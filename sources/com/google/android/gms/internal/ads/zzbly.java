package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzbly {
    private final List<zzblv> zza = new LinkedList();
    private final Map<String, String> zzb;
    private final Object zzc;

    public zzbly(boolean z11, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "make_wv");
        linkedHashMap.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public static final zzblv zzf() {
        return new zzblv(zzt.zzA().elapsedRealtime(), (String) null, (zzblv) null);
    }

    public final zzblx zza() {
        zzblx zzblx;
        boolean booleanValue = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue();
        StringBuilder sb2 = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzblv next : this.zza) {
                long zza2 = next.zza();
                String zzc2 = next.zzc();
                zzblv zzb2 = next.zzb();
                if (zzb2 != null && zza2 > 0) {
                    sb2.append(zzc2);
                    sb2.append('.');
                    sb2.append(zza2 - zzb2.zza());
                    sb2.append(AbstractJsonLexerKt.COMMA);
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzb2.zza()))) {
                            hashMap.put(Long.valueOf(zzb2.zza()), new StringBuilder(zzc2));
                        } else {
                            StringBuilder sb3 = (StringBuilder) hashMap.get(Long.valueOf(zzb2.zza()));
                            sb3.append(SignatureVisitor.EXTENDS);
                            sb3.append(zzc2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb2.append((String) null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            StringBuilder sb4 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb4.append((CharSequence) entry.getValue());
                    sb4.append('.');
                    sb4.append(zzt.zzA().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzt.zzA().elapsedRealtime()));
                    sb4.append(AbstractJsonLexerKt.COMMA);
                }
                if (sb4.length() > 0) {
                    sb4.setLength(sb4.length() - 1);
                }
                str = sb4.toString();
            }
            zzblx = new zzblx(sb2.toString(), str);
        }
        return zzblx;
    }

    @VisibleForTesting
    public final Map<String, String> zzb() {
        Map<String, String> map;
        synchronized (this.zzc) {
            zzt.zzo().zzf();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(@Nullable zzbly zzbly) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzblo zzf;
        if (!TextUtils.isEmpty(str2) && (zzf = zzt.zzo().zzf()) != null) {
            synchronized (this.zzc) {
                zzblu zza2 = zzf.zza(str);
                Map<String, String> map = this.zzb;
                map.put(str, zza2.zza(map.get(str), str2));
            }
        }
    }

    public final boolean zze(zzblv zzblv, long j11, String... strArr) {
        synchronized (this.zzc) {
            for (int i11 = 0; i11 <= 0; i11++) {
                this.zza.add(new zzblv(j11, strArr[i11], zzblv));
            }
        }
        return true;
    }
}
