package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$addAndroidView$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeView$addAndroidView$1 extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LayoutNode f9977c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f9978d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f9979e;

    public AndroidComposeView$addAndroidView$1(LayoutNode layoutNode, AndroidComposeView androidComposeView, AndroidComposeView androidComposeView2) {
        this.f9977c = layoutNode;
        this.f9978d = androidComposeView;
        this.f9979e = androidComposeView2;
    }

    public void onInitializeAccessibilityNodeInfo(@NotNull View view, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, CustomerInfoLocalDataSourceImpl.KEY);
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(this.f9977c);
        Intrinsics.checkNotNull(outerSemantics);
        SemanticsNode parent = new SemanticsNode(outerSemantics, false, (LayoutNode) null, 4, (DefaultConstructorMarker) null).getParent();
        Intrinsics.checkNotNull(parent);
        int id2 = parent.getId();
        if (id2 == this.f9978d.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            id2 = -1;
        }
        accessibilityNodeInfoCompat.setParent(this.f9979e, id2);
    }
}
