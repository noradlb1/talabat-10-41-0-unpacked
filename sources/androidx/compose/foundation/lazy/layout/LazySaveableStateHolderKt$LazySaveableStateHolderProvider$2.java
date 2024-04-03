package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<SaveableStateHolder, Composer, Integer, Unit> f3075g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3076h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2(Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f3075g = function3;
        this.f3076h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazySaveableStateHolderKt.LazySaveableStateHolderProvider(this.f3075g, composer, this.f3076h | 1);
    }
}
