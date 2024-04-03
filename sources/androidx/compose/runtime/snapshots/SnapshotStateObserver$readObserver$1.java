package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateObserver$readObserver$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnapshotStateObserver f9546g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateObserver$readObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(1);
        this.f9546g = snapshotStateObserver;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "state");
        if (!this.f9546g.isPaused) {
            MutableVector access$getObservedScopeMaps$p = this.f9546g.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = this.f9546g;
            synchronized (access$getObservedScopeMaps$p) {
                SnapshotStateObserver.ObservedScopeMap access$getCurrentMap$p = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(access$getCurrentMap$p);
                access$getCurrentMap$p.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
