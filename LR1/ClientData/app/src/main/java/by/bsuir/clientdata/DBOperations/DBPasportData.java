package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.clientdata.Model.PasportInfo;
import by.bsuir.clientdata.R;


public class DBPasportData extends AsyncTask <Void,Void, List<PasportInfo>> {

    Statement statement;
    String query;

    public DBPasportData(Statement statement, Context mContext, int pasportID) {
        this.statement = statement;
        this.query = mContext.getString(R.string.select_pasport, pasportID);
    }

    public DBPasportData(Statement statement, Context mContext) {
        this.statement = statement;
        this.query = mContext.getString(R.string.select_all_pasports);
    }

    @Override
    protected List<PasportInfo> doInBackground(Void... voids) {
        List<PasportInfo> pasports = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                PasportInfo pasport = new PasportInfo();
                pasport.setIdPasport(Integer.parseInt(resultSet.getString("idPasport")));
                pasport.setSeries(resultSet.getString("series"));
                pasport.setNumber(resultSet.getString("number"));
                pasport.setDate(Date.valueOf(resultSet.getString("date")));
                pasport.setOrganization(resultSet.getString("organization"));
                pasport.setIdentNumber(resultSet.getString("identNumber"));
                pasports.add(pasport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasports;
    }
}
