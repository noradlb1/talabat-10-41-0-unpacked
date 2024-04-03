package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogKt$AlertDialogFlowRow$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<List<Placeable>> f6295g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f6296h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f6297i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6298j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ List<Integer> f6299k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogFlowRow$1$measure$1(List<List<Placeable>> list, MeasureScope measureScope, float f11, int i11, List<Integer> list2) {
        super(1);
        this.f6295g = list;
        this.f6296h = measureScope;
        this.f6297i = f11;
        this.f6298j = i11;
        this.f6299k = list2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        MeasureScope measureScope = this.f6296h;
        float f11 = this.f6297i;
        int i11 = this.f6298j;
        List<Integer> list = this.f6299k;
        int i12 = 0;
        for (Object next : this.f6295g) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List list2 = (List) next;
            int size = list2.size();
            int[] iArr = new int[size];
            int i14 = 0;
            while (i14 < size) {
                iArr[i14] = ((Placeable) list2.get(i14)).getWidth() + (i14 < CollectionsKt__CollectionsKt.getLastIndex(list2) ? measureScope.m5441roundToPx0680j_4(f11) : 0);
                i14++;
            }
            Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
            int[] iArr2 = new int[size];
            for (int i15 = 0; i15 < size; i15++) {
                iArr2[i15] = 0;
            }
            bottom.arrange(measureScope, i11, iArr, iArr2);
            int i16 = 0;
            for (Object next2 : list2) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Placeable.PlacementScope.place$default(placementScope, (Placeable) next2, iArr2[i16], list.get(i12).intValue(), 0.0f, 4, (Object) null);
                i16 = i17;
                iArr2 = iArr2;
            }
            i12 = i13;
        }
    }
}
