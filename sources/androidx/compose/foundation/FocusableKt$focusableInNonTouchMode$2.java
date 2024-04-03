package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusableKt$focusableInNonTouchMode$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1671g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1672h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusableKt$focusableInNonTouchMode$2(boolean z11, MutableInteractionSource mutableInteractionSource) {
        super(3);
        this.f1671g = z11;
        this.f1672h = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-618949501);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-618949501, i11, -1, "androidx.compose.foundation.focusableInNonTouchMode.<anonymous> (Focusable.kt:217)");
        }
        final InputModeManager inputModeManager = (InputModeManager) composer.consume(CompositionLocalsKt.getLocalInputModeManager());
        Modifier focusable = FocusableKt.focusable(FocusPropertiesKt.focusProperties(Modifier.Companion, new Function1<FocusProperties, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusProperties) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FocusProperties focusProperties) {
                Intrinsics.checkNotNullParameter(focusProperties, "$this$focusProperties");
                focusProperties.setCanFocus(!InputMode.m3574equalsimpl0(inputModeManager.m3580getInputModeaOaMEAU(), InputMode.Companion.m3579getTouchaOaMEAU()));
            }
        }), this.f1671g, this.f1672h);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return focusable;
    }
}
