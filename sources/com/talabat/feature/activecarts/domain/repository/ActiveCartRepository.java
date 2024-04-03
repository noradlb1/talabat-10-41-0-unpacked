package com.talabat.feature.activecarts.domain.repository;

import io.reactivex.Maybe;
import java.util.List;
import kotlin.Metadata;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0003H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;", "", "getFoodCart", "Lio/reactivex/Maybe;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "getQCommerceCart", "getQCommerceCartList", "", "invalidateQCommerceCartListCache", "", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ActiveCartRepository {
    @NotNull
    Maybe<ActiveCartInfo> getFoodCart();

    @NotNull
    Maybe<ActiveCartInfo> getQCommerceCart();

    @NotNull
    Maybe<List<ActiveCartInfo>> getQCommerceCartList();

    void invalidateQCommerceCartListCache();
}
