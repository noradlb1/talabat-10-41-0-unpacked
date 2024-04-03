package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AlignmentLine f2424g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f2425h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f2426i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(AlignmentLine alignmentLine, float f11, float f12) {
        super(1);
        this.f2424g = alignmentLine;
        this.f2425h = f11;
        this.f2426i = f12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("paddingFrom");
        inspectorInfo.getProperties().set("alignmentLine", this.f2424g);
        inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, Dp.m5476boximpl(this.f2425h));
        inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, Dp.m5476boximpl(this.f2426i));
    }
}
