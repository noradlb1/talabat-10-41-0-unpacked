package com.talabat.collectiondetails.ui.quickfilter;

import com.talabat.collectiondetails.data.AbDataSourceImpl;
import com.talabat.collectiondetails.data.CollectionsApi;
import com.talabat.collectiondetails.data.CollectionsDataSourceImplementation;
import com.talabat.collectiondetails.data.FiltersDataSourceImpl;
import com.talabat.collectiondetails.data.MenuDataSourceImpl;
import com.talabat.collectiondetails.data.RestaurantDataSourceImpl;
import com.talabat.collectiondetails.data.TermsApiFactory;
import com.talabat.collectiondetails.data.TermsDataSourceImpl;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.helpers.GlobalDataModel;
import datamodels.QuickFilter;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ4\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterInteractorFactory;", "", "()V", "makeInteractor", "Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsInteractor;", "quickFilter", "Ldatamodels/QuickFilter;", "io", "Lio/reactivex/Scheduler;", "main", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "verticalId", "", "isNavigatedFromHomeCollection", "", "makeNewApiInteractor", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuickFilterInteractorFactory {
    @NotNull
    public static final QuickFilterInteractorFactory INSTANCE = new QuickFilterInteractorFactory();

    private QuickFilterInteractorFactory() {
    }

    public static /* synthetic */ IQuickFilterRestaurantsInteractor makeInteractor$default(QuickFilterInteractorFactory quickFilterInteractorFactory, QuickFilter quickFilter, Scheduler scheduler, Scheduler scheduler2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            scheduler = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(scheduler, "io()");
        }
        Scheduler scheduler3 = scheduler;
        if ((i12 & 4) != 0) {
            scheduler2 = AndroidSchedulers.mainThread();
            Intrinsics.checkNotNullExpressionValue(scheduler2, "mainThread()");
        }
        Scheduler scheduler4 = scheduler2;
        if ((i12 & 32) != 0) {
            z11 = false;
        }
        return quickFilterInteractorFactory.makeInteractor(quickFilter, scheduler3, scheduler4, configurationLocalCoreLibApi, i11, z11);
    }

    private final IQuickFilterRestaurantsInteractor makeNewApiInteractor(QuickFilter quickFilter, Scheduler scheduler, Scheduler scheduler2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, boolean z11) {
        return new QuickFilterBEFiltrationInteractor(new TermsDataSourceImpl(TermsApiFactory.INSTANCE.getTermsApi(), configurationLocalCoreLibApi), new RestaurantDataSourceImpl(), new AbDataSourceImpl(), new MenuDataSourceImpl(), new FiltersDataSourceImpl(), new CollectionsDataSourceImplementation((CollectionsApi) null, String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), z11, 1, (DefaultConstructorMarker) null), quickFilter, scheduler, scheduler2);
    }

    @NotNull
    public final IQuickFilterRestaurantsInteractor makeInteractor(@NotNull QuickFilter quickFilter, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, int i11, boolean z11) {
        ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = configurationLocalCoreLibApi;
        QuickFilter quickFilter2 = quickFilter;
        Intrinsics.checkNotNullParameter(quickFilter, "quickFilter");
        Intrinsics.checkNotNullParameter(scheduler, "io");
        Intrinsics.checkNotNullParameter(scheduler2, "main");
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi2, "configurationLocalCoreLibApi");
        if (i11 == 0) {
            return makeNewApiInteractor(quickFilter, scheduler, scheduler2, configurationLocalCoreLibApi, z11);
        }
        return new QuickFilterRestaurantsInteractor(new TermsDataSourceImpl(TermsApiFactory.INSTANCE.getTermsApi(), configurationLocalCoreLibApi2), new RestaurantDataSourceImpl(), new AbDataSourceImpl(), new MenuDataSourceImpl(), quickFilter, scheduler, scheduler2, (Function1) null, (Function1) null, (Function1) null, 896, (DefaultConstructorMarker) null);
    }
}
