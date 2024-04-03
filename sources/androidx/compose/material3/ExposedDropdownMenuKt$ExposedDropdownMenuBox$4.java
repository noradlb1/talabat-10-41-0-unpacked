package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7005g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f7006h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7007i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit> f7008j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7009k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7010l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$4(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7005g = z11;
        this.f7006h = function1;
        this.f7007i = modifier;
        this.f7008j = function3;
        this.f7009k = i11;
        this.f7010l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ExposedDropdownMenuKt.ExposedDropdownMenuBox(this.f7005g, this.f7006h, this.f7007i, this.f7008j, composer, this.f7009k | 1, this.f7010l);
    }
}
