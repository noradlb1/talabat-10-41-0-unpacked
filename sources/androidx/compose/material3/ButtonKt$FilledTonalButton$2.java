package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
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
public final class ButtonKt$FilledTonalButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6622g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6623h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6624i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6625j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ButtonColors f6626k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ButtonElevation f6627l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6628m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6629n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6630o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6631p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6632q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6633r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$FilledTonalButton$2(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6622g = function0;
        this.f6623h = modifier;
        this.f6624i = z11;
        this.f6625j = shape;
        this.f6626k = buttonColors;
        this.f6627l = buttonElevation;
        this.f6628m = borderStroke;
        this.f6629n = paddingValues;
        this.f6630o = mutableInteractionSource;
        this.f6631p = function3;
        this.f6632q = i11;
        this.f6633r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonKt.FilledTonalButton(this.f6622g, this.f6623h, this.f6624i, this.f6625j, this.f6626k, this.f6627l, this.f6628m, this.f6629n, this.f6630o, this.f6631p, composer, this.f6632q | 1, this.f6633r);
    }
}
