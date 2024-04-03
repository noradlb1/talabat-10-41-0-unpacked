package com.talabat.feature.tmart.growth.domain.confirmation;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/confirmation/TMartGrowthConfirmationImagesUseCase;", "", "repository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "imageFileManager", "Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;", "(Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;)V", "imageFiles", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "getImageFiles", "()Lkotlinx/coroutines/flow/Flow;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalCoroutinesApi
public final class TMartGrowthConfirmationImagesUseCase {
    @NotNull
    private final Flow<TMartGrowthFilePath> imageFiles;

    @Inject
    public TMartGrowthConfirmationImagesUseCase(@NotNull ITMartGrowthRepository iTMartGrowthRepository, @NotNull ITMartGrowthFileManager iTMartGrowthFileManager) {
        Intrinsics.checkNotNullParameter(iTMartGrowthRepository, "repository");
        Intrinsics.checkNotNullParameter(iTMartGrowthFileManager, "imageFileManager");
        this.imageFiles = FlowKt.transformLatest(FlowKt.take(iTMartGrowthRepository.getLoaderData(), 1), new TMartGrowthConfirmationImagesUseCase$special$$inlined$flatMapLatest$1((Continuation) null, iTMartGrowthFileManager));
    }

    @NotNull
    public final Flow<TMartGrowthFilePath> getImageFiles() {
        return this.imageFiles;
    }
}
