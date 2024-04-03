package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ThreeLine$ListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ThreeLine f6155g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6156h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6157i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6158j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6159k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6160l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6161m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6162n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6163o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeLine$ListItem$2(ThreeLine threeLine, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, int i11, int i12) {
        super(2);
        this.f6155g = threeLine;
        this.f6156h = modifier;
        this.f6157i = function2;
        this.f6158j = function22;
        this.f6159k = function23;
        this.f6160l = function24;
        this.f6161m = function25;
        this.f6162n = i11;
        this.f6163o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f6155g.ListItem(this.f6156h, this.f6157i, this.f6158j, this.f6159k, this.f6160l, this.f6161m, composer, this.f6162n | 1, this.f6163o);
    }
}
