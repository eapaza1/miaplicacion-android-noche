package com.apaza.mi_aplicacion;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.apaza.mi_aplicacion.adapters.StoreProductAdapter;
import com.apaza.mi_aplicacion.databinding.ActivityStoreBinding;
import com.apaza.mi_aplicacion.entidades.EProducto;
import com.apaza.mi_aplicacion.services.ProductService;
import com.apaza.mi_aplicacion.services.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreActivity extends AppCompatActivity {


    ActivityStoreBinding binding;

    StoreProductAdapter adapter;

    List<EProducto> listaProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //instanciar binding
        binding=ActivityStoreBinding.inflate(getLayoutInflater());

        //mostrar vista
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.rvProductos.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        getProducts();
    }

    private void getProducts() {
        ProductService service= RetrofitClient.getRetrofitInstace().create(ProductService.class);

        Call<List<EProducto>> call=service.getProductos();

        call.enqueue(new Callback<List<EProducto>>() {
            @Override
            public void onResponse(Call<List<EProducto>> call, Response<List<EProducto>> response) {
                if (response.isSuccessful()&&response.body()!=null){
                    listaProducto=response.body();
                    adapter=new StoreProductAdapter(listaProducto);
                    binding.rvProductos.setAdapter(adapter);
                }else {
                    makeToas("error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<List<EProducto>> call, Throwable t) {
                makeToas("error: "+t.getMessage());
            }
        });

    }

    private void makeToas(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}