package com.juborajsarker.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String uid = "";

    private Firebase rootRef;
    CheckBox computer, electrical, civil;
    EditText userName, fullName, age, varsity;

    DatabaseReference databaseReference;
    DatabaseReference databaseReferenceChild;

    ListView computerLV, electricalLV, civilLV;
    private ArrayList<String>muserNames = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        computerLV = (ListView) findViewById(R.id.computerLV) ;
        electricalLV = (ListView) findViewById(R.id.electricalLV) ;
        civilLV = (ListView) findViewById(R.id.civilLV) ;

        computer = (CheckBox) findViewById(R.id.computerCB);
        electrical = (CheckBox) findViewById(R.id.electrical);
        civil = (CheckBox) findViewById(R.id.civil);

        userName = (EditText) findViewById(R.id.userName);
        fullName = (EditText) findViewById(R.id.fullName);
        age = (EditText) findViewById(R.id.age);
        varsity = (EditText) findViewById(R.id.varsity);

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, muserNames);

        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");



        Firebase.setAndroidContext(this);






    }

    public void submit(View view) {

        computerLV.setAdapter(arrayAdapter);

        if (computer.isChecked()){

            rootRef = new Firebase("https://fir-test-ca2c3.firebaseio.com/Computer/" + userName.getText().toString());
            Firebase childsRefName = rootRef.child("Full Name");
            Firebase childsRefAge = rootRef.child("Age");
            Firebase childsRefVarsity = rootRef.child("Varsity");

            childsRefName.setValue(fullName.getText().toString());
            childsRefAge.setValue(age.getText().toString());
            childsRefVarsity.setValue(varsity.getText().toString());


        }

        if (electrical.isChecked()){

            rootRef = new Firebase("https://fir-test-ca2c3.firebaseio.com/Electrical/" + userName.getText().toString());
            Firebase childsRefName = rootRef.child("Full Name");
            Firebase childsRefAge = rootRef.child("Age");
            Firebase childsRefVarsity = rootRef.child("Varsity");

            childsRefName.setValue(fullName.getText().toString());
            childsRefAge.setValue(age.getText().toString());
            childsRefVarsity.setValue(varsity.getText().toString());
        }

        if (civil.isChecked()){


//            rootRef = new Firebase("https://fir-test-ca2c3.firebaseio.com/Civil/" + userName.getText().toString());
//            Firebase childsRefName = rootRef.child("Full Name");
//            Firebase childsRefAge = rootRef.child("Age");
//            Firebase childsRefVarsity = rootRef.child("Varsity");
//
//            childsRefName.setValue(fullName.getText().toString());
//            childsRefAge.setValue(age.getText().toString());
//            childsRefVarsity.setValue(varsity.getText().toString());

            databaseReference = FirebaseDatabase.getInstance().getReference("Civil");
            databaseReferenceChild = FirebaseDatabase.getInstance().getReference("Civil/" + userName.getText().toString());


            String id = uid;
            String userID = uid;
            Civil civil = new Civil(userName.getText().toString(), fullName.getText().toString(), userID,
                    age.getText().toString(), varsity.getText().toString());

            databaseReference.child(id).setValue(civil);

            startActivity(new Intent(this, ShowList.class));

        }


        rootRef = new Firebase("https://fir-test-ca2c3.firebaseio.com/Computer/juboraj/");

        rootRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                muserNames.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });






    }
}
