package me.look.common.enums;
/**是否删除*/
public enum IsDelete {

    yes("是",1),
    no("否",0);

    private String value;
    private int key;

    IsDelete(String value, int key) {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
