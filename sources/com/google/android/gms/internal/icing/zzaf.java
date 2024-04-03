package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import java.util.List;

public final class zzaf {
    public static zzx zza(Action action, long j11, String str, int i11) {
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        int i12;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zza());
        Bundle bundle2 = bundle.getBundle("object");
        if (bundle2 != null) {
            String string = bundle2.getString("id");
            if (string != null) {
                uri = Uri.parse(string);
            } else {
                uri = null;
            }
            str4 = bundle2.getString("name");
            str3 = bundle2.getString("type");
            str2 = bundle2.getString("url");
        } else {
            str2 = null;
            uri = null;
            str4 = null;
            str3 = null;
        }
        if (str2 != null) {
            uri2 = Uri.parse(str2);
        } else {
            uri2 = null;
        }
        Intent zzb = zzal.zzb(str, uri2);
        zzf zzb2 = zzx.zzb(zzb, str4, uri, str3, (List<AppIndexApi.AppIndexingLink>) null);
        byte[] byteArray = bundle.getByteArray(".private:ssbContext");
        if (byteArray != null) {
            zzb2.zza(zzk.zza(byteArray));
            bundle.remove(".private:ssbContext");
        }
        String string2 = bundle.getString(".private:accountName");
        if (string2 != null) {
            zzb2.zzd(new Account(string2, "com.google"));
            bundle.remove(".private:accountName");
        }
        boolean z11 = false;
        if (!bundle.containsKey(".private:isContextOnly") || !bundle.getBoolean(".private:isContextOnly")) {
            i12 = 0;
        } else {
            bundle.remove(".private:isContextOnly");
            i12 = 4;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z11 = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zzgf zzb3 = zzb(bundle);
        zzr zzr = new zzr(".private:action");
        zzr.zzb(true);
        zzr.zzd(".private:action");
        zzr.zza("blob");
        zzb2.zza(new zzk(zzb3.zzh(), zzr.zze()));
        zzw zzw = new zzw();
        zzw.zza(zzx.zza(str, zzb));
        zzw.zzb(j11);
        zzw.zzc(i12);
        zzw.zzd(zzb2.zze());
        zzw.zze(z11);
        zzw.zzf(i11);
        return zzw.zzg();
    }

    public static zzgf zzb(Bundle bundle) {
        zzge zza = zzgf.zza();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj instanceof String) {
                zzgg zza2 = zzgh.zza();
                zza2.zzb((String) obj);
                zzgc zza3 = zzgd.zza();
                zza3.zza(next);
                zza3.zzb((zzgh) zza2.zzj());
                zza.zzb((zzgd) zza3.zzj());
            } else if (obj instanceof Bundle) {
                zzgg zza4 = zzgh.zza();
                zza4.zzc(zzb((Bundle) obj));
                zzgc zza5 = zzgd.zza();
                zza5.zza(next);
                zza5.zzb((zzgh) zza4.zzj());
                zza.zzb((zzgd) zza5.zzj());
            } else {
                int i11 = 0;
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    int length = strArr.length;
                    while (i11 < length) {
                        String str = strArr[i11];
                        if (str != null) {
                            zzgg zza6 = zzgh.zza();
                            zza6.zzb(str);
                            zzgc zza7 = zzgd.zza();
                            zza7.zza(next);
                            zza7.zzb((zzgh) zza6.zzj());
                            zza.zzb((zzgd) zza7.zzj());
                        }
                        i11++;
                    }
                } else if (obj instanceof Bundle[]) {
                    Bundle[] bundleArr = (Bundle[]) obj;
                    int length2 = bundleArr.length;
                    while (i11 < length2) {
                        Bundle bundle2 = bundleArr[i11];
                        if (bundle2 != null) {
                            zzgg zza8 = zzgh.zza();
                            zza8.zzc(zzb(bundle2));
                            zzgc zza9 = zzgd.zza();
                            zza9.zza(next);
                            zza9.zzb((zzgh) zza8.zzj());
                            zza.zzb((zzgd) zza9.zzj());
                        }
                        i11++;
                    }
                } else if (obj instanceof Boolean) {
                    zzgg zza10 = zzgh.zza();
                    zza10.zza(((Boolean) obj).booleanValue());
                    zzgc zza11 = zzgd.zza();
                    zza11.zza(next);
                    zza11.zzb((zzgh) zza10.zzj());
                    zza.zzb((zzgd) zza11.zzj());
                } else {
                    String valueOf = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
                    sb2.append("Unsupported value: ");
                    sb2.append(valueOf);
                    Log.e("SearchIndex", sb2.toString());
                }
            }
        }
        String string = bundle.getString("type");
        if (string != null) {
            zza.zza(string);
        }
        return (zzgf) zza.zzj();
    }
}
