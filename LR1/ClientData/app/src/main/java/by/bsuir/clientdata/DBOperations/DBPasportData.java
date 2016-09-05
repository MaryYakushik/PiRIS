package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.bsuir.clientdata.Model.PasportInfo;
import by.bsuir.clientdata.R;


public class DBPasportData extends AsyncTask <Void,Void, PasportInfo> {

    Statement statement;
    String query;

    public DBPasportData(Statement statement, Context mContext, int pasportID) {
        this.statement = statement;
        this.query = mContext.getString(R.string.select_pasport, pasportID);
    }

    @Override
    protected PasportInfo doInBackground(Void... voids) {
        PasportInfo pasport = new PasportInfo();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            pasport.setIdPasport(Integer.parseInt(resultSet.getString("idPasport")));
            pasport.setSeries(resultSet.getString("series"));
            pasport.setNumber(resultSet.getString("number"));
            pasport.setDate(Date.valueOf(resultSet.getString("date")));
            pasport.setOrganization(resultSet.getString("organization"));
            pasport.setIdentNumber(resultSet.getString("identNumber"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasport;
    }
}
