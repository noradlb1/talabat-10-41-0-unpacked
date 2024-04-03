package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DraggableKt$draggable$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1 f2036g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Orientation f2037h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2038i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f2039j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f2040k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0 f2041l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3 f2042m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3 f2043n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ DraggableState f2044o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$$inlined$debugInspectorInfo$1(Function1 function1, Orientation orientation, boolean z11, boolean z12, MutableInteractionSource mutableInteractionSource, Function0 function0, Function3 function3, Function3 function32, DraggableState draggableState) {
        super(1);
        this.f2036g = function1;
        this.f2037h = orientation;
        this.f2038i = z11;
        this.f2039j = z12;
        this.f2040k = mutableInteractionSource;
        this.f2041l = function0;
        this.f2042m = function3;
        this.f2043n = function32;
        this.f2044o = draggableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName(Param.DRAGGABLE);
        inspectorInfo.getProperties().set("canDrag", this.f2036g);
        inspectorInfo.getProperties().set("orientation", this.f2037h);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f2038i));
        inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(this.f2039j));
        inspectorInfo.getProperties().set("interactionSource", this.f2040k);
        inspectorInfo.getProperties().set("startDragImmediately", this.f2041l);
        inspectorInfo.getProperties().set("onDragStarted", this.f2042m);
        inspectorInfo.getProperties().set("onDragStopped", this.f2043n);
        inspectorInfo.getProperties().set("state", this.f2044o);
    }
}
