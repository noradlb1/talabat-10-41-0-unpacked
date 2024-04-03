package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PainterModifierKt$paint$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Painter f9571g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f9572h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Alignment f9573i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ContentScale f9574j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f9575k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f9576l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PainterModifierKt$paint$$inlined$debugInspectorInfo$1(Painter painter, boolean z11, Alignment alignment, ContentScale contentScale, float f11, ColorFilter colorFilter) {
        super(1);
        this.f9571g = painter;
        this.f9572h = z11;
        this.f9573i = alignment;
        this.f9574j = contentScale;
        this.f9575k = f11;
        this.f9576l = colorFilter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("paint");
        inspectorInfo.getProperties().set("painter", this.f9571g);
        inspectorInfo.getProperties().set("sizeToIntrinsics", Boolean.valueOf(this.f9572h));
        inspectorInfo.getProperties().set("alignment", this.f9573i);
        inspectorInfo.getProperties().set("contentScale", this.f9574j);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.f9575k));
        inspectorInfo.getProperties().set("colorFilter", this.f9576l);
    }
}
