package com.talabat.feature.referafriend.data.di;

import com.talabat.feature.referafriend.domain.di.ReferAFriendFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/referafriend/data/di/ReferAFriendFeatureComponent;", "Lcom/talabat/feature/referafriend/domain/di/ReferAFriendFeatureApi;", "Factory", "com_talabat_feature_refer-a-friend_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component
public interface ReferAFriendFeatureComponent extends ReferAFriendFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/feature/referafriend/data/di/ReferAFriendFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/referafriend/data/di/ReferAFriendFeatureComponent;", "com_talabat_feature_refer-a-friend_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ReferAFriendFeatureComponent create();
    }
}
