package com.instabug.library.util;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

public abstract class l {
    public static void a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        audioManager.setMode(0);
        if (!audioManager.isMicrophoneMute()) {
            audioManager.setMicrophoneMute(true);
        }
    }

    public static void b(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        audioManager.setMode(0);
        if (audioManager.isMicrophoneMute()) {
            audioManager.setMicrophoneMute(false);
        }
    }

    public static boolean a() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        return currentActivity != null && ContextCompat.checkSelfPermission(currentActivity, "android.permission.RECORD_AUDIO") == 0;
    }
}
