package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldTransitionScope$Transition$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldTransitionScope f8954g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InputPhase f8955h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f8956i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f8957j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<InputPhase, Composer, Integer, Color> f8958k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f8959l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function6<Float, Color, Color, Float, Composer, Integer, Unit> f8960m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f8961n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldTransitionScope$Transition$1(TextFieldTransitionScope textFieldTransitionScope, InputPhase inputPhase, long j11, long j12, Function3<? super InputPhase, ? super Composer, ? super Integer, Color> function3, boolean z11, Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> function6, int i11) {
        super(2);
        this.f8954g = textFieldTransitionScope;
        this.f8955h = inputPhase;
        this.f8956i = j11;
        this.f8957j = j12;
        this.f8958k = function3;
        this.f8959l = z11;
        this.f8960m = function6;
        this.f8961n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f8954g.m1936TransitionDTcfvLk(this.f8955h, this.f8956i, this.f8957j, this.f8958k, this.f8959l, this.f8960m, composer, this.f8961n | 1);
    }
}
