package androidx.compose.animation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityScope$animateEnterExit$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnimatedVisibilityScope f1206g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1207h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1208i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f1209j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityScope$animateEnterExit$2(AnimatedVisibilityScope animatedVisibilityScope, EnterTransition enterTransition, ExitTransition exitTransition, String str) {
        super(3);
        this.f1206g = animatedVisibilityScope;
        this.f1207h = enterTransition;
        this.f1208i = exitTransition;
        this.f1209j = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1840112047);
        Modifier then = modifier.then(EnterExitTransitionKt.createModifier(this.f1206g.getTransition(), this.f1207h, this.f1208i, this.f1209j, composer, 0));
        composer.endReplaceableGroup();
        return then;
    }
}
