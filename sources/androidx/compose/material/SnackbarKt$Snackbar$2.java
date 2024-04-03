package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt$Snackbar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f5424g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5425h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5426i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f5427j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f5428k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f5429l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f5430m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5431n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5432o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5433p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z11, Shape shape, long j11, long j12, float f11, Function2<? super Composer, ? super Integer, Unit> function22, int i11, int i12) {
        super(2);
        this.f5424g = modifier;
        this.f5425h = function2;
        this.f5426i = z11;
        this.f5427j = shape;
        this.f5428k = j11;
        this.f5429l = j12;
        this.f5430m = f11;
        this.f5431n = function22;
        this.f5432o = i11;
        this.f5433p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SnackbarKt.m1364Snackbar7zSek6w(this.f5424g, this.f5425h, this.f5426i, this.f5427j, this.f5428k, this.f5429l, this.f5430m, this.f5431n, composer, this.f5432o | 1, this.f5433p);
    }
}
