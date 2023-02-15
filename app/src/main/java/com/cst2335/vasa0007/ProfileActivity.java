package com.cst2335.vasa0007;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    public static final String ANDROID_LAB4 = "user_data";
    public static final String USER_NAME = "user_name";
    public static final String USER_ADDRESS="user_address";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences sharedPreferences = getSharedPreferences(ANDROID_LAB4,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText name_edit = findViewById(R.id.name);
        EditText address_edit = findViewById(R.id.editText2);
        Button savedata = findViewById(R.id.button3);
        Button cleardata = findViewById(R.id.button2);

        Intent fromMain = getIntent();
        String email = fromMain.getStringExtra("EMAIL");
        TextView emailText = findViewById(R.id.textViewemail);
        emailText.setText(email);


        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_edit.getText().toString();
                String address = address_edit.getText().toString();

                editor.putString(USER_NAME,name);
                editor.putString(USER_ADDRESS,address);
                editor.apply();
            }
        });

        String name = sharedPreferences.getString("user_name","");
        String address = sharedPreferences.getString("user_address","");

          name_edit.setText(name);
          address_edit.setText(address);

        cleardata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_edit.getText().toString();
                String address = address_edit.getText().toString();

                editor.remove(USER_NAME);
                editor.remove(USER_ADDRESS);
                editor.commit();

                name=" ";
                address=" ";

                name_edit.setText("");
                address_edit.setText("");
            }
        });



     }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }






}
