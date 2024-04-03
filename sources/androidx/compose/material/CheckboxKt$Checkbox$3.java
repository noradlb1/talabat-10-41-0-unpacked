package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CheckboxKt$Checkbox$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4268g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f4269h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4270i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4271j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4272k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CheckboxColors f4273l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4274m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4275n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$Checkbox$3(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i11, int i12) {
        super(2);
        this.f4268g = z11;
        this.f4269h = function1;
        this.f4270i = modifier;
        this.f4271j = z12;
        this.f4272k = mutableInteractionSource;
        this.f4273l = checkboxColors;
        this.f4274m = i11;
        this.f4275n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxKt.Checkbox(this.f4268g, this.f4269h, this.f4270i, this.f4271j, this.f4272k, this.f4273l, composer, this.f4274m | 1, this.f4275n);
    }
}
