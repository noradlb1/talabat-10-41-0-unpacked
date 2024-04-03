package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
/* renamed from: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1490g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1491h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f1492i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0 f1493j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Indication f1494k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1495l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1(boolean z11, String str, Role role, Function0 function0, Indication indication, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f1490g = z11;
        this.f1491h = str;
        this.f1492i = role;
        this.f1493j = function0;
        this.f1494k = indication;
        this.f1495l = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName(Param.CLICKABLE);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f1490g));
        inspectorInfo.getProperties().set("onClickLabel", this.f1491h);
        inspectorInfo.getProperties().set("role", this.f1492i);
        inspectorInfo.getProperties().set("onClick", this.f1493j);
        inspectorInfo.getProperties().set("indication", this.f1494k);
        inspectorInfo.getProperties().set("interactionSource", this.f1495l);
    }
}
