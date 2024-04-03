package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
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
public final class ModalBottomSheetKt$ModalBottomSheetLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4735g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4736h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ModalBottomSheetState f4737i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f4738j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f4739k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f4740l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f4741m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f4742n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4743o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f4744p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4745q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetKt$ModalBottomSheetLayout$2(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, ModalBottomSheetState modalBottomSheetState, Shape shape, float f11, long j11, long j12, long j13, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4735g = function3;
        this.f4736h = modifier;
        this.f4737i = modalBottomSheetState;
        this.f4738j = shape;
        this.f4739k = f11;
        this.f4740l = j11;
        this.f4741m = j12;
        this.f4742n = j13;
        this.f4743o = function2;
        this.f4744p = i11;
        this.f4745q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ModalBottomSheetKt.m1297ModalBottomSheetLayoutBzaUkTc(this.f4735g, this.f4736h, this.f4737i, this.f4738j, this.f4739k, this.f4740l, this.f4741m, this.f4742n, this.f4743o, composer, this.f4744p | 1, this.f4745q);
    }
}
