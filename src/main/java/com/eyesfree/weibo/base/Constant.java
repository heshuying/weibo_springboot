
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

    /**
     * 正则表达式:验证密码(不包含特殊字符) 大小写、特殊字符
     * "^(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@&%#_])[a-zA-Z0-9~!@&%#_]{8,16}$"
     */
    public static final String REGEX_PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z~!@&%#_]{6,16}$";

    /**
     *说明：移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
     * 联通：130、131、132、152、155、156、185、186
     * 电信：133、153、180、189
     * 正则表达式:验证手机号
     */
    public static final String REGEX_MOBILE = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$";

    /**
     * 链群状态 1创单链群； 2体验链群
     */
    public enum EmpRole {
        /**
         * 创单链群
         */
        CD("1"),
        /**
         * 体验链群
         */
        TY("2");

        private String value;

        EmpRole(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 抢单和目标比较： gt:上；lt:下；eq:等于
     */
    public enum CompareResult {
        GT("gt"),
        LT("lt"),
        EQ("eq");

        private String value;

        CompareResult(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    /**
     * 合约因素编码枚举对象
     */
    public enum FactorCode {
        /**
         * 收入
         */
        Incom("T01001","收入"),
        /**
         * 销量
         */
        Sales("T01002","销量"),
        /**
         * 成本
         */
        Cost("T01003","成本"),
        /**
         * 利润率
         */
        Lrl("T02002","利润率"),
        /**
         * 毛利率
         */
        Mll("T02004","毛利率"),
        /**
         *利润额
         */
        Lre("T01017","利润额"),
        /**
         * 高端占比
         */
        HighPercent("T03001","高端占比"),
        /**
         * 低端占比
         */
        LowPercent("T03002","低端占比"),
        /**
         * 低端占比
         */
        MiddPercent("T03003","中端占比");

        private String value;
        private String name;
        FactorCode(String value, String name) {
            this.value = value;
            this.name=name;
        }

        public String getValue() {
            return value;
        }
        public String getName() {
            return name;
        }
    }

}
