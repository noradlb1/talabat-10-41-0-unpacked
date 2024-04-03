package androidx.compose.foundation;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1496g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1497h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f1498i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0 f1499j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(boolean z11, String str, Role role, Function0 function0) {
        super(1);
        this.f1496g = z11;
        this.f1497h = str;
        this.f1498i = role;
        this.f1499j = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName(Param.CLICKABLE);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f1496g));
        inspectorInfo.getProperties().set("onClickLabel", this.f1497h);
        inspectorInfo.getProperties().set("role", this.f1498i);
        inspectorInfo.getProperties().set("onClick", this.f1499j);
    }
}
