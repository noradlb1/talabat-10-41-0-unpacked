package com.talabat.offering.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.collectiondetails.ui.restaurantlist.RestaurantsCollectionsAdapter;
import com.talabat.collectiondetails.ui.restaurantlist.RestaurantsListAdapter;
import com.talabat.collectiondetails.utils.FreshVerticalSpaceItemDecoration;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.flutter.VendorListSearchFlutterActivity;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.offering.R;
import com.talabat.offering.di.OfferCollectionViewModelFactory;
import com.talabat.offering.presentation.displaymodel.HeaderDisplayModel;
import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import com.talabat.offering.presentation.displaymodel.UserSubscriptionDisplayModel;
import com.talabat.offering.presentation.displaymodel.VendorsDisplayModel;
import com.talabat.offering.presentation.viewmodel.OfferCollectionViewModel;
import com.talabat.offering.ui.di.DaggerOfferCollectionActivityComponent;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vs.a;
import vs.b;
import vs.c;
import vs.d;
import vs.e;
import vs.f;
import vs.g;
import vs.h;
import vs.i;
import vs.j;
import vs.k;
import vs.l;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020)H\u0007J\u0006\u00104\u001a\u00020)J\u0006\u00105\u001a\u00020)J\u001a\u00106\u001a\u00020)2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u000108H\u0002J\b\u0010:\u001a\u00020)H\u0002J.\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u0002002\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020-J\"\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u0002002\u0006\u0010C\u001a\u0002002\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010F\u001a\u00020)2\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\u0018\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u000200H\u0016J\u000e\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020OJ\u0006\u0010P\u001a\u00020)J\b\u0010Q\u001a\u00020)H\u0002J\u0006\u0010R\u001a\u00020)J\u0010\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u000208H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006V"}, d2 = {"Lcom/talabat/offering/ui/OfferCollectionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/talabat/collectiondetails/ui/restaurantlist/RestaurantsCollectionsAdapter$OnRestaurantCLickListener;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "offerCollectionViewModel", "Lcom/talabat/offering/presentation/viewmodel/OfferCollectionViewModel;", "getOfferCollectionViewModel", "()Lcom/talabat/offering/presentation/viewmodel/OfferCollectionViewModel;", "setOfferCollectionViewModel", "(Lcom/talabat/offering/presentation/viewmodel/OfferCollectionViewModel;)V", "subscriptionDialog", "Lcom/talabat/offering/ui/OfferSubscriptionBottomSheetDialog;", "getSubscriptionDialog", "()Lcom/talabat/offering/ui/OfferSubscriptionBottomSheetDialog;", "setSubscriptionDialog", "(Lcom/talabat/offering/ui/OfferSubscriptionBottomSheetDialog;)V", "subscriptionVerificationDialog", "Lcom/talabat/offering/ui/OfferSubscriptionVerifyBottomSheetDialog;", "getSubscriptionVerificationDialog", "()Lcom/talabat/offering/ui/OfferSubscriptionVerifyBottomSheetDialog;", "setSubscriptionVerificationDialog", "(Lcom/talabat/offering/ui/OfferSubscriptionVerifyBottomSheetDialog;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "vendorsAdapter", "Lcom/talabat/collectiondetails/ui/restaurantlist/RestaurantsListAdapter;", "getVendorsAdapter", "()Lcom/talabat/collectiondetails/ui/restaurantlist/RestaurantsListAdapter;", "setVendorsAdapter", "(Lcom/talabat/collectiondetails/ui/restaurantlist/RestaurantsListAdapter;)V", "bindData", "", "headerText", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$HeaderData;", "isSubscribed", "", "checkVisibilityThreshold", "verticalOffset", "", "totalScrollRange", "configureToolbarAndStatusBar", "getOfferCollectionData", "handleLoggedOutUser", "handleNotSubscribedUser", "handleResendOTP", "mobileNumber", "", "requestId", "inject", "moveToMenu", "branchId", "shopType", "isGlrEnabled", "isDarkStore", "isMigrated", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRestaurantClick", "restaurant", "Ldatamodels/Restaurant;", "position", "openOTPVerificationDialog", "otpDisplayModel", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel;", "openSubscriptionDialog", "registerObservable", "showSuccessDialog", "verifyOTP", "otpCode", "Companion", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionActivity extends AppCompatActivity implements RestaurantsCollectionsAdapter.OnRestaurantCLickListener, TraceFieldInterface {
    @NotNull
    @JvmField
    public static String COLLECTION_ID_PARAM = VendorListSearchFlutterActivity.COLLECTION_ID_KEY;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    public OfferCollectionViewModel offerCollectionViewModel;
    @Nullable
    private OfferSubscriptionBottomSheetDialog subscriptionDialog;
    @Nullable
    private OfferSubscriptionVerifyBottomSheetDialog subscriptionVerificationDialog;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    public RestaurantsListAdapter vendorsAdapter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/offering/ui/OfferCollectionActivity$Companion;", "", "()V", "COLLECTION_ID_PARAM", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void bindData$default(OfferCollectionActivity offerCollectionActivity, HeaderDisplayModel.HeaderData headerData, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        offerCollectionActivity.bindData(headerData, z11);
    }

    private final void configureToolbarAndStatusBar() {
        int i11 = R.id.appbar;
        ((AppBarLayout) _$_findCachedViewById(i11)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(this));
        ViewCompat.setOnApplyWindowInsetsListener((AppBarLayout) _$_findCachedViewById(i11), new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: configureToolbarAndStatusBar$lambda-12  reason: not valid java name */
    public static final void m10683configureToolbarAndStatusBar$lambda12(OfferCollectionActivity offerCollectionActivity, AppBarLayout appBarLayout, int i11) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        offerCollectionActivity.checkVisibilityThreshold(Math.abs(i11), ((AppBarLayout) offerCollectionActivity._$_findCachedViewById(R.id.appbar)).getTotalScrollRange());
    }

    /* access modifiers changed from: private */
    /* renamed from: configureToolbarAndStatusBar$lambda-13  reason: not valid java name */
    public static final WindowInsetsCompat m10684configureToolbarAndStatusBar$lambda13(OfferCollectionActivity offerCollectionActivity, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        ViewGroup.LayoutParams layoutParams = ((Toolbar) offerCollectionActivity._$_findCachedViewById(R.id.toolbar)).getLayoutParams();
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsCompat.getSystemWindowInsetTop();
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleLoggedOutUser$lambda-11  reason: not valid java name */
    public static final void m10685handleLoggedOutUser$lambda11(OfferCollectionActivity offerCollectionActivity, View view) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        Navigator.Companion.navigate((Activity) offerCollectionActivity, new NavigatorModelForResult(LegacyTalabatActions.OPEN_LOGIN_SCREEN_ACTIVITY, (Bundle) null, OfferCollectionActivity$handleLoggedOutUser$1$1.INSTANCE, 999, 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleNotSubscribedUser$lambda-10  reason: not valid java name */
    public static final void m10686handleNotSubscribedUser$lambda10(OfferCollectionActivity offerCollectionActivity, View view) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        offerCollectionActivity.openSubscriptionDialog();
        offerCollectionActivity.getOfferCollectionViewModel().trackSubscriptionVerificationClicked();
        offerCollectionActivity.getOfferCollectionViewModel().trackSubscriptionVerificationStarted();
    }

    /* access modifiers changed from: private */
    public final void handleResendOTP(String str, String str2) {
        getOfferCollectionViewModel().resendMobileNumberOTP(str, str2, getConfigurationLocalRepository());
        getOfferCollectionViewModel().trackSubscriptionVerificationResend();
    }

    private final void inject() {
        DaggerOfferCollectionActivityComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m10687onCreate$lambda0(OfferCollectionActivity offerCollectionActivity, View view) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        offerCollectionActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m10688onCreate$lambda1(OfferCollectionActivity offerCollectionActivity, View view) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        offerCollectionActivity.finish();
    }

    private final void registerObservable() {
        getOfferCollectionViewModel().getHeaderViewData().observe(this, new e(this));
        getOfferCollectionViewModel().getVendors().observe(this, new f(this));
        getOfferCollectionViewModel().getBackgroundData().observe(this, new g(this));
        getOfferCollectionViewModel().getOfferSubscribed().observe(this, new h(this));
        getOfferCollectionViewModel().getOtpData().observe(this, new i(this));
        getOfferCollectionViewModel().getOtpVerification().observe(this, new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservable$lambda-3  reason: not valid java name */
    public static final void m10689registerObservable$lambda3(OfferCollectionActivity offerCollectionActivity, HeaderDisplayModel headerDisplayModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        if (headerDisplayModel != null) {
            HeaderDisplayModel.HeaderData headerData = (HeaderDisplayModel.HeaderData) headerDisplayModel;
            if (headerData.getCallToActionText() == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            offerCollectionActivity.bindData(headerData, z11);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.offering.presentation.displaymodel.HeaderDisplayModel.HeaderData");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservable$lambda-5  reason: not valid java name */
    public static final void m10690registerObservable$lambda5(OfferCollectionActivity offerCollectionActivity, VendorsDisplayModel vendorsDisplayModel) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        if (vendorsDisplayModel instanceof VendorsDisplayModel.ShowVendors) {
            VendorsDisplayModel.ShowVendors showVendors = (VendorsDisplayModel.ShowVendors) vendorsDisplayModel;
            offerCollectionActivity.getVendorsAdapter().setRestaurantListModel(showVendors.getRestaurantListModel(), 0);
            ((RecyclerView) offerCollectionActivity._$_findCachedViewById(R.id.vendorsRecyclerView)).setAdapter(offerCollectionActivity.getVendorsAdapter());
            offerCollectionActivity.getOfferCollectionViewModel().getRestaurantsListModel().setValue(showVendors.getRestaurantListModel());
        } else {
            boolean z11 = vendorsDisplayModel instanceof VendorsDisplayModel.ShowEmptyVendors;
        }
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) offerCollectionActivity._$_findCachedViewById(R.id.collectionShimmer);
        shimmerFrameLayout.stopShimmer();
        Intrinsics.checkNotNullExpressionValue(shimmerFrameLayout, "");
        ViewKt.invisible(shimmerFrameLayout);
        ImageView imageView = (ImageView) offerCollectionActivity._$_findCachedViewById(R.id.ivCloseShimmer);
        Intrinsics.checkNotNullExpressionValue(imageView, "ivCloseShimmer");
        ViewKt.invisible(imageView);
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservable$lambda-6  reason: not valid java name */
    public static final void m10691registerObservable$lambda6(OfferCollectionActivity offerCollectionActivity, HeaderDisplayModel headerDisplayModel) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        if (headerDisplayModel instanceof HeaderDisplayModel.BackgroundImage) {
            HeaderDisplayModel.BackgroundImage backgroundImage = (HeaderDisplayModel.BackgroundImage) headerDisplayModel;
            Glide.with((FragmentActivity) offerCollectionActivity).load(backgroundImage.getImageUrl()).into((ImageView) offerCollectionActivity._$_findCachedViewById(R.id.ivBackground));
            ((RequestBuilder) Glide.with((FragmentActivity) offerCollectionActivity).load(backgroundImage.getForegroundImage()).fitCenter()).into((ImageView) offerCollectionActivity._$_findCachedViewById(R.id.ivOfferLogos));
        } else if (headerDisplayModel instanceof HeaderDisplayModel.BackgroundColor) {
            HeaderDisplayModel.BackgroundColor backgroundColor = (HeaderDisplayModel.BackgroundColor) headerDisplayModel;
            ((ImageView) offerCollectionActivity._$_findCachedViewById(R.id.ivBackground)).setBackgroundColor(Color.parseColor(backgroundColor.getColor()));
            Glide.with((FragmentActivity) offerCollectionActivity).load(backgroundColor.getForegroundImage()).into((ImageView) offerCollectionActivity._$_findCachedViewById(R.id.ivOfferLogos));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservable$lambda-7  reason: not valid java name */
    public static final void m10692registerObservable$lambda7(OfferCollectionActivity offerCollectionActivity, UserSubscriptionDisplayModel userSubscriptionDisplayModel) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        if (userSubscriptionDisplayModel instanceof UserSubscriptionDisplayModel.UserSubscribed) {
            Button button = (Button) offerCollectionActivity._$_findCachedViewById(R.id.bCallToAction);
            Intrinsics.checkNotNullExpressionValue(button, "bCallToAction");
            ViewKt.invisible(button);
            offerCollectionActivity.getOfferCollectionViewModel().updateTelcoStatus(true);
        } else if (userSubscriptionDisplayModel instanceof UserSubscriptionDisplayModel.UserLoggedOut) {
            offerCollectionActivity.getOfferCollectionViewModel().updateTelcoStatus(false);
            offerCollectionActivity.handleLoggedOutUser();
        } else {
            offerCollectionActivity.getOfferCollectionViewModel().updateTelcoStatus(false);
            offerCollectionActivity.handleNotSubscribedUser();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservable$lambda-8  reason: not valid java name */
    public static final void m10693registerObservable$lambda8(OfferCollectionActivity offerCollectionActivity, OTPDisplayModel oTPDisplayModel) {
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        if (oTPDisplayModel instanceof OTPDisplayModel.OTPData) {
            OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog = offerCollectionActivity.subscriptionDialog;
            if (offerSubscriptionBottomSheetDialog != null) {
                offerSubscriptionBottomSheetDialog.hideError();
            }
            Intrinsics.checkNotNullExpressionValue(oTPDisplayModel, "it");
            offerCollectionActivity.openOTPVerificationDialog(oTPDisplayModel);
        } else if (oTPDisplayModel instanceof OTPDisplayModel.OTPFailData) {
            OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog2 = offerCollectionActivity.subscriptionDialog;
            if (offerSubscriptionBottomSheetDialog2 != null) {
                offerSubscriptionBottomSheetDialog2.showError(String.valueOf(((OTPDisplayModel.OTPFailData) oTPDisplayModel).getErrorMsg()));
            }
            offerCollectionActivity.getOfferCollectionViewModel().trackSubscriptionVerificationErrorShown(String.valueOf(((OTPDisplayModel.OTPFailData) oTPDisplayModel).getErrorMsg()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservable$lambda-9  reason: not valid java name */
    public static final void m10694registerObservable$lambda9(OfferCollectionActivity offerCollectionActivity, OTPDisplayModel oTPDisplayModel) {
        OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog;
        Intrinsics.checkNotNullParameter(offerCollectionActivity, "this$0");
        if (oTPDisplayModel instanceof OTPDisplayModel.OTPVerified) {
            offerCollectionActivity.showSuccessDialog();
        } else if ((oTPDisplayModel instanceof OTPDisplayModel.OTPFailData) && (offerSubscriptionVerifyBottomSheetDialog = offerCollectionActivity.subscriptionVerificationDialog) != null) {
            offerSubscriptionVerifyBottomSheetDialog.showError(String.valueOf(((OTPDisplayModel.OTPFailData) oTPDisplayModel).getErrorMsg()));
        }
    }

    /* access modifiers changed from: private */
    public final void verifyOTP(String str) {
        getOfferCollectionViewModel().verifyOTP(str);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void bindData(@NotNull HeaderDisplayModel.HeaderData headerData, boolean z11) {
        Intrinsics.checkNotNullParameter(headerData, "headerText");
        int i11 = R.id.tvOfferTitle;
        ((TextView) _$_findCachedViewById(i11)).setText(headerData.getHeaderText());
        int i12 = R.id.tvToolbarOfferTitle;
        ((TextView) _$_findCachedViewById(i12)).setText(headerData.getHeaderText());
        ((TextView) _$_findCachedViewById(R.id.tvOfferSubtitle)).setText(headerData.getSecondaryText());
        ((TextView) _$_findCachedViewById(i11)).setTextColor(Color.parseColor(headerData.getTextColor()));
        ((TextView) _$_findCachedViewById(i12)).setTextColor(Color.parseColor(headerData.getTextColor()));
        if (headerData.getShowTermsCondition()) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvTermsCondition);
            Intrinsics.checkNotNullExpressionValue(textView, "tvTermsCondition");
            ViewKt.visible(textView);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvTermsCondition);
            Intrinsics.checkNotNullExpressionValue(textView2, "tvTermsCondition");
            ViewKt.invisible(textView2);
        }
        if (z11) {
            Button button = (Button) _$_findCachedViewById(R.id.bCallToAction);
            Intrinsics.checkNotNullExpressionValue(button, "bCallToAction");
            ViewKt.invisible(button);
            return;
        }
        ((Button) _$_findCachedViewById(R.id.bCallToAction)).setText(headerData.getCallToActionText());
    }

    public final void checkVisibilityThreshold(int i11, int i12) {
        if (((double) (((float) Math.abs(i11)) / ((float) i12))) <= 0.855d) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvToolbarOfferTitle);
            Intrinsics.checkNotNullExpressionValue(textView, "tvToolbarOfferTitle");
            ViewKt.invisible(textView);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvToolbarOfferTitle);
            Intrinsics.checkNotNullExpressionValue(textView2, "tvToolbarOfferTitle");
            ViewKt.visible(textView2);
        }
        if (Math.abs(i11) == 0) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivOfferLogos);
            Intrinsics.checkNotNullExpressionValue(imageView, "ivOfferLogos");
            ViewKt.visible(imageView);
            return;
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.ivOfferLogos);
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivOfferLogos");
        ViewKt.invisible(imageView2);
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @VisibleForTesting
    public final void getOfferCollectionData() {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) _$_findCachedViewById(R.id.collectionShimmer);
        Intrinsics.checkNotNullExpressionValue(shimmerFrameLayout, "");
        ViewKt.visible(shimmerFrameLayout);
        shimmerFrameLayout.startShimmer();
        getOfferCollectionViewModel().getOfferCollectionData(OfferCollectionActivityKt.COLLECTION_ID, GlobalDataModel.RECENT_LATLONG.getLatitude(), GlobalDataModel.RECENT_LATLONG.getLongitude());
    }

    @NotNull
    public final OfferCollectionViewModel getOfferCollectionViewModel() {
        OfferCollectionViewModel offerCollectionViewModel2 = this.offerCollectionViewModel;
        if (offerCollectionViewModel2 != null) {
            return offerCollectionViewModel2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offerCollectionViewModel");
        return null;
    }

    @Nullable
    public final OfferSubscriptionBottomSheetDialog getSubscriptionDialog() {
        return this.subscriptionDialog;
    }

    @Nullable
    public final OfferSubscriptionVerifyBottomSheetDialog getSubscriptionVerificationDialog() {
        return this.subscriptionVerificationDialog;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public final RestaurantsListAdapter getVendorsAdapter() {
        RestaurantsListAdapter restaurantsListAdapter = this.vendorsAdapter;
        if (restaurantsListAdapter != null) {
            return restaurantsListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vendorsAdapter");
        return null;
    }

    public final void handleLoggedOutUser() {
        int i11 = R.id.bCallToAction;
        Button button = (Button) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(button, "bCallToAction");
        ViewKt.visible(button);
        ((Button) _$_findCachedViewById(i11)).setText(com.talabat.localization.R.string.login_to_subscribe);
        ((Button) _$_findCachedViewById(i11)).setOnClickListener(new k(this));
    }

    public final void handleNotSubscribedUser() {
        int i11 = R.id.bCallToAction;
        Button button = (Button) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(button, "bCallToAction");
        ViewKt.visible(button);
        ((Button) _$_findCachedViewById(i11)).setOnClickListener(new c(this));
    }

    public final void moveToMenu(int i11, int i12, boolean z11, boolean z12, boolean z13) {
        Navigator.Companion.navigate((Context) this, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, i11, i12, z11, z12, z13, false, (String) null, (Bundle) null, 224, (Object) null));
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 999) {
            getOfferCollectionData();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("OfferCollectionActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "OfferCollectionActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "OfferCollectionActivity#onCreate", (ArrayList<String>) null);
        }
        inject();
        super.onCreate(bundle);
        setContentView(R.layout.activity_offer_collection);
        int i11 = R.id.toolbar;
        ((Toolbar) _$_findCachedViewById(i11)).setNavigationOnClickListener(new l(this));
        ((Toolbar) _$_findCachedViewById(i11)).setNavigationIcon(com.talabat.talabatcommon.R.drawable.ic_m_back_white_bg);
        configureToolbarAndStatusBar();
        OfferCollectionActivityKt.COLLECTION_ID = getIntent().getIntExtra(COLLECTION_ID_PARAM, -1);
        setOfferCollectionViewModel(OfferCollectionViewModelFactory.Companion.create(this, getConfigurationLocalRepository()));
        setVendorsAdapter(new RestaurantsListAdapter(this, getTalabatFeatureFlag()));
        ((RecyclerView) _$_findCachedViewById(R.id.vendorsRecyclerView)).addItemDecoration(new FreshVerticalSpaceItemDecoration(getResources(), true));
        getVendorsAdapter().setOnRestaurantClickListener(this);
        registerObservable();
        getOfferCollectionData();
        ((ImageView) _$_findCachedViewById(R.id.ivCloseShimmer)).setOnClickListener(new b(this));
        TraceMachine.exitMethod();
    }

    public void onRestaurantClick(@NotNull Restaurant restaurant, int i11) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        restaurant.itemPosition = i11 + 1;
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        getOfferCollectionViewModel().sendShopClickedGA(restaurant);
        moveToMenu(restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated);
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void openOTPVerificationDialog(@NotNull OTPDisplayModel oTPDisplayModel) {
        Intrinsics.checkNotNullParameter(oTPDisplayModel, "otpDisplayModel");
        OTPDisplayModel.OTPData oTPData = (OTPDisplayModel.OTPData) oTPDisplayModel;
        OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog = this.subscriptionVerificationDialog;
        boolean z11 = false;
        if (offerSubscriptionVerifyBottomSheetDialog != null && offerSubscriptionVerifyBottomSheetDialog.isShown()) {
            z11 = true;
        }
        if (z11) {
            OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog2 = this.subscriptionVerificationDialog;
            if (offerSubscriptionVerifyBottomSheetDialog2 != null) {
                offerSubscriptionVerifyBottomSheetDialog2.updateResendOTP(oTPData);
                return;
            }
            return;
        }
        OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog3 = new OfferSubscriptionVerifyBottomSheetDialog(this, oTPData, new OfferCollectionActivity$openOTPVerificationDialog$1(this), new OfferCollectionActivity$openOTPVerificationDialog$2(this, oTPDisplayModel), new OfferCollectionActivity$openOTPVerificationDialog$3(this), new OfferCollectionActivity$openOTPVerificationDialog$4(this));
        this.subscriptionVerificationDialog = offerSubscriptionVerifyBottomSheetDialog3;
        offerSubscriptionVerifyBottomSheetDialog3.show();
    }

    public final void openSubscriptionDialog() {
        OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog = new OfferSubscriptionBottomSheetDialog(this, getOfferCollectionViewModel().getPopupData().getValue(), getConfigurationLocalRepository(), new OfferCollectionActivity$openSubscriptionDialog$1(this), new OfferCollectionActivity$openSubscriptionDialog$2(this));
        this.subscriptionDialog = offerSubscriptionBottomSheetDialog;
        offerSubscriptionBottomSheetDialog.show();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setOfferCollectionViewModel(@NotNull OfferCollectionViewModel offerCollectionViewModel2) {
        Intrinsics.checkNotNullParameter(offerCollectionViewModel2, "<set-?>");
        this.offerCollectionViewModel = offerCollectionViewModel2;
    }

    public final void setSubscriptionDialog(@Nullable OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog) {
        this.subscriptionDialog = offerSubscriptionBottomSheetDialog;
    }

    public final void setSubscriptionVerificationDialog(@Nullable OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog) {
        this.subscriptionVerificationDialog = offerSubscriptionVerifyBottomSheetDialog;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setVendorsAdapter(@NotNull RestaurantsListAdapter restaurantsListAdapter) {
        Intrinsics.checkNotNullParameter(restaurantsListAdapter, "<set-?>");
        this.vendorsAdapter = restaurantsListAdapter;
    }

    public final void showSuccessDialog() {
        OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog = this.subscriptionDialog;
        if (offerSubscriptionBottomSheetDialog != null) {
            offerSubscriptionBottomSheetDialog.hide();
        }
        OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog = this.subscriptionVerificationDialog;
        if (offerSubscriptionVerifyBottomSheetDialog != null) {
            offerSubscriptionVerifyBottomSheetDialog.hide();
        }
        new OfferSuccessBottomSheetDialog(this, new OfferCollectionActivity$showSuccessDialog$1(this)).show();
        getOfferCollectionViewModel().trackSubscriptionVerificationValidated();
    }
}
