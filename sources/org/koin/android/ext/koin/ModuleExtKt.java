package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.android.error.MissingAndroidContextException;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"ERROR_MSG", "", "androidApplication", "Landroid/app/Application;", "Lorg/koin/core/scope/Scope;", "androidContext", "Landroid/content/Context;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ModuleExtKt {
    @NotNull
    public static final String ERROR_MSG = "Please use androidContext() function in your KoinApplication configuration.";

    @NotNull
    public static final Application androidApplication(@NotNull Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        try {
            return (Application) scope.get(Reflection.getOrCreateKotlinClass(Application.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        } catch (Exception unused) {
            throw new MissingAndroidContextException("Can't resolve Application instance. Please use androidContext() function in your KoinApplication configuration.");
        }
    }

    @NotNull
    public static final Context androidContext(@NotNull Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        try {
            return (Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        } catch (Exception unused) {
            throw new MissingAndroidContextException("Can't resolve Context instance. Please use androidContext() function in your KoinApplication configuration.");
        }
    }
}
