package com.talabat.core.work.di;

import androidx.work.WorkerFactory;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/work/di/WorkCoreLibComponent;", "Lcom/talabat/core/work/di/WorkCoreLibApi;", "Factory", "com_talabat_core_work_work"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(modules = {WorkCoreLibModule.class})
public interface WorkCoreLibComponent extends WorkCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0013\b\u0001\u0010\u0004\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00070\u0005H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/work/di/WorkCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/work/di/WorkCoreLibComponent;", "workerFactories", "", "Landroidx/work/WorkerFactory;", "Lkotlin/jvm/JvmSuppressWildcards;", "com_talabat_core_work_work"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        WorkCoreLibComponent create(@NotNull @BindsInstance Set<WorkerFactory> set);
    }
}
