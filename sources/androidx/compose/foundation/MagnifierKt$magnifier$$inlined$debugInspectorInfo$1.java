package androidx.compose.foundation;

import androidx.compose.ui.platform.InspectorInfo;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MagnifierKt$magnifier$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1 f1724g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1 f1725h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f1726i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MagnifierStyle f1727j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$$inlined$debugInspectorInfo$1(Function1 function1, Function1 function12, float f11, MagnifierStyle magnifierStyle) {
        super(1);
        this.f1724g = function1;
        this.f1725h = function12;
        this.f1726i = f11;
        this.f1727j = magnifierStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName(MagnifierKt.isPlatformMagnifierSupported$default(0, 1, (Object) null) ? "magnifier" : "magnifier (not supported)");
        inspectorInfo.getProperties().set("sourceCenter", this.f1724g);
        inspectorInfo.getProperties().set("magnifierCenter", this.f1725h);
        inspectorInfo.getProperties().set(Param.ZOOM, Float.valueOf(this.f1726i));
        inspectorInfo.getProperties().set("style", this.f1727j);
    }
}
