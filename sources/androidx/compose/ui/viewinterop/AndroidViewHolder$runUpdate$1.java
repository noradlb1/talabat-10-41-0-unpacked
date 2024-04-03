package androidx.compose.ui.viewinterop;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewHolder$runUpdate$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f10309g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$runUpdate$1(AndroidViewHolder androidViewHolder) {
        super(0);
        this.f10309g = androidViewHolder;
    }

    public final void invoke() {
        if (this.f10309g.hasUpdateBlock) {
            SnapshotStateObserver access$getSnapshotObserver$p = this.f10309g.snapshotObserver;
            AndroidViewHolder androidViewHolder = this.f10309g;
            access$getSnapshotObserver$p.observeReads(androidViewHolder, androidViewHolder.onCommitAffectingUpdate, this.f10309g.getUpdate());
        }
    }
}
