package androidx.compose.ui.window;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt$DialogLayout$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Placeable> f10351g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidDialog_androidKt$DialogLayout$1$measure$1(List<? extends Placeable> list) {
        super(1);
        this.f10351g = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Placeable> list = this.f10351g;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i11), 0, 0, 0.0f, 4, (Object) null);
        }
    }
}
