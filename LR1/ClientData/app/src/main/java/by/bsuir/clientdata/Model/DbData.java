package by.bsuir.clientdata.Model;

import java.util.List;


public class DbData {
    private List<ClientInfo> clients;
    private List<PasportInfo> pasports;
    private List<String> maritalStatuses;
    private List<String> disabilities;
    private List<String> nationalities;

    public List<String> getTowns() {
        return towns;
    }

    public void setTowns(List<String> towns) {
        this.towns = towns;
    }

    public List<ClientInfo> getClients() {
        return clients;
    }

    public void setClients(List<ClientInfo> clients) {
        this.clients = clients;
    }

    public List<PasportInfo> getPasports() {
        return pasports;
    }

    public PasportInfo getPasport(int id){
        for(int i = 0; i < pasports.size(); i++){
            if (pasports.get(i).getIdPasport() == id)
                return pasports.get(i);
        }
        return pasports.get(0);
    }

    public void setPasports(List<PasportInfo> pasports) {
        this.pasports = pasports;
    }

    public List<String> getMaritalStatuses() {
        return maritalStatuses;
    }

    public void setMaritalStatuses(List<String> maritalStatuses) {
        this.maritalStatuses = maritalStatuses;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public List<String> getNationalities() {
        return nationalities;
    }

    public void setNationalities(List<String> nationalities) {
        this.nationalities = nationalities;
    }

    private List<String> towns;
}
