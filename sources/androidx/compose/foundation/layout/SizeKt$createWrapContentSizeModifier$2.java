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
public final class SizeKt$createWrapContentSizeModifier$2 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Alignment f2581g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f2582h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SizeKt$createWrapContentSizeModifier$2(Alignment alignment, boolean z11) {
        super(1);
        this.f2581g = alignment;
        this.f2582h = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$$receiver");
        inspectorInfo.setName("wrapContentSize");
        inspectorInfo.getProperties().set("align", this.f2581g);
        inspectorInfo.getProperties().set("unbounded", Boolean.valueOf(this.f2582h));
    }
}
