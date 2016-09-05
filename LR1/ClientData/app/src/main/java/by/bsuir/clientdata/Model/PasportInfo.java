package by.bsuir.clientdata.Model;


import java.sql.Date;

public class PasportInfo {

    private int idPasport;
    private String series;
    private String number;
    private String organization;
    private Date date;
    private String identNumber;


    public int getIdPasport() {
        return idPasport;
    }

    public void setIdPasport(int idPasport) {
        this.idPasport = idPasport;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public PasportInfo() {
}   }
