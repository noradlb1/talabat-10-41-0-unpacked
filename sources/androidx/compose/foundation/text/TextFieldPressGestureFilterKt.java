package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"tapPressTextFieldModifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onTap", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextFieldPressGestureFilterKt {
    @NotNull
    public static final Modifier tapPressTextFieldModifier(@NotNull Modifier modifier, @Nullable MutableInteractionSource mutableInteractionSource, boolean z11, @NotNull Function1<? super Offset, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onTap");
        if (z11) {
            return ComposedModifierKt.composed$default(modifier, (Function1) null, new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1(function1, mutableInteractionSource), 1, (Object) null);
        }
        return modifier;
    }

    public static /* synthetic */ Modifier tapPressTextFieldModifier$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return tapPressTextFieldModifier(modifier, mutableInteractionSource, z11, function1);
    }
}
