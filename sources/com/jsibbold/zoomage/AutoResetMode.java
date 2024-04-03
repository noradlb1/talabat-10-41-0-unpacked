package com.jsibbold.zoomage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AutoResetMode {
    public static final int ALWAYS = 2;
    public static final int NEVER = 3;
    public static final int OVER = 1;
    public static final int UNDER = 0;

    public static class Parser {
        public static int fromInt(int i11) {
            int i12 = 1;
            if (i11 != 1) {
                i12 = 2;
                if (i11 != 2) {
                    i12 = 3;
                    if (i11 != 3) {
                        return 0;
                    }
                }
            }
            return i12;
        }
    }
}
