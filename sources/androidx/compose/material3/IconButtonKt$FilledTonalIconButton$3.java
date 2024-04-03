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
public final class IconButtonKt$FilledTonalIconButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7154g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7155h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7156i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f7157j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ IconButtonColors f7158k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7159l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7160m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7161n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7162o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$FilledTonalIconButton$3(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7154g = function0;
        this.f7155h = modifier;
        this.f7156i = z11;
        this.f7157j = shape;
        this.f7158k = iconButtonColors;
        this.f7159l = mutableInteractionSource;
        this.f7160m = function2;
        this.f7161n = i11;
        this.f7162o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.FilledTonalIconButton(this.f7154g, this.f7155h, this.f7156i, this.f7157j, this.f7158k, this.f7159l, this.f7160m, composer, this.f7161n | 1, this.f7162o);
    }
}
