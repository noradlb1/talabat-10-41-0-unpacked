package com.talabat.darkstores.di;

import com.serjltt.moshi.adapters.FallbackEnum;
import com.serjltt.moshi.adapters.FirstElement;
import com.serjltt.moshi.adapters.Wrapped;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.endpoint.BasketEndPointProvider;
import com.talabat.core.network.endpoint.DarkstoresFavoritesEndPointProvider;
import com.talabat.core.network.endpoint.GroceryEndPointProvider;
import com.talabat.core.network.endpoint.QCommerceSearchEndpointProvider;
import com.talabat.core.network.endpoint.VendorEndPointProvider;
import com.talabat.core.network.endpoint.VerticalsEndPointProvider;
import com.talabat.core.network.midas.MidasHttpInterceptor;
import com.talabat.core.network.network.OKHttpBuilder;
import com.talabat.darkstores.common.helpers.Base64Helper;
import com.talabat.darkstores.data.NetworkConnectionInterceptor;
import com.talabat.darkstores.data.darkstores.AuthHeaderInterceptor;
import com.talabat.darkstores.data.darkstores.DarkstoresHeaderInterceptor;
import com.talabat.darkstores.data.grocery.GroceryBaseUrl;
import com.talabat.darkstores.di.qualifier.Basket;
import com.talabat.darkstores.di.qualifier.Darkstores;
import com.talabat.darkstores.di.qualifier.Discovery;
import com.talabat.darkstores.di.qualifier.Grocery;
import com.talabat.darkstores.di.qualifier.PartialFulfillment;
import com.talabat.darkstores.di.qualifier.QCommerce;
import com.talabat.darkstores.di.qualifier.QCommerceGrocery;
import com.talabat.darkstores.di.qualifier.Vendor;
import com.talabat.darkstores.model.CategorySuggestion;
import com.talabat.darkstores.model.ProductSuggestion;
import com.talabat.darkstores.model.SearchSuggestion;
import dagger.Module;
import dagger.Provides;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0007J\b\u0010\u0015\u001a\u00020\nH\u0007J\b\u0010\u0016\u001a\u00020\nH\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\nH\u0007J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\nH\u0007J\b\u0010#\u001a\u00020\nH\u0007¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresNetworkModule;", "", "()V", "provideAuthHeaderInterceptor", "Lcom/talabat/darkstores/data/darkstores/AuthHeaderInterceptor;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "base64Helper", "Lcom/talabat/darkstores/common/helpers/Base64Helper;", "provideBasketBaseUrl", "", "provideDarkstoresBaseUrl", "provideDarkstoresHeaderInterceptor", "Lcom/talabat/darkstores/data/darkstores/DarkstoresHeaderInterceptor;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "provideDarkstoresOkHttp", "Lokhttp3/OkHttpClient;", "okHttpClient", "authInterceptor", "darkstoresHeaderInterceptor", "provideDiscoveryBaseUrl", "provideGroceryBaseUrl", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideOkHttp", "networkConnectionInterceptor", "Lcom/talabat/darkstores/data/NetworkConnectionInterceptor;", "providePartialFulfillmentBaseUrl", "provideQCommerceGroceryUrl", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "baseUrl", "Lcom/talabat/darkstores/data/grocery/GroceryBaseUrl;", "provideQCommerceSearchBaseUrl", "provideVendorBaseUrl", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresNetworkModule {
    @NotNull
    public static final DarkstoresNetworkModule INSTANCE = new DarkstoresNetworkModule();

    private DarkstoresNetworkModule() {
    }

    @NotNull
    @LibScope
    @Provides
    public final AuthHeaderInterceptor provideAuthHeaderInterceptor(@NotNull SecretProvider secretProvider, @NotNull Base64Helper base64Helper) {
        Intrinsics.checkNotNullParameter(secretProvider, "secretProvider");
        Intrinsics.checkNotNullParameter(base64Helper, "base64Helper");
        return new AuthHeaderInterceptor(secretProvider.getDarkstoresAPIKey(), base64Helper);
    }

    @Basket
    @NotNull
    @Provides
    public final String provideBasketBaseUrl() {
        return BasketEndPointProvider.INSTANCE.getBaseUrl();
    }

    @Darkstores
    @NotNull
    @LibScope
    @Provides
    public final String provideDarkstoresBaseUrl() {
        return VerticalsEndPointProvider.INSTANCE.getBaseUrl();
    }

    @NotNull
    @LibScope
    @Provides
    public final DarkstoresHeaderInterceptor provideDarkstoresHeaderInterceptor(@NotNull AppVersionProvider appVersionProvider) {
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        return new DarkstoresHeaderInterceptor(appVersionProvider, new DarkstoresNetworkModule$provideDarkstoresHeaderInterceptor$1());
    }

    @Darkstores
    @NotNull
    @LibScope
    @Provides
    public final OkHttpClient provideDarkstoresOkHttp(@NotNull OkHttpClient okHttpClient, @NotNull AuthHeaderInterceptor authHeaderInterceptor, @NotNull DarkstoresHeaderInterceptor darkstoresHeaderInterceptor) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(authHeaderInterceptor, "authInterceptor");
        Intrinsics.checkNotNullParameter(darkstoresHeaderInterceptor, "darkstoresHeaderInterceptor");
        return okHttpClient.newBuilder().addInterceptor(MidasHttpInterceptor.INSTANCE).addInterceptor(authHeaderInterceptor).addInterceptor(darkstoresHeaderInterceptor).build();
    }

    @Discovery
    @NotNull
    @LibScope
    @Provides
    public final String provideDiscoveryBaseUrl() {
        return VerticalsEndPointProvider.INSTANCE.getBaseUrl();
    }

    @Grocery
    @NotNull
    @Provides
    public final String provideGroceryBaseUrl() {
        return new GroceryEndPointProvider((String) null, (String) null, 3, (DefaultConstructorMarker) null).getBaseUrl();
    }

    @NotNull
    @LibScope
    @Provides
    public final Moshi provideMoshi() {
        Class cls = CategorySuggestion.class;
        Moshi build = new Moshi.Builder().add(FallbackEnum.ADAPTER_FACTORY).add(FirstElement.ADAPTER_FACTORY).add(Wrapped.ADAPTER_FACTORY).add(Date.class, new Rfc3339DateJsonAdapter()).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(SearchSuggestion.class, "type").withSubtype(ProductSuggestion.class, SearchSuggestion.Type.product.name()).withSubtype(cls, SearchSuggestion.Type.category.name())).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .add(F…       )\n        .build()");
        return build;
    }

    @NotNull
    @LibScope
    @Provides
    public final OkHttpClient provideOkHttp(@NotNull NetworkConnectionInterceptor networkConnectionInterceptor) {
        Intrinsics.checkNotNullParameter(networkConnectionInterceptor, "networkConnectionInterceptor");
        return OKHttpBuilder.INSTANCE.getDefaultHttpClient(CollectionsKt__CollectionsJVMKt.listOf(networkConnectionInterceptor), 10);
    }

    @PartialFulfillment
    @NotNull
    @LibScope
    @Provides
    public final String providePartialFulfillmentBaseUrl() {
        return DarkstoresFavoritesEndPointProvider.INSTANCE.getBaseUrl();
    }

    @NotNull
    @QCommerceGrocery
    @Provides
    public final String provideQCommerceGroceryUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull GroceryBaseUrl groceryBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(groceryBaseUrl, "baseUrl");
        return baseUrlFactory.baseUrl(groceryBaseUrl);
    }

    @QCommerce
    @NotNull
    @Provides
    public final String provideQCommerceSearchBaseUrl() {
        return QCommerceSearchEndpointProvider.INSTANCE.getBaseUrl();
    }

    @NotNull
    @LibScope
    @Vendor
    @Provides
    public final String provideVendorBaseUrl() {
        return VendorEndPointProvider.INSTANCE.getBaseUrl();
    }
}
