package com.instabug.library.util;

import android.content.Context;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class InstabugDeprecationLogger {
    private static InstabugDeprecationLogger INSTANCE = null;
    private static final String PREFIX_SECTION = "#section-";
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public static String f52051a = "https://docs.instabug.com/docs/android-sdk-8-6-migration-guide";

    @Retention(RetentionPolicy.SOURCE)
    public @interface MigrationSection {
        public static final int METHOD_SET_CHATS_STATE = 19;
        public static final int METHOD_SHOW_CHATS = 18;
    }

    private InstabugDeprecationLogger() {
    }

    public static InstabugDeprecationLogger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InstabugDeprecationLogger();
        }
        return INSTANCE;
    }

    private String getSection(int i11) {
        return i11 != 18 ? i11 != 19 ? "" : "setstate" : "show";
    }

    private static void setBaseUrl(String str) {
        if (str != null && str.trim().length() > 0) {
            f52051a = str;
        }
    }

    @VisibleForTesting
    public String a(int i11) {
        return f52051a + PREFIX_SECTION + getSection(i11);
    }

    public void log(int i11) {
        Context applicationContext;
        if (Instabug.isBuilt() && Instabug.isEnabled() && (applicationContext = Instabug.getApplicationContext()) != null) {
            if (!((applicationContext.getApplicationInfo().flags & 2) != 0)) {
                return;
            }
            if (i11 == 19 || i11 == 18) {
                Log.i("INSTABUG", "\n\nIn this release, we’re improving the in-app communication experience. Now, your end user will have a unified experience while sending you a report independently from its type. Whether it is a bug, improvement, or question, they’ll see the same experience.\n\nThe Chats class and its methods have been deprecated, and while they still function, they will be completely removed in a future release. For more details about this API’s replacement, check the docs here: " + a(i11) + ".\n\nIf you have any questions please reach out to us through contactus@instabug.com.");
            }
        }
    }

    public void log(String str) {
        Context applicationContext;
        if (Instabug.isBuilt() && Instabug.isEnabled() && (applicationContext = Instabug.getApplicationContext()) != null) {
            if ((applicationContext.getApplicationInfo().flags & 2) != 0) {
                Log.i("INSTABUG", str);
            }
        }
    }
}
