package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzfqa {
    private final String zza;
    private final zzfpy zzb;
    private zzfpy zzc;

    public /* synthetic */ zzfqa(String str, zzfpz zzfpz) {
        zzfpy zzfpy = new zzfpy((zzfpx) null);
        this.zzb = zzfpy;
        this.zzc = zzfpy;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzfpy zzfpy = this.zzb.zzb;
        String str = "";
        while (zzfpy != null) {
            Object obj = zzfpy.zza;
            sb2.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append(deepToString, 1, deepToString.length() - 1);
            }
            zzfpy = zzfpy.zzb;
            str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    public final zzfqa zza(@CheckForNull Object obj) {
        zzfpy zzfpy = new zzfpy((zzfpx) null);
        this.zzc.zzb = zzfpy;
        this.zzc = zzfpy;
        zzfpy.zza = obj;
        return this;
    }
}
