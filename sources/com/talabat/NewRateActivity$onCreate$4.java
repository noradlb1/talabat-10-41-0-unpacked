package com.talabat;

import androidx.viewpager.widget.ViewPager;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/talabat/NewRateActivity$onCreate$4", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "p0", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRateActivity$onCreate$4 implements ViewPager.OnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewRateActivity f54438b;

    public NewRateActivity$onCreate$4(NewRateActivity newRateActivity) {
        this.f54438b = newRateActivity;
    }

    public void onPageScrollStateChanged(int i11) {
        LogManager.debug("onPageScrollStateChanged: " + i11);
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        LogManager.debug("onPageScrolled: " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + f11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: com.talabat.adapters.RatePagerAdapter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageSelected(int r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onPageSelected: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.talabat.talabatcore.logger.LogManager.debug(r0)
            java.lang.String r0 = "getString(com.talabat.lo…n.R.string.rate_continue)"
            r1 = 2132019642(0x7f1409ba, float:1.9677625E38)
            r2 = 0
            java.lang.String r3 = "null cannot be cast to non-null type androidx.fragment.app.Fragment"
            r4 = 0
            if (r9 == 0) goto L_0x0142
            r5 = 0
            r6 = 1
            if (r9 == r6) goto L_0x00e9
            r0 = 2
            if (r9 == r0) goto L_0x0062
            com.talabat.NewRateActivity r9 = r8.f54438b
            int r0 = com.talabat.R.id.viewPager
            android.view.View r9 = r9._$_findCachedViewById(r0)
            com.talabat.designhelpers.WrappingViewPager r9 = (com.talabat.designhelpers.WrappingViewPager) r9
            androidx.viewpager.widget.PagerAdapter r9 = r9.getAdapter()
            if (r9 == 0) goto L_0x0043
            com.talabat.NewRateActivity r1 = r8.f54438b
            android.view.View r0 = r1._$_findCachedViewById(r0)
            com.talabat.designhelpers.WrappingViewPager r0 = (com.talabat.designhelpers.WrappingViewPager) r0
            r1 = 3
            java.lang.Object r4 = r9.instantiateItem((android.view.ViewGroup) r0, (int) r1)
        L_0x0043:
            if (r4 == 0) goto L_0x005c
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            boolean r9 = r4 instanceof com.talabat.fragments.RateCompleteFragment
            if (r9 == 0) goto L_0x0181
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.hideBackButton()
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.hideButton()
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.showFinishButton()
            goto L_0x0181
        L_0x005c:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r3)
            throw r9
        L_0x0062:
            com.talabat.NewRateActivity r9 = r8.f54438b
            int r1 = com.talabat.R.id.viewPager
            android.view.View r9 = r9._$_findCachedViewById(r1)
            com.talabat.designhelpers.WrappingViewPager r9 = (com.talabat.designhelpers.WrappingViewPager) r9
            androidx.viewpager.widget.PagerAdapter r9 = r9.getAdapter()
            if (r9 == 0) goto L_0x007f
            com.talabat.NewRateActivity r2 = r8.f54438b
            android.view.View r1 = r2._$_findCachedViewById(r1)
            com.talabat.designhelpers.WrappingViewPager r1 = (com.talabat.designhelpers.WrappingViewPager) r1
            java.lang.Object r9 = r9.instantiateItem((android.view.ViewGroup) r1, (int) r0)
            goto L_0x0080
        L_0x007f:
            r9 = r4
        L_0x0080:
            if (r9 == 0) goto L_0x00e3
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            boolean r0 = r9 instanceof com.talabat.fragments.RateFeedbackFragment
            if (r0 == 0) goto L_0x0181
            com.talabat.NewRateActivity r0 = r8.f54438b
            r0.enableContinueButton()
            com.talabat.fragments.RateFeedbackFragment r9 = (com.talabat.fragments.RateFeedbackFragment) r9
            com.talabat.NewRateActivity r0 = r8.f54438b
            com.talabat.adapters.RatePagerAdapter r0 = r0.adapter
            java.lang.String r1 = "adapter"
            if (r0 != 0) goto L_0x009d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r4
        L_0x009d:
            java.lang.String r0 = r0.getVendorRating()
            if (r0 == 0) goto L_0x00a8
            float r0 = java.lang.Float.parseFloat(r0)
            goto L_0x00a9
        L_0x00a8:
            r0 = r5
        L_0x00a9:
            r9.setRestaurantRate(r0)
            com.talabat.NewRateActivity r0 = r8.f54438b
            com.talabat.adapters.RatePagerAdapter r0 = r0.adapter
            if (r0 != 0) goto L_0x00b8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x00b9
        L_0x00b8:
            r4 = r0
        L_0x00b9:
            java.lang.String r0 = r4.getDeliveryRate()
            if (r0 == 0) goto L_0x00c3
            float r5 = java.lang.Float.parseFloat(r0)
        L_0x00c3:
            r9.setDeliveryRate(r5)
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.hideFinishButton()
            com.talabat.NewRateActivity r9 = r8.f54438b
            r0 = 2132019651(0x7f1409c3, float:1.9677643E38)
            java.lang.String r0 = r9.getString(r0)
            java.lang.String r1 = "getString(com.talabat.lo…ion.R.string.rate_submit)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9.showButton(r0)
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.showBackButton()
            goto L_0x0181
        L_0x00e3:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r3)
            throw r9
        L_0x00e9:
            com.talabat.NewRateActivity r9 = r8.f54438b
            int r7 = com.talabat.R.id.viewPager
            android.view.View r9 = r9._$_findCachedViewById(r7)
            com.talabat.designhelpers.WrappingViewPager r9 = (com.talabat.designhelpers.WrappingViewPager) r9
            androidx.viewpager.widget.PagerAdapter r9 = r9.getAdapter()
            if (r9 == 0) goto L_0x0105
            com.talabat.NewRateActivity r4 = r8.f54438b
            android.view.View r4 = r4._$_findCachedViewById(r7)
            com.talabat.designhelpers.WrappingViewPager r4 = (com.talabat.designhelpers.WrappingViewPager) r4
            java.lang.Object r4 = r9.instantiateItem((android.view.ViewGroup) r4, (int) r6)
        L_0x0105:
            if (r4 == 0) goto L_0x013c
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            boolean r9 = r4 instanceof com.talabat.fragments.RateDeliveryFragment
            if (r9 == 0) goto L_0x0181
            com.talabat.fragments.RateDeliveryFragment r4 = (com.talabat.fragments.RateDeliveryFragment) r4
            float r9 = r4.getRate()
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0118
            r2 = r6
        L_0x0118:
            if (r2 != 0) goto L_0x0120
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.enableContinueButton()
            goto L_0x0125
        L_0x0120:
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.disableContinueButton()
        L_0x0125:
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.showBackButton()
            com.talabat.NewRateActivity r9 = r8.f54438b
            java.lang.String r1 = r9.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r9.showButton(r1)
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.hideFinishButton()
            goto L_0x0181
        L_0x013c:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r3)
            throw r9
        L_0x0142:
            com.talabat.NewRateActivity r9 = r8.f54438b
            int r5 = com.talabat.R.id.viewPager
            android.view.View r9 = r9._$_findCachedViewById(r5)
            com.talabat.designhelpers.WrappingViewPager r9 = (com.talabat.designhelpers.WrappingViewPager) r9
            androidx.viewpager.widget.PagerAdapter r9 = r9.getAdapter()
            if (r9 == 0) goto L_0x015e
            com.talabat.NewRateActivity r4 = r8.f54438b
            android.view.View r4 = r4._$_findCachedViewById(r5)
            com.talabat.designhelpers.WrappingViewPager r4 = (com.talabat.designhelpers.WrappingViewPager) r4
            java.lang.Object r4 = r9.instantiateItem((android.view.ViewGroup) r4, (int) r2)
        L_0x015e:
            if (r4 == 0) goto L_0x0182
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            boolean r9 = r4 instanceof com.talabat.fragments.RateRestaurantFragment
            if (r9 == 0) goto L_0x0181
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.hideBackButton()
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.hideFinishButton()
            com.talabat.NewRateActivity r9 = r8.f54438b
            java.lang.String r1 = r9.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r9.showButton(r1)
            com.talabat.NewRateActivity r9 = r8.f54438b
            r9.enableContinueButton()
        L_0x0181:
            return
        L_0x0182:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.NewRateActivity$onCreate$4.onPageSelected(int):void");
    }
}
