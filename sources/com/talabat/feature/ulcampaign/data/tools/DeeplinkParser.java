package com.talabat.feature.ulcampaign.data.tools;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/tools/DeeplinkParser;", "", "()V", "getStringValue", "", "parts", "", "key", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkParser {
    @NotNull
    public static final DeeplinkParser INSTANCE = new DeeplinkParser();

    private DeeplinkParser() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|10|11|12|30|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getStringValue(@org.jetbrains.annotations.Nullable java.lang.String[] r11, @org.jetbrains.annotations.Nullable java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0058
            int r1 = r11.length     // Catch:{ Exception -> 0x0058 }
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0058 }
            int r3 = r11.length     // Catch:{ Exception -> 0x0058 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0058 }
            int r4 = r11.length     // Catch:{ Exception -> 0x0058 }
            r5 = 0
            r6 = r5
        L_0x000d:
            if (r6 >= r4) goto L_0x003f
            r7 = r11[r6]     // Catch:{ Exception -> 0x0058 }
            kotlin.text.Regex r8 = new kotlin.text.Regex     // Catch:{ Exception -> 0x0058 }
            java.lang.String r9 = "="
            r8.<init>((java.lang.String) r9)     // Catch:{ Exception -> 0x0058 }
            java.util.List r7 = r8.split(r7, r5)     // Catch:{ Exception -> 0x0058 }
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ Exception -> 0x0058 }
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0058 }
            java.lang.Object[] r7 = r7.toArray(r8)     // Catch:{ Exception -> 0x0058 }
            if (r7 == 0) goto L_0x0037
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ Exception -> 0x0058 }
            r8 = r7[r5]     // Catch:{ Exception -> 0x0058 }
            r2[r6] = r8     // Catch:{ Exception -> 0x0058 }
            r8 = 1
            r7 = r7[r8]     // Catch:{ Exception -> 0x0032 }
            r3[r6] = r7     // Catch:{ Exception -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r3[r6] = r0     // Catch:{ Exception -> 0x0058 }
        L_0x0034:
            int r6 = r6 + 1
            goto L_0x000d
        L_0x0037:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0058 }
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r11.<init>(r12)     // Catch:{ Exception -> 0x0058 }
            throw r11     // Catch:{ Exception -> 0x0058 }
        L_0x003f:
            r11 = r0
        L_0x0040:
            if (r5 >= r1) goto L_0x0056
            r4 = r2[r5]     // Catch:{ Exception -> 0x0058 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r12)     // Catch:{ Exception -> 0x0058 }
            if (r4 == 0) goto L_0x0053
            r11 = r3[r5]     // Catch:{ Exception -> 0x0058 }
            if (r11 == 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r11 = 0
        L_0x0050:
            if (r11 != 0) goto L_0x0053
            r11 = r0
        L_0x0053:
            int r5 = r5 + 1
            goto L_0x0040
        L_0x0056:
            r0 = r11
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ulcampaign.data.tools.DeeplinkParser.getStringValue(java.lang.String[], java.lang.String):java.lang.String");
    }
}
