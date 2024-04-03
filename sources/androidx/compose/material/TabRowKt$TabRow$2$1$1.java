package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Iterator;
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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabRowKt$TabRow$2$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5842g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5843h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f5844i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5845j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$TabRow$2$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f5842g = function2;
        this.f5843h = function22;
        this.f5844i = function3;
        this.f5845j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1427invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1427invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        Object obj;
        int i11;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$SubcomposeLayout");
        int r14 = Constraints.m5422getMaxWidthimpl(j11);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(TabSlots.Tabs, this.f5842g);
        int size = subcompose.size();
        int i12 = r14 / size;
        Iterable<Measurable> iterable = subcompose;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Measurable r15 : iterable) {
            arrayList.add(r15.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, i12, i12, 0, 0, 12, (Object) null)));
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
        if (placeable != null) {
            i11 = placeable.getHeight();
        } else {
            i11 = 0;
        }
        final ArrayList arrayList2 = new ArrayList(size);
        for (int i13 = 0; i13 < size; i13++) {
            arrayList2.add(new TabPosition(Dp.m5478constructorimpl(subcomposeMeasureScope2.m5444toDpu2uoSUM(i12) * ((float) i13)), subcomposeMeasureScope2.m5444toDpu2uoSUM(i12), (DefaultConstructorMarker) null));
        }
        final Function2<Composer, Integer, Unit> function2 = this.f5843h;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.f5844i;
        final ArrayList arrayList3 = arrayList;
        final SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
        final int i14 = i12;
        final long j12 = j11;
        final int i15 = this.f5845j;
        final int i16 = i11;
        final int i17 = r14;
        return MeasureScope.CC.p(subcomposeMeasureScope, r14, i11, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                int i11 = i14;
                int i12 = 0;
                for (Object next : arrayList3) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    int i14 = i12 * i11;
                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) next, i14, 0, 0.0f, 4, (Object) null);
                    i12 = i13;
                }
                long j11 = j12;
                int i15 = i16;
                for (Measurable r22 : subcomposeMeasureScope3.subcompose(TabSlots.Divider, function2)) {
                    Placeable r32 = r22.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, r32, 0, i15 - r32.getHeight(), 0.0f, 4, (Object) null);
                    i15 = i15;
                    j11 = j11;
                }
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope3;
                TabSlots tabSlots = TabSlots.Indicator;
                final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                final List<TabPosition> list = arrayList2;
                final int i16 = i15;
                int i17 = i17;
                int i18 = i16;
                for (Measurable r23 : subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer, int i11) {
                        if ((i11 & 11) != 2 || !composer.getSkipping()) {
                            function3.invoke(list, composer, Integer.valueOf(((i16 >> 9) & 112) | 8));
                        } else {
                            composer.skipToGroupEnd();
                        }
                    }
                }))) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, r23.m4508measureBRTryo0(Constraints.Companion.m5430fixedJhjzzOo(i17, i18)), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
