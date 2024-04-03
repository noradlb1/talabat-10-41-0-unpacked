package com.google.accompanist.flowlayout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FlowKt$Flow$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ FlowCrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ List<Integer> $crossAxisPositions;
    final /* synthetic */ List<Integer> $crossAxisSizes;
    final /* synthetic */ MainAxisAlignment $lastLineMainAxisAlignment;
    final /* synthetic */ MainAxisAlignment $mainAxisAlignment;
    final /* synthetic */ int $mainAxisLayoutSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ LayoutOrientation $orientation;
    final /* synthetic */ List<List<Placeable>> $sequences;
    final /* synthetic */ MeasureScope $this_Layout;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlowCrossAxisAlignment.values().length];
            iArr[FlowCrossAxisAlignment.Start.ordinal()] = 1;
            iArr[FlowCrossAxisAlignment.End.ordinal()] = 2;
            iArr[FlowCrossAxisAlignment.Center.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt$Flow$1$measure$1(List<List<Placeable>> list, MeasureScope measureScope, float f11, MainAxisAlignment mainAxisAlignment, MainAxisAlignment mainAxisAlignment2, LayoutOrientation layoutOrientation, int i11, FlowCrossAxisAlignment flowCrossAxisAlignment, List<Integer> list2, List<Integer> list3) {
        super(1);
        this.$sequences = list;
        this.$this_Layout = measureScope;
        this.$mainAxisSpacing = f11;
        this.$mainAxisAlignment = mainAxisAlignment;
        this.$lastLineMainAxisAlignment = mainAxisAlignment2;
        this.$orientation = layoutOrientation;
        this.$mainAxisLayoutSize = i11;
        this.$crossAxisAlignment = flowCrossAxisAlignment;
        this.$crossAxisSizes = list2;
        this.$crossAxisPositions = list3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Arrangement.Vertical vertical;
        int i11;
        boolean z11;
        int i12;
        FlowCrossAxisAlignment flowCrossAxisAlignment;
        List<Integer> list;
        List<Integer> list2;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<List<Placeable>> list3 = this.$sequences;
        MeasureScope measureScope = this.$this_Layout;
        float f11 = this.$mainAxisSpacing;
        MainAxisAlignment mainAxisAlignment = this.$mainAxisAlignment;
        MainAxisAlignment mainAxisAlignment2 = this.$lastLineMainAxisAlignment;
        LayoutOrientation layoutOrientation = this.$orientation;
        int i13 = this.$mainAxisLayoutSize;
        FlowCrossAxisAlignment flowCrossAxisAlignment2 = this.$crossAxisAlignment;
        List<Integer> list4 = this.$crossAxisSizes;
        List<Integer> list5 = this.$crossAxisPositions;
        int i14 = 0;
        for (Object next : list3) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List list6 = (List) next;
            int size = list6.size();
            int[] iArr = new int[size];
            int i16 = 0;
            while (i16 < size) {
                List<Integer> list7 = list5;
                iArr[i16] = FlowKt.Flow_F4y8cZ0$mainAxisSize((Placeable) list6.get(i16), layoutOrientation) + (i16 < CollectionsKt__CollectionsKt.getLastIndex(list6) ? measureScope.m5441roundToPx0680j_4(f11) : 0);
                i16++;
                Placeable.PlacementScope placementScope2 = placementScope;
                list5 = list7;
            }
            List<Integer> list8 = list5;
            if (i14 < CollectionsKt__CollectionsKt.getLastIndex(list3)) {
                vertical = mainAxisAlignment.getArrangement$flowlayout_release();
            } else {
                vertical = mainAxisAlignment2.getArrangement$flowlayout_release();
            }
            int[] iArr2 = new int[size];
            for (int i17 = 0; i17 < size; i17++) {
                iArr2[i17] = 0;
            }
            vertical.arrange(measureScope, i13, iArr, iArr2);
            int i18 = 0;
            for (Object next2 : list6) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Placeable placeable = (Placeable) next2;
                int i21 = WhenMappings.$EnumSwitchMapping$0[flowCrossAxisAlignment2.ordinal()];
                if (i21 == 1) {
                    z11 = false;
                    i11 = 0;
                } else if (i21 == 2) {
                    z11 = false;
                    i11 = list4.get(i14).intValue() - FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable, layoutOrientation);
                } else if (i21 == 3) {
                    z11 = false;
                    i11 = IntOffset.m5597getYimpl(Alignment.Companion.getCenter().m2554alignKFBX0sM(IntSize.Companion.m5643getZeroYbymL2g(), IntSizeKt.IntSize(0, list4.get(i14).intValue() - FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable, layoutOrientation)), LayoutDirection.Ltr));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (layoutOrientation == LayoutOrientation.Horizontal) {
                    int i22 = iArr2[i18];
                    List<Integer> list9 = list8;
                    boolean z12 = z11;
                    list = list4;
                    flowCrossAxisAlignment = flowCrossAxisAlignment2;
                    Placeable.PlacementScope.place$default(placementScope, placeable, i22, list9.get(i14).intValue() + i11, 0.0f, 4, (Object) null);
                    i12 = i14;
                    list2 = list9;
                } else {
                    boolean z13 = z11;
                    flowCrossAxisAlignment = flowCrossAxisAlignment2;
                    List<Integer> list10 = list8;
                    list = list4;
                    int i23 = i14;
                    i12 = i23;
                    list2 = list10;
                    Placeable.PlacementScope.place$default(placementScope, placeable, list10.get(i23).intValue() + i11, iArr2[i18], 0.0f, 4, (Object) null);
                }
                list4 = list;
                i18 = i19;
                flowCrossAxisAlignment2 = flowCrossAxisAlignment;
                i14 = i12;
                list8 = list2;
            }
            Placeable.PlacementScope placementScope3 = placementScope;
            i14 = i15;
            list5 = list8;
        }
    }
}
