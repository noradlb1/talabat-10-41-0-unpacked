package com.talabat.restaurants.v2.ui.viewmodels;

import androidx.lifecycle.ViewModel;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.restaurants.v2.data.vendors.VendorByIdDataSource;
import com.talabat.restaurants.v2.domain.utils.GetExternalExperimentsUseCase;
import com.talabat.restaurants.v2.domain.vendors.GetFavouriteRestaurantsUseCase;
import com.talabat.restaurants.v2.tracking.FavouriteShopListLoadedEvent;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Restaurant;
import io.reactivex.Scheduler;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import tt.a;
import tt.b;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RC\u0010\u0012\u001a4\u00120\u0012.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u0003 \u000f*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00130\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/restaurants/v2/ui/viewmodels/FavouriteRestaurantsViewModel;", "Landroidx/lifecycle/ViewModel;", "isCardView", "", "io", "Lio/reactivex/Scheduler;", "main", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getFavouriteRestaurantsUseCase", "Lcom/talabat/restaurants/v2/domain/vendors/GetFavouriteRestaurantsUseCase;", "(ZLio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/restaurants/v2/domain/vendors/GetFavouriteRestaurantsUseCase;)V", "showNoResult", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "getShowNoResult", "()Lio/reactivex/subjects/PublishSubject;", "showRestaurants", "Lkotlin/Pair;", "", "Ldatamodels/Restaurant;", "getShowRestaurants", "loadFavouriteList", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FavouriteRestaurantsViewModel extends ViewModel {
    @NotNull
    private final GetFavouriteRestaurantsUseCase getFavouriteRestaurantsUseCase;
    @NotNull

    /* renamed from: io  reason: collision with root package name */
    private final Scheduler f61270io;
    private final boolean isCardView;
    @NotNull
    private final Scheduler main;
    @NotNull
    private final PublishSubject<Unit> showNoResult;
    @NotNull
    private final PublishSubject<Pair<List<Restaurant>, Boolean>> showRestaurants;
    @NotNull
    private final TalabatTracker tracker;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FavouriteRestaurantsViewModel(boolean z11, Scheduler scheduler, Scheduler scheduler2, TalabatTracker talabatTracker, GetFavouriteRestaurantsUseCase getFavouriteRestaurantsUseCase2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? SharedPreferencesManager.getInstance().isCardViewFavStyle(Boolean.FALSE) : z11, scheduler, scheduler2, talabatTracker, (i11 & 16) != 0 ? new GetFavouriteRestaurantsUseCase((GetExternalExperimentsUseCase) null, (VendorByIdDataSource) null, 3, (DefaultConstructorMarker) null) : getFavouriteRestaurantsUseCase2);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadFavouriteList$lambda-0  reason: not valid java name */
    public static final void m10758loadFavouriteList$lambda0(FavouriteRestaurantsViewModel favouriteRestaurantsViewModel, List list) {
        Intrinsics.checkNotNullParameter(favouriteRestaurantsViewModel, "this$0");
        if (list.isEmpty()) {
            favouriteRestaurantsViewModel.showNoResult.onNext(Unit.INSTANCE);
        } else {
            favouriteRestaurantsViewModel.showRestaurants.onNext(new Pair(list, Boolean.valueOf(favouriteRestaurantsViewModel.isCardView)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadFavouriteList$lambda-1  reason: not valid java name */
    public static final void m10759loadFavouriteList$lambda1(FavouriteRestaurantsViewModel favouriteRestaurantsViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(favouriteRestaurantsViewModel, "this$0");
        favouriteRestaurantsViewModel.showNoResult.onNext(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    @NotNull
    public final PublishSubject<Unit> getShowNoResult() {
        return this.showNoResult;
    }

    @NotNull
    public final PublishSubject<Pair<List<Restaurant>, Boolean>> getShowRestaurants() {
        return this.showRestaurants;
    }

    public final void loadFavouriteList() {
        this.getFavouriteRestaurantsUseCase.invoke().subscribeOn(this.f61270io).observeOn(this.main).subscribe(new a(this), new b(this));
        this.tracker.track(new FavouriteShopListLoadedEvent(new UserSettingsTracker((Function0) null, 1, (DefaultConstructorMarker) null).addUserSettings()));
    }

    public FavouriteRestaurantsViewModel(boolean z11, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull TalabatTracker talabatTracker, @NotNull GetFavouriteRestaurantsUseCase getFavouriteRestaurantsUseCase2) {
        Intrinsics.checkNotNullParameter(scheduler, "io");
        Intrinsics.checkNotNullParameter(scheduler2, "main");
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        Intrinsics.checkNotNullParameter(getFavouriteRestaurantsUseCase2, "getFavouriteRestaurantsUseCase");
        this.isCardView = z11;
        this.f61270io = scheduler;
        this.main = scheduler2;
        this.tracker = talabatTracker;
        this.getFavouriteRestaurantsUseCase = getFavouriteRestaurantsUseCase2;
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Unit>()");
        this.showNoResult = create;
        PublishSubject<Pair<List<Restaurant>, Boolean>> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Pair<List<Restaurant>, Boolean>>()");
        this.showRestaurants = create2;
    }
}
