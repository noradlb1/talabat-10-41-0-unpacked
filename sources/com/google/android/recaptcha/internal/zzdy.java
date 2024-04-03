package com.google.android.recaptcha.internal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class zzdy implements Iterable {
    private final zzdn zza = zzdn.zza();

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z11 = true;
        for (Object append : this) {
            if (!z11) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(append);
            z11 = false;
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }
}
