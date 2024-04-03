package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import com.braze.models.FeatureFlag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a-\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\n"}, d2 = {"clearAndSetSemantics", "Landroidx/compose/ui/Modifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "semantics", "mergeDescendants", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SemanticsModifierKt {
    @NotNull
    public static final Modifier clearAndSetSemantics(@NotNull Modifier modifier, @NotNull Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, FeatureFlag.PROPERTIES);
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new SemanticsModifierKt$clearAndSetSemantics$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SemanticsModifierCore(false, true, function1, function12));
    }

    @NotNull
    public static final Modifier semantics(@NotNull Modifier modifier, boolean z11, @NotNull Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, FeatureFlag.PROPERTIES);
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new SemanticsModifierKt$semantics$$inlined$debugInspectorInfo$1(z11, function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SemanticsModifierCore(z11, false, function1, function12));
    }

    public static /* synthetic */ Modifier semantics$default(Modifier modifier, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return semantics(modifier, z11, function1);
    }
}
