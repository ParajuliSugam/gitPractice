package com.surhid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.surhid.myapplication.utils.ShowToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnCancel, btnOk;
    private RadioButton radioMale, radioFemale;
    private RadioGroup radioSex;
    private EditText edtFirstName, edtPhoneNumber, edtAddress, edtEmail;

    private String firstName, phoneNumber, address, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");

        initView();

    }

    }

    private void initView() {
        btnCancel = findViewById(R.id.btn_cancel);
        btnOk = findViewById(R.id.btn_ok);
        radioSex = (RadioGroup) findViewById(R.id.radioSex);
        radioMale=(RadioButton) findViewById(R.id.radioMale);
        radioFemale=(RadioButton) findViewById(R.id.radioFemale);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        edtFirstName = findViewById(R.id.edt_first_name);
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtAddress = findViewById(R.id.edt_address);
        edtEmail = findViewById(R.id.edt_email);

//        btnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                firstName = edtFirstName.getText().toString().trim();
//                phoneNumber = edtPhoneNumber.getText().toString().trim();
//                if (TextUtils.isEmpty(firstName)) {
//                    ShowToast.showToast(MainActivity.this, "First name cannot be empty", true);
//                } else if (TextUtils.isEmpty(phoneNumber)) {
//                    ShowToast.showToast(MainActivity.this, "Phone number cannot be empty", true);
//                } else {
//                    ShowToast.showToast(MainActivity.this, "Form received", true);
//                    emptyForm();
//                }
//
//            }
//        });
//
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                emptyForm();
//            }
//        });
    }

    private void emptyForm() {
        edtFirstName.setText("");
        edtPhoneNumber.setText("");
        edtAddress.setText("");
        edtEmail.setText("");
    }

    private void getFormValue() {
        firstName = edtFirstName.getText().toString().trim();
        phoneNumber = edtPhoneNumber.getText().toString().trim();
        address = edtAddress.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        int phone = Integer.parseInt(phoneNumber);
        


        if (TextUtils.isEmpty(firstName)) {
            ShowToast.showToast(MainActivity.this, "First name cannot be empty", true);
        } else if (TextUtils.isEmpty(address)) {
            ShowToast.showToast(MainActivity.this, "Address cannot be empty", true);
        } else if (TextUtils.isEmpty(phone)) {
            ShowToast.showToast(MainActivity.this, "Phone number cannot be empty", true);
        }  else if (TextUtils.isEmpty(email)) {
                ShowToast.showToast(MainActivity.this, "E-Mail cannot be empty", true);
        } else {
            ShowToast.showToast(MainActivity.this, "Form received", true);
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.btn_ok:
                Intent intent=new Intent(MainActivity.this,activityb.class);
                intent.putExtra("formvalue",[firstName,phoneNumber,address,email)
                startActivity(intent);
                break;

            case R.id.btn_cancel:
                emptyForm();
                break;
        }

    }
}
