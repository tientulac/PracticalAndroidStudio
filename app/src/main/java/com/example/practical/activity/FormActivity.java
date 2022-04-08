package com.example.practical.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practical.MainActivity;
import com.example.practical.R;
import com.example.practical.dto.ResponseLogin;
import com.example.practical.entity.Bookmark;
import com.example.practical.entity.Product;
import com.example.practical.room.AppDatabase;
import com.example.practical.service.AccountService;
import com.example.practical.util.RetrofitGenerator;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class FormActivity extends AppCompatActivity {

    Button btnSubmitForm;
    EditText editText1, editText2, editText3, editText4;
    Context ctx;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        db = AppDatabase.getAppDatabase(this);
        ctx = this;
        initData();
        initListener();
    }

    public void initData(){
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
//        editText3 = (EditText) findViewById(R.id.editText3);
//        editText4 = (EditText) findViewById(R.id.editText4);
        btnSubmitForm = (Button) findViewById(R.id.buttonSubmitForm);
    }

    private void initListener() {
        btnSubmitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et1 = editText1.getText().toString();
                String et2 = editText2.getText().toString();
//                String et3 = editText3.getText().toString();
//                String et4 = editText4.getText().toString();
                try {
                    System.out.println("--------------------------------------------------------");
                    Product product = new Product();
                    product.name = et1;
                    product.quantity = Integer.parseInt(et2);
                    db.productDao().insertProduct(product);
                    CharSequence charSequence = "Successfully !";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                    ctx.startActivity(new Intent(ctx, MainActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}