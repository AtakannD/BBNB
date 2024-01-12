package com.atakandalkiran.bbnb.db;

import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.atakandalkiran.bbnb.R;

public class AddingNewUser extends AppCompatActivity {

    EditText name, surname, phone, email, citizenshipNo,password, confirmPassword;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurname);
        email = findViewById(R.id.editTextEmail);
        citizenshipNo = findViewById(R.id.editTextCitizenShipNo);
        phone = findViewById(R.id.editTextPhone);
        password = findViewById(R.id.editTextPassword);
        confirmPassword = findViewById(R.id.editTextConfirmPassword);
        save = findViewById(R.id.buttonRegister);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
}
    private void saveData() {

        String name_txt = name.getText().toString().trim();
        String surName_txt = surname.getText().toString().trim();
        String phone_txt = phone.getText().toString().trim();
        String email_txt = email.getText().toString().trim();
        String citizenshipNo_txt = citizenshipNo.getText().toString().trim();
        String password_txt = password.getText().toString().trim();
        String confirmPassword_txt = confirmPassword.getText().toString().trim();

        User model = new User();
        model.setFirstName(name_txt);
        model.setLastName(surName_txt);
        model.setPhoneNumber(phone_txt);
        model.setEmail(email_txt);
        model.setCitizenshipNo(citizenshipNo_txt);
        model.setPassword(password_txt);
        model.setConfirmPassword(confirmPassword_txt);
        AppDatabase.getDbInstance(getApplicationContext()).userdao().InsertUser(model);

        Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();
    }}
