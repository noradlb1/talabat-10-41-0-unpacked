package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ButtonKt$Button$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4254g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4255h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4256i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4257j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ButtonElevation f4258k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f4259l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f4260m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ButtonColors f4261n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f4262o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4263p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4264q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f4265r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$Button$3(Function0<Unit> function0, Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4254g = function0;
        this.f4255h = modifier;
        this.f4256i = z11;
        this.f4257j = mutableInteractionSource;
        this.f4258k = buttonElevation;
        this.f4259l = shape;
        this.f4260m = borderStroke;
        this.f4261n = buttonColors;
        this.f4262o = paddingValues;
        this.f4263p = function3;
        this.f4264q = i11;
        this.f4265r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonKt.Button(this.f4254g, this.f4255h, this.f4256i, this.f4257j, this.f4258k, this.f4259l, this.f4260m, this.f4261n, this.f4262o, this.f4263p, composer, this.f4264q | 1, this.f4265r);
    }
}
