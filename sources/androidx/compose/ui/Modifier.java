package androidx.compose.ui;

import a0.a;
import a0.b;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J5\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "Companion", "Element", "Node", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public interface Modifier {
    @NotNull
    public static final Companion Companion = Companion.f9553b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "()V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion implements Modifier {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ Companion f9553b = new Companion();

        private Companion() {
        }

        public boolean all(@NotNull Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return true;
        }

        public boolean any(@NotNull Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return false;
        }

        public <R> R foldIn(R r11, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r11;
        }

        public <R> R foldOut(R r11, @NotNull Function2<? super Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r11;
        }

        @NotNull
        public Modifier then(@NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return modifier;
        }

        @NotNull
        public String toString() {
            return "Modifier";
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        @Deprecated
        public static Modifier then(@NotNull Modifier modifier, @NotNull Modifier modifier2) {
            Intrinsics.checkNotNullParameter(modifier2, "other");
            return a.a(modifier, modifier2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "all", "", "predicate", "Lkotlin/Function1;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Element extends Modifier {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static boolean all(@NotNull Element element, @NotNull Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return b.a(element, function1);
            }

            @Deprecated
            public static boolean any(@NotNull Element element, @NotNull Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return b.b(element, function1);
            }

            @Deprecated
            public static <R> R foldIn(@NotNull Element element, R r11, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return b.c(element, r11, function2);
            }

            @Deprecated
            public static <R> R foldOut(@NotNull Element element, R r11, @NotNull Function2<? super Element, ? super R, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return b.d(element, r11, function2);
            }

            @NotNull
            @Deprecated
            public static Modifier then(@NotNull Element element, @NotNull Modifier modifier) {
                Intrinsics.checkNotNullParameter(modifier, "other");
                return a.a(element, modifier);
            }
        }

        boolean all(@NotNull Function1<? super Element, Boolean> function1);

        boolean any(@NotNull Function1<? super Element, Boolean> function1);

        <R> R foldIn(R r11, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

        <R> R foldOut(R r11, @NotNull Function2<? super Element, ? super R, ? extends R> function2);
    }

    @StabilityInferred(parameters = 0)
    @ExperimentalComposeUiApi
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020 H\u0000¢\u0006\u0002\b#J\"\u0010$\u001a\u00020\u00132\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0016J\u0015\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0000H\u0000¢\u0006\u0002\b-J\u0014\u0010.\u001a\u00020 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020 00J\u0017\u00101\u001a\u00020 2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0010¢\u0006\u0002\b2R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00063"}, d2 = {"Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "()V", "aggregateChildKindSet", "", "getAggregateChildKindSet$ui_release", "()I", "setAggregateChildKindSet$ui_release", "(I)V", "child", "getChild$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setChild$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "<set-?>", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "getCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "", "isAttached", "()Z", "kindSet", "getKindSet$ui_release", "setKindSet$ui_release", "node", "getNode$annotations", "getNode", "parent", "getParent$ui_release", "setParent$ui_release", "attach", "", "attach$ui_release", "detach", "detach$ui_release", "isKind", "kind", "Landroidx/compose/ui/node/NodeKind;", "isKind-H91voCI$ui_release", "(I)Z", "onAttach", "onDetach", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "sideEffect", "effect", "Lkotlin/Function0;", "updateCoordinator", "updateCoordinator$ui_release", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Node implements DelegatableNode {
        public static final int $stable = 8;
        private int aggregateChildKindSet;
        @Nullable
        private Node child;
        @Nullable
        private NodeCoordinator coordinator;
        private boolean isAttached;
        private int kindSet;
        @NotNull
        private Node node = this;
        @Nullable
        private Node parent;

        public static /* synthetic */ void getNode$annotations() {
        }

        public final void attach$ui_release() {
            boolean z11;
            if (!this.isAttached) {
                if (this.coordinator != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    this.isAttached = true;
                    onAttach();
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void detach$ui_release() {
            boolean z11;
            if (this.isAttached) {
                if (this.coordinator != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    onDetach();
                    this.isAttached = false;
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        @Nullable
        public final Node getChild$ui_release() {
            return this.child;
        }

        @Nullable
        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        @NotNull
        public final Node getNode() {
            return this.node;
        }

        @Nullable
        public final Node getParent$ui_release() {
            return this.parent;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        /* renamed from: isKind-H91voCI$ui_release  reason: not valid java name */
        public final boolean m2557isKindH91voCI$ui_release(int i11) {
            return (i11 & getKindSet$ui_release()) != 0;
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public final void setAggregateChildKindSet$ui_release(int i11) {
            this.aggregateChildKindSet = i11;
        }

        public final void setAsDelegateTo$ui_release(@NotNull Node node2) {
            Intrinsics.checkNotNullParameter(node2, "owner");
            this.node = node2;
        }

        public final void setChild$ui_release(@Nullable Node node2) {
            this.child = node2;
        }

        public final void setKindSet$ui_release(int i11) {
            this.kindSet = i11;
        }

        public final void setParent$ui_release(@Nullable Node node2) {
            this.parent = node2;
        }

        public final void sideEffect(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "effect");
            DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(function0);
        }

        public void updateCoordinator$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }
    }

    boolean all(@NotNull Function1<? super Element, Boolean> function1);

    boolean any(@NotNull Function1<? super Element, Boolean> function1);

    <R> R foldIn(R r11, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

    <R> R foldOut(R r11, @NotNull Function2<? super Element, ? super R, ? extends R> function2);

    @NotNull
    Modifier then(@NotNull Modifier modifier);
}
