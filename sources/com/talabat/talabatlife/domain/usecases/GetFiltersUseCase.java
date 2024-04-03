package com.talabat.talabatlife.domain.usecases;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import com.talabat.talabatlife.domain.repo.IFilterRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002&\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00030\u0002\u0012\u0004\u0012\u00020\u00060\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ=\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatlife/domain/usecases/GetFiltersUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lkotlin/Pair;", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "Lcom/talabat/talabatlife/domain/entity/Filter;", "Lcom/talabat/talabatlife/domain/usecases/GetFiltersUseCase$Params;", "filterRepository", "Lcom/talabat/talabatlife/domain/repo/IFilterRepo;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatlife/domain/repo/IFilterRepo;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatlife/domain/usecases/GetFiltersUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFiltersUseCase extends UseCase<Pair<? extends List<? extends Cuisine>, ? extends List<? extends Filter>>, Params> {
    @NotNull
    private final IFilterRepo filterRepository;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatlife/domain/usecases/GetFiltersUseCase$Params;", "", "countryId", "", "(I)V", "getCountryId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final int countryId;

        public Params(int i11) {
            this.countryId = i11;
        }

        public static /* synthetic */ Params copy$default(Params params, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = params.countryId;
            }
            return params.copy(i11);
        }

        public final int component1() {
            return this.countryId;
        }

        @NotNull
        public final Params copy(int i11) {
            return new Params(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && this.countryId == ((Params) obj).countryId;
        }

        public final int getCountryId() {
            return this.countryId;
        }

        public int hashCode() {
            return this.countryId;
        }

        @NotNull
        public String toString() {
            int i11 = this.countryId;
            return "Params(countryId=" + i11 + ")";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetFiltersUseCase(@NotNull IFilterRepo iFilterRepo, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(iFilterRepo, "filterRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.filterRepository = iFilterRepo;
    }

    @Nullable
    public Object run(@NotNull Params params, @NotNull Continuation<? super Either<? extends Failure, ? extends Pair<? extends List<Cuisine>, ? extends List<Filter>>>> continuation) {
        return this.filterRepository.getFilters(params.getCountryId());
    }
}
