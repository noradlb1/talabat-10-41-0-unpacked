package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzach  reason: invalid package */
final class zzach extends BroadcastReceiver {
    final /* synthetic */ zzacj zza;
    private final String zzb;

    public zzach(zzacj zzacj, String str) {
        this.zza = zzacj;
        this.zzb = str;
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str2 = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzaci zzaci = (zzaci) this.zza.zzd.get(this.zzb);
                if (zzaci == null) {
                    zzacj.zza.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
                    if (matcher.find()) {
                        str = matcher.group();
                    } else {
                        str = null;
                    }
                    zzaci.zze = str;
                    if (str == null) {
                        zzacj.zza.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzac.zzd(zzaci.zzd)) {
                        zzacj.zzd(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
