package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomNavigationKt$BottomNavigationItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RowScope f4082g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f4083h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4084i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4085j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f4086k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f4087l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4088m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f4089n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4090o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ long f4091p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f4092q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f4093r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f4094s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f4095t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationKt$BottomNavigationItem$3(RowScope rowScope, boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function22, boolean z13, MutableInteractionSource mutableInteractionSource, long j11, long j12, int i11, int i12, int i13) {
        super(2);
        this.f4082g = rowScope;
        this.f4083h = z11;
        this.f4084i = function0;
        this.f4085j = function2;
        this.f4086k = modifier;
        this.f4087l = z12;
        this.f4088m = function22;
        this.f4089n = z13;
        this.f4090o = mutableInteractionSource;
        this.f4091p = j11;
        this.f4092q = j12;
        this.f4093r = i11;
        this.f4094s = i12;
        this.f4095t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RowScope rowScope = this.f4082g;
        RowScope rowScope2 = rowScope;
        BottomNavigationKt.m1108BottomNavigationItemjY6E1Zs(rowScope2, this.f4083h, this.f4084i, this.f4085j, this.f4086k, this.f4087l, this.f4088m, this.f4089n, this.f4090o, this.f4091p, this.f4092q, composer, this.f4093r | 1, this.f4094s, this.f4095t);
    }
}
