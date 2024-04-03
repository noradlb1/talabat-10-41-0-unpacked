package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$BottomAppBar$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6384g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f6385h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6386i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f6387j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6388k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6389l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6390m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6391n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6392o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$BottomAppBar$4(Modifier modifier, long j11, long j12, float f11, PaddingValues paddingValues, WindowInsets windowInsets, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6384g = modifier;
        this.f6385h = j11;
        this.f6386i = j12;
        this.f6387j = f11;
        this.f6388k = paddingValues;
        this.f6389l = windowInsets;
        this.f6390m = function3;
        this.f6391n = i11;
        this.f6392o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.m1498BottomAppBar1oL4kX8(this.f6384g, this.f6385h, this.f6386i, this.f6387j, this.f6388k, this.f6389l, this.f6390m, composer, this.f6391n | 1, this.f6392o);
    }
}
