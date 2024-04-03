package androidx.compose.ui.focus;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusModifierKt$focusTarget$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final FocusModifierKt$focusTarget$2 INSTANCE = new FocusModifierKt$focusTarget$2();

    public FocusModifierKt$focusTarget$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-326009031);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-326009031, i11, -1, "androidx.compose.ui.focus.focusTarget.<anonymous> (FocusModifier.kt:194)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new FocusModifier(FocusStateImpl.Inactive, (Function1) null, 2, (DefaultConstructorMarker) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        FocusModifier focusModifier = (FocusModifier) rememberedValue;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) focusModifier);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new FocusModifierKt$focusTarget$2$1$1(focusModifier);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue2, composer, 0);
        Modifier focusTarget = FocusModifierKt.focusTarget(modifier, focusModifier);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return focusTarget;
    }
}
