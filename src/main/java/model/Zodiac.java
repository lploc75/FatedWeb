/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author locsu
 */
public class Zodiac {

    private int type_id;
    private int zodiac_id;
    private String compatible_signs;
    private String incompatible_signs;
    private String Element_Mode_Season;
    private String Characteristics;
    private String Purpose_Career;
    private String Health;

    public Zodiac() {
    }

    public Zodiac(int type_id, int zodiac_id, String compatible_signs, String incompatible_signs, String Element_Mode_Season, String Characteristics, String Purpose_Career, String Health) {
        this.type_id = type_id;
        this.zodiac_id = zodiac_id;
        this.compatible_signs = compatible_signs;
        this.incompatible_signs = incompatible_signs;
        this.Element_Mode_Season = Element_Mode_Season;
        this.Characteristics = Characteristics;
        this.Purpose_Career = Purpose_Career;
        this.Health = Health;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getZodiac_id() {
        return zodiac_id;
    }

    public void setZodiac_id(int zodiac_id) {
        this.zodiac_id = zodiac_id;
    }

    public String getCompatible_signs() {
        return compatible_signs;
    }

    public void setCompatible_signs(String compatible_signs) {
        this.compatible_signs = compatible_signs;
    }

    public String getIncompatible_signs() {
        return incompatible_signs;
    }

    public void setIncompatible_signs(String incompatible_signs) {
        this.incompatible_signs = incompatible_signs;
    }

    public String getElement_Mode_Season() {
        return Element_Mode_Season;
    }

    public void setElement_Mode_Season(String Element_Mode_Season) {
        this.Element_Mode_Season = Element_Mode_Season;
    }

    public String getCharacteristics() {
        return Characteristics;
    }

    public void setCharacteristics(String Characteristics) {
        this.Characteristics = Characteristics;
    }

    public String getPurpose_Career() {
        return Purpose_Career;
    }

    public void setPurpose_Career(String Purpose_Career) {
        this.Purpose_Career = Purpose_Career;
    }

    public String getHealth() {
        return Health;
    }

    public void setHealth(String Health) {
        this.Health = Health;
    }
}

    