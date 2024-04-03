package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt$OneRowSnackbar$2$measure$4 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f5404g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5405h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f5406i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5407j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5408k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$OneRowSnackbar$2$measure$4(Placeable placeable, int i11, Placeable placeable2, int i12, int i13) {
        super(1);
        this.f5404g = placeable;
        this.f5405h = i11;
        this.f5406i = placeable2;
        this.f5407j = i12;
        this.f5408k = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f5404g, 0, this.f5405h, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f5406i, this.f5407j, this.f5408k, 0.0f, 4, (Object) null);
    }
}
