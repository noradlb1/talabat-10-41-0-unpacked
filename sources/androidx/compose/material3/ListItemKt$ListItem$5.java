package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ListItemKt$ListItem$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7260g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7261h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7262i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7263j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7264k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7265l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ListItemColors f7266m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f7267n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f7268o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7269p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7270q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$5(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, ListItemColors listItemColors, float f11, float f12, int i11, int i12) {
        super(2);
        this.f7260g = function2;
        this.f7261h = modifier;
        this.f7262i = function22;
        this.f7263j = function23;
        this.f7264k = function24;
        this.f7265l = function25;
        this.f7266m = listItemColors;
        this.f7267n = f11;
        this.f7268o = f12;
        this.f7269p = i11;
        this.f7270q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemKt.m1728ListItemHXNGIdc(this.f7260g, this.f7261h, this.f7262i, this.f7263j, this.f7264k, this.f7265l, this.f7266m, this.f7267n, this.f7268o, composer, this.f7269p | 1, this.f7270q);
    }
}
