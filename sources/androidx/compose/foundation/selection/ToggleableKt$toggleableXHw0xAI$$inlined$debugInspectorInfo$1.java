package androidx.compose.foundation.selection;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.selection.ToggleableKt$toggleable-XHw0xAI$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3233g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3234h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f3235i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1 f3236j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(boolean z11, boolean z12, Role role, Function1 function1) {
        super(1);
        this.f3233g = z11;
        this.f3234h = z12;
        this.f3235i = role;
        this.f3236j = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("toggleable");
        inspectorInfo.getProperties().set("value", Boolean.valueOf(this.f3233g));
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f3234h));
        inspectorInfo.getProperties().set("role", this.f3235i);
        inspectorInfo.getProperties().set("onValueChange", this.f3236j);
    }
}
