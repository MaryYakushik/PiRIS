package by.bsuir.clientdata.Model;

import java.sql.Date;

/**
 * Created by User on 05.09.2016.
 */
public class ClientInfo {

    private String surname;
    private String name;
    private String patronymic;
    private Date dateOfBirth;
    private int gender;
    private int pasportId;
    private String placeOfBirth;
    private int placeOfResidence;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String e_mail;
    private int maritalStatus;
    private int nationality;
    private int disability;
    private boolean pensioner;
    private Integer monthlyIncome;
    private boolean military;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getPasportId() {
        return pasportId;
    }

    public void setPasportId(int pasportId) {
        this.pasportId = pasportId;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(int placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public int getDisability() {
        return disability;
    }

    public void setDisability(int disability) {
        this.disability = disability;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public ClientInfo() {
    }
}
