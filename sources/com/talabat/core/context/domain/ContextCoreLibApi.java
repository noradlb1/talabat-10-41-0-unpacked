package com.talabat.core.context.domain;

import android.app.Application;
import android.content.Context;
import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/core/context/domain/ContextCoreLibApi;", "Lcom/talabat/core/di/Api;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "context", "Landroid/content/Context;", "getContext$annotations", "()V", "getContext", "()Landroid/content/Context;", "com_talabat_core_context_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ContextCoreLibApi extends Api {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @ApplicationContext
        public static /* synthetic */ void getContext$annotations() {
        }
    }

    @NotNull
    Application getApplication();

    @NotNull
    Context getContext();
}
