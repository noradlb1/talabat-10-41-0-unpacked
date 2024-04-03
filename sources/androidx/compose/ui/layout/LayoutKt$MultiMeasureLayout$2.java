package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutKt$MultiMeasureLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f9842g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f9843h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MeasurePolicy f9844i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f9845j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f9846k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutKt$MultiMeasureLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MeasurePolicy measurePolicy, int i11, int i12) {
        super(2);
        this.f9842g = modifier;
        this.f9843h = function2;
        this.f9844i = measurePolicy;
        this.f9845j = i11;
        this.f9846k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LayoutKt.MultiMeasureLayout(this.f9842g, this.f9843h, this.f9844i, composer, this.f9845j | 1, this.f9846k);
    }
}
