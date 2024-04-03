package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeView$removeAndroidView$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f9982g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f9983h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$removeAndroidView$1(AndroidComposeView androidComposeView, AndroidViewHolder androidViewHolder) {
        super(0);
        this.f9982g = androidComposeView;
        this.f9983h = androidViewHolder;
    }

    public final void invoke() {
        this.f9982g.getAndroidViewsHandler$ui_release().removeViewInLayout(this.f9983h);
        HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = this.f9982g.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
        TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(this.f9982g.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(this.f9983h));
        ViewCompat.setImportantForAccessibility(this.f9983h, 0);
    }
}
