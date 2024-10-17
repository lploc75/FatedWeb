/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HuyTruong
 */
public class CanChiCalculator {

    private static final String[] CAN = {"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
    private static final String[] CHI = {"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};
    private static final Map<String, String> ELEMENT_MAP = new HashMap<>();

    static {
        ELEMENT_MAP.put("Giáp", "Mộc");
        ELEMENT_MAP.put("Ất", "Mộc");
        ELEMENT_MAP.put("Bính", "Hỏa");
        ELEMENT_MAP.put("Đinh", "Hỏa");
        ELEMENT_MAP.put("Mậu", "Thổ");
        ELEMENT_MAP.put("Kỷ", "Thổ");
        ELEMENT_MAP.put("Canh", "Kim");
        ELEMENT_MAP.put("Tân", "Kim");
        ELEMENT_MAP.put("Nhâm", "Thủy");
        ELEMENT_MAP.put("Quý", "Thủy");

        ELEMENT_MAP.put("Tý", "Thủy");
        ELEMENT_MAP.put("Sửu", "Thổ");
        ELEMENT_MAP.put("Dần", "Mộc");
        ELEMENT_MAP.put("Mão", "Mộc");
        ELEMENT_MAP.put("Thìn", "Thổ");
        ELEMENT_MAP.put("Tỵ", "Hỏa");
        ELEMENT_MAP.put("Ngọ", "Hỏa");
        ELEMENT_MAP.put("Mùi", "Thổ");
        ELEMENT_MAP.put("Thân", "Kim");
        ELEMENT_MAP.put("Dậu", "Kim");
        ELEMENT_MAP.put("Tuất", "Thổ");
        ELEMENT_MAP.put("Hợi", "Thủy");
    }

    public String getCan(int year) {
        return CAN[(year + 6) % 10];
    }

    public String getChi(int year) {
        return CHI[(year + 8) % 12];
    }

    // Phương pháp xác định Thiên Can của tháng âm lịch
    public static String getMonthCan(int year, int month) {
        String[] monthCanTable;
        switch (CAN[(year + 6) % 10]) {
            case "Giáp":
            case "Kỷ":
                monthCanTable = new String[]{"Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh"};
                break;
            case "Ất":
            case "Canh":
                monthCanTable = new String[]{"Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
                break;
            case "Bính":
            case "Tân":
                monthCanTable = new String[]{"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân"};
                break;
            case "Đinh":
            case "Nhâm":
                monthCanTable = new String[]{"Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
                break;
            case "Mậu":
            case "Quý":
                monthCanTable = new String[]{"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất"};
                break;
            default:
                throw new IllegalArgumentException("Thiên Can không hợp lệ");
        }
        return monthCanTable[month - 1];
    }

    // Phương pháp xác định Địa Chi của tháng âm lịch
    public static String getMonthChi(int month) {
        return CHI[(month + 1) % 12]; // Tháng 1 âm lịch ứng với Dần
    }

    // Phương pháp xác định Thiên Can và Địa Chi của ngày dương lịch
    public static String[] canChi(String date) {
        String[] canList = {"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
        String[] chiList = {"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};

        // Ngày cơ sở: 29 tháng 6 năm 2024 (Giáp Tý)
        LocalDate baseDate = LocalDate.of(2024, 6, 29);
        LocalDate targetDate = LocalDate.parse(date);

        // Tính số ngày chênh lệch
        long deltaDays = java.time.temporal.ChronoUnit.DAYS.between(baseDate, targetDate);

        // Sử dụng Math.floorMod để đảm bảo chỉ số luôn dương
        int canIndex = Math.floorMod((int) deltaDays, 10);
        int chiIndex = Math.floorMod((int) deltaDays, 12);

        // Lấy giá trị can và chi từ danh sách
        String can = canList[canIndex];
        String chi = chiList[chiIndex];

        return new String[]{can, chi};
    }

    public Map<String, Integer> analyzeElements(String canYear, String chiYear, String canMonth, String chiMonth, String canDay, String chiDay) {
        Map<String, Integer> elementCount = new HashMap<>();
        for (String element : ELEMENT_MAP.values()) {
            elementCount.put(element, 0);
        }

        elementCount.put(ELEMENT_MAP.get(canYear), elementCount.get(ELEMENT_MAP.get(canYear)) + 1);
        elementCount.put(ELEMENT_MAP.get(chiYear), elementCount.get(ELEMENT_MAP.get(chiYear)) + 1);
        elementCount.put(ELEMENT_MAP.get(canMonth), elementCount.get(ELEMENT_MAP.get(canMonth)) + 1);
        elementCount.put(ELEMENT_MAP.get(chiMonth), elementCount.get(ELEMENT_MAP.get(chiMonth)) + 1);
        elementCount.put(ELEMENT_MAP.get(canDay), elementCount.get(ELEMENT_MAP.get(canDay)) + 1);
        elementCount.put(ELEMENT_MAP.get(chiDay), elementCount.get(ELEMENT_MAP.get(chiDay)) + 1);

        return elementCount;
    }

      public static String findWeakElement(Map<String, Integer> elementCount) {
        // Tìm các yếu tố có điểm 0
        List<String> zeroElements = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : elementCount.entrySet()) {
            if (entry.getValue() == 0) {
                zeroElements.add(entry.getKey());
            }
        }

        // Nếu có nhiều yếu tố có điểm 0, tìm yếu tố bị khuyết nặng nhất
        if (zeroElements.size() > 1) {
            Map<String, String> cycle = getCycleMap();

            String weakestElement = null;
            int maxDifference = Integer.MIN_VALUE;

            for (String element : zeroElements) {
                String nextElement = cycle.get(element);
                int nextElementCount = elementCount.getOrDefault(nextElement, 0);
                int difference = nextElementCount - elementCount.getOrDefault(element, 0);
                if (difference > maxDifference) {
                    maxDifference = difference;
                    weakestElement = element;
                }
            }

            return weakestElement;
        }

        // Nếu có một yếu tố có điểm 0, yếu tố đó chắc chắn bị khuyết
        if (zeroElements.size() == 1) {
            return zeroElements.get(0);
        }

        // Tìm yếu tố có điểm cao nhất
        int maxCount = Collections.max(elementCount.values());

        // Tìm các yếu tố có điểm cao nhất
        List<String> strongestElements = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : elementCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                strongestElements.add(entry.getKey());
            }
        }

        // Nếu chỉ có một yếu tố có điểm cao nhất
        if (strongestElements.size() == 1) {
            String strongestElement = strongestElements.get(0);
            return getWeakElement(strongestElement);
        }

        // Nếu có nhiều yếu tố có điểm cao nhất, áp dụng quy tắc tương khắc để tìm yếu tố bị khuyết
        Map<String, String> cycle = getCycleMap();

        String weakElement = null;
        int weakestDifference = Integer.MAX_VALUE;

        for (String element : strongestElements) {
            String opposingElement = cycle.get(element);
            int difference = maxCount - elementCount.getOrDefault(opposingElement, 0);
            if (difference < weakestDifference) {
                weakestDifference = difference;
                weakElement = opposingElement;
            }
        }

        return weakElement;
    }

    private static String getWeakElement(String strongestElement) {
        Map<String, String> cycle = getCycleMap();
        return cycle.get(strongestElement);
    }

    private static Map<String, String> getCycleMap() {
        Map<String, String> cycle = new HashMap<>();
        cycle.put("Kim", "Hoả");
        cycle.put("Mộc", "Kin");
        cycle.put("Thổ", "Mộc");
        cycle.put("Thủy", "Thổ");
        cycle.put("Hỏa", "Thuỷ");
        return cycle;
    }
}