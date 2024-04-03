package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheControl {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    @NotNull
    @JvmField
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    @Nullable
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j11) {
            if (j11 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j11;
        }

        @NotNull
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, (String) null, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        @NotNull
        public final Builder maxAge(int i11, @NotNull TimeUnit timeUnit) {
            boolean z11;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds((long) i11));
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("maxAge < 0: ", Integer.valueOf(i11)).toString());
        }

        @NotNull
        public final Builder maxStale(int i11, @NotNull TimeUnit timeUnit) {
            boolean z11;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds((long) i11));
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("maxStale < 0: ", Integer.valueOf(i11)).toString());
        }

        @NotNull
        public final Builder minFresh(int i11, @NotNull TimeUnit timeUnit) {
            boolean z11;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds((long) i11));
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("minFresh < 0: ", Integer.valueOf(i11)).toString());
        }

        @NotNull
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @NotNull
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @NotNull
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @NotNull
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i11) {
            int length = str.length();
            while (i11 < length) {
                int i12 = i11 + 1;
                if (StringsKt__StringsKt.contains$default((CharSequence) str2, str.charAt(i11), false, 2, (Object) null)) {
                    return i11;
                }
                i11 = i12;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return companion.indexOfElement(str, str2, i11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.CacheControl parse(@org.jetbrains.annotations.NotNull okhttp3.Headers r31) {
            /*
                r30 = this;
                r0 = r30
                r1 = r31
                java.lang.String r2 = "headers"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                int r2 = r31.size()
                r5 = 1
                r8 = r5
                r7 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = -1
                r13 = -1
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = -1
                r18 = -1
                r19 = 0
                r20 = 0
                r21 = 0
            L_0x0023:
                if (r7 >= r2) goto L_0x0188
                int r22 = r7 + 1
                java.lang.String r3 = r1.name(r7)
                java.lang.String r7 = r1.value(r7)
                java.lang.String r6 = "Cache-Control"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r6, r5)
                if (r6 == 0) goto L_0x003c
                if (r9 == 0) goto L_0x003a
                goto L_0x0044
            L_0x003a:
                r9 = r7
                goto L_0x0045
            L_0x003c:
                java.lang.String r6 = "Pragma"
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r6, r5)
                if (r3 == 0) goto L_0x0181
            L_0x0044:
                r8 = 0
            L_0x0045:
                r3 = 0
            L_0x0046:
                int r6 = r7.length()
                if (r3 >= r6) goto L_0x0181
                java.lang.String r6 = "=,;"
                int r6 = r0.indexOfElement(r7, r6, r3)
                java.lang.String r3 = r7.substring(r3, r6)
                java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                java.lang.CharSequence r3 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r3)
                java.lang.String r3 = r3.toString()
                int r5 = r7.length()
                if (r6 == r5) goto L_0x00c0
                char r5 = r7.charAt(r6)
                r1 = 44
                if (r5 == r1) goto L_0x00c0
                char r1 = r7.charAt(r6)
                r5 = 59
                if (r1 != r5) goto L_0x007a
                goto L_0x00c0
            L_0x007a:
                int r6 = r6 + 1
                int r1 = okhttp3.internal.Util.indexOfNonWhitespace(r7, r6)
                int r5 = r7.length()
                if (r1 >= r5) goto L_0x00aa
                char r5 = r7.charAt(r1)
                r6 = 34
                if (r5 != r6) goto L_0x00aa
                int r1 = r1 + 1
                r25 = 34
                r27 = 0
                r28 = 4
                r29 = 0
                r24 = r7
                r26 = r1
                int r5 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r24, (char) r25, (int) r26, (boolean) r27, (int) r28, (java.lang.Object) r29)
                java.lang.String r1 = r7.substring(r1, r5)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                r4 = 1
                int r5 = r5 + r4
                goto L_0x00c4
            L_0x00aa:
                java.lang.String r5 = ",;"
                int r5 = r0.indexOfElement(r7, r5, r1)
                java.lang.String r1 = r7.substring(r1, r5)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                java.lang.CharSequence r1 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r1)
                java.lang.String r1 = r1.toString()
                goto L_0x00c4
            L_0x00c0:
                int r6 = r6 + 1
                r5 = r6
                r1 = 0
            L_0x00c4:
                java.lang.String r4 = "no-cache"
                r6 = 1
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x00d4
                r1 = r31
                r3 = r5
                r5 = r6
                r10 = r5
                goto L_0x0046
            L_0x00d4:
                java.lang.String r4 = "no-store"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x00e3
                r1 = r31
                r3 = r5
                r5 = r6
                r11 = r5
                goto L_0x0046
            L_0x00e3:
                java.lang.String r4 = "max-age"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x00f6
                r4 = -1
                int r12 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
            L_0x00f0:
                r1 = r31
                r3 = r5
                r5 = r6
                goto L_0x0046
            L_0x00f6:
                java.lang.String r4 = "s-maxage"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x0104
                r4 = -1
                int r13 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
                goto L_0x00f0
            L_0x0104:
                java.lang.String r4 = "private"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x0113
                r1 = r31
                r3 = r5
                r5 = r6
                r14 = r5
                goto L_0x0046
            L_0x0113:
                java.lang.String r4 = "public"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x0122
                r1 = r31
                r3 = r5
                r5 = r6
                r15 = r5
                goto L_0x0046
            L_0x0122:
                java.lang.String r4 = "must-revalidate"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x0132
                r1 = r31
                r3 = r5
                r5 = r6
                r16 = r5
                goto L_0x0046
            L_0x0132:
                java.lang.String r4 = "max-stale"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x0142
                r3 = 2147483647(0x7fffffff, float:NaN)
                int r17 = okhttp3.internal.Util.toNonNegativeInt(r1, r3)
                goto L_0x00f0
            L_0x0142:
                java.lang.String r4 = "min-fresh"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r3, r6)
                if (r4 == 0) goto L_0x0150
                r4 = -1
                int r18 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
                goto L_0x00f0
            L_0x0150:
                r4 = -1
                java.lang.String r1 = "only-if-cached"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.equals(r1, r3, r6)
                if (r1 == 0) goto L_0x0161
                r1 = r31
                r3 = r5
                r5 = r6
                r19 = r5
                goto L_0x0046
            L_0x0161:
                java.lang.String r1 = "no-transform"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.equals(r1, r3, r6)
                if (r1 == 0) goto L_0x0171
                r1 = r31
                r3 = r5
                r5 = r6
                r20 = r5
                goto L_0x0046
            L_0x0171:
                java.lang.String r1 = "immutable"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.equals(r1, r3, r6)
                if (r1 == 0) goto L_0x00f0
                r1 = r31
                r3 = r5
                r5 = r6
                r21 = r5
                goto L_0x0046
            L_0x0181:
                r4 = -1
                r1 = r31
                r7 = r22
                goto L_0x0023
            L_0x0188:
                if (r8 != 0) goto L_0x018d
                r22 = 0
                goto L_0x018f
            L_0x018d:
                r22 = r9
            L_0x018f:
                okhttp3.CacheControl r1 = new okhttp3.CacheControl
                r23 = 0
                r9 = r1
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }
    }

    private CacheControl(boolean z11, boolean z12, int i11, int i12, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, boolean z17, boolean z18, String str) {
        this.noCache = z11;
        this.noStore = z12;
        this.maxAgeSeconds = i11;
        this.sMaxAgeSeconds = i12;
        this.isPrivate = z13;
        this.isPublic = z14;
        this.mustRevalidate = z15;
        this.maxStaleSeconds = i13;
        this.minFreshSeconds = i14;
        this.onlyIfCached = z16;
        this.noTransform = z17;
        this.immutable = z18;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z11, boolean z12, int i11, int i12, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, boolean z17, boolean z18, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, z12, i11, i12, z13, z14, z15, i13, i14, z16, z17, z18, str);
    }

    @JvmStatic
    @NotNull
    public static final CacheControl parse(@NotNull Headers headers) {
        return Companion.parse(headers);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    @JvmName(name = "-deprecated_immutable")
    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m7926deprecated_immutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxAgeSeconds")
    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m7927deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxStaleSeconds")
    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m7928deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    @JvmName(name = "-deprecated_minFreshSeconds")
    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m7929deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    @JvmName(name = "-deprecated_mustRevalidate")
    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m7930deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    @JvmName(name = "-deprecated_noCache")
    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m7931deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    @JvmName(name = "-deprecated_noStore")
    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m7932deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    @JvmName(name = "-deprecated_noTransform")
    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m7933deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    @JvmName(name = "-deprecated_onlyIfCached")
    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m7934deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_sMaxAgeSeconds")
    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m7935deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @JvmName(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @JvmName(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @NotNull
    public String toString() {
        boolean z11;
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (noCache()) {
            sb2.append("no-cache, ");
        }
        if (noStore()) {
            sb2.append("no-store, ");
        }
        if (maxAgeSeconds() != -1) {
            sb2.append("max-age=");
            sb2.append(maxAgeSeconds());
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        }
        if (sMaxAgeSeconds() != -1) {
            sb2.append("s-maxage=");
            sb2.append(sMaxAgeSeconds());
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        }
        if (isPrivate()) {
            sb2.append("private, ");
        }
        if (isPublic()) {
            sb2.append("public, ");
        }
        if (mustRevalidate()) {
            sb2.append("must-revalidate, ");
        }
        if (maxStaleSeconds() != -1) {
            sb2.append("max-stale=");
            sb2.append(maxStaleSeconds());
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        }
        if (minFreshSeconds() != -1) {
            sb2.append("min-fresh=");
            sb2.append(minFreshSeconds());
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        }
        if (onlyIfCached()) {
            sb2.append("only-if-cached, ");
        }
        if (noTransform()) {
            sb2.append("no-transform, ");
        }
        if (immutable()) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = sb3;
        return sb3;
    }
}
