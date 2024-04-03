package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AppBarKt$AppBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f3882g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f3883h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f3884i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3885j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f3886k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Modifier f3887l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f3888m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3889n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3890o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$AppBar$2(long j11, long j12, float f11, PaddingValues paddingValues, Shape shape, Modifier modifier, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f3882g = j11;
        this.f3883h = j12;
        this.f3884i = f11;
        this.f3885j = paddingValues;
        this.f3886k = shape;
        this.f3887l = modifier;
        this.f3888m = function3;
        this.f3889n = i11;
        this.f3890o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.m1084AppBarcelAv9A(this.f3882g, this.f3883h, this.f3884i, this.f3885j, this.f3886k, this.f3887l, this.f3888m, composer, this.f3889n | 1, this.f3890o);
    }
}
