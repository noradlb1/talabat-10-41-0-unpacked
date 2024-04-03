package com.talabat.feature.subscriptions.fake.di;

import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/di/FakeSubscriptionsFeatureComponent;", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "Factory", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(modules = {FakeSubscriptionsFeatureModule.class})
public interface FakeSubscriptionsFeatureComponent extends SubscriptionsFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JX\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/di/FakeSubscriptionsFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/subscriptions/fake/di/FakeSubscriptionsFeatureComponent;", "flagIsTProEnabled", "", "flagIsSavingsFlowEnabled", "flagIsSavingsBannerEnabled", "flagIsNewBrandEnabled", "flagIsTProFeatureEnabled", "flagDefault", "repositoryThrowError", "repositorySavingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ FakeSubscriptionsFeatureComponent create$default(Factory factory, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, SubscriptionSavingsInfo subscriptionSavingsInfo, int i11, Object obj) {
                if (obj == null) {
                    if ((i11 & 1) != 0) {
                        z11 = true;
                    }
                    if ((i11 & 2) != 0) {
                        z12 = true;
                    }
                    if ((i11 & 4) != 0) {
                        z13 = true;
                    }
                    if ((i11 & 8) != 0) {
                        z14 = true;
                    }
                    if ((i11 & 16) != 0) {
                        z15 = true;
                    }
                    if ((i11 & 32) != 0) {
                        z16 = true;
                    }
                    if ((i11 & 64) != 0) {
                        z17 = false;
                    }
                    if ((i11 & 128) != 0) {
                        subscriptionSavingsInfo = new SubscriptionSavingsInfo(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
                    }
                    return factory.create(z11, z12, z13, z14, z15, z16, z17, subscriptionSavingsInfo);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
        }

        @NotNull
        FakeSubscriptionsFeatureComponent create(@BindsInstance @FakeSubscriptionsFeature(name = "isTProEnabled") boolean z11, @BindsInstance @FakeSubscriptionsFeature(name = "isSavingsFlowEnabled") boolean z12, @BindsInstance @FakeSubscriptionsFeature(name = "isSavingsBannerEnabled") boolean z13, @BindsInstance @FakeSubscriptionsFeature(name = "isNewBrandEnabled") boolean z14, @BindsInstance @FakeSubscriptionsFeature(name = "isTProFeatureEnabled") boolean z15, @BindsInstance @FakeSubscriptionsFeature(name = "defaultFlag") boolean z16, @BindsInstance @FakeSubscriptionsFeature(name = "repositoryThrowError") boolean z17, @NotNull @BindsInstance @FakeSubscriptionsFeature(name = "savingsInfo") SubscriptionSavingsInfo subscriptionSavingsInfo);
    }
}
