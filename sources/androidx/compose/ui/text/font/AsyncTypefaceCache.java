package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalTextApi
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0017JK\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u001e\u0010\u0019\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\bø\u0001\u0003R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\fX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "", "()V", "PermanentFailure", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "Ljava/lang/Object;", "cacheLock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "permanentCache", "Landroidx/compose/ui/text/caches/SimpleArrayMap;", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "get", "font", "Landroidx/compose/ui/text/font/Font;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "get-1ASDuI8", "put", "", "result", "forever", "", "runCached", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCachedBlocking", "Lkotlin/Function0;", "AsyncTypefaceResult", "Key", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AsyncTypefaceCache {
    @NotNull
    private final Object PermanentFailure = AsyncTypefaceResult.m5081constructorimpl((Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public final SynchronizedObject cacheLock = Synchronization_jvmKt.createSynchronizedObject();
    /* access modifiers changed from: private */
    @NotNull
    public final SimpleArrayMap<Key, AsyncTypefaceResult> permanentCache = new SimpleArrayMap<>(0, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public final LruCache<Key, AsyncTypefaceResult> resultCache = new LruCache<>(16);

    @JvmInline
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "", "result", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isPermanentFailure", "", "isPermanentFailure-impl", "(Ljava/lang/Object;)Z", "getResult", "()Ljava/lang/Object;", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AsyncTypefaceResult {
        @Nullable
        private final Object result;

        private /* synthetic */ AsyncTypefaceResult(Object obj) {
            this.result = obj;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ AsyncTypefaceResult m5080boximpl(Object obj) {
            return new AsyncTypefaceResult(obj);
        }

        @NotNull
        /* renamed from: constructor-impl  reason: not valid java name */
        public static Object m5081constructorimpl(@Nullable Object obj) {
            return obj;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5082equalsimpl(Object obj, Object obj2) {
            return (obj2 instanceof AsyncTypefaceResult) && Intrinsics.areEqual(obj, ((AsyncTypefaceResult) obj2).m5087unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5083equalsimpl0(Object obj, Object obj2) {
            return Intrinsics.areEqual(obj, obj2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5084hashCodeimpl(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        /* renamed from: isPermanentFailure-impl  reason: not valid java name */
        public static final boolean m5085isPermanentFailureimpl(Object obj) {
            return obj == null;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5086toStringimpl(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return m5082equalsimpl(this.result, obj);
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        public int hashCode() {
            return m5084hashCodeimpl(this.result);
        }

        public String toString() {
            return m5086toStringimpl(this.result);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ Object m5087unboximpl() {
            return this.result;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "", "font", "Landroidx/compose/ui/text/font/Font;", "loaderKey", "(Landroidx/compose/ui/text/font/Font;Ljava/lang/Object;)V", "getFont", "()Landroidx/compose/ui/text/font/Font;", "getLoaderKey", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Key {
        @NotNull
        private final Font font;
        @Nullable
        private final Object loaderKey;

        public Key(@NotNull Font font2, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(font2, "font");
            this.font = font2;
            this.loaderKey = obj;
        }

        public static /* synthetic */ Key copy$default(Key key, Font font2, Object obj, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                font2 = key.font;
            }
            if ((i11 & 2) != 0) {
                obj = key.loaderKey;
            }
            return key.copy(font2, obj);
        }

        @NotNull
        public final Font component1() {
            return this.font;
        }

        @Nullable
        public final Object component2() {
            return this.loaderKey;
        }

        @NotNull
        public final Key copy(@NotNull Font font2, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(font2, "font");
            return new Key(font2, obj);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual((Object) this.font, (Object) key.font) && Intrinsics.areEqual(this.loaderKey, key.loaderKey);
        }

        @NotNull
        public final Font getFont() {
            return this.font;
        }

        @Nullable
        public final Object getLoaderKey() {
            return this.loaderKey;
        }

        public int hashCode() {
            int hashCode = this.font.hashCode() * 31;
            Object obj = this.loaderKey;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        @NotNull
        public String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }
    }

    public static /* synthetic */ void put$default(AsyncTypefaceCache asyncTypefaceCache, Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z11, int i11, Object obj2) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        asyncTypefaceCache.put(font, platformFontLoader, obj, z11);
    }

    @Nullable
    /* renamed from: get-1ASDuI8  reason: not valid java name */
    public final AsyncTypefaceResult m5079get1ASDuI8(@NotNull Font font, @NotNull PlatformFontLoader platformFontLoader) {
        AsyncTypefaceResult asyncTypefaceResult;
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            asyncTypefaceResult = this.resultCache.get(key);
            if (asyncTypefaceResult == null) {
                asyncTypefaceResult = this.permanentCache.get(key);
            }
        }
        return asyncTypefaceResult;
    }

    public final void put(@NotNull Font font, @NotNull PlatformFontLoader platformFontLoader, @Nullable Object obj, boolean z11) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            if (obj == null) {
                try {
                    AsyncTypefaceResult put = this.permanentCache.put(key, AsyncTypefaceResult.m5080boximpl(this.PermanentFailure));
                } catch (Throwable th2) {
                    throw th2;
                }
            } else if (z11) {
                AsyncTypefaceResult put2 = this.permanentCache.put(key, AsyncTypefaceResult.m5080boximpl(AsyncTypefaceResult.m5081constructorimpl(obj)));
            } else {
                AsyncTypefaceResult put3 = this.resultCache.put(key, AsyncTypefaceResult.m5080boximpl(AsyncTypefaceResult.m5081constructorimpl(obj)));
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object runCached(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r6, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.PlatformFontLoader r7, boolean r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<java.lang.Object> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = (androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1) r0
            int r1 = r0.f10176m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f10176m = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            r0.<init>(r5, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f10174k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f10176m
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            boolean r8 = r0.f10173j
            java.lang.Object r6 = r0.f10172i
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r6 = (androidx.compose.ui.text.font.AsyncTypefaceCache.Key) r6
            java.lang.Object r7 = r0.f10171h
            androidx.compose.ui.text.font.AsyncTypefaceCache r7 = (androidx.compose.ui.text.font.AsyncTypefaceCache) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007a
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r10 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key
            java.lang.Object r7 = r7.getCacheKey()
            r10.<init>(r6, r7)
            androidx.compose.ui.text.platform.SynchronizedObject r6 = r5.cacheLock
            monitor-enter(r6)
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r5.resultCache     // Catch:{ all -> 0x00b0 }
            java.lang.Object r7 = r7.get(r10)     // Catch:{ all -> 0x00b0 }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r7     // Catch:{ all -> 0x00b0 }
            if (r7 != 0) goto L_0x005c
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r5.permanentCache     // Catch:{ all -> 0x00b0 }
            java.lang.Object r7 = r7.get(r10)     // Catch:{ all -> 0x00b0 }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r7     // Catch:{ all -> 0x00b0 }
        L_0x005c:
            if (r7 == 0) goto L_0x0064
            java.lang.Object r7 = r7.m5087unboximpl()     // Catch:{ all -> 0x00b0 }
            monitor-exit(r6)
            return r7
        L_0x0064:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b0 }
            monitor-exit(r6)
            r0.f10171h = r5
            r0.f10172i = r10
            r0.f10173j = r8
            r0.f10176m = r3
            java.lang.Object r6 = r9.invoke(r0)
            if (r6 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r7 = r5
            r4 = r10
            r10 = r6
            r6 = r4
        L_0x007a:
            androidx.compose.ui.text.platform.SynchronizedObject r9 = r7.cacheLock
            monitor-enter(r9)
            if (r10 != 0) goto L_0x008d
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r8 = r7.permanentCache     // Catch:{ all -> 0x008b }
            java.lang.Object r7 = r7.PermanentFailure     // Catch:{ all -> 0x008b }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m5080boximpl(r7)     // Catch:{ all -> 0x008b }
            r8.put(r6, r7)     // Catch:{ all -> 0x008b }
            goto L_0x00aa
        L_0x008b:
            r6 = move-exception
            goto L_0x00ae
        L_0x008d:
            if (r8 == 0) goto L_0x009d
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r7.permanentCache     // Catch:{ all -> 0x008b }
            java.lang.Object r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m5081constructorimpl(r10)     // Catch:{ all -> 0x008b }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m5080boximpl(r8)     // Catch:{ all -> 0x008b }
            r7.put(r6, r8)     // Catch:{ all -> 0x008b }
            goto L_0x00aa
        L_0x009d:
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r7.resultCache     // Catch:{ all -> 0x008b }
            java.lang.Object r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m5081constructorimpl(r10)     // Catch:{ all -> 0x008b }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m5080boximpl(r8)     // Catch:{ all -> 0x008b }
            r7.put(r6, r8)     // Catch:{ all -> 0x008b }
        L_0x00aa:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008b }
            monitor-exit(r9)
            return r10
        L_0x00ae:
            monitor-exit(r9)
            throw r6
        L_0x00b0:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncTypefaceCache.runCached(androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.PlatformFontLoader, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runCachedBlocking(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r11, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.PlatformFontLoader r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends java.lang.Object> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "font"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "platformFontLoader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r10.cacheLock
            monitor-enter(r0)
            r1 = 1
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r2 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key     // Catch:{ all -> 0x005d }
            java.lang.Object r3 = r12.getCacheKey()     // Catch:{ all -> 0x005d }
            r2.<init>(r11, r3)     // Catch:{ all -> 0x005d }
            androidx.compose.ui.text.caches.LruCache r3 = r10.resultCache     // Catch:{ all -> 0x005d }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x005d }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r3 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r3     // Catch:{ all -> 0x005d }
            if (r3 != 0) goto L_0x0035
            androidx.compose.ui.text.caches.SimpleArrayMap r3 = r10.permanentCache     // Catch:{ all -> 0x005d }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ all -> 0x005d }
            r3 = r2
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r3 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r3     // Catch:{ all -> 0x005d }
        L_0x0035:
            if (r3 == 0) goto L_0x0044
            java.lang.Object r11 = r3.m5087unboximpl()     // Catch:{ all -> 0x005d }
            r12 = 2
            kotlin.jvm.internal.InlineMarker.finallyStart(r12)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r12)
            return r11
        L_0x0044:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005d }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            java.lang.Object r13 = r13.invoke()
            r7 = 0
            r8 = 8
            r9 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            put$default(r3, r4, r5, r6, r7, r8, r9)
            return r13
        L_0x005d:
            r11 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncTypefaceCache.runCachedBlocking(androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.PlatformFontLoader, kotlin.jvm.functions.Function0):java.lang.Object");
    }
}
