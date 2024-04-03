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
public final class IconButtonKt$FilledTonalIconToggleButton$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7165g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f7166h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7167i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7168j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f7169k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ IconToggleButtonColors f7170l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7171m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7172n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7173o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7174p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$FilledTonalIconToggleButton$4(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7165g = z11;
        this.f7166h = function1;
        this.f7167i = modifier;
        this.f7168j = z12;
        this.f7169k = shape;
        this.f7170l = iconToggleButtonColors;
        this.f7171m = mutableInteractionSource;
        this.f7172n = function2;
        this.f7173o = i11;
        this.f7174p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.FilledTonalIconToggleButton(this.f7165g, this.f7166h, this.f7167i, this.f7168j, this.f7169k, this.f7170l, this.f7171m, this.f7172n, composer, this.f7173o | 1, this.f7174p);
    }
}
