package androidx.compose.ui.platform;

import android.view.RenderNode;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(28)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeVerificationHelper28;", "", "()V", "getAmbientShadowColor", "", "renderNode", "Landroid/view/RenderNode;", "getSpotShadowColor", "setAmbientShadowColor", "", "target", "setSpotShadowColor", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class RenderNodeVerificationHelper28 {
    @NotNull
    public static final RenderNodeVerificationHelper28 INSTANCE = new RenderNodeVerificationHelper28();

    private RenderNodeVerificationHelper28() {
    }

    @DoNotInline
    public final int getAmbientShadowColor(@NotNull RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        return renderNode.getAmbientShadowColor();
    }

    @DoNotInline
    public final int getSpotShadowColor(@NotNull RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        return renderNode.getSpotShadowColor();
    }

    @DoNotInline
    public final void setAmbientShadowColor(@NotNull RenderNode renderNode, int i11) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        renderNode.setAmbientShadowColor(i11);
    }

    @DoNotInline
    public final void setSpotShadowColor(@NotNull RenderNode renderNode, int i11) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        renderNode.setSpotShadowColor(i11);
    }
}
