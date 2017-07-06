package br.com.solimar.desafiomobfiq.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.solimar.desafiomobfiq.R;
import br.com.solimar.desafiomobfiq.models.Image;
import br.com.solimar.desafiomobfiq.models.Product;
import br.com.solimar.desafiomobfiq.models.Sku;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Solimar on 05/07/2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.HolderProductList> {


    private List<Product> products;

    public ProductListAdapter(List<Product> products) {
        super();
        this.products = products;
    }

    @Override
    public HolderProductList onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new HolderProductList(itemView);
    }

    @Override
    public void onBindViewHolder(HolderProductList holder, int position) {
        Product product = products.get(position);
        holder.tvName.setText(product.getName());
        Sku sku = product.getSkus().get(0);
        holder.tvPrecoTabela.setText(sku.getSellers().get(0).getListPrice().toString());
        holder.tvPrecoFinal.setText(sku.getSellers().get(0).getPrice().toString());
        holder.tvParcelamento.setText(sku.getSellers().get(0).getBestInstallment().getCount().toString());
        holder.tvDesconto.setText(sku.getSellers().get(0).calcDesconto().toString());

        String imgUrl = getImage(holder.imgProduto.getContext(), sku);
        Picasso.with(holder.imgProduto.getContext()).load(imgUrl).into(holder.imgProduto);
    }

    private String getImage(Context context, Sku sku) {
        for (Image img : sku.getImages()) {
            if (img.getLabel() !=null && img.getLabel().equals(context.getString(R.string.orientaion))){
                return img.getImageUrl();
            }
        };
        return sku.getImages().get(0).getImageUrl();
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void add(List<Product> sts) {
        products.addAll(sts);
        notifyDataSetChanged();
    }

    public static class HolderProductList extends RecyclerView.ViewHolder {

        @BindView(R.id.tvdesconto)
        TextView tvDesconto;
        @BindView(R.id.tvname)
        TextView tvName;
        @BindView(R.id.tvprecotabela)
        TextView tvPrecoTabela;
        @BindView(R.id.tvprecofinal)
        TextView tvPrecoFinal;
        @BindView(R.id.tvparcelamento)
        TextView tvParcelamento;
        @BindView(R.id.imgproduto)
        ImageView imgProduto;

        private HolderProductList(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }



    }
}
