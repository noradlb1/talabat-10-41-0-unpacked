package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1 extends Lambda implements Function0<LayoutNode> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0 f10311g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(Function0 function0) {
        super(0);
        this.f10311g = function0;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
    @NotNull
    public final LayoutNode invoke() {
        return this.f10311g.invoke();
    }
}
