package com.goskydive.logbook;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.goskydive.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    FirebaseFirestore fStore;
    String userId;

    private List<DocumentSnapshot> rcJumpList = new ArrayList<>();

    public RecyclerViewAdapter(String userId) {
        this.userId = userId;
        this.fStore = FirebaseFirestore.getInstance();
        loadJumps();
    }

    private void loadJumps() {
        if (userId != null) {
            DocumentReference documentRef = fStore.collection("userJumpsLogBook").document(userId);
            CollectionReference collectionRef = documentRef.collection("jumps");

            collectionRef
                    .orderBy("nextJump.jumpNumber", Query.Direction.DESCENDING)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            QuerySnapshot querySnapshot = task.getResult();
                            if (querySnapshot != null) {
                                rcJumpList = querySnapshot.getDocuments();
                                Log.d("RecyclerViewAdapter", "Data loaded: " + rcJumpList.size());
                                notifyDataSetChanged();
                            } else {
                                Log.e("RecyclerViewAdapter", "QuerySnapshot is null");
                            }
                        } else {
                            Log.e("RecyclerViewAdapter", "Error getting documents");
                        }
                    });
        } else {
            Log.e("RecyclerViewAdapter", "userId is null");
        }
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
        Log.d("RecyclerViewAdapter", "onBindViewHolder called for position: " + position);

        if (rcJumpList != null && position < rcJumpList.size()) {
            DocumentSnapshot doc = rcJumpList.get(position);
            RecyclerViewLogBookModel model = doc.toObject(RecyclerViewLogBookModel.class);
            if (model != null) {
                Map<String, Object> nextJumpMap = model.getNextJump();
                if (nextJumpMap != null && !nextJumpMap.isEmpty()) {
                    Long jumpNo = (Long) nextJumpMap.get("jumpNumber");
                    String jumpDate = (String) nextJumpMap.get("date");
                    Long jumpHeight = (Long) nextJumpMap.get("jumpHeight");
                    String jumpStyle = (String) nextJumpMap.get("jumpType");

                    if (jumpNo != null) {
                        holder.jumpNo.setText(Long.toString(jumpNo));
                    }
                    holder.jumpDate.setText(jumpDate);
                    if (jumpHeight != null) {
                        holder.jumpHeight.setText(Long.toString(jumpHeight));
                    }
                    holder.jumpStyle.setText(jumpStyle);
                    Log.d("RecyclerViewAdapter", "Model data: " + model.toString());
                } else {
                    Log.d("RecyclerViewAdapter", "nextJump is null or empty");
                }

            }
        }
    }

@Override
public int getItemCount() {
    return rcJumpList != null ? rcJumpList.size() : 0;
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
