package androidx.compose.ui.focus;

import a0.a;
import a0.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.focus.FocusAwareInputModifier;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 g2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001gB(\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\u0010\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020RH\u0016J\u0010\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020/2\u0006\u0010f\u001a\u00020\\H\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020/8VX\u0004¢\u0006\u0006\u001a\u0004\bE\u00101R\u001c\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000G8VX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0015¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0017R\"\u0010N\u001a\u0004\u0018\u00010K2\b\u0010M\u001a\u0004\u0018\u00010K@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020RX.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010B\"\u0004\bY\u0010DR\u001c\u0010Z\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010[X\u000e¢\u0006\b\n\u0000\u0012\u0004\b]\u0010^R\u0014\u0010:\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010B¨\u0006h"}, d2 = {"Landroidx/compose/ui/focus/FocusModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "initialFocus", "Landroidx/compose/ui/focus/FocusStateImpl;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/focus/FocusStateImpl;Lkotlin/jvm/functions/Function1;)V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "setBeyondBoundsLayoutParent", "(Landroidx/compose/ui/layout/BeyondBoundsLayout;)V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "setCoordinator", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "focusEventListener", "Landroidx/compose/ui/focus/FocusEventModifierLocal;", "getFocusEventListener", "()Landroidx/compose/ui/focus/FocusEventModifierLocal;", "setFocusEventListener", "(Landroidx/compose/ui/focus/FocusEventModifierLocal;)V", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusProperties", "()Landroidx/compose/ui/focus/FocusProperties;", "focusPropertiesModifier", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "getFocusPropertiesModifier", "()Landroidx/compose/ui/focus/FocusPropertiesModifier;", "setFocusPropertiesModifier", "(Landroidx/compose/ui/focus/FocusPropertiesModifier;)V", "focusRequestedOnPlaced", "", "getFocusRequestedOnPlaced", "()Z", "setFocusRequestedOnPlaced", "(Z)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequesterModifierLocal;)V", "value", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "focusedChild", "getFocusedChild", "()Landroidx/compose/ui/focus/FocusModifier;", "setFocusedChild", "(Landroidx/compose/ui/focus/FocusModifier;)V", "isValid", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "keyInputChildren", "Landroidx/compose/ui/input/key/KeyInputModifier;", "getKeyInputChildren", "<set-?>", "keyInputModifier", "getKeyInputModifier", "()Landroidx/compose/ui/input/key/KeyInputModifier;", "modifierLocalReadScope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "getModifierLocalReadScope", "()Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "setModifierLocalReadScope", "(Landroidx/compose/ui/modifier/ModifierLocalReadScope;)V", "parent", "getParent", "setParent", "rotaryScrollParent", "Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getRotaryScrollParent$annotations", "()V", "getValue", "onModifierLocalsUpdated", "scope", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "propagateRotaryEvent", "event", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FocusModifier extends InspectorValueInfo implements ModifierLocalConsumer, ModifierLocalProvider<FocusModifier>, OwnerScope, OnPlacedModifier {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Function1<FocusModifier, Unit> RefreshFocusProperties = FocusModifier$Companion$RefreshFocusProperties$1.INSTANCE;
    @Nullable
    private BeyondBoundsLayout beyondBoundsLayoutParent;
    @NotNull
    private final MutableVector<FocusModifier> children;
    @Nullable
    private NodeCoordinator coordinator;
    @Nullable
    private FocusEventModifierLocal focusEventListener;
    @NotNull
    private final FocusProperties focusProperties;
    @Nullable
    private FocusPropertiesModifier focusPropertiesModifier;
    private boolean focusRequestedOnPlaced;
    @Nullable
    private FocusRequesterModifierLocal focusRequester;
    @NotNull
    private FocusStateImpl focusState;
    @Nullable
    private FocusModifier focusedChild;
    @NotNull
    private final MutableVector<KeyInputModifier> keyInputChildren;
    @Nullable
    private KeyInputModifier keyInputModifier;
    public ModifierLocalReadScope modifierLocalReadScope;
    @Nullable
    private FocusModifier parent;
    @Nullable
    private FocusAwareInputModifier<RotaryScrollEvent> rotaryScrollParent;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/focus/FocusModifier$Companion;", "", "()V", "RefreshFocusProperties", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusModifier;", "", "getRefreshFocusProperties", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Function1<FocusModifier, Unit> getRefreshFocusProperties() {
            return FocusModifier.RefreshFocusProperties;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusModifier(FocusStateImpl focusStateImpl, Function1<InspectorInfo, Unit> function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(focusStateImpl, (i11 & 2) != 0 ? InspectableValueKt.getNoInspectorInfo() : function1);
    }

    private static /* synthetic */ void getRotaryScrollParent$annotations() {
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

    @Nullable
    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return this.beyondBoundsLayoutParent;
    }

    @NotNull
    public final MutableVector<FocusModifier> getChildren() {
        return this.children;
    }

    @Nullable
    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    @Nullable
    public final FocusEventModifierLocal getFocusEventListener() {
        return this.focusEventListener;
    }

    @NotNull
    public final FocusProperties getFocusProperties() {
        return this.focusProperties;
    }

    @Nullable
    public final FocusPropertiesModifier getFocusPropertiesModifier() {
        return this.focusPropertiesModifier;
    }

    public final boolean getFocusRequestedOnPlaced() {
        return this.focusRequestedOnPlaced;
    }

    @Nullable
    public final FocusRequesterModifierLocal getFocusRequester() {
        return this.focusRequester;
    }

    @NotNull
    public final FocusStateImpl getFocusState() {
        return this.focusState;
    }

    @Nullable
    public final FocusModifier getFocusedChild() {
        return this.focusedChild;
    }

    @NotNull
    public ProvidableModifierLocal<FocusModifier> getKey() {
        return FocusModifierKt.getModifierLocalParentFocusModifier();
    }

    @NotNull
    public final MutableVector<KeyInputModifier> getKeyInputChildren() {
        return this.keyInputChildren;
    }

    @Nullable
    public final KeyInputModifier getKeyInputModifier() {
        return this.keyInputModifier;
    }

    @NotNull
    public final ModifierLocalReadScope getModifierLocalReadScope() {
        ModifierLocalReadScope modifierLocalReadScope2 = this.modifierLocalReadScope;
        if (modifierLocalReadScope2 != null) {
            return modifierLocalReadScope2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("modifierLocalReadScope");
        return null;
    }

    @Nullable
    public final FocusModifier getParent() {
        return this.parent;
    }

    @NotNull
    public FocusModifier getValue() {
        return this;
    }

    public boolean isValid() {
        return this.parent != null;
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope2) {
        MutableVector<FocusModifier> mutableVector;
        MutableVector<FocusModifier> mutableVector2;
        NodeCoordinator nodeCoordinator;
        LayoutNode layoutNode;
        Owner owner$ui_release;
        FocusManager focusManager;
        Intrinsics.checkNotNullParameter(modifierLocalReadScope2, "scope");
        setModifierLocalReadScope(modifierLocalReadScope2);
        FocusModifier focusModifier = (FocusModifier) modifierLocalReadScope2.getCurrent(FocusModifierKt.getModifierLocalParentFocusModifier());
        if (!Intrinsics.areEqual((Object) focusModifier, (Object) this.parent)) {
            if (focusModifier == null) {
                int i11 = WhenMappings.$EnumSwitchMapping$0[this.focusState.ordinal()];
                if (!((i11 != 1 && i11 != 2) || (nodeCoordinator = this.coordinator) == null || (layoutNode = nodeCoordinator.getLayoutNode()) == null || (owner$ui_release = layoutNode.getOwner$ui_release()) == null || (focusManager = owner$ui_release.getFocusManager()) == null)) {
                    focusManager.clearFocus(true);
                }
            }
            FocusModifier focusModifier2 = this.parent;
            if (!(focusModifier2 == null || (mutableVector2 = focusModifier2.children) == null)) {
                mutableVector2.remove(this);
            }
            if (!(focusModifier == null || (mutableVector = focusModifier.children) == null)) {
                mutableVector.add(this);
            }
        }
        this.parent = focusModifier;
        FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) modifierLocalReadScope2.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
        if (!Intrinsics.areEqual((Object) focusEventModifierLocal, (Object) this.focusEventListener)) {
            FocusEventModifierLocal focusEventModifierLocal2 = this.focusEventListener;
            if (focusEventModifierLocal2 != null) {
                focusEventModifierLocal2.removeFocusModifier(this);
            }
            if (focusEventModifierLocal != null) {
                focusEventModifierLocal.addFocusModifier(this);
            }
        }
        this.focusEventListener = focusEventModifierLocal;
        FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) modifierLocalReadScope2.getCurrent(FocusRequesterModifierKt.getModifierLocalFocusRequester());
        if (!Intrinsics.areEqual((Object) focusRequesterModifierLocal, (Object) this.focusRequester)) {
            FocusRequesterModifierLocal focusRequesterModifierLocal2 = this.focusRequester;
            if (focusRequesterModifierLocal2 != null) {
                focusRequesterModifierLocal2.removeFocusModifier(this);
            }
            if (focusRequesterModifierLocal != null) {
                focusRequesterModifierLocal.addFocusModifier(this);
            }
        }
        this.focusRequester = focusRequesterModifierLocal;
        this.rotaryScrollParent = (FocusAwareInputModifier) modifierLocalReadScope2.getCurrent(RotaryInputModifierKt.getModifierLocalRotaryScrollParent());
        this.beyondBoundsLayoutParent = (BeyondBoundsLayout) modifierLocalReadScope2.getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
        this.keyInputModifier = (KeyInputModifier) modifierLocalReadScope2.getCurrent(KeyInputModifierKt.getModifierLocalKeyInput());
        this.focusPropertiesModifier = (FocusPropertiesModifier) modifierLocalReadScope2.getCurrent(FocusPropertiesKt.getModifierLocalFocusProperties());
        FocusPropertiesKt.refreshFocusProperties(this);
    }

    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        boolean z11;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        if (this.coordinator == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.coordinator = (NodeCoordinator) layoutCoordinates;
        if (z11) {
            FocusPropertiesKt.refreshFocusProperties(this);
        }
        if (this.focusRequestedOnPlaced) {
            this.focusRequestedOnPlaced = false;
            FocusTransactionsKt.requestFocus(this);
        }
    }

    @ExperimentalComposeUiApi
    public final boolean propagateRotaryEvent(@NotNull RotaryScrollEvent rotaryScrollEvent) {
        Intrinsics.checkNotNullParameter(rotaryScrollEvent, "event");
        FocusAwareInputModifier<RotaryScrollEvent> focusAwareInputModifier = this.rotaryScrollParent;
        if (focusAwareInputModifier != null) {
            return focusAwareInputModifier.propagateFocusAwareEvent(rotaryScrollEvent);
        }
        return false;
    }

    public final void setBeyondBoundsLayoutParent(@Nullable BeyondBoundsLayout beyondBoundsLayout) {
        this.beyondBoundsLayoutParent = beyondBoundsLayout;
    }

    public final void setCoordinator(@Nullable NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
    }

    public final void setFocusEventListener(@Nullable FocusEventModifierLocal focusEventModifierLocal) {
        this.focusEventListener = focusEventModifierLocal;
    }

    public final void setFocusPropertiesModifier(@Nullable FocusPropertiesModifier focusPropertiesModifier2) {
        this.focusPropertiesModifier = focusPropertiesModifier2;
    }

    public final void setFocusRequestedOnPlaced(boolean z11) {
        this.focusRequestedOnPlaced = z11;
    }

    public final void setFocusRequester(@Nullable FocusRequesterModifierLocal focusRequesterModifierLocal) {
        this.focusRequester = focusRequesterModifierLocal;
    }

    public final void setFocusState(@NotNull FocusStateImpl focusStateImpl) {
        Intrinsics.checkNotNullParameter(focusStateImpl, "value");
        this.focusState = focusStateImpl;
        FocusTransactionsKt.sendOnFocusEvent(this);
    }

    public final void setFocusedChild(@Nullable FocusModifier focusModifier) {
        this.focusedChild = focusModifier;
    }

    public final void setModifierLocalReadScope(@NotNull ModifierLocalReadScope modifierLocalReadScope2) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope2, "<set-?>");
        this.modifierLocalReadScope = modifierLocalReadScope2;
    }

    public final void setParent(@Nullable FocusModifier focusModifier) {
        this.parent = focusModifier;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusModifier(@NotNull FocusStateImpl focusStateImpl, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(focusStateImpl, "initialFocus");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.children = new MutableVector<>(new FocusModifier[16], 0);
        this.focusState = focusStateImpl;
        this.focusProperties = new FocusPropertiesImpl();
        this.keyInputChildren = new MutableVector<>(new KeyInputModifier[16], 0);
    }
}
