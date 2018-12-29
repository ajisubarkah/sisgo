package android.sisgo.adapter;

import android.sisgo.R;
import android.sisgo.model.GoodItem;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.MyViewHolder> {
    private ArrayList<GoodItem> listGoods;

    public InventoryAdapter(ArrayList<GoodItem> myDataset) {
        this.listGoods = myDataset;
    }

    private ArrayList<GoodItem> getListGoods() {
        return listGoods;
    }

    @Override
    public int getItemCount() {
        return listGoods.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_goods, parent, false);
        return new MyViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.barcode.setText(getListGoods().get(i).getBarcode());
        myViewHolder.nameGoods.setText(getListGoods().get(i).getName());
        myViewHolder.priceList.setText(getListGoods().get(i).getPriceSelling());
        myViewHolder.stock.setText(getListGoods().get(i).getStock());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView tvImage;
        TextView barcode;
        TextView nameGoods;
        TextView priceList;
        TextView stock;

        MyViewHolder(View view) {
            super(view);
            tvImage = itemView.findViewById(R.id.tv_image);
            barcode = itemView.findViewById(R.id.barcode);
            nameGoods = itemView.findViewById(R.id.name_goods);
            priceList = itemView.findViewById(R.id.price_list);
            stock = itemView.findViewById(R.id.stock);
        }
    }
}