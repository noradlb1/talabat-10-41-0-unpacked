package androidx.compose.foundation;

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
/* renamed from: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1511g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1512h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f1513i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0 f1514j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0 f1515k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0 f1516l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f1517m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(boolean z11, String str, Role role, Function0 function0, Function0 function02, Function0 function03, String str2) {
        super(1);
        this.f1511g = z11;
        this.f1512h = str;
        this.f1513i = role;
        this.f1514j = function0;
        this.f1515k = function02;
        this.f1516l = function03;
        this.f1517m = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("combinedClickable");
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f1511g));
        inspectorInfo.getProperties().set("onClickLabel", this.f1512h);
        inspectorInfo.getProperties().set("role", this.f1513i);
        inspectorInfo.getProperties().set("onClick", this.f1514j);
        inspectorInfo.getProperties().set("onDoubleClick", this.f1515k);
        inspectorInfo.getProperties().set("onLongClick", this.f1516l);
        inspectorInfo.getProperties().set("onLongClickLabel", this.f1517m);
    }
}
