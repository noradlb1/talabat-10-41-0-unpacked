package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzcmu implements zzbrt<zzclh> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        float parseFloat;
        zzclh zzclh = (zzclh) obj;
        zzcpl zzs = zzclh.zzs();
        if (zzs == null) {
            try {
                zzcpl zzcpl = new zzcpl(zzclh, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzclh.zzE(zzcpl);
                zzs = zzcpl;
            } catch (NullPointerException e11) {
                e = e11;
                zzciz.zzh("Unable to parse videoMeta message.", e);
                zzt.zzo().zzs(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e12) {
                e = e12;
                zzciz.zzh("Unable to parse videoMeta message.", e);
                zzt.zzo().zzs(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat2 = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat3 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        int i11 = 0;
        if (parseInt >= 0) {
            if (parseInt <= 3) {
                i11 = parseInt;
            }
        }
        String str = (String) map.get("aspectRatio");
        if (TextUtils.isEmpty(str)) {
            parseFloat = 0.0f;
        } else {
            parseFloat = Float.parseFloat(str);
        }
        float f11 = parseFloat;
        if (zzciz.zzm(3)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + Opcodes.F2L);
            sb2.append("Video Meta GMSG: currentTime : ");
            sb2.append(parseFloat3);
            sb2.append(" , duration : ");
            sb2.append(parseFloat2);
            sb2.append(" , isMuted : ");
            sb2.append(equals);
            sb2.append(" , playbackState : ");
            sb2.append(i11);
            sb2.append(" , aspectRatio : ");
            sb2.append(str);
            zzciz.zze(sb2.toString());
        }
        zzs.zzc(parseFloat3, parseFloat2, i11, equals, f11);
    }
}
