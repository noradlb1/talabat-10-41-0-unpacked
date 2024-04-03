package com.talabat.restaurants;

import android.app.Application;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/EventTrackerInitializer;", "Lio/reactivex/functions/Consumer;", "Lcom/talabat/restaurants/RestaurantsListScreenRefactor;", "()V", "accept", "", "activity", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventTrackerInitializer implements Consumer<RestaurantsListScreenRefactor> {
    public void accept(@NotNull RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        Intrinsics.checkNotNullParameter(restaurantsListScreenRefactor, "activity");
        Application application = restaurantsListScreenRefactor.getApplication();
        if (application != null) {
            restaurantsListScreenRefactor.J = ((TrackingCoreLibApi) ((ApiContainer) application).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
            restaurantsListScreenRefactor.K = new UserSettingsTracker((Function0) null, 1, (DefaultConstructorMarker) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }
}
