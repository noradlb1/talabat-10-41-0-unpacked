package androidx.compose.foundation.relocation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BringIntoViewRequesterKt$bringIntoViewRequester$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewRequester f3189g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BringIntoViewRequesterKt$bringIntoViewRequester$2(BringIntoViewRequester bringIntoViewRequester) {
        super(3);
        this.f3189g = bringIntoViewRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-992853993);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-992853993, i11, -1, "androidx.compose.foundation.relocation.bringIntoViewRequester.<anonymous> (BringIntoViewRequester.kt:100)");
        }
        BringIntoViewParent rememberDefaultBringIntoViewParent = BringIntoViewResponder_androidKt.rememberDefaultBringIntoViewParent(composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) rememberDefaultBringIntoViewParent);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new BringIntoViewRequesterModifier(rememberDefaultBringIntoViewParent);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final BringIntoViewRequesterModifier bringIntoViewRequesterModifier = (BringIntoViewRequesterModifier) rememberedValue;
        final BringIntoViewRequester bringIntoViewRequester = this.f3189g;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            EffectsKt.DisposableEffect((Object) bringIntoViewRequester, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    ((BringIntoViewRequesterImpl) bringIntoViewRequester).getModifiers().add(bringIntoViewRequesterModifier);
                    return new BringIntoViewRequesterKt$bringIntoViewRequester$2$1$invoke$$inlined$onDispose$1(bringIntoViewRequester, bringIntoViewRequesterModifier);
                }
            }, composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bringIntoViewRequesterModifier;
    }
}
