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
public final class TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f8767g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8768h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1(long j11, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.f8767g = j11;
        this.f8768h = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(175497959, i11, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:148)");
            }
            TextFieldImplKt.m1923DecorationKTwxG1Y(this.f8767g, (TextStyle) null, this.f8768h, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
