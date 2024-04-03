package com.talabat.userandlocation.compliance.status.di.module;

import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcore.cache.Cache;
import com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl;
import com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusApi;
import com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/di/module/UserStatusDomainModule;", "", "()V", "durationStatusCanBeCheckedAgain", "", "getDurationStatusCanBeCheckedAgain", "()J", "provideUserStatusRepository", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserStatusDomainModule {
    @NotNull
    public static final UserStatusDomainModule INSTANCE = new UserStatusDomainModule();
    private static final long durationStatusCanBeCheckedAgain = TimeUnit.MINUTES.toMillis(30);

    private UserStatusDomainModule() {
    }

    public final long getDurationStatusCanBeCheckedAgain() {
        return durationStatusCanBeCheckedAgain;
    }

    @NotNull
    public final UserStatusRepository provideUserStatusRepository() {
        return new UserStatusRepositoryImpl(new UserStatusRemoteDataSourceImpl((UserStatusApi) new TalabatAPIBuilder().createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), UserStatusApi.class)), (Cache) null, 2, (DefaultConstructorMarker) null);
    }
}
