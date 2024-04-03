package com.talabat.app.di;

import com.talabat.app.App;
import com.talabat.core.di.Api;
import dagger.Component;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J#\u0010\u0006\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b0\u0007H&¨\u0006\r"}, d2 = {"Lcom/talabat/app/di/AppComponent;", "", "inject", "", "target", "Lcom/talabat/app/App;", "mergedMap", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/di/Api;", "Lkotlin/jvm/JvmSuppressWildcards;", "Factory", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(modules = {AppModule.class, CoreApiModule.class, FeatureApiModule.class})
public interface AppComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/app/di/AppComponent$Factory;", "", "create", "Lcom/talabat/app/di/AppComponent;", "coreLibsModule", "Lcom/talabat/app/di/CoreLibsModule;", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        AppComponent create(@NotNull CoreLibsModule coreLibsModule);
    }

    void inject(@NotNull App app);

    @NotNull
    Map<Class<?>, Provider<Api>> mergedMap();
}
