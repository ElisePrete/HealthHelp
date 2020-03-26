package com.example.healthhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthhelp.Adapters.MyAdapter;
import com.example.healthhelp.Model.Information;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomePage extends AppCompatActivity {
    RegistrationDatabase db;
    Button b1,b2,b3,b4,b5;
    ListView l1;
    //ListView listView;
    ArrayList<Information> arrayList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //listView=[listView]findViewById(R.id.listView2); // Tried looking up how to mess around with this

        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        TextView textViewDate= findViewById(R.id.textViewDate);
        textViewDate.setText(currentDate);

        db = new RegistrationDatabase(this);

        b1= findViewById(R.id.btnLogout);
        b2= findViewById(R.id.btnProfilePage);
        b3= findViewById(R.id.btnEditGoals);
        b4= findViewById(R.id.btnActivityTrackingPage);
        b5= findViewById(R.id.btnGoalTracker);

        /*ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Weight");
        arrayList.add("Sleep");
        arrayList.add("Steps");
        arrayList.add("Calories");
        arrayList.add("Hydration");   Tried looking up how to mess around with this  */

        l1 = findViewById(R.id.listView);

        loadDataInListView();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, Login.class) ;
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, ProfilePage.class) ;
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, NewUserGoals.class) ;
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, ActivityTracker.class) ;
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, GoalTracker.class) ;
                startActivity(i);
            }
        });
    }

    private void loadDataInListView() {
        arrayList = db.getAllData();
        myAdapter = new MyAdapter(this, arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}