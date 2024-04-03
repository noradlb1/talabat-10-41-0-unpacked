package androidx.compose.ui.layout;

import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
public final class LayoutKt$Layout$$inlined$ReusableComposeNode$1 extends Lambda implements Function0<ComposeUiNode> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0 f9841g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutKt$Layout$$inlined$ReusableComposeNode$1(Function0 function0) {
        super(0);
        this.f9841g = function0;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
    @NotNull
    public final ComposeUiNode invoke() {
        return this.f9841g.invoke();
    }
}
