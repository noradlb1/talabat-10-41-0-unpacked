package com.talabat.darkstores.di;

import com.talabat.darkstores.domain.cart.IsFlutterCartEnabledUseCase;
import com.talabat.darkstores.domain.cart.IsFlutterCartEnabledUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresCartModule;", "", "bindIsFlutterCartEnabledUseCase", "Lcom/talabat/darkstores/domain/cart/IsFlutterCartEnabledUseCase;", "impl", "Lcom/talabat/darkstores/domain/cart/IsFlutterCartEnabledUseCaseImpl;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresCartModule {
    @NotNull
    @Binds
    IsFlutterCartEnabledUseCase bindIsFlutterCartEnabledUseCase(@NotNull IsFlutterCartEnabledUseCaseImpl isFlutterCartEnabledUseCaseImpl);
}
