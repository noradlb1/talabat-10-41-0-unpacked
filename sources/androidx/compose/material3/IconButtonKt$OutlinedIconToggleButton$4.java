package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IconButtonKt$OutlinedIconToggleButton$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7206g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f7207h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7208i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7209j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f7210k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ IconToggleButtonColors f7211l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f7212m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7213n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7214o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7215p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7216q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$OutlinedIconToggleButton$4(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, Shape shape, IconToggleButtonColors iconToggleButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7206g = z11;
        this.f7207h = function1;
        this.f7208i = modifier;
        this.f7209j = z12;
        this.f7210k = shape;
        this.f7211l = iconToggleButtonColors;
        this.f7212m = borderStroke;
        this.f7213n = mutableInteractionSource;
        this.f7214o = function2;
        this.f7215p = i11;
        this.f7216q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.OutlinedIconToggleButton(this.f7206g, this.f7207h, this.f7208i, this.f7209j, this.f7210k, this.f7211l, this.f7212m, this.f7213n, this.f7214o, composer, this.f7215p | 1, this.f7216q);
    }
}
