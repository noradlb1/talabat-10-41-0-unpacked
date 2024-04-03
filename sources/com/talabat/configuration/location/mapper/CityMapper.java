package com.talabat.configuration.location.mapper;

import com.talabat.configuration.location.City;
import com.talabat.configuration.location.model.CityEntity;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/location/mapper/CityMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/location/model/CityEntity;", "Lcom/talabat/configuration/location/City;", "()V", "apply", "source", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CityMapper implements ModelMapper<CityEntity, City> {
    @NotNull
    public City apply(@NotNull CityEntity cityEntity) {
        Intrinsics.checkNotNullParameter(cityEntity, "source");
        Integer id2 = cityEntity.getId();
        int i11 = -1;
        int intValue = id2 != null ? id2.intValue() : -1;
        Integer countryId = cityEntity.getCountryId();
        if (countryId != null) {
            i11 = countryId.intValue();
        }
        String name2 = cityEntity.getName();
        if (name2 == null) {
            name2 = "";
        }
        return new City(intValue, i11, name2);
    }
}
