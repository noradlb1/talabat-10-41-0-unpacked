package com.talabat;

import JsonModels.Response.rateOrders.RateReason;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_button.DSSecondaryButton;
import com.designsystem.ds_button.DSTertiaryButton;
import com.talabat.adapters.RatePagerAdapter;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.designhelpers.WrappingViewPager;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.rating.domain.repo.RatingSession;
import com.talabat.helpers.TalabatBase;
import datamodels.RateOrderReq;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.newrate.INewRatePresenter;
import library.talabat.mvp.newrate.INewRateView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.IAppTracker;
import tracking.ScreenNames;
import ue.eb;
import ue.fb;
import ue.gb;
import ue.hb;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\u0012\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u00020\u001eH\u0016J\u0018\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0018H\u0016J\b\u00107\u001a\u00020\u001eH\u0002J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020\u001eH\u0016J\b\u0010;\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX.¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/talabat/NewRateActivity;", "Lcom/talabat/helpers/TalabatBase;", "Llibrary/talabat/mvp/newrate/INewRateView;", "Lcom/talabat/adapters/RatePagerAdapter$RatingFragmentCallbacksListener;", "()V", "adapter", "Lcom/talabat/adapters/RatePagerAdapter;", "appTracker", "Ltracking/IAppTracker;", "deliveryExperienceRatingTitle", "", "deliveryRateReasons", "Ljava/util/ArrayList;", "LJsonModels/Response/rateOrders/RateReason;", "Lkotlin/collections/ArrayList;", "encryptedOrderId", "orderId", "presenter", "Llibrary/talabat/mvp/newrate/INewRatePresenter;", "ratingSession", "Lcom/talabat/feature/rating/domain/repo/RatingSession;", "restaurantId", "restaurantName", "restaurantRate", "", "showReasons", "", "vendorExperienceRatingTitle", "vendorRateReasons", "destroyPresenter", "", "disableContinueButton", "enableContinueButton", "getPresenter", "Llibrary/talabat/mvp/IGlobalPresenter;", "getScreenName", "hideBackButton", "hideButton", "hideContinueContainer", "hideFinishButton", "hideKeyboardFrom", "view", "Landroid/view/View;", "onAuthError", "onBackClicked", "onCloseClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "rateFailed", "rateSucceded", "transactionId", "", "totalRating", "showBackButton", "showButton", "text", "showContinueContainer", "showFinishButton", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRateActivity extends TalabatBase implements INewRateView, RatePagerAdapter.RatingFragmentCallbacksListener {
    @NotNull
    public static final String BRANCH_ID = "branchId";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DELIVERY_EXPERIENCE_RATING_TITLE = "deliveryExperienceRatingTitle";
    @NotNull
    public static final String DELIVERY_RATE_REASONS = "driverReasons";
    @NotNull
    public static final String ENCRYPTED_ORDER_ID = "encryptedOrderId";
    @NotNull
    public static final String NAME = "name";
    @NotNull
    public static final String ORDER_ID = "orderId";
    @NotNull
    public static final String RATE = "rate";
    public static final int RATE_DELIVERY_STEP = 1;
    public static final int RATE_FURTHER_FEEDBACK_STEP = 2;
    public static final int RATE_THANK_YOU_STEP = 3;
    public static final int RATE_VENDOR_STEP = 0;
    @NotNull
    public static final String SHOW_REASONS = "showReasons";
    public static final int TOTAL_RATING_STEPS = 4;
    @NotNull
    public static final String VENDOR_EXPERIENCE_RATING_TITLE = "vendorExperienceRatingTitle";
    @NotNull
    public static final String VENDOR_RATE_REASONS = "rateReasons";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public RatePagerAdapter adapter;
    private IAppTracker appTracker;
    private String deliveryExperienceRatingTitle;
    private ArrayList<RateReason> deliveryRateReasons;
    private String encryptedOrderId;
    private String orderId;
    private INewRatePresenter presenter;
    private RatingSession ratingSession;
    private String restaurantId;
    private String restaurantName;
    private float restaurantRate;
    private boolean showReasons;
    private String vendorExperienceRatingTitle;
    private ArrayList<RateReason> vendorRateReasons;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/NewRateActivity$Companion;", "", "()V", "BRANCH_ID", "", "DELIVERY_EXPERIENCE_RATING_TITLE", "DELIVERY_RATE_REASONS", "ENCRYPTED_ORDER_ID", "NAME", "ORDER_ID", "RATE", "RATE_DELIVERY_STEP", "", "RATE_FURTHER_FEEDBACK_STEP", "RATE_THANK_YOU_STEP", "RATE_VENDOR_STEP", "SHOW_REASONS", "TOTAL_RATING_STEPS", "VENDOR_EXPERIENCE_RATING_TITLE", "VENDOR_RATE_REASONS", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void hideBackButton() {
        ((DSSecondaryButton) _$_findCachedViewById(R.id.button_back)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void hideButton() {
        ((DSPrimaryButton) _$_findCachedViewById(R.id.button_submit)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void hideFinishButton() {
        ((DSTertiaryButton) _$_findCachedViewById(R.id.button_finish)).setVisibility(8);
    }

    private final void hideKeyboardFrom(View view) {
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    /* access modifiers changed from: private */
    /* renamed from: onBackClicked$lambda-3  reason: not valid java name */
    public static final void m9484onBackClicked$lambda3(NewRateActivity newRateActivity) {
        Intrinsics.checkNotNullParameter(newRateActivity, "this$0");
        System.out.println("onBackPerformed");
        int i11 = R.id.viewPager;
        ((WrappingViewPager) newRateActivity._$_findCachedViewById(i11)).setCurrentItem(((WrappingViewPager) newRateActivity._$_findCachedViewById(i11)).getCurrentItem() - 1, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9485onCreate$lambda0(com.talabat.NewRateActivity r10, android.view.View r11) {
        /*
            java.lang.String r11 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            int r11 = com.talabat.R.id.viewPager
            android.view.View r0 = r10._$_findCachedViewById(r11)
            com.talabat.designhelpers.WrappingViewPager r0 = (com.talabat.designhelpers.WrappingViewPager) r0
            int r0 = r0.getCurrentItem()
            r1 = 1
            if (r0 == 0) goto L_0x00c1
            r2 = 0
            if (r0 == r1) goto L_0x007b
            r11 = 2
            if (r0 == r11) goto L_0x001d
            goto L_0x00d5
        L_0x001d:
            r10.startLodingPopup()
            library.talabat.mvp.newrate.INewRatePresenter r11 = r10.presenter
            if (r11 != 0) goto L_0x002b
            java.lang.String r11 = "presenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r3 = r2
            goto L_0x002c
        L_0x002b:
            r3 = r11
        L_0x002c:
            java.lang.String r11 = r10.encryptedOrderId
            if (r11 != 0) goto L_0x0037
            java.lang.String r11 = "encryptedOrderId"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r4 = r2
            goto L_0x0038
        L_0x0037:
            r4 = r11
        L_0x0038:
            com.talabat.adapters.RatePagerAdapter r11 = r10.adapter
            java.lang.String r0 = "adapter"
            if (r11 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r11 = r2
        L_0x0042:
            java.lang.String r5 = r11.getVendorRating()
            com.talabat.adapters.RatePagerAdapter r11 = r10.adapter
            if (r11 != 0) goto L_0x004e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r11 = r2
        L_0x004e:
            java.lang.String r6 = r11.getDeliveryRate()
            com.talabat.adapters.RatePagerAdapter r11 = r10.adapter
            if (r11 != 0) goto L_0x005a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r11 = r2
        L_0x005a:
            java.lang.String r7 = r11.getReview()
            com.talabat.adapters.RatePagerAdapter r11 = r10.adapter
            if (r11 != 0) goto L_0x0066
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r11 = r2
        L_0x0066:
            java.util.ArrayList r8 = r11.getRestaurantsReasons()
            com.talabat.adapters.RatePagerAdapter r10 = r10.adapter
            if (r10 != 0) goto L_0x0072
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0073
        L_0x0072:
            r2 = r10
        L_0x0073:
            java.util.ArrayList r9 = r2.getDeliveryReason()
            r3.submitRate(r4, r5, r6, r7, r8, r9)
            goto L_0x00d5
        L_0x007b:
            android.view.View r0 = r10._$_findCachedViewById(r11)
            com.talabat.designhelpers.WrappingViewPager r0 = (com.talabat.designhelpers.WrappingViewPager) r0
            androidx.viewpager.widget.PagerAdapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x0091
            android.view.View r2 = r10._$_findCachedViewById(r11)
            com.talabat.designhelpers.WrappingViewPager r2 = (com.talabat.designhelpers.WrappingViewPager) r2
            java.lang.Object r2 = r0.instantiateItem((android.view.ViewGroup) r2, (int) r1)
        L_0x0091:
            if (r2 == 0) goto L_0x00b9
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            boolean r0 = r2 instanceof com.talabat.fragments.RateDeliveryFragment
            if (r0 == 0) goto L_0x00d5
            com.talabat.fragments.RateDeliveryFragment r2 = (com.talabat.fragments.RateDeliveryFragment) r2
            float r0 = r2.getRate()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d5
            android.view.View r0 = r10._$_findCachedViewById(r11)
            com.talabat.designhelpers.WrappingViewPager r0 = (com.talabat.designhelpers.WrappingViewPager) r0
            android.view.View r10 = r10._$_findCachedViewById(r11)
            com.talabat.designhelpers.WrappingViewPager r10 = (com.talabat.designhelpers.WrappingViewPager) r10
            int r10 = r10.getCurrentItem()
            int r10 = r10 + r1
            r0.setCurrentItem(r10, r1)
            goto L_0x00d5
        L_0x00b9:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r11 = "null cannot be cast to non-null type androidx.fragment.app.Fragment"
            r10.<init>(r11)
            throw r10
        L_0x00c1:
            android.view.View r0 = r10._$_findCachedViewById(r11)
            com.talabat.designhelpers.WrappingViewPager r0 = (com.talabat.designhelpers.WrappingViewPager) r0
            android.view.View r10 = r10._$_findCachedViewById(r11)
            com.talabat.designhelpers.WrappingViewPager r10 = (com.talabat.designhelpers.WrappingViewPager) r10
            int r10 = r10.getCurrentItem()
            int r10 = r10 + r1
            r0.setCurrentItem(r10, r1)
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.NewRateActivity.m9485onCreate$lambda0(com.talabat.NewRateActivity, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m9486onCreate$lambda1(NewRateActivity newRateActivity, View view) {
        Intrinsics.checkNotNullParameter(newRateActivity, "this$0");
        newRateActivity.onBackClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m9487onCreate$lambda2(NewRateActivity newRateActivity, View view) {
        Intrinsics.checkNotNullParameter(newRateActivity, "this$0");
        newRateActivity.onCloseClicked();
    }

    /* access modifiers changed from: private */
    public final void showBackButton() {
        int i11 = R.id.button_back;
        ((DSSecondaryButton) _$_findCachedViewById(i11)).setVisibility(0);
        ((DSSecondaryButton) _$_findCachedViewById(i11)).setDsIsEnabled(true);
        ((DSSecondaryButton) _$_findCachedViewById(i11)).setActivated(true);
        ((DSSecondaryButton) _$_findCachedViewById(i11)).setEnabled(true);
    }

    /* access modifiers changed from: private */
    public final void showButton(String str) {
        int i11 = R.id.button_submit;
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setCenterText(str);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showFinishButton() {
        ((DSTertiaryButton) _$_findCachedViewById(R.id.button_finish)).setVisibility(0);
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

    public void destroyPresenter() {
    }

    public void disableContinueButton() {
        int i11 = R.id.button_submit;
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setDsIsEnabled(false);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setActivated(false);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setEnabled(false);
    }

    public void enableContinueButton() {
        int i11 = R.id.button_submit;
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setDsIsEnabled(true);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setActivated(true);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setEnabled(true);
    }

    @Nullable
    public IGlobalPresenter getPresenter() {
        return null;
    }

    @NotNull
    public String getScreenName() {
        return ScreenNames.NEW_RATE_SCREEN;
    }

    public void hideContinueContainer() {
        ((LinearLayout) _$_findCachedViewById(R.id.continue_container)).setVisibility(8);
        int i11 = R.id.viewPager;
        ViewGroup.LayoutParams layoutParams = ((WrappingViewPager) _$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(12);
            ((WrappingViewPager) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public void onAuthError() {
    }

    public void onBackClicked() {
        WrappingViewPager wrappingViewPager = (WrappingViewPager) _$_findCachedViewById(R.id.viewPager);
        Intrinsics.checkNotNullExpressionValue(wrappingViewPager, "viewPager");
        hideKeyboardFrom(wrappingViewPager);
        new Handler().postDelayed(new eb(this), 150);
    }

    public void onCloseClicked() {
        String str = null;
        if (((WrappingViewPager) _$_findCachedViewById(R.id.viewPager)).getCurrentItem() == 3) {
            Intent intent = new Intent();
            String str2 = this.orderId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderId");
                str2 = null;
            }
            intent.putExtra("orderId", str2);
            setResult(-1, intent);
            finish();
        } else {
            finish();
        }
        RatingSession ratingSession2 = this.ratingSession;
        if (ratingSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingSession");
            ratingSession2 = null;
        }
        String str3 = this.encryptedOrderId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("encryptedOrderId");
        } else {
            str = str3;
        }
        ratingSession2.setRatingDismissed(true, str);
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        ArrayList<RateReason> arrayList;
        ArrayList<RateReason> arrayList2;
        String str2;
        String str3;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_new_rate);
        this.ratingSession = ((RatingFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(RatingFeatureApi.class)).getRatingSession();
        getWindow().setLayout(-1, -1);
        String stringExtra = getIntent().getStringExtra("orderId");
        String str4 = "";
        if (stringExtra == null) {
            stringExtra = str4;
        }
        this.orderId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("encryptedOrderId");
        if (stringExtra2 == null) {
            stringExtra2 = str4;
        }
        this.encryptedOrderId = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("name");
        if (stringExtra3 == null) {
            stringExtra3 = str4;
        }
        this.restaurantName = stringExtra3;
        boolean z11 = false;
        this.restaurantId = String.valueOf(getIntent().getIntExtra("branchId", 0));
        this.restaurantRate = getIntent().getFloatExtra(RATE, 0.0f);
        ArrayList<RateReason> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(DELIVERY_RATE_REASONS);
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = new ArrayList<>();
        }
        this.deliveryRateReasons = parcelableArrayListExtra;
        ArrayList<RateReason> parcelableArrayListExtra2 = getIntent().getParcelableArrayListExtra(VENDOR_RATE_REASONS);
        if (parcelableArrayListExtra2 == null) {
            parcelableArrayListExtra2 = new ArrayList<>();
        }
        this.vendorRateReasons = parcelableArrayListExtra2;
        String stringExtra4 = getIntent().getStringExtra(VENDOR_EXPERIENCE_RATING_TITLE);
        if (stringExtra4 == null) {
            stringExtra4 = str4;
        }
        this.vendorExperienceRatingTitle = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra(DELIVERY_EXPERIENCE_RATING_TITLE);
        if (stringExtra5 != null) {
            str4 = stringExtra5;
        }
        this.deliveryExperienceRatingTitle = str4;
        this.showReasons = getIntent().getBooleanExtra(SHOW_REASONS, false);
        this.presenter = NewRateActivityDependencyProvider.getNewRatePresenter(this);
        this.appTracker = NewRateActivityDependencyProvider.getTracker();
        ((DSPrimaryButton) _$_findCachedViewById(R.id.button_submit)).setOnClickListener(new fb(this));
        ((DSSecondaryButton) _$_findCachedViewById(R.id.button_back)).setOnClickListener(new gb(this));
        ((DSTertiaryButton) _$_findCachedViewById(R.id.button_finish)).setOnClickListener(new hb(this));
        int i11 = R.id.viewPager;
        ((WrappingViewPager) _$_findCachedViewById(i11)).setOffscreenPageLimit(3);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        String str5 = this.restaurantName;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantName");
            str = null;
        } else {
            str = str5;
        }
        int intExtra = getIntent().getIntExtra("id", 0);
        float f11 = this.restaurantRate;
        ArrayList<RateReason> arrayList3 = this.vendorRateReasons;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vendorRateReasons");
            arrayList = null;
        } else {
            arrayList = arrayList3;
        }
        ArrayList<RateReason> arrayList4 = this.deliveryRateReasons;
        if (arrayList4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryRateReasons");
            arrayList2 = null;
        } else {
            arrayList2 = arrayList4;
        }
        String str6 = this.vendorExperienceRatingTitle;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VENDOR_EXPERIENCE_RATING_TITLE);
            str2 = null;
        } else {
            str2 = str6;
        }
        String str7 = this.deliveryExperienceRatingTitle;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DELIVERY_EXPERIENCE_RATING_TITLE);
            str3 = null;
        } else {
            str3 = str7;
        }
        this.adapter = new RatePagerAdapter(this, supportFragmentManager, str, intExtra, f11, arrayList, arrayList2, str2, str3, this.showReasons);
        WrappingViewPager wrappingViewPager = (WrappingViewPager) _$_findCachedViewById(i11);
        RatePagerAdapter ratePagerAdapter = this.adapter;
        if (ratePagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            ratePagerAdapter = null;
        }
        wrappingViewPager.setAdapter(ratePagerAdapter);
        ((WrappingViewPager) _$_findCachedViewById(i11)).addOnPageChangeListener(new NewRateActivity$onCreate$4(this));
        if (this.restaurantRate == 0.0f) {
            z11 = true;
        }
        if (z11) {
            hideContinueContainer();
        }
    }

    public void onError() {
    }

    public void rateFailed() {
        stopLodingPopup();
        finish();
    }

    public void rateSucceded(int i11, float f11) {
        IAppTracker iAppTracker;
        stopLodingPopup();
        RateOrderReq rateOrderReq = new RateOrderReq();
        String str = this.encryptedOrderId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("encryptedOrderId");
            str = null;
        }
        rateOrderReq.ordId = str;
        String str3 = this.restaurantName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantName");
            str3 = null;
        }
        rateOrderReq.restName = str3;
        String str4 = this.restaurantId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantId");
            str4 = null;
        }
        rateOrderReq.restId = str4;
        rateOrderReq.totalRating = f11;
        IAppTracker iAppTracker2 = this.appTracker;
        if (iAppTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appTracker");
            iAppTracker = null;
        } else {
            iAppTracker = iAppTracker2;
        }
        String str5 = this.orderId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderId");
            str5 = null;
        }
        String str6 = this.restaurantId;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantId");
        } else {
            str2 = str6;
        }
        iAppTracker.onOrderRating(this, rateOrderReq, str5, Integer.parseInt(str2), i11, true);
        ((WrappingViewPager) _$_findCachedViewById(R.id.viewPager)).setCurrentItem(4);
    }

    public void showContinueContainer() {
        ((LinearLayout) _$_findCachedViewById(R.id.continue_container)).setVisibility(0);
        int i11 = R.id.viewPager;
        ViewGroup.LayoutParams layoutParams = ((WrappingViewPager) _$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.removeRule(12);
            layoutParams2.addRule(2, R.id.continue_container);
            ((WrappingViewPager) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
}
