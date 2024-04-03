package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarKt$NavigationBarItem$3$indicator$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavigationBarItemColors f7374g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7375h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$NavigationBarItem$3$indicator$1(NavigationBarItemColors navigationBarItemColors, State<Float> state) {
        super(2);
        this.f7374g = navigationBarItemColors;
        this.f7375h = state;
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
                ComposerKt.traceEventStart(-474426875, i11, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:237)");
            }
            BoxKt.Box(BackgroundKt.m176backgroundbw27NRU(LayoutIdKt.layoutId(Modifier.Companion, "indicator"), Color.m2918copywmQWz5c$default(this.f7374g.m1746getIndicatorColor0d7_KjU$material3_release(), NavigationBarKt.m1751NavigationBarItem$lambda9$lambda6(this.f7375h), 0.0f, 0.0f, 0.0f, 14, (Object) null), ShapesKt.toShape(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer, 6)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
