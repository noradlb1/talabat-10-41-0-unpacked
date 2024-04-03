package com.talabat.feature.referafriend.presentation.di;

import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/di/ReferAFriendFlutterActivityModule;", "", "provideVoucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "voucherRepositoryImpl", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepositoryImpl;", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {VoucherRepositoryModule.class})
public interface ReferAFriendFlutterActivityModule {
    @NotNull
    @Binds
    @Reusable
    VoucherRepository provideVoucherRepository(@NotNull VoucherRepositoryImpl voucherRepositoryImpl);
}
