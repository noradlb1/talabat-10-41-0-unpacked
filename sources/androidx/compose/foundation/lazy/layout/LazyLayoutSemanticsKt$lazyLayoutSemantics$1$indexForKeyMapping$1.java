package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1 extends Lambda implements Function1<Object, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f3040g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(1);
        this.f3040g = lazyLayoutItemProvider;
    }

    @NotNull
    public final Integer invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "needle");
        int itemCount = this.f3040g.getItemCount();
        int i11 = 0;
        while (true) {
            if (i11 >= itemCount) {
                i11 = -1;
                break;
            } else if (Intrinsics.areEqual(this.f3040g.getKey(i11), obj)) {
                break;
            } else {
                i11++;
            }
        }
        return Integer.valueOf(i11);
    }
}
