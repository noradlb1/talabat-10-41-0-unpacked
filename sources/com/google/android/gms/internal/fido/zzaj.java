package com.google.android.gms.internal.fido;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzaj {
    private final String zza;
    private final zzah zzb;
    private zzah zzc;

    public /* synthetic */ zzaj(String str, zzai zzai) {
        zzah zzah = new zzah((zzag) null);
        this.zzb = zzah;
        this.zzc = zzah;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzah zzah = this.zzb.zzc;
        String str = "";
        while (zzah != null) {
            Object obj = zzah.zzb;
            boolean z11 = zzah instanceof zzaf;
            sb2.append(str);
            String str2 = zzah.zza;
            if (str2 != null) {
                sb2.append(str2);
                sb2.append(SignatureVisitor.INSTANCEOF);
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append(deepToString, 1, deepToString.length() - 1);
            }
            zzah = zzah.zzc;
            str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    public final zzaj zza(String str, int i11) {
        String valueOf = String.valueOf(i11);
        zzaf zzaf = new zzaf((zzae) null);
        this.zzc.zzc = zzaf;
        this.zzc = zzaf;
        zzaf.zzb = valueOf;
        zzaf.zza = "errorCode";
        return this;
    }

    public final zzaj zzb(String str, @CheckForNull Object obj) {
        zzah zzah = new zzah((zzag) null);
        this.zzc.zzc = zzah;
        this.zzc = zzah;
        zzah.zzb = obj;
        zzah.zza = str;
        return this;
    }
}
