package com.talabat.gem.adapters.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.gem.adapters.presentation.offer.GemOfferActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/gem/adapters/di/GemOfferActivityComponent;", "", "inject", "", "target", "Lcom/talabat/gem/adapters/presentation/offer/GemOfferActivity;", "Factory", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DeepLinkCoreLibApi.class})
public interface GemOfferActivityComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/gem/adapters/di/GemOfferActivityComponent$Factory;", "", "create", "Lcom/talabat/gem/adapters/di/GemOfferActivityComponent;", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        GemOfferActivityComponent create(@NotNull DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(@NotNull GemOfferActivity gemOfferActivity);
}
