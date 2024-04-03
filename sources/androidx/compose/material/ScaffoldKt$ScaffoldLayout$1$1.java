package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScaffoldKt$ScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5034g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5035h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5036i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5037j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f5038k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5039l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5040m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f5041n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i11, boolean z11, Function2<? super Composer, ? super Integer, Unit> function24, int i12, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.f5034g = function2;
        this.f5035h = function22;
        this.f5036i = function23;
        this.f5037j = i11;
        this.f5038k = z11;
        this.f5039l = function24;
        this.f5040m = i12;
        this.f5041n = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1356invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1356invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int r12 = Constraints.m5422getMaxWidthimpl(j11);
        int r16 = Constraints.m5421getMaxHeightimpl(j11);
        final long r11 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 10, (Object) null);
        final Function2<Composer, Integer, Unit> function2 = this.f5034g;
        final Function2<Composer, Integer, Unit> function22 = this.f5035h;
        final Function2<Composer, Integer, Unit> function23 = this.f5036i;
        final int i11 = this.f5037j;
        final boolean z11 = this.f5038k;
        final Function2<Composer, Integer, Unit> function24 = this.f5039l;
        final int i12 = this.f5040m;
        final SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        final int i13 = r12;
        final int i14 = r16;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.f5041n;
        return MeasureScope.CC.p(subcomposeMeasureScope, r12, r16, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Object obj;
                Object obj2;
                FabPlacement fabPlacement;
                Object obj3;
                Integer num;
                int i11;
                int i12;
                int height;
                int r22;
                Object obj4;
                Object obj5;
                int i13;
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, function2);
                long j11 = r11;
                ArrayList arrayList = new ArrayList(subcompose.size());
                int size = subcompose.size();
                int i14 = 0;
                for (int i15 = 0; i15 < size; i15++) {
                    arrayList.add(subcompose.get(i15).m4508measureBRTryo0(j11));
                }
                if (arrayList.isEmpty()) {
                    obj = null;
                } else {
                    obj = arrayList.get(0);
                    int height2 = ((Placeable) obj).getHeight();
                    int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                    if (1 <= lastIndex) {
                        int i16 = 1;
                        while (true) {
                            Object obj6 = arrayList.get(i16);
                            int height3 = ((Placeable) obj6).getHeight();
                            if (height2 < height3) {
                                obj = obj6;
                                height2 = height3;
                            }
                            if (i16 == lastIndex) {
                                break;
                            }
                            i16++;
                        }
                    }
                }
                Placeable placeable = (Placeable) obj;
                int height4 = placeable != null ? placeable.getHeight() : 0;
                List<Measurable> subcompose2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                long j12 = r11;
                ArrayList arrayList2 = new ArrayList(subcompose2.size());
                int size2 = subcompose2.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    arrayList2.add(subcompose2.get(i17).m4508measureBRTryo0(j12));
                }
                if (arrayList2.isEmpty()) {
                    obj2 = null;
                } else {
                    obj2 = arrayList2.get(0);
                    int height5 = ((Placeable) obj2).getHeight();
                    int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList2);
                    if (1 <= lastIndex2) {
                        int i18 = 1;
                        while (true) {
                            Object obj7 = arrayList2.get(i18);
                            int height6 = ((Placeable) obj7).getHeight();
                            if (height5 < height6) {
                                obj2 = obj7;
                                height5 = height6;
                            }
                            if (i18 == lastIndex2) {
                                break;
                            }
                            i18++;
                        }
                    }
                }
                Placeable placeable2 = (Placeable) obj2;
                int height7 = placeable2 != null ? placeable2.getHeight() : 0;
                long j13 = r11;
                ArrayList arrayList3 = new ArrayList();
                for (Measurable r82 : subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, function23)) {
                    Placeable r83 = r82.m4508measureBRTryo0(j13);
                    if (!((r83.getHeight() == 0 || r83.getWidth() == 0) ? false : true)) {
                        r83 = null;
                    }
                    if (r83 != null) {
                        arrayList3.add(r83);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    if (arrayList3.isEmpty()) {
                        obj4 = null;
                    } else {
                        obj4 = arrayList3.get(0);
                        int width = ((Placeable) obj4).getWidth();
                        int lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(arrayList3);
                        if (1 <= lastIndex3) {
                            int i19 = 1;
                            while (true) {
                                Object obj8 = arrayList3.get(i19);
                                int width2 = ((Placeable) obj8).getWidth();
                                if (width < width2) {
                                    obj4 = obj8;
                                    width = width2;
                                }
                                if (i19 == lastIndex3) {
                                    break;
                                }
                                i19++;
                            }
                        }
                    }
                    Intrinsics.checkNotNull(obj4);
                    int width3 = ((Placeable) obj4).getWidth();
                    if (arrayList3.isEmpty()) {
                        obj5 = null;
                    } else {
                        obj5 = arrayList3.get(0);
                        int height8 = ((Placeable) obj5).getHeight();
                        int lastIndex4 = CollectionsKt__CollectionsKt.getLastIndex(arrayList3);
                        if (1 <= lastIndex4) {
                            int i21 = 1;
                            while (true) {
                                Object obj9 = arrayList3.get(i21);
                                int height9 = ((Placeable) obj9).getHeight();
                                if (height8 < height9) {
                                    height8 = height9;
                                    obj5 = obj9;
                                }
                                if (i21 == lastIndex4) {
                                    break;
                                }
                                i21++;
                            }
                        }
                    }
                    Intrinsics.checkNotNull(obj5);
                    int height10 = ((Placeable) obj5).getHeight();
                    if (!FabPosition.m1264equalsimpl0(i11, FabPosition.Companion.m1269getEnd5ygKITE())) {
                        i13 = (i13 - width3) / 2;
                    } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                        i13 = (i13 - subcomposeMeasureScope2.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width3;
                    } else {
                        i13 = subcomposeMeasureScope2.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    fabPlacement = new FabPlacement(z11, i13, width3, height10);
                } else {
                    fabPlacement = null;
                }
                List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement, function24, i12)));
                long j14 = r11;
                ArrayList arrayList4 = new ArrayList(subcompose3.size());
                int size3 = subcompose3.size();
                for (int i22 = 0; i22 < size3; i22++) {
                    arrayList4.add(subcompose3.get(i22).m4508measureBRTryo0(j14));
                }
                if (arrayList4.isEmpty()) {
                    obj3 = null;
                } else {
                    obj3 = arrayList4.get(0);
                    int height11 = ((Placeable) obj3).getHeight();
                    int lastIndex5 = CollectionsKt__CollectionsKt.getLastIndex(arrayList4);
                    if (1 <= lastIndex5) {
                        int i23 = 1;
                        while (true) {
                            Object obj10 = arrayList4.get(i23);
                            int height12 = ((Placeable) obj10).getHeight();
                            if (height11 < height12) {
                                obj3 = obj10;
                                height11 = height12;
                            }
                            if (i23 == lastIndex5) {
                                break;
                            }
                            i23++;
                        }
                    }
                }
                Placeable placeable3 = (Placeable) obj3;
                int height13 = placeable3 != null ? placeable3.getHeight() : 0;
                if (fabPlacement != null) {
                    SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                    boolean z11 = z11;
                    if (height13 == 0) {
                        height = fabPlacement.getHeight();
                        r22 = subcomposeMeasureScope.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    } else if (z11) {
                        i12 = height13 + (fabPlacement.getHeight() / 2);
                        num = Integer.valueOf(i12);
                    } else {
                        height = fabPlacement.getHeight() + height13;
                        r22 = subcomposeMeasureScope.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    i12 = height + r22;
                    num = Integer.valueOf(i12);
                } else {
                    num = null;
                }
                if (height7 != 0) {
                    i11 = height7 + (num != null ? num.intValue() : height13);
                } else {
                    i11 = 0;
                }
                int i24 = i14 - height4;
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope2;
                List<Measurable> subcompose4 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(subcomposeMeasureScope2, height13, function3, i12)));
                long j15 = r11;
                ArrayList arrayList5 = new ArrayList(subcompose4.size());
                int size4 = subcompose4.size();
                while (i14 < size4) {
                    arrayList5.add(subcompose4.get(i14).m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j15, 0, 0, 0, i24, 7, (Object) null)));
                    i14++;
                    subcompose4 = subcompose4;
                    j15 = j15;
                }
                int size5 = arrayList5.size();
                int i25 = 0;
                while (i25 < size5) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList5.get(i25), 0, height4, 0.0f, 4, (Object) null);
                    i25++;
                    arrayList5 = arrayList5;
                    height13 = height13;
                }
                int i26 = height13;
                int size6 = arrayList.size();
                for (int i27 = 0; i27 < size6; i27++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList.get(i27), 0, 0, 0.0f, 4, (Object) null);
                }
                int i28 = i14;
                int size7 = arrayList2.size();
                for (int i29 = 0; i29 < size7; i29++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList2.get(i29), 0, i28 - i11, 0.0f, 4, (Object) null);
                }
                int i31 = i14;
                int size8 = arrayList4.size();
                for (int i32 = 0; i32 < size8; i32++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList4.get(i32), 0, i31 - i26, 0.0f, 4, (Object) null);
                }
                if (fabPlacement != null) {
                    int i33 = i14;
                    int size9 = arrayList3.size();
                    for (int i34 = 0; i34 < size9; i34++) {
                        int left = fabPlacement.getLeft();
                        Intrinsics.checkNotNull(num);
                        Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList3.get(i34), left, i33 - num.intValue(), 0.0f, 4, (Object) null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, 4, (Object) null);
    }
}
