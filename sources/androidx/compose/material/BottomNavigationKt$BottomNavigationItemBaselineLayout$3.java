package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomNavigationKt$BottomNavigationItemBaselineLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4100g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4101h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f4102i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4103j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationKt$BottomNavigationItemBaselineLayout$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, float f11, int i11) {
        super(2);
        this.f4100g = function2;
        this.f4101h = function22;
        this.f4102i = f11;
        this.f4103j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BottomNavigationKt.BottomNavigationItemBaselineLayout(this.f4100g, this.f4101h, this.f4102i, composer, this.f4103j | 1);
    }
}
