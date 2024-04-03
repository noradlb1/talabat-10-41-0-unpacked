package datamodels.mappers;

import com.talabat.domain.money.CurrenciesKt;
import com.talabat.mapper.CollectionModelMapper;
import dagger.Reusable;
import datamodels.City;
import datamodels.Country;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ldatamodels/mappers/OldCountryToCountryMapper;", "Lcom/talabat/mapper/CollectionModelMapper;", "Ldatamodels/Country;", "Lcom/talabat/configuration/location/Country;", "cityMapper", "Ldatamodels/mappers/OldCityToCityMapper;", "(Ldatamodels/mappers/OldCityToCityMapper;)V", "apply", "source", "map", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class OldCountryToCountryMapper implements CollectionModelMapper<Country, com.talabat.configuration.location.Country> {
    @NotNull
    private final OldCityToCityMapper cityMapper;

    @Inject
    public OldCountryToCountryMapper(@NotNull OldCityToCityMapper oldCityToCityMapper) {
        Intrinsics.checkNotNullParameter(oldCityToCityMapper, "cityMapper");
        this.cityMapper = oldCityToCityMapper;
    }

    @NotNull
    public Collection<com.talabat.configuration.location.Country> map(@NotNull Collection<Country> collection) {
        Intrinsics.checkNotNullParameter(collection, "source");
        Iterable<Country> iterable = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Country apply : iterable) {
            arrayList.add(apply(apply));
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList);
    }

    @NotNull
    public com.talabat.configuration.location.Country apply(@NotNull Country country) {
        List list;
        Country country2 = country;
        Intrinsics.checkNotNullParameter(country2, "source");
        com.talabat.configuration.country.Country from = com.talabat.configuration.country.Country.Companion.from(country2.f13845id);
        boolean z11 = country2.canShowCollectionWidget;
        City[] cityArr = country2.cities;
        if (cityArr != null) {
            OldCityToCityMapper oldCityToCityMapper = this.cityMapper;
            list = new ArrayList(cityArr.length);
            for (City apply : cityArr) {
                list.add(oldCityToCityMapper.apply(apply));
            }
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Currency currencyByCode = CurrenciesKt.getCurrencyByCode(country2.currencySymbol);
        String str = country2.currencySymbol;
        if (str == null) {
            str = "";
        }
        return new com.talabat.configuration.location.Country(from, z11, list, currencyByCode, str, country2.isCityInAddress, country2.isComplianceEnabled, country2.contactlessPaymentEnabled, country2.isDefault, country2.supportsInternalization, country2.isMapEnabledCountry, country2.enableTalabtCredit, country2.enableTalabatPay, country2.isTokenisationEnabledCountry, country2.isVisaCheckoutAvailable, country2.numOfDecimalPlaces, country2.tokenisationProvider);
    }
}
