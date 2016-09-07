package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import by.bsuir.clientdata.R;

public class DBConnection extends AsyncTask<String, Void, Statement> {

    String url;
    String user;
    String password;

    public DBConnection(Context context) {
        url = context.getString(R.string.db_url);
        user = context.getString(R.string.user);
        password = context.getString(R.string.password);
    }

    @Override
    protected Statement doInBackground(String... params) {
        Statement st = null;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
}
