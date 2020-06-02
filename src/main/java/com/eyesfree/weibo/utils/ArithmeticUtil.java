package com.eyesfree.weibo.utils;

import java.math.BigDecimal;

/**
 * 
 * 数学表达式工具类
 * 
 * @author lujin
 * @since 2017年11月12日
 *
 */
public class ArithmeticUtil {
    /* 
     * 小数精确的位数 
     */ 
    private static final int DEF_DIV_SCALE = 10; 

    /** 
     * 提供精确的加法运算。 
     * 
     * @param added
     *            加数 
     * @param  augend
     *            被加数 
     * @return 两个参数的和 
     */ 
    public static double add(double added, double augend) { 
    	BigDecimal addedBigDecimal = new BigDecimal(Double.toString(added));
        BigDecimal augendBigDecimal = new BigDecimal(Double.toString(augend));
        return addedBigDecimal.add(augendBigDecimal).doubleValue(); 
    } 
   
    /** 
     * 提供精确的加法运算。 
     * 
     * @param added 
     *            被加数 
     * @param augend 
     *            加数 
     * @return 两个参数的和 
     */ 
    public static BigDecimal add(String added, String augend) {
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        return addedBigDecimal.add(augendBigDecimal); 
    }
    
    /**
     * 条件运算
     * @param condition1
     * 			第一个条件
     * @param condition2
     * 			第二个条件
     * @return
     */
    public static BigDecimal condition(String condition1, String condition2){
    	Double cond1 = Double.valueOf(condition1);
    	Double cond2 = Double.valueOf(condition2);
    	BigDecimal result = new BigDecimal(cond1 < cond2 ? cond1 : cond2);
    	return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * BigDecimal两数相加
     * @param added
     * @param augend
     * @return
     */
    public static BigDecimal add(BigDecimal added, BigDecimal augend) {
        return added.add(augend); 
    }
    
    /** 
     * 提供精确的加法运算。 
     * 
     * @param added 
     *            被加数 
     * @param augend 
     *            加数 
     * @return 多个参数求和 
     */ 
    public static BigDecimal add(String... addeds) {
    	BigDecimal sum = BigDecimal.ZERO;
    	for (int i = 0; i < addeds.length; i++) {
    		if(addeds[i] != null && !"".equals(addeds[i])){
    			sum = sum.add(new BigDecimal(addeds[i]));
    		}
		}
    	return sum;
    } 
   
    /** 
     * 提供精确的加法运算。 String 
     * 
     * @param added 
     *            被加数 
     * @param augend 
     *            加数 
     * @return 两个参数的和 
     */ 
    public static String strAdd(String added, String augend, int scale) {
        if (scale < 0) { 
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } 
        
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.add(augendBigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    } 
    
    /**
     * 多个加数的和减去被减数
     * 
     * @param subed
     * 		减数
     * 
     * @param addeds
     * 		加数
     * 
     * @return 运算完的值
     */
    public static BigDecimal addSub(String subed, String...addeds){
    	BigDecimal sum = BigDecimal.ZERO;
    	BigDecimal sub = new BigDecimal(subed);
    	for (int i = 0; i < addeds.length; i++) {
			sum = sum.add(new BigDecimal(addeds[i]));
		}
    	return sum.subtract(sub);
    }
        
    /**
     * 两个加数，多个被减数
     * @param added
     * 			加数
     * @param augend
     * 			加数
     * @param subed
     * 			被减数
     * @return  和
     */
    public static BigDecimal subAdd(String added, String augend, String...subed){
    	BigDecimal sum = add(added, augend);
    	BigDecimal sub  = BigDecimal.ZERO;
    	for (int i = 0; i < subed.length; i++) {
			sub = sub.add(new BigDecimal(subed[i]));
		}
		return sum.subtract(sub);
    }
    
    /**
     * 两个减数,多个加数
     * @param subed
     * @param subeds
     * @param added
     * @return
     */
    public static BigDecimal moreAdd(String subed, String subeds, String...added){
    	BigDecimal sub = add(subed,  subeds);
    	BigDecimal sum  = BigDecimal.ZERO;
    	for (int i = 0; i < added.length; i++) {
			sum = sum.add(new BigDecimal(added[i]));
		}
		return sum.subtract(sub);
    }
    
    /** 
     * 提供精确的减法运算。 
     * 
     * @param added 
     *            被减数 
     * @param augend 
     *            减数 
     * @return 两个参数的差 
     */ 
    public static double sub(double added, double augend) { 
    	
        BigDecimal addedBigDecimal = new BigDecimal(Double.toString(added));
        BigDecimal augendBigDecimal = new BigDecimal(Double.toString(augend));
        
        return addedBigDecimal.subtract(augendBigDecimal).doubleValue(); 
    } 
    
    
    /** 
     * 提供精确的减法运算。 
     * 
     * @param added 
     *            被减数 
     * @param augend 
     *            减数 
     * @return 两个参数的差 
     */ 
    public static BigDecimal sub(BigDecimal added, BigDecimal augend) {
        return added.subtract(augend); 
    } 
   
    /** 
     * 提供精确的减法运算。 
     * 
     * @param added 
     *            被减数 
     * @param augend 
     *            减数 
     * @return 两个参数的差 
     */ 
    public static BigDecimal sub(String added, String augend) {
    	
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.subtract(augendBigDecimal); 
    } 
    
    /**
     * 多个数相减
     * @param subed
     * @return
     */
    public static BigDecimal sub(String...subed){
    	BigDecimal sum = new BigDecimal(subed[0]);
    	for (int i = 1; i < subed.length; i++) {
    		sum = sum.subtract(new BigDecimal(subed[i]));
		}
		return sum;
    }
    
    /**
     * 多个数相减之后的绝对值
     * 
     * @param subed
     * 			减数
     * @return
     * 			差的绝对值
     */
    public static BigDecimal abs(String...subed){
    	BigDecimal sum = new BigDecimal(subed[0]);
    	for (int i = 1; i < subed.length; i++) {
    		sum = sum.subtract(new BigDecimal(subed[i]));
		}
		return sum.abs();
    }
    
    /** 
     * 对一个数字取精度 
     * @param v 
     * @param scale 
     * @return 
     */ 
    public static BigDecimal round(String v, int scale) {
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = BigDecimal.ONE;

        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
    } 
   
    /** 
     * 提供精确的减法运算。String 
     * 
     * @param added 
     *            被减数 
     * @param augend 
     *            减数 
     *            
     * @return 两个参数的差 
     */ 
    public static String strSub(String added, String augend, int scale) {
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.subtract(augendBigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    } 
    /** 
     * 提供精确的乘法运算。 
     * 
     * @param added 
     *            被乘数 
     * @param augend 
     *            乘数 
     * @return 两个参数的积 
     */ 
    public static double mul(double added, double augend) { 
        BigDecimal addedBigDecimal = new BigDecimal(Double.toString(added));
        BigDecimal augendBigDecimal = new BigDecimal(Double.toString(augend));
        return addedBigDecimal.multiply(augendBigDecimal).doubleValue(); 
    } 
   
    /** 
     * 提供精确的乘法运算。 
     * 
     * @param added 
     *            被乘数 
     * @param augend 
     *            乘数 
     * @return 两个参数的积 
     */ 
    public static BigDecimal mul(String added, String augend) {
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        return addedBigDecimal.multiply(augendBigDecimal); 
    } 
       
    /** 
     * 提供精确的乘法运算。 保留scale 位小数 
     * 
     * @param added 
     *            被乘数 
     * @param augend 
     *            乘数 
     * @return 两个参数的积 
     */ 
    public static double mul2(double added, double augend,int scale) { 
        BigDecimal addedBigDecimal = new BigDecimal(Double.toString(added));
        BigDecimal augendBigDecimal = new BigDecimal(Double.toString(augend));
        return  round(addedBigDecimal.multiply(augendBigDecimal).doubleValue(),scale); 
    } 
   
    /** 
     * 提供精确的乘法运算。 保留scale 位小数 String 
     * 
     * @param added 
     *            被乘数 
     * @param augend 
     *            乘数 
     * @return 两个参数的积 
     */ 
    public static String strMul2(String added, String augend, int scale) {
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        return addedBigDecimal.multiply(augendBigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    } 
    /** 
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。 
     * 
     * @param added 
     *            被除数 
     * @param augend 
     *            除数 
     * @return 两个参数的商 
     */ 
    public static BigDecimal div(String added, String augend) {
        return div(added, augend, DEF_DIV_SCALE); 
    } 
   
    /** 
     * 提供精确的乘法运算。 
     * 
     * @param added 
     *            被除数 
     * @param rate 
     *            税率or预征率 
     * @return 两个参数的积 
     */ 
    public static BigDecimal superDiv(String added, String rate) {
    	BigDecimal addedBigDecimal = new BigDecimal(added);
    	BigDecimal rateBigDecimal = new BigDecimal(rate);
    	BigDecimal resultBigDecimal = addedBigDecimal.divide(add("1", rate),DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).multiply(rateBigDecimal);
        return resultBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    /** 
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。 
     * 
     * @param added 
     *            被除数 
     * @param augend 
     *            除数 
     * @return 两个参数的商 
     */ 
    public static double div(double added, double augend) { 
        return div(added, augend, DEF_DIV_SCALE); 
    } 

    /** 
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。 
     * 
     * @param added 
     *            被除数 
     * @param augend 
     *            除数 
     * @param scale 
     *            表示需要精确到小数点以后几位。 
     * @return 两个参数的商 
     */ 
    public static double div(double added, double augend, int scale) { 
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        
        BigDecimal addedBigDecimal = new BigDecimal(Double.toString(added));
        BigDecimal augendBigDecimal = new BigDecimal(Double.toString(augend));
        
        return addedBigDecimal.divide(augendBigDecimal, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    } 
   
    /** 
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。 
     * 
     * @param added 
     *            被除数 
     * @param augend 
     *            除数 
     * @param scale 
     *            表示需要精确到小数点以后几位。 
     * @return 两个参数的商 
     */ 
    public static BigDecimal div(String added, String augend, int scale) {
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.divide(augendBigDecimal, scale, BigDecimal.ROUND_HALF_UP);
    } 

    /** 
     * 精确的除法运算。除不尽时，由scale参数指 定精度 四舍五入。string 
     * 
     * @param added 
     *            被除数 
     * @param augend 
     *            除数 
     * @param scale 
     *            表示需要精确到小数点以后几位。 
     * @return 两个参数的商 
     */ 
    public static String strDiv(String added, String augend, int scale) {
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.divide(augendBigDecimal, scale, BigDecimal.ROUND_HALF_UP).toString();
    } 
   
    /** 
     * 精确的除法运算。除不尽时，由scale参数指 定精度 四舍五入。string 
     * 
     * @param added 
     *            被除数 
     * @param augend 
     *            除数 
     * @param scale 
     *            表示需要精确到小数点以后几位。 
     * @return 两个参数的商 
     */ 
    public static BigDecimal bigDiv(String added, String augend, int scale) {
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.divide(augendBigDecimal, scale, BigDecimal.ROUND_HALF_UP);
    } 
    /** 
     * 取余数  string 
     * @param added 
     * @param augend 
     * @param scale 
     * @return 
     */ 
    public static BigDecimal strRemainder(String added, String augend, int scale){
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.remainder(augendBigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP);
    } 
    /** 
     * 取余数  string 
     * @param added 
     * @param augend 
     * @param scale 
     * @return  string 
     */ 
    public static String strRemainder2Str(String added, String augend, int scale){
        if (scale < 0) { 
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero"); 
        } 
        
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        return addedBigDecimal.remainder(augendBigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    } 
   
    /** 
     * 比较大小 如果added 大于augend 则 返回true 否则false 
     * @param added 
     * @param augend 
     * @return 
     */ 
    public static boolean strcompareTo(String added, String augend){
    	
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        
        int compareFlag = addedBigDecimal.compareTo(augendBigDecimal); 
        
        return (compareFlag > 0)?true:false; 
    } 
   
    /** 
     * 比较大小 如果added 大于等于augend 则 返回true 否则false 
     * @param added 
     * @param augend 
     * @return 
     */ 
    public static boolean strcompareTo2(String added, String augend){
    	
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        int compareFlag = addedBigDecimal.compareTo(augendBigDecimal); 
        
        return (compareFlag >= 0)?true:false; 
    } 
   
    /** 
     * 比较大小 如果added 等于augend 则 返回true 否则false 
     * @param added 
     * @param augend 
     * @return 
     */ 
    public static boolean strcompareToEquals(String added, String augend){
    	if(added == null || "".equals(added) || augend == null || "".equals(augend)){
    		return false;
    	}
        BigDecimal addedBigDecimal = new BigDecimal(added);
        BigDecimal augendBigDecimal = new BigDecimal(augend);
        int compareFlag = addedBigDecimal.compareTo(augendBigDecimal); 

        return (compareFlag == 0)?true:false; 
    } 
    
    /** 
     * 取余数  BigDecimal 
     * @param added 
     * @param augend 
     * @param scale 
     * @return 
     */ 
    public static BigDecimal bigRemainder(BigDecimal added, BigDecimal augend, int scale){
        if (scale < 0) { 
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } 
        return added.remainder(augend).setScale(scale, BigDecimal.ROUND_HALF_UP);
    } 
    
    /** 
     * 提供精确的小数位四舍五入处理。 
     * 
     * @param v 
     *            需要四舍五入的数字 
     * @param scale 
     *            小数点后保留几位 
     * @return 四舍五入后的结果 
     */ 
    public static double round(double v, int scale) { 
        if (scale < 0) { 
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } 
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    } 
   
    /** 
     * 提供精确的小数位四舍五入处理。string 
     * 
     * @param v 
     *            需要四舍五入的数字 
     * @param scale 
     *            小数点后保留几位 
     * @return 四舍五入后的结果 
     */ 
    public static String strRound(String v, int scale) {
    	try{
	        if (scale < 0) { 
	            return v;
	        } 
	        BigDecimal b = new BigDecimal(v);
	        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    	}catch(Exception e){
    		if(v.endsWith("-") && v.length()>0){
    			return "-"+v.substring(0, v.length()-1);
    		}
    		return v;
    	}
    } 
}