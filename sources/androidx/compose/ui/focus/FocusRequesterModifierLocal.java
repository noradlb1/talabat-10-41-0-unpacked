package androidx.compose.ui.focus;

import a0.a;
import a0.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/ui/focus/FocusRequester;)V", "focusModifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusModifier;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "parent", "value", "getValue", "()Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "addFocusModifier", "", "focusModifier", "addFocusModifiers", "newModifiers", "findFocusNode", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "removeFocusModifier", "removeFocusModifiers", "removedModifiers", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FocusRequesterModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<FocusRequesterModifierLocal> {
    @NotNull
    private final MutableVector<FocusModifier> focusModifiers = new MutableVector<>(new FocusModifier[16], 0);
    @NotNull
    private final FocusRequester focusRequester;
    @Nullable
    private FocusRequesterModifierLocal parent;

    public FocusRequesterModifierLocal(@NotNull FocusRequester focusRequester2) {
        Intrinsics.checkNotNullParameter(focusRequester2, "focusRequester");
        this.focusRequester = focusRequester2;
        focusRequester2.getFocusRequesterModifierLocals$ui_release().add(this);
    }

    public final void addFocusModifier(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        this.focusModifiers.add(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifier(focusModifier);
        }
    }

    public final void addFocusModifiers(@NotNull MutableVector<FocusModifier> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "newModifiers");
        MutableVector<FocusModifier> mutableVector2 = this.focusModifiers;
        mutableVector2.addAll(mutableVector2.getSize(), mutableVector);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifiers(mutableVector);
        }
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        if (r7.indexOf(r5) < r7.indexOf(r6)) goto L_0x008b;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.focus.FocusModifier findFocusNode() {
        /*
            r9 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusModifier> r0 = r9.focusModifiers
            int r1 = r0.getSize()
            r2 = 0
            if (r1 <= 0) goto L_0x008f
            java.lang.Object[] r0 = r0.getContent()
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            r3 = 0
        L_0x0013:
            r4 = r0[r3]
            androidx.compose.ui.focus.FocusModifier r4 = (androidx.compose.ui.focus.FocusModifier) r4
            if (r2 == 0) goto L_0x008a
            androidx.compose.ui.node.NodeCoordinator r5 = r2.getCoordinator()
            if (r5 == 0) goto L_0x008a
            androidx.compose.ui.node.LayoutNode r5 = r5.getLayoutNode()
            if (r5 != 0) goto L_0x0026
            goto L_0x008a
        L_0x0026:
            androidx.compose.ui.node.NodeCoordinator r6 = r4.getCoordinator()
            if (r6 == 0) goto L_0x008b
            androidx.compose.ui.node.LayoutNode r6 = r6.getLayoutNode()
            if (r6 != 0) goto L_0x0033
            goto L_0x008b
        L_0x0033:
            int r7 = r5.getDepth$ui_release()
            int r8 = r6.getDepth$ui_release()
            if (r7 <= r8) goto L_0x0045
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            goto L_0x0033
        L_0x0045:
            int r7 = r6.getDepth$ui_release()
            int r8 = r5.getDepth$ui_release()
            if (r7 <= r8) goto L_0x0057
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto L_0x0045
        L_0x0057:
            androidx.compose.ui.node.LayoutNode r7 = r5.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r8 = r6.getParent$ui_release()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x0074
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto L_0x0057
        L_0x0074:
            androidx.compose.ui.node.LayoutNode r7 = r5.getParent$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.util.List r7 = r7.getChildren$ui_release()
            int r5 = r7.indexOf(r5)
            int r6 = r7.indexOf(r6)
            if (r5 >= r6) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r2 = r4
        L_0x008b:
            int r3 = r3 + 1
            if (r3 < r1) goto L_0x0013
        L_0x008f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequesterModifierLocal.findFocusNode():androidx.compose.ui.focus.FocusModifier");
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @NotNull
    public ProvidableModifierLocal<FocusRequesterModifierLocal> getKey() {
        return FocusRequesterModifierKt.getModifierLocalFocusRequester();
    }

    @NotNull
    public FocusRequesterModifierLocal getValue() {
        return this;
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) modifierLocalReadScope.getCurrent(FocusRequesterModifierKt.getModifierLocalFocusRequester());
        if (!Intrinsics.areEqual((Object) focusRequesterModifierLocal, (Object) this.parent)) {
            FocusRequesterModifierLocal focusRequesterModifierLocal2 = this.parent;
            if (focusRequesterModifierLocal2 != null) {
                focusRequesterModifierLocal2.removeFocusModifiers(this.focusModifiers);
            }
            if (focusRequesterModifierLocal != null) {
                focusRequesterModifierLocal.addFocusModifiers(this.focusModifiers);
            }
            this.parent = focusRequesterModifierLocal;
        }
    }

    public final void removeFocusModifier(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        this.focusModifiers.remove(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifier(focusModifier);
        }
    }

    public final void removeFocusModifiers(@NotNull MutableVector<FocusModifier> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "removedModifiers");
        this.focusModifiers.removeAll(mutableVector);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifiers(mutableVector);
        }
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
