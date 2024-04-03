package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CheckboxKt$TriStateCheckbox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f6748g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6749h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6750i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6751j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CheckboxColors f6752k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6753l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f6754m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6755n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$TriStateCheckbox$2(ToggleableState toggleableState, Function0<Unit> function0, Modifier modifier, boolean z11, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f6748g = toggleableState;
        this.f6749h = function0;
        this.f6750i = modifier;
        this.f6751j = z11;
        this.f6752k = checkboxColors;
        this.f6753l = mutableInteractionSource;
        this.f6754m = i11;
        this.f6755n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxKt.TriStateCheckbox(this.f6748g, this.f6749h, this.f6750i, this.f6751j, this.f6752k, this.f6753l, composer, this.f6754m | 1, this.f6755n);
    }
}
