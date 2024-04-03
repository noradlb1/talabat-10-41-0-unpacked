package com.talabat.flutter.secrets.data.di;

import com.talabat.flutter.secrets.data.handler.SecretsMethodCallHandlerImpl;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/flutter/secrets/data/di/FlutterSecretsModule;", "", "bindSecretsMethodCallHandler", "Lcom/talabat/flutter/secrets/domain/handler/SecretsMethodCallHandler;", "impl", "Lcom/talabat/flutter/secrets/data/handler/SecretsMethodCallHandlerImpl;", "com_talabat_core_flutter-secrets_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FlutterSecretsModule {
    @NotNull
    @Binds
    SecretsMethodCallHandler bindSecretsMethodCallHandler(@NotNull SecretsMethodCallHandlerImpl secretsMethodCallHandlerImpl);
}
