package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CheckboxKt$CheckboxImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4282g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f4283h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4284i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CheckboxColors f4285j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4286k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$CheckboxImpl$2(boolean z11, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, int i11) {
        super(2);
        this.f4282g = z11;
        this.f4283h = toggleableState;
        this.f4284i = modifier;
        this.f4285j = checkboxColors;
        this.f4286k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxKt.CheckboxImpl(this.f4282g, this.f4283h, this.f4284i, this.f4285j, composer, this.f4286k | 1);
    }
}
