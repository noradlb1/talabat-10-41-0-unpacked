package com.talabat.darkstores.feature.mission.control;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.darkstores.DarkstoresFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.ResultKt;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.GetFlutterConfigurationParamsUseCase;
import com.talabat.darkstores.domain.common.IsFlutterVLPEnabledUseCase;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNewArgs;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.main.usecase.GenerateVoucherUseCase;
import com.talabat.darkstores.feature.model.NavigationTarget;
import com.talabat.darkstores.feature.product.ProductFragmentArgs;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentArgs;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.model.ToastModel;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.feature.nfvinvendorsearch.presentation.fragment.QCommerceFlutterFragmentArgs;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.wrapper.EventWrapper;
import com.tekartik.sqflite.Constant;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001cBo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0018\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00102\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00103\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00104\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00105\u001a\u00020 2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002J\u0018\u00109\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\b\u0010:\u001a\u00020 H\u0002J \u0010;\u001a\u00020 2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u0002072\u0006\u0010>\u001a\u000207H\u0002J,\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u0002072\u0006\u0010A\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u0001072\b\u0010B\u001a\u0004\u0018\u000107H\u0002J\b\u0010C\u001a\u00020\"H\u0002J\u0010\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u000207H\u0002J\u0006\u0010F\u001a\u00020/J\b\u0010G\u001a\u00020HH\u0002J\u0006\u0010I\u001a\u00020HJ\u0010\u0010J\u001a\u00020\"2\u0006\u0010K\u001a\u00020 H\u0002J\u001a\u0010J\u001a\u00020\"2\u0006\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u000207H\u0002J\b\u0010R\u001a\u00020\"H\u0002J\u0018\u0010S\u001a\u00020\"2\u0006\u0010<\u001a\u0002072\u0006\u0010>\u001a\u000207H\u0002J \u0010T\u001a\u00020\"2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u000207H\u0002J \u0010U\u001a\u00020\"2\u0006\u0010@\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u000207H\u0002J \u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u0002072\u0006\u0010>\u001a\u0002072\u0006\u0010X\u001a\u000207H\u0002J \u0010Y\u001a\u00020\"2\u0006\u0010Z\u001a\u0002072\u0006\u0010[\u001a\u0002072\u0006\u0010>\u001a\u000207H\u0002J\u000e\u0010\\\u001a\u00020\"2\u0006\u0010]\u001a\u00020^J\u000e\u0010_\u001a\u00020\"2\u0006\u0010]\u001a\u00020`J \u0010a\u001a\u00020\"2\u0006\u0010W\u001a\u0002072\u0006\u0010>\u001a\u0002072\u0006\u0010X\u001a\u000207H\u0002J\b\u0010b\u001a\u00020\"H\u0002R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001f0&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001f0&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/talabat/darkstores/feature/mission/control/MainViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "buildCategoryProductsNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;", "buildCartNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;", "buildSwimlanesSearchResultNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCase;", "buildLifestyleSearchResultNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCase;", "getFlutterConfigurationParamsUseCase", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "isFlutterVLPEnabledUseCase", "Lcom/talabat/darkstores/domain/common/IsFlutterVLPEnabledUseCase;", "generateVoucherUseCase", "Lcom/talabat/darkstores/feature/main/usecase/GenerateVoucherUseCase;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "buildBannerCampaignProductListingNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCase;", "(Lio/reactivex/disposables/CompositeDisposable;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCase;Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCase;Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;Lcom/talabat/darkstores/domain/common/IsFlutterVLPEnabledUseCase;Lcom/talabat/darkstores/feature/main/usecase/GenerateVoucherUseCase;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCase;)V", "_navigationActions", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wrapper/EventWrapper;", "Landroidx/navigation/NavDirections;", "_productInfoErrors", "", "_showToastMessage", "Lcom/talabat/darkstores/model/ToastModel;", "navigationActions", "Landroidx/lifecycle/LiveData;", "getNavigationActions", "()Landroidx/lifecycle/LiveData;", "productInfoErrors", "getProductInfoErrors", "showToastMessage", "getShowToastMessage", "buildCampaignFlutterNavAction", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildFlutterCartAction", "buildFlutterCategoryAction", "buildFlutterSwimlanesSearchAction", "buildLifestyleMissionControlNativeNavAction", "code", "", "name", "buildLifestyleMissionFlutterNavAction", "buildNativeCartAction", "buildNativeCategoryAction", "categoryId", "categoryName", "eventOrigin", "buildNativeSwimlanesSearchAction", "swimlaneId", "headline", "tag", "generateVoucherIfUserEligible", "getBannerNativeNavAction", "campaignId", "getFlutterConfigurationParams", "isLifeStyleMissionEnabled", "", "isVlpFlutterEnabled", "navigate", "action", "actionId", "", "arguments", "Landroid/os/Bundle;", "navigateToCampaign", "deeplinkInfo", "navigateToCart", "navigateToCategory", "navigateToLifeStyleMissionProducts", "navigateToPrimaryMissionSwimlane", "navigateToProductById", "id", "searchTerm", "navigateToProductBySku", "productSku", "deeplinkUri", "onDeferredNavigation", "target", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "onImmediateNavigation", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Immediate;", "requestProductInformation", "setImageOptimizationFlagAttributeForObservability", "InternalNavDirections", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<EventWrapper<NavDirections>> _navigationActions;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<EventWrapper<Unit>> _productInfoErrors;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<EventWrapper<ToastModel>> _showToastMessage;
    @NotNull
    private final BuildBannerCampaignProductListingNavigationUseCase buildBannerCampaignProductListingNavigationUseCase;
    @NotNull
    private final BuildCartNavigationActionUseCase buildCartNavigationAction;
    @NotNull
    private final BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationAction;
    @NotNull
    private final BuildLifestyleSearchResultNavigationActionUseCase buildLifestyleSearchResultNavigationActionUseCase;
    @NotNull
    private final BuildSwimlanesSearchResultNavigationActionUseCase buildSwimlanesSearchResultNavigationActionUseCase;
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    @NotNull
    private final GenerateVoucherUseCase generateVoucherUseCase;
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase;
    @NotNull
    private final IsFlutterVLPEnabledUseCase isFlutterVLPEnabledUseCase;
    @NotNull
    private final LiveData<EventWrapper<NavDirections>> navigationActions;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final LiveData<EventWrapper<Unit>> productInfoErrors;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final LiveData<EventWrapper<ToastModel>> showToastMessage;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/mission/control/MainViewModel$InternalNavDirections;", "Landroidx/navigation/NavDirections;", "actionId", "", "arguments", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getActionId", "()I", "getArguments", "()Landroid/os/Bundle;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InternalNavDirections implements NavDirections {
        private final int actionId;
        @NotNull
        private final Bundle arguments;

        public InternalNavDirections(int i11, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, Constant.PARAM_SQL_ARGUMENTS);
            this.actionId = i11;
            this.arguments = bundle;
        }

        public static /* synthetic */ InternalNavDirections copy$default(InternalNavDirections internalNavDirections, int i11, Bundle bundle, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = internalNavDirections.getActionId();
            }
            if ((i12 & 2) != 0) {
                bundle = internalNavDirections.getArguments();
            }
            return internalNavDirections.copy(i11, bundle);
        }

        public final int component1() {
            return getActionId();
        }

        @NotNull
        public final Bundle component2() {
            return getArguments();
        }

        @NotNull
        public final InternalNavDirections copy(int i11, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, Constant.PARAM_SQL_ARGUMENTS);
            return new InternalNavDirections(i11, bundle);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InternalNavDirections)) {
                return false;
            }
            InternalNavDirections internalNavDirections = (InternalNavDirections) obj;
            return getActionId() == internalNavDirections.getActionId() && Intrinsics.areEqual((Object) getArguments(), (Object) internalNavDirections.getArguments());
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            return this.arguments;
        }

        public int hashCode() {
            return (getActionId() * 31) + getArguments().hashCode();
        }

        @NotNull
        public String toString() {
            int actionId2 = getActionId();
            Bundle arguments2 = getArguments();
            return "InternalNavDirections(actionId=" + actionId2 + ", arguments=" + arguments2 + ")";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public MainViewModel(@NotNull CompositeDisposable compositeDisposable, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull DiscoveryRepo discoveryRepo2, @NotNull BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationActionUseCase, @NotNull BuildCartNavigationActionUseCase buildCartNavigationActionUseCase, @NotNull BuildSwimlanesSearchResultNavigationActionUseCase buildSwimlanesSearchResultNavigationActionUseCase2, @NotNull BuildLifestyleSearchResultNavigationActionUseCase buildLifestyleSearchResultNavigationActionUseCase2, @NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase2, @NotNull IsFlutterVLPEnabledUseCase isFlutterVLPEnabledUseCase2, @NotNull GenerateVoucherUseCase generateVoucherUseCase2, @NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull IObservabilityManager iObservabilityManager, @NotNull BuildBannerCampaignProductListingNavigationUseCase buildBannerCampaignProductListingNavigationUseCase2) {
        super(compositeDisposable);
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(buildCategoryProductsNavigationActionUseCase, "buildCategoryProductsNavigationAction");
        Intrinsics.checkNotNullParameter(buildCartNavigationActionUseCase, "buildCartNavigationAction");
        Intrinsics.checkNotNullParameter(buildSwimlanesSearchResultNavigationActionUseCase2, "buildSwimlanesSearchResultNavigationActionUseCase");
        Intrinsics.checkNotNullParameter(buildLifestyleSearchResultNavigationActionUseCase2, "buildLifestyleSearchResultNavigationActionUseCase");
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase2, "getFlutterConfigurationParamsUseCase");
        Intrinsics.checkNotNullParameter(isFlutterVLPEnabledUseCase2, "isFlutterVLPEnabledUseCase");
        Intrinsics.checkNotNullParameter(generateVoucherUseCase2, "generateVoucherUseCase");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(buildBannerCampaignProductListingNavigationUseCase2, "buildBannerCampaignProductListingNavigationUseCase");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.discoveryRepo = discoveryRepo2;
        this.buildCategoryProductsNavigationAction = buildCategoryProductsNavigationActionUseCase;
        this.buildCartNavigationAction = buildCartNavigationActionUseCase;
        this.buildSwimlanesSearchResultNavigationActionUseCase = buildSwimlanesSearchResultNavigationActionUseCase2;
        this.buildLifestyleSearchResultNavigationActionUseCase = buildLifestyleSearchResultNavigationActionUseCase2;
        this.getFlutterConfigurationParamsUseCase = getFlutterConfigurationParamsUseCase2;
        this.isFlutterVLPEnabledUseCase = isFlutterVLPEnabledUseCase2;
        this.generateVoucherUseCase = generateVoucherUseCase2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.observabilityManager = iObservabilityManager;
        this.buildBannerCampaignProductListingNavigationUseCase = buildBannerCampaignProductListingNavigationUseCase2;
        MutableLiveData<EventWrapper<NavDirections>> mutableLiveData = new MutableLiveData<>();
        this._navigationActions = mutableLiveData;
        this.navigationActions = mutableLiveData;
        MutableLiveData<EventWrapper<Unit>> mutableLiveData2 = new MutableLiveData<>();
        this._productInfoErrors = mutableLiveData2;
        this.productInfoErrors = mutableLiveData2;
        MutableLiveData<EventWrapper<ToastModel>> mutableLiveData3 = new MutableLiveData<>();
        this._showToastMessage = mutableLiveData3;
        this.showToastMessage = mutableLiveData3;
        generateVoucherIfUserEligible();
        setImageOptimizationFlagAttributeForObservability();
    }

    /* access modifiers changed from: private */
    public final NavDirections buildCampaignFlutterNavAction(FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute) {
        return new InternalNavDirections(R.id.flutterSearchFragment, new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute).toBundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildFlutterCartAction(FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute) {
        return new InternalNavDirections(R.id.flutterSearchFragment, new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute).toBundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildFlutterCategoryAction(FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute) {
        return new InternalNavDirections(R.id.flutterSearchFragment, new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute).toBundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildFlutterSwimlanesSearchAction(FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute) {
        return new InternalNavDirections(R.id.flutterSearchFragment, new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute).toBundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildLifestyleMissionControlNativeNavAction(String str, String str2) {
        return new InternalNavDirections(R.id.searchResultsFragment, new SearchResultsFragmentArgs(new SearchResultsType.LifestyleMissionControl(str, str2), (String) null, 2, (DefaultConstructorMarker) null).toBundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildLifestyleMissionFlutterNavAction(FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute) {
        return new InternalNavDirections(R.id.flutterSearchFragment, new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute).toBundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildNativeCartAction() {
        return new InternalNavDirections(R.id.cartFragment, new Bundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildNativeCategoryAction(String str, String str2, String str3) {
        return new InternalNavDirections(R.id.subcategoriesFragmentNew, new SubcategoriesFragmentNewArgs(str, str2, str3).toBundle());
    }

    /* access modifiers changed from: private */
    public final NavDirections buildNativeSwimlanesSearchAction(String str, String str2, String str3, String str4) {
        return new InternalNavDirections(R.id.searchResultsFragment, new SearchResultsFragmentArgs(new SearchResultsType.PrimaryMissionControl(str, str2), (String) null, 2, (DefaultConstructorMarker) null).toBundle());
    }

    private final void generateVoucherIfUserEligible() {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default(this.generateVoucherUseCase.invoke(), (Function1) new MainViewModel$generateVoucherIfUserEligible$1(this), (Function0) null, 2, (Object) null));
    }

    /* access modifiers changed from: private */
    public final NavDirections getBannerNativeNavAction(String str) {
        return new InternalNavDirections(R.id.searchResultsFragment, new SearchResultsFragmentArgs(new SearchResultsType.Tag(str, (String) null, 2, (DefaultConstructorMarker) null), (String) null, 2, (DefaultConstructorMarker) null).toBundle());
    }

    private final boolean isLifeStyleMissionEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(DarkstoresFeatureFlagConstants.DARKSTORE_VLP_LIFESTYLE_MISSION_CONTROL, false);
    }

    /* access modifiers changed from: private */
    public final void navigate(int i11, Bundle bundle) {
        navigate(new InternalNavDirections(i11, bundle));
    }

    private final void navigateToCampaign(String str) {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildBannerCampaignProductListingNavigationUseCase.invoke(str, new MainViewModel$navigateToCampaign$1(this), new MainViewModel$navigateToCampaign$2(this)), (Function1) null, (Function1) new MainViewModel$navigateToCampaign$3(this), 1, (Object) null));
    }

    private final void navigateToCart() {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildCartNavigationAction.invoke(new MainViewModel$navigateToCart$1(this), new MainViewModel$navigateToCart$2(this)), (Function1) null, (Function1) new MainViewModel$navigateToCart$3(this), 1, (Object) null));
    }

    private final void navigateToCategory(String str, String str2) {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildCategoryProductsNavigationAction.invoke(str, "", str2, new MainViewModel$navigateToCategory$1(this), new MainViewModel$navigateToCategory$2(this)), (Function1) null, (Function1) new MainViewModel$navigateToCategory$3(this), 1, (Object) null));
    }

    private final void navigateToLifeStyleMissionProducts(String str, String str2, String str3) {
        if (isLifeStyleMissionEnabled()) {
            DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildLifestyleSearchResultNavigationActionUseCase.invoke(str, str2, str3, new MainViewModel$navigateToLifeStyleMissionProducts$1(this), new MainViewModel$navigateToLifeStyleMissionProducts$2(this)), (Function1) null, (Function1) new MainViewModel$navigateToLifeStyleMissionProducts$3(this), 1, (Object) null));
        }
    }

    private final void navigateToPrimaryMissionSwimlane(String str, String str2, String str3) {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildSwimlanesSearchResultNavigationActionUseCase.invoke(str, str2, str3, (String) null, (String) null, new MainViewModel$navigateToPrimaryMissionSwimlane$1(this), new MainViewModel$navigateToPrimaryMissionSwimlane$2(this)), (Function1) null, (Function1) new MainViewModel$navigateToPrimaryMissionSwimlane$3(this), 1, (Object) null));
    }

    private final void navigateToProductById(String str, String str2, String str3) {
        requestProductInformation(str, str2, str3);
    }

    private final void navigateToProductBySku(String str, String str2, String str3) {
        Product product = r0;
        Product product2 = new Product((String) null, (String) null, (String) null, 0.0f, (Float) null, 0, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, (CampaignTrigger) null, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, Integer.MAX_VALUE, (DefaultConstructorMarker) null);
        Product product3 = product;
        product3.setSku(str);
        navigate(R.id.productFragment, new ProductFragmentArgs(product3, false, str2, str3, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 242, (DefaultConstructorMarker) null).toBundle());
    }

    private final void requestProductInformation(String str, String str2, String str3) {
        CompositeDisposable a11 = a();
        Observable<Result<Type>> subscribeOn = ResultKt.toResult(this.discoveryRepo.getProductDetails(str)).observeOn(this.rxSchedulersFactory.main()).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "discoveryRepo.getProduct…rxSchedulersFactory.io())");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) subscribeOn, (Function1) null, (Function0) null, (Function1) new MainViewModel$requestProductInformation$1(this, str2, str3), 3, (Object) null));
    }

    private final void setImageOptimizationFlagAttributeForObservability() {
        QCommerceFeatureFlagsKeys qCommerceFeatureFlagsKeys = QCommerceFeatureFlagsKeys.QCOMMERCE_IMAGE_OPTIMIZATION;
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(qCommerceFeatureFlagsKeys, false);
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String value = qCommerceFeatureFlagsKeys.getValue();
        iObservabilityManager.trackAttribute("feature_flags", value + CertificateUtil.DELIMITER + featureFlag);
    }

    @NotNull
    public final FlutterConfigurationParams getFlutterConfigurationParams() {
        return this.getFlutterConfigurationParamsUseCase.invoke();
    }

    @NotNull
    public final LiveData<EventWrapper<NavDirections>> getNavigationActions() {
        return this.navigationActions;
    }

    @NotNull
    public final LiveData<EventWrapper<Unit>> getProductInfoErrors() {
        return this.productInfoErrors;
    }

    @NotNull
    public final LiveData<EventWrapper<ToastModel>> getShowToastMessage() {
        return this.showToastMessage;
    }

    public final boolean isVlpFlutterEnabled() {
        return this.isFlutterVLPEnabledUseCase.invoke();
    }

    public final void onDeferredNavigation(@NotNull NavigationTarget.Deferred deferred) {
        Intrinsics.checkNotNullParameter(deferred, "target");
        if (deferred instanceof NavigationTarget.Deferred.Campaign) {
            navigateToCampaign(((NavigationTarget.Deferred.Campaign) deferred).getCampaignId());
        } else if (Intrinsics.areEqual((Object) deferred, (Object) NavigationTarget.Deferred.Cart.INSTANCE)) {
            navigateToCart();
        } else if (deferred instanceof NavigationTarget.Deferred.Category) {
            NavigationTarget.Deferred.Category category = (NavigationTarget.Deferred.Category) deferred;
            navigateToCategory(category.getCategoryId(), category.getEventOrigin());
        } else if (deferred instanceof NavigationTarget.Deferred.Product) {
            NavigationTarget.Deferred.Product product = (NavigationTarget.Deferred.Product) deferred;
            navigateToProductById(product.getProductId(), product.getEventOrigin(), product.getSearchTerm());
        } else if (deferred instanceof NavigationTarget.Deferred.ProductBySku) {
            NavigationTarget.Deferred.ProductBySku productBySku = (NavigationTarget.Deferred.ProductBySku) deferred;
            navigateToProductBySku(productBySku.getProductSku(), productBySku.getDeeplinkUri(), productBySku.getEventOrigin());
        } else if (deferred instanceof NavigationTarget.Deferred.LifeStyleMission) {
            NavigationTarget.Deferred.LifeStyleMission lifeStyleMission = (NavigationTarget.Deferred.LifeStyleMission) deferred;
            navigateToLifeStyleMissionProducts(lifeStyleMission.getCode(), lifeStyleMission.getName(), lifeStyleMission.getEventOrigin());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void onImmediateNavigation(@NotNull NavigationTarget.Immediate immediate) {
        Intrinsics.checkNotNullParameter(immediate, "target");
        if (immediate instanceof NavigationTarget.Immediate.PrimaryMission) {
            NavigationTarget.Immediate.PrimaryMission primaryMission = (NavigationTarget.Immediate.PrimaryMission) immediate;
            navigateToPrimaryMissionSwimlane(primaryMission.getSwimlaneId(), primaryMission.getName(), primaryMission.getEventOrigin());
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public final void navigate(NavDirections navDirections) {
        this._navigationActions.postValue(new EventWrapper(navDirections));
    }
}
