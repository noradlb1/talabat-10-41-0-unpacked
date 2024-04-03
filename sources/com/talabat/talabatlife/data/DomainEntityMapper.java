package com.talabat.talabatlife.data;

import com.talabat.talabatlife.data.remote.dto.FiltersResponseRemoteDto;
import com.talabat.talabatlife.data.remote.dto.Result;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/talabat/talabatlife/data/DomainEntityMapper;", "", "()V", "mapRemoteDtoToFilters", "Lkotlin/Pair;", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "Lcom/talabat/talabatlife/domain/entity/Filter;", "filtersResponseRemoteDto", "Lcom/talabat/talabatlife/data/remote/dto/FiltersResponseRemoteDto;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DomainEntityMapper {
    @NotNull
    public final Pair<List<Cuisine>, List<Filter>> mapRemoteDtoToFilters(@NotNull FiltersResponseRemoteDto filtersResponseRemoteDto) {
        List list;
        List list2;
        Iterable offerTypes;
        Iterable cuisines;
        Intrinsics.checkNotNullParameter(filtersResponseRemoteDto, "filtersResponseRemoteDto");
        Result result = filtersResponseRemoteDto.getResult();
        if (result == null || (cuisines = result.getCuisines()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Iterable<com.talabat.talabatlife.data.remote.dto.Cuisine> iterable = cuisines;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (com.talabat.talabatlife.data.remote.dto.Cuisine cuisine : iterable) {
                list.add(new Cuisine(cuisine.getId(), cuisine.getName(), cuisine.getSlug()));
            }
        }
        Result result2 = filtersResponseRemoteDto.getResult();
        if (result2 == null || (offerTypes = result2.getOfferTypes()) == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Iterable<com.talabat.talabatlife.data.remote.dto.Filter> iterable2 = offerTypes;
            list2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
            for (com.talabat.talabatlife.data.remote.dto.Filter filter : iterable2) {
                list2.add(new Filter(filter.getId(), filter.getName(), filter.getSlug()));
            }
        }
        return new Pair<>(list, list2);
    }
}
