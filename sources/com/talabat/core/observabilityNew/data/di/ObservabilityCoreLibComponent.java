package com.talabat.core.observabilityNew.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/ObservabilityCoreLibComponent;", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "Factory", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, TalabatPerseusCoreLibApi.class}, modules = {ObservabilityCoreLibModule.class})
public interface ObservabilityCoreLibComponent extends ObservabilityCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/ObservabilityCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/observabilityNew/data/di/ObservabilityCoreLibComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "talabatPerseusCoreLibApi", "Lcom/talabat/core/perseus/domain/TalabatPerseusCoreLibApi;", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ObservabilityCoreLibComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull TalabatPerseusCoreLibApi talabatPerseusCoreLibApi);
    }
}
