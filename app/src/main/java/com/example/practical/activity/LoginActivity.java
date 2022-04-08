package com.example.practical.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practical.MainActivity;
import com.example.practical.R;
import com.example.practical.dto.ResponseLogin;
import com.example.practical.entity.Account;
import com.example.practical.service.AccountService;
import com.example.practical.util.RetrofitGenerator;
import java.io.IOException;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etUserName, etPassword;
    AccountService accountService;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }
        ctx = this;
        initData();
        initListener();
    }

    public void initData(){
        etUserName = (EditText) findViewById(R.id.userNameLogin);
        etPassword = (EditText) findViewById(R.id.passwordLogin);
        accountService = RetrofitGenerator.createService(AccountService.class);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    private void initListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                Account account = new Account();
                account.setUserName(userName);
                account.setPassword(password);
                try {
                    System.out.println("--------------------------------------------------------");
                    Response<ResponseLogin> tokenResponse =  accountService.login(account).execute();
                    if(tokenResponse.isSuccessful()){
                        ResponseLogin loginToken = tokenResponse.body();
                        Log.d("Token", loginToken.toString());
                        CharSequence charSequence = loginToken.getMessage();
                        Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                        toast.show();
                        ctx.startActivity(new Intent(ctx, MainActivity.class));
                    }
                    else {
                        CharSequence charSequence = "Login failed. Please input correct account !!";
                        Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                        toast.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}