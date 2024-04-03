package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Measurable> f2528g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Placeable[] f2529h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> f2530i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f2531j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f2532k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int[] f2533l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ LayoutOrientation f2534m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ RowColumnParentData[] f2535n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CrossAxisAlignment f2536o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f2537p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f2538q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4(List<? extends Measurable> list, Placeable[] placeableArr, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, int i11, MeasureScope measureScope, int[] iArr, LayoutOrientation layoutOrientation, RowColumnParentData[] rowColumnParentDataArr, CrossAxisAlignment crossAxisAlignment, int i12, Ref.IntRef intRef) {
        super(1);
        this.f2528g = list;
        this.f2529h = placeableArr;
        this.f2530i = function5;
        this.f2531j = i11;
        this.f2532k = measureScope;
        this.f2533l = iArr;
        this.f2534m = layoutOrientation;
        this.f2535n = rowColumnParentDataArr;
        this.f2536o = crossAxisAlignment;
        this.f2537p = i12;
        this.f2538q = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        LayoutDirection layoutDirection;
        int[] iArr;
        int i11;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        int size = this.f2528g.size();
        int[] iArr2 = new int[size];
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            Placeable placeable = this.f2529h[i13];
            Intrinsics.checkNotNull(placeable);
            iArr2[i13] = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable, this.f2534m);
        }
        this.f2530i.invoke(Integer.valueOf(this.f2531j), iArr2, this.f2532k.getLayoutDirection(), this.f2532k, this.f2533l);
        Placeable[] placeableArr = this.f2529h;
        RowColumnParentData[] rowColumnParentDataArr = this.f2535n;
        CrossAxisAlignment crossAxisAlignment = this.f2536o;
        int i14 = this.f2537p;
        LayoutOrientation layoutOrientation = this.f2534m;
        MeasureScope measureScope = this.f2532k;
        Ref.IntRef intRef = this.f2538q;
        int[] iArr3 = this.f2533l;
        int length = placeableArr.length;
        int i15 = 0;
        while (i12 < length) {
            Placeable placeable2 = placeableArr[i12];
            int i16 = i15 + 1;
            Intrinsics.checkNotNull(placeable2);
            CrossAxisAlignment access$getCrossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr[i15]);
            if (access$getCrossAxisAlignment == null) {
                access$getCrossAxisAlignment = crossAxisAlignment;
            }
            int access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize = i14 - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable2, layoutOrientation);
            LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
            if (layoutOrientation == layoutOrientation2) {
                layoutDirection = LayoutDirection.Ltr;
            } else {
                layoutDirection = measureScope.getLayoutDirection();
            }
            Placeable[] placeableArr2 = placeableArr;
            LayoutDirection layoutDirection2 = layoutDirection;
            int i17 = length;
            int align$foundation_layout_release = access$getCrossAxisAlignment.align$foundation_layout_release(access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize, layoutDirection2, placeable2, intRef.element);
            if (layoutOrientation == layoutOrientation2) {
                iArr = iArr3;
                i11 = i12;
                Placeable.PlacementScope.place$default(placementScope, placeable2, iArr3[i15], align$foundation_layout_release, 0.0f, 4, (Object) null);
            } else {
                iArr = iArr3;
                i11 = i12;
                Placeable.PlacementScope.place$default(placementScope, placeable2, align$foundation_layout_release, iArr[i15], 0.0f, 4, (Object) null);
            }
            i12 = i11 + 1;
            i15 = i16;
            length = i17;
            placeableArr = placeableArr2;
            iArr3 = iArr;
        }
    }
}
