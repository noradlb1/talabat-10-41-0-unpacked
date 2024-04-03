package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
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
public final class IconButtonKt$OutlinedIconButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7194g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7195h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7196i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f7197j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ IconButtonColors f7198k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f7199l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7200m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7201n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7202o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7203p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$OutlinedIconButton$3(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, IconButtonColors iconButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7194g = function0;
        this.f7195h = modifier;
        this.f7196i = z11;
        this.f7197j = shape;
        this.f7198k = iconButtonColors;
        this.f7199l = borderStroke;
        this.f7200m = mutableInteractionSource;
        this.f7201n = function2;
        this.f7202o = i11;
        this.f7203p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.OutlinedIconButton(this.f7194g, this.f7195h, this.f7196i, this.f7197j, this.f7198k, this.f7199l, this.f7200m, this.f7201n, composer, this.f7202o | 1, this.f7203p);
    }
}
