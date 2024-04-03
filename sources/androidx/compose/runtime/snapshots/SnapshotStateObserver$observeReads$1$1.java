package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateObserver$observeReads$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnapshotStateObserver f9544g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f9545h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateObserver$observeReads$1$1(SnapshotStateObserver snapshotStateObserver, Function0<Unit> function0) {
        super(0);
        this.f9544g = snapshotStateObserver;
        this.f9545h = function0;
    }

    public final void invoke() {
        Snapshot.Companion.observe(this.f9544g.readObserver, (Function1<Object, Unit>) null, this.f9545h);
    }
}
