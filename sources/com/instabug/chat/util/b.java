package com.instabug.chat.util;

import android.annotation.SuppressLint;
import android.content.Context;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.R;
import com.instabug.library.util.InstabugAppData;
import com.instabug.library.util.PlaceHolderUtils;

public abstract class b {
    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String a() {
        String str;
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            str = "";
        } else {
            str = String.format(applicationContext.getString(R.string.instabug_str_notification_title), new Object[]{new InstabugAppData(applicationContext).getAppName()});
        }
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.CHATS_TEAM_STRING_NAME, str);
    }
}
