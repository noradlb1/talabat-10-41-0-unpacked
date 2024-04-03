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
public final class AppBarKt$BottomAppBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3891g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f3892h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f3893i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f3894j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f3895k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3896l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f3897m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3898n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3899o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$BottomAppBar$1(Modifier modifier, long j11, long j12, Shape shape, float f11, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f3891g = modifier;
        this.f3892h = j11;
        this.f3893i = j12;
        this.f3894j = shape;
        this.f3895k = f11;
        this.f3896l = paddingValues;
        this.f3897m = function3;
        this.f3898n = i11;
        this.f3899o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.m1085BottomAppBarY1yfwus(this.f3891g, this.f3892h, this.f3893i, this.f3894j, this.f3895k, this.f3896l, this.f3897m, composer, this.f3898n | 1, this.f3899o);
    }
}
