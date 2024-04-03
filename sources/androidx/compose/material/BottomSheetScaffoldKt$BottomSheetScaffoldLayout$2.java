package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4229g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f4230h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, Composer, Integer, Unit> f4231i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4232j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4233k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f4234l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4235m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4236n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ BottomSheetState f4237o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f4238p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, float f11, int i11, State<Float> state, BottomSheetState bottomSheetState, int i12) {
        super(2);
        this.f4229g = function2;
        this.f4230h = function3;
        this.f4231i = function32;
        this.f4232j = function22;
        this.f4233k = function23;
        this.f4234l = f11;
        this.f4235m = i11;
        this.f4236n = state;
        this.f4237o = bottomSheetState;
        this.f4238p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BottomSheetScaffoldKt.m1121BottomSheetScaffoldLayoutKCBPh4w(this.f4229g, this.f4230h, this.f4231i, this.f4232j, this.f4233k, this.f4234l, this.f4235m, this.f4236n, this.f4237o, composer, this.f4238p | 1);
    }
}
