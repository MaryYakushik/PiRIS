package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection extends AsyncTask<String, Void, Statement> {

    String url = "jdbc:mysql://192.168.0.106:3306/bank_db";
    String user = "user";
    String password = "13345678";
    Context mContext;

    public DBConnection(Context context) {
        mContext = context;
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
