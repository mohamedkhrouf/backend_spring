package tn.esprit.videos.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import tn.esprit.videos.entity.Commande;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CommandeService {
    public static final String COL_NAME="commandes";
    public String saveCommandeDetails(Commande commande) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(Integer.toString(commande.getId())).set(commande);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public List<Commande> getCommandesDetails() throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = db.collection("commandes").get();
// future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Commande> commandes = new ArrayList<Commande>();
        for (QueryDocumentSnapshot document : documents) {
            commandes.add(document.toObject(Commande.class));
        }
        return commandes;
    }
    public Commande getCommandeDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Commande commande = null;
        if(document.exists()) {
            commande = document.toObject(Commande.class);
            return commande;
        }else {
            return null;
        }
    }
    public String updateCommandeDetails(Commande commande) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(Integer.toString(commande.getId())).set(commande);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteCommande(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(id).delete();
        return "Document with Patient ID "+id+" has been deleted";
    }
}
