package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults$TrailingIcon$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExposedDropdownMenuDefaults f4528g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f4529h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4530i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4531j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4532k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuDefaults$TrailingIcon$4(ExposedDropdownMenuDefaults exposedDropdownMenuDefaults, boolean z11, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f4528g = exposedDropdownMenuDefaults;
        this.f4529h = z11;
        this.f4530i = function0;
        this.f4531j = i11;
        this.f4532k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f4528g.TrailingIcon(this.f4529h, this.f4530i, composer, this.f4531j | 1, this.f4532k);
    }
}
