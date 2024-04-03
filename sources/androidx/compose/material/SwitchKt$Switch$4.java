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
public final class SwitchKt$Switch$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5693g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f5694h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f5695i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5696j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5697k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SwitchColors f5698l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5699m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f5700n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$4(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, int i11, int i12) {
        super(2);
        this.f5693g = z11;
        this.f5694h = function1;
        this.f5695i = modifier;
        this.f5696j = z12;
        this.f5697k = mutableInteractionSource;
        this.f5698l = switchColors;
        this.f5699m = i11;
        this.f5700n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SwitchKt.Switch(this.f5693g, this.f5694h, this.f5695i, this.f5696j, this.f5697k, this.f5698l, composer, this.f5699m | 1, this.f5700n);
    }
}
