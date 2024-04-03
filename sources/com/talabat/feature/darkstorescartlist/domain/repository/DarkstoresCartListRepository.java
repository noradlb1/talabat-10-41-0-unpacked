package com.talabat.feature.darkstorescartlist.domain.repository;

import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;", "", "getCartInfoList", "Lio/reactivex/Single;", "", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartInfo;", "invalidateCartInfoListCache", "", "isCartListToastShown", "", "cartCount", "", "variation", "", "setCartListToastShown", "shown", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresCartListRepository {
    @NotNull
    Single<List<CartInfo>> getCartInfoList();

    void invalidateCartInfoListCache();

    boolean isCartListToastShown(int i11, @NotNull String str);

    void setCartListToastShown(int i11, @NotNull String str, boolean z11);
}
