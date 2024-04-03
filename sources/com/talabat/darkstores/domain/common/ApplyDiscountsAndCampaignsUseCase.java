package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.model.ProductsHolder;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u0004H¦\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;", "", "invoke", "Lio/reactivex/Single;", "T", "Lcom/talabat/darkstores/domain/model/ProductsHolder;", "response", "(Lcom/talabat/darkstores/domain/model/ProductsHolder;)Lio/reactivex/Single;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApplyDiscountsAndCampaignsUseCase {
    @NotNull
    <T extends ProductsHolder<T>> Single<T> invoke(@NotNull T t11);
}
