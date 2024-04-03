package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CardKt$ElevatedCard$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6698g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6699h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6700i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6701j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CardColors f6702k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CardElevation f6703l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6704m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6705n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6706o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6707p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardKt$ElevatedCard$3(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6698g = function0;
        this.f6699h = modifier;
        this.f6700i = z11;
        this.f6701j = shape;
        this.f6702k = cardColors;
        this.f6703l = cardElevation;
        this.f6704m = mutableInteractionSource;
        this.f6705n = function3;
        this.f6706o = i11;
        this.f6707p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CardKt.ElevatedCard(this.f6698g, this.f6699h, this.f6700i, this.f6701j, this.f6702k, this.f6703l, this.f6704m, this.f6705n, composer, this.f6706o | 1, this.f6707p);
    }
}
