package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class ShadowKt$shadows4CzXII$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f9577g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f9578h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f9579i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f9580j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f9581k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowKt$shadows4CzXII$$inlined$debugInspectorInfo$1(float f11, Shape shape, boolean z11, long j11, long j12) {
        super(1);
        this.f9577g = f11;
        this.f9578h = shape;
        this.f9579i = z11;
        this.f9580j = j11;
        this.f9581k = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("shadow");
        inspectorInfo.getProperties().set("elevation", Dp.m5476boximpl(this.f9577g));
        inspectorInfo.getProperties().set("shape", this.f9578h);
        inspectorInfo.getProperties().set("clip", Boolean.valueOf(this.f9579i));
        inspectorInfo.getProperties().set("ambientColor", Color.m2909boximpl(this.f9580j));
        inspectorInfo.getProperties().set("spotColor", Color.m2909boximpl(this.f9581k));
    }
}
