package androidx.compose.foundation;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.BackgroundKt$background-bw27NRU$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f1447g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f1448h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1(long j11, Shape shape) {
        super(1);
        this.f1447g = j11;
        this.f1448h = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("background");
        inspectorInfo.setValue(Color.m2909boximpl(this.f1447g));
        inspectorInfo.getProperties().set("color", Color.m2909boximpl(this.f1447g));
        inspectorInfo.getProperties().set("shape", this.f1448h);
    }
}
