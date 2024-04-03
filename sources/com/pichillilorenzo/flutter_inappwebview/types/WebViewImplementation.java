package com.pichillilorenzo.flutter_inappwebview.types;

public enum WebViewImplementation {
    NATIVE(0);
    
    private final int value;

    private WebViewImplementation(int i11) {
        this.value = i11;
    }

    public static WebViewImplementation fromValue(int i11) {
        for (WebViewImplementation webViewImplementation : values()) {
            if (i11 == webViewImplementation.value) {
                return webViewImplementation;
            }
        }
        throw new IllegalArgumentException("No enum constant: " + i11);
    }

    public boolean equalsValue(int i11) {
        return this.value == i11;
    }

    public int rawValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
