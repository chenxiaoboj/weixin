package weixin.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author chenx 2018-10-12 17:19
 */
public class ArithUtil {
    private static final int DEF_DIV_SCALE = 10;

    private ArithUtil() {
    }

    public static double add(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1 == null ? 0.0D : v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2 == null ? 0.0D : v2));
        return b1.add(b2).doubleValue();
    }

    public static double add(double... vs) {
        BigDecimal b1 = new BigDecimal(0);
        double[] var6 = vs;
        int var5 = vs.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            double d = var6[var4];
            BigDecimal b2 = new BigDecimal(Double.toString(d));
            b1 = b1.add(b2);
        }

        return b1.doubleValue();
    }

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    public static double mul(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(), scale);
    }

    public static double div(double v1, double v2) {
        return div(v1, v2, 10);
    }

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("参数scale必须为整数为零!");
        } else {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.divide(b2, scale, 4).doubleValue();
        }
    }

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("参数scale必须为整数或零!");
        } else {
            BigDecimal b = new BigDecimal(Double.toString(v));
            BigDecimal one = new BigDecimal("1");
            return b.divide(one, scale, 4).doubleValue();
        }
    }

    public static float convertsToFloat(double v) {
        BigDecimal b = new BigDecimal(v);
        return b.floatValue();
    }

    public static int convertsToInt(double v) {
        BigDecimal b = new BigDecimal(v);
        return b.intValue();
    }

    public static long convertsToLong(double v) {
        BigDecimal b = new BigDecimal(v);
        return b.longValue();
    }

    public static double returnMax(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.max(b2).doubleValue();
    }

    public static double returnMin(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.min(b2).doubleValue();
    }

    public static int compareTo(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.compareTo(b2);
    }

    public static int getDecimals(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String numberString = decimalFormat.format(number);
        return numberString.indexOf(".") > 0 ? numberString.length() - String.valueOf(number).indexOf(".") - 1 : 0;
    }

    public static int getDecimals(float number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String numberString = decimalFormat.format((double)number);
        return numberString.indexOf(".") > 0 ? numberString.length() - String.valueOf(number).indexOf(".") - 1 : 0;
    }

    public static double round(double value, int scale, int roundingMode) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }

    public static double pow(double value, int power) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.pow(power);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }
}
