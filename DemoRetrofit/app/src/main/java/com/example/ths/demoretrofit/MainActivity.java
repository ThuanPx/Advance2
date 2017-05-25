package com.example.ths.demoretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private List<MultiProducts.Products> mProductsList;
    private List<ItemProduct> itemProductList = new ArrayList<>();
    private Button bt, bt2;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog.show();
                getListProducts();
//                getItem();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog.show();
                //postUser();
                postUser2();
            }
        });
    }
    private void postUser2(){
        User user = new User("Thuan","OpenEdu");
        ProductService service = ServiceGenerator.createService(ProductService.class);
        service.postUser2(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Error", "Error");
                mProgressDialog.dismiss();
            }
        });
    }
    private void postUser() {
        ProductService service = ServiceGenerator.createService(ProductService.class);
        service.postUser("Thuan", "OpenEdu").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Error", "Error");
                mProgressDialog.dismiss();
            }

        });
    }

    private void getItem() {
        ProductService service = ServiceGenerator.createService(ProductService.class);
        service.getItem().enqueue(new Callback<ItemP>() {
            @Override
            public void onResponse(Call<ItemP> call, Response<ItemP> response) {
                ItemP itemP2 = response.body();

                List<ItemP.ItemA>list =itemP2.getData();
                for(int i=0;i<list.size();i++){
                    Toast.makeText(MainActivity.this, "ID -"+list.get(i).getId(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ItemP> call, Throwable t) {
                Log.d("Error", "Error");
            }
        });
    }

    private void getListProducts() {
        ProductService service = ServiceGenerator.createService(ProductService.class);
        service.listProduct("2").enqueue(new Callback<MultiProducts>() {
            @Override
            public void onResponse(Call<MultiProducts> call, Response<MultiProducts> response) {
                MultiProducts multiProducts = response.body();

                mProductsList = multiProducts.getData();
                for (int i = 0; i < mProductsList.size(); i++) {
                    ItemProduct itemProduct = new ItemProduct();
                    itemProduct.setFirst_name(mProductsList.get(i).getFirst_name());
                    itemProduct.setAvatar(mProductsList.get(i).getAvatar());
                    itemProductList.add(0, itemProduct);
                    customAdapter.notifyItemInserted(0);
                    recyclerView.scrollToPosition(0);
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<MultiProducts> call, Throwable t) {
                Log.d("Error", "Error");
                mProgressDialog.dismiss();
            }
        });
    }

    private void initView() {
        customAdapter = new CustomAdapter(itemProductList, getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
        bt = (Button) findViewById(R.id.bt);
        bt2 = (Button) findViewById(R.id.bt2);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading ...");
    }
}
