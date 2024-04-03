package com.talabat.sign_in_with_facebook;

import com.google.firebase.analytics.FirebaseAnalytics;

public enum FacebookMethod {
    LOGIN(FirebaseAnalytics.Event.LOGIN),
    GET_USER_DATA("getUserData"),
    LOG_OUT("logOut");
    

    /* renamed from: name  reason: collision with root package name */
    private final String f61418name;

    private FacebookMethod(String str) {
        this.f61418name = str;
    }

    public static FacebookMethod fromString(String str) {
        for (FacebookMethod facebookMethod : values()) {
            if (facebookMethod.f61418name.equalsIgnoreCase(str)) {
                return facebookMethod;
            }
        }
        return null;
    }

    public String toString() {
        return this.f61418name;
    }
}
