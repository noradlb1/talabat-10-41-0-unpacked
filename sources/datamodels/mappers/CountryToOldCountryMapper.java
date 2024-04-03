package datamodels.mappers;

import com.talabat.configuration.location.City;
import com.talabat.configuration.location.Country;
import com.talabat.mapper.CollectionModelMapper;
import dagger.Reusable;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ldatamodels/mappers/CountryToOldCountryMapper;", "Lcom/talabat/mapper/CollectionModelMapper;", "Lcom/talabat/configuration/location/Country;", "Ldatamodels/Country;", "cityToOldCityMapper", "Ldatamodels/mappers/CityToOldCityMapper;", "(Ldatamodels/mappers/CityToOldCityMapper;)V", "apply", "source", "map", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class CountryToOldCountryMapper implements CollectionModelMapper<Country, datamodels.Country> {
    @NotNull
    private final CityToOldCityMapper cityToOldCityMapper;

    @Inject
    public CountryToOldCountryMapper(@NotNull CityToOldCityMapper cityToOldCityMapper2) {
        Intrinsics.checkNotNullParameter(cityToOldCityMapper2, "cityToOldCityMapper");
        this.cityToOldCityMapper = cityToOldCityMapper2;
    }

    @NotNull
    public Collection<datamodels.Country> map(@NotNull Collection<Country> collection) {
        Intrinsics.checkNotNullParameter(collection, "source");
        Iterable<Country> iterable = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Country apply : iterable) {
            arrayList.add(apply(apply));
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList);
    }

    @NotNull
    public datamodels.Country apply(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "source");
        datamodels.Country country2 = new datamodels.Country();
        country2.f13845id = country.getCountry().getCountryId();
        country2.f13846name = country.getCountry().getCountryName();
        country2.isCityInAddress = country.isCity();
        country2.currencySymbol = country.getCurrencyCode();
        country2.numOfDecimalPlaces = country.getNumberOfDecimalPlaces();
        Iterable<City> cities = country.getCities();
        CityToOldCityMapper cityToOldCityMapper2 = this.cityToOldCityMapper;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(cities, 10));
        for (City apply : cities) {
            arrayList.add(cityToOldCityMapper2.apply(apply));
        }
        Object[] array = arrayList.toArray(new datamodels.City[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        country2.cities = (datamodels.City[]) array;
        country2.isDefault = country.isDefault();
        country2.isTokenisationEnabledCountry = country.isTokenizationEnabled();
        country2.tokenisationProvider = country.getTokenizationProvider();
        country2.isVisaCheckoutAvailable = country.isVisaCheckoutAvailable();
        country2.canShowCollectionWidget = country.getCanShowCollectionWidget();
        country2.isMapEnabledCountry = country.isMapEnabled();
        country2.supportsInternalization = country.isI18nSupported();
        country2.enableTalabtCredit = country.isTalabatCreditEnabled();
        country2.enableTalabatPay = country.isTalabatPayEnabled();
        country2.contactlessPaymentEnabled = country.isContactlessPaymentEnabled();
        country2.isComplianceEnabled = country.isComplianceEnabled();
        country2.code = country.getCountry().getTwoLetterCode();
        return country2;
    }
}
