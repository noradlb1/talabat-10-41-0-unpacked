package com.talabat.talabatlife.ui.cuisine;

import com.talabat.talabatlife.domain.entity.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/GetCuisineUseCase;", "", "cuisineRepository", "Lcom/talabat/talabatlife/ui/cuisine/ICuisineRepository;", "(Lcom/talabat/talabatlife/ui/cuisine/ICuisineRepository;)V", "invoke", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCuisineUseCase {
    @NotNull
    private final ICuisineRepository cuisineRepository;

    public GetCuisineUseCase(@NotNull ICuisineRepository iCuisineRepository) {
        Intrinsics.checkNotNullParameter(iCuisineRepository, "cuisineRepository");
        this.cuisineRepository = iCuisineRepository;
    }

    @NotNull
    public final List<Cuisine> invoke() {
        return this.cuisineRepository.getCuisines();
    }
}
