package hci201.tingada;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class ChatScreenAdapter extends RecyclerView.Adapter<ChatScreenAdapter.RecyclerViewHolder> {

    private List<String> data;


    public ChatScreenAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.chat, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        holder.txtChatScreen.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtChatScreen;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtChatScreen = (TextView) itemView.findViewById(R.id.chat);
        }
    }

    public void addMoreItems(String item){
        this.data.add(item);
    }

}
