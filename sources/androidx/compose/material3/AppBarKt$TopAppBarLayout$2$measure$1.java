package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$TopAppBarLayout$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f6474g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6475h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f6476i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f6477j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f6478k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f6479l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f6480m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f6481n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6482o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6483p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBarLayout$2$measure$1(Placeable placeable, int i11, Placeable placeable2, Arrangement.Horizontal horizontal, long j11, Placeable placeable3, MeasureScope measureScope, Arrangement.Vertical vertical, int i12, int i13) {
        super(1);
        this.f6474g = placeable;
        this.f6475h = i11;
        this.f6476i = placeable2;
        this.f6477j = horizontal;
        this.f6478k = j11;
        this.f6479l = placeable3;
        this.f6480m = measureScope;
        this.f6481n = vertical;
        this.f6482o = i12;
        this.f6483p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        int max;
        int i11;
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable placeable = this.f6474g;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (this.f6475h - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
        Placeable placeable2 = this.f6476i;
        Arrangement.Horizontal horizontal = this.f6477j;
        Arrangement arrangement = Arrangement.INSTANCE;
        if (Intrinsics.areEqual((Object) horizontal, (Object) arrangement.getCenter())) {
            max = (Constraints.m5422getMaxWidthimpl(this.f6478k) - this.f6476i.getWidth()) / 2;
        } else if (Intrinsics.areEqual((Object) horizontal, (Object) arrangement.getEnd())) {
            max = (Constraints.m5422getMaxWidthimpl(this.f6478k) - this.f6476i.getWidth()) - this.f6479l.getWidth();
        } else {
            max = Math.max(this.f6480m.m5441roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), this.f6474g.getWidth());
        }
        int i15 = max;
        Arrangement.Vertical vertical = this.f6481n;
        if (Intrinsics.areEqual((Object) vertical, (Object) arrangement.getCenter())) {
            i14 = (this.f6475h - this.f6476i.getHeight()) / 2;
        } else if (Intrinsics.areEqual((Object) vertical, (Object) arrangement.getBottom())) {
            if (this.f6482o == 0) {
                i13 = this.f6475h;
                i12 = this.f6476i.getHeight();
            } else {
                i13 = this.f6475h - this.f6476i.getHeight();
                i12 = Math.max(0, (this.f6482o - this.f6476i.getHeight()) + this.f6483p);
            }
            i14 = i13 - i12;
        } else {
            i11 = 0;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i15, i11, 0.0f, 4, (Object) null);
            Placeable.PlacementScope.placeRelative$default(placementScope, this.f6479l, Constraints.m5422getMaxWidthimpl(this.f6478k) - this.f6479l.getWidth(), (this.f6475h - this.f6479l.getHeight()) / 2, 0.0f, 4, (Object) null);
        }
        i11 = i14;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i15, i11, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f6479l, Constraints.m5422getMaxWidthimpl(this.f6478k) - this.f6479l.getWidth(), (this.f6475h - this.f6479l.getHeight()) / 2, 0.0f, 4, (Object) null);
    }
}
