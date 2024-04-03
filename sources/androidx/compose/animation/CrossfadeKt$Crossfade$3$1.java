package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CrossfadeKt$Crossfade$3$1 extends Lambda implements Function1<T, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<T> f1221g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CrossfadeKt$Crossfade$3$1(Transition<T> transition) {
        super(1);
        this.f1221g = transition;
    }

    @NotNull
    public final Boolean invoke(T t11) {
        return Boolean.valueOf(!Intrinsics.areEqual((Object) t11, (Object) this.f1221g.getTargetState()));
    }
}
