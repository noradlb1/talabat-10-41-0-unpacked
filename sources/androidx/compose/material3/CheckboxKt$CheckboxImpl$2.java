package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CheckboxKt$CheckboxImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6743g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f6744h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6745i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CheckboxColors f6746j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6747k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$CheckboxImpl$2(boolean z11, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, int i11) {
        super(2);
        this.f6743g = z11;
        this.f6744h = toggleableState;
        this.f6745i = modifier;
        this.f6746j = checkboxColors;
        this.f6747k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxKt.CheckboxImpl(this.f6743g, this.f6744h, this.f6745i, this.f6746j, composer, this.f6747k | 1);
    }
}
