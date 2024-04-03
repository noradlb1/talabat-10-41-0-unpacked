package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
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
public final class AppBarKt$TopAppBarLayout$1$3$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f6466g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f6467h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6468i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6469j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBarLayout$1$3$1(long j11, float f11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f6466g = j11;
        this.f6467h = f11;
        this.f6468i = function2;
        this.f6469j = i11;
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
                ComposerKt.traceEventStart(824316656, i11, -1, "androidx.compose.material3.TopAppBarLayout.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:1270)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(Color.m2918copywmQWz5c$default(this.f6466g, this.f6467h, 0.0f, 0.0f, 0.0f, 14, (Object) null)))}, (Function2<? super Composer, ? super Integer, Unit>) this.f6468i, composer, ((this.f6469j >> 12) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
