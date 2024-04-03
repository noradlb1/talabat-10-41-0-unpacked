package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwitchKt$Switch$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8479g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f8480h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f8481i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8482j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8483k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SwitchColors f8484l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8485m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f8486n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f8487o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$5(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z12, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f8479g = z11;
        this.f8480h = function1;
        this.f8481i = modifier;
        this.f8482j = function2;
        this.f8483k = z12;
        this.f8484l = switchColors;
        this.f8485m = mutableInteractionSource;
        this.f8486n = i11;
        this.f8487o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SwitchKt.Switch(this.f8479g, this.f8480h, this.f8481i, this.f8482j, this.f8483k, this.f8484l, this.f8485m, composer, this.f8486n | 1, this.f8487o);
    }
}
