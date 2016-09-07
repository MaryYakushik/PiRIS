package by.bsuir.clientdata.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;

import by.bsuir.clientdata.DBOperations.DBDisabilityData;
import by.bsuir.clientdata.DBOperations.DBMaritalStatusData;
import by.bsuir.clientdata.DBOperations.DBNationalityData;
import by.bsuir.clientdata.DBOperations.DBPasportData;
import by.bsuir.clientdata.DBOperations.DBPlaseOfBirthData;
import by.bsuir.clientdata.Model.ClientInfo;
import by.bsuir.clientdata.Model.DbData;
import by.bsuir.clientdata.Model.PasportInfo;
import by.bsuir.clientdata.R;

public class ClientAdapter {

    Context mContext;
    ClientInfo client;
    Statement statement;
    DbData all_db;

    public ClientAdapter(Context context, ClientInfo client, Statement st, DbData all_db) {
        mContext = context;
        this.client = client;
        statement = st;
        this.all_db = all_db;
    }

    public View getView() throws ExecutionException, InterruptedException {
        View viewClient;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        viewClient = inflater.inflate(R.layout.client_activity, null);

        EditText name = (EditText) viewClient.findViewById(R.id.name);
        EditText surname = (EditText) viewClient.findViewById(R.id.surname);
        EditText patronymic = (EditText) viewClient.findViewById(R.id.patronymic);
        EditText dateOfBirth = (EditText) viewClient.findViewById(R.id.date);
        RadioButton gender;
        if(client.getGender() == 0){
            gender = (RadioButton) viewClient.findViewById(R.id.woman);
        }
        else{
            gender = (RadioButton) viewClient.findViewById(R.id.man);
        }

        EditText pasportSeries = (EditText) viewClient.findViewById(R.id.series);
        EditText pasportNumber = (EditText) viewClient.findViewById(R.id.number);
        EditText organization = (EditText) viewClient.findViewById(R.id.organization);
        EditText pasportDate = (EditText) viewClient.findViewById(R.id.pasportDate);
        EditText identNumber = (EditText) viewClient.findViewById(R.id.identNumber);

        EditText placeOfBirth = (EditText) viewClient.findViewById(R.id.placeOfBirth);
        Spinner towns = (Spinner) viewClient.findViewById(R.id.towns);
        EditText address = (EditText) viewClient.findViewById(R.id.address);
        EditText homePhone = (EditText) viewClient.findViewById(R.id.homePhone);
        EditText mobilePhone = (EditText) viewClient.findViewById(R.id.mobilePhone);
        EditText e_maeil = (EditText) viewClient.findViewById(R.id.e_mail);
        Spinner maritalStatus = (Spinner) viewClient.findViewById(R.id.maritalStatus);
        Spinner nationality = (Spinner) viewClient.findViewById(R.id.nationality);
        Spinner disability = (Spinner) viewClient.findViewById(R.id.disability);
        CheckBox pensioner = (CheckBox) viewClient.findViewById(R.id.pensioner);
        EditText monthlyIncome = (EditText) viewClient.findViewById(R.id.monthlyIncome);
        CheckBox militarry = (CheckBox) viewClient.findViewById(R.id.military);
        Button editButton = (Button) viewClient.findViewById(R.id.addClient);

        name.setText(client.getName());
        surname.setText(client.getSurname());
        patronymic.setText(client.getPatronymic());
        dateOfBirth.setText(client.getDateOfBirth().toString());
        gender.setChecked(true);

        PasportInfo pasport = all_db.getPasport(client.getPasportId());
        pasportSeries.setText(pasport.getSeries());
        pasportNumber.setText(pasport.getNumber());
        organization.setText(pasport.getOrganization());
        pasportDate.setText(pasport.getDate().toString());
        identNumber.setText(pasport.getIdentNumber());

        placeOfBirth.setText(client.getPlaceOfBirth());

        List<String> listTowns = all_db.getTowns();
        towns.setAdapter(getNewAdapter(listTowns));
        towns.setSelection(0);

        address.setText(client.getAddress());
        homePhone.setText(client.getHomePhone());
        mobilePhone.setText(client.getMobilePhone());
        e_maeil.setText(client.getE_mail());

        List<String> maritalStatuses = all_db.getMaritalStatuses();
        maritalStatus.setAdapter(getNewAdapter(maritalStatuses));
        maritalStatus.setSelection(0);

        List<String> nationalities = all_db.getNationalities();
        nationality.setAdapter(getNewAdapter(nationalities));
        nationality.setSelection(0);

        List<String> groups = all_db.getDisabilities();
        disability.setAdapter(getNewAdapter(groups));
        disability.setSelection(0);

        pensioner.setChecked(client.isPensioner());
        monthlyIncome.setText(String.valueOf(client.getMonthlyIncome()));
        militarry.setChecked(client.isMilitary());

        return  viewClient;
    }


    private ArrayAdapter<String> getNewAdapter(List<String> data){
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, data);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return spinnerAdapter;
    }


}
