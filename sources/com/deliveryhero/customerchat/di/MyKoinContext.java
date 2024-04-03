package com.deliveryhero.customerchat.di;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;
import org.koin.dsl.KoinApplicationKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/customerchat/di/MyKoinContext;", "", "()V", "koinApp", "Lorg/koin/core/KoinApplication;", "getKoin", "Lorg/koin/core/Koin;", "init", "", "application", "Landroid/app/Application;", "modules", "", "Lorg/koin/core/module/Module;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MyKoinContext {
    @NotNull
    public static final MyKoinContext INSTANCE = new MyKoinContext();
    @Nullable
    private static KoinApplication koinApp;

    private MyKoinContext() {
    }

    @NotNull
    public final Koin getKoin() {
        KoinApplication koinApplication = koinApp;
        if (koinApplication != null) {
            return koinApplication.getKoin();
        }
        throw new IllegalArgumentException("Koin is not initialized. Make sure to initialize first with a call to `init(application)`".toString());
    }

    public final void init(@NotNull Application application, @NotNull List<Module> list) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(list, "modules");
        koinApp = KoinApplicationKt.koinApplication(new MyKoinContext$init$1(application, list));
    }
}
