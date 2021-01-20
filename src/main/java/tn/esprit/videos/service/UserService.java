package tn.esprit.videos.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import tn.esprit.videos.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    public static final String COL_NAME="users";
    public String saveUserDetails(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(Integer.toString(user.getId())).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public List<User> getUsersDetails() throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = db.collection("users").get();
// future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<User> users = new ArrayList<User>();
        for (QueryDocumentSnapshot document : documents) {
            users.add(document.toObject(User.class));
        }
        return users;
}
    public User getUserDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user = null;
        if(document.exists()) {
            user = document.toObject(User.class);
            return user;
        }else {
            return null;
        }
    }
    public String updateUserDetails(User person) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(Integer.toString(person.getId())).set(person);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteUser(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(id).delete();
        return "Document with Patient ID "+id+" has been deleted";
    }}
