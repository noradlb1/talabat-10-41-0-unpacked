package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SizeKt$createWrapContentHeightModifier$2 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Alignment.Vertical f2578g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f2579h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SizeKt$createWrapContentHeightModifier$2(Alignment.Vertical vertical, boolean z11) {
        super(1);
        this.f2578g = vertical;
        this.f2579h = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$$receiver");
        inspectorInfo.setName("wrapContentHeight");
        inspectorInfo.getProperties().set("align", this.f2578g);
        inspectorInfo.getProperties().set("unbounded", Boolean.valueOf(this.f2579h));
    }
}
