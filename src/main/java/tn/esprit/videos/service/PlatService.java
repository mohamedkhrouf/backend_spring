package tn.esprit.videos.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import tn.esprit.videos.entity.Plat;
import tn.esprit.videos.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
@Service
public class PlatService {
    public static final String COL_NAME="plats";
    public String savePlatDetails(Plat plat) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(Integer.toString(plat.getId())).set(plat);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public List<Plat> getPlatsDetails() throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = db.collection("plats").get();
// future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Plat> plats = new ArrayList<Plat>();
        for (QueryDocumentSnapshot document : documents) {
            plats.add(document.toObject(Plat.class));
        }
        return plats;
    }
    public Plat getPlatDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Plat plat = null;
        if(document.exists()) {
            plat = document.toObject(Plat.class);
            return plat;
        }else {
            return null;
        }
    }
    public String updatePlatDetails(Plat plat) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(Integer.toString(plat.getId())).set(plat);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deletePlat(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(id).delete();
        return "Document with Patient ID "+id+" has been deleted";
    }
}
