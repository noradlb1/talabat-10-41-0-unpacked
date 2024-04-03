package com.braze.support;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.webkit.ProxyConfig;
import com.braze.support.BrazeLogger;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0007\u001aH\u0010\u000e\u001a \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010j\u0002`\u00110\u000f2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u001b\u001a\n\u0010\u001c\u001a\u00020\u001a*\u00020\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"FILE_SCHEME", "", "REMOTE_SCHEMES", "", "SHARED_PREFERENCES_FILENAME_SUFFIX", "TAG", "deleteFileOrDirectory", "", "fileOrDirectory", "Ljava/io/File;", "deleteSharedPreferencesFile", "context", "Landroid/content/Context;", "file", "downloadFileToPath", "Lkotlin/Pair;", "", "Lcom/braze/communication/HttpHeaders;", "downloadDirectoryAbsolutePath", "remoteFileUrl", "outputFilename", "extension", "getAssetFileStringContents", "Landroid/content/res/AssetManager;", "assetPath", "isLocalUri", "", "Landroid/net/Uri;", "isRemoteUri", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BrazeFileUtils {
    private static final String FILE_SCHEME = "file";
    public static final List<String> REMOTE_SCHEMES = CollectionsKt__CollectionsKt.listOf(ProxyConfig.MATCH_HTTP, "https", "ftp", "ftps", "about", "javascript");
    private static final String SHARED_PREFERENCES_FILENAME_SUFFIX = ".xml";
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeFileUtils");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f43892g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(0);
            this.f43892g = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Could not recursively delete ", this.f43892g.getName());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f43893g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(File file) {
            super(0);
            this.f43893g = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Cannot delete SharedPreferences that does not exist. Path: ", this.f43893g.getAbsolutePath());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f43894g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(File file) {
            super(0);
            this.f43894g = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("SharedPreferences file is expected to end in .xml. Path: ", this.f43894g.getAbsolutePath());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43895g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f43895g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("SDK is offline. File not downloaded for url: ", this.f43895g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f43896b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Download directory null or blank. File not downloaded.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f43897b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Zip file url null or blank. File not downloaded.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f43898b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Output filename null or blank. File not downloaded.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43899g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43900h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(int i11, String str) {
            super(0);
            this.f43899g = i11;
            this.f43900h = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "HTTP response code was " + this.f43899g + ". File with url " + this.f43900h + " could not be downloaded.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43901g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super(0);
            this.f43901g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Exception during download of file from url : ", this.f43901g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f43902b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Null or blank Uri scheme.";
        }
    }

    public static final void deleteFileOrDirectory(File file) {
        Intrinsics.checkNotNullParameter(file, "fileOrDirectory");
        if (!FilesKt__UtilsKt.deleteRecursively(file)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(file), 12, (Object) null);
        }
    }

    public static final void deleteSharedPreferencesFile(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(file), 12, (Object) null);
            return;
        }
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "fileName");
        if (!StringsKt__StringsJVMKt.endsWith$default(name2, SHARED_PREFERENCES_FILENAME_SUFFIX, false, 2, (Object) null)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new c(file), 12, (Object) null);
            return;
        }
        String removeSuffix = StringsKt__StringsKt.removeSuffix(name2, (CharSequence) SHARED_PREFERENCES_FILENAME_SUFFIX);
        if (Build.VERSION.SDK_INT >= 24) {
            boolean unused = context.deleteSharedPreferences(removeSuffix);
            return;
        }
        context.getSharedPreferences(removeSuffix, 0).edit().clear().commit();
        deleteFileOrDirectory(file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0092, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0096, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0099, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009d, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046 A[Catch:{ Exception -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062 A[Catch:{ Exception -> 0x00d8, all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009e A[Catch:{ Exception -> 0x00d8, all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<java.io.File, java.util.Map<java.lang.String, java.lang.String>> downloadFileToPath(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "downloadDirectoryAbsolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "remoteFileUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "outputFilename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1337(0x539, float:1.874E-42)
            android.net.TrafficStats.setThreadStatsTag(r0)
            com.braze.Braze$Companion r0 = com.braze.Braze.Companion
            boolean r0 = r0.getOutboundNetworkRequestsOffline()
            if (r0 != 0) goto L_0x014d
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r9)
            if (r0 != 0) goto L_0x0135
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r10)
            if (r0 != 0) goto L_0x011d
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r11)
            if (r0 != 0) goto L_0x0105
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00de }
            r1.<init>(r9)     // Catch:{ Exception -> 0x00de }
            r1.mkdirs()     // Catch:{ Exception -> 0x00de }
            r1 = 0
            if (r12 == 0) goto L_0x0043
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x00de }
            if (r2 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r2 = r1
            goto L_0x0044
        L_0x0043:
            r2 = 1
        L_0x0044:
            if (r2 != 0) goto L_0x004a
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r12)     // Catch:{ Exception -> 0x00de }
        L_0x004a:
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x00de }
            r12.<init>(r9, r11)     // Catch:{ Exception -> 0x00de }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x00de }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00de }
            bo.app.s6 r11 = bo.app.s6.f39358a     // Catch:{ Exception -> 0x00de }
            java.net.HttpURLConnection r9 = r11.a(r9)     // Catch:{ Exception -> 0x00de }
            int r11 = r9.getResponseCode()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r11 != r2) goto L_0x009e
            java.io.DataInputStream r11 = new java.io.DataInputStream     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.io.InputStream r2 = r9.getInputStream()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0097 }
            r2.<init>(r12)     // Catch:{ all -> 0x0097 }
            r3 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r11, r2, r1, r3, r0)     // Catch:{ all -> 0x0090 }
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x0097 }
            kotlin.io.CloseableKt.closeFinally(r11, r0)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.util.Map r11 = r9.getHeaderFields()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r0 = "urlConnection.headerFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.util.Map r10 = bo.app.v1.a((java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>>) r11)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r9.disconnect()
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r12, r10)
            return r9
        L_0x0090:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0092 }
        L_0x0092:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r12)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r11, r12)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            throw r0     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
        L_0x009e:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r2 = 0
            r3 = 0
            r4 = 0
            com.braze.support.BrazeFileUtils$h r5 = new com.braze.support.BrazeFileUtils$h     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r5.<init>(r11, r10)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r6 = 14
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.Exception r12 = new java.lang.Exception     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.<init>()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r1 = "HTTP response code was "
            r0.append(r1)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.append(r11)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r11 = ". File with url "
            r0.append(r11)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.append(r10)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r11 = " could not be downloaded."
            r0.append(r11)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r11 = r0.toString()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            throw r12     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
        L_0x00d4:
            r10 = move-exception
            r0 = r9
            r9 = r10
            goto L_0x00fe
        L_0x00d8:
            r11 = move-exception
            r0 = r9
            r4 = r11
            goto L_0x00e0
        L_0x00dc:
            r9 = move-exception
            goto L_0x00fe
        L_0x00de:
            r9 = move-exception
            r4 = r9
        L_0x00e0:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00dc }
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x00dc }
            r5 = 0
            com.braze.support.BrazeFileUtils$i r6 = new com.braze.support.BrazeFileUtils$i     // Catch:{ all -> 0x00dc }
            r6.<init>(r10)     // Catch:{ all -> 0x00dc }
            r7 = 8
            r8 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.String) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x00dc }
            java.lang.Exception r9 = new java.lang.Exception     // Catch:{ all -> 0x00dc }
            java.lang.String r11 = "Exception during download of file from url : "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r10)     // Catch:{ all -> 0x00dc }
            r9.<init>(r10)     // Catch:{ all -> 0x00dc }
            throw r9     // Catch:{ all -> 0x00dc }
        L_0x00fe:
            if (r0 != 0) goto L_0x0101
            goto L_0x0104
        L_0x0101:
            r0.disconnect()
        L_0x0104:
            throw r9
        L_0x0105:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r2 = TAG
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$g r6 = com.braze.support.BrazeFileUtils.g.f43898b
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.String) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r10 = "Output filename is blank. File not downloaded."
            r9.<init>(r10)
            throw r9
        L_0x011d:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r1 = TAG
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$f r5 = com.braze.support.BrazeFileUtils.f.f43897b
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r10 = "Zip file url is blank. File not downloaded."
            r9.<init>(r10)
            throw r9
        L_0x0135:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r1 = TAG
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$e r5 = com.braze.support.BrazeFileUtils.e.f43896b
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r10 = "Download directory is blank. File not downloaded."
            r9.<init>(r10)
            throw r9
        L_0x014d:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r1 = TAG
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$d r5 = new com.braze.support.BrazeFileUtils$d
            r5.<init>(r10)
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r11 = "SDK is offline. File not downloaded for url: "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r10)
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeFileUtils.downloadFileToPath(java.lang.String, java.lang.String, java.lang.String, java.lang.String):kotlin.Pair");
    }

    public static /* synthetic */ Pair downloadFileToPath$default(String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str4 = null;
        }
        return downloadFileToPath(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getAssetFileStringContents(android.content.res.AssetManager r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "assetPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "this.open(assetPath)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0021
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x0029
        L_0x0021:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x0029:
            java.lang.String r1 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0032 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return r1
        L_0x0032:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeFileUtils.getAssetFileStringContents(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    public static final boolean isLocalUri(Uri uri) {
        boolean z11;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String scheme = uri.getScheme();
        if (scheme == null || StringsKt__StringsJVMKt.isBlank(scheme)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || Intrinsics.areEqual((Object) scheme, (Object) "file")) {
            return true;
        }
        return false;
    }

    public static final boolean isRemoteUri(Uri uri) {
        boolean z11;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String scheme = uri.getScheme();
        if (scheme == null || StringsKt__StringsJVMKt.isBlank(scheme)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return REMOTE_SCHEMES.contains(scheme);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) j.f43902b, 12, (Object) null);
        return false;
    }
}
