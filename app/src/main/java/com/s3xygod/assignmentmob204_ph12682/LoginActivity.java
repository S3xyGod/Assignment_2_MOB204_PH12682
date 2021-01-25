package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.MemberDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterMem;
import com.s3xygod.assignmentmob204_ph12682.model.Members;

public class LoginActivity extends AppCompatActivity {
    private TextView user, password;
    private String id, pass, acc="", mk="";
    private CheckBox remember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.txt_id);
        password = findViewById(R.id.txt_pass);
        remember = findViewById(R.id.cb_remember);
        SharedPreferences sp =getSharedPreferences("idSave", MODE_PRIVATE);
        Boolean stt = sp.getBoolean("Save", false);
        if(stt == true){
            acc = sp.getString("accSave", "");
            mk = sp.getString("mkSave", "");
            user.setText(acc);
            password.setText(mk);
            remember.setChecked(true);
        }else{
            user.setText("");
            password.setText("");
            remember.setChecked(false);
        }
    }

    public void LogIn(View view) {
        id = user.getText().toString();
        pass = password.getText().toString();
        if(id.equalsIgnoreCase("admin")  && pass.equals("admin") ||
                id.equalsIgnoreCase("manager") && pass.equals("manager") ||
                    id.equalsIgnoreCase("user") && pass.equals("user")){
            if(remember.isChecked()){
                SharedPreferences sp = getSharedPreferences("idSave", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("accSave", id);
                editor.putString("mkSave", pass);
                editor.putBoolean("Save", true);
                editor.commit();
            }else {
                SharedPreferences sp = getSharedPreferences("idSave", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("Save", false);
                editor.commit();
            }
            Toast.makeText(this, "Chào mừng "+id+" !", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("sayHi", id);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Sai tên tài khoản hoặc mật khẩu.\n " +
                    "\t\t\t\tVui lòng kiểm tra lại !", Toast.LENGTH_LONG).show();
        }

    }

    public void ForgotPass(View view) {
        Intent intent = new Intent(this, ForgotActivity.class);
        startActivity(intent);
    }
}