package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.clientdata.R;

public class DBDisabilityData extends AsyncTask<Void, Void, List<String>>{

    Statement statement;
    String query;

    public DBDisabilityData(Statement statement, Context context, int idDisability) {
        this.statement = statement;
        query = context.getString(R.string.select_disability, idDisability);
    }

    public DBDisabilityData(Statement statement, Context context) {
        this.statement = statement;
        query = context.getString(R.string.select_all_disabilities);
    }

    @Override
    protected List<String> doInBackground(Void... voids) {

        List<String> disabilities = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                disabilities.add(resultSet.getString("group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disabilities;
    }
}
