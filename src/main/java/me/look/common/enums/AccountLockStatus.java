package me.look.common.enums;

/**账号状态*/
public enum AccountLockStatus {
    normal("正常",0),
    locking("锁定",1);


    private String value;
    private int key;

    AccountLockStatus(String value, int key) {
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

