package hci201.tingada;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;


public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.RecyclerViewHolder> {

    private List<String> data;


    public FeedAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.feed, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        holder.txtUser.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtUser;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtUser = (TextView) itemView.findViewById(R.id.userInfo);
        }
    }

    public void addMoreItems(String item){
        this.data.add(item);
    }

}
