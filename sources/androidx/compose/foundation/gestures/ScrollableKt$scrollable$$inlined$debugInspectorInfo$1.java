package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollableKt$scrollable$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Orientation f2158g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ScrollableState f2159h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OverscrollEffect f2160i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f2161j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f2162k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2163l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f2164m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableKt$scrollable$$inlined$debugInspectorInfo$1(Orientation orientation, ScrollableState scrollableState, OverscrollEffect overscrollEffect, boolean z11, boolean z12, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f2158g = orientation;
        this.f2159h = scrollableState;
        this.f2160i = overscrollEffect;
        this.f2161j = z11;
        this.f2162k = z12;
        this.f2163l = flingBehavior;
        this.f2164m = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("scrollable");
        inspectorInfo.getProperties().set("orientation", this.f2158g);
        inspectorInfo.getProperties().set("state", this.f2159h);
        inspectorInfo.getProperties().set("overscrollEffect", this.f2160i);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f2161j));
        inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(this.f2162k));
        inspectorInfo.getProperties().set("flingBehavior", this.f2163l);
        inspectorInfo.getProperties().set("interactionSource", this.f2164m);
    }
}
