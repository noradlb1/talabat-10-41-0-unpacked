package com.instabug.library.instacapture;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

public final class a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f34371a;

    @Nullable
    public Activity a() {
        WeakReference weakReference = this.f34371a;
        if (weakReference == null) {
            return null;
        }
        Activity activity = (Activity) weakReference.get();
        if (!a(activity)) {
            return null;
        }
        return activity;
    }

    public void b(@NonNull Activity activity) {
        this.f34371a = new WeakReference(activity);
    }

    private boolean a(@Nullable Activity activity) {
        return activity != null && !activity.isFinishing() && !activity.isDestroyed();
    }
}
