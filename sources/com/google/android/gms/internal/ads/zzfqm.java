package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzfqm implements Iterable<String> {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfqp zzb;

    public zzfqm(zzfqp zzfqp, CharSequence charSequence) {
        this.zzb = zzfqp;
        this.zza = charSequence;
    }

    public final Iterator<String> iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb2.append(zzfpw.zza(it.next(), IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
                while (it.hasNext()) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    sb2.append(zzfpw.zza(it.next(), IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
                }
            }
            sb2.append(AbstractJsonLexerKt.END_LIST);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
