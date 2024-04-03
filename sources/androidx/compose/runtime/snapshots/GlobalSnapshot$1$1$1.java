package androidx.compose.runtime.snapshots;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class GlobalSnapshot$1$1$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Function1<Object, Unit>> f9517g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalSnapshot$1$1$1(List<Function1<Object, Unit>> list) {
        super(1);
        this.f9517g = list;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "state");
        List<Function1<Object, Unit>> list = this.f9517g;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).invoke(obj);
        }
    }
}
