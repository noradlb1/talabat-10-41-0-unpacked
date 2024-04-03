package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u0002H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "R", "", "T", "stash", "Landroidx/paging/TransformablePage;", "invoke"}, k = 3, mv = {1, 4, 2})
public final class SeparatorState$onDrop$1 extends Lambda implements Function1<TransformablePage<T>, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ IntRange f37089g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeparatorState$onDrop$1(IntRange intRange) {
        super(1);
        this.f37089g = intRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((TransformablePage) obj));
    }

    public final boolean invoke(@NotNull TransformablePage<T> transformablePage) {
        Intrinsics.checkNotNullParameter(transformablePage, "stash");
        for (int contains : transformablePage.getOriginalPageOffsets()) {
            if (this.f37089g.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
