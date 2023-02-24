package com.cst2335.vasa0007;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This is a login page
 * @author Mathunan Vasanthan
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity {
    /**
     * This holds the text at the center of the screen
     */
    TextView tv = null;
    /**
     * This holds the type-in box at the center of the screen
     */
    EditText et = null;
    /**
     * This holds the login button on the bottom
     */
    Button btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Program starts here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab_05);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);


        btn.setOnClickListener( clk ->{
            String password = et.getText().toString();

            checkPasswordComplexity(password);
            if (checkPasswordComplexity(password)) {
                tv.setText(R.string.tv1);
            } else {
                tv.setText(R.string.tv2);
            }
        });



    }

    /**
     * This function is to verify if the password is too simple or not
     * @param pw The String object that we are checking on
     * @return Returns true if the password is complex enough, and false if it is not complex enough.
     */
    boolean checkPasswordComplexity (String pw) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;
        boolean lengthValid = false;

        // Check length requirement
        if (pw.length() >= 4 && pw.length() <= 20) {
            lengthValid = true;
        }

        //start the loop
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        // Show toast messages for any missing requirement and return false
        if (!lengthValid) {
            Toast.makeText(this, R.string.text1, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundUpperCase) {
            Toast.makeText(this,R.string.text2, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, R.string.text3, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, R.string.text4, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, R.string.text5, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * This function is to verify if the character is a special character (#$%^&*!@?).
     * @param c one character in the string that we are checking
     * @return Return true if there is one special character (#$%^&*!@?), and false if there is no special character
     */
    private boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }



}

