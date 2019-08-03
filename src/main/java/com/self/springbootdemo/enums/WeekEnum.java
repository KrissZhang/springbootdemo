package com.self.springbootdemo.enums;

/**
 * 周枚举
 * @author zp
 */
public enum WeekEnum {

    /**
     * 星期一
     */
    MONDAY(1,"星期一"),

    /**
     * 星期二
     */
    TUESDAY(2,"星期二"),

    /**
     * 星期三
     */
    WEDNESDAY(3,"星期三"),

    /**
     * 星期四
     */
    THURSDAY(4,"星期四"),

    /**
     * 星期五
     */
    FRIDAY(5,"星期五"),

    /**
     * 星期六
     */
    SATURDAY(6,"星期六"),

    /**
     * 星期天
     */
    SUNDAY(7,"星期天");

    /**
     * 枚举值
     */
    private Integer value;

    /**
     * 枚举描述文本
     */
    private String text;

    WeekEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    /**
     * 判断枚举是否包含指定值
     * @param value 指定值
     * @return 判断结果
     */
    public static boolean contains(Integer value) {
        boolean result = false;
        for (WeekEnum entity: WeekEnum.values()){
            if(entity.getValue().equals(value)){
                result = true;
                break;
            }
        }

        return result;
    }

}
