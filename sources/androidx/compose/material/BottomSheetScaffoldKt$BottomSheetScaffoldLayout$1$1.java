package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4200g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4201h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4202i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4203j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f4204k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4205l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BottomSheetState f4206m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, Composer, Integer, Unit> f4207n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f4208o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f4209p;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(State<Float> state, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11, float f11, Function2<? super Composer, ? super Integer, Unit> function23, BottomSheetState bottomSheetState, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, int i12, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.f4200g = state;
        this.f4201h = function2;
        this.f4202i = function22;
        this.f4203j = i11;
        this.f4204k = f11;
        this.f4205l = function23;
        this.f4206m = bottomSheetState;
        this.f4207n = function3;
        this.f4208o = i12;
        this.f4209p = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1128invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1128invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        Placeable placeable;
        int i11;
        final Placeable placeable2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$SubcomposeLayout");
        int r22 = Constraints.m5422getMaxWidthimpl(j11);
        int r32 = Constraints.m5421getMaxHeightimpl(j11);
        long r42 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 10, (Object) null);
        Placeable r62 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(520491296, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1(this.f4207n, r32, this.f4208o))).get(0).m4508measureBRTryo0(r42);
        int roundToInt = MathKt__MathJVMKt.roundToInt(this.f4200g.getValue().floatValue());
        Function2<Composer, Integer, Unit> function2 = this.f4201h;
        if (function2 != null) {
            placeable = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(1988456983, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1(function2, this.f4208o))).get(0).m4508measureBRTryo0(r42);
        } else {
            placeable = null;
        }
        if (placeable != null) {
            i11 = placeable.getHeight();
        } else {
            i11 = 0;
        }
        final Placeable r11 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Body, ComposableLambdaKt.composableLambdaInstance(1466287989, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(this.f4209p, this.f4204k, this.f4208o))).get(0).m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(r42, 0, 0, 0, r32 - i11, 7, (Object) null));
        Function2<Composer, Integer, Unit> function22 = this.f4202i;
        if (function22 != null) {
            placeable2 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Fab, function22).get(0).m4508measureBRTryo0(r42);
        } else {
            placeable2 = null;
        }
        if (placeable2 != null) {
            i12 = placeable2.getWidth();
        } else {
            i12 = 0;
        }
        if (placeable2 != null) {
            i13 = placeable2.getHeight();
        } else {
            i13 = 0;
        }
        if (FabPosition.m1264equalsimpl0(this.f4203j, FabPosition.Companion.m1268getCenter5ygKITE())) {
            i14 = (r22 - i12) / 2;
        } else {
            i14 = (r22 - i12) - subcomposeMeasureScope2.m5441roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        }
        final int i17 = i14;
        int i18 = i13 / 2;
        if (subcomposeMeasureScope2.m5447toPx0680j_4(this.f4204k) < ((float) i18)) {
            i15 = (roundToInt - i13) - subcomposeMeasureScope2.m5441roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        } else {
            i15 = roundToInt - i18;
        }
        final int i19 = i15;
        final Placeable r19 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.f4205l).get(0).m4508measureBRTryo0(r42);
        int width = (r22 - r19.getWidth()) / 2;
        int i21 = WhenMappings.$EnumSwitchMapping$0[((BottomSheetValue) this.f4206m.getCurrentValue()).ordinal()];
        if (i21 == 1) {
            i16 = i19 - r19.getHeight();
        } else if (i21 == 2) {
            i16 = r32 - r19.getHeight();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final int i22 = i11;
        final Placeable placeable3 = placeable;
        final Placeable placeable4 = r62;
        final int i23 = roundToInt;
        final int i24 = width;
        final int i25 = i16;
        return MeasureScope.CC.p(subcomposeMeasureScope, r22, r32, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(placementScope, r11, 0, i22, 0.0f, 4, (Object) null);
                Placeable placeable = placeable3;
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, i23, 0.0f, 4, (Object) null);
                Placeable placeable2 = placeable2;
                if (placeable2 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i17, i19, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, r19, i24, i25, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
