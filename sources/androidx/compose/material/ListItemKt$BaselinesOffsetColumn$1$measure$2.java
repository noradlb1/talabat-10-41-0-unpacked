package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt$BaselinesOffsetColumn$1$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Placeable> f4628g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer[] f4629h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$BaselinesOffsetColumn$1$measure$2(List<? extends Placeable> list, Integer[] numArr) {
        super(1);
        this.f4628g = list;
        this.f4629h = numArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Placeable> list = this.f4628g;
        Integer[] numArr = this.f4629h;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i11), 0, numArr[i11].intValue(), 0.0f, 4, (Object) null);
        }
    }
}
