package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationRailKt$NavigationRailItem$2$indicator$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavigationRailItemColors f7567g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7568h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f7569i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7570j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItem$2$indicator$1(NavigationRailItemColors navigationRailItemColors, int i11, Shape shape, State<Float> state) {
        super(2);
        this.f7567g = navigationRailItemColors;
        this.f7568h = i11;
        this.f7569i = shape;
        this.f7570j = state;
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
                ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
            }
            BoxKt.Box(BackgroundKt.m176backgroundbw27NRU(LayoutIdKt.layoutId(Modifier.Companion, "indicator"), Color.m2918copywmQWz5c$default(this.f7567g.getIndicatorColor(composer, (this.f7568h >> 21) & 14), NavigationRailKt.m1776NavigationRailItem$lambda5$lambda2(this.f7570j), 0.0f, 0.0f, 0.0f, 14, (Object) null), this.f7569i), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
