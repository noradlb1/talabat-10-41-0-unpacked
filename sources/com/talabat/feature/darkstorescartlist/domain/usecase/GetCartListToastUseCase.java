package com.talabat.feature.darkstorescartlist.domain.usecase;

import com.talabat.feature.darkstorescartlist.domain.model.CartListToast;
import io.reactivex.Maybe;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCase;", "", "invoke", "Lio/reactivex/Maybe;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "globalVendorId", "", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetCartListToastUseCase {
    @NotNull
    Maybe<CartListToast> invoke(@NotNull String str);
}
