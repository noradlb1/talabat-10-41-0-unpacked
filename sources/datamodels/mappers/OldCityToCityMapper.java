package datamodels.mappers;

import com.talabat.mapper.CollectionModelMapper;
import dagger.Reusable;
import datamodels.City;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ldatamodels/mappers/OldCityToCityMapper;", "Lcom/talabat/mapper/CollectionModelMapper;", "Ldatamodels/City;", "Lcom/talabat/configuration/location/City;", "()V", "apply", "source", "map", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class OldCityToCityMapper implements CollectionModelMapper<City, com.talabat.configuration.location.City> {
    @NotNull
    public Collection<com.talabat.configuration.location.City> map(@NotNull Collection<City> collection) {
        Intrinsics.checkNotNullParameter(collection, "source");
        Iterable<City> iterable = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (City apply : iterable) {
            arrayList.add(apply(apply));
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList);
    }

    @NotNull
    public com.talabat.configuration.location.City apply(@NotNull City city) {
        Intrinsics.checkNotNullParameter(city, "source");
        int i11 = city.f13843id;
        int i12 = city.countryId;
        String str = city.f13844name;
        if (str == null) {
            str = "";
        }
        return new com.talabat.configuration.location.City(i11, i12, str);
    }
}
