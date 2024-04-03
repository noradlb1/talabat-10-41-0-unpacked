package com.deliveryhero.perseus.di;

import android.content.Context;
import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.core.session.ClientIdProvider;
import com.deliveryhero.perseus.hits.usecase.DeleteStaleEventsUseCase;
import com.deliveryhero.perseus.hits.usecase.PerseusSaveHitUseCase;
import com.deliveryhero.perseus.logger.DatabaseInfoLogger;
import com.deliveryhero.perseus.logger.PerseusLogger;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/deliveryhero/perseus/di/PerseusAppComponent;", "", "()V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "isInitialized", "", "()Z", "getAppSessionProvider", "Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "getClientIdProvider", "Lcom/deliveryhero/perseus/core/session/ClientIdProvider;", "getDatabaseInfoLogger", "Lcom/deliveryhero/perseus/logger/DatabaseInfoLogger;", "getDeleteStaleEventsUseCase", "Lcom/deliveryhero/perseus/hits/usecase/DeleteStaleEventsUseCase;", "getPerseusSaveHitUseCase", "Lcom/deliveryhero/perseus/hits/usecase/PerseusSaveHitUseCase;", "initializeComponent", "", "config", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "updateBatchDispatchHitsDelay", "batchDispatchHitsDelay", "", "updateConfig", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusAppComponent {
    @NotNull
    public static final PerseusAppComponent INSTANCE = new PerseusAppComponent();
    public static Context applicationContext;

    private PerseusAppComponent() {
    }

    public static /* synthetic */ void updateConfig$default(PerseusAppComponent perseusAppComponent, PerseusParamsConfig perseusParamsConfig, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            perseusParamsConfig = null;
        }
        perseusAppComponent.updateConfig(perseusParamsConfig);
    }

    @NotNull
    public final AppSessionManager getAppSessionProvider() {
        return CoreModule.INSTANCE.getAppSessionManager();
    }

    @NotNull
    public final Context getApplicationContext() {
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        return null;
    }

    @NotNull
    public final ClientIdProvider getClientIdProvider() {
        return CoreModule.INSTANCE.getClientIdProvider();
    }

    @NotNull
    public final DatabaseInfoLogger getDatabaseInfoLogger() {
        return LoggerModule.INSTANCE.getDatabaseInfoLogger();
    }

    @NotNull
    public final DeleteStaleEventsUseCase getDeleteStaleEventsUseCase() {
        return HitsModule.INSTANCE.getDeleteStaleEventsUseCase();
    }

    @NotNull
    public final PerseusSaveHitUseCase getPerseusSaveHitUseCase() {
        return HitsModule.INSTANCE.getPerseusSaveHitUseCase();
    }

    public final void initializeComponent(@NotNull Context context, @NotNull PerseusParamsConfig perseusParamsConfig) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(perseusParamsConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        setApplicationContext(context);
        updateConfig(perseusParamsConfig);
    }

    public final boolean isInitialized() {
        return applicationContext != null;
    }

    public final void setApplicationContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        applicationContext = context;
    }

    public final void updateBatchDispatchHitsDelay(long j11) {
        DataModule.INSTANCE.getPerseusConfigLocalDataStore().putBatchDispatchHitsDelay(j11);
    }

    public final void updateConfig(@Nullable PerseusParamsConfig perseusParamsConfig) {
        if (!isInitialized()) {
            PerseusLogger.w$default(LoggerModule.INSTANCE.getPerseusLogger(), "Failed to update configuration because the app context has not been initialized. Please initialize it first.", (Throwable) null, 2, (Object) null);
        } else if (perseusParamsConfig != null) {
            DataModule.INSTANCE.getPerseusConfigLocalDataStore().putConfig(perseusParamsConfig);
        }
    }
}
