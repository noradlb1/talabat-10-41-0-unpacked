package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LookaheadLayoutKt$LookaheadLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<LookaheadLayoutScope, Composer, Integer, Unit> f9860g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f9861h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MeasurePolicy f9862i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f9863j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f9864k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookaheadLayoutKt$LookaheadLayout$3(Function3<? super LookaheadLayoutScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, MeasurePolicy measurePolicy, int i11, int i12) {
        super(2);
        this.f9860g = function3;
        this.f9861h = modifier;
        this.f9862i = measurePolicy;
        this.f9863j = i11;
        this.f9864k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LookaheadLayoutKt.LookaheadLayout(this.f9860g, this.f9861h, this.f9862i, composer, this.f9863j | 1, this.f9864k);
    }
}
