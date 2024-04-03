package androidx.compose.ui.focus;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusChangedModifierKt$onFocusChanged$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<FocusState, Unit> f9588g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusChangedModifierKt$onFocusChanged$2(Function1<? super FocusState, Unit> function1) {
        super(3);
        this.f9588g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1741761824);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1741761824, i11, -1, "androidx.compose.ui.focus.onFocusChanged.<anonymous> (FocusChangedModifier.kt:41)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        Modifier.Companion companion2 = Modifier.Companion;
        Function1<FocusState, Unit> function1 = this.f9588g;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed((Object) mutableState) | composer.changed((Object) function1);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new FocusChangedModifierKt$onFocusChanged$2$1$1(mutableState, function1);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier onFocusEvent = FocusEventModifierKt.onFocusEvent(companion2, (Function1) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return onFocusEvent;
    }
}
