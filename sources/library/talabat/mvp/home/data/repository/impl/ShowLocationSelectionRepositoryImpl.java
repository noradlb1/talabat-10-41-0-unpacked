package library.talabat.mvp.home.data.repository.impl;

import kotlin.Metadata;
import library.talabat.mvp.home.domain.repository.ShowLocationSelectionRepository;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/home/data/repository/impl/ShowLocationSelectionRepositoryImpl;", "Llibrary/talabat/mvp/home/domain/repository/ShowLocationSelectionRepository;", "()V", "shouldShowLocationSelectionOnHomeScreen", "", "getShouldShowLocationSelectionOnHomeScreen", "()Z", "setShouldShowLocationSelectionOnHomeScreen", "(Z)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShowLocationSelectionRepositoryImpl implements ShowLocationSelectionRepository {
    @NotNull
    public static final ShowLocationSelectionRepositoryImpl INSTANCE = new ShowLocationSelectionRepositoryImpl();
    private static boolean shouldShowLocationSelectionOnHomeScreen;

    private ShowLocationSelectionRepositoryImpl() {
    }

    public boolean getShouldShowLocationSelectionOnHomeScreen() {
        return shouldShowLocationSelectionOnHomeScreen;
    }

    public void setShouldShowLocationSelectionOnHomeScreen(boolean z11) {
        shouldShowLocationSelectionOnHomeScreen = z11;
    }
}
