package com.goskydive.logbook;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.QuerySnapshot;
import com.goskydive.R;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    private List<DocumentSnapshot> rcJumpList = new ArrayList<>();

    public RecyclerViewAdapter(String userId) {
        this.userId = userId;
        this.fStore = FirebaseFirestore.getInstance();
        loadJumps();
    }

    private void loadJumps() {

        fAuth = FirebaseAuth.getInstance();
        userId = fAuth.getCurrentUser().getUid();
        DocumentReference documentRef = fStore.collection("userJumpsLogBook").document(userId);
        CollectionReference collectionRef = documentRef.collection("jumps");

        collectionRef
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null) {
                            rcJumpList = querySnapshot.getDocuments();
                            notifyDataSetChanged();
                        } else {
                            Log.e("RecyclerViewAdapter", "QuerySnapshot is null");
                        }
                    } else {
                        Log.e("RecyclerViewAdapter", "Error getting documents");
                    }
                });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.loogbook_recyclerview_row, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DocumentSnapshot recyclerViewLogBookModel = rcJumpList.get(position);
        if (recyclerViewLogBookModel != null) {
            double jumpNo = recyclerViewLogBookModel.getDouble("jumpNumber");
            String jumpDate = recyclerViewLogBookModel.getString("date");
            double jumpHeight = recyclerViewLogBookModel.getDouble("jumpHeight");
            String jumpStyle = recyclerViewLogBookModel.getString("jumpType");

            holder.jumpNo.setText(Double.toString(jumpNo));
            holder.jumpDate.setText(jumpDate);
            holder.jumpHeight.setText(Double.toString(jumpHeight));
            holder.jumpStyle.setText(jumpStyle);
        }
    }

    @Override
    public int getItemCount() {
        return rcJumpList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jumpNo;
        TextView jumpDate;
        TextView jumpHeight;
        TextView jumpStyle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jumpNo = itemView.findViewById(R.id.rc_jump_number);
            jumpDate = itemView.findViewById(R.id.rc_date_jump);
            jumpHeight = itemView.findViewById(R.id.rc_jump_height);
            jumpStyle = itemView.findViewById(R.id.rc_jump_style);
        }

    }
}
