/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author locsu
 */
public class EasternHoroscope {

    private int year;
    private String overview;
    private String career;
    private String love;
    private String health;
    private String fortune;
    private String family;
    private String importantYears;
    private String advice;
    private int type_id;

    public EasternHoroscope() {
    }

    public EasternHoroscope(int year, String overview, String career, String love, String health, String fortune, String family, String importantYears, String advice, int type_id) {
        this.year = year;
        this.overview = overview;
        this.career = career;
        this.love = love;
        this.health = health;
        this.fortune = fortune;
        this.family = family;
        this.importantYears = importantYears;
        this.advice = advice;
        this.type_id = type_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getFortune() {
        return fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getImportantYears() {
        return importantYears;
    }

    public void setImportantYears(String importantYears) {
        this.importantYears = importantYears;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

}
