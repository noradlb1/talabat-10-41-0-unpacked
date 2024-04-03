package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogBaselineLayout$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f3777g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3778h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f3779i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3780j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogBaselineLayout$2$measure$1(Placeable placeable, int i11, Placeable placeable2, int i12) {
        super(1);
        this.f3777g = placeable;
        this.f3778h = i11;
        this.f3779i = placeable2;
        this.f3780j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable placeable = this.f3777g;
        if (placeable != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, this.f3778h, 0.0f, 4, (Object) null);
        }
        Placeable placeable2 = this.f3779i;
        if (placeable2 != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable2, 0, this.f3780j, 0.0f, 4, (Object) null);
        }
    }
}
