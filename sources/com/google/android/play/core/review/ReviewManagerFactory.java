package com.google.android.play.core.review;

import android.content.Context;
import androidx.annotation.NonNull;

public class ReviewManagerFactory {
    private ReviewManagerFactory() {
    }

    @NonNull
    public static ReviewManager create(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new zzd(new zzi(context));
    }
}
