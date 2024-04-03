package androidx.compose.ui.draw;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DrawModifierKt$drawWithCache$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<CacheDrawScope, DrawResult> f9569g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawModifierKt$drawWithCache$2(Function1<? super CacheDrawScope, DrawResult> function1) {
        super(3);
        this.f9569g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1689569019);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1689569019, i11, -1, "androidx.compose.ui.draw.drawWithCache.<anonymous> (DrawModifier.kt:141)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CacheDrawScope();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then(new DrawContentCacheModifier((CacheDrawScope) rememberedValue, this.f9569g));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
