package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$OneRowSnackbar$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8275g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8276h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8277i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8278j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f8279k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f8280l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f8281m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$OneRowSnackbar$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j11, long j12, int i11) {
        super(2);
        this.f8275g = function2;
        this.f8276h = function22;
        this.f8277i = function23;
        this.f8278j = textStyle;
        this.f8279k = j11;
        this.f8280l = j12;
        this.f8281m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SnackbarKt.m1826OneRowSnackbarkKq0p4A(this.f8275g, this.f8276h, this.f8277i, this.f8278j, this.f8279k, this.f8280l, composer, this.f8281m | 1);
    }
}
