package com.braze.support;

import android.content.Context;
import com.braze.support.BrazeLogger;
import com.visa.checkout.Profile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH\u0007J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/braze/support/WebContentUtils;", "", "()V", "FILE_URI_SCHEME_PREFIX", "", "HTML_INAPP_MESSAGES_FOLDER", "ZIP_EXTENSION", "getHtmlInAppMessageAssetCacheDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "getLocalHtmlUrlFromRemoteUrl", "localDirectory", "remoteZipUrl", "replacePrefetchedUrlsWithLocalAssets", "originalString", "remoteToLocalAssetMap", "", "unpackZipIntoDirectory", "", "unpackDirectory", "zipFile", "validateChildFileExistsUnderParent", "intendedParentDirectory", "childFilePath", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebContentUtils {
    private static final String FILE_URI_SCHEME_PREFIX = "file://";
    public static final String HTML_INAPP_MESSAGES_FOLDER = "appboy-html-inapp-messages";
    public static final WebContentUtils INSTANCE = new WebContentUtils();
    private static final String ZIP_EXTENSION = ".zip";

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43984b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Remote zip url is empty. No local URL will be created.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43986h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(0);
            this.f43985g = str;
            this.f43986h = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Starting download of url: " + this.f43985g + " to " + this.f43986h;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43987g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f43987g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Could not download zip file to local storage. ", this.f43987g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43988g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43989h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, String str2) {
            super(0);
            this.f43988g = str;
            this.f43989h = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Html content zip downloaded. " + this.f43988g + " to " + this.f43989h;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f43990b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error during the zip unpack.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43991g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.f43991g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Html content zip unpacked to to " + this.f43991g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f43992g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Ref.ObjectRef<String> objectRef) {
            super(0);
            this.f43992g = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Cannot find local asset file at path: ", this.f43992g.element);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43993g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f43994h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str, Ref.ObjectRef<String> objectRef) {
            super(0);
            this.f43993g = str;
            this.f43994h = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Replacing remote url \"" + this.f43993g + "\" with local uri \"" + ((String) this.f43994h.element) + '\"';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f43995b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unpack directory is blank. Zip file not unpacked.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f43996g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Ref.ObjectRef<String> objectRef) {
            super(0);
            this.f43996g = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Error creating parent directory ", this.f43996g.element);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f43997g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Ref.ObjectRef<String> objectRef) {
            super(0);
            this.f43997g = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Error unpacking zipEntry ", this.f43997g.element);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f43998g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43999h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(File file, String str) {
            super(0);
            this.f43998g = file;
            this.f43999h = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error during unpack of zip file " + this.f43998g.getAbsolutePath() + " to " + this.f43999h + '.';
        }
    }

    private WebContentUtils() {
    }

    @JvmStatic
    public static final File getHtmlInAppMessageAssetCacheDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new File(context.getCacheDir().getPath() + '/' + HTML_INAPP_MESSAGES_FOLDER);
    }

    @JvmStatic
    public static final String getLocalHtmlUrlFromRemoteUrl(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "localDirectory");
        Intrinsics.checkNotNullParameter(str, "remoteZipUrl");
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43984b, 6, (Object) null);
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        String valueOf = String.valueOf(IntentUtils.getRequestCode());
        String str2 = absolutePath + '/' + valueOf;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        WebContentUtils webContentUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(str, str2), 7, (Object) null);
        try {
            BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(str, str2), 7, (Object) null);
            if (!unpackZipIntoDirectory(str2, BrazeFileUtils.downloadFileToPath(str2, str, valueOf, ZIP_EXTENSION).component1())) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) e.f43990b, 6, (Object) null);
                BrazeFileUtils.deleteFileOrDirectory(new File(str2));
                return null;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(str2), 7, (Object) null);
            return str2;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new c(str), 4, (Object) null);
            BrazeFileUtils.deleteFileOrDirectory(new File(str2));
            return null;
        }
    }

    @JvmStatic
    public static final String replacePrefetchedUrlsWithLocalAssets(String str, Map<String, String> map) {
        T t11;
        Intrinsics.checkNotNullParameter(str, "originalString");
        Intrinsics.checkNotNullParameter(map, "remoteToLocalAssetMap");
        String str2 = str;
        for (Map.Entry next : map.entrySet()) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = next.getValue();
            if (!new File((String) objectRef.element).exists()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new g(objectRef), 6, (Object) null);
            } else {
                WebContentUtils webContentUtils = INSTANCE;
                if (StringsKt__StringsJVMKt.startsWith$default((String) objectRef.element, FILE_URI_SCHEME_PREFIX, false, 2, (Object) null)) {
                    t11 = (String) objectRef.element;
                } else {
                    t11 = Intrinsics.stringPlus(FILE_URI_SCHEME_PREFIX, objectRef.element);
                }
                objectRef.element = t11;
                String str3 = (String) next.getKey();
                if (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(str3, objectRef), 7, (Object) null);
                    str2 = StringsKt__StringsJVMKt.replace$default(str2, str3, (String) objectRef.element, false, 4, (Object) null);
                }
            }
        }
        return str2;
    }

    @JvmStatic
    public static final boolean unpackZipIntoDirectory(String str, File file) {
        Throwable th2;
        String str2 = str;
        File file2 = file;
        Intrinsics.checkNotNullParameter(str2, "unpackDirectory");
        Intrinsics.checkNotNullParameter(file2, "zipFile");
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) i.f43995b, 6, (Object) null);
            return false;
        }
        new File(str2).mkdirs();
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file2));
            try {
                for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                    T name2 = nextEntry.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "zipEntry.name");
                    objectRef.element = name2;
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                    String lowerCase = name2.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (!StringsKt__StringsJVMKt.startsWith$default(lowerCase, "__macosx", false, 2, (Object) null)) {
                        try {
                            String validateChildFileExistsUnderParent = validateChildFileExistsUnderParent(str2, str2 + '/' + ((String) objectRef.element));
                            if (nextEntry.isDirectory()) {
                                new File(validateChildFileExistsUnderParent).mkdirs();
                            } else {
                                try {
                                    File parentFile = new File(validateChildFileExistsUnderParent).getParentFile();
                                    if (parentFile != null) {
                                        parentFile.mkdirs();
                                    }
                                } catch (Exception e11) {
                                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new j(objectRef), 4, (Object) null);
                                }
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(validateChildFileExistsUnderParent));
                                try {
                                    ByteStreamsKt.copyTo$default(zipInputStream, bufferedOutputStream, 0, 2, (Object) null);
                                    CloseableKt.closeFinally(bufferedOutputStream, (Throwable) null);
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    CloseableKt.closeFinally(bufferedOutputStream, th2);
                                    throw th4;
                                }
                            }
                        } catch (Exception e12) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e12, false, (Function0) new k(objectRef), 4, (Object) null);
                        }
                    }
                    zipInputStream.closeEntry();
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(zipInputStream, (Throwable) null);
                return true;
            } finally {
                Exception exc = e12;
                try {
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    CloseableKt.closeFinally(zipInputStream, exc);
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, th7, false, (Function0) new l(file2, str2), 4, (Object) null);
            return false;
        }
    }

    @JvmStatic
    public static final String validateChildFileExistsUnderParent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "intendedParentDirectory");
        Intrinsics.checkNotNullParameter(str2, "childFilePath");
        String canonicalPath = new File(str).getCanonicalPath();
        String canonicalPath2 = new File(str2).getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath2, "childFileCanonicalPath");
        Intrinsics.checkNotNullExpressionValue(canonicalPath, "parentCanonicalPath");
        if (StringsKt__StringsJVMKt.startsWith$default(canonicalPath2, canonicalPath, false, 2, (Object) null)) {
            return canonicalPath2;
        }
        throw new IllegalStateException("Invalid file with original path: " + str2 + " with canonical path: " + canonicalPath2 + " does not exist under intended parent with  path: " + str + " and canonical path: " + canonicalPath);
    }
}
