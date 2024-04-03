package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutIdKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarKt$NavigationBarItem$3$indicatorRipple$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MappedInteractionSource f7376g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$NavigationBarItem$3$indicatorRipple$1(MappedInteractionSource mappedInteractionSource) {
        super(2);
        this.f7376g = mappedInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(691730997, i11, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:229)");
            }
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.Companion, "indicatorRipple"), ShapesKt.toShape(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer, 6)), this.f7376g, RippleKt.m1485rememberRipple9IZ8Weo(false, 0.0f, 0, composer, 0, 7)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
