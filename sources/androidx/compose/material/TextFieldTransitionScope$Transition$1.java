package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldTransitionScope$Transition$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldTransitionScope f6101g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InputPhase f6102h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6103i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f6104j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<InputPhase, Composer, Integer, Color> f6105k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f6106l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function6<Float, Color, Color, Float, Composer, Integer, Unit> f6107m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6108n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldTransitionScope$Transition$1(TextFieldTransitionScope textFieldTransitionScope, InputPhase inputPhase, long j11, long j12, Function3<? super InputPhase, ? super Composer, ? super Integer, Color> function3, boolean z11, Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> function6, int i11) {
        super(2);
        this.f6101g = textFieldTransitionScope;
        this.f6102h = inputPhase;
        this.f6103i = j11;
        this.f6104j = j12;
        this.f6105k = function3;
        this.f6106l = z11;
        this.f6107m = function6;
        this.f6108n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f6101g.m1459TransitionDTcfvLk(this.f6102h, this.f6103i, this.f6104j, this.f6105k, this.f6106l, this.f6107m, composer, this.f6108n | 1);
    }
}
