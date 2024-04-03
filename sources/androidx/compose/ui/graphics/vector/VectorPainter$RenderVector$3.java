package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorPainter$RenderVector$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VectorPainter f9731g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f9732h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f9733i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f9734j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function4<Float, Float, Composer, Integer, Unit> f9735k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f9736l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorPainter$RenderVector$3(VectorPainter vectorPainter, String str, float f11, float f12, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, int i11) {
        super(2);
        this.f9731g = vectorPainter;
        this.f9732h = str;
        this.f9733i = f11;
        this.f9734j = f12;
        this.f9735k = function4;
        this.f9736l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f9731g.RenderVector$ui_release(this.f9732h, this.f9733i, this.f9734j, this.f9735k, composer, this.f9736l | 1);
    }
}
