package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1502g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1503h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f1504i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0 f1505j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0 f1506k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0 f1507l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f1508m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Indication f1509n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1510o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(boolean z11, String str, Role role, Function0 function0, Function0 function02, Function0 function03, String str2, Indication indication, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f1502g = z11;
        this.f1503h = str;
        this.f1504i = role;
        this.f1505j = function0;
        this.f1506k = function02;
        this.f1507l = function03;
        this.f1508m = str2;
        this.f1509n = indication;
        this.f1510o = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("combinedClickable");
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f1502g));
        inspectorInfo.getProperties().set("onClickLabel", this.f1503h);
        inspectorInfo.getProperties().set("role", this.f1504i);
        inspectorInfo.getProperties().set("onClick", this.f1505j);
        inspectorInfo.getProperties().set("onDoubleClick", this.f1506k);
        inspectorInfo.getProperties().set("onLongClick", this.f1507l);
        inspectorInfo.getProperties().set("onLongClickLabel", this.f1508m);
        inspectorInfo.getProperties().set("indication", this.f1509n);
        inspectorInfo.getProperties().set("interactionSource", this.f1510o);
    }
}
