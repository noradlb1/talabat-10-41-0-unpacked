package androidx.compose.ui.input.key;

import a0.a;
import a0.b;
import android.view.KeyEvent;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B4\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u001b\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u001b\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010'R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "onKeyEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "focusModifier", "Landroidx/compose/ui/focus/FocusModifier;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "<set-?>", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "getOnKeyEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreviewKeyEvent", "parent", "getParent", "()Landroidx/compose/ui/input/key/KeyInputModifier;", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "processKeyInput", "keyEvent", "processKeyInput-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "propagateKeyEvent", "propagateKeyEvent-ZmokQxo", "propagatePreviewKeyEvent", "propagatePreviewKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyInputModifier implements ModifierLocalConsumer, ModifierLocalProvider<KeyInputModifier>, OnPlacedModifier {
    @Nullable
    private FocusModifier focusModifier;
    @Nullable
    private LayoutNode layoutNode;
    @Nullable
    private final Function1<KeyEvent, Boolean> onKeyEvent;
    @Nullable
    private final Function1<KeyEvent, Boolean> onPreviewKeyEvent;
    @Nullable
    private KeyInputModifier parent;

    public KeyInputModifier(@Nullable Function1<? super KeyEvent, Boolean> function1, @Nullable Function1<? super KeyEvent, Boolean> function12) {
        this.onKeyEvent = function1;
        this.onPreviewKeyEvent = function12;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public ProvidableModifierLocal<KeyInputModifier> getKey() {
        return KeyInputModifierKt.getModifierLocalKeyInput();
    }

    @Nullable
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Nullable
    public final Function1<KeyEvent, Boolean> getOnKeyEvent() {
        return this.onKeyEvent;
    }

    @Nullable
    public final Function1<KeyEvent, Boolean> getOnPreviewKeyEvent() {
        return this.onPreviewKeyEvent;
    }

    @Nullable
    public final KeyInputModifier getParent() {
        return this.parent;
    }

    @NotNull
    public KeyInputModifier getValue() {
        return this;
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        MutableVector<KeyInputModifier> keyInputChildren;
        MutableVector<KeyInputModifier> keyInputChildren2;
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        FocusModifier focusModifier2 = this.focusModifier;
        if (!(focusModifier2 == null || (keyInputChildren2 = focusModifier2.getKeyInputChildren()) == null)) {
            keyInputChildren2.remove(this);
        }
        FocusModifier focusModifier3 = (FocusModifier) modifierLocalReadScope.getCurrent(FocusModifierKt.getModifierLocalParentFocusModifier());
        this.focusModifier = focusModifier3;
        if (!(focusModifier3 == null || (keyInputChildren = focusModifier3.getKeyInputChildren()) == null)) {
            keyInputChildren.add(this);
        }
        this.parent = (KeyInputModifier) modifierLocalReadScope.getCurrent(KeyInputModifierKt.getModifierLocalKeyInput());
    }

    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.layoutNode = ((NodeCoordinator) layoutCoordinates).getLayoutNode();
    }

    /* renamed from: processKeyInput-ZmokQxo  reason: not valid java name */
    public final boolean m4190processKeyInputZmokQxo(@NotNull KeyEvent keyEvent) {
        FocusModifier findActiveFocusNode;
        KeyInputModifier findLastKeyInputModifier;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusModifier focusModifier2 = this.focusModifier;
        if (focusModifier2 == null || (findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusModifier2)) == null || (findLastKeyInputModifier = FocusTraversalKt.findLastKeyInputModifier(findActiveFocusNode)) == null) {
            throw new IllegalStateException("KeyEvent can't be processed because this key input node is not active.".toString());
        } else if (findLastKeyInputModifier.m4192propagatePreviewKeyEventZmokQxo(keyEvent)) {
            return true;
        } else {
            return findLastKeyInputModifier.m4191propagateKeyEventZmokQxo(keyEvent);
        }
    }

    /* renamed from: propagateKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean m4191propagateKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        Function1<KeyEvent, Boolean> function1 = this.onKeyEvent;
        if (function1 != null) {
            bool = function1.invoke(KeyEvent.m4166boximpl(keyEvent));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            return bool.booleanValue();
        }
        KeyInputModifier keyInputModifier = this.parent;
        if (keyInputModifier != null) {
            return keyInputModifier.m4191propagateKeyEventZmokQxo(keyEvent);
        }
        return false;
    }

    /* renamed from: propagatePreviewKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean m4192propagatePreviewKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        KeyInputModifier keyInputModifier = this.parent;
        if (keyInputModifier != null) {
            bool = Boolean.valueOf(keyInputModifier.m4192propagatePreviewKeyEventZmokQxo(keyEvent));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            return bool.booleanValue();
        }
        Function1<KeyEvent, Boolean> function1 = this.onPreviewKeyEvent;
        if (function1 != null) {
            return function1.invoke(KeyEvent.m4166boximpl(keyEvent)).booleanValue();
        }
        return false;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
