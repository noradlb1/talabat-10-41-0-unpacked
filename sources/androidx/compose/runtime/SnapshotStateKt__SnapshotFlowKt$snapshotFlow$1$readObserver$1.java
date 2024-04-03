package androidx.compose.runtime;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Set<Object> f9255g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1(Set<Object> set) {
        super(1);
        this.f9255g = set;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        this.f9255g.add(obj);
    }
}
