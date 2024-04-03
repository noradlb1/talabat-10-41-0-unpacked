package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScaffoldKt$ScaffoldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f7889g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7890h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f7891i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7892j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7893k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7894l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7895m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7896n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$2(int i11, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, int i12) {
        super(2);
        this.f7889g = i11;
        this.f7890h = function2;
        this.f7891i = function3;
        this.f7892j = function22;
        this.f7893k = function23;
        this.f7894l = windowInsets;
        this.f7895m = function24;
        this.f7896n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ScaffoldKt.m1811ScaffoldLayoutFMILGgc(this.f7889g, this.f7890h, this.f7891i, this.f7892j, this.f7893k, this.f7894l, this.f7895m, composer, this.f7896n | 1);
    }
}
