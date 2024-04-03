package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class Snapshot$Companion$registerGlobalWriteObserver$2 implements ObserverHandle {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<Object, Unit> f9525a;

    public Snapshot$Companion$registerGlobalWriteObserver$2(Function1<Object, Unit> function1) {
        this.f9525a = function1;
    }

    public final void dispose() {
        Function1<Object, Unit> function1 = this.f9525a;
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.globalWriteObservers.remove(function1);
        }
        SnapshotKt.advanceGlobalSnapshot();
    }
}
