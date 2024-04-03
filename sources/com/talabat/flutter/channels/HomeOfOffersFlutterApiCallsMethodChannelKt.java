package com.talabat.flutter.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¨\u0006\u0007"}, d2 = {"homeOfOffersApi", "", "lat", "lon", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HomeOfOffersFlutterApiCallsMethodChannelKt {
    @NotNull
    public static final String homeOfOffersApi(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lon");
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default("/v1/home-of-offers?lat={lat}&lon={lon}", "{lat}", str, false, 4, (Object) null), "{lon}", str2, false, 4, (Object) null);
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.flutter.channels.HomeOfOffersFlutterApiCallsMethodChannelKt.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }
}
