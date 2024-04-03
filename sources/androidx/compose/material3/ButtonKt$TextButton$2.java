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
public final class ButtonKt$TextButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6646g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6647h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6648i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6649j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ButtonColors f6650k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ButtonElevation f6651l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6652m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6653n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6654o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6655p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6656q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6657r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$TextButton$2(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6646g = function0;
        this.f6647h = modifier;
        this.f6648i = z11;
        this.f6649j = shape;
        this.f6650k = buttonColors;
        this.f6651l = buttonElevation;
        this.f6652m = borderStroke;
        this.f6653n = paddingValues;
        this.f6654o = mutableInteractionSource;
        this.f6655p = function3;
        this.f6656q = i11;
        this.f6657r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonKt.TextButton(this.f6646g, this.f6647h, this.f6648i, this.f6649j, this.f6650k, this.f6651l, this.f6652m, this.f6653n, this.f6654o, this.f6655p, composer, this.f6656q | 1, this.f6657r);
    }
}
