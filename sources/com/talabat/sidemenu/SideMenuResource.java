package com.talabat.sidemenu;

import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020/H\u0007J\u0018\u00104\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00105\u001a\u000200H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R>\u0010+\u001a2\u0012\u0004\u0012\u00020\u0004\u0012(\u0012&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020(0.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020(0.0-0,X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/talabat/sidemenu/SideMenuResource;", "", "()V", "ABOUT", "", "ACCOUNT_INFO", "BIRTHDAY", "CAMPAIGN", "CART", "COUPON", "CREDIT_STATEMENT", "FAQ", "FEEDBACK", "GIFT_VOUCHER", "HOME", "INSTAGRAM", "LIVE_SUPPORT", "LOG_OUT", "MY_ACCOUNT", "MY_ADDRESS", "NEW_RESTAURANTS", "NOTIFICATIONS", "OFFERS", "ORDERS", "PAY_LATER", "PROMOTION", "QUICK_FIND", "RECOMMEND_FRIEND", "REDEMPTION", "REF_REFER_A_FRIEND", "REVIEWS", "REWARDS", "SETTINGS", "SHARE", "SOCIAL", "SUBSCRIPTIONS", "TALABAT_CREDIT", "TERMS_AND_CONDITIONS", "TWITTER", "UNSUPPORTED_RESOURCE_ID", "", "VOUCHERS", "YOUTUBE", "resourceMap", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/talabat/configuration/country/Country;", "getIconResource", "ref", "useDesignSystem", "getStringResource", "country", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuResource {
    @NotNull
    private static final String ABOUT = "about";
    @NotNull
    private static final String ACCOUNT_INFO = "accountinfo";
    @NotNull
    private static final String BIRTHDAY = "birthday";
    @NotNull
    private static final String CAMPAIGN = "campaign";
    @NotNull
    private static final String CART = "cart";
    @NotNull
    private static final String COUPON = "coupon";
    @NotNull
    private static final String CREDIT_STATEMENT = "creditstatement";
    @NotNull
    private static final String FAQ = "faq";
    @NotNull
    private static final String FEEDBACK = "feedback";
    @NotNull
    private static final String GIFT_VOUCHER = "giftvoucher";
    @NotNull
    private static final String HOME = "home";
    @NotNull
    private static final String INSTAGRAM = "instagram";
    @NotNull
    public static final SideMenuResource INSTANCE = new SideMenuResource();
    @NotNull
    private static final String LIVE_SUPPORT = "livesupport";
    @NotNull
    private static final String LOG_OUT = "logout";
    @NotNull
    private static final String MY_ACCOUNT = "myaccount";
    @NotNull
    private static final String MY_ADDRESS = "myaddress";
    @NotNull
    private static final String NEW_RESTAURANTS = "newrestaurants";
    @NotNull
    private static final String NOTIFICATIONS = "notifications";
    @NotNull
    private static final String OFFERS = "offers";
    @NotNull
    private static final String ORDERS = "orders";
    @NotNull
    private static final String PAY_LATER = "paylater";
    @NotNull
    private static final String PROMOTION = "promotion";
    @NotNull
    private static final String QUICK_FIND = "quickfind";
    @NotNull
    private static final String RECOMMEND_FRIEND = "recommendfriend";
    @NotNull
    private static final String REDEMPTION = "redemption";
    @NotNull
    public static final String REF_REFER_A_FRIEND = "referfriend";
    @NotNull
    private static final String REVIEWS = "reviews";
    @NotNull
    private static final String REWARDS = "rewards";
    @NotNull
    private static final String SETTINGS = "settings";
    @NotNull
    private static final String SHARE = "share";
    @NotNull
    private static final String SOCIAL = "social";
    @NotNull
    private static final String SUBSCRIPTIONS = "Subscriptions";
    @NotNull
    private static final String TALABAT_CREDIT = "talabatcredit";
    @NotNull
    private static final String TERMS_AND_CONDITIONS = "terms";
    @NotNull
    private static final String TWITTER = "twitter";
    private static final int UNSUPPORTED_RESOURCE_ID = -1;
    @NotNull
    private static final String VOUCHERS = "Vouchers";
    @NotNull
    private static final String YOUTUBE = "youtube";
    @NotNull
    private static final Map<String, Pair<Function1<Boolean, Integer>, Function1<Country, Integer>>> resourceMap = MapsKt__MapsKt.mapOf(TuplesKt.to(MY_ACCOUNT, new Pair(SideMenuResource$resourceMap$1.INSTANCE, SideMenuResource$resourceMap$2.INSTANCE)), TuplesKt.to("home", new Pair(SideMenuResource$resourceMap$3.INSTANCE, SideMenuResource$resourceMap$4.INSTANCE)), TuplesKt.to(QUICK_FIND, new Pair(SideMenuResource$resourceMap$5.INSTANCE, SideMenuResource$resourceMap$6.INSTANCE)), TuplesKt.to(LIVE_SUPPORT, new Pair(SideMenuResource$resourceMap$7.INSTANCE, SideMenuResource$resourceMap$8.INSTANCE)), TuplesKt.to(PROMOTION, new Pair(SideMenuResource$resourceMap$9.INSTANCE, SideMenuResource$resourceMap$10.INSTANCE)), TuplesKt.to("cart", new Pair(SideMenuResource$resourceMap$11.INSTANCE, SideMenuResource$resourceMap$12.INSTANCE)), TuplesKt.to(BIRTHDAY, new Pair(SideMenuResource$resourceMap$13.INSTANCE, SideMenuResource$resourceMap$14.INSTANCE)), TuplesKt.to("notifications", new Pair(SideMenuResource$resourceMap$15.INSTANCE, SideMenuResource$resourceMap$16.INSTANCE)), TuplesKt.to("campaign", new Pair(SideMenuResource$resourceMap$17.INSTANCE, SideMenuResource$resourceMap$18.INSTANCE)), TuplesKt.to("orders", new Pair(SideMenuResource$resourceMap$19.INSTANCE, SideMenuResource$resourceMap$20.INSTANCE)), TuplesKt.to(REVIEWS, new Pair(SideMenuResource$resourceMap$21.INSTANCE, SideMenuResource$resourceMap$22.INSTANCE)), TuplesKt.to(MY_ADDRESS, new Pair(SideMenuResource$resourceMap$23.INSTANCE, SideMenuResource$resourceMap$24.INSTANCE)), TuplesKt.to(TALABAT_CREDIT, new Pair(SideMenuResource$resourceMap$25.INSTANCE, SideMenuResource$resourceMap$26.INSTANCE)), TuplesKt.to(PAY_LATER, new Pair(SideMenuResource$resourceMap$27.INSTANCE, SideMenuResource$resourceMap$28.INSTANCE)), TuplesKt.to(SUBSCRIPTIONS, new Pair(SideMenuResource$resourceMap$29.INSTANCE, SideMenuResource$resourceMap$30.INSTANCE)), TuplesKt.to("Vouchers", new Pair(SideMenuResource$resourceMap$31.INSTANCE, SideMenuResource$resourceMap$32.INSTANCE)), TuplesKt.to(CREDIT_STATEMENT, new Pair(SideMenuResource$resourceMap$33.INSTANCE, SideMenuResource$resourceMap$34.INSTANCE)), TuplesKt.to(GIFT_VOUCHER, new Pair(SideMenuResource$resourceMap$35.INSTANCE, SideMenuResource$resourceMap$36.INSTANCE)), TuplesKt.to(ACCOUNT_INFO, new Pair(SideMenuResource$resourceMap$37.INSTANCE, SideMenuResource$resourceMap$38.INSTANCE)), TuplesKt.to(LOG_OUT, new Pair(SideMenuResource$resourceMap$39.INSTANCE, SideMenuResource$resourceMap$40.INSTANCE)), TuplesKt.to("rewards", new Pair(SideMenuResource$resourceMap$41.INSTANCE, SideMenuResource$resourceMap$42.INSTANCE)), TuplesKt.to(TWITTER, new Pair(SideMenuResource$resourceMap$43.INSTANCE, SideMenuResource$resourceMap$44.INSTANCE)), TuplesKt.to(YOUTUBE, new Pair(SideMenuResource$resourceMap$45.INSTANCE, SideMenuResource$resourceMap$46.INSTANCE)), TuplesKt.to("instagram", new Pair(SideMenuResource$resourceMap$47.INSTANCE, SideMenuResource$resourceMap$48.INSTANCE)), TuplesKt.to(RECOMMEND_FRIEND, new Pair(SideMenuResource$resourceMap$49.INSTANCE, SideMenuResource$resourceMap$50.INSTANCE)), TuplesKt.to("terms", new Pair(SideMenuResource$resourceMap$51.INSTANCE, SideMenuResource$resourceMap$52.INSTANCE)), TuplesKt.to("coupon", new Pair(SideMenuResource$resourceMap$53.INSTANCE, SideMenuResource$resourceMap$54.INSTANCE)), TuplesKt.to(REDEMPTION, new Pair(SideMenuResource$resourceMap$55.INSTANCE, SideMenuResource$resourceMap$56.INSTANCE)), TuplesKt.to("social", new Pair(SideMenuResource$resourceMap$57.INSTANCE, SideMenuResource$resourceMap$58.INSTANCE)), TuplesKt.to("offers", new Pair(SideMenuResource$resourceMap$59.INSTANCE, SideMenuResource$resourceMap$60.INSTANCE)), TuplesKt.to(NEW_RESTAURANTS, new Pair(SideMenuResource$resourceMap$61.INSTANCE, SideMenuResource$resourceMap$62.INSTANCE)), TuplesKt.to(ABOUT, new Pair(SideMenuResource$resourceMap$63.INSTANCE, SideMenuResource$resourceMap$64.INSTANCE)), TuplesKt.to(FAQ, new Pair(SideMenuResource$resourceMap$65.INSTANCE, SideMenuResource$resourceMap$66.INSTANCE)), TuplesKt.to(FEEDBACK, new Pair(SideMenuResource$resourceMap$67.INSTANCE, SideMenuResource$resourceMap$68.INSTANCE)), TuplesKt.to(SETTINGS, new Pair(SideMenuResource$resourceMap$69.INSTANCE, SideMenuResource$resourceMap$70.INSTANCE)), TuplesKt.to("share", new Pair(SideMenuResource$resourceMap$71.INSTANCE, SideMenuResource$resourceMap$72.INSTANCE)), TuplesKt.to(REF_REFER_A_FRIEND, new Pair(SideMenuResource$resourceMap$73.INSTANCE, SideMenuResource$resourceMap$74.INSTANCE)));

    private SideMenuResource() {
    }

    @JvmStatic
    public static final int getIconResource(@NotNull String str, boolean z11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(str, GlobalConstants.ExtraNames.REF);
        Pair pair = resourceMap.get(str);
        if (pair == null || (function1 = (Function1) pair.getFirst()) == null) {
            return -1;
        }
        return ((Number) function1.invoke(Boolean.valueOf(z11))).intValue();
    }

    @JvmStatic
    public static final int getStringResource(@NotNull String str, @NotNull Country country) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(str, GlobalConstants.ExtraNames.REF);
        Intrinsics.checkNotNullParameter(country, "country");
        Pair pair = resourceMap.get(str);
        if (pair == null || (function1 = (Function1) pair.getSecond()) == null) {
            return -1;
        }
        return ((Number) function1.invoke(country)).intValue();
    }
}
