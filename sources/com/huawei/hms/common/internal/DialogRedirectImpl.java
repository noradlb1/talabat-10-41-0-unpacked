package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f48171a;

    /* renamed from: b  reason: collision with root package name */
    private final int f48172b;

    /* renamed from: c  reason: collision with root package name */
    private final Intent f48173c;

    public DialogRedirectImpl(Intent intent, Activity activity, int i11) {
        this.f48173c = intent;
        this.f48171a = activity;
        this.f48172b = i11;
    }

    public final void redirect() {
        Activity activity;
        Intent intent = this.f48173c;
        if (intent != null && (activity = this.f48171a) != null) {
            activity.startActivityForResult(intent, this.f48172b);
        }
    }
}
