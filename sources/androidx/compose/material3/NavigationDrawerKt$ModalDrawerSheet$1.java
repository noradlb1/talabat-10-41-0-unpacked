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
public final class NavigationDrawerKt$ModalDrawerSheet$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7475g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f7476h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7477i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7478j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f7479k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7480l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7481m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7482n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7483o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$ModalDrawerSheet$1(Modifier modifier, Shape shape, long j11, long j12, float f11, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7475g = modifier;
        this.f7476h = shape;
        this.f7477i = j11;
        this.f7478j = j12;
        this.f7479k = f11;
        this.f7480l = windowInsets;
        this.f7481m = function3;
        this.f7482n = i11;
        this.f7483o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.m1765ModalDrawerSheetafqeVBk(this.f7475g, this.f7476h, this.f7477i, this.f7478j, this.f7479k, this.f7480l, this.f7481m, composer, this.f7482n | 1, this.f7483o);
    }
}
