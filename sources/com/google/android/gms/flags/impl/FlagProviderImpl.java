package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.flags.zzd;

@DynamiteApi
public class FlagProviderImpl extends zzd {
    private boolean zzu = false;
    private SharedPreferences zzv;

    public boolean getBooleanFlagValue(String str, boolean z11, int i11) {
        if (!this.zzu) {
            return z11;
        }
        return zzb.zza(this.zzv, str, Boolean.valueOf(z11)).booleanValue();
    }

    public int getIntFlagValue(String str, int i11, int i12) {
        if (!this.zzu) {
            return i11;
        }
        return zzd.zza(this.zzv, str, Integer.valueOf(i11)).intValue();
    }

    public long getLongFlagValue(String str, long j11, int i11) {
        if (!this.zzu) {
            return j11;
        }
        return zzf.zza(this.zzv, str, Long.valueOf(j11)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i11) {
        if (!this.zzu) {
            return str2;
        }
        return zzh.zza(this.zzv, str, str2);
    }

    public void init(IObjectWrapper iObjectWrapper) {
        String str;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzu) {
            try {
                this.zzv = zzj.zza(context.createPackageContext("com.google.android.gms", 0));
                this.zzu = true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e11) {
                String valueOf = String.valueOf(e11.getMessage());
                if (valueOf.length() != 0) {
                    str = "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf);
                } else {
                    str = new String("Could not retrieve sdk flags, continuing with defaults: ");
                }
                Log.w("FlagProviderImpl", str);
            }
        }
    }
}
