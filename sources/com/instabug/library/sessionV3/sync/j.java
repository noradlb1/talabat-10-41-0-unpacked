package com.instabug.library.sessionV3.sync;

import com.instabug.library.networkv2.INetworkManager;
import com.instabug.library.sessionV3.di.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class j extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final j f51837a = new j();

    public j() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final INetworkManager invoke() {
        return c.f51790a.i();
    }
}
