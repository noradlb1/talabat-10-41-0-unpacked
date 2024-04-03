package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ListItemKt$ProvideTextStyleFromToken$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextStyle f7286g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7287h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7288i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$ProvideTextStyleFromToken$1(TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f7286g = textStyle;
        this.f7287h = function2;
        this.f7288i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-514310925, i11, -1, "androidx.compose.material3.ProvideTextStyleFromToken.<anonymous> (ListItem.kt:495)");
            }
            TextKt.ProvideTextStyle(this.f7286g, this.f7287h, composer, (this.f7288i >> 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
