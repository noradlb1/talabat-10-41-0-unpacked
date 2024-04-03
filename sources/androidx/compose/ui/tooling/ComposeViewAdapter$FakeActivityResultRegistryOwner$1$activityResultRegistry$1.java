package androidx.compose.ui.tooling;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1", "Landroidx/activity/result/ActivityResultRegistry;", "onLaunch", "", "I", "O", "requestCode", "", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 extends ActivityResultRegistry {
    public <I, O> void onLaunch(int i11, @NotNull ActivityResultContract<I, O> activityResultContract, I i12, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics.checkNotNullParameter(activityResultContract, "contract");
        throw new IllegalStateException("Calling launch() is not supported in Preview");
    }
}
