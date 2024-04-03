package com.talabat.core.flutter.channels.impl.data.di;

import JsonModels.parser.UniversalGson;
import buisnessmodels.Cart;
import com.google.gson.Gson;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceChannelCallbackImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/QCommerceMethodChannelFeatureImplLibModule;", "", "()V", "provideNonMigratedCart", "Lbuisnessmodels/Cart;", "provideQCommerceChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;", "qCommerceChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/qcommerce/QCommerceChannelCallbackImpl;", "provideUniversalGson", "Lcom/google/gson/Gson;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class QCommerceMethodChannelFeatureImplLibModule {
    @NotNull
    @Provides
    public final Cart provideNonMigratedCart() {
        Cart instance = Cart.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    @Provides
    public final QCommerceChannelCallback provideQCommerceChannelCallbackImpl(@NotNull QCommerceChannelCallbackImpl qCommerceChannelCallbackImpl) {
        Intrinsics.checkNotNullParameter(qCommerceChannelCallbackImpl, "qCommerceChannelCallbackImpl");
        return qCommerceChannelCallbackImpl;
    }

    @NotNull
    @Provides
    @Named("LegacyUniversalGson")
    public final Gson provideUniversalGson() {
        Gson gson = UniversalGson.INSTANCE.gson;
        Intrinsics.checkNotNullExpressionValue(gson, "INSTANCE.gson");
        return gson;
    }
}
