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
    private static final String MES = "ProfileActivity";
//    private ImageView imgView;
//    private EditText emailEditText;
    private ActivityResultLauncher<Intent> myPictureTakerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button takePictureButton = findViewById(R.id.button3);

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
                            Log.i(MES, "User refused to capture a picture.");
                        }
                    }
                }
        );
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            myPictureTakerLauncher.launch(takePictureIntent);
        }


        setContentView(R.layout.activity_profile);
        EditText emailEditText = findViewById(R.id.emailp);

        Intent fromMain = getIntent();
        String email = fromMain.getStringExtra(String.valueOf(R.id.email));
        emailEditText.setText(email);
    }

        @Override
        protected void onStart() {
            super.onStart();
            Log.e(MES, "onStart method");
            // rest of the code
        }

        @Override
        protected void onResume() {
            super.onResume();
            Log.e(MES, "onResume method");
            // rest of the code
        }

        @Override
        protected void onPause() {
            super.onPause();
            Log.e(MES, "onPause method");
            // rest of the code
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.e(MES, "onStop method");
            // rest of the code
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.e(MES, "onDestroy method");
            // rest of the code
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Log.e(MES, "onActivityResult method");
            // rest of the code
        }

}
