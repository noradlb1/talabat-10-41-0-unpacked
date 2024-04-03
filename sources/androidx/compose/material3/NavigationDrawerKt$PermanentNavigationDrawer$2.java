package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$PermanentNavigationDrawer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7535g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7536h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7537i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7538j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7539k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$PermanentNavigationDrawer$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, int i11, int i12) {
        super(2);
        this.f7535g = function2;
        this.f7536h = modifier;
        this.f7537i = function22;
        this.f7538j = i11;
        this.f7539k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.PermanentNavigationDrawer(this.f7535g, this.f7536h, this.f7537i, composer, this.f7538j | 1, this.f7539k);
    }
}
