package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotContextElement;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalComposeApi
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0016R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/SnapshotContextElementImpl;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlinx/coroutines/ThreadContextElement;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "updateThreadContext", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SnapshotContextElementImpl implements SnapshotContextElement, ThreadContextElement<Snapshot> {
    @NotNull
    private final Snapshot snapshot;

    public SnapshotContextElementImpl(@NotNull Snapshot snapshot2) {
        Intrinsics.checkNotNullParameter(snapshot2, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        this.snapshot = snapshot2;
    }

    public <R> R fold(R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return SnapshotContextElement.DefaultImpls.fold(this, r11, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return SnapshotContextElement.DefaultImpls.get(this, key);
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return SnapshotContextElement.Key;
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return SnapshotContextElement.DefaultImpls.plus(this, coroutineContext);
    }

    public void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Snapshot snapshot2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        this.snapshot.unsafeLeave(snapshot2);
    }

    @Nullable
    public Snapshot updateThreadContext(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return this.snapshot.unsafeEnter();
    }
}
