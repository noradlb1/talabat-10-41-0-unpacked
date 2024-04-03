package com.instabug.apm.handler.uitrace.customuitraces;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface a {
    @Nullable
    String a();

    void a(Activity activity, @Nullable Looper looper);

    void a(@NonNull String str, Activity activity, @Nullable Looper looper);

    void c();
}
