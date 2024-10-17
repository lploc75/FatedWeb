/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.LunarDate;

/**
 *
 * @author HuyTruong
 */
public class LunarDateConverter {

    public static LunarDate convertSolar2Lunar(int dd, int mm, int yy, double timeZone) {
        int[] lunar = LunarCalendarConverter.convertSolar2Lunar(dd, mm, yy, timeZone);
        return new LunarDate(lunar[0], lunar[1], lunar[2], lunar[3] == 1);
    }
}