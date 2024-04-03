package com.huawei.wearengine.device;

public enum CommandPriorityType {
    COMMAND_PRIORITY_NORMAL(1),
    COMMAND_PRIORITY_URGENT(2);
    
    private static final int NORMAL_COMMAND_PRIORITY = 1;
    private static final int URGENT_COMMAND_PRIORITY = 2;
    private int mType;

    private CommandPriorityType(int i11) {
        this.mType = i11;
    }

    public static CommandPriorityType valueOf(int i11) {
        if (i11 == 1) {
            return COMMAND_PRIORITY_NORMAL;
        }
        if (i11 != 2) {
            return null;
        }
        return COMMAND_PRIORITY_URGENT;
    }

    public int value() {
        return this.mType;
    }
}
