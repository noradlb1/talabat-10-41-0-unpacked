package androidx.compose.material3;

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
public final class IconButtonKt$FilledIconToggleButton$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7142g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f7143h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7144i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7145j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f7146k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ IconToggleButtonColors f7147l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7148m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7149n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7150o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7151p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$FilledIconToggleButton$4(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7142g = z11;
        this.f7143h = function1;
        this.f7144i = modifier;
        this.f7145j = z12;
        this.f7146k = shape;
        this.f7147l = iconToggleButtonColors;
        this.f7148m = mutableInteractionSource;
        this.f7149n = function2;
        this.f7150o = i11;
        this.f7151p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.FilledIconToggleButton(this.f7142g, this.f7143h, this.f7144i, this.f7145j, this.f7146k, this.f7147l, this.f7148m, this.f7149n, composer, this.f7150o | 1, this.f7151p);
    }
}
