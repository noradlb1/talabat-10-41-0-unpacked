package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogFlowRow$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<List<Placeable>> f3808g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f3809h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f3810i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3811j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ List<Integer> f3812k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogFlowRow$1$measure$1(List<List<Placeable>> list, MeasureScope measureScope, float f11, int i11, List<Integer> list2) {
        super(1);
        this.f3808g = list;
        this.f3809h = measureScope;
        this.f3810i = f11;
        this.f3811j = i11;
        this.f3812k = list2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<List<Placeable>> list = this.f3808g;
        MeasureScope measureScope = this.f3809h;
        float f11 = this.f3810i;
        int i11 = this.f3811j;
        List<Integer> list2 = this.f3812k;
        int size = list.size();
        int i12 = 0;
        while (i12 < size) {
            List list3 = list.get(i12);
            int size2 = list3.size();
            int[] iArr = new int[size2];
            int i13 = 0;
            while (i13 < size2) {
                iArr[i13] = ((Placeable) list3.get(i13)).getWidth() + (i13 < CollectionsKt__CollectionsKt.getLastIndex(list3) ? measureScope.m5441roundToPx0680j_4(f11) : 0);
                i13++;
            }
            Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
            int[] iArr2 = new int[size2];
            for (int i14 = 0; i14 < size2; i14++) {
                iArr2[i14] = 0;
            }
            bottom.arrange(measureScope, i11, iArr, iArr2);
            int size3 = list3.size();
            int i15 = 0;
            while (i15 < size3) {
                int i16 = i15;
                Placeable.PlacementScope.place$default(placementScope, (Placeable) list3.get(i15), iArr2[i15], list2.get(i12).intValue(), 0.0f, 4, (Object) null);
                i15 = i16 + 1;
                size3 = size3;
                iArr2 = iArr2;
                list3 = list3;
                i12 = i12;
            }
            i12++;
        }
    }
}
