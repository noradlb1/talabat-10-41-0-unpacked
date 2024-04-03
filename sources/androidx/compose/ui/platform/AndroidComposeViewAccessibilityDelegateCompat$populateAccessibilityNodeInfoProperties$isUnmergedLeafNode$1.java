package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;", "invoke", "(Landroidx/compose/ui/node/LayoutNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$isUnmergedLeafNode$1 extends Lambda implements Function1<LayoutNode, Boolean> {
    public static final AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$isUnmergedLeafNode$1 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$isUnmergedLeafNode$1();

    public AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$isUnmergedLeafNode$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull LayoutNode layoutNode) {
        SemanticsConfiguration collapsedSemanticsConfiguration;
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        boolean z11 = false;
        if (!(outerSemantics == null || (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) == null || !collapsedSemanticsConfiguration.isMergingSemanticsOfDescendants())) {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }
}
