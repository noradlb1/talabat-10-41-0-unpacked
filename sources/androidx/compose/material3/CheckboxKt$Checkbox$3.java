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
public final class CheckboxKt$Checkbox$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6729g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f6730h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6731i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6732j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CheckboxColors f6733k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6734l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f6735m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6736n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$Checkbox$3(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f6729g = z11;
        this.f6730h = function1;
        this.f6731i = modifier;
        this.f6732j = z12;
        this.f6733k = checkboxColors;
        this.f6734l = mutableInteractionSource;
        this.f6735m = i11;
        this.f6736n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxKt.Checkbox(this.f6729g, this.f6730h, this.f6731i, this.f6732j, this.f6733k, this.f6734l, composer, this.f6735m | 1, this.f6736n);
    }
}
