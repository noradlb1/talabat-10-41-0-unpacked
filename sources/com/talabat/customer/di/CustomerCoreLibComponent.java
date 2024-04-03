package com.talabat.customer.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/customer/di/CustomerCoreLibComponent;", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "Factory", "com_talabat_core_customer_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class}, modules = {CustomerCoreLibModule.class})
public interface CustomerCoreLibComponent extends CustomerCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/customer/di/CustomerCoreLibComponent$Factory;", "", "create", "Lcom/talabat/customer/di/CustomerCoreLibComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "com_talabat_core_customer_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        CustomerCoreLibComponent create(@NotNull ContextCoreLibApi contextCoreLibApi);
    }
}
