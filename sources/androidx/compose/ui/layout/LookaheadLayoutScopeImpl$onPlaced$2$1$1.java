package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LookaheadLayoutScopeImpl$onPlaced$2$1$1 extends Lambda implements Function0<LookaheadLayoutCoordinates> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LookaheadLayoutScopeImpl f9869g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookaheadLayoutScopeImpl$onPlaced$2$1$1(LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl) {
        super(0);
        this.f9869g = lookaheadLayoutScopeImpl;
    }

    @NotNull
    public final LookaheadLayoutCoordinates invoke() {
        NodeCoordinator root = this.f9869g.getRoot();
        if (root != null) {
            LookaheadDelegate lookaheadDelegate$ui_release = root.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = lookaheadDelegate$ui_release.getLookaheadLayoutCoordinates();
            if (lookaheadLayoutCoordinates != null) {
                return lookaheadLayoutCoordinates;
            }
        }
        throw new IllegalStateException("Lookahead root has not been set up yet".toString());
    }
}
