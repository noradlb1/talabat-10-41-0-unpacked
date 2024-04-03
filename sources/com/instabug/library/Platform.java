package com.instabug.library;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.RUNTIME)
public @interface Platform {
    public static final int ANDROID = 2;
    public static final int CORDOVA = 6;
    public static final int FLUTTER = 8;
    public static final int RN = 4;
    public static final int UNITY = 7;
    public static final int XAMARIN = 5;
}
