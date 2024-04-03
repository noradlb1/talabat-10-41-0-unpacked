package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.InspectableValueKt;
import com.braze.models.FeatureFlag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a#\u0010\b\u001a\u00020\t*\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"ModifierLocalFocusProperties", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "getModifierLocalFocusProperties", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "clear", "", "Landroidx/compose/ui/focus/FocusProperties;", "focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "refreshFocusProperties", "Landroidx/compose/ui/focus/FocusModifier;", "setUpdatedProperties", "properties", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FocusPropertiesKt {
    @NotNull
    private static final ProvidableModifierLocal<FocusPropertiesModifier> ModifierLocalFocusProperties = ModifierLocalKt.modifierLocalOf(FocusPropertiesKt$ModifierLocalFocusProperties$1.INSTANCE);

    public static final void clear(@NotNull FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "<this>");
        focusProperties.setCanFocus(true);
        FocusRequester.Companion companion = FocusRequester.Companion;
        focusProperties.setNext(companion.getDefault());
        focusProperties.setPrevious(companion.getDefault());
        focusProperties.setUp(companion.getDefault());
        focusProperties.setDown(companion.getDefault());
        focusProperties.setLeft(companion.getDefault());
        focusProperties.setRight(companion.getDefault());
        focusProperties.setStart(companion.getDefault());
        focusProperties.setEnd(companion.getDefault());
        focusProperties.setEnter(FocusPropertiesKt$clear$1.INSTANCE);
        focusProperties.setExit(FocusPropertiesKt$clear$2.INSTANCE);
    }

    @NotNull
    public static final Modifier focusProperties(@NotNull Modifier modifier, @NotNull Function1<? super FocusProperties, Unit> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "scope");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new FocusPropertiesKt$focusProperties$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new FocusPropertiesModifier(function1, function12));
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusPropertiesModifier> getModifierLocalFocusProperties() {
        return ModifierLocalFocusProperties;
    }

    public static final void refreshFocusProperties(@NotNull FocusModifier focusModifier) {
        OwnerSnapshotObserver snapshotObserver;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        if (coordinator != null) {
            clear(focusModifier.getFocusProperties());
            Owner owner$ui_release = coordinator.getLayoutNode().getOwner$ui_release();
            if (!(owner$ui_release == null || (snapshotObserver = owner$ui_release.getSnapshotObserver()) == null)) {
                snapshotObserver.observeReads$ui_release(focusModifier, FocusModifier.Companion.getRefreshFocusProperties(), new FocusPropertiesKt$refreshFocusProperties$1(focusModifier));
            }
            setUpdatedProperties(focusModifier, focusModifier.getFocusProperties());
        }
    }

    public static final void setUpdatedProperties(@NotNull FocusModifier focusModifier, @NotNull FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        Intrinsics.checkNotNullParameter(focusProperties, FeatureFlag.PROPERTIES);
        if (focusProperties.getCanFocus()) {
            FocusTransactionsKt.activateNode(focusModifier);
        } else {
            FocusTransactionsKt.deactivateNode(focusModifier);
        }
    }
}
