package com.talabat.feature.darkstoresvendor.data.di;

import com.talabat.feature.darkstoresvendor.data.mapper.VendorResponseMapper;
import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.feature.darkstoresvendor.data.repository.VendorRepositoryImpl;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import com.talabat.mapper.ModelMapper;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/di/VendorDataModule;", "", "bindsVendorRepository", "Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;", "vendorRepository", "Lcom/talabat/feature/darkstoresvendor/data/repository/VendorRepositoryImpl;", "bindsVendorResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "vendorResponseMapper", "Lcom/talabat/feature/darkstoresvendor/data/mapper/VendorResponseMapper;", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface VendorDataModule {
    @NotNull
    @Binds
    @Reusable
    VendorRepository bindsVendorRepository(@NotNull VendorRepositoryImpl vendorRepositoryImpl);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<VendorResponse, Vendor> bindsVendorResponseMapper(@NotNull VendorResponseMapper vendorResponseMapper);
}
