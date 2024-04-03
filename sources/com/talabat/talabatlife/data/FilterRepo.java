package com.talabat.talabatlife.data;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatlife.data.remote.IFiltersRemoteDataSource;
import com.talabat.talabatlife.data.remote.dto.FiltersResponseRemoteDto;
import com.talabat.talabatlife.data.remote.dto.Result;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import com.talabat.talabatlife.domain.repo.IFilterRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J4\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\t\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000b0\n0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatlife/data/FilterRepo;", "Lcom/talabat/talabatlife/domain/repo/IFilterRepo;", "filtersRemoteDataSource", "Lcom/talabat/talabatlife/data/remote/IFiltersRemoteDataSource;", "domainEntityMapper", "Lcom/talabat/talabatlife/data/DomainEntityMapper;", "(Lcom/talabat/talabatlife/data/remote/IFiltersRemoteDataSource;Lcom/talabat/talabatlife/data/DomainEntityMapper;)V", "getFilters", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lkotlin/Pair;", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "Lcom/talabat/talabatlife/domain/entity/Filter;", "countryId", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterRepo implements IFilterRepo {
    /* access modifiers changed from: private */
    @NotNull
    public final DomainEntityMapper domainEntityMapper;
    @NotNull
    private final IFiltersRemoteDataSource filtersRemoteDataSource;

    public FilterRepo(@NotNull IFiltersRemoteDataSource iFiltersRemoteDataSource, @NotNull DomainEntityMapper domainEntityMapper2) {
        Intrinsics.checkNotNullParameter(iFiltersRemoteDataSource, "filtersRemoteDataSource");
        Intrinsics.checkNotNullParameter(domainEntityMapper2, "domainEntityMapper");
        this.filtersRemoteDataSource = iFiltersRemoteDataSource;
        this.domainEntityMapper = domainEntityMapper2;
    }

    @NotNull
    public Either<Failure, Pair<List<Cuisine>, List<Filter>>> getFilters(int i11) {
        return RequestKt.request(this.filtersRemoteDataSource.getFilters(i11), new FilterRepo$getFilters$1(this), new FiltersResponseRemoteDto((Result) null, 1, (DefaultConstructorMarker) null));
    }
}
