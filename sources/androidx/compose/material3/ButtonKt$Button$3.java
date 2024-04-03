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
public final class ButtonKt$Button$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6598g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6599h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6600i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6601j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ButtonColors f6602k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ButtonElevation f6603l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6604m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6605n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6606o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6607p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6608q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6609r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$Button$3(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6598g = function0;
        this.f6599h = modifier;
        this.f6600i = z11;
        this.f6601j = shape;
        this.f6602k = buttonColors;
        this.f6603l = buttonElevation;
        this.f6604m = borderStroke;
        this.f6605n = paddingValues;
        this.f6606o = mutableInteractionSource;
        this.f6607p = function3;
        this.f6608q = i11;
        this.f6609r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonKt.Button(this.f6598g, this.f6599h, this.f6600i, this.f6601j, this.f6602k, this.f6603l, this.f6604m, this.f6605n, this.f6606o, this.f6607p, composer, this.f6608q | 1, this.f6609r);
    }
}
