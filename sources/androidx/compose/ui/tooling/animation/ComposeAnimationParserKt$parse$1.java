package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"androidx/compose/ui/tooling/animation/ComposeAnimationParserKt$parse$1", "Landroidx/compose/animation/tooling/ComposeAnimation;", "animationObject", "", "getAnimationObject", "()Ljava/lang/Object;", "label", "", "getLabel", "()Ljava/lang/String;", "states", "", "getStates", "()Ljava/util/Set;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComposeAnimationParserKt$parse$1 implements ComposeAnimation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Transition<Object> f10277a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set<Object> f10278b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f10279c;

    public ComposeAnimationParserKt$parse$1(Transition<Object> transition, Set<? extends Object> set, String str) {
        this.f10277a = transition;
        this.f10278b = set;
        this.f10279c = str;
    }

    @NotNull
    public Object getAnimationObject() {
        return this.f10277a;
    }

    @Nullable
    public String getLabel() {
        return this.f10279c;
    }

    @NotNull
    public Set<Object> getStates() {
        return this.f10278b;
    }

    @NotNull
    public ComposeAnimationType getType() {
        return ComposeAnimationType.TRANSITION_ANIMATION;
    }
}
