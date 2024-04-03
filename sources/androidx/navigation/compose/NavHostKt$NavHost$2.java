package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt$NavHost$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavHostController f36404g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f36405h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f36406i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f36407j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<NavGraphBuilder, Unit> f36408k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f36409l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f36410m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$2(NavHostController navHostController, String str, Modifier modifier, String str2, Function1<? super NavGraphBuilder, Unit> function1, int i11, int i12) {
        super(2);
        this.f36404g = navHostController;
        this.f36405h = str;
        this.f36406i = modifier;
        this.f36407j = str2;
        this.f36408k = function1;
        this.f36409l = i11;
        this.f36410m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavHostKt.NavHost(this.f36404g, this.f36405h, this.f36406i, this.f36407j, this.f36408k, composer, this.f36409l | 1, this.f36410m);
    }
}
