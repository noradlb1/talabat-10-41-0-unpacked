package com.talabat.talabatlife.data;

import com.talabat.talabatlife.data.remote.dto.FiltersResponseRemoteDto;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "Lcom/talabat/talabatlife/domain/entity/Filter;", "it", "Lcom/talabat/talabatlife/data/remote/dto/FiltersResponseRemoteDto;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FilterRepo$getFilters$1 extends Lambda implements Function1<FiltersResponseRemoteDto, Pair<? extends List<? extends Cuisine>, ? extends List<? extends Filter>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FilterRepo f12033g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterRepo$getFilters$1(FilterRepo filterRepo) {
        super(1);
        this.f12033g = filterRepo;
    }

    @NotNull
    public final Pair<List<Cuisine>, List<Filter>> invoke(@NotNull FiltersResponseRemoteDto filtersResponseRemoteDto) {
        Intrinsics.checkNotNullParameter(filtersResponseRemoteDto, "it");
        return this.f12033g.domainEntityMapper.mapRemoteDtoToFilters(filtersResponseRemoteDto);
    }
}
