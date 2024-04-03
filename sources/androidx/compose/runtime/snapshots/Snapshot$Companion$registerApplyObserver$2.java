package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class Snapshot$Companion$registerApplyObserver$2 implements ObserverHandle {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2<Set<? extends Object>, Snapshot, Unit> f9524a;

    public Snapshot$Companion$registerApplyObserver$2(Function2<? super Set<? extends Object>, ? super Snapshot, Unit> function2) {
        this.f9524a = function2;
    }

    public final void dispose() {
        Function2<Set<? extends Object>, Snapshot, Unit> function2 = this.f9524a;
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.applyObservers.remove(function2);
            Unit unit = Unit.INSTANCE;
        }
    }
}
