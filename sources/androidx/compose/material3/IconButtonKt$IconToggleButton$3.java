package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IconButtonKt$IconToggleButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7183g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f7184h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7185i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7186j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ IconToggleButtonColors f7187k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7188l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7189m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7190n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7191o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$IconToggleButton$3(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7183g = z11;
        this.f7184h = function1;
        this.f7185i = modifier;
        this.f7186j = z12;
        this.f7187k = iconToggleButtonColors;
        this.f7188l = mutableInteractionSource;
        this.f7189m = function2;
        this.f7190n = i11;
        this.f7191o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.IconToggleButton(this.f7183g, this.f7184h, this.f7185i, this.f7186j, this.f7187k, this.f7188l, this.f7189m, composer, this.f7190n | 1, this.f7191o);
    }
}
