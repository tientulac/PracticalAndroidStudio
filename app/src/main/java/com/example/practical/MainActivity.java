package com.example.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practical.dto.ResponseFunction;
import com.example.practical.dto.ResponseLogin;
import com.example.practical.entity.Account;
import com.example.practical.entity.Bookmark;
import com.example.practical.entity.Contact;
import com.example.practical.entity.Function;
import com.example.practical.entity.Product;
import com.example.practical.room.AppDatabase;
import com.example.practical.service.AccountService;
import com.example.practical.util.ListViewAdapter;
import com.example.practical.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listViewFunction;
    private List<Product> listFunctions = new ArrayList<>();
    AccountService accountService;
    AppDatabase db;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        initData();
        listViewFunction = (ListView) findViewById(R.id.listViewFunction);
        ListViewAdapter adapter = new ListViewAdapter(listFunctions, this);
        listViewFunction.setAdapter((ListAdapter) adapter);

        listViewFunction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product function = listFunctions.get(i);
                Toast.makeText(MainActivity.this, function.name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        CharSequence charSequence = "Success";
        Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
        toast.show();
        List<Product> list = db.productDao().findAll();
        for (Product product : list) {
            listFunctions.add(product);
            Log.d("TAG", "id: "+ product.id + "name: "+product.name);
        }
//        accountService = RetrofitGenerator.createService(AccountService.class);
//        try {
//            System.out.println("--------------------------------------------------------");
//            Response<ResponseFunction> res =  accountService.getListFunction().execute();
//            if(res.isSuccessful()){
//                ResponseFunction responseFunction = (ResponseFunction) res.body();
//                Log.d("responseFunction", responseFunction.toString());
//                CharSequence charSequence = "Success";
//                Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
//                toast.show();
//                List<Function> list = responseFunction.listFunctions;
//
//                for (Function f : list) {
//                    listFunctions.add(f);
//                }
//            }
//            else {
//                CharSequence charSequence = "Login failed. Please input correct account !!";
//                Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
//                toast.show();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}