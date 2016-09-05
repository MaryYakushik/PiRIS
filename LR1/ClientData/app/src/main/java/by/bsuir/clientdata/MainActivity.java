package by.bsuir.clientdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;

import by.bsuir.clientdata.DBOperations.DBClientsData;
import by.bsuir.clientdata.DBOperations.DBConnection;
import by.bsuir.clientdata.Model.ClientInfo;


public class MainActivity extends AppCompatActivity {

    private int LAYOUT = R.layout.activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        try {
            String url = getString(R.string.db_url);
            String user = getString(R.string.user);
            String password = getString(R.string.password);
            Statement st = new DBConnection(getApplicationContext()).execute(url, user, password).get();
            List<ClientInfo> clients = new DBClientsData(st, getApplicationContext()).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
