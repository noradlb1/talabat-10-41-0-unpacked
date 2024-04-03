package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4553g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f4554h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4555i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit> f4556j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4557k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4558l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$6(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4553g = z11;
        this.f4554h = function1;
        this.f4555i = modifier;
        this.f4556j = function3;
        this.f4557k = i11;
        this.f4558l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ExposedDropdownMenuKt.ExposedDropdownMenuBox(this.f4553g, this.f4554h, this.f4555i, this.f4556j, composer, this.f4557k | 1, this.f4558l);
    }
}
