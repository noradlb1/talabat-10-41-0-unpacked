package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p002firebaseauthapi.zzbf;
import com.google.android.gms.internal.p002firebaseauthapi.zzbk;
import com.google.android.gms.internal.p002firebaseauthapi.zzca;
import com.google.android.gms.internal.p002firebaseauthapi.zzin;
import com.google.android.gms.internal.p002firebaseauthapi.zzis;
import com.google.android.gms.internal.p002firebaseauthapi.zzjq;
import com.google.android.gms.internal.p002firebaseauthapi.zzjs;
import com.google.android.gms.internal.p002firebaseauthapi.zzlv;
import com.google.android.gms.internal.p002firebaseauthapi.zzq;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public final class zzk {
    private static zzk zza;
    private final String zzb;
    @Nullable
    private final zzjs zzc;

    private zzk(Context context, String str, boolean z11) {
        zzjs zzjs;
        this.zzb = str;
        try {
            zzin.zza();
            zzjq zzjq = new zzjq();
            zzjq.zzf(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", new Object[]{str}));
            zzjq.zzd(zzis.zza);
            zzjq.zze(String.format("android-keystore://firebear_master_key_id.%s", new Object[]{str}));
            zzjs = zzjq.zzg();
        } catch (IOException | GeneralSecurityException e11) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n".concat(String.valueOf(e11.getMessage())));
            zzjs = null;
        }
        this.zzc = zzjs;
    }

    public static zzk zza(Context context, String str) {
        zzk zzk = zza;
        if (zzk == null || !zzq.zza(zzk.zzb, str)) {
            zza = new zzk(context, str, true);
        }
        return zza;
    }

    @Nullable
    public final String zzb(String str) {
        String str2;
        zzjs zzjs = this.zzc;
        if (zzjs != null) {
            try {
                synchronized (zzjs) {
                    str2 = new String(((zzbk) this.zzc.zza().zze(zzlv.zza(), zzbk.class)).zza(Base64.decode(str, 8), (byte[]) null), "UTF-8");
                }
                return str2;
            } catch (UnsupportedEncodingException | GeneralSecurityException e11) {
                Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n".concat(String.valueOf(e11.getMessage())));
                return null;
            }
        } else {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
    }

    @Nullable
    public final String zzc() {
        if (this.zzc == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzca zza2 = zzbf.zza(byteArrayOutputStream);
        try {
            synchronized (this.zzc) {
                this.zzc.zza().zzb().zzg(zza2);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e11) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n".concat(String.valueOf(e11.getMessage())));
            return null;
        }
    }
}
