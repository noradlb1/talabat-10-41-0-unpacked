package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ActivityResultRegistryKt$rememberLauncherForActivityResult$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ ActivityResultRegistry $activityResultRegistry;
    final /* synthetic */ ActivityResultContract<I, O> $contract;
    final /* synthetic */ State<Function1<O, Unit>> $currentOnResult;
    final /* synthetic */ String $key;
    final /* synthetic */ ActivityResultLauncherHolder<I> $realLauncher;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityResultRegistryKt$rememberLauncherForActivityResult$1(ActivityResultLauncherHolder<I> activityResultLauncherHolder, ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract<I, O> activityResultContract, State<? extends Function1<? super O, Unit>> state) {
        super(1);
        this.$realLauncher = activityResultLauncherHolder;
        this.$activityResultRegistry = activityResultRegistry;
        this.$key = str;
        this.$contract = activityResultContract;
        this.$currentOnResult = state;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m3invoke$lambda0(State state, Object obj) {
        Intrinsics.checkNotNullParameter(state, "$currentOnResult");
        ((Function1) state.getValue()).invoke(obj);
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.$realLauncher.setLauncher(this.$activityResultRegistry.register(this.$key, this.$contract, new a(this.$currentOnResult)));
        return new ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1(this.$realLauncher);
    }
}
