package com.google.android.gms.internal.gtm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tagmanager.impl.R;

public final class zzfb {
    private final Intent intent;
    private final zzfy zzalj;
    /* access modifiers changed from: private */
    public final Context zzaon;
    private final Context zzaoo;

    public zzfb(Intent intent2, Context context, Context context2, zzfy zzfy) {
        this.zzaon = context;
        this.zzaoo = context2;
        this.intent = intent2;
        this.zzalj = zzfy;
    }

    public final void zzkq() {
        String str;
        try {
            this.zzalj.zzb(this.intent.getData());
            String string = this.zzaoo.getResources().getString(R.string.tagmanager_preview_dialog_title);
            String string2 = this.zzaoo.getResources().getString(R.string.tagmanager_preview_dialog_message);
            String string3 = this.zzaoo.getResources().getString(R.string.tagmanager_preview_dialog_button);
            AlertDialog create = new AlertDialog.Builder(this.zzaon).create();
            create.setTitle(string);
            create.setMessage(string2);
            create.setButton(-1, string3, new zzfc(this));
            create.show();
        } catch (Exception e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Calling preview threw an exception: ".concat(valueOf);
            } else {
                str = new String("Calling preview threw an exception: ");
            }
            zzev.zzav(str);
        }
    }
}
