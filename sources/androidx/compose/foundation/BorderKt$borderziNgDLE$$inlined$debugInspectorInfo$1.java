package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.BorderKt$border-ziNgDLE$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f1449g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Brush f1450h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f1451i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1(float f11, Brush brush, Shape shape) {
        super(1);
        this.f1449g = f11;
        this.f1450h = brush;
        this.f1451i = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName(OutlinedTextFieldKt.BorderId);
        inspectorInfo.getProperties().set("width", Dp.m5476boximpl(this.f1449g));
        if (this.f1450h instanceof SolidColor) {
            inspectorInfo.getProperties().set("color", Color.m2909boximpl(((SolidColor) this.f1450h).m3235getValue0d7_KjU()));
            inspectorInfo.setValue(Color.m2909boximpl(((SolidColor) this.f1450h).m3235getValue0d7_KjU()));
        } else {
            inspectorInfo.getProperties().set("brush", this.f1450h);
        }
        inspectorInfo.getProperties().set("shape", this.f1451i);
    }
}
