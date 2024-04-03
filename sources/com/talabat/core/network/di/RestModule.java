package com.talabat.core.network.di;

import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.core.network.domain.GsonRetrofit;
import com.talabat.core.network.domain.MoshiRetrofit;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/network/di/RestModule;", "", "()V", "createBaseBuilder", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "client", "Lokhttp3/OkHttpClient;", "retrofit", "retrofitWithGson", "gson", "Lcom/google/gson/Gson;", "retrofitWithMoshi", "moshi", "Lcom/squareup/moshi/Moshi;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {NetworkCoreLibModule.class})
public final class RestModule {
    @NotNull
    public static final RestModule INSTANCE = new RestModule();

    private RestModule() {
    }

    private final Retrofit.Builder createBaseBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    @NotNull
    @Reusable
    @Provides
    public final Retrofit.Builder retrofit(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        Retrofit.Builder createBaseBuilder = createBaseBuilder(okHttpClient);
        Intrinsics.checkNotNullExpressionValue(createBaseBuilder, "createBaseBuilder(client)");
        return createBaseBuilder;
    }

    @GsonRetrofit
    @NotNull
    @Deprecated(message = "Please use Retrofit with Moshi converter")
    @Reusable
    @Provides
    public final Retrofit.Builder retrofitWithGson(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        Intrinsics.checkNotNullParameter(gson, "gson");
        Retrofit.Builder addConverterFactory = createBaseBuilder(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson));
        Intrinsics.checkNotNullExpressionValue(addConverterFactory, "createBaseBuilder(client…rterFactory.create(gson))");
        return addConverterFactory;
    }

    @MoshiRetrofit
    @NotNull
    @Reusable
    @Provides
    public final Retrofit.Builder retrofitWithMoshi(@NotNull OkHttpClient okHttpClient, @NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder addConverterFactory = createBaseBuilder(okHttpClient).addConverterFactory(MoshiConverterFactory.create(moshi));
        Intrinsics.checkNotNullExpressionValue(addConverterFactory, "createBaseBuilder(client…terFactory.create(moshi))");
        return addConverterFactory;
    }
}
