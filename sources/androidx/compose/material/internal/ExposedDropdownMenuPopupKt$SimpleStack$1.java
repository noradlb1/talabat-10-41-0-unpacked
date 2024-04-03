package androidx.compose.material.internal;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import j0.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt$SimpleStack$1 implements MeasurePolicy {
    public static final ExposedDropdownMenuPopupKt$SimpleStack$1 INSTANCE = new ExposedDropdownMenuPopupKt$SimpleStack$1();

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1469measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        int size = list.size();
        if (size != 0) {
            int i13 = 0;
            if (size != 1) {
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                for (int i14 = 0; i14 < size2; i14++) {
                    arrayList.add(((Measurable) list.get(i14)).m4508measureBRTryo0(j11));
                }
                int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (lastIndex >= 0) {
                    int i15 = 0;
                    int i16 = 0;
                    while (true) {
                        Placeable placeable = (Placeable) arrayList.get(i13);
                        i15 = Math.max(i15, placeable.getWidth());
                        i16 = Math.max(i16, placeable.getHeight());
                        if (i13 == lastIndex) {
                            break;
                        }
                        i13++;
                    }
                    i12 = i15;
                    i11 = i16;
                } else {
                    i12 = 0;
                    i11 = 0;
                }
                return MeasureScope.CC.p(measureScope, i12, i11, (Map) null, new ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3(arrayList), 4, (Object) null);
            }
            Placeable r12 = ((Measurable) list.get(0)).m4508measureBRTryo0(j11);
            return MeasureScope.CC.p(measureScope, r12.getWidth(), r12.getHeight(), (Map) null, new ExposedDropdownMenuPopupKt$SimpleStack$1$measure$2(r12), 4, (Object) null);
        }
        return MeasureScope.CC.p(measureScope, 0, 0, (Map) null, ExposedDropdownMenuPopupKt$SimpleStack$1$measure$1.INSTANCE, 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
