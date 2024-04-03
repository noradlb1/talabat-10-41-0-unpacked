package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = RequestExecutor.a("fonts-androidx", 10, 10000);

    /* renamed from: a  reason: collision with root package name */
    public static final LruCache<String, Typeface> f11374a = new LruCache<>(16);

    /* renamed from: b  reason: collision with root package name */
    public static final Object f11375b = new Object();
    @GuardedBy("LOCK")

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> f11376c = new SimpleArrayMap<>();

    private FontRequestWorker() {
    }

    @NonNull
    public static TypefaceResult a(@NonNull String str, @NonNull Context context, @NonNull FontRequest fontRequest, int i11) {
        LruCache<String, Typeface> lruCache = f11374a;
        Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult b11 = FontProvider.b(context, fontRequest, (CancellationSignal) null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(b11);
            if (fontFamilyResultStatus != 0) {
                return new TypefaceResult(fontFamilyResultStatus);
            }
            Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, (CancellationSignal) null, b11.getFonts(), i11);
            if (createFromFontInfo == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, createFromFontInfo);
            return new TypefaceResult(createFromFontInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r9 = new androidx.core.provider.FontRequestWorker.AnonymousClass3();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r8 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r8 = DEFAULT_EXECUTOR_SERVICE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        androidx.core.provider.RequestExecutor.c(r8, r9, new androidx.core.provider.FontRequestWorker.AnonymousClass4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface b(@androidx.annotation.NonNull final android.content.Context r5, @androidx.annotation.NonNull final androidx.core.provider.FontRequest r6, final int r7, @androidx.annotation.Nullable java.util.concurrent.Executor r8, @androidx.annotation.NonNull final androidx.core.provider.CallbackWithHandler r9) {
        /*
            java.lang.String r0 = createCacheId(r6, r7)
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r1 = f11374a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.FontRequestWorker$TypefaceResult r5 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r5.<init>((android.graphics.Typeface) r1)
            r9.a(r5)
            return r1
        L_0x0017:
            androidx.core.provider.FontRequestWorker$2 r1 = new androidx.core.provider.FontRequestWorker$2
            r1.<init>()
            java.lang.Object r9 = f11375b
            monitor-enter(r9)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult>>> r2 = f11376c     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x004d }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x004d }
            r4 = 0
            if (r3 == 0) goto L_0x002f
            r3.add(r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            return r4
        L_0x002f:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            r3.add(r1)     // Catch:{ all -> 0x004d }
            r2.put(r0, r3)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            androidx.core.provider.FontRequestWorker$3 r9 = new androidx.core.provider.FontRequestWorker$3
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r8 = DEFAULT_EXECUTOR_SERVICE
        L_0x0044:
            androidx.core.provider.FontRequestWorker$4 r5 = new androidx.core.provider.FontRequestWorker$4
            r5.<init>(r0)
            androidx.core.provider.RequestExecutor.c(r8, r9, r5)
            return r4
        L_0x004d:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.b(android.content.Context, androidx.core.provider.FontRequest, int, java.util.concurrent.Executor, androidx.core.provider.CallbackWithHandler):android.graphics.Typeface");
    }

    public static Typeface c(@NonNull final Context context, @NonNull final FontRequest fontRequest, @NonNull CallbackWithHandler callbackWithHandler, final int i11, int i12) {
        final String createCacheId = createCacheId(fontRequest, i11);
        Typeface typeface = f11374a.get(createCacheId);
        if (typeface != null) {
            callbackWithHandler.a(new TypefaceResult(typeface));
            return typeface;
        } else if (i12 == -1) {
            TypefaceResult a11 = a(createCacheId, context, fontRequest, i11);
            callbackWithHandler.a(a11);
            return a11.f11387a;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.d(DEFAULT_EXECUTOR_SERVICE, new Callable<TypefaceResult>() {
                    public TypefaceResult call() {
                        return FontRequestWorker.a(createCacheId, context, fontRequest, i11);
                    }
                }, i12);
                callbackWithHandler.a(typefaceResult);
                return typefaceResult.f11387a;
            } catch (InterruptedException unused) {
                callbackWithHandler.a(new TypefaceResult(-3));
                return null;
            }
        }
    }

    private static String createCacheId(@NonNull FontRequest fontRequest, int i11) {
        return fontRequest.a() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + i11;
    }

    public static void d() {
        f11374a.evictAll();
    }

    @SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(@NonNull FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i11 = 1;
        if (fontFamilyResult.getStatusCode() == 0) {
            FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
            if (!(fonts == null || fonts.length == 0)) {
                int length = fonts.length;
                i11 = 0;
                int i12 = 0;
                while (i12 < length) {
                    int resultCode = fonts[i12].getResultCode();
                    if (resultCode == 0) {
                        i12++;
                    } else if (resultCode < 0) {
                        return -3;
                    } else {
                        return resultCode;
                    }
                }
            }
            return i11;
        } else if (fontFamilyResult.getStatusCode() != 1) {
            return -3;
        } else {
            return -2;
        }
    }

    public static final class TypefaceResult {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f11387a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11388b;

        public TypefaceResult(int i11) {
            this.f11387a = null;
            this.f11388b = i11;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f11388b == 0;
        }

        @SuppressLint({"WrongConstant"})
        public TypefaceResult(@NonNull Typeface typeface) {
            this.f11387a = typeface;
            this.f11388b = 0;
        }
    }
}
