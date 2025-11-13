package com.tcet.srms.modal;

public class Parents_detail_master {

    private int guardian_id;
    private String father_name;
    private String mother_name;
    private String father_contact;
    private String mother_contact;
    private String father_email;
    private String mother_email;
    private String father_qualification;
    private String mother_qualification;
    private String total_earning;
    private String father_occupation;
    private String mother_occupation;

    public Parents_detail_master(int guardian_id, String father_name, String mother_name, String father_contact, String mother_contact, String father_email, String mother_email, String father_qualification, String mother_qualification, String total_earning, String father_occupation, String mother_occupation) {
        this.guardian_id = guardian_id;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.father_contact = father_contact;
        this.mother_contact = mother_contact;
        this.father_email = father_email;
        this.mother_email = mother_email;
        this.father_qualification = father_qualification;
        this.mother_qualification = mother_qualification;
        this.total_earning = total_earning;
        this.father_occupation = father_occupation;
        this.mother_occupation = mother_occupation;

    }

    public int getGuardian_id() {
        return guardian_id;
    }

    public void setGuardian_id(int guardian_id) {
        this.guardian_id = guardian_id;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getFather_contact() {
        return father_contact;
    }

    public void setFather_contact(String father_contact) {
        this.father_contact = father_contact;
    }

    public String getMother_contact() {
        return mother_contact;
    }

    public void setMother_contact(String mother_contact) {
        this.mother_contact = mother_contact;
    }

    public String getFather_email() {
        return father_email;
    }

    public void setFather_email(String father_email) {
        this.father_email = father_email;
    }

    public String getMother_email() {
        return mother_email;
    }

    public void setMother_email(String mother_email) {
        this.mother_email = mother_email;
    }

    public String getFather_qualification() {
        return father_qualification;
    }

    public void setFather_qualification(String father_qualification) {
        this.father_qualification = father_qualification;
    }

    public String getMother_qualification() {
        return mother_qualification;
    }

    public void setMother_qualification(String mother_qualification) {
        this.mother_qualification = mother_qualification;
    }

    public String getFamily_total_earning() {
        return total_earning;
    }

    public void setFamily_total_earning(String total_earning) {
        this.total_earning = total_earning;
    }

    public String getFather_occupation() {
        return father_occupation;
    }

    public void setFather_occupation(String father_occupation) {
        this.father_occupation = father_occupation;
    }

    public String getMother_occupation() {
        return mother_occupation;
    }

    public void setMother_occupation(String mother_occupation) {
        this.mother_occupation = mother_occupation;
    }

}
