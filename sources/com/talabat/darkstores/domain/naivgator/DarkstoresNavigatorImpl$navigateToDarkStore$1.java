package com.talabat.darkstores.domain.naivgator;

import android.app.Activity;
import android.content.Intent;
import buisnessmodels.Cart;
import com.talabat.core.navigation.domain.screen.darkstores.DarkstoresScreen;
import com.talabat.darkstores.feature.Darkstores;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresNavigatorImpl$navigateToDarkStore$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Restaurant f56221g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DarkstoresNavigatorImpl f56222h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f56223i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f56224j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f56225k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f56226l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f56227m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f56228n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f56229o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ String f56230p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ DarkstoresTrackingData f56231q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Activity f56232r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresNavigatorImpl$navigateToDarkStore$1(Restaurant restaurant, DarkstoresNavigatorImpl darkstoresNavigatorImpl, Integer num, String str, String str2, String str3, String str4, String str5, boolean z11, String str6, DarkstoresTrackingData darkstoresTrackingData, Activity activity) {
        super(1);
        this.f56221g = restaurant;
        this.f56222h = darkstoresNavigatorImpl;
        this.f56223i = num;
        this.f56224j = str;
        this.f56225k = str2;
        this.f56226l = str3;
        this.f56227m = str4;
        this.f56228n = str5;
        this.f56229o = z11;
        this.f56230p = str6;
        this.f56231q = darkstoresTrackingData;
        this.f56232r = activity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        String str;
        String str2;
        String str3;
        String str4;
        if (!z11) {
            Cart instance = Cart.getInstance();
            GlobalDataModel.SELECTED.updateRestaurant(this.f56221g);
            int countryId = this.f56222h.configurationLocalRepository.selectedCountry().getCountryId();
            Integer num = this.f56223i;
            int intValue = num != null ? num.intValue() : 0;
            String str5 = this.f56224j;
            String str6 = str5 == null ? "" : str5;
            String str7 = this.f56225k;
            if (str7 == null) {
                str = "";
            } else {
                str = str7;
            }
            String str8 = this.f56226l;
            if (str8 == null) {
                str2 = "";
            } else {
                str2 = str8;
            }
            boolean isShouldEmptyDarkstroresCart = instance.isShouldEmptyDarkstroresCart();
            String str9 = this.f56227m;
            if (str9 == null) {
                str3 = "";
            } else {
                str3 = str9;
            }
            String str10 = this.f56228n;
            if (str10 == null) {
                str4 = "";
            } else {
                str4 = str10;
            }
            final Darkstores.Config access$createConfig = this.f56222h.createConfig(this.f56221g, countryId, this.f56229o, isShouldEmptyDarkstroresCart, intValue, str6, str, str2, this.f56230p, str3, str4, this.f56231q);
            instance.setShouldEmptyDarkstroresCart(false);
            this.f56222h.navigator.navigateTo(this.f56232r, new DarkstoresScreen((Void) null, 1, (DefaultConstructorMarker) null), new Function1<Intent, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Intent) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Intent intent) {
                    Intrinsics.checkNotNullParameter(intent, "$this$navigateTo");
                    intent.putExtra(DarkstoresMainActivity.CONFIG_EXTRA_KEY, access$createConfig);
                }
            });
        }
    }
}
