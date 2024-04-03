package androidx.compose.material3.internal;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Placeable> f9028g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3(List<? extends Placeable> list) {
        super(1);
        this.f9028g = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.f9028g);
        if (lastIndex >= 0) {
            int i11 = 0;
            while (true) {
                Placeable.PlacementScope.placeRelative$default(placementScope, this.f9028g.get(i11), 0, 0, 0.0f, 4, (Object) null);
                if (i11 != lastIndex) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }
}
