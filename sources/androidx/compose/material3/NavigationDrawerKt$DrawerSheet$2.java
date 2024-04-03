package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$DrawerSheet$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7466g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7467h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f7468i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7469j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f7470k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f7471l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7472m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7473n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7474o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$DrawerSheet$2(WindowInsets windowInsets, Modifier modifier, Shape shape, long j11, long j12, float f11, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7466g = windowInsets;
        this.f7467h = modifier;
        this.f7468i = shape;
        this.f7469j = j11;
        this.f7470k = j12;
        this.f7471l = f11;
        this.f7472m = function3;
        this.f7473n = i11;
        this.f7474o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.m1764DrawerSheetvywBR7E(this.f7466g, this.f7467h, this.f7468i, this.f7469j, this.f7470k, this.f7471l, this.f7472m, composer, this.f7473n | 1, this.f7474o);
    }
}
