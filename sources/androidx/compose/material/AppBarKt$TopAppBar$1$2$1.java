package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AppBarKt$TopAppBar$1$2$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3904g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3905h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBar$1$2$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3904g = function2;
        this.f3905h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6)))}, (Function2<? super Composer, ? super Integer, Unit>) this.f3904g, composer, ((this.f3905h << 3) & 112) | 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
