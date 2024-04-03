package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\rB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bHBø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionsUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "invoke", "", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionsUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionsUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSubscriptionsUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final ISubscriptionsRepository repository;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionsUseCase$Params;", "", "country", "Lcom/talabat/configuration/country/Country;", "(Lcom/talabat/configuration/country/Country;)V", "getCountry", "()Lcom/talabat/configuration/country/Country;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        @NotNull
        private final Country country;

        public Params(@NotNull Country country2) {
            Intrinsics.checkNotNullParameter(country2, "country");
            this.country = country2;
        }

        public static /* synthetic */ Params copy$default(Params params, Country country2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                country2 = params.country;
            }
            return params.copy(country2);
        }

        @NotNull
        public final Country component1() {
            return this.country;
        }

        @NotNull
        public final Params copy(@NotNull Country country2) {
            Intrinsics.checkNotNullParameter(country2, "country");
            return new Params(country2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && this.country == ((Params) obj).country;
        }

        @NotNull
        public final Country getCountry() {
            return this.country;
        }

        public int hashCode() {
            return this.country.hashCode();
        }

        @NotNull
        public String toString() {
            Country country2 = this.country;
            return "Params(country=" + country2 + ")";
        }
    }

    @Inject
    public GetSubscriptionsUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.repository = iSubscriptionsRepository;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @Nullable
    public final Object invoke(@NotNull Params params, @NotNull Continuation<? super List<Subscription>> continuation) {
        return this.repository.getSubscriptionsForCountry(params.getCountry().getPhoneCodeISO3166(), continuation);
    }
}
