package concurrent.enums;

import lombok.Getter;

public enum LovEnum {
    one(1,"ck"),two(2,"iu"),three(3,"xue");
    
    @Getter private Integer retCode;
    @Getter private String retMessage;

    LovEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    
    public static LovEnum forEach_Lov(int index){

        LovEnum[] values = LovEnum.values();
        for (LovEnum value : values) {
            if (index==value.getRetCode()){
                return value;
            }
        }
        return null;
    }
}
