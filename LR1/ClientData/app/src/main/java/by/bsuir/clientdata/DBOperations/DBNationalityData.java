package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.clientdata.R;

public class DBNationalityData extends AsyncTask<Void, Void, List<String>> {

    Statement statement;
    String query;

    public DBNationalityData(Statement statement, Context context, int idNationality) {
        this.statement = statement;
        query = context.getString(R.string.select_nationality, idNationality);
    }

    public DBNationalityData(Statement statement, Context context) {
        this.statement = statement;
        query = context.getString(R.string.select_all_nationalities);
    }

    @Override
    protected List<String> doInBackground(Void... voids) {
        List<String> nationalities = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                nationalities.add(resultSet.getString("nationality"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nationalities;
    }
}
