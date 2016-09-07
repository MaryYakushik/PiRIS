package by.bsuir.clientdata.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import by.bsuir.clientdata.Model.ClientInfo;
import by.bsuir.clientdata.R;


public class ClientsAdapter extends BaseAdapter {

    private List<ClientInfo> clients;
    private Context context;

    public ClientsAdapter(Context context, List<ClientInfo> clients) {
        this.clients = clients;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clients.size();
    }

    @Override
    public Object getItem(int i) {
        return clients.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View clientsView;
        if (view == null) {
            LayoutInflater li = LayoutInflater.from(context);
            clientsView = li.inflate(R.layout.listview_grid, null  );
        } else {
            clientsView = view;
        }

        TextView clientFIO = (TextView) clientsView.findViewById(R.id.clientsFIO);
        TextView pasportID = (TextView) clientsView.findViewById(R.id.pasportID);

        clientFIO.setText(clients.get(i).getSurname()+ " " + clients.get(i).getName()+ " " + clients.get(i).getPatronymic());
        pasportID.setText(String.valueOf(clients.get(i).getPasportId()));

        return clientsView;
    }
}
