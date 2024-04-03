package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$OneRowSnackbar$2$measure$4 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f8267g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8268h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f8269i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8270j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8271k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f8272l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f8273m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f8274n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$OneRowSnackbar$2$measure$4(Placeable placeable, int i11, Placeable placeable2, int i12, int i13, Placeable placeable3, int i14, int i15) {
        super(1);
        this.f8267g = placeable;
        this.f8268h = i11;
        this.f8269i = placeable2;
        this.f8270j = i12;
        this.f8271k = i13;
        this.f8272l = placeable3;
        this.f8273m = i14;
        this.f8274n = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f8267g, 0, this.f8268h, 0.0f, 4, (Object) null);
        Placeable placeable = this.f8269i;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, this.f8270j, this.f8271k, 0.0f, 4, (Object) null);
        }
        Placeable placeable2 = this.f8272l;
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, this.f8273m, this.f8274n, 0.0f, 4, (Object) null);
        }
    }
}
