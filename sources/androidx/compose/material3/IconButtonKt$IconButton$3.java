package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IconButtonKt$IconButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7175g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7176h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7177i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ IconButtonColors f7178j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7179k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7180l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7181m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7182n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$IconButton$3(Function0<Unit> function0, Modifier modifier, boolean z11, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7175g = function0;
        this.f7176h = modifier;
        this.f7177i = z11;
        this.f7178j = iconButtonColors;
        this.f7179k = mutableInteractionSource;
        this.f7180l = function2;
        this.f7181m = i11;
        this.f7182n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.IconButton(this.f7175g, this.f7176h, this.f7177i, this.f7178j, this.f7179k, this.f7180l, composer, this.f7181m | 1, this.f7182n);
    }
}
