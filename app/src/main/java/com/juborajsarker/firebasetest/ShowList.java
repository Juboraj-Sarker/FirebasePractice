package com.juborajsarker.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowList extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    List<Civil> civilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        listView = (ListView) findViewById(R.id.lv);
        databaseReference = FirebaseDatabase.getInstance().getReference("Civil");
        civilList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                civilList.clear();
                for (DataSnapshot civilSnapshot: dataSnapshot.getChildren() ){


                    Civil civil = civilSnapshot.getValue(Civil.class);
                    civilList.add(civil);

                }

                CivilList adapter = new CivilList(ShowList.this,civilList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
