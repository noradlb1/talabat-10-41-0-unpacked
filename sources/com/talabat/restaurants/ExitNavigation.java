package com.talabat.restaurants;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.home.HomeScreenActivity;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import io.reactivex.functions.Consumer;

class ExitNavigation implements Consumer<Activity> {
    private boolean isFromPickup(Activity activity) {
        return TalabatCommonNavigationActions.EXTRA_FROM_TOGGLE.equals(activity.getIntent().getStringExtra("source"));
    }

    @VisibleForTesting
    public boolean validateDeeplinkQuery(String str) {
        return str != null && !str.isEmpty();
    }

    public void accept(Activity activity) {
        if (isFromPickup(activity)) {
            Navigator.Companion.navigate((Context) activity, new NavigatorModel("talabat.action.homeScreen"));
            activity.finish();
            return;
        }
        Intent intent = new Intent(activity, HomeScreenActivity.class);
        if (NavUtils.shouldUpRecreateTask(activity, intent) || validateDeeplinkQuery(GlobalDataModel.getDeepLinksQuery())) {
            TaskStackBuilder.create(activity).addNextIntent(intent).startActivities();
            activity.finish();
            return;
        }
        NavUtils.navigateUpTo(activity, intent);
    }
}
