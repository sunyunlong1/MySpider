package TestBigDecimal;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIGlobalBinding;

import java.math.BigDecimal;

public class test {

    public static void main(String[] args) {
        BigDecimal p1 = BigDecimal.valueOf(0.00);
        BigDecimal p2 = BigDecimal.valueOf(0.00);
        BigDecimal p3 = new BigDecimal("0.0");
        BigDecimal p4 = new BigDecimal(0.00);

        //System.out.println(divide(p1,p3));
        System.out.println(Double.toString(0.00));
        System.out.println(p1.equals(p2));
        System.out.println(p3.equals(p1));
        System.out.println(p3.compareTo(p1));
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p3.compareTo(p4));
        System.out.println(p3.equals(p4));
        System.out.println( p3.equals(BigDecimal.ZERO));
        System.out.println(p3.compareTo(BigDecimal.ZERO));
    }

    private static BigDecimal divide(BigDecimal p1,BigDecimal p2){
        if (p1 == null || p2 == null || p2.equals(BigDecimal.ZERO)){
            return BigDecimal.ZERO;
        }
        return p1.divide(p2);
    }
}
