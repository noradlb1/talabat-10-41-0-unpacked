package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFoundationApi
@Stable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048@@@X\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "()V", "<set-?>", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "prefetcher", "getPrefetcher$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "setPrefetcher$foundation_release", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;)V", "prefetcher$delegate", "Landroidx/compose/runtime/MutableState;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "PrefetchHandle", "Prefetcher", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutPrefetchState {
    @NotNull
    private final MutableState prefetcher$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u0001\u0002\u0004\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$PrefetchRequest;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface PrefetchHandle {
        void cancel();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Prefetcher {
        @NotNull
        /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
        PrefetchHandle m761schedulePrefetch0kLqBqw(int i11, long j11);
    }

    @Nullable
    public final Prefetcher getPrefetcher$foundation_release() {
        return (Prefetcher) this.prefetcher$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = r0.m761schedulePrefetch0kLqBqw(r2, r3);
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle m760schedulePrefetch0kLqBqw(int r2, long r3) {
        /*
            r1 = this;
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$Prefetcher r0 = r1.getPrefetcher$foundation_release()
            if (r0 == 0) goto L_0x000c
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r2 = r0.m761schedulePrefetch0kLqBqw(r2, r3)
            if (r2 != 0) goto L_0x000e
        L_0x000c:
            androidx.compose.foundation.lazy.layout.DummyHandle r2 = androidx.compose.foundation.lazy.layout.DummyHandle.INSTANCE
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.m760schedulePrefetch0kLqBqw(int, long):androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle");
    }

    public final void setPrefetcher$foundation_release(@Nullable Prefetcher prefetcher) {
        this.prefetcher$delegate.setValue(prefetcher);
    }
}
