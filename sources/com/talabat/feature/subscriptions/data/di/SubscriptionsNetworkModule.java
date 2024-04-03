package com.talabat.feature.subscriptions.data.di;

import com.serjltt.moshi.adapters.FallbackEnum;
import com.serjltt.moshi.adapters.FirstElement;
import com.serjltt.moshi.adapters.Wrapped;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.subscriptions.data.remote.ProApi;
import com.talabat.feature.subscriptions.data.remote.ProBaseUrl;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsApi;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsBaseUrl;
import com.talabat.feature.subscriptions.data.remote.model.HeroWidgetResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.HeroWidgetTypeResponse;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCapsuleCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardDefaultResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardLotteResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardTypeResponse;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCarouselCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingDefaultWidgetResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableWidgetResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingGridCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingInfoWidgetResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingTagsCardResponseModel;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import java.util.Locale;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J,\u0010\u000b\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r\u0018\u00010\f0\fH\u0002J,\u0010\u000e\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\f0\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\nH\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J$\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\b\b\u0001\u0010 \u001a\u00020\u0007H\u0007J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/feature/subscriptions/data/di/SubscriptionsNetworkModule;", "", "()V", "BASE_URL", "", "BASE_URL_PRO", "createBaseBuilder", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "client", "Lokhttp3/OkHttpClient;", "getHeroWidgetPolyMorphicAdapter", "Lcom/squareup/moshi/adapters/PolymorphicJsonAdapterFactory;", "Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModel;", "getTProOnBoardingCardsPolymorphicAdapter", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardResponseModel;", "provideBaseUrl", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "subscriptionsBaseUrl", "Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsBaseUrl;", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideProApi", "Lcom/talabat/feature/subscriptions/data/remote/ProApi;", "baseUrl", "okHttpClient", "provideProBaseUrl", "proBaseUrl", "Lcom/talabat/feature/subscriptions/data/remote/ProBaseUrl;", "provideSubscriptionsApi", "Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsApi;", "retrofitBuilder", "retrofitWithMoshi", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class SubscriptionsNetworkModule {
    @NotNull
    private static final String BASE_URL = "baseUrl";
    @NotNull
    private static final String BASE_URL_PRO = "BASE_URL_PRO";
    @NotNull
    public static final SubscriptionsNetworkModule INSTANCE = new SubscriptionsNetworkModule();

    private SubscriptionsNetworkModule() {
    }

    private final Retrofit.Builder createBaseBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().client(okHttpClient);
    }

    private final PolymorphicJsonAdapterFactory<HeroWidgetResponseModel> getHeroWidgetPolyMorphicAdapter() {
        return PolymorphicJsonAdapterFactory.of(HeroWidgetResponseModel.class, "widgetType").withSubtype(TProOnBoardingExpandableWidgetResponseModel.class, HeroWidgetTypeResponse.expandableWidget.name()).withSubtype(TProOnBoardingInfoWidgetResponseModel.class, HeroWidgetTypeResponse.infoWidget.name()).withDefaultValue(new TProOnBoardingDefaultWidgetResponseModel((String) null, 1, (DefaultConstructorMarker) null));
    }

    private final PolymorphicJsonAdapterFactory<TProOnBoardingCardResponseModel> getTProOnBoardingCardsPolymorphicAdapter() {
        PolymorphicJsonAdapterFactory<TProOnBoardingCardResponseModel> of2 = PolymorphicJsonAdapterFactory.of(TProOnBoardingCardResponseModel.class, "cardType");
        String name2 = TProOnBoardingCardTypeResponse.CAROUSEL.name();
        Locale locale = Locale.ROOT;
        String lowerCase = name2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        PolymorphicJsonAdapterFactory<TProOnBoardingCardResponseModel> withSubtype = of2.withSubtype(TProOnBoardingCarouselCardResponseModel.class, lowerCase);
        String lowerCase2 = TProOnBoardingCardTypeResponse.GRID.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        PolymorphicJsonAdapterFactory<TProOnBoardingCardResponseModel> withSubtype2 = withSubtype.withSubtype(TProOnBoardingGridCardResponseModel.class, lowerCase2);
        String lowerCase3 = TProOnBoardingCardTypeResponse.CAPSULES.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        PolymorphicJsonAdapterFactory<TProOnBoardingCardResponseModel> withSubtype3 = withSubtype2.withSubtype(TProOnBoardingCapsuleCardResponseModel.class, lowerCase3);
        String lowerCase4 = TProOnBoardingCardTypeResponse.TAGS.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        PolymorphicJsonAdapterFactory<TProOnBoardingCardResponseModel> withSubtype4 = withSubtype3.withSubtype(TProOnBoardingTagsCardResponseModel.class, lowerCase4);
        String lowerCase5 = TProOnBoardingCardTypeResponse.LOTTIE.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return withSubtype4.withSubtype(TProOnBoardingCardLotteResponseModel.class, lowerCase5).withDefaultValue(new TProOnBoardingCardDefaultResponseModel((List) null, 1, (DefaultConstructorMarker) null));
    }

    private final Moshi provideMoshi() {
        Moshi build = new Moshi.Builder().add(FallbackEnum.ADAPTER_FACTORY).add(FirstElement.ADAPTER_FACTORY).add(Wrapped.ADAPTER_FACTORY).add((JsonAdapter.Factory) getHeroWidgetPolyMorphicAdapter()).add((JsonAdapter.Factory) getTProOnBoardingCardsPolymorphicAdapter()).addLast((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .add(F…ctory())\n        .build()");
        return build;
    }

    private final Retrofit.Builder retrofitWithMoshi(OkHttpClient okHttpClient) {
        Retrofit.Builder addConverterFactory = createBaseBuilder(okHttpClient).addConverterFactory(MoshiConverterFactory.create(provideMoshi()));
        Intrinsics.checkNotNullExpressionValue(addConverterFactory, "createBaseBuilder(client…)\n            )\n        )");
        return addConverterFactory;
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull SubscriptionsBaseUrl subscriptionsBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(subscriptionsBaseUrl, "subscriptionsBaseUrl");
        return baseUrlFactory.baseUrl(subscriptionsBaseUrl);
    }

    @NotNull
    @Provides
    public final ProApi provideProApi(@NotNull @Named("BASE_URL_PRO") String str, @NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Retrofit build = INSTANCE.retrofitWithMoshi(okHttpClient).client(okHttpClient.newBuilder().build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "okHttpClient.newBuilder(…   .build()\n            }");
        return (ProApi) build.create(ProApi.class);
    }

    @NotNull
    @Provides
    @Named("BASE_URL_PRO")
    public final String provideProBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull ProBaseUrl proBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(proBaseUrl, "proBaseUrl");
        return baseUrlFactory.baseUrl(proBaseUrl);
    }

    @NotNull
    @Provides
    public final SubscriptionsApi provideSubscriptionsApi(@NotNull @Named("baseUrl") String str, @NotNull OkHttpClient okHttpClient, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.client(okHttpClient.newBuilder().build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "okHttpClient.newBuilder(…   .build()\n            }");
        return (SubscriptionsApi) build.create(SubscriptionsApi.class);
    }
}
