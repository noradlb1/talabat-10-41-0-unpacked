package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$BackdropStack$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4015g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Constraints, Constraints> f4016h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function4<Constraints, Float, Composer, Integer, Unit> f4017i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4018j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropStack$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, int i11) {
        super(2);
        this.f4015g = function2;
        this.f4016h = function1;
        this.f4017i = function4;
        this.f4018j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1101invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1101invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        final Placeable r02 = ((Measurable) CollectionsKt___CollectionsKt.first(subcomposeMeasureScope.subcompose(BackdropLayers.Back, this.f4015g))).m4508measureBRTryo0(this.f4016h.invoke(Constraints.m5410boximpl(j11)).m5428unboximpl());
        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(BackdropLayers.Front, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new BackdropScaffoldKt$BackdropStack$1$1$placeables$1(this.f4017i, j11, (float) r02.getHeight(), this.f4018j)));
        final ArrayList arrayList = new ArrayList(subcompose.size());
        int size = subcompose.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(subcompose.get(i11).m4508measureBRTryo0(j11));
        }
        int max = Math.max(Constraints.m5424getMinWidthimpl(j11), r02.getWidth());
        int max2 = Math.max(Constraints.m5423getMinHeightimpl(j11), r02.getHeight());
        int size2 = arrayList.size();
        int i12 = max2;
        int i13 = max;
        for (int i14 = 0; i14 < size2; i14++) {
            Placeable placeable = (Placeable) arrayList.get(i14);
            i13 = Math.max(i13, placeable.getWidth());
            i12 = Math.max(i12, placeable.getHeight());
        }
        return MeasureScope.CC.p(subcomposeMeasureScope, i13, i12, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(placementScope, r02, 0, 0, 0.0f, 4, (Object) null);
                List<Placeable> list = arrayList;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i11), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
