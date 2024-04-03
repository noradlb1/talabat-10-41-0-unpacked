package com.talabat.feature.rating.presentation.ui;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u0004*\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"navigateSafe", "", "Landroidx/navigation/NavController;", "resId", "", "args", "Landroid/os/Bundle;", "orEmpty", "default", "(Ljava/lang/Integer;I)I", "com_talabat_feature_rating_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavControllerExtensionKt {
    public static final void navigateSafe(@NotNull NavController navController, @IdRes int i11, @Nullable Bundle bundle) {
        Integer num;
        NavGraph navGraph;
        NavAction action;
        Intrinsics.checkNotNullParameter(navController, "<this>");
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination == null || (action = currentDestination.getAction(i11)) == null) {
            num = null;
        } else {
            num = Integer.valueOf(action.getDestinationId());
        }
        int orEmpty$default = orEmpty$default(num, 0, 1, (Object) null);
        NavDestination currentDestination2 = navController.getCurrentDestination();
        if (currentDestination2 != null) {
            if (currentDestination2 instanceof NavGraph) {
                navGraph = (NavGraph) currentDestination2;
            } else {
                navGraph = currentDestination2.getParent();
            }
            if (orEmpty$default != 0 && navGraph != null && navGraph.findNode(orEmpty$default) != null) {
                navController.navigate(i11, bundle);
            }
        }
    }

    public static /* synthetic */ void navigateSafe$default(NavController navController, int i11, Bundle bundle, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            bundle = null;
        }
        navigateSafe(navController, i11, bundle);
    }

    public static final int orEmpty(@Nullable Integer num, int i11) {
        return num != null ? num.intValue() : i11;
    }

    public static /* synthetic */ int orEmpty$default(Integer num, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return orEmpty(num, i11);
    }
}
