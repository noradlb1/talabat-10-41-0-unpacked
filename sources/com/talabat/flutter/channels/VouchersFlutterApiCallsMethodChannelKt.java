package com.talabat.flutter.channels;

import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"CART_APPLY_VOUCHER_API", "Lkotlin/text/Regex;", "getCART_APPLY_VOUCHER_API", "()Lkotlin/text/Regex;", "readAssetsFile", "", "Landroid/content/res/AssetManager;", "fileName", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VouchersFlutterApiCallsMethodChannelKt {
    @NotNull
    private static final Regex CART_APPLY_VOUCHER_API = new Regex(".*/cart/v1/(\\d+)/applyVoucher/.*");

    @NotNull
    public static final Regex getCART_APPLY_VOUCHER_API() {
        return CART_APPLY_VOUCHER_API;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readAssetsFile(android.content.res.AssetManager r1, java.lang.String r2) {
        /*
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "open(fileName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0017
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x001f
        L_0x0017:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x001f:
            java.lang.String r1 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0028 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return r1
        L_0x0028:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002a }
        L_0x002a:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.flutter.channels.VouchersFlutterApiCallsMethodChannelKt.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }
}
