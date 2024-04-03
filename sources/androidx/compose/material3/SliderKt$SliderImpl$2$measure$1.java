package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$SliderImpl$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f8066g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8067h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8068i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Placeable f8069j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8070k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8071l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$2$measure$1(Placeable placeable, int i11, int i12, Placeable placeable2, int i13, int i14) {
        super(1);
        this.f8066g = placeable;
        this.f8067h = i11;
        this.f8068i = i12;
        this.f8069j = placeable2;
        this.f8070k = i13;
        this.f8071l = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f8066g, this.f8067h, this.f8068i, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f8069j, this.f8070k, this.f8071l, 0.0f, 4, (Object) null);
    }
}
