
package com.eyesfree.weibo.base;

/**
 * 常量
 */
public class Constant {

    public static String JWT_AUTH_HEADER = "Authorization";
    public static String CODE_LOGINFAIL = "401001";

    public static String CODE_AUTH = "401";
    public static String MSG_AUTH = "鉴权失败";

    public static String CODE_FORBIDDEN = "403";
    public static String MSG_FORBIDDEN = "无权限操作";

    public static String CODE_VALIDFAIL = "401002";
    public static String MSG_VALIDFAIL = "数据校验失败";

    public static String CODE_DATA_NOTFOUND= "404001";
    public static String MSG_DATA_NOTFOUND= "数据不存在";

    public static String CODE_DATA_FOUND= "404003";
    public static String MSG_DATA_FOUND= "数据已存在";

    public static String CODE_NO_MINBU= "404002";
    public static String MSG_NO_MINBU= "当前列表无法查看";

    public static String CODE_ERROR= "500001";
    public static String MSG_ERROR= "网络错误，请稍后再试";


}
