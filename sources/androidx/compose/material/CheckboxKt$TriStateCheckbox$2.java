package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CheckboxKt$TriStateCheckbox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f4287g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4288h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4289i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4290j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4291k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CheckboxColors f4292l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4293m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4294n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$TriStateCheckbox$2(ToggleableState toggleableState, Function0<Unit> function0, Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i11, int i12) {
        super(2);
        this.f4287g = toggleableState;
        this.f4288h = function0;
        this.f4289i = modifier;
        this.f4290j = z11;
        this.f4291k = mutableInteractionSource;
        this.f4292l = checkboxColors;
        this.f4293m = i11;
        this.f4294n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxKt.TriStateCheckbox(this.f4287g, this.f4288h, this.f4289i, this.f4290j, this.f4291k, this.f4292l, composer, this.f4293m | 1, this.f4294n);
    }
}
