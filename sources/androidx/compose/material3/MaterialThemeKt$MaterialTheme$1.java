package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MaterialThemeKt$MaterialTheme$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Typography f7312g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7313h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7314i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaterialThemeKt$MaterialTheme$1(Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f7312g = typography;
        this.f7313h = function2;
        this.f7314i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1066563262, i11, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
            }
            TextKt.ProvideTextStyle(this.f7312g.getBodyLarge(), this.f7313h, composer, (this.f7314i >> 6) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
