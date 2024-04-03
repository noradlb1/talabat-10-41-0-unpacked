package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TwoLine$ListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TwoLine f6173g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6174h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6175i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6176j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6177k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6178l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6179m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6180n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6181o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoLine$ListItem$2(TwoLine twoLine, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, int i11, int i12) {
        super(2);
        this.f6173g = twoLine;
        this.f6174h = modifier;
        this.f6175i = function2;
        this.f6176j = function22;
        this.f6177k = function23;
        this.f6178l = function24;
        this.f6179m = function25;
        this.f6180n = i11;
        this.f6181o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f6173g.ListItem(this.f6174h, this.f6175i, this.f6176j, this.f6177k, this.f6178l, this.f6179m, composer, this.f6180n | 1, this.f6181o);
    }
}
