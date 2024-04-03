package com.pichillilorenzo.flutter_inappwebview.types;

public enum PreferredContentModeOptionType {
    RECOMMENDED(0),
    MOBILE(1),
    DESKTOP(2);
    
    private final int value;

    private PreferredContentModeOptionType(int i11) {
        this.value = i11;
    }

    public static PreferredContentModeOptionType fromValue(int i11) {
        for (PreferredContentModeOptionType preferredContentModeOptionType : values()) {
            if (i11 == preferredContentModeOptionType.toValue()) {
                return preferredContentModeOptionType;
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
