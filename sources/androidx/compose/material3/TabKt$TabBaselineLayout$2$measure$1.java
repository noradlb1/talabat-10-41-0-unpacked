package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabKt$TabBaselineLayout$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f8560g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Placeable f8561h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f8562i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8563j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8564k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f8565l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f8566m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$TabBaselineLayout$2$measure$1(Placeable placeable, Placeable placeable2, MeasureScope measureScope, int i11, int i12, Integer num, Integer num2) {
        super(1);
        this.f8560g = placeable;
        this.f8561h = placeable2;
        this.f8562i = measureScope;
        this.f8563j = i11;
        this.f8564k = i12;
        this.f8565l = num;
        this.f8566m = num2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Placeable placeable;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable placeable2 = this.f8560g;
        if (placeable2 != null && (placeable = this.f8561h) != null) {
            MeasureScope measureScope = this.f8562i;
            int i11 = this.f8563j;
            int i12 = this.f8564k;
            Integer num = this.f8565l;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = this.f8566m;
            Intrinsics.checkNotNull(num2);
            TabKt.placeTextAndIcon(placementScope, measureScope, placeable2, placeable, i11, i12, intValue, num2.intValue());
        } else if (placeable2 != null) {
            TabKt.placeTextOrIcon(placementScope, placeable2, this.f8564k);
        } else {
            Placeable placeable3 = this.f8561h;
            if (placeable3 != null) {
                TabKt.placeTextOrIcon(placementScope, placeable3, this.f8564k);
            }
        }
    }
}
