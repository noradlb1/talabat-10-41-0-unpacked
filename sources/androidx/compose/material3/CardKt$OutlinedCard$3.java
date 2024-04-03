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
public final class CardKt$OutlinedCard$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6716g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6717h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6718i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6719j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CardColors f6720k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CardElevation f6721l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6722m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6723n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6724o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6725p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6726q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardKt$OutlinedCard$3(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6716g = function0;
        this.f6717h = modifier;
        this.f6718i = z11;
        this.f6719j = shape;
        this.f6720k = cardColors;
        this.f6721l = cardElevation;
        this.f6722m = borderStroke;
        this.f6723n = mutableInteractionSource;
        this.f6724o = function3;
        this.f6725p = i11;
        this.f6726q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CardKt.OutlinedCard(this.f6716g, this.f6717h, this.f6718i, this.f6719j, this.f6720k, this.f6721l, this.f6722m, this.f6723n, this.f6724o, composer, this.f6725p | 1, this.f6726q);
    }
}
