package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$NavigationRailItemBaselineLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4796g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4797h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f4798i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4799j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItemBaselineLayout$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, float f11, int i11) {
        super(2);
        this.f4796g = function2;
        this.f4797h = function22;
        this.f4798i = f11;
        this.f4799j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationRailKt.NavigationRailItemBaselineLayout(this.f4796g, this.f4797h, this.f4798i, composer, this.f4799j | 1);
    }
}
