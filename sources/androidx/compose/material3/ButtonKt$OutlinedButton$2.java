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
public final class ButtonKt$OutlinedButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6634g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6635h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6636i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6637j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ButtonColors f6638k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ButtonElevation f6639l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6640m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6641n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6642o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6643p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6644q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6645r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$OutlinedButton$2(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6634g = function0;
        this.f6635h = modifier;
        this.f6636i = z11;
        this.f6637j = shape;
        this.f6638k = buttonColors;
        this.f6639l = buttonElevation;
        this.f6640m = borderStroke;
        this.f6641n = paddingValues;
        this.f6642o = mutableInteractionSource;
        this.f6643p = function3;
        this.f6644q = i11;
        this.f6645r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonKt.OutlinedButton(this.f6634g, this.f6635h, this.f6636i, this.f6637j, this.f6638k, this.f6639l, this.f6640m, this.f6641n, this.f6642o, this.f6643p, composer, this.f6644q | 1, this.f6645r);
    }
}
