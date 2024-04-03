package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarKt$NavigationBarItemBaselineLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7405g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7406h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7407i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7408j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7409k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f7410l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7411m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$NavigationBarItemBaselineLayout$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, int i11) {
        super(2);
        this.f7405g = function2;
        this.f7406h = function22;
        this.f7407i = function23;
        this.f7408j = function24;
        this.f7409k = z11;
        this.f7410l = f11;
        this.f7411m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationBarKt.NavigationBarItemBaselineLayout(this.f7405g, this.f7406h, this.f7407i, this.f7408j, this.f7409k, this.f7410l, composer, this.f7411m | 1);
    }
}
