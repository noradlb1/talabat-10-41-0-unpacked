package androidx.navigation;

import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.ActivityNavigator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"ActivityNavigatorExtras", "Landroidx/navigation/ActivityNavigator$Extras;", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "flags", "", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActivityNavigatorExtrasKt {
    @NotNull
    public static final ActivityNavigator.Extras ActivityNavigatorExtras(@Nullable ActivityOptionsCompat activityOptionsCompat, int i11) {
        ActivityNavigator.Extras.Builder builder = new ActivityNavigator.Extras.Builder();
        if (activityOptionsCompat != null) {
            builder.setActivityOptions(activityOptionsCompat);
        }
        builder.addFlags(i11);
        return builder.build();
    }

    public static /* synthetic */ ActivityNavigator.Extras ActivityNavigatorExtras$default(ActivityOptionsCompat activityOptionsCompat, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            activityOptionsCompat = null;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return ActivityNavigatorExtras(activityOptionsCompat, i11);
    }
}
