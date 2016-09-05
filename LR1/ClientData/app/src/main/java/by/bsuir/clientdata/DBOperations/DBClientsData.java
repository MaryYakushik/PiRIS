package by.bsuir.clientdata.DBOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.clientdata.Model.ClientInfo;
import by.bsuir.clientdata.R;

public  class DBClientsData extends AsyncTask<Void, Void,  List<ClientInfo>>{

    private Statement statement;
    private String query;

    public DBClientsData(Statement statement, Context mContext) {
        this.statement = statement;
        this.query = mContext.getString(R.string.select_all_clients);
    }

    public DBClientsData(Statement statement, Context mContext, String name, String surname) {
        this.statement = statement;
        this.query = mContext.getString(R.string.select_client, surname, name);
    }

    @Override
    protected  List<ClientInfo> doInBackground(Void... voids) {
        List<ClientInfo> clients = null;
        try {
            ResultSet resultSet = statement.executeQuery(query);
            clients = new ArrayList<>();
            while(resultSet.next()){
                ClientInfo client = new ClientInfo();
                client.setSurname(resultSet.getString("surname"));
                client.setName(resultSet.getString("name"));
                client.setPatronymic(resultSet.getString("patronymic"));
                client.setDateOfBirth(Date.valueOf(resultSet.getString("dateOfBirth")));
                client.setGender(Integer.parseInt(resultSet.getString("gender")));
                client.setPasportId(Integer.parseInt(resultSet.getString("pasportId")));
                client.setPlaceOfBirth(resultSet.getString("placeOfBirth"));
                client.setPlaceOfResidence(Integer.parseInt(resultSet.getString("placeOfResidence")));
                client.setAddress(resultSet.getString("address"));
                client.setHomePhone(resultSet.getString("homephone"));
                client.setMobilePhone(resultSet.getString("mobilePhone"));
                client.setE_mail(resultSet.getString("e-mail"));
                client.setMaritalStatus(Integer.parseInt(resultSet.getString("maritalStatus")));
                client.setNationality(Integer.parseInt(resultSet.getString("nationality")));
                client.setDisability(Integer.parseInt(resultSet.getString("disability")));
                client.setPensioner(Boolean.parseBoolean(resultSet.getString("pensioner")));
                client.setMonthlyIncome(Integer.parseInt(resultSet.getString("monthlyIncome")));
                client.setMilitary(Boolean.parseBoolean(resultSet.getString("military")));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
