package com.talabat.feature.activecarts.domain.usecase;

import io.reactivex.Maybe;
import java.util.List;
import kotlin.Metadata;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;", "", "invoke", "Lio/reactivex/Maybe;", "", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetQCommerceCartListUseCase {
    @NotNull
    Maybe<List<ActiveCartInfo>> invoke();
}
