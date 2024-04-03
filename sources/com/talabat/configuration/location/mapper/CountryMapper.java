package com.talabat.configuration.location.mapper;

import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.model.CityEntity;
import com.talabat.configuration.location.model.CountryEntity;
import com.talabat.domain.money.CurrenciesKt;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/configuration/location/mapper/CountryMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/location/model/CountryEntity;", "Lcom/talabat/configuration/location/Country;", "cityMapper", "Lcom/talabat/configuration/location/mapper/CityMapper;", "(Lcom/talabat/configuration/location/mapper/CityMapper;)V", "apply", "source", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountryMapper implements ModelMapper<CountryEntity, Country> {
    @NotNull
    private final CityMapper cityMapper;

    @Inject
    public CountryMapper(@NotNull CityMapper cityMapper2) {
        Intrinsics.checkNotNullParameter(cityMapper2, "cityMapper");
        this.cityMapper = cityMapper2;
    }

    @NotNull
    public Country apply(@NotNull CountryEntity countryEntity) {
        com.talabat.configuration.country.Country country;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(countryEntity, "source");
        Integer id2 = countryEntity.getId();
        if (id2 == null || (country = com.talabat.configuration.country.Country.Companion.from(id2.intValue())) == null) {
            country = com.talabat.configuration.country.Country.UNDEFINED;
        }
        com.talabat.configuration.country.Country country2 = country;
        Boolean canShowCollectionWidget = countryEntity.getCanShowCollectionWidget();
        boolean booleanValue = canShowCollectionWidget != null ? canShowCollectionWidget.booleanValue() : false;
        List<CityEntity> cities = countryEntity.getCities();
        if (cities != null) {
            Iterable<CityEntity> iterable = cities;
            CityMapper cityMapper2 = this.cityMapper;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (CityEntity apply : iterable) {
                arrayList.add(cityMapper2.apply(apply));
            }
        } else {
            arrayList = null;
        }
        List emptyList = arrayList == null ? CollectionsKt__CollectionsKt.emptyList() : arrayList;
        Currency currencyByCode = CurrenciesKt.getCurrencyByCode(countryEntity.getCurrencyCode());
        String currencyCode = countryEntity.getCurrencyCode();
        if (currencyCode == null) {
            currencyCode = "";
        }
        Boolean isCity = countryEntity.isCity();
        boolean booleanValue2 = isCity != null ? isCity.booleanValue() : false;
        Boolean isComplianceEnabled = countryEntity.isComplianceEnabled();
        boolean booleanValue3 = isComplianceEnabled != null ? isComplianceEnabled.booleanValue() : false;
        Boolean isContactlessPaymentEnabled = countryEntity.isContactlessPaymentEnabled();
        boolean booleanValue4 = isContactlessPaymentEnabled != null ? isContactlessPaymentEnabled.booleanValue() : false;
        Boolean isDefault = countryEntity.isDefault();
        boolean booleanValue5 = isDefault != null ? isDefault.booleanValue() : false;
        Boolean isI18nSupported = countryEntity.isI18nSupported();
        boolean booleanValue6 = isI18nSupported != null ? isI18nSupported.booleanValue() : false;
        Boolean isMapEnabled = countryEntity.isMapEnabled();
        boolean booleanValue7 = isMapEnabled != null ? isMapEnabled.booleanValue() : false;
        Boolean isTalabatCreditEnabled = countryEntity.isTalabatCreditEnabled();
        boolean booleanValue8 = isTalabatCreditEnabled != null ? isTalabatCreditEnabled.booleanValue() : false;
        Boolean isTalabatPayEnabled = countryEntity.isTalabatPayEnabled();
        boolean booleanValue9 = isTalabatPayEnabled != null ? isTalabatPayEnabled.booleanValue() : false;
        Boolean isTokenizationEnabled = countryEntity.isTokenizationEnabled();
        boolean booleanValue10 = isTokenizationEnabled != null ? isTokenizationEnabled.booleanValue() : false;
        Boolean isVisaCheckoutAvailable = countryEntity.isVisaCheckoutAvailable();
        boolean booleanValue11 = isVisaCheckoutAvailable != null ? isVisaCheckoutAvailable.booleanValue() : false;
        Integer numberOfDecimalPlaces = countryEntity.getNumberOfDecimalPlaces();
        int intValue = numberOfDecimalPlaces != null ? numberOfDecimalPlaces.intValue() : 2;
        Integer tokenizationProvider = countryEntity.getTokenizationProvider();
        return new Country(country2, booleanValue, emptyList, currencyByCode, currencyCode, booleanValue2, booleanValue3, booleanValue4, booleanValue5, booleanValue6, booleanValue7, booleanValue8, booleanValue9, booleanValue10, booleanValue11, intValue, tokenizationProvider != null ? tokenizationProvider.intValue() : 0);
    }
}
