package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActivityResultRegistryKt {
    @NotNull
    @Composable
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(@NotNull ActivityResultContract<I, O> activityResultContract, @NotNull Function1<? super O, Unit> function1, @Nullable Composer composer, int i11) {
        ActivityResultContract<I, O> activityResultContract2 = activityResultContract;
        Function1<? super O, Unit> function12 = function1;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(activityResultContract, "contract");
        Intrinsics.checkNotNullParameter(function12, "onResult");
        composer2.startReplaceableGroup(-1408504823);
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(activityResultContract, composer2, 8);
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function12, composer2, (i11 >> 3) & 14);
        Object rememberSaveable = RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1.INSTANCE, composer, 8, 6);
        Intrinsics.checkNotNullExpressionValue(rememberSaveable, "rememberSaveable { UUID.randomUUID().toString() }");
        String str = (String) rememberSaveable;
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer2, 6);
        if (current != null) {
            ActivityResultRegistry activityResultRegistry = current.getActivityResultRegistry();
            Intrinsics.checkNotNullExpressionValue(activityResultRegistry, "checkNotNull(LocalActivi… }.activityResultRegistry");
            composer2.startReplaceableGroup(-3687241);
            Object rememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new ActivityResultLauncherHolder();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) rememberedValue;
            composer2.startReplaceableGroup(-3687241);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new ManagedActivityResultLauncher(activityResultLauncherHolder, rememberUpdatedState);
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            ManagedActivityResultLauncher<I, O> managedActivityResultLauncher = (ManagedActivityResultLauncher) rememberedValue2;
            EffectsKt.DisposableEffect(activityResultRegistry, str, activityResultContract, new ActivityResultRegistryKt$rememberLauncherForActivityResult$1(activityResultLauncherHolder, activityResultRegistry, str, activityResultContract, rememberUpdatedState2), composer, 520);
            composer.endReplaceableGroup();
            return managedActivityResultLauncher;
        }
        throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
    }
}
