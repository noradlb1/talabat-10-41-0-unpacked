package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f2557g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f2558h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f2559i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f2560j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(float f11, float f12, float f13, float f14) {
        super(1);
        this.f2557g = f11;
        this.f2558h = f12;
        this.f2559i = f13;
        this.f2560j = f14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("requiredSizeIn");
        inspectorInfo.getProperties().set("minWidth", Dp.m5476boximpl(this.f2557g));
        inspectorInfo.getProperties().set("minHeight", Dp.m5476boximpl(this.f2558h));
        inspectorInfo.getProperties().set("maxWidth", Dp.m5476boximpl(this.f2559i));
        inspectorInfo.getProperties().set("maxHeight", Dp.m5476boximpl(this.f2560j));
    }
}
