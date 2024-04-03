package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$TempRangeSliderThumb$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f8096g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f8097h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> f8098i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8099j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$TempRangeSliderThumb$1(BoxScope boxScope, float f11, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f8096g = boxScope;
        this.f8097h = f11;
        this.f8098i = function3;
        this.f8099j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.m1816TempRangeSliderThumbrAjV9yQ(this.f8096g, this.f8097h, this.f8098i, composer, this.f8099j | 1);
    }
}
