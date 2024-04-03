package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackHandlerKt$BackHandler$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onBack;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackHandlerKt$BackHandler$3(boolean z11, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.$enabled = z11;
        this.$onBack = function0;
        this.$$changed = i11;
        this.$$default = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BackHandlerKt.BackHandler(this.$enabled, this.$onBack, composer, this.$$changed | 1, this.$$default);
    }
}
