package com.talabat.filters;

import android.app.Application;
import com.talabat.filters.domain.FiltersRepository;
import com.talabat.filters.navigation.FiltersLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0012H\u0007\"\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0000\u001a\u00020\u0005@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0000\u001a\u00020\t@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"<set-?>", "Landroid/app/Application;", "AppContext", "getAppContext", "()Landroid/app/Application;", "Lcom/talabat/filters/navigation/FiltersLogger;", "Logger", "getLogger", "()Lcom/talabat/filters/navigation/FiltersLogger;", "Lcom/talabat/filters/domain/FiltersRepository;", "Repository", "getRepository", "()Lcom/talabat/filters/domain/FiltersRepository;", "FiltersIntegration", "", "integrate", "Lkotlin/Function1;", "Lcom/talabat/filters/FiltersIntegrator;", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FiltersIntegratorKt {
    private static Application AppContext;
    /* access modifiers changed from: private */
    public static FiltersLogger Logger;
    /* access modifiers changed from: private */
    public static FiltersRepository Repository;

    @IntegrationDsl
    public static final void FiltersIntegration(@NotNull Application application, @NotNull Function1<? super FiltersIntegrator, Unit> function1) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(function1, "integrate");
        AppContext = application;
        function1.invoke(FiltersIntegrator.INSTANCE);
    }

    @NotNull
    public static final Application getAppContext() {
        Application application = AppContext;
        if (application != null) {
            return application;
        }
        Intrinsics.throwUninitializedPropertyAccessException("AppContext");
        return null;
    }

    @NotNull
    public static final FiltersLogger getLogger() {
        FiltersLogger filtersLogger = Logger;
        if (filtersLogger != null) {
            return filtersLogger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("Logger");
        return null;
    }

    @NotNull
    public static final FiltersRepository getRepository() {
        FiltersRepository filtersRepository = Repository;
        if (filtersRepository != null) {
            return filtersRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("Repository");
        return null;
    }
}
