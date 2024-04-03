package com.instabug.library.diagnostics.di;

import com.instabug.library.diagnostics.g;
import com.instabug.library.diagnostics.i;
import com.instabug.library.diagnostics.network.c;
import com.instabug.library.diagnostics.network.e;
import com.instabug.library.networkv2.INetworkManager;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.util.threading.PoolProvider;
import java.util.concurrent.Executor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f34243a = new a();

    private a() {
    }

    @JvmStatic
    @NotNull
    public static final synchronized g b() {
        i iVar;
        synchronized (a.class) {
            iVar = new i();
        }
        return iVar;
    }

    @JvmStatic
    @NotNull
    public static final INetworkManager d() {
        return new NetworkManager();
    }

    @NotNull
    public final synchronized Executor a() {
        Executor singleThreadExecutor;
        singleThreadExecutor = PoolProvider.getSingleThreadExecutor("ibg-diagnostics-executor");
        Intrinsics.checkNotNullExpressionValue(singleThreadExecutor, "getSingleThreadExecutor(…bg-diagnostics-executor\")");
        return singleThreadExecutor;
    }

    @NotNull
    public final synchronized c c() {
        return new e();
    }
}
