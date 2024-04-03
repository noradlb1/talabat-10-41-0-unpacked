package com.google.android.gms.internal.gtm;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class zzci extends zzan {
    private static zzci zzabl;

    public zzci(zzap zzap) {
        super(zzap);
    }

    @VisibleForTesting
    private static String zzd(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        boolean z11 = obj instanceof Long;
        String str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        if (z11) {
            Long l11 = (Long) obj;
            if (Math.abs(l11.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) != '-') {
                str = "";
            }
            String valueOf = String.valueOf(Math.abs(l11.longValue()));
            return str + Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                return obj.getClass().getCanonicalName();
            }
            return str;
        }
    }

    public static zzci zzfn() {
        return zzabl;
    }

    public final void zza(zzcd zzcd, String str) {
        String zzcd2 = zzcd != null ? zzcd.toString() : "no hit data";
        String valueOf = String.valueOf(str);
        zzd(valueOf.length() != 0 ? "Discarding hit. ".concat(valueOf) : new String("Discarding hit. "), zzcd2);
    }

    public final void zzaw() {
        synchronized (zzci.class) {
            zzabl = this;
        }
    }

    public final synchronized void zzb(int i11, String str, Object obj, Object obj2, Object obj3) {
        char c11;
        Preconditions.checkNotNull(str);
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 >= 9) {
            i11 = 8;
        }
        if (zzcp().zzem()) {
            c11 = 'C';
        } else {
            c11 = 'c';
        }
        char charAt = "01VDIWEA?".charAt(i11);
        String str2 = zzao.VERSION;
        String zzc = zzam.zzc(str, zzd(obj), zzd(obj2), zzd(obj3));
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(zzc).length());
        sb2.append(ExifInterface.GPS_MEASUREMENT_3D);
        sb2.append(charAt);
        sb2.append(c11);
        sb2.append(str2);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(zzc);
        String sb3 = sb2.toString();
        if (sb3.length() > 1024) {
            sb3 = sb3.substring(0, 1024);
        }
        zzcm zzdf = zzcm().zzdf();
        if (zzdf != null) {
            zzdf.zzga().zzae(sb3);
        }
    }

    public final void zza(Map<String, String> map, String str) {
        String str2;
        if (map != null) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append(AbstractJsonLexerKt.COMMA);
                }
                sb2.append((String) next.getKey());
                sb2.append(SignatureVisitor.INSTANCEOF);
                sb2.append((String) next.getValue());
            }
            str2 = sb2.toString();
        } else {
            str2 = "no hit data";
        }
        String valueOf = String.valueOf(str);
        zzd(valueOf.length() != 0 ? "Discarding hit. ".concat(valueOf) : new String("Discarding hit. "), str2);
    }
}
