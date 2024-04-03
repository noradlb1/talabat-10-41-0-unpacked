package com.talabat.darkstores.di;

import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.network.network.KeyValueHeaderInterceptor;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.darkstores.data.basket.BasketApi;
import com.talabat.darkstores.data.darkstores.DarkstoresApi;
import com.talabat.darkstores.data.darkstores.PlatformHeaderInterceptor;
import com.talabat.darkstores.data.discovery.DiscoveryApi;
import com.talabat.darkstores.data.discovery.FeedApi;
import com.talabat.darkstores.data.discovery.ProductApi;
import com.talabat.darkstores.data.grocery.GroceryShoppingApi;
import com.talabat.darkstores.data.lookingglass.LookingGlassVoucherApi;
import com.talabat.darkstores.data.mission.control.MissionControlProductApi;
import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentApi;
import com.talabat.darkstores.data.search.QCommerceGroceryApi;
import com.talabat.darkstores.data.search.QCommerceSearchApi;
import com.talabat.darkstores.data.search.SearchApi;
import com.talabat.darkstores.data.swimlanes.SwimlanseProductApi;
import com.talabat.darkstores.data.vendors.remote.VendorsApi;
import com.talabat.darkstores.data.voucher.VoucherApi;
import com.talabat.darkstores.di.qualifier.Basket;
import com.talabat.darkstores.di.qualifier.Darkstores;
import com.talabat.darkstores.di.qualifier.Discovery;
import com.talabat.darkstores.di.qualifier.Grocery;
import com.talabat.darkstores.di.qualifier.PartialFulfillment;
import com.talabat.darkstores.di.qualifier.QCommerce;
import com.talabat.darkstores.di.qualifier.QCommerceGrocery;
import com.talabat.darkstores.di.qualifier.Vendor;
import com.talabat.growth.ui.loyalty.burn.details.BurnOptionsDetailsDialogFragment;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\"\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\"\u0010\"\u001a\u00020#2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\"\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\"\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\"\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J$\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\b\u0010,\u001a\u00020-H\u0007J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020-2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J*\u00101\u001a\u0002H2\"\u0006\b\u0000\u00102\u0018\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\b¢\u0006\u0002\u00103¨\u00064"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresApiModule;", "", "()V", "provideBaseRetrofitBuilder", "Lretrofit2/Retrofit$Builder;", "moshi", "Lcom/squareup/moshi/Moshi;", "provideBasketApi", "Lcom/talabat/darkstores/data/basket/BasketApi;", "retrofitBuilder", "okHttpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "platformHeaderInterceptor", "Lcom/talabat/darkstores/data/darkstores/PlatformHeaderInterceptor;", "provideDiscoveryApi", "Lcom/talabat/darkstores/data/discovery/DiscoveryApi;", "provideDjiniApi", "Lcom/talabat/darkstores/data/darkstores/DarkstoresApi;", "provideFeedApi", "Lcom/talabat/darkstores/data/discovery/FeedApi;", "provideGroceryApi", "Lcom/talabat/darkstores/data/voucher/VoucherApi;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "provideGroceryShoppingApi", "Lcom/talabat/darkstores/data/grocery/GroceryShoppingApi;", "provideLookingGlassVoucherApi", "Lcom/talabat/darkstores/data/lookingglass/LookingGlassVoucherApi;", "provideMissionControlProductApi", "Lcom/talabat/darkstores/data/mission/control/MissionControlProductApi;", "providePartialFulfillmentApi", "Lcom/talabat/darkstores/data/partialFulfillment/remote/PartialFulfillmentApi;", "provideProductApi", "Lcom/talabat/darkstores/data/discovery/ProductApi;", "provideQCGroceryCategorySearchApi", "Lcom/talabat/darkstores/data/search/QCommerceGroceryApi;", "provideQCommerceSearchApi", "Lcom/talabat/darkstores/data/search/QCommerceSearchApi;", "provideSearchApi", "Lcom/talabat/darkstores/data/search/SearchApi;", "provideSwimlanseProductApi", "Lcom/talabat/darkstores/data/swimlanes/SwimlanseProductApi;", "provideTalabatApiBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "provideVendorsApi", "Lcom/talabat/darkstores/data/vendors/remote/VendorsApi;", "talabatAPIBuilder", "createApi", "Api", "(Lretrofit2/Retrofit$Builder;Ljava/lang/String;Lokhttp3/OkHttpClient;)Ljava/lang/Object;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresApiModule {
    @NotNull
    public static final DarkstoresApiModule INSTANCE = new DarkstoresApiModule();

    private DarkstoresApiModule() {
    }

    private final /* synthetic */ <Api> Api createApi(Retrofit.Builder builder, String str, OkHttpClient okHttpClient) {
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        Intrinsics.reifiedOperationMarker(4, BurnOptionsDetailsDialogFragment.GA_REASON_API_FAILED);
        return build.create(Object.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final Retrofit.Builder provideBaseRetrofitBuilder(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder addCallAdapterFactory = new Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Intrinsics.checkNotNullExpressionValue(addCallAdapterFactory, "Builder()\n        .addCo…lAdapterFactory.create())");
        return addCallAdapterFactory;
    }

    @NotNull
    @Provides
    public final BasketApi provideBasketApi(@NotNull Retrofit.Builder builder, @Darkstores @NotNull OkHttpClient okHttpClient, @Basket @NotNull String str, @NotNull PlatformHeaderInterceptor platformHeaderInterceptor) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(platformHeaderInterceptor, "platformHeaderInterceptor");
        Retrofit build = builder.client(okHttpClient.newBuilder().addInterceptor(platformHeaderInterceptor).build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (BasketApi) build.create(BasketApi.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final DiscoveryApi provideDiscoveryApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @Discovery @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (DiscoveryApi) build.create(DiscoveryApi.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final DarkstoresApi provideDjiniApi(@NotNull Retrofit.Builder builder, @Darkstores @NotNull OkHttpClient okHttpClient, @Darkstores @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (DarkstoresApi) build.create(DarkstoresApi.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final FeedApi provideFeedApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull @QCommerceGrocery String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (FeedApi) build.create(FeedApi.class);
    }

    @NotNull
    @Provides
    public final VoucherApi provideGroceryApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull SecretProvider secretProvider, @Grocery @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(secretProvider, "secretProvider");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient.newBuilder().addInterceptor(new KeyValueHeaderInterceptor("X-API-Key", secretProvider.getTMartAPIKey(), true)).build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (VoucherApi) build.create(VoucherApi.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final GroceryShoppingApi provideGroceryShoppingApi(@NotNull Retrofit.Builder builder, @Darkstores @NotNull OkHttpClient okHttpClient, @Darkstores @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (GroceryShoppingApi) build.create(GroceryShoppingApi.class);
    }

    @NotNull
    @Provides
    public final LookingGlassVoucherApi provideLookingGlassVoucherApi(@NotNull Retrofit.Builder builder, @Darkstores @NotNull OkHttpClient okHttpClient, @NotNull @QCommerceGrocery String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (LookingGlassVoucherApi) build.create(LookingGlassVoucherApi.class);
    }

    @NotNull
    @Provides
    public final MissionControlProductApi provideMissionControlProductApi(@NotNull Retrofit.Builder builder, @Darkstores @NotNull OkHttpClient okHttpClient, @NotNull @QCommerceGrocery String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (MissionControlProductApi) build.create(MissionControlProductApi.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final PartialFulfillmentApi providePartialFulfillmentApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull @PartialFulfillment String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (PartialFulfillmentApi) build.create(PartialFulfillmentApi.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final ProductApi provideProductApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull @QCommerceGrocery String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (ProductApi) build.create(ProductApi.class);
    }

    @NotNull
    @Provides
    public final QCommerceGroceryApi provideQCGroceryCategorySearchApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull @QCommerceGrocery String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (QCommerceGroceryApi) build.create(QCommerceGroceryApi.class);
    }

    @NotNull
    @Provides
    public final QCommerceSearchApi provideQCommerceSearchApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @QCommerce @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (QCommerceSearchApi) build.create(QCommerceSearchApi.class);
    }

    @NotNull
    @Provides
    public final SearchApi provideSearchApi(@NotNull Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @Discovery @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (SearchApi) build.create(SearchApi.class);
    }

    @NotNull
    @Provides
    public final SwimlanseProductApi provideSwimlanseProductApi(@NotNull Retrofit.Builder builder, @Darkstores @NotNull OkHttpClient okHttpClient, @Grocery @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "client(okHttpClient).baseUrl(baseUrl).build()");
        return (SwimlanseProductApi) build.create(SwimlanseProductApi.class);
    }

    @NotNull
    @LibScope
    @Provides
    public final TalabatAPIBuilder provideTalabatApiBuilder() {
        return new TalabatAPIBuilder();
    }

    @NotNull
    @LibScope
    @Provides
    public final VendorsApi provideVendorsApi(@NotNull TalabatAPIBuilder talabatAPIBuilder, @NotNull @Vendor String str) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        return (VendorsApi) talabatAPIBuilder.createApi(str, VendorsApi.class);
    }
}
