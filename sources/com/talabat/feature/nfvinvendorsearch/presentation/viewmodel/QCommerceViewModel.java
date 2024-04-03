package com.talabat.feature.nfvinvendorsearch.presentation.viewmodel;

import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresInternalNavigationTarget;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandler;
import com.talabat.feature.darkstoresflutter.domain.usecase.NavigateToCheckoutUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler;
import com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand;
import com.talabat.feature.nfvinvendorsearch.presentation.model.ProductInfo;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0015H\u0017J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0019J\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModel;", "Landroidx/lifecycle/ViewModel;", "qCommerceMethodHandler", "Lcom/talabat/feature/nfvinvendorsearch/presentation/handler/QCommerceMethodHandler;", "darkstoresNavigator", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "darkstoreCartEventStreamHandler", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoreCartEventStreamHandler;", "darkstoresCartMethodCallHandler", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler;", "navigateToCheckout", "Lcom/talabat/feature/darkstoresflutter/domain/usecase/NavigateToCheckoutUseCase;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/handler/QCommerceMethodHandler;Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoreCartEventStreamHandler;Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler;Lcom/talabat/feature/darkstoresflutter/domain/usecase/NavigateToCheckoutUseCase;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "navigationCommands", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "getNavigationCommands", "()Landroidx/lifecycle/LiveData;", "onBannerCampaignProductListing", "", "fragment", "Landroidx/fragment/app/Fragment;", "tag", "", "onCleared", "onNavigateToCart", "onNavigateToCheckout", "specialRequest", "onNavigateToProductDetails", "productInfo", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/ProductInfo;", "onNavigateToVendorLanding", "setUpChannels", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceViewModel extends ViewModel {
    @NotNull
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @NotNull
    private final DarkstoreCartEventStreamHandler darkstoreCartEventStreamHandler;
    @NotNull
    private final DarkstoresCartMethodCallHandler darkstoresCartMethodCallHandler;
    @NotNull
    private final DarkstoresNavigator darkstoresNavigator;
    @NotNull
    private final NavigateToCheckoutUseCase navigateToCheckout;
    @NotNull
    private final LiveData<NavigationCommand> navigationCommands;
    @NotNull
    private final QCommerceMethodHandler qCommerceMethodHandler;

    @Inject
    public QCommerceViewModel(@NotNull QCommerceMethodHandler qCommerceMethodHandler2, @NotNull DarkstoresNavigator darkstoresNavigator2, @NotNull DarkstoreCartEventStreamHandler darkstoreCartEventStreamHandler2, @NotNull DarkstoresCartMethodCallHandler darkstoresCartMethodCallHandler2, @NotNull NavigateToCheckoutUseCase navigateToCheckoutUseCase) {
        Intrinsics.checkNotNullParameter(qCommerceMethodHandler2, "qCommerceMethodHandler");
        Intrinsics.checkNotNullParameter(darkstoresNavigator2, "darkstoresNavigator");
        Intrinsics.checkNotNullParameter(darkstoreCartEventStreamHandler2, "darkstoreCartEventStreamHandler");
        Intrinsics.checkNotNullParameter(darkstoresCartMethodCallHandler2, "darkstoresCartMethodCallHandler");
        Intrinsics.checkNotNullParameter(navigateToCheckoutUseCase, "navigateToCheckout");
        this.qCommerceMethodHandler = qCommerceMethodHandler2;
        this.darkstoresNavigator = darkstoresNavigator2;
        this.darkstoreCartEventStreamHandler = darkstoreCartEventStreamHandler2;
        this.darkstoresCartMethodCallHandler = darkstoresCartMethodCallHandler2;
        this.navigateToCheckout = navigateToCheckoutUseCase;
        this.navigationCommands = qCommerceMethodHandler2.getNavigationCommands();
    }

    @NotNull
    public final LiveData<NavigationCommand> getNavigationCommands() {
        return this.navigationCommands;
    }

    public final void onBannerCampaignProductListing(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.darkstoresNavigator.navigateInternal(fragment, new DarkstoresInternalNavigationTarget.BannerCampaignSearchResult(str, ScreenTrackingProvider.EventOrigin.SEARCH));
    }

    @VisibleForTesting(otherwise = 4)
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
        this.qCommerceMethodHandler.dispose();
        this.darkstoreCartEventStreamHandler.terminate();
        this.darkstoresCartMethodCallHandler.terminate();
    }

    public final void onNavigateToCart(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.darkstoresNavigator.navigateInternal(fragment, DarkstoresInternalNavigationTarget.Cart.INSTANCE);
    }

    public final void onNavigateToCheckout(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        this.navigateToCheckout.invoke(str);
    }

    public final void onNavigateToProductDetails(@NotNull Fragment fragment, @NotNull ProductInfo productInfo) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(productInfo, "productInfo");
        this.darkstoresNavigator.navigateInternal(fragment, new DarkstoresInternalNavigationTarget.ProductDetails(productInfo.getProductId(), false, productInfo.getEventOrigin(), productInfo.getSwimlaneRequestId(), productInfo.getSearchRequestId()));
    }

    public final void onNavigateToVendorLanding(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.darkstoresNavigator.navigateInternal(fragment, DarkstoresInternalNavigationTarget.VendorLanding.INSTANCE);
    }

    public final void setUpChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "engine");
        QCommerceMethodHandler qCommerceMethodHandler2 = this.qCommerceMethodHandler;
        DartExecutor dartExecutor = flutterEngine.getDartExecutor();
        Intrinsics.checkNotNullExpressionValue(dartExecutor, "engine.dartExecutor");
        qCommerceMethodHandler2.setUp(dartExecutor);
        this.darkstoreCartEventStreamHandler.setUpWithEngine(flutterEngine);
        this.darkstoresCartMethodCallHandler.setUpWithEngine(flutterEngine, new QCommerceViewModel$setUpChannels$1());
    }
}
