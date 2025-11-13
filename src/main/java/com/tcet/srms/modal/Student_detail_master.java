/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcet.srms.modal;
import java.time.LocalDate;
public class Student_detail_master{
 private  int student_id;
   private  String first_name;
   private  String middle_name;
   private  String last_name;
   private  int gender_id;
   private  LocalDate date_of_birth;
   private  int country_id;
   private  int religion;
   private  int category;
   private  String address;
   private  int state;
   private  int district;
   private  String city;
   private  String contact_no;
   private  String email_id;
   private  String aadhar_no;
   private  String abc_id;
   private  String birth_place;
   private  String blood_group;

   
   
   public Student_detail_master(int student_id, String first_name, String middle_name, String last_name, int gender_id, LocalDate date_of_birth, int country_id, int religion, int category, String address, int state, int district, String city, String contact_no, String email_id, String aadhar_no, String abc_id, String birth_place, String blood_group) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender_id = gender_id;
        this.date_of_birth = date_of_birth;
        this.country_id = country_id;
        this.religion = religion;
        this.category = category;
        this.address = address;
        this.state = state;
        this.district = district;
        this.city = city;
        this.contact_no = contact_no;
        this.email_id = email_id;
        this.aadhar_no = aadhar_no;
        this.abc_id = abc_id;
        this.birth_place = birth_place;
        this.blood_group = blood_group;
    }
   
   
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAadhar_no() {
        return aadhar_no;
    }

    public void setAadhar_no(String aadhar_no) {
        this.aadhar_no = aadhar_no;
    }

    public String getAbc_id() {
        return abc_id;
    }

    public void setAbc_id(String abc_id) {
        this.abc_id = abc_id;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    
}
