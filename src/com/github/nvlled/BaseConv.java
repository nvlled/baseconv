package com.github.nvlled;

/**
 *
 * @author nvlled
 */
public class BaseConv {

    public static String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()[]:<>";

    public int valueOf(char c) {
        return digits.indexOf(c + "");
    }
    
    public boolean isValid(int base, String num) {
        for(char c: num.toCharArray())
        {
            if (digits.indexOf(c+"") >= base)
                return false;
        }
        return true;
    }

    public double toDecimal(int base, String num) {
        String[] fields = num.split("\\.");
        String left;
        if (fields.length == 0)
            left = num;
        else
            left = fields[0];

        double result = 0;
        int len = left.length();
        for (int i = 0; i < len; i++) {
            int n = valueOf(left.charAt(i));
            int exp = len - 1 - i;
            result += n * (int) Math.pow(base, exp);
        }

        if (fields.length < 2) {
            return result;
        }

        String right = fields[1];
        len = right.length();
        for (int i = 0; i < len; i++) {
            int n = valueOf(right.charAt(i));
            int exp = -(i + 1);
            double m = Math.pow(base, exp);
            result += n * m;
        }

        return result;
    }

    public String fromDecimal(int base, double decimal) {
        String[] fields = String.format("%f", decimal).split("\\.");
        long n = Long.parseLong(fields[0]);
        
        String result = "";
        while (n > 0) {
            result = digits.charAt((int) (n%base)) + result;
            n /= base;
        }
        if (fields.length < 2) 
            return result;
        
        double d = 0.00000000000001;
        double m = Double.parseDouble("0."+fields[1]);
        
        int limit = 20 ;
        String sub = "";
        while (m > d) {
            int i = (int) Math.floor(m * base);
            sub += digits.charAt(i);
            m = (m % (1.0/base)) * base;
            limit--;
            if (limit <= 0)
                break;
        }
        if (sub.length() > 0)
            result += "."+sub;
        
        return result;
    }
}
