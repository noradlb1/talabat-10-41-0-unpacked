package com.talabat.domain.money;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"DEFAULT_CURRENCY_CODE", "", "getCurrencyByCode", "Ljava/util/Currency;", "currencyCode", "com_talabat_domain_money_money"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CurrenciesKt {
    @NotNull
    private static final String DEFAULT_CURRENCY_CODE = "AED";

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008b, code lost:
        if (r6.equals("sr") == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0094, code lost:
        if (r6.equals("qr") == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        if (r6.equals("kd") == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a6, code lost:
        if (r6.equals("bd") == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00af, code lost:
        if (r6.equals("SR") == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bb, code lost:
        if (r6.equals("QR") == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c7, code lost:
        if (r6.equals("KD") == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d3, code lost:
        if (r6.equals("BD") == false) goto L_0x00d8;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Currency getCurrencyByCode(@org.jetbrains.annotations.Nullable java.lang.String r6) {
        /*
            java.lang.String r0 = "AED"
            r1 = 0
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ IllegalArgumentException -> 0x000c }
            java.util.Currency r2 = java.util.Currency.getInstance(r2)     // Catch:{ IllegalArgumentException -> 0x000c }
            goto L_0x003e
        L_0x000c:
            java.util.Set r2 = java.util.Currency.getAvailableCurrencies()
            java.lang.String r3 = "availableCurrencies"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.Iterator r3 = r2.iterator()
        L_0x0019:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0031
            java.lang.Object r4 = r3.next()
            r5 = r4
            java.util.Currency r5 = (java.util.Currency) r5
            java.lang.String r5 = r5.getCurrencyCode()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 == 0) goto L_0x0019
            goto L_0x0032
        L_0x0031:
            r4 = r1
        L_0x0032:
            java.util.Currency r4 = (java.util.Currency) r4
            if (r4 != 0) goto L_0x003d
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.first(r2)
            java.util.Currency r2 = (java.util.Currency) r2
            goto L_0x003e
        L_0x003d:
            r2 = r4
        L_0x003e:
            if (r6 == 0) goto L_0x00df
            int r1 = r6.hashCode()
            r3 = 2114(0x842, float:2.962E-42)
            if (r1 == r3) goto L_0x00cd
            r3 = 2393(0x959, float:3.353E-42)
            if (r1 == r3) goto L_0x00c1
            r3 = 2593(0xa21, float:3.634E-42)
            if (r1 == r3) goto L_0x00b5
            r3 = 2655(0xa5f, float:3.72E-42)
            if (r1 == r3) goto L_0x00a9
            r3 = 3138(0xc42, float:4.397E-42)
            if (r1 == r3) goto L_0x00a0
            r3 = 3417(0xd59, float:4.788E-42)
            if (r1 == r3) goto L_0x0097
            r3 = 3617(0xe21, float:5.068E-42)
            if (r1 == r3) goto L_0x008e
            r3 = 3679(0xe5f, float:5.155E-42)
            if (r1 == r3) goto L_0x0085
            r3 = 67663(0x1084f, float:9.4816E-41)
            if (r1 == r3) goto L_0x007a
            r3 = 68687(0x10c4f, float:9.6251E-41)
            if (r1 == r3) goto L_0x0070
            goto L_0x00d8
        L_0x0070:
            java.lang.String r1 = "Dhs"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0083
            goto L_0x00d8
        L_0x007a:
            java.lang.String r1 = "DHS"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0083
            goto L_0x00d8
        L_0x0083:
            r6 = r0
            goto L_0x00d8
        L_0x0085:
            java.lang.String r0 = "sr"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00b2
            goto L_0x00d8
        L_0x008e:
            java.lang.String r0 = "qr"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00be
            goto L_0x00d8
        L_0x0097:
            java.lang.String r0 = "kd"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00ca
            goto L_0x00d8
        L_0x00a0:
            java.lang.String r0 = "bd"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00a9:
            java.lang.String r0 = "SR"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00b2
            goto L_0x00d8
        L_0x00b2:
            java.lang.String r6 = "SAR"
            goto L_0x00d8
        L_0x00b5:
            java.lang.String r0 = "QR"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00be
            goto L_0x00d8
        L_0x00be:
            java.lang.String r6 = "QAR"
            goto L_0x00d8
        L_0x00c1:
            java.lang.String r0 = "KD"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00ca
            goto L_0x00d8
        L_0x00ca:
            java.lang.String r6 = "KWD"
            goto L_0x00d8
        L_0x00cd:
            java.lang.String r0 = "BD"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            java.lang.String r6 = "BHD"
        L_0x00d8:
            java.util.Currency r6 = java.util.Currency.getInstance(r6)     // Catch:{ IllegalArgumentException -> 0x00de }
            r1 = r6
            goto L_0x00df
        L_0x00de:
            r1 = r2
        L_0x00df:
            if (r1 != 0) goto L_0x00e7
            java.lang.String r6 = "defaultCurrency"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            goto L_0x00e8
        L_0x00e7:
            r2 = r1
        L_0x00e8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.domain.money.CurrenciesKt.getCurrencyByCode(java.lang.String):java.util.Currency");
    }
}
