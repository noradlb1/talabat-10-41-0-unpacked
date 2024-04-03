package com.talabat.configuration.payment.mapper;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.WalletConfig;
import com.talabat.configuration.payment.model.TokenizedBankCardEntity;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.configuration.remote.model.AppInfoResultEntity;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.menu.MenuRemoteConfigurationsKeys;
import com.talabat.mapper.ModelMapper;
import dagger.Reusable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/configuration/payment/mapper/WalletConfigMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "Lcom/talabat/configuration/payment/WalletConfig;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "tokenizedBankCardMapper", "Lcom/talabat/configuration/payment/mapper/TokenizedBankCardMapper;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/payment/mapper/TokenizedBankCardMapper;)V", "apply", "source", "mapIsAmexAvailable", "", "mapSelectedCountryForDefaultIsAmexAvailable", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class WalletConfigMapper implements ModelMapper<AppInfoEntity, WalletConfig> {
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final TokenizedBankCardMapper tokenizedBankCardMapper;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.KSA.ordinal()] = 1;
            iArr[Country.LEBANON.ordinal()] = 2;
            iArr[Country.IRAQ.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public WalletConfigMapper(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull TokenizedBankCardMapper tokenizedBankCardMapper2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(tokenizedBankCardMapper2, "tokenizedBankCardMapper");
        this.featureFlags = iTalabatFeatureFlag;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.tokenizedBankCardMapper = tokenizedBankCardMapper2;
    }

    private final boolean mapIsAmexAvailable() {
        return this.featureFlags.getFeatureFlag(MenuRemoteConfigurationsKeys.MENU_CONFIG_IS_AMEX_AVAILABLE, mapSelectedCountryForDefaultIsAmexAvailable());
    }

    private final boolean mapSelectedCountryForDefaultIsAmexAvailable() {
        Country country;
        com.talabat.configuration.location.Country selectedCountry = this.locationConfigurationRepository.selectedCountry();
        if (selectedCountry == null || (country = selectedCountry.getCountry()) == null) {
            return true;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[country.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            return false;
        }
        return true;
    }

    @NotNull
    public WalletConfig apply(@NotNull AppInfoEntity appInfoEntity) {
        List list;
        List<TokenizedBankCardEntity> tokenizedBankCards;
        Intrinsics.checkNotNullParameter(appInfoEntity, "source");
        boolean mapIsAmexAvailable = mapIsAmexAvailable();
        AppInfoResultEntity result = appInfoEntity.getResult();
        if (result == null || (tokenizedBankCards = result.getTokenizedBankCards()) == null) {
            list = null;
        } else {
            Iterable<TokenizedBankCardEntity> iterable = tokenizedBankCards;
            TokenizedBankCardMapper tokenizedBankCardMapper2 = this.tokenizedBankCardMapper;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (TokenizedBankCardEntity apply : iterable) {
                list.add(tokenizedBankCardMapper2.apply(apply));
            }
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new WalletConfig(mapIsAmexAvailable, list);
    }
}
