package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt$Decoration$contentWithColor$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f8811g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8812h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8813i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$Decoration$contentWithColor$1(long j11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f8811g = j11;
        this.f8812h = function2;
        this.f8813i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1449369305, i11, -1, "androidx.compose.material3.Decoration.<anonymous> (TextFieldImpl.kt:241)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(this.f8811g))}, (Function2<? super Composer, ? super Integer, Unit>) this.f8812h, composer, ((this.f8813i >> 3) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
