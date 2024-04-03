package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CardKt$ElevatedCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6691g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f6692h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CardColors f6693i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CardElevation f6694j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6695k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f6696l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f6697m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardKt$ElevatedCard$1(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6691g = modifier;
        this.f6692h = shape;
        this.f6693i = cardColors;
        this.f6694j = cardElevation;
        this.f6695k = function3;
        this.f6696l = i11;
        this.f6697m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CardKt.ElevatedCard(this.f6691g, this.f6692h, this.f6693i, this.f6694j, this.f6695k, composer, this.f6696l | 1, this.f6697m);
    }
}
