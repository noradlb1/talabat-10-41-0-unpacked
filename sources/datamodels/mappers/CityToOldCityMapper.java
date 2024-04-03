package datamodels.mappers;

import com.talabat.configuration.location.City;
import com.talabat.mapper.CollectionModelMapper;
import dagger.Reusable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ldatamodels/mappers/CityToOldCityMapper;", "Lcom/talabat/mapper/CollectionModelMapper;", "Lcom/talabat/configuration/location/City;", "Ldatamodels/City;", "()V", "apply", "source", "map", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class CityToOldCityMapper implements CollectionModelMapper<City, datamodels.City> {
    @NotNull
    public Collection<datamodels.City> map(@NotNull Collection<City> collection) {
        Intrinsics.checkNotNullParameter(collection, "source");
        Iterable<City> iterable = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (City apply : iterable) {
            arrayList.add(apply(apply));
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList);
    }

    @NotNull
    public datamodels.City apply(@NotNull City city) {
        Intrinsics.checkNotNullParameter(city, "source");
        datamodels.City city2 = new datamodels.City();
        city2.f13843id = city.getId();
        city2.countryId = city.getCountryId();
        city2.f13844name = city.getName();
        return city2;
    }
}
