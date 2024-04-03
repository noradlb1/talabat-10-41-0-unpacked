package com.airbnb.lottie.parser.moshi;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class JsonScope {
    private JsonScope() {
    }

    public static String a(int i11, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = iArr[i12];
            if (i13 == 1 || i13 == 2) {
                sb2.append('[');
                sb2.append(iArr2[i12]);
                sb2.append(AbstractJsonLexerKt.END_LIST);
            } else if (i13 == 3 || i13 == 4 || i13 == 5) {
                sb2.append('.');
                String str = strArr[i12];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }
}
