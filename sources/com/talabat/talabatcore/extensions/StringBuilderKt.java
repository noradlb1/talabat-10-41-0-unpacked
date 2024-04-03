package com.talabat.talabatcore.extensions;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a!\u0010\u0000\u001a\u00020\u0001*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0004¨\u0006\u0006"}, d2 = {"addStringWithComma", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "newString", "", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StringBuilderKt {
    public static final void addStringWithComma(@Nullable StringBuilder sb2, @Nullable Object obj) {
        if (obj != null && sb2 != null) {
            boolean z11 = true;
            if (!StringsKt__StringsJVMKt.isBlank(obj.toString())) {
                if (sb2.length() <= 0) {
                    z11 = false;
                }
                if (z11) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    sb2.append(StringsKt__StringsKt.trim((CharSequence) obj.toString()).toString());
                    return;
                }
                sb2.append(StringsKt__StringsKt.trim((CharSequence) obj.toString()).toString());
            }
        }
    }
}
