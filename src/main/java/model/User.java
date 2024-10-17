/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Luu Chi Khanh-CE181175
 */
public class User {

    private int id;
    private String fullname;
    private String gender;
    private String dob;
    private Account account;
    private String membership;
    private double price;
    private String period;
    private String ranktype;

    public User() {
    }

    public User(int id, String fullname, String gender, String dob, Account account, String membership, double price, String period, String ranktype) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
        this.account = account;
        this.membership = membership;
        this.price = price;
        this.period = period;
        this.ranktype = ranktype;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

   

    public String getRanktype() {
        return ranktype;
    }

    public void setRanktype(String ranktype) {
        this.ranktype = ranktype;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
