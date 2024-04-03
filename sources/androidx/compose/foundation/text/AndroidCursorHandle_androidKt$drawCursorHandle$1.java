package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCursorHandle_androidKt$drawCursorHandle$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final AndroidCursorHandle_androidKt$drawCursorHandle$1 INSTANCE = new AndroidCursorHandle_androidKt$drawCursorHandle$1();

    public AndroidCursorHandle_androidKt$drawCursorHandle$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-2126899193);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2126899193, i11, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:62)");
        }
        long r02 = ((TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m1074getHandleColor0d7_KjU();
        Modifier.Companion companion = Modifier.Companion;
        Color r22 = Color.m2909boximpl(r02);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) r22);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1(r02);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then(DrawModifierKt.drawWithCache(companion, (Function1) rememberedValue));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
