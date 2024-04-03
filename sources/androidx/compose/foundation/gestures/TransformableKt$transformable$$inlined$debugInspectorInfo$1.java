package androidx.compose.foundation.gestures;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TransformableKt$transformable$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TransformableState f2300g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f2301h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2302i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableKt$transformable$$inlined$debugInspectorInfo$1(TransformableState transformableState, boolean z11, boolean z12) {
        super(1);
        this.f2300g = transformableState;
        this.f2301h = z11;
        this.f2302i = z12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("transformable");
        inspectorInfo.getProperties().set("state", this.f2300g);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f2301h));
        inspectorInfo.getProperties().set("lockRotationOnZoomPan", Boolean.valueOf(this.f2302i));
    }
}
