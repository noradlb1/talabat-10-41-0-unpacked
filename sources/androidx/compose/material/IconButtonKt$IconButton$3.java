package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class IconButtonKt$IconButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4605g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4606h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4607i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4608j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4609k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4610l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4611m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$IconButton$3(Function0<Unit> function0, Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4605g = function0;
        this.f4606h = modifier;
        this.f4607i = z11;
        this.f4608j = mutableInteractionSource;
        this.f4609k = function2;
        this.f4610l = i11;
        this.f4611m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.IconButton(this.f4605g, this.f4606h, this.f4607i, this.f4608j, this.f4609k, composer, this.f4610l | 1, this.f4611m);
    }
}
