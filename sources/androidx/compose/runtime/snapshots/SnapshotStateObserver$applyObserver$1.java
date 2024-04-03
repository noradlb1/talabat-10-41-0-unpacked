package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "applied", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateObserver$applyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnapshotStateObserver f9542g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateObserver$applyObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(2);
        this.f9542g = snapshotStateObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) (Set) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
        boolean z11;
        Intrinsics.checkNotNullParameter(set, "applied");
        Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
        SnapshotStateObserver snapshotStateObserver = this.f9542g;
        synchronized (snapshotStateObserver.observedScopeMaps) {
            MutableVector access$getObservedScopeMaps$p = snapshotStateObserver.observedScopeMaps;
            int size = access$getObservedScopeMaps$p.getSize();
            z11 = false;
            if (size > 0) {
                Object[] content = access$getObservedScopeMaps$p.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                boolean z12 = false;
                do {
                    if (!((SnapshotStateObserver.ObservedScopeMap) content[i11]).recordInvalidation(set)) {
                        if (!z12) {
                            z12 = false;
                            i11++;
                        }
                    }
                    z12 = true;
                    i11++;
                } while (i11 < size);
                z11 = z12;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z11) {
            Function1 access$getOnChangedExecutor$p = this.f9542g.onChangedExecutor;
            final SnapshotStateObserver snapshotStateObserver2 = this.f9542g;
            access$getOnChangedExecutor$p.invoke(new Function0<Unit>() {
                public final void invoke() {
                    SnapshotStateObserver snapshotStateObserver = snapshotStateObserver2;
                    synchronized (snapshotStateObserver.observedScopeMaps) {
                        MutableVector access$getObservedScopeMaps$p = snapshotStateObserver.observedScopeMaps;
                        int size = access$getObservedScopeMaps$p.getSize();
                        if (size > 0) {
                            Object[] content = access$getObservedScopeMaps$p.getContent();
                            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                            int i11 = 0;
                            do {
                                ((SnapshotStateObserver.ObservedScopeMap) content[i11]).notifyInvalidatedScopes();
                                i11++;
                            } while (i11 < size);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            });
        }
    }
}
