package com.cst2335.vasa0007;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "PROFILE_ACTIVITY";
    private ImageView imgView;
    private ActivityResultLauncher<Intent> myPictureTakerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.e(TAG, "In function: onCreate");
        imgView = findViewById(R.id.img_view);
        Button takePictureButton = findViewById(R.id.button3);
        EditText name = findViewById(R.id.name);

            takePictureButton.setOnClickListener(v -> dispatchTakePictureIntent());


        myPictureTakerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        ImageView imgView = findViewById(R.id.img_view);
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            assert data != null;
                            Bitmap imgBitmap = (Bitmap) data.getExtras().get("data");
                            imgView.setImageBitmap(imgBitmap);
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            Log.i(TAG, "User refused to capture a picture.");
                        }
                    }
                }
        );

        Intent fromMain = getIntent();
        String email = fromMain.getStringExtra("EMAIL");
        EditText emailEditText = findViewById(R.id.editText2);
        emailEditText.setText(email);

        name.setText("Mathunan");


     }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "In function: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "In function: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "In function: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "In function: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "In function: onDestroy");
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            myPictureTakerLauncher.launch(takePictureIntent);
        }

        }



}
