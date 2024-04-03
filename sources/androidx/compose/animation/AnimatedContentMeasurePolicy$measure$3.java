package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentMeasurePolicy$measure$3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable[] f1088g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AnimatedContentMeasurePolicy f1089h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f1090i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f1091j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentMeasurePolicy$measure$3(Placeable[] placeableArr, AnimatedContentMeasurePolicy animatedContentMeasurePolicy, int i11, int i12) {
        super(1);
        this.f1088g = placeableArr;
        this.f1089h = animatedContentMeasurePolicy;
        this.f1090i = i11;
        this.f1091j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable[] placeableArr = this.f1088g;
        AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this.f1089h;
        int i11 = this.f1090i;
        int i12 = this.f1091j;
        for (Placeable placeable : placeableArr) {
            if (placeable != null) {
                long r82 = animatedContentMeasurePolicy.getRootScope().getContentAlignment$animation_release().m2554alignKFBX0sM(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()), IntSizeKt.IntSize(i11, i12), LayoutDirection.Ltr);
                Placeable.PlacementScope.place$default(placementScope, placeable, IntOffset.m5596getXimpl(r82), IntOffset.m5597getYimpl(r82), 0.0f, 4, (Object) null);
            }
        }
    }
}
