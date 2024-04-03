package com.talabat.core.fwf.data.di;

import com.talabat.core.fwf.data.config.FWFManagerImpl;
import com.talabat.core.fwf.domain.config.IFWFManager;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/fwf/data/di/FWFManagerCoreLibModule;", "", "fwfManager", "Lcom/talabat/core/fwf/domain/config/IFWFManager;", "fwfManagerImpl", "Lcom/talabat/core/fwf/data/config/FWFManagerImpl;", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FWFManagerCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    IFWFManager fwfManager(@NotNull FWFManagerImpl fWFManagerImpl);
}
