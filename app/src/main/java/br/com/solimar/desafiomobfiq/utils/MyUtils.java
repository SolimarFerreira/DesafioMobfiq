package br.com.solimar.desafiomobfiq.utils;

import java.text.DecimalFormat;

/**
 * Created by Solimar on 06/07/2017.
 */

public class MyUtils {
    private static final String priceFormat = "#.00";

    public static String formatPrice(Double price){
        return new DecimalFormat(priceFormat).format(price);
    }
}
