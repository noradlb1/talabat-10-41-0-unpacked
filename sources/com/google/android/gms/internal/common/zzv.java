package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzv implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzx zzb;

    public zzv(zzx zzx, CharSequence charSequence) {
        this.zzb = zzx;
        this.zza = charSequence;
    }

    public final Iterator iterator() {
        return this.zzb.zzh(this.zza);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb2.append(zzq.zza(it.next(), IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
                while (it.hasNext()) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    sb2.append(zzq.zza(it.next(), IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
                }
            }
            sb2.append(AbstractJsonLexerKt.END_LIST);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
