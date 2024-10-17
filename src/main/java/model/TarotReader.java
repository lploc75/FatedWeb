/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author locsu
 */
public class TarotReader {
    private int type_id;
    private int card_id;
    private String card_url;
    private String card_name;
    private String wish_des;
    private String love_des;
    private String career_des;
    private String study_des;

    public TarotReader() {
    }

    public TarotReader(int type_id, int card_id, String card_url, String card_name, String wish_des, String love_des, String career_des, String study_des) {
        this.type_id = type_id;
        this.card_id = card_id;
        this.card_url = card_url;
        this.card_name = card_name;
        this.wish_des = wish_des;
        this.love_des = love_des;
        this.career_des = career_des;
        this.study_des = study_des;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getCard_url() {
        return card_url;
    }

    public void setCard_url(String card_url) {
        this.card_url = card_url;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getWish_des() {
        return wish_des;
    }

    public void setWish_des(String wish_des) {
        this.wish_des = wish_des;
    }

    public String getLove_des() {
        return love_des;
    }

    public void setLove_des(String love_des) {
        this.love_des = love_des;
    }

    public String getCareer_des() {
        return career_des;
    }

    public void setCareer_des(String career_des) {
        this.career_des = career_des;
    }

    public String getStudy_des() {
        return study_des;
    }

    public void setStudy_des(String study_des) {
        this.study_des = study_des;
    }

    
   
    
}
