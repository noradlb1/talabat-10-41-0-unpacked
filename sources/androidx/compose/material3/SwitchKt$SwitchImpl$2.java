package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwitchKt$SwitchImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f8491g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8492h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8493i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwitchColors f8494j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f8495k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8496l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8497m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Shape f8498n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f8499o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f8500p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ float f8501q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8502r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f8503s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$SwitchImpl$2(BoxScope boxScope, boolean z11, boolean z12, SwitchColors switchColors, State<Float> state, Function2<? super Composer, ? super Integer, Unit> function2, InteractionSource interactionSource, Shape shape, float f11, float f12, float f13, int i11, int i12) {
        super(2);
        this.f8491g = boxScope;
        this.f8492h = z11;
        this.f8493i = z12;
        this.f8494j = switchColors;
        this.f8495k = state;
        this.f8496l = function2;
        this.f8497m = interactionSource;
        this.f8498n = shape;
        this.f8499o = f11;
        this.f8500p = f12;
        this.f8501q = f13;
        this.f8502r = i11;
        this.f8503s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SwitchKt.m1875SwitchImpl0DmnUew(this.f8491g, this.f8492h, this.f8493i, this.f8494j, this.f8495k, this.f8496l, this.f8497m, this.f8498n, this.f8499o, this.f8500p, this.f8501q, composer, this.f8502r | 1, this.f8503s);
    }
}
