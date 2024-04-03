package com.talabat.home;

import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.homescreen.utils.HomeScreenTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/homescreen/utils/HomeScreenTracker;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$homeScreenTracker$2 extends Lambda implements Function0<HomeScreenTracker> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60883g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$homeScreenTracker$2(HomeScreenActivity homeScreenActivity) {
        super(0);
        this.f60883g = homeScreenActivity;
    }

    @NotNull
    public final HomeScreenTracker invoke() {
        return new HomeScreenTracker(this.f60883g, new TalabatFirebase(), new LocationDataFactory((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null));
    }
}
