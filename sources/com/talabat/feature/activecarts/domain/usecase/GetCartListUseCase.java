package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.model.BasketType;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH¦\u0002¨\u0006\f"}, d2 = {"Lcom/talabat/feature/activecarts/domain/usecase/GetCartListUseCase;", "", "invoke", "Lio/reactivex/Single;", "", "", "", "basketTypes", "", "Lcom/talabat/feature/activecarts/domain/model/BasketType;", "invalidateCache", "", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetCartListUseCase {
    @NotNull
    Single<List<Map<String, Object>>> invoke(@NotNull Set<? extends BasketType> set, boolean z11);
}
