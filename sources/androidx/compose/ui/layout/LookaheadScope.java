package androidx.compose.ui.layout;

import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/layout/LookaheadScope;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "disposableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "withDisposableSnapshot", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LookaheadScope {
    @Nullable
    private MutableSnapshot disposableSnapshot;
    @NotNull
    private final LayoutNode root;

    public LookaheadScope(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        this.root = layoutNode;
    }

    @NotNull
    public final LayoutNode getRoot() {
        return this.root;
    }

    public final <T> T withDisposableSnapshot(@NotNull Function0<? extends T> function0) {
        boolean z11;
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (this.disposableSnapshot == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            MutableSnapshot takeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.Companion, (Function1) null, (Function1) null, 3, (Object) null);
            this.disposableSnapshot = takeMutableSnapshot$default;
            try {
                makeCurrent = takeMutableSnapshot$default.makeCurrent();
                T invoke = function0.invoke();
                takeMutableSnapshot$default.restoreCurrent(makeCurrent);
                takeMutableSnapshot$default.dispose();
                this.disposableSnapshot = null;
                return invoke;
            } catch (Throwable th2) {
                takeMutableSnapshot$default.dispose();
                this.disposableSnapshot = null;
                throw th2;
            }
        } else {
            throw new IllegalStateException("Disposable snapshot is already active".toString());
        }
    }
}
