package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$Snackbar$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8310g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f8311h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8312i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f8313j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f8314k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f8315l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f8316m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f8317n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f8318o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f8319p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f8320q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$4(SnackbarData snackbarData, Modifier modifier, boolean z11, Shape shape, long j11, long j12, long j13, long j14, long j15, int i11, int i12) {
        super(2);
        this.f8310g = snackbarData;
        this.f8311h = modifier;
        this.f8312i = z11;
        this.f8313j = shape;
        this.f8314k = j11;
        this.f8315l = j12;
        this.f8316m = j13;
        this.f8317n = j14;
        this.f8318o = j15;
        this.f8319p = i11;
        this.f8320q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        SnackbarData snackbarData = this.f8310g;
        SnackbarData snackbarData2 = snackbarData;
        SnackbarKt.m1828SnackbarsDKtq54(snackbarData2, this.f8311h, this.f8312i, this.f8313j, this.f8314k, this.f8315l, this.f8316m, this.f8317n, this.f8318o, composer2, this.f8319p | 1, this.f8320q);
    }
}
