package com.talabat.core.context.data;

import android.app.Application;
import android.content.Context;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.context.domain.ContextCoreLibApi;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/context/data/ContextCoreLibComponent;", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "Factory", "com_talabat_core_context_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component
public interface ContextCoreLibComponent extends ContextCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/context/data/ContextCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/context/data/ContextCoreLibComponent;", "application", "Landroid/app/Application;", "context", "Landroid/content/Context;", "com_talabat_core_context_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ContextCoreLibComponent create(@NotNull @BindsInstance Application application, @NotNull @ApplicationContext @BindsInstance Context context);
    }
}
