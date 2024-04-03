package com.talabat.components;

import android.content.Context;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/components/FiltersLogger;", "Lcom/talabat/filters/navigation/FiltersLogger;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayErrorMessage", "", "throwable", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersLogger implements com.talabat.filters.navigation.FiltersLogger {
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;

    @FiltersIntegrationDsl
    public FiltersLogger(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void displayErrorMessage(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        LogManager.logException(th2);
        CoroutinesKt.launchCatching$default(GlobalScope.INSTANCE, (Function1) null, Dispatchers.getMain(), new FiltersLogger$displayErrorMessage$1(this, th2, (Continuation<? super FiltersLogger$displayErrorMessage$1>) null), 1, (Object) null);
    }
}
