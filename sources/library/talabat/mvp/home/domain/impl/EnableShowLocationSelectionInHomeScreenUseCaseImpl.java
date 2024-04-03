package library.talabat.mvp.home.domain.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.data.repository.impl.ShowLocationSelectionRepositoryImpl;
import library.talabat.mvp.home.domain.EnableShowLocationSelectionInHomeScreenUseCase;
import library.talabat.mvp.home.domain.repository.ShowLocationSelectionRepository;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Llibrary/talabat/mvp/home/domain/impl/EnableShowLocationSelectionInHomeScreenUseCaseImpl;", "Llibrary/talabat/mvp/home/domain/EnableShowLocationSelectionInHomeScreenUseCase;", "showLocationSelectionRepository", "Llibrary/talabat/mvp/home/domain/repository/ShowLocationSelectionRepository;", "(Llibrary/talabat/mvp/home/domain/repository/ShowLocationSelectionRepository;)V", "enableShowLocationSelectionInHomeScreen", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnableShowLocationSelectionInHomeScreenUseCaseImpl implements EnableShowLocationSelectionInHomeScreenUseCase {
    @NotNull
    private final ShowLocationSelectionRepository showLocationSelectionRepository;

    public EnableShowLocationSelectionInHomeScreenUseCaseImpl() {
        this((ShowLocationSelectionRepository) null, 1, (DefaultConstructorMarker) null);
    }

    public EnableShowLocationSelectionInHomeScreenUseCaseImpl(@NotNull ShowLocationSelectionRepository showLocationSelectionRepository2) {
        Intrinsics.checkNotNullParameter(showLocationSelectionRepository2, "showLocationSelectionRepository");
        this.showLocationSelectionRepository = showLocationSelectionRepository2;
    }

    public void enableShowLocationSelectionInHomeScreen() {
        this.showLocationSelectionRepository.setShouldShowLocationSelectionOnHomeScreen(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EnableShowLocationSelectionInHomeScreenUseCaseImpl(ShowLocationSelectionRepository showLocationSelectionRepository2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? ShowLocationSelectionRepositoryImpl.INSTANCE : showLocationSelectionRepository2);
    }
}
