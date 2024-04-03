package com.talabat.core.hms.push.presentation.di;

import android.content.Context;
import com.braze.Braze;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/hms/push/presentation/di/HmsPushServiceModule;", "", "()V", "appBoy", "Lcom/braze/Braze;", "context", "Landroid/content/Context;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "com_talabat_core_hms_push_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class HmsPushServiceModule {
    @NotNull
    public static final HmsPushServiceModule INSTANCE = new HmsPushServiceModule();

    private HmsPushServiceModule() {
    }

    @NotNull
    @Provides
    public final Braze appBoy(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Braze.Companion.getInstance(context);
    }

    @NotNull
    @Provides
    public final CoroutineScope uiScope(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        return CoroutineScopeKt.CoroutineScope(coroutineDispatchersFactory.main().plus(JobKt.Job$default((Job) null, 1, (Object) null)));
    }
}
