package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScaffoldKt$ScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7858g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7859h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7860i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7861j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7862k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7863l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7864m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f7865n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i11, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, int i12, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.f7858g = function2;
        this.f7859h = function22;
        this.f7860i = function23;
        this.f7861j = i11;
        this.f7862k = windowInsets;
        this.f7863l = function24;
        this.f7864m = i12;
        this.f7865n = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1813invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1813invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int r12 = Constraints.m5422getMaxWidthimpl(j11);
        int r16 = Constraints.m5421getMaxHeightimpl(j11);
        final long r102 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 10, (Object) null);
        final Function2<Composer, Integer, Unit> function2 = this.f7858g;
        final Function2<Composer, Integer, Unit> function22 = this.f7859h;
        final Function2<Composer, Integer, Unit> function23 = this.f7860i;
        final int i11 = this.f7861j;
        final WindowInsets windowInsets = this.f7862k;
        final Function2<Composer, Integer, Unit> function24 = this.f7863l;
        final int i12 = this.f7864m;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.f7865n;
        final SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        final int i13 = r12;
        final int i14 = r16;
        return MeasureScope.CC.p(subcomposeMeasureScope, r12, r16, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Object obj;
                Object obj2;
                Object obj3;
                FabPlacement fabPlacement;
                Object obj4;
                Integer num;
                int i11;
                int i12;
                Object obj5;
                Object obj6;
                int i13;
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Iterable<Measurable> subcompose = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, function2);
                long j11 = r102;
                ArrayList<Placeable> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcompose, 10));
                for (Measurable r52 : subcompose) {
                    arrayList.add(r52.m4508measureBRTryo0(j11));
                }
                Iterator it = arrayList.iterator();
                if (!it.hasNext()) {
                    obj = null;
                } else {
                    obj = it.next();
                    if (it.hasNext()) {
                        int height = ((Placeable) obj).getHeight();
                        do {
                            Object next = it.next();
                            int height2 = ((Placeable) next).getHeight();
                            if (height < height2) {
                                obj = next;
                                height = height2;
                            }
                        } while (it.hasNext());
                    }
                }
                Placeable placeable = (Placeable) obj;
                int height3 = placeable != null ? placeable.getHeight() : 0;
                Iterable<Measurable> subcompose2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                WindowInsets windowInsets = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                long j12 = r102;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcompose2, 10));
                for (Measurable r102 : subcompose2) {
                    arrayList2.add(r102.m4508measureBRTryo0(ConstraintsKt.m5438offsetNN6EwU(j12, (-windowInsets.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets.getBottom(subcomposeMeasureScope))));
                }
                Iterator it2 = arrayList2.iterator();
                if (!it2.hasNext()) {
                    obj2 = null;
                } else {
                    obj2 = it2.next();
                    if (it2.hasNext()) {
                        int height4 = ((Placeable) obj2).getHeight();
                        do {
                            Object next2 = it2.next();
                            int height5 = ((Placeable) next2).getHeight();
                            if (height4 < height5) {
                                obj2 = next2;
                                height4 = height5;
                            }
                        } while (it2.hasNext());
                    }
                }
                Placeable placeable2 = (Placeable) obj2;
                int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                Iterator it3 = arrayList2.iterator();
                if (!it3.hasNext()) {
                    obj3 = null;
                } else {
                    obj3 = it3.next();
                    if (it3.hasNext()) {
                        int width = ((Placeable) obj3).getWidth();
                        while (true) {
                            Object next3 = it3.next();
                            int width2 = ((Placeable) next3).getWidth();
                            if (width < width2) {
                                obj3 = next3;
                                width = width2;
                            }
                            if (!it3.hasNext()) {
                                break;
                            }
                        }
                    }
                }
                Placeable placeable3 = (Placeable) obj3;
                int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                WindowInsets windowInsets2 = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope2;
                long j13 = r102;
                ArrayList arrayList3 = new ArrayList();
                for (Measurable r12 : subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, function23)) {
                    Placeable r32 = r12.m4508measureBRTryo0(ConstraintsKt.m5438offsetNN6EwU(j13, (-windowInsets2.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets2.getRight(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets2.getBottom(subcomposeMeasureScope2)));
                    if (!((r32.getHeight() == 0 || r32.getWidth() == 0) ? false : true)) {
                        r32 = null;
                    }
                    if (r32 != null) {
                        arrayList3.add(r32);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    Iterator it4 = arrayList3.iterator();
                    if (!it4.hasNext()) {
                        obj5 = null;
                    } else {
                        obj5 = it4.next();
                        if (it4.hasNext()) {
                            int width4 = ((Placeable) obj5).getWidth();
                            do {
                                Object next4 = it4.next();
                                int width5 = ((Placeable) next4).getWidth();
                                if (width4 < width5) {
                                    obj5 = next4;
                                    width4 = width5;
                                }
                            } while (it4.hasNext());
                        }
                    }
                    Intrinsics.checkNotNull(obj5);
                    int width6 = ((Placeable) obj5).getWidth();
                    Iterator it5 = arrayList3.iterator();
                    if (!it5.hasNext()) {
                        obj6 = null;
                    } else {
                        obj6 = it5.next();
                        if (it5.hasNext()) {
                            int height7 = ((Placeable) obj6).getHeight();
                            do {
                                Object next5 = it5.next();
                                int height8 = ((Placeable) next5).getHeight();
                                if (height7 < height8) {
                                    obj6 = next5;
                                    height7 = height8;
                                }
                            } while (it5.hasNext());
                        }
                    }
                    Intrinsics.checkNotNull(obj6);
                    int height9 = ((Placeable) obj6).getHeight();
                    if (!FabPosition.m1682equalsimpl0(i11, FabPosition.Companion.m1687getEndERTFSPs())) {
                        i13 = (i13 - width6) / 2;
                    } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                        i13 = (i13 - subcomposeMeasureScope2.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width6;
                    } else {
                        i13 = subcomposeMeasureScope2.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    fabPlacement = new FabPlacement(i13, width6, height9);
                } else {
                    fabPlacement = null;
                }
                Iterable<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-1455477816, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement, function24, i12)));
                long j14 = r102;
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcompose3, 10));
                for (Measurable r103 : subcompose3) {
                    arrayList4.add(r103.m4508measureBRTryo0(j14));
                }
                Iterator it6 = arrayList4.iterator();
                if (!it6.hasNext()) {
                    obj4 = null;
                } else {
                    obj4 = it6.next();
                    if (it6.hasNext()) {
                        int height10 = ((Placeable) obj4).getHeight();
                        while (true) {
                            Object next6 = it6.next();
                            int height11 = ((Placeable) next6).getHeight();
                            if (height10 < height11) {
                                obj4 = next6;
                                height10 = height11;
                            }
                            if (!it6.hasNext()) {
                                break;
                            }
                            ArrayList arrayList5 = arrayList2;
                            ArrayList arrayList6 = arrayList3;
                            arrayList2 = arrayList5;
                        }
                    }
                }
                Placeable placeable4 = (Placeable) obj4;
                Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                if (fabPlacement != null) {
                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope2;
                    WindowInsets windowInsets3 = windowInsets;
                    if (valueOf == null) {
                        i12 = fabPlacement.getHeight() + subcomposeMeasureScope3.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing) + windowInsets3.getBottom(subcomposeMeasureScope3);
                    } else {
                        i12 = valueOf.intValue() + fabPlacement.getHeight() + subcomposeMeasureScope3.m5441roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    num = Integer.valueOf(i12);
                } else {
                    num = null;
                }
                if (height6 != 0) {
                    i11 = height6 + (num != null ? num.intValue() : valueOf != null ? valueOf.intValue() : windowInsets.getBottom(subcomposeMeasureScope2));
                } else {
                    i11 = 0;
                }
                SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope2;
                ArrayList arrayList7 = arrayList3;
                ArrayList<Placeable> arrayList8 = arrayList2;
                Iterable<Measurable> subcompose4 = subcomposeMeasureScope4.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(1643221465, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(windowInsets, subcomposeMeasureScope4, arrayList, height3, arrayList4, valueOf, function3, i12)));
                long j15 = r102;
                ArrayList<Placeable> arrayList9 = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcompose4, 10));
                for (Measurable r72 : subcompose4) {
                    arrayList9.add(r72.m4508measureBRTryo0(j15));
                }
                for (Placeable place$default : arrayList9) {
                    ArrayList arrayList10 = arrayList7;
                    Placeable.PlacementScope.place$default(placementScope, place$default, 0, 0, 0.0f, 4, (Object) null);
                    arrayList = arrayList;
                    arrayList4 = arrayList4;
                }
                ArrayList<Placeable> arrayList11 = arrayList4;
                ArrayList<Placeable> arrayList12 = arrayList7;
                for (Placeable place$default2 : arrayList) {
                    Placeable.PlacementScope.place$default(placementScope, place$default2, 0, 0, 0.0f, 4, (Object) null);
                }
                int i14 = i13;
                WindowInsets windowInsets4 = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope5 = subcomposeMeasureScope2;
                int i15 = i14;
                for (Placeable place$default3 : arrayList8) {
                    Placeable.PlacementScope.place$default(placementScope, place$default3, windowInsets4.getLeft(subcomposeMeasureScope5, subcomposeMeasureScope5.getLayoutDirection()) + ((i14 - width3) / 2), i15 - i11, 0.0f, 4, (Object) null);
                }
                int i16 = i14;
                for (Placeable place$default4 : arrayList11) {
                    Placeable.PlacementScope.place$default(placementScope, place$default4, 0, i16 - (valueOf != null ? valueOf.intValue() : 0), 0.0f, 4, (Object) null);
                }
                if (fabPlacement != null) {
                    int i17 = i14;
                    for (Placeable place$default5 : arrayList12) {
                        int left = fabPlacement.getLeft();
                        Intrinsics.checkNotNull(num);
                        Placeable.PlacementScope.place$default(placementScope, place$default5, left, i17 - num.intValue(), 0.0f, 4, (Object) null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, 4, (Object) null);
    }
}
