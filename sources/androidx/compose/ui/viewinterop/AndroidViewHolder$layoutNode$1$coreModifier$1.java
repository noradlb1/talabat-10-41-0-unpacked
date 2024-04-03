package androidx.compose.ui.viewinterop;

import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewHolder$layoutNode$1$coreModifier$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutNode f10297g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f10298h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$layoutNode$1$coreModifier$1(LayoutNode layoutNode, AndroidViewHolder androidViewHolder) {
        super(1);
        this.f10297g = layoutNode;
        this.f10298h = androidViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        LayoutNode layoutNode = this.f10297g;
        AndroidViewHolder androidViewHolder = this.f10298h;
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        Owner owner$ui_release = layoutNode.getOwner$ui_release();
        AndroidComposeView androidComposeView = owner$ui_release instanceof AndroidComposeView ? (AndroidComposeView) owner$ui_release : null;
        if (androidComposeView != null) {
            androidComposeView.drawAndroidView(androidViewHolder, AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }
}
