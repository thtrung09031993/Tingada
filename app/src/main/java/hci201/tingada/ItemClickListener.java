package hci201.tingada;

public interface ItemClickListener<V> {
    public void onAccept(V position);
    public void onReject(V position);
}
