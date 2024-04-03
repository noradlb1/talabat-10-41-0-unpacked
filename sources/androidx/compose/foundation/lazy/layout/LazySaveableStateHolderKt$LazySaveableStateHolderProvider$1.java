package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazySaveableStateHolder f3072g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<SaveableStateHolder, Composer, Integer, Unit> f3073h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3074i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1(LazySaveableStateHolder lazySaveableStateHolder, Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f3072g = lazySaveableStateHolder;
        this.f3073h = function3;
        this.f3074i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1863926504, i11, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider.<anonymous> (LazySaveableStateHolder.kt:48)");
            }
            this.f3072g.setWrappedHolder(SaveableStateHolderKt.rememberSaveableStateHolder(composer, 0));
            this.f3073h.invoke(this.f3072g, composer, Integer.valueOf(((this.f3074i << 3) & 112) | 8));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
