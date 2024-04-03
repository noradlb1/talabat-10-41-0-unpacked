package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
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
public final class CardKt$Card$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6680g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6681h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6682i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6683j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CardColors f6684k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CardElevation f6685l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6686m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6687n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6688o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6689p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6690q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardKt$Card$5(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6680g = function0;
        this.f6681h = modifier;
        this.f6682i = z11;
        this.f6683j = shape;
        this.f6684k = cardColors;
        this.f6685l = cardElevation;
        this.f6686m = borderStroke;
        this.f6687n = mutableInteractionSource;
        this.f6688o = function3;
        this.f6689p = i11;
        this.f6690q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CardKt.Card(this.f6680g, this.f6681h, this.f6682i, this.f6683j, this.f6684k, this.f6685l, this.f6686m, this.f6687n, this.f6688o, composer, this.f6689p | 1, this.f6690q);
    }
}
