package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IconButtonKt$FilledIconButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7131g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7132h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7133i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f7134j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ IconButtonColors f7135k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7136l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7137m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7138n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7139o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$FilledIconButton$3(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7131g = function0;
        this.f7132h = modifier;
        this.f7133i = z11;
        this.f7134j = shape;
        this.f7135k = iconButtonColors;
        this.f7136l = mutableInteractionSource;
        this.f7137m = function2;
        this.f7138n = i11;
        this.f7139o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.FilledIconButton(this.f7131g, this.f7132h, this.f7133i, this.f7134j, this.f7135k, this.f7136l, this.f7137m, composer, this.f7138n | 1, this.f7139o);
    }
}
