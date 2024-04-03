package com.talabat.darkstores.domain.naivgator;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import com.google.gson.Gson;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.darkstores.common.helpers.DarkstoresUtils;
import com.talabat.darkstores.data.Environment;
import com.talabat.darkstores.feature.Darkstores;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresInternalNavigationTarget;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import datamodels.Restaurant;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJG\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0014Jl\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010+\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010,Jc\u0010-\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020#0/H\u0016¢\u0006\u0002\u00100R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/talabat/darkstores/domain/naivgator/DarkstoresNavigatorImpl;", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "deeplinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "dispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "buildDeeplink", "", "branchId", "", "deeplinkType", "deeplinkInfo", "screenTitle", "eventOrigin", "shopClickOrigin", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "createConfig", "Lcom/talabat/darkstores/feature/Darkstores$Config;", "restaurant", "Ldatamodels/Restaurant;", "selectedCountryId", "isFromDeepLink", "", "shouldClearCart", "deeplinkUri", "searchTerm", "experimentKey", "darkstoresTrackingData", "Llibrary/talabat/mvp/listingmenubridge/DarkstoresTrackingData;", "navigateInternal", "", "fragment", "Landroidx/fragment/app/Fragment;", "target", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "navigateToDarkStore", "activity", "Landroid/app/Activity;", "isFromDeeplink", "(Landroid/app/Activity;Ldatamodels/Restaurant;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Llibrary/talabat/mvp/listingmenubridge/DarkstoresTrackingData;)V", "tryNavigateUsingDeeplink", "navigationCallback", "Lkotlin/Function1;", "(Landroid/app/Activity;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresNavigatorImpl implements DarkstoresNavigator {
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final DeepLinkNavigator deeplinkNavigator;
    @NotNull
    private final CoroutineDispatchersFactory dispatchersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final Navigator navigator;

    @Inject
    public DarkstoresNavigatorImpl(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull DeepLinkNavigator deepLinkNavigator, @NotNull Navigator navigator2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(deepLinkNavigator, "deeplinkNavigator");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "dispatchersFactory");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.deeplinkNavigator = deepLinkNavigator;
        this.navigator = navigator2;
        this.dispatchersFactory = coroutineDispatchersFactory;
    }

    /* access modifiers changed from: private */
    public final String buildDeeplink(int i11, Integer num, String str, String str2, String str3, String str4) {
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("talabat").authority("").appendQueryParameter("s", "mv").appendQueryParameter("shopClickOrigin", str4).appendQueryParameter("eventOrigin", str3).appendQueryParameter("bid", String.valueOf(i11));
        if (num != null) {
            appendQueryParameter.appendQueryParameter("t", String.valueOf(num.intValue()));
        }
        if (str != null) {
            appendQueryParameter.appendQueryParameter("i", str);
        }
        if (str2 != null) {
            appendQueryParameter.appendQueryParameter("n", str2);
        }
        String uri = appendQueryParameter.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Builder()\n        .schem…     }.build().toString()");
        return uri;
    }

    /* access modifiers changed from: private */
    public final Darkstores.Config createConfig(Restaurant restaurant, int i11, boolean z11, boolean z12, int i12, String str, String str2, String str3, String str4, String str5, String str6, DarkstoresTrackingData darkstoresTrackingData) {
        String str7;
        String str8;
        Darkstores.DarkstoresTrackingData darkstoresTrackingData2;
        Restaurant restaurant2 = restaurant;
        int i13 = i11;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str7 = gson.toJson((Object) restaurant2);
        } else {
            str7 = GsonInstrumentation.toJson(gson, (Object) restaurant2);
        }
        String str9 = str7;
        DarkstoresUtils darkstoresUtils = DarkstoresUtils.INSTANCE;
        String lowerCase = darkstoresUtils.getCountryForDarkstores(i13).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        DarkstoresMainActivity.Language language$default = DarkstoresUtils.getLanguage$default(darkstoresUtils, (String) null, 1, (Object) null);
        String locale$default = DarkstoresUtils.getLocale$default(darkstoresUtils, darkstoresUtils.getCountryForDarkstores(i13), (String) null, 2, (Object) null);
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        double selectedLocationLatitude = companion.selectedLocationLatitude();
        double selectedLocationLongitude = companion.selectedLocationLongitude();
        String customerId$default = DarkstoresUtils.getCustomerId$default(darkstoresUtils, (String) null, 1, (Object) null);
        Environment environment$default = DarkstoresUtils.getEnvironment$default(darkstoresUtils, (String) null, (String) null, 3, (Object) null);
        String countryCurrencyCode = darkstoresUtils.getCountryCurrencyCode(i13);
        String countryDjiniEntityId = darkstoresUtils.getCountryDjiniEntityId(i13);
        if (str4 == null) {
            str8 = "N/A";
        } else {
            str8 = str4;
        }
        if (darkstoresTrackingData != null) {
            darkstoresTrackingData2 = new Darkstores.DarkstoresTrackingData(darkstoresTrackingData.getLoadingStartTime());
        } else {
            darkstoresTrackingData2 = null;
        }
        Intrinsics.checkNotNullExpressionValue(str9, "toJson(restaurant)");
        return new Darkstores.Config(str9, lowerCase, language$default, locale$default, selectedLocationLatitude, selectedLocationLongitude, customerId$default, environment$default, z12, z11, i12, str, str2, str3, countryCurrencyCode, countryDjiniEntityId, str8, str5, str6, darkstoresTrackingData2);
    }

    public void navigateInternal(@NotNull Fragment fragment, @NotNull DarkstoresInternalNavigationTarget darkstoresInternalNavigationTarget) {
        DarkstoresMainActivity darkstoresMainActivity;
        NavController navController$com_talabat_NewArchi_darkstores_darkstores;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(darkstoresInternalNavigationTarget, "target");
        FragmentActivity activity = fragment.getActivity();
        if (activity instanceof DarkstoresMainActivity) {
            darkstoresMainActivity = (DarkstoresMainActivity) activity;
        } else {
            darkstoresMainActivity = null;
        }
        if (darkstoresMainActivity != null && (navController$com_talabat_NewArchi_darkstores_darkstores = darkstoresMainActivity.getNavController$com_talabat_NewArchi_darkstores_darkstores()) != null) {
            navController$com_talabat_NewArchi_darkstores_darkstores.navigate(DarkstoresInternalNavigationTargetExtKt.getDestinationId(darkstoresInternalNavigationTarget), DarkstoresInternalNavigationTargetExtKt.getArguments(darkstoresInternalNavigationTarget));
        }
    }

    public void navigateToDarkStore(@NotNull Activity activity, @NotNull Restaurant restaurant, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable DarkstoresTrackingData darkstoresTrackingData) {
        Restaurant restaurant2 = restaurant;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        String str8 = str3;
        String str9 = str5;
        tryNavigateUsingDeeplink(activity, restaurant2.branchId, num, str, str8, str9, str6, new DarkstoresNavigatorImpl$navigateToDarkStore$1(restaurant2, this, num, str, str2, str8, str9, str7, z11, str4, darkstoresTrackingData, activity));
    }

    public void tryNavigateUsingDeeplink(@NotNull Activity activity, int i11, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Function1<? super Boolean, Unit> function1) {
        Activity activity2 = activity;
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Function1<? super Boolean, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "navigationCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatchersFactory.main()), (CoroutineContext) null, (CoroutineStart) null, new DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1(this, i11, num, str, str2, str3, str4, activity2, function12, (Continuation<? super DarkstoresNavigatorImpl$tryNavigateUsingDeeplink$1>) null), 3, (Object) null);
    }
}
