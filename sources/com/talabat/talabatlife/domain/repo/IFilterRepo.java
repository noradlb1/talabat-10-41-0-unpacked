package com.talabat.talabatlife.domain.repo;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00050\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatlife/domain/repo/IFilterRepo;", "", "getFilters", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lkotlin/Pair;", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "Lcom/talabat/talabatlife/domain/entity/Filter;", "countryId", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFilterRepo {
    @NotNull
    Either<Failure, Pair<List<Cuisine>, List<Filter>>> getFilters(int i11);
}
