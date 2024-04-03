package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J(\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0017J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u0010\u001a\u00020\t2\u001e\u0010\u0016\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0017\u0012\u0004\u0012\u00020\n0\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceRequestCache;", "", "()V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text_release", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/TypefaceResult;", "size", "", "getSize$ui_text_release", "()I", "get", "typefaceRequest", "get$ui_text_release", "preWarmCache", "", "typefaceRequests", "", "resolveTypeface", "Lkotlin/Function1;", "runCached", "Landroidx/compose/runtime/State;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypefaceRequestCache {
    @NotNull
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();
    /* access modifiers changed from: private */
    @NotNull
    public final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>(16);

    @Nullable
    public final TypefaceResult get$ui_text_release(@NotNull TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResult;
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        synchronized (this.lock) {
            typefaceResult = this.resultCache.get(typefaceRequest);
        }
        return typefaceResult;
    }

    @NotNull
    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    public final int getSize$ui_text_release() {
        int size;
        synchronized (this.lock) {
            size = this.resultCache.size();
        }
        return size;
    }

    public final void preWarmCache(@NotNull List<TypefaceRequest> list, @NotNull Function1<? super TypefaceRequest, ? extends TypefaceResult> function1) {
        TypefaceResult typefaceResult;
        Intrinsics.checkNotNullParameter(list, "typefaceRequests");
        Intrinsics.checkNotNullParameter(function1, "resolveTypeface");
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            TypefaceRequest typefaceRequest = list.get(i11);
            synchronized (this.lock) {
                typefaceResult = this.resultCache.get(typefaceRequest);
            }
            if (typefaceResult == null) {
                try {
                    TypefaceResult typefaceResult2 = (TypefaceResult) function1.invoke(typefaceRequest);
                    if (!(typefaceResult2 instanceof TypefaceResult.Async)) {
                        synchronized (this.lock) {
                            TypefaceResult put = this.resultCache.put(typefaceRequest, typefaceResult2);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e11) {
                    throw new IllegalStateException("Could not load font", e11);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r5 = (androidx.compose.ui.text.font.TypefaceResult) r5.invoke(new androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r0 = r3.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        if (r3.resultCache.get(r4) != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r5.getCacheable() == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r3.resultCache.put(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
        throw new java.lang.IllegalStateException("Could not load font", r4);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.State<java.lang.Object> runCached(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.TypefaceRequest r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.font.TypefaceResult, kotlin.Unit>, ? extends androidx.compose.ui.text.font.TypefaceResult> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "typefaceRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "resolveTypeface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r3.lock
            monitor-enter(r0)
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x0059 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0059 }
            androidx.compose.ui.text.font.TypefaceResult r1 = (androidx.compose.ui.text.font.TypefaceResult) r1     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0027
            boolean r2 = r1.getCacheable()     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x001f
            monitor-exit(r0)
            return r1
        L_0x001f:
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x0059 }
            java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x0059 }
            androidx.compose.ui.text.font.TypefaceResult r1 = (androidx.compose.ui.text.font.TypefaceResult) r1     // Catch:{ all -> 0x0059 }
        L_0x0027:
            monitor-exit(r0)
            androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1 r0 = new androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1     // Catch:{ Exception -> 0x0050 }
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0050 }
            java.lang.Object r5 = r5.invoke(r0)     // Catch:{ Exception -> 0x0050 }
            androidx.compose.ui.text.font.TypefaceResult r5 = (androidx.compose.ui.text.font.TypefaceResult) r5     // Catch:{ Exception -> 0x0050 }
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r3.lock
            monitor-enter(r0)
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x004d }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0049
            boolean r1 = r5.getCacheable()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0049
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x004d }
            r1.put(r4, r5)     // Catch:{ all -> 0x004d }
        L_0x0049:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004d }
            monitor-exit(r0)
            return r5
        L_0x004d:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x0050:
            r4 = move-exception
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Could not load font"
            r5.<init>(r0, r4)
            throw r5
        L_0x0059:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.TypefaceRequestCache.runCached(androidx.compose.ui.text.font.TypefaceRequest, kotlin.jvm.functions.Function1):androidx.compose.runtime.State");
    }
}
