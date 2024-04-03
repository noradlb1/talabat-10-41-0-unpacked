package com.instabug.library.util;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.settings.SettingsManager;

public class PlaceHolderUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r2 = r0.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPlaceHolder(com.instabug.library.InstabugCustomTextPlaceHolder.Key r2, java.lang.String r3) {
        /*
            com.instabug.library.settings.SettingsManager r0 = com.instabug.library.settings.SettingsManager.getInstance()
            com.instabug.library.InstabugCustomTextPlaceHolder r0 = r0.getCustomPlaceHolders()
            if (r0 != 0) goto L_0x000b
            return r3
        L_0x000b:
            java.lang.String r2 = r0.get(r2)
            if (r2 == 0) goto L_0x001e
            java.lang.String r0 = r2.trim()
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001e
            return r2
        L_0x001e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.PlaceHolderUtils.getPlaceHolder(com.instabug.library.InstabugCustomTextPlaceHolder$Key, java.lang.String):java.lang.String");
    }

    @NonNull
    public static String getPlaceHolder(@Nullable Context context, InstabugCustomTextPlaceHolder.Key key, @StringRes int i11) {
        String str;
        InstabugCustomTextPlaceHolder customPlaceHolders = SettingsManager.getInstance().getCustomPlaceHolders();
        if (customPlaceHolders != null && (str = customPlaceHolders.get(key)) != null && !str.trim().isEmpty()) {
            return str;
        }
        if (context == null) {
            return "";
        }
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), i11, context);
    }
}
