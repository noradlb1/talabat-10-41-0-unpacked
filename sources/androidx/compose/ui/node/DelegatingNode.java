package androidx.compose.ui.node;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import com.facebook.appevents.UserDataStore;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J#\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000eH\bJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\b0\u0010\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nJ\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0017\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0010¢\u0006\u0002\b\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "delegate", "addDelegate", "", "node", "delegated", "T", "fn", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier$Node;", "forEachDelegate", "block", "Lkotlin/Function1;", "lazyDelegated", "Lkotlin/Lazy;", "onAttach", "onDetach", "updateCoordinator", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    @Nullable
    private Modifier.Node delegate;

    private final void addDelegate(Modifier.Node node) {
        Modifier.Node node2 = this.delegate;
        if (node2 != null) {
            node.setParent$ui_release(node2);
        }
        this.delegate = node;
    }

    private final void forEachDelegate(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            function1.invoke(node);
        }
    }

    @NotNull
    public final <T extends Modifier.Node> T delegated(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, UserDataStore.FIRST_NAME);
        Modifier.Node node = getNode();
        T t11 = (Modifier.Node) function0.invoke();
        t11.setAsDelegateTo$ui_release(node);
        if (isAttached()) {
            updateCoordinator$ui_release(node.getCoordinator$ui_release());
            t11.attach$ui_release();
        }
        addDelegate(t11);
        return t11;
    }

    @NotNull
    public final <T extends Modifier.Node> Lazy<T> lazyDelegated(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, UserDataStore.FIRST_NAME);
        return LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new DelegatingNode$lazyDelegated$1(this, function0));
    }

    public void onAttach() {
        super.onAttach();
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            updateCoordinator$ui_release(getCoordinator$ui_release());
            node.attach$ui_release();
        }
    }

    public void onDetach() {
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            node.detach$ui_release();
        }
        super.onDetach();
    }

    public void updateCoordinator$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
        super.updateCoordinator$ui_release(nodeCoordinator);
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            node.updateCoordinator$ui_release(nodeCoordinator);
        }
    }
}
