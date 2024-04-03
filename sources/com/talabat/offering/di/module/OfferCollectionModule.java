package com.talabat.offering.di.module;

import android.app.Activity;
import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.network.endpoint.OfferingPartnershipEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.offering.data.OfferCollectionTrackerImpl;
import com.talabat.offering.data.remote.api.OfferCollectionAPI;
import com.talabat.offering.data.remote.api.OfferCollectionSubscriptionAPI;
import com.talabat.offering.data.remote.datasoures.impl.OfferCollectionRemoteDataSourceImpl;
import com.talabat.offering.data.repo.OfferCollectionRepoImpl;
import com.talabat.offering.domain.OfferCollectionTracker;
import com.talabat.offering.domain.repo.OfferCollectionRepo;
import com.talabat.offering.domain.usecases.business.GetOfferCollectionUseCase;
import com.talabat.offering.domain.usecases.business.GetUserIsOfferCollectionSubscribedUseCase;
import com.talabat.offering.domain.usecases.business.SendMobileOTPUseCase;
import com.talabat.offering.domain.usecases.business.TrackShopClickedUseCase;
import com.talabat.offering.domain.usecases.business.TrackShopListUpdatedUseCase;
import com.talabat.offering.domain.usecases.business.TrackSubscriptionVerificationUseCase;
import com.talabat.offering.domain.usecases.business.VerifyOTPSubscriptionUseCase;
import com.talabat.offering.domain.usecases.business.impl.TrackShopClickedUseCaseImpl;
import com.talabat.offering.domain.usecases.business.impl.TrackShopListUpdatedUseCaseImpl;
import com.talabat.offering.domain.usecases.business.impl.TrackSubscriptionVerificationUseCaseImpl;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 ¨\u0006!"}, d2 = {"Lcom/talabat/offering/di/module/OfferCollectionModule;", "", "()V", "provideOfferCollectionRepository", "Lcom/talabat/offering/domain/repo/OfferCollectionRepo;", "provideOfferCollectionTracker", "Lcom/talabat/offering/domain/OfferCollectionTracker;", "context", "Landroid/content/Context;", "appTracker", "Ltracking/AppTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "provideOfferCollectionUseCase", "Lcom/talabat/offering/domain/usecases/business/GetOfferCollectionUseCase;", "provideSendMobileOTPUseCase", "Lcom/talabat/offering/domain/usecases/business/SendMobileOTPUseCase;", "provideTalabatTracker", "activity", "Landroid/app/Activity;", "provideTrackShopClickedUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackShopClickedUseCase;", "offerCollectionTracker", "provideTrackShopListUpdatedUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackShopListUpdatedUseCase;", "provideTrackSubscriptionVerificationUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackSubscriptionVerificationUseCase;", "provideUserIsOfferCollectionSubscribedUseCase", "Lcom/talabat/offering/domain/usecases/business/GetUserIsOfferCollectionSubscribedUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "provideVerifyOTPSubscriptionUseCaseUseCase", "Lcom/talabat/offering/domain/usecases/business/VerifyOTPSubscriptionUseCase;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionModule {
    @NotNull
    public static final OfferCollectionModule INSTANCE = new OfferCollectionModule();

    private OfferCollectionModule() {
    }

    private final OfferCollectionRepo provideOfferCollectionRepository() {
        return new OfferCollectionRepoImpl(new OfferCollectionRemoteDataSourceImpl((OfferCollectionAPI) new TalabatAPIBuilder().createApi(new OfferingPartnershipEndPointProvider((String) null, (String) null, 3, (DefaultConstructorMarker) null).getBaseUrl(), OfferCollectionAPI.class), (OfferCollectionSubscriptionAPI) new TalabatAPIBuilder().createApi(TalabatCommonUrlConstants.Companion.getSubscriptionBaseUrl(), OfferCollectionSubscriptionAPI.class)));
    }

    @NotNull
    public final OfferCollectionTracker provideOfferCollectionTracker(@NotNull Context context, @NotNull AppTracker appTracker, @NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appTracker, "appTracker");
        Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
        return new OfferCollectionTrackerImpl(context, appTracker, talabatTracker);
    }

    @NotNull
    public final GetOfferCollectionUseCase provideOfferCollectionUseCase() {
        return new GetOfferCollectionUseCase(provideOfferCollectionRepository(), (CoroutineDispatcher) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final SendMobileOTPUseCase provideSendMobileOTPUseCase() {
        return new SendMobileOTPUseCase(provideOfferCollectionRepository(), (CoroutineDispatcher) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final TalabatTracker provideTalabatTracker(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
    }

    @NotNull
    public final TrackShopClickedUseCase provideTrackShopClickedUseCase(@NotNull OfferCollectionTracker offerCollectionTracker) {
        Intrinsics.checkNotNullParameter(offerCollectionTracker, "offerCollectionTracker");
        return new TrackShopClickedUseCaseImpl(offerCollectionTracker);
    }

    @NotNull
    public final TrackShopListUpdatedUseCase provideTrackShopListUpdatedUseCase(@NotNull OfferCollectionTracker offerCollectionTracker) {
        Intrinsics.checkNotNullParameter(offerCollectionTracker, "offerCollectionTracker");
        return new TrackShopListUpdatedUseCaseImpl(offerCollectionTracker);
    }

    @NotNull
    public final TrackSubscriptionVerificationUseCase provideTrackSubscriptionVerificationUseCase(@NotNull OfferCollectionTracker offerCollectionTracker) {
        Intrinsics.checkNotNullParameter(offerCollectionTracker, "offerCollectionTracker");
        return new TrackSubscriptionVerificationUseCaseImpl(offerCollectionTracker);
    }

    @NotNull
    public final GetUserIsOfferCollectionSubscribedUseCase provideUserIsOfferCollectionSubscribedUseCase(@NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        return new GetUserIsOfferCollectionSubscribedUseCase(provideOfferCollectionRepository(), (CoroutineDispatcher) null, configurationLocalRepository, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final VerifyOTPSubscriptionUseCase provideVerifyOTPSubscriptionUseCaseUseCase() {
        return new VerifyOTPSubscriptionUseCase(provideOfferCollectionRepository(), (CoroutineDispatcher) null, 2, (DefaultConstructorMarker) null);
    }
}
