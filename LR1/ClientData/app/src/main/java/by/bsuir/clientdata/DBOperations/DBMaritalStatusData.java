package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Statement;
import java.util.List;

import by.bsuir.clientdata.R;

public class DBMaritalStatusData extends AsyncTask<Void, Void, List<String>> {

    Statement statement;
    String query;

    public DBMaritalStatusData(Statement statement, Context mContext, int idStatus) {
        this.statement = statement;
        query = mContext.getString(R.string.select_marital_status, idStatus);
    }

    public DBMaritalStatusData(Statement statement, Context mContext) {
        this.statement = statement;
        query = mContext.getString(R.string.select_all_marital_status);
    }

    @Override
    protected List<String> doInBackground(Void... voids) {

        return null;
    }
}
