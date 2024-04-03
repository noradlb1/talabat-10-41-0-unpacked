package com.google.android.gms.internal.gtm;

import android.content.DialogInterface;
import android.content.Intent;

final class zzfc implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzfb zzaop;

    public zzfc(zzfb zzfb) {
        this.zzaop = zzfb;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        String str;
        String str2;
        String packageName = this.zzaop.zzaon.getPackageName();
        Intent launchIntentForPackage = this.zzaop.zzaon.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            String valueOf = String.valueOf(packageName);
            if (valueOf.length() != 0) {
                str2 = "Invoke the launch activity for package name: ".concat(valueOf);
            } else {
                str2 = new String("Invoke the launch activity for package name: ");
            }
            zzev.zzaw(str2);
            this.zzaop.zzaon.startActivity(launchIntentForPackage);
            return;
        }
        String valueOf2 = String.valueOf(packageName);
        if (valueOf2.length() != 0) {
            str = "No launch activity found for package name: ".concat(valueOf2);
        } else {
            str = new String("No launch activity found for package name: ");
        }
        zzev.zzac(str);
    }
}
