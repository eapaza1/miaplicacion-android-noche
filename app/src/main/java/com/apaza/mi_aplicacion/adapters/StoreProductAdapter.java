package com.apaza.mi_aplicacion.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apaza.mi_aplicacion.R;
import com.apaza.mi_aplicacion.databinding.ProductItemBinding;
import com.apaza.mi_aplicacion.entidades.EProducto;

import java.util.List;

public class StoreProductAdapter extends RecyclerView.Adapter<StoreProductAdapter.StoreProductHolder> {

    private List<EProducto> items;

    public StoreProductAdapter(List<EProducto> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public StoreProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,null);
        return new StoreProductHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreProductHolder holder, int position) {
        holder.render(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class StoreProductHolder extends RecyclerView.ViewHolder{

        ProductItemBinding binding;

        public StoreProductHolder(@NonNull View itemView) {
            super(itemView);
            binding=ProductItemBinding.bind(itemView);
        }

        public void render(EProducto data){
            binding.productTitle.setText(data.getTitle());
            binding.productCategory.setText(data.getCategory());
            binding.productPrice.setText("Price: "+data.getPrice());
            binding.producRating.setRating((float) data.getRating().getRate());
            binding.productRatingValue.setText("("+data.getRating().getRate()+")");
            binding.productRatingCount.setText("p."+data.getRating().getCount());
        }
    }
}
