package com.cst2335.vasa0007;

import static android.text.InputType.TYPE_TEXT_FLAG_CAP_WORDS;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Content View for LinearLayout
        setContentView(R.layout.activity_main_linear);
        //Content view for constraintLayout
        //setContentView(R.layout.activity_main_constraint);

        Switch swt = findViewById(R.id.switch1);
        Button btn = findViewById(R.id.button);




        //Add a check listener for switch
        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (cb.isChecked()) {
                    Snackbar snackbar1 = Snackbar.make(swt, getResources().getString(R.string.on), Snackbar.LENGTH_LONG).setAction(getResources().getString(R.string.undo), click ->
                            cb.setChecked(!b));
                    snackbar1.show();
                } else {
                    Snackbar snackbar2 = Snackbar.make(swt, getResources().getString(R.string.off), Snackbar.LENGTH_LONG).setAction(getResources().getString(R.string.undo), click ->
                            cb.setChecked(!b));
                    snackbar2.show();
                }
            }
        });

        //Add OnClickListener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
            }
        });

        // Code for make first letter of the name capital
        EditText edtxt = findViewById(R.id.edit_text);
        edtxt.setInputType(TYPE_TEXT_FLAG_CAP_WORDS);

//        edtxt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
//                String text = charSequence.toString();
//                if (start == 0 && !text.isEmpty()) {
//                    char first = text.charAt(0);
//                    text = Character.toUpperCase(first) + text.substring(1);
//                    edtxt.setText(text);
//                    edtxt.setSelection(1);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
    }

}
