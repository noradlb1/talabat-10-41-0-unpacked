package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.View;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u000201B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "view", "Landroid/view/View;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroid/view/View;)V", "averagePrecomposeTimeNs", "", "averagePremeasureTimeNs", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "isActive", "", "prefetchRequests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$PrefetchRequest;", "prefetchScheduled", "calculateAverageTime", "new", "current", "doFrame", "", "frameTimeNanos", "enoughTimeLeft", "now", "nextFrame", "average", "onAbandoned", "onForgotten", "onRemembered", "run", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Companion", "PrefetchRequest", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
public final class LazyLayoutPrefetcher implements RememberObserver, LazyLayoutPrefetchState.Prefetcher, Runnable, Choreographer.FrameCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static long frameIntervalNs;
    private long averagePrecomposeTimeNs;
    private long averagePremeasureTimeNs;
    private final Choreographer choreographer = Choreographer.getInstance();
    private boolean isActive;
    @NotNull
    private final LazyLayoutItemContentFactory itemContentFactory;
    @NotNull
    private final MutableVector<PrefetchRequest> prefetchRequests = new MutableVector<>(new PrefetchRequest[16], 0);
    private boolean prefetchScheduled;
    @NotNull
    private final LazyLayoutPrefetchState prefetchState;
    @NotNull
    private final SubcomposeLayoutState subcomposeLayoutState;
    @NotNull
    private final View view;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$Companion;", "", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
            if (r5 >= 30.0f) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void calculateFrameIntervalIfNeeded(android.view.View r5) {
            /*
                r4 = this;
                long r0 = androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.frameIntervalNs
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002c
                android.view.Display r0 = r5.getDisplay()
                boolean r5 = r5.isInEditMode()
                if (r5 != 0) goto L_0x0021
                if (r0 == 0) goto L_0x0021
                float r5 = r0.getRefreshRate()
                r0 = 1106247680(0x41f00000, float:30.0)
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 < 0) goto L_0x0021
                goto L_0x0023
            L_0x0021:
                r5 = 1114636288(0x42700000, float:60.0)
            L_0x0023:
                r0 = 1000000000(0x3b9aca00, float:0.0047237873)
                float r0 = (float) r0
                float r0 = r0 / r5
                long r0 = (long) r0
                androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.frameIntervalNs = r0
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.Companion.calculateFrameIntervalIfNeeded(android.view.View):void");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$PrefetchRequest;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(IJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "canceled", "", "getCanceled", "()Z", "setCanceled", "(Z)V", "getConstraints-msEJaDk", "()J", "J", "getIndex", "()I", "measured", "getMeasured", "setMeasured", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "getPrecomposeHandle", "()Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "setPrecomposeHandle", "(Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;)V", "cancel", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PrefetchRequest implements LazyLayoutPrefetchState.PrefetchHandle {
        private boolean canceled;
        private final long constraints;
        private final int index;
        private boolean measured;
        @Nullable
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;

        private PrefetchRequest(int i11, long j11) {
            this.index = i11;
            this.constraints = j11;
        }

        public /* synthetic */ PrefetchRequest(int i11, long j11, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, j11);
        }

        public void cancel() {
            if (!this.canceled) {
                this.canceled = true;
                SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
                if (precomposedSlotHandle != null) {
                    precomposedSlotHandle.dispose();
                }
                this.precomposeHandle = null;
            }
        }

        public final boolean getCanceled() {
            return this.canceled;
        }

        /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
        public final long m763getConstraintsmsEJaDk() {
            return this.constraints;
        }

        public final int getIndex() {
            return this.index;
        }

        public final boolean getMeasured() {
            return this.measured;
        }

        @Nullable
        public final SubcomposeLayoutState.PrecomposedSlotHandle getPrecomposeHandle() {
            return this.precomposeHandle;
        }

        public final void setCanceled(boolean z11) {
            this.canceled = z11;
        }

        public final void setMeasured(boolean z11) {
            this.measured = z11;
        }

        public final void setPrecomposeHandle(@Nullable SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle) {
            this.precomposeHandle = precomposedSlotHandle;
        }
    }

    public LazyLayoutPrefetcher(@NotNull LazyLayoutPrefetchState lazyLayoutPrefetchState, @NotNull SubcomposeLayoutState subcomposeLayoutState2, @NotNull LazyLayoutItemContentFactory lazyLayoutItemContentFactory, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(lazyLayoutPrefetchState, "prefetchState");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState2, "subcomposeLayoutState");
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.prefetchState = lazyLayoutPrefetchState;
        this.subcomposeLayoutState = subcomposeLayoutState2;
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.view = view2;
        Companion.calculateFrameIntervalIfNeeded(view2);
    }

    private final long calculateAverageTime(long j11, long j12) {
        if (j12 == 0) {
            return j11;
        }
        long j13 = (long) 4;
        return (j11 / j13) + ((j12 / j13) * ((long) 3));
    }

    private final boolean enoughTimeLeft(long j11, long j12, long j13) {
        return j11 > j12 || j11 + j13 < j12;
    }

    public void doFrame(long j11) {
        if (this.isActive) {
            this.view.post(this);
        }
    }

    public void onAbandoned() {
    }

    public void onForgotten() {
        this.isActive = false;
        this.prefetchState.setPrefetcher$foundation_release((LazyLayoutPrefetchState.Prefetcher) null);
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    public void onRemembered() {
        this.prefetchState.setPrefetcher$foundation_release(this);
        this.isActive = true;
    }

    public void run() {
        boolean z11;
        if (this.prefetchRequests.isEmpty() || !this.prefetchScheduled || !this.isActive || this.view.getWindowVisibility() != 0) {
            this.prefetchScheduled = false;
            return;
        }
        long nanos = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime()) + frameIntervalNs;
        boolean z12 = false;
        while (this.prefetchRequests.isNotEmpty() && !z12) {
            PrefetchRequest prefetchRequest = (PrefetchRequest) this.prefetchRequests.getContent()[0];
            LazyLayoutItemProvider invoke = this.itemContentFactory.getItemProvider().invoke();
            if (!prefetchRequest.getCanceled()) {
                int itemCount = invoke.getItemCount();
                int index = prefetchRequest.getIndex();
                if (index < 0 || index >= itemCount) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    if (prefetchRequest.getPrecomposeHandle() == null) {
                        Trace.beginSection("compose:lazylist:prefetch:compose");
                        try {
                            long nanoTime = System.nanoTime();
                            if (enoughTimeLeft(nanoTime, nanos, this.averagePrecomposeTimeNs)) {
                                Object key = invoke.getKey(prefetchRequest.getIndex());
                                prefetchRequest.setPrecomposeHandle(this.subcomposeLayoutState.precompose(key, this.itemContentFactory.getContent(prefetchRequest.getIndex(), key)));
                                this.averagePrecomposeTimeNs = calculateAverageTime(System.nanoTime() - nanoTime, this.averagePrecomposeTimeNs);
                            } else {
                                z12 = true;
                            }
                            Unit unit = Unit.INSTANCE;
                        } finally {
                            Trace.endSection();
                        }
                    } else if (!prefetchRequest.getMeasured()) {
                        Trace.beginSection("compose:lazylist:prefetch:measure");
                        try {
                            long nanoTime2 = System.nanoTime();
                            if (enoughTimeLeft(nanoTime2, nanos, this.averagePremeasureTimeNs)) {
                                SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle = prefetchRequest.getPrecomposeHandle();
                                Intrinsics.checkNotNull(precomposeHandle);
                                int placeablesCount = precomposeHandle.getPlaceablesCount();
                                for (int i11 = 0; i11 < placeablesCount; i11++) {
                                    precomposeHandle.m4566premeasure0kLqBqw(i11, prefetchRequest.m763getConstraintsmsEJaDk());
                                }
                                this.averagePremeasureTimeNs = calculateAverageTime(System.nanoTime() - nanoTime2, this.averagePremeasureTimeNs);
                                this.prefetchRequests.removeAt(0);
                            } else {
                                Unit unit2 = Unit.INSTANCE;
                                z12 = true;
                            }
                        } finally {
                            Trace.endSection();
                        }
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            }
            this.prefetchRequests.removeAt(0);
        }
        if (z12) {
            this.choreographer.postFrameCallback(this);
        } else {
            this.prefetchScheduled = false;
        }
    }

    @NotNull
    /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
    public LazyLayoutPrefetchState.PrefetchHandle m762schedulePrefetch0kLqBqw(int i11, long j11) {
        PrefetchRequest prefetchRequest = new PrefetchRequest(i11, j11, (DefaultConstructorMarker) null);
        this.prefetchRequests.add(prefetchRequest);
        if (!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post(this);
        }
        return prefetchRequest;
    }
}
