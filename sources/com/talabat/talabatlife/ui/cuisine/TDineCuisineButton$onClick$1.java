package com.talabat.talabatlife.ui.cuisine;

import com.talabat.talabatlife.domain.entity.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/talabatlife/ui/cuisine/TDineCuisineButton$onClick$1", "Lcom/talabat/talabatlife/ui/cuisine/ICuisineRepository;", "getCuisines", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TDineCuisineButton$onClick$1 implements ICuisineRepository {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TDineCuisineButton f12064a;

    public TDineCuisineButton$onClick$1(TDineCuisineButton tDineCuisineButton) {
        this.f12064a = tDineCuisineButton;
    }

    @NotNull
    public List<Cuisine> getCuisines() {
        List<Cuisine> cuisineList = this.f12064a.getCuisineList();
        Intrinsics.checkNotNull(cuisineList);
        return cuisineList;
    }
}
