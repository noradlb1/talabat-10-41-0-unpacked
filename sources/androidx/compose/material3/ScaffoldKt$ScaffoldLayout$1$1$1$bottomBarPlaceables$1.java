package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FabPlacement f7886g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7887h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7888i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(FabPlacement fabPlacement, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f7886g = fabPlacement;
        this.f7887h = function2;
        this.f7888i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1455477816, i11, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:195)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(this.f7886g)}, (Function2<? super Composer, ? super Integer, Unit>) this.f7887h, composer, ((this.f7888i >> 15) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
