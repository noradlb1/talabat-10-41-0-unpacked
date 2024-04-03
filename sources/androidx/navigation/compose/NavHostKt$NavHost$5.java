package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt$NavHost$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavHostController f36420g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavGraph f36421h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f36422i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f36423j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f36424k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$5(NavHostController navHostController, NavGraph navGraph, Modifier modifier, int i11, int i12) {
        super(2);
        this.f36420g = navHostController;
        this.f36421h = navGraph;
        this.f36422i = modifier;
        this.f36423j = i11;
        this.f36424k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavHostKt.NavHost(this.f36420g, this.f36421h, this.f36422i, composer, this.f36423j | 1, this.f36424k);
    }
}
