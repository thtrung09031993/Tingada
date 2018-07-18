package hci201.tingada;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListRequestAdapter extends  RecyclerView.Adapter<ListRequestAdapter.ViewHolder>{

    private ArrayList<String> data;
    private ItemClickListener<Integer> itemClickListener;

    public ListRequestAdapter(ArrayList<String> data) {
        this.data = data;
    }

    public void setItemClickListener(ItemClickListener<Integer> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.request_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.requestName.setText(data.get(position));
        holder.acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null){
                    itemClickListener.onAccept(holder.getAdapterPosition());
                }
            }
        });
        holder.rejectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null){
                    itemClickListener.onReject(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView requestName;
        ImageView acceptBtn, rejectBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            requestName = itemView.findViewById(R.id.request_name);
            acceptBtn = itemView.findViewById(R.id.acceptBtn);
            rejectBtn = itemView.findViewById(R.id.rejectBtn);
        }
    }

    public String getData(int pos){
        return this.data.get(pos);
    }

    public void remove(int pos){
        this.data.remove(pos);
    }
}
