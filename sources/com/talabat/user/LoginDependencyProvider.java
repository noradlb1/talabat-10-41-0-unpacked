package com.talabat.user;

import android.content.Context;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.user.status.data.impl.IsUserRegisteredRepositoryImpl;
import com.talabat.user.status.data.remote.api.UserRegistrationStatusApi;
import com.talabat.user.status.data.remote.impl.IsUserRegisteredRemoteDataSourceImpl;
import com.talabat.user.status.domain.repository.IsUserRegisteredRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/user/LoginDependencyProvider;", "", "()V", "provideIsUserRegisteredRepository", "Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository;", "context", "Landroid/content/Context;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginDependencyProvider {
    @NotNull
    public static final LoginDependencyProvider INSTANCE = new LoginDependencyProvider();

    private LoginDependencyProvider() {
    }

    @NotNull
    public final IsUserRegisteredRepository provideIsUserRegisteredRepository(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new IsUserRegisteredRepositoryImpl(new IsUserRegisteredRemoteDataSourceImpl((UserRegistrationStatusApi) new TalabatAPIBuilder().createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), UserRegistrationStatusApi.class)), new DeviceIdProviderImpl(context), (Function0) null, 4, (DefaultConstructorMarker) null);
    }
}
