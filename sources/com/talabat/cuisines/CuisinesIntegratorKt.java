package com.talabat.cuisines;

import android.app.Application;
import com.talabat.cuisines.domain.CuisinesRepository;
import com.talabat.cuisines.navigation.CuisinesLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0012H\u0004\"\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0000\u001a\u00020\u0005@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0000\u001a\u00020\t@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"<set-?>", "Landroid/app/Application;", "AppContext", "getAppContext", "()Landroid/app/Application;", "Lcom/talabat/cuisines/navigation/CuisinesLogger;", "Logger", "getLogger", "()Lcom/talabat/cuisines/navigation/CuisinesLogger;", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "Repository", "getRepository", "()Lcom/talabat/cuisines/domain/CuisinesRepository;", "CuisinesIntegration", "", "integrate", "Lkotlin/Function1;", "Lcom/talabat/cuisines/CuisinesIntegrator;", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CuisinesIntegratorKt {
    private static Application AppContext;
    /* access modifiers changed from: private */
    public static CuisinesLogger Logger;
    /* access modifiers changed from: private */
    public static CuisinesRepository Repository;

    @IntegrationDsl
    public static final void CuisinesIntegration(@NotNull Application application, @NotNull Function1<? super CuisinesIntegrator, Unit> function1) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(function1, "integrate");
        AppContext = application;
        function1.invoke(CuisinesIntegrator.INSTANCE);
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
    public static final CuisinesLogger getLogger() {
        CuisinesLogger cuisinesLogger = Logger;
        if (cuisinesLogger != null) {
            return cuisinesLogger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("Logger");
        return null;
    }

    @NotNull
    public static final CuisinesRepository getRepository() {
        CuisinesRepository cuisinesRepository = Repository;
        if (cuisinesRepository != null) {
            return cuisinesRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("Repository");
        return null;
    }
}
