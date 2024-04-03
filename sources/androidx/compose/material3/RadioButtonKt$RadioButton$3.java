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
public final class RadioButtonKt$RadioButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7826g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7827h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7828i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7829j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ RadioButtonColors f7830k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7831l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7832m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7833n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioButtonKt$RadioButton$3(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f7826g = z11;
        this.f7827h = function0;
        this.f7828i = modifier;
        this.f7829j = z12;
        this.f7830k = radioButtonColors;
        this.f7831l = mutableInteractionSource;
        this.f7832m = i11;
        this.f7833n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RadioButtonKt.RadioButton(this.f7826g, this.f7827h, this.f7828i, this.f7829j, this.f7830k, this.f7831l, composer, this.f7832m | 1, this.f7833n);
    }
}
