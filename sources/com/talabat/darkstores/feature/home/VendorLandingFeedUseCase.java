package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/home/VendorLandingFeedUseCase;", "", "getFeedMultiListData", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/discovery/model/FeedMultiListData;", "pageType", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorLandingFeedUseCase {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getFeedMultiListData$default(VendorLandingFeedUseCase vendorLandingFeedUseCase, FeedEndpointRequest.PageType pageType, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    pageType = null;
                }
                return vendorLandingFeedUseCase.getFeedMultiListData(pageType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFeedMultiListData");
        }
    }

    @NotNull
    Single<FeedMultiListData> getFeedMultiListData(@Nullable FeedEndpointRequest.PageType pageType);
}
