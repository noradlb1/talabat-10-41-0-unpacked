package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$SliderThumb$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f5233g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5234h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5235i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5236j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5237k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f5238l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f5239m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f5240n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderThumb$2(BoxScope boxScope, Modifier modifier, float f11, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z11, float f12, int i11) {
        super(2);
        this.f5233g = boxScope;
        this.f5234h = modifier;
        this.f5235i = f11;
        this.f5236j = mutableInteractionSource;
        this.f5237k = sliderColors;
        this.f5238l = z11;
        this.f5239m = f12;
        this.f5240n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.m1358SliderThumbPcYyNuk(this.f5233g, this.f5234h, this.f5235i, this.f5236j, this.f5237k, this.f5238l, this.f5239m, composer, this.f5240n | 1);
    }
}
