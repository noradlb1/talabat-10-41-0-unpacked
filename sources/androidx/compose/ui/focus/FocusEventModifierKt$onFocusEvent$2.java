package androidx.compose.ui.focus;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusEventModifierKt$onFocusEvent$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<FocusState, Unit> f9592g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusEventModifierKt$onFocusEvent$2(Function1<? super FocusState, Unit> function1) {
        super(3);
        this.f9592g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(607036704);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(607036704, i11, -1, "androidx.compose.ui.focus.onFocusEvent.<anonymous> (FocusEventModifier.kt:155)");
        }
        Function1<FocusState, Unit> function1 = this.f9592g;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) function1);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new FocusEventModifierLocal(function1);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) rememberedValue;
        composer.startReplaceableGroup(1157296644);
        boolean changed2 = composer.changed((Object) focusEventModifierLocal);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new FocusEventModifierKt$onFocusEvent$2$1$1(focusEventModifierLocal);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return focusEventModifierLocal;
    }
}
