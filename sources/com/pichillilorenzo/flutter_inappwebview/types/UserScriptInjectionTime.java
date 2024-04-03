package com.pichillilorenzo.flutter_inappwebview.types;

public enum UserScriptInjectionTime {
    AT_DOCUMENT_START(0),
    AT_DOCUMENT_END(1);
    
    private final int value;

    private UserScriptInjectionTime(int i11) {
        this.value = i11;
    }

    public static UserScriptInjectionTime fromValue(int i11) {
        for (UserScriptInjectionTime userScriptInjectionTime : values()) {
            if (i11 == userScriptInjectionTime.toValue()) {
                return userScriptInjectionTime;
            }
        }
        throw new IllegalArgumentException("No enum constant: " + i11);
    }

    public boolean equalsValue(int i11) {
        return this.value == i11;
    }

    public int toValue() {
        return this.value;
    }
}
