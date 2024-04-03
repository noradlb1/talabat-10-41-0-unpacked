package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class MaterialThemeKt$MaterialTheme$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Typography f4657g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4658h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4659i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaterialThemeKt$MaterialTheme$1(Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f4657g = typography;
        this.f4658h = function2;
        this.f4659i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            TextStyle body1 = this.f4657g.getBody1();
            final Function2<Composer, Integer, Unit> function2 = this.f4658h;
            final int i12 = this.f4659i;
            TextKt.ProvideTextStyle(body1, ComposableLambdaKt.composableLambda(composer, 181426554, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        MaterialTheme_androidKt.PlatformMaterialTheme(function2, composer, (i12 >> 9) & 14);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 48);
            return;
        }
        composer.skipToGroupEnd();
    }
}
