package com.example.admin1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SMS extends AppCompatActivity {
    EditText editTextPhone;
    EditText editTextMessage;
    Button btnSent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        editTextPhone=findViewById(R.id.editTextPhone);
        editTextMessage=findViewById(R.id.editTextMessage);
        btnSent=findViewById(R.id.btnSent);
        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(SMS.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                    sendSMS();
                }else{
                    ActivityCompat.requestPermissions(SMS.this,new String[]{Manifest.permission.SEND_SMS},100);
                }

            }
        });
}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            sendSMS();

        }else{
            Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
        }

    }

    private void sendSMS(){
    String phone=editTextPhone.getText().toString();
    String message=editTextMessage.getText().toString();

    if(!phone.isEmpty() && !message.isEmpty()) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, message, null, null);
        Toast.makeText(this, "SMS Sent successfully", Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(this,"Please enter phone or message",Toast.LENGTH_SHORT).show();
    }
    }
}
