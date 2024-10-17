package DAO;

import java.time.LocalDate;
import java.util.Map;
import model.LunarDate;

public class LunarCalendarConverter {

    private String weakElement;

    public String getWeakElement() {
        return weakElement;
    }

    public String LunarCalendarConverter(int day, int month, int year) {
        String result = "";
        // Example usage
        double timeZone = 7.0;
        // Convert solar date to lunar date
        int[] lunarDateArray = convertSolar2Lunar(day, month, year, timeZone);
        LunarDate lunarDate = new LunarDate(lunarDateArray[0], lunarDateArray[1], lunarDateArray[2], lunarDateArray[3] == 1);
        System.out.printf("Lunar Date: %02d-%02d-%d\n", lunarDate.getDay(), lunarDate.getMonth(), lunarDate.getYear());

        // Calculate Can Chi and analyze elements
        CanChiCalculator calculator = new CanChiCalculator();
        String canNam = calculator.getCan(lunarDate.getYear());
        String chiNam = calculator.getChi(lunarDate.getYear());

        String monthCan = calculator.getMonthCan(lunarDate.getYear(), lunarDate.getMonth());
        String monthChi = calculator.getMonthChi(lunarDate.getMonth());

        // Tính Can Chi của ngày dựa trên ngày dương lịch
        String[] canChiNgay = calculator.canChi(LocalDate.of(year, month, day).toString());

        // Analyze elements in Bazi Chart
        Map<String, Integer> elementCount = calculator.analyzeElements(canNam, chiNam, monthCan, monthChi, canChiNgay[0], canChiNgay[1]);

        // Determine weak element
        weakElement = calculator.findWeakElement(elementCount);

        // Thêm kết quả vào biến result
        result += "Ngày dương: " + day + "/" + month + "/" + year + "\n";
        result += "Ngày âm: " + lunarDate.getDay() + "/" + lunarDate.getMonth() + "/" + lunarDate.getYear() + "\n";
        result += "Ngày âm lịch " + lunarDate.getDay() + "/" + lunarDate.getMonth() + "/" + lunarDate.getYear() + " là ngày " + canChiNgay[0] + " " + canChiNgay[1] + "\n";
        result += "Thiên Can năm: " + canNam + "\n";
        result += "Địa Chi năm: " + chiNam + "\n";
        result += "Thiên Can tháng: " + monthCan + "\n";
        result += "Địa Chi tháng: " + monthChi + "\n";
        result += "Số lần xuất hiện của ngũ hành:\n";
        for (Map.Entry<String, Integer> entry : elementCount.entrySet()) {
            result += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        result += "Mệnh khuyết: " + weakElement + "\n";

        return result;
    }
    public static int INT(double x) {
        return (int) Math.floor(x);
    }

    public static int jdFromDate(int dd, int mm, int yy) {
        int a = INT((14 - mm) / 12.0);
        int y = yy + 4800 - a;
        int m = mm + 12 * a - 3;
        int jd = dd + INT((153 * m + 2) / 5.0) + 365 * y + INT(y / 4.0) - INT(y / 100.0) + INT(y / 400.0) - 32045;
        if (jd < 2299161) {
            jd = dd + INT((153 * m + 2) / 5.0) + 365 * y + INT(y / 4.0) - 32083;
        }
        return jd;
    }

    public static int[] jdToDate(int jd) {
        int a, b, c;
        if (jd > 2299160) {
            a = jd + 32044;
            b = INT((4 * a + 3) / 146097.0);
            c = a - INT((b * 146097) / 4.0);
        } else {
            b = 0;
            c = jd + 32082;
        }
        int d = INT((4 * c + 3) / 1461.0);
        int e = c - INT((1461 * d) / 4.0);
        int m = INT((5 * e + 2) / 153.0);
        int day = e - INT((153 * m + 2) / 5.0) + 1;
        int month = m + 3 - 12 * INT(m / 10.0);
        int year = b * 100 + d - 4800 + INT(m / 10.0);
        return new int[]{day, month, year};
    }

    public static int getNewMoonDay(int k, double timeZone) {
        double T = k / 1236.85;
        double T2 = T * T;
        double T3 = T2 * T;
        double dr = Math.PI / 180;
        double Jd1 = 2415020.75933 + 29.53058868 * k + 0.0001178 * T2 - 0.000000155 * T3;
        Jd1 = Jd1 + 0.00033 * Math.sin((166.56 + 132.87 * T - 0.009173 * T2) * dr);
        double M = 359.2242 + 29.10535608 * k - 0.0000333 * T2 - 0.00000347 * T3;
        double Mpr = 306.0253 + 385.81691806 * k + 0.0107306 * T2 + 0.00001236 * T3;
        double F = 21.2964 + 390.67050646 * k - 0.0016528 * T2 - 0.00000239 * T3;
        double C1 = (0.1734 - 0.000393 * T) * Math.sin(M * dr) + 0.0021 * Math.sin(2 * dr * M);
        C1 = C1 - 0.4068 * Math.sin(Mpr * dr) + 0.0161 * Math.sin(dr * 2 * Mpr);
        C1 = C1 - 0.0004 * Math.sin(dr * 3 * Mpr);
        C1 = C1 + 0.0104 * Math.sin(dr * 2 * F) - 0.0051 * Math.sin(dr * (M + Mpr));
        C1 = C1 - 0.0074 * Math.sin(dr * (M - Mpr)) + 0.0004 * Math.sin(dr * (2 * F + M));
        C1 = C1 - 0.0004 * Math.sin(dr * (2 * F - M)) - 0.0006 * Math.sin(dr * (2 * F + Mpr));
        C1 = C1 + 0.0010 * Math.sin(dr * (2 * F - Mpr)) + 0.0005 * Math.sin(dr * (2 * Mpr + M));
        double deltat;
        if (T < -11) {
            deltat = 0.001 + 0.000839 * T + 0.0002261 * T2 - 0.00000845 * T3 - 0.000000081 * T * T3;
        } else {
            deltat = -0.000278 + 0.000265 * T + 0.000262 * T2;
        }
        double JdNew = Jd1 + C1 - deltat;
        return INT(JdNew + 0.5 + timeZone / 24);
    }

    public static int getSunLongitude(int jdn, double timeZone) {
        double T = (jdn - 2451545.5 - timeZone / 24) / 36525;
        double T2 = T * T;
        double dr = Math.PI / 180;
        double M = 357.52910 + 35999.05030 * T - 0.0001559 * T2 - 0.00000048 * T * T2;
        double L0 = 280.46645 + 36000.76983 * T + 0.0003032 * T2;
        double DL = (1.914600 - 0.004817 * T - 0.000014 * T2) * Math.sin(dr * M);
        DL = DL + (0.019993 - 0.000101 * T) * Math.sin(dr * 2 * M) + 0.000290 * Math.sin(dr * 3 * M);
        double L = L0 + DL;
        L = L * dr;
        L = L - Math.PI * 2 * (INT(L / (Math.PI * 2)));
        return INT(L / Math.PI * 6);
    }

    public static int getLunarMonth11(int yy, double timeZone) {
        int k, off, nm, sunLong;
        off = jdFromDate(31, 12, yy) - 2415021;
        k = INT(off / 29.530588853);
        nm = getNewMoonDay(k, timeZone);
        sunLong = getSunLongitude(nm, timeZone);
        if (sunLong >= 9) {
            nm = getNewMoonDay(k - 1, timeZone);
        }
        return nm;
    }

    public static int getLeapMonthOffset(int a11, double timeZone) {
        int k, last, arc, i;
        k = INT((a11 - 2415021.076998695) / 29.530588853 + 0.5);
        last = 0;
        i = 1;
        arc = getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone);
        do {
            last = arc;
            i++;
            arc = getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone);
        } while (arc != last && i < 14);
        return i - 1;
    }

    public static int[] convertSolar2Lunar(int dd, int mm, int yy, double timeZone) {
        int dayNumber = jdFromDate(dd, mm, yy);
        int k = INT((dayNumber - 2415021.076998695) / 29.530588853);
        int monthStart = getNewMoonDay(k + 1, timeZone);
        if (monthStart > dayNumber) {
            monthStart = getNewMoonDay(k, timeZone);
        }
        int a11 = getLunarMonth11(yy, timeZone);
        int b11 = a11;
        int lunarYear;
        if (a11 >= monthStart) {
            lunarYear = yy;
            a11 = getLunarMonth11(yy - 1, timeZone);
        } else {
            lunarYear = yy + 1;
            b11 = getLunarMonth11(yy + 1, timeZone);
        }
        int lunarDay = dayNumber - monthStart + 1;
        int diff = INT((monthStart - a11) / 29);
        int lunarLeap = 0;
        int lunarMonth = diff + 11;
        if (b11 - a11 > 365) {
            int leapMonthDiff = getLeapMonthOffset(a11, timeZone);
            if (diff >= leapMonthDiff) {
                lunarMonth = diff + 10;
                if (diff == leapMonthDiff) {
                    lunarLeap = 1;
                }
            }
        }
        if (lunarMonth > 12) {
            lunarMonth = lunarMonth - 12;
        }
        if (lunarMonth >= 11 && diff < 4) {
            lunarYear -= 1;
        }
        return new int[]{lunarDay, lunarMonth, lunarYear, lunarLeap};
    }

    public static int[] convertLunar2Solar(int lunarDay, int lunarMonth, int lunarYear, int lunarLeap, double timeZone) {
        int k, a11, b11, off, leapOff, leapMonth, monthStart;
        if (lunarMonth < 11) {
            a11 = getLunarMonth11(lunarYear - 1, timeZone);
            b11 = getLunarMonth11(lunarYear, timeZone);
        } else {
            a11 = getLunarMonth11(lunarYear, timeZone);
            b11 = getLunarMonth11(lunarYear + 1, timeZone);
        }
        off = lunarMonth - 11;
        if (off < 0) {
            off += 12;
        }
        if (b11 - a11 > 365) {
            leapOff = getLeapMonthOffset(a11, timeZone);
            leapMonth = leapOff - 2;
            if (leapMonth < 0) {
                leapMonth += 12;
            }
            if (lunarLeap != 0 && lunarMonth != leapMonth) {
                return new int[]{0, 0, 0};
            } else if (lunarLeap != 0 || off >= leapOff) {
                off += 1;
            }
        }
        k = INT(0.5 + (a11 - 2415021.076998695) / 29.530588853);
        monthStart = getNewMoonDay(k + off, timeZone);
        return jdToDate(monthStart + lunarDay - 1);
    }
}
