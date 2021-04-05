package com.automation.test.libraries.web.ui.model;

public class PersonalDetailsModel {
    private String birthDate;
    private String birthMonth;
    private String birthYear;
    private String nationality;
    private String gender;
    private String interestedProduct;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterestedProduct() {
        return interestedProduct;
    }

    public void setInterestedProduct(String interestedProduct) {
        this.interestedProduct = interestedProduct;
    }
}
