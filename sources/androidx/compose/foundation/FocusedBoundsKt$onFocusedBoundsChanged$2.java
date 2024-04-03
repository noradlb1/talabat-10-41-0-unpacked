package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusedBoundsKt$onFocusedBoundsChanged$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<LayoutCoordinates, Unit> f1675g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusedBoundsKt$onFocusedBoundsChanged$2(Function1<? super LayoutCoordinates, Unit> function1) {
        super(3);
        this.f1675g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1176407768);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1176407768, i11, -1, "androidx.compose.foundation.onFocusedBoundsChanged.<anonymous> (FocusedBounds.kt:53)");
        }
        Function1<LayoutCoordinates, Unit> function1 = this.f1675g;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) function1);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new FocusedBoundsObserverModifier(function1);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        FocusedBoundsObserverModifier focusedBoundsObserverModifier = (FocusedBoundsObserverModifier) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return focusedBoundsObserverModifier;
    }
}
