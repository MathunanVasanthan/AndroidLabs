package com.cst2335.vasa0007;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        Switch swt = findViewById(R.id.switch1);
        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if(cb.isChecked()){
                    Snackbar snackbar1= Snackbar.make(swt,getResources().getString(R.string.on),Snackbar.LENGTH_LONG).setAction(getResources().getString(R.string.undo),click ->
                            cb.setChecked(!b));
                    snackbar1.show();
                }else {
                    Snackbar snackbar2= Snackbar.make(swt,getResources().getString(R.string.off),Snackbar.LENGTH_LONG).setAction(getResources().getString(R.string.undo),click ->
                            cb.setChecked(!b));
                    snackbar2.show();
                }
            }
        });




    }


    public void clickListener(View view) {
        Toast.makeText(this, getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
    }
}