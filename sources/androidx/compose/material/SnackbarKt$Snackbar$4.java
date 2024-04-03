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
public final class SnackbarKt$Snackbar$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f5435g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5436h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5437i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f5438j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f5439k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f5440l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f5441m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f5442n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5443o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5444p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$4(SnackbarData snackbarData, Modifier modifier, boolean z11, Shape shape, long j11, long j12, long j13, float f11, int i11, int i12) {
        super(2);
        this.f5435g = snackbarData;
        this.f5436h = modifier;
        this.f5437i = z11;
        this.f5438j = shape;
        this.f5439k = j11;
        this.f5440l = j12;
        this.f5441m = j13;
        this.f5442n = f11;
        this.f5443o = i11;
        this.f5444p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SnackbarKt.m1365SnackbarsPrSdHI(this.f5435g, this.f5436h, this.f5437i, this.f5438j, this.f5439k, this.f5440l, this.f5441m, this.f5442n, composer, this.f5443o | 1, this.f5444p);
    }
}
