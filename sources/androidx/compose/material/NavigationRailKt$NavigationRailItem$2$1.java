package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$NavigationRailItem$2$1 extends Lambda implements Function3<Float, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4776g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4777h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4778i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4779j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItem$2$1(boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11) {
        super(3);
        this.f4776g = z11;
        this.f4777h = function2;
        this.f4778i = function22;
        this.f4779j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).floatValue(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(float f11, @Nullable Composer composer, int i11) {
        if ((i11 & 14) == 0) {
            i11 |= composer.changed(f11) ? 4 : 2;
        }
        if ((i11 & 91) != 18 || !composer.getSkipping()) {
            if (this.f4776g) {
                f11 = 1.0f;
            }
            NavigationRailKt.NavigationRailItemBaselineLayout(this.f4777h, this.f4778i, f11, composer, (this.f4779j >> 6) & 14);
            return;
        }
        composer.skipToGroupEnd();
    }
}
