package com.github.nvlled;

/**
 *
 * @author nvlled
 */
public class Main {

    public static void main(String[] args) {
        BaseConv conv = new BaseConv();
        double x = conv.toDecimal(16, "1111.1");
        System.out.println("x: " + x);
        //System.out.println("binary: " + conv.fromDecimal(2, x));
        //System.out.println("octal: " + conv.fromDecimal(8, x));
        System.out.println("decimal: " + conv.fromDecimal(10, x));
        //System.out.println("hexadec: " + conv.fromDecimal(16, x));
//        System.out.println(x);
//        System.out.println(s);
//        System.out.println(conv.fromDecimal(2, 123.45));
//        
//        System.out.println(Long.parseLong("999999999999999999"));
        ConversionForm form = new ConversionForm();
        form.setVisible(true);
    }

}
