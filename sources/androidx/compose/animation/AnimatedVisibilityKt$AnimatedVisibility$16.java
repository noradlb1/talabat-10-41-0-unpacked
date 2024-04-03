package androidx.compose.animation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$16 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f1159g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1160h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$16(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(3);
        this.f1159g = function2;
        this.f1160h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        if ((i11 & 81) != 16 || !composer.getSkipping()) {
            this.f1159g.invoke(composer, Integer.valueOf((this.f1160h >> 15) & 14));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
