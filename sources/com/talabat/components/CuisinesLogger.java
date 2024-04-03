package com.talabat.components;

import android.content.Context;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/talabat/components/CuisinesLogger;", "Lcom/talabat/cuisines/navigation/CuisinesLogger;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "displayErrorMessage", "", "throwable", "", "error", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesLogger implements com.talabat.cuisines.navigation.CuisinesLogger {
    @NotNull
    private final Context context;

    @CuisinesIntegrationDsl
    public CuisinesLogger(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void displayErrorMessage(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        CoroutinesKt.runHandling$default((Function1) null, new CuisinesLogger$displayErrorMessage$1(th2, this), 1, (Object) null);
    }

    public void error(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        CoroutinesKt.runHandling$default((Function1) null, new CuisinesLogger$error$1(th2), 1, (Object) null);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }
}
