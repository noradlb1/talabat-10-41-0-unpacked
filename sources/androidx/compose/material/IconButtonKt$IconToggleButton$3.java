package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class IconButtonKt$IconToggleButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4612g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f4613h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4614i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4615j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4616k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4617l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4618m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4619n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconButtonKt$IconToggleButton$3(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4612g = z11;
        this.f4613h = function1;
        this.f4614i = modifier;
        this.f4615j = z12;
        this.f4616k = mutableInteractionSource;
        this.f4617l = function2;
        this.f4618m = i11;
        this.f4619n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconButtonKt.IconToggleButton(this.f4612g, this.f4613h, this.f4614i, this.f4615j, this.f4616k, this.f4617l, composer, this.f4618m | 1, this.f4619n);
    }
}
