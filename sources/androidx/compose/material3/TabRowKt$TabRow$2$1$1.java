package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabRowKt$TabRow$2$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8626g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8627h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f8628i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8629j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$TabRow$2$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f8626g = function2;
        this.f8627h = function22;
        this.f8628i = function3;
        this.f8629j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1897invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1897invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$SubcomposeLayout");
        int r14 = Constraints.m5422getMaxWidthimpl(j11);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(TabSlots.Tabs, this.f8626g);
        int size = subcompose.size();
        int i11 = r14 / size;
        Iterable<Measurable> iterable = subcompose;
        int i12 = 0;
        for (Measurable maxIntrinsicHeight : iterable) {
            i12 = Math.max(maxIntrinsicHeight.maxIntrinsicHeight(i11), i12);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Measurable r92 : iterable) {
            int i13 = r14;
            ArrayList arrayList2 = arrayList;
            arrayList2.add(r92.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, i11, i11, i12, 0, 8, (Object) null)));
            arrayList = arrayList2;
            r14 = i13;
        }
        int i14 = r14;
        ArrayList arrayList3 = arrayList;
        final ArrayList arrayList4 = new ArrayList(size);
        for (int i15 = 0; i15 < size; i15++) {
            arrayList4.add(new TabPosition(Dp.m5478constructorimpl(subcomposeMeasureScope2.m5444toDpu2uoSUM(i11) * ((float) i15)), subcomposeMeasureScope2.m5444toDpu2uoSUM(i11), (DefaultConstructorMarker) null));
        }
        final Function2<Composer, Integer, Unit> function2 = this.f8627h;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.f8628i;
        final ArrayList arrayList5 = arrayList3;
        final SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
        final int i16 = i11;
        final long j12 = j11;
        final int i17 = i12;
        final int i18 = this.f8629j;
        final int i19 = i14;
        return MeasureScope.CC.p(subcomposeMeasureScope, i14, i12, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                int i11 = i16;
                int i12 = 0;
                for (Object next : arrayList5) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    int i14 = i12 * i11;
                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) next, i14, 0, 0.0f, 4, (Object) null);
                    i12 = i13;
                }
                long j11 = j12;
                int i15 = i17;
                for (Measurable r22 : subcomposeMeasureScope3.subcompose(TabSlots.Divider, function2)) {
                    Placeable r32 = r22.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, r32, 0, i15 - r32.getHeight(), 0.0f, 4, (Object) null);
                    i15 = i15;
                    j11 = j11;
                }
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope3;
                TabSlots tabSlots = TabSlots.Indicator;
                final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                final List<TabPosition> list = arrayList4;
                final int i16 = i18;
                int i17 = i19;
                int i18 = i17;
                for (Measurable r23 : subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-976887453, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer, int i11) {
                        if ((i11 & 11) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-976887453, i11, -1, "androidx.compose.material3.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:178)");
                            }
                            function3.invoke(list, composer, Integer.valueOf(((i16 >> 9) & 112) | 8));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                }))) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, r23.m4508measureBRTryo0(Constraints.Companion.m5430fixedJhjzzOo(i17, i18)), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
