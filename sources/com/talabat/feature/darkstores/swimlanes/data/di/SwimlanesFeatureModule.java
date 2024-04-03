package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.feature.darkstores.swimlanes.data.RealSwimlanesRepository;
import com.talabat.feature.darkstores.swimlanes.data.remote.mapper.SwimlanesMapper;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponse;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesRepository;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import com.talabat.mapper.ModelMapper;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/di/SwimlanesFeatureModule;", "", "swimlanesMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesResponse;", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesData;", "impl", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/mapper/SwimlanesMapper;", "swimlanesRepository", "Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesRepository;", "repository", "Lcom/talabat/feature/darkstores/swimlanes/data/RealSwimlanesRepository;", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {SwimlanesNetworkModule.class, SwimlanesUserDataModule.class})
public interface SwimlanesFeatureModule {
    @NotNull
    @Binds
    ModelMapper<SwimlanesResponse, SwimlanesData> swimlanesMapper(@NotNull SwimlanesMapper swimlanesMapper);

    @NotNull
    @Binds
    @Reusable
    SwimlanesRepository swimlanesRepository(@NotNull RealSwimlanesRepository realSwimlanesRepository);
}
