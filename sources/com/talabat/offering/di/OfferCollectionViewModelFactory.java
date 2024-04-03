package com.talabat.offering.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.offering.di.module.OfferCollectionModule;
import com.talabat.offering.domain.OfferCollectionTracker;
import com.talabat.offering.domain.usecases.business.GetOfferCollectionUseCase;
import com.talabat.offering.domain.usecases.business.GetUserIsOfferCollectionSubscribedUseCase;
import com.talabat.offering.domain.usecases.business.SendMobileOTPUseCase;
import com.talabat.offering.domain.usecases.business.TrackShopClickedUseCase;
import com.talabat.offering.domain.usecases.business.TrackShopListUpdatedUseCase;
import com.talabat.offering.domain.usecases.business.TrackSubscriptionVerificationUseCase;
import com.talabat.offering.domain.usecases.business.VerifyOTPSubscriptionUseCase;
import com.talabat.offering.presentation.viewmodel.OfferCollectionViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/offering/di/OfferCollectionViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "offerCollectionUseCase", "Lcom/talabat/offering/domain/usecases/business/GetOfferCollectionUseCase;", "userIsOfferCollectionSubscribedUseCase", "Lcom/talabat/offering/domain/usecases/business/GetUserIsOfferCollectionSubscribedUseCase;", "sendMobileOTPUseCase", "Lcom/talabat/offering/domain/usecases/business/SendMobileOTPUseCase;", "verifyOTPSubscriptionUseCase", "Lcom/talabat/offering/domain/usecases/business/VerifyOTPSubscriptionUseCase;", "trackShopClickedUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackShopClickedUseCase;", "trackShopListUpdatedUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackShopListUpdatedUseCase;", "trackSubscriptionVerificationUseCase", "Lcom/talabat/offering/domain/usecases/business/TrackSubscriptionVerificationUseCase;", "(Lcom/talabat/offering/domain/usecases/business/GetOfferCollectionUseCase;Lcom/talabat/offering/domain/usecases/business/GetUserIsOfferCollectionSubscribedUseCase;Lcom/talabat/offering/domain/usecases/business/SendMobileOTPUseCase;Lcom/talabat/offering/domain/usecases/business/VerifyOTPSubscriptionUseCase;Lcom/talabat/offering/domain/usecases/business/TrackShopClickedUseCase;Lcom/talabat/offering/domain/usecases/business/TrackShopListUpdatedUseCase;Lcom/talabat/offering/domain/usecases/business/TrackSubscriptionVerificationUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static OfferCollectionViewModel mockedOfferCollectionViewModel;
    @NotNull
    private final GetOfferCollectionUseCase offerCollectionUseCase;
    @NotNull
    private final SendMobileOTPUseCase sendMobileOTPUseCase;
    @NotNull
    private final TrackShopClickedUseCase trackShopClickedUseCase;
    @NotNull
    private final TrackShopListUpdatedUseCase trackShopListUpdatedUseCase;
    @NotNull
    private final TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase;
    @NotNull
    private final GetUserIsOfferCollectionSubscribedUseCase userIsOfferCollectionSubscribedUseCase;
    @NotNull
    private final VerifyOTPSubscriptionUseCase verifyOTPSubscriptionUseCase;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/talabat/offering/di/OfferCollectionViewModelFactory$Companion;", "", "()V", "mockedOfferCollectionViewModel", "Lcom/talabat/offering/presentation/viewmodel/OfferCollectionViewModel;", "getMockedOfferCollectionViewModel", "()Lcom/talabat/offering/presentation/viewmodel/OfferCollectionViewModel;", "setMockedOfferCollectionViewModel", "(Lcom/talabat/offering/presentation/viewmodel/OfferCollectionViewModel;)V", "create", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OfferCollectionViewModel create(@NotNull AppCompatActivity appCompatActivity, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "appCompatActivity");
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            OfferCollectionModule offerCollectionModule = OfferCollectionModule.INSTANCE;
            OfferCollectionTracker provideOfferCollectionTracker = offerCollectionModule.provideOfferCollectionTracker(appCompatActivity, new AppTracker(new TalabatGTM()), offerCollectionModule.provideTalabatTracker(appCompatActivity));
            OfferCollectionViewModel mockedOfferCollectionViewModel = getMockedOfferCollectionViewModel();
            if (mockedOfferCollectionViewModel != null) {
                return mockedOfferCollectionViewModel;
            }
            return (OfferCollectionViewModel) new ViewModelProvider((ViewModelStoreOwner) appCompatActivity, (ViewModelProvider.Factory) new OfferCollectionViewModelFactory(offerCollectionModule.provideOfferCollectionUseCase(), offerCollectionModule.provideUserIsOfferCollectionSubscribedUseCase(configurationLocalRepository), offerCollectionModule.provideSendMobileOTPUseCase(), offerCollectionModule.provideVerifyOTPSubscriptionUseCaseUseCase(), offerCollectionModule.provideTrackShopClickedUseCase(provideOfferCollectionTracker), offerCollectionModule.provideTrackShopListUpdatedUseCase(provideOfferCollectionTracker), offerCollectionModule.provideTrackSubscriptionVerificationUseCase(provideOfferCollectionTracker), (DefaultConstructorMarker) null)).get(OfferCollectionViewModel.class);
        }

        @Nullable
        public final OfferCollectionViewModel getMockedOfferCollectionViewModel() {
            return OfferCollectionViewModelFactory.mockedOfferCollectionViewModel;
        }

        public final void setMockedOfferCollectionViewModel(@Nullable OfferCollectionViewModel offerCollectionViewModel) {
            OfferCollectionViewModelFactory.mockedOfferCollectionViewModel = offerCollectionViewModel;
        }
    }

    private OfferCollectionViewModelFactory(GetOfferCollectionUseCase getOfferCollectionUseCase, GetUserIsOfferCollectionSubscribedUseCase getUserIsOfferCollectionSubscribedUseCase, SendMobileOTPUseCase sendMobileOTPUseCase2, VerifyOTPSubscriptionUseCase verifyOTPSubscriptionUseCase2, TrackShopClickedUseCase trackShopClickedUseCase2, TrackShopListUpdatedUseCase trackShopListUpdatedUseCase2, TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2) {
        this.offerCollectionUseCase = getOfferCollectionUseCase;
        this.userIsOfferCollectionSubscribedUseCase = getUserIsOfferCollectionSubscribedUseCase;
        this.sendMobileOTPUseCase = sendMobileOTPUseCase2;
        this.verifyOTPSubscriptionUseCase = verifyOTPSubscriptionUseCase2;
        this.trackShopClickedUseCase = trackShopClickedUseCase2;
        this.trackShopListUpdatedUseCase = trackShopListUpdatedUseCase2;
        this.trackSubscriptionVerificationUseCase = trackSubscriptionVerificationUseCase2;
    }

    public /* synthetic */ OfferCollectionViewModelFactory(GetOfferCollectionUseCase getOfferCollectionUseCase, GetUserIsOfferCollectionSubscribedUseCase getUserIsOfferCollectionSubscribedUseCase, SendMobileOTPUseCase sendMobileOTPUseCase2, VerifyOTPSubscriptionUseCase verifyOTPSubscriptionUseCase2, TrackShopClickedUseCase trackShopClickedUseCase2, TrackShopListUpdatedUseCase trackShopListUpdatedUseCase2, TrackSubscriptionVerificationUseCase trackSubscriptionVerificationUseCase2, DefaultConstructorMarker defaultConstructorMarker) {
        this(getOfferCollectionUseCase, getUserIsOfferCollectionSubscribedUseCase, sendMobileOTPUseCase2, verifyOTPSubscriptionUseCase2, trackShopClickedUseCase2, trackShopListUpdatedUseCase2, trackSubscriptionVerificationUseCase2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new OfferCollectionViewModel(this.offerCollectionUseCase, this.userIsOfferCollectionSubscribedUseCase, this.sendMobileOTPUseCase, this.verifyOTPSubscriptionUseCase, this.trackShopClickedUseCase, this.trackShopListUpdatedUseCase, this.trackSubscriptionVerificationUseCase);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
