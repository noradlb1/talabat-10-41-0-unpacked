package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuDefaults$TrailingIcon$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExposedDropdownMenuDefaults f6990g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f6991h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f6992i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuDefaults$TrailingIcon$1(ExposedDropdownMenuDefaults exposedDropdownMenuDefaults, boolean z11, int i11) {
        super(2);
        this.f6990g = exposedDropdownMenuDefaults;
        this.f6991h = z11;
        this.f6992i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f6990g.TrailingIcon(this.f6991h, composer, this.f6992i | 1);
    }
}
