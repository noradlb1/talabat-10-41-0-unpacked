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
public final class ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FabPlacement f5058g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5059h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5060i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(FabPlacement fabPlacement, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f5058g = fabPlacement;
        this.f5059h = function2;
        this.f5060i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(this.f5058g)}, (Function2<? super Composer, ? super Integer, Unit>) this.f5059h, composer, ((this.f5060i >> 15) & 112) | 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
