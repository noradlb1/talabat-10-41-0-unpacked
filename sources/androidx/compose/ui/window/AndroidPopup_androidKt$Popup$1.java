package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Alignment f10357g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f10358h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f10359i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PopupProperties f10360j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10361k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f10362l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f10363m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$1(Alignment alignment, long j11, Function0<Unit> function0, PopupProperties popupProperties, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f10357g = alignment;
        this.f10358h = j11;
        this.f10359i = function0;
        this.f10360j = popupProperties;
        this.f10361k = function2;
        this.f10362l = i11;
        this.f10363m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidPopup_androidKt.m5728PopupK5zGePQ(this.f10357g, this.f10358h, this.f10359i, this.f10360j, this.f10361k, composer, this.f10362l | 1, this.f10363m);
    }
}
