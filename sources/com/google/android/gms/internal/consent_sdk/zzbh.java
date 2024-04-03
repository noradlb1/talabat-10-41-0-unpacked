package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.content.Intent;

public final class zzbh extends ContextWrapper {
    private Activity zza;

    public zzbh(Application application) {
        super(application);
    }

    public final Object getSystemService(String str) {
        Activity activity = this.zza;
        if (activity != null) {
            return activity.getSystemService(str);
        }
        return super.getSystemService(str);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zza;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        super.startActivity(intent);
    }

    public final void zza(Activity activity) {
        this.zza = activity;
    }
}
