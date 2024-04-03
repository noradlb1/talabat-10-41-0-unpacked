package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
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
public final class CardKt$OutlinedCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6708g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f6709h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CardColors f6710i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CardElevation f6711j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6712k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6713l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f6714m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6715n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardKt$OutlinedCard$1(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6708g = modifier;
        this.f6709h = shape;
        this.f6710i = cardColors;
        this.f6711j = cardElevation;
        this.f6712k = borderStroke;
        this.f6713l = function3;
        this.f6714m = i11;
        this.f6715n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CardKt.OutlinedCard(this.f6708g, this.f6709h, this.f6710i, this.f6711j, this.f6712k, this.f6713l, composer, this.f6714m | 1, this.f6715n);
    }
}
