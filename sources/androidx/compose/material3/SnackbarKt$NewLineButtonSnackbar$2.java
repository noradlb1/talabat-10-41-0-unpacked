package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$NewLineButtonSnackbar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8257g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8258h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8259i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8260j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f8261k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f8262l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f8263m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$NewLineButtonSnackbar$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j11, long j12, int i11) {
        super(2);
        this.f8257g = function2;
        this.f8258h = function22;
        this.f8259i = function23;
        this.f8260j = textStyle;
        this.f8261k = j11;
        this.f8262l = j12;
        this.f8263m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SnackbarKt.m1825NewLineButtonSnackbarkKq0p4A(this.f8257g, this.f8258h, this.f8259i, this.f8260j, this.f8261k, this.f8262l, composer, this.f8263m | 1);
    }
}
