package by.bsuir.clientdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;

import java.sql.Statement;
import java.text.ParsePosition;
import java.util.List;
import java.util.concurrent.ExecutionException;

import by.bsuir.clientdata.Adapter.ClientAdapter;
import by.bsuir.clientdata.Adapter.ClientsAdapter;
import by.bsuir.clientdata.DBOperations.DBClientsData;
import by.bsuir.clientdata.DBOperations.DBConnection;
import by.bsuir.clientdata.DBOperations.DBDisabilityData;
import by.bsuir.clientdata.DBOperations.DBMaritalStatusData;
import by.bsuir.clientdata.DBOperations.DBNationalityData;
import by.bsuir.clientdata.DBOperations.DBPasportData;
import by.bsuir.clientdata.DBOperations.DBPlaseOfBirthData;
import by.bsuir.clientdata.Model.ClientInfo;
import by.bsuir.clientdata.Model.DbData;
import by.bsuir.clientdata.Model.PasportInfo;


public class MainActivity extends AppCompatActivity {

    private int LAYOUT = R.layout.activity_main;
    LayoutInflater inflater;
    TableLayout contentView;
    Statement dbSt;
    DbData allDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = getLayoutInflater();
        allDb = new DbData();
        setContentView(LAYOUT);
        contentView = (TableLayout) findViewById(R.id.contentView);
        try {
            dbSt = new DBConnection(getApplicationContext()).execute().get();
            allDb.setClients(new DBClientsData(dbSt, getApplicationContext()).execute().get());
            allDb.setPasports(new DBPasportData(dbSt, getApplicationContext()).execute().get());
            allDb.setMaritalStatuses(new DBMaritalStatusData(dbSt, getApplicationContext()).execute().get());
            allDb.setDisabilities(new DBDisabilityData(dbSt, getApplicationContext()).execute().get());
            allDb.setTowns(new DBPlaseOfBirthData(dbSt, getApplicationContext()).execute().get());
            allDb.setNationalities(new DBNationalityData(dbSt, getApplicationContext()).execute().get());

            openListOfClients();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void openListOfClients() throws ExecutionException, InterruptedException {
        ListView clientsView = (ListView) inflater.inflate(R.layout.listview_clients, null);
        clientsView.setAdapter(new ClientsAdapter(this, allDb.getClients()));
        clientsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                try {
                    editClient(allDb.getClients().get(position));
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        clientsView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                return false;
            }
        });
        contentView.addView(clientsView);
    }

    private void editClient(ClientInfo client) throws ExecutionException, InterruptedException {
        contentView.removeAllViews();
        contentView.addView(new ClientAdapter(getApplicationContext(), client, dbSt, allDb).getView());

    }


}
