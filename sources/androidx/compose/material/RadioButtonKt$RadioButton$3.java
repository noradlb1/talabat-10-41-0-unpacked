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
public final class RadioButtonKt$RadioButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4976g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4977h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4978i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4979j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4980k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ RadioButtonColors f4981l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4982m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4983n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioButtonKt$RadioButton$3(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, int i11, int i12) {
        super(2);
        this.f4976g = z11;
        this.f4977h = function0;
        this.f4978i = modifier;
        this.f4979j = z12;
        this.f4980k = mutableInteractionSource;
        this.f4981l = radioButtonColors;
        this.f4982m = i11;
        this.f4983n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RadioButtonKt.RadioButton(this.f4976g, this.f4977h, this.f4978i, this.f4979j, this.f4980k, this.f4981l, composer, this.f4982m | 1, this.f4983n);
    }
}
