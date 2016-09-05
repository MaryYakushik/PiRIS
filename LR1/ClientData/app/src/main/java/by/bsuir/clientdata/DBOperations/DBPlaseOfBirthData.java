package by.bsuir.clientdata.DBOperations;


import android.content.Context;
import android.os.AsyncTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.clientdata.R;

public class DBPlaseOfBirthData extends AsyncTask<Void, Void, List<String>>{

    Statement statement;
    String query;

    public DBPlaseOfBirthData(Statement statement, Context context, int idTown) {
        this.statement = statement;
        query = context.getString(R.string.select_place_of_birth, idTown);
    }

    public DBPlaseOfBirthData(Statement statement, Context context) {
        this.statement = statement;
        query = context.getString(R.string.select_all_places_of_birth);
    }

    @Override
    protected List<String> doInBackground(Void... voids) {
        List<String> town = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                town.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return town;
    }
}
