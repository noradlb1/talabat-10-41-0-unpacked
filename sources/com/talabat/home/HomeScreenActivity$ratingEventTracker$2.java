package com.talabat.home;

import android.app.Activity;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/rating/domain/EventTracker;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$ratingEventTracker$2 extends Lambda implements Function0<EventTracker> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60895g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$ratingEventTracker$2(HomeScreenActivity homeScreenActivity) {
        super(0);
        this.f60895g = homeScreenActivity;
    }

    @NotNull
    public final EventTracker invoke() {
        return ((RatingFeatureApi) AndroidComponentsKt.apiContainer((Activity) this.f60895g).getFeature(RatingFeatureApi.class)).getRatingEventTracker();
    }
}
