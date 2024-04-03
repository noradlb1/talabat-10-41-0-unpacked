package androidx.compose.material.internal;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.LayoutDirection;
import j0.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f6200a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f6201b;

    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6(PopupLayout popupLayout, LayoutDirection layoutDirection) {
        this.f6200a = popupLayout;
        this.f6201b = layoutDirection;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1467measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
        this.f6200a.setParentLayoutDirection(this.f6201b);
        return MeasureScope.CC.p(measureScope, 0, 0, (Map) null, ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1.INSTANCE, 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
