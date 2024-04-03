package com.talabat.core.network.testutils;

import androidx.test.espresso.IdlingRegistry;
import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.talabat.core.network.testutils.OkHttpIdling;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/network/testutils/OkHttpIdlingResource;", "", "()V", "okHttpIdlingResources", "", "Lcom/talabat/core/network/testutils/OkHttpIdling;", "register", "", "client", "Lokhttp3/OkHttpClient;", "unregister", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHttpIdlingResource {
    @NotNull
    public static final OkHttpIdlingResource INSTANCE = new OkHttpIdlingResource();
    @NotNull
    private static final List<OkHttpIdling> okHttpIdlingResources = new ArrayList();

    private OkHttpIdlingResource() {
    }

    @JvmStatic
    public static final void register(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        OkHttpIdling.Companion companion = OkHttpIdling.Companion;
        long currentTimeMillis = System.currentTimeMillis();
        OkHttpIdling create = companion.create("okhttp_" + currentTimeMillis, okHttpClient);
        IdlingRegistry.getInstance().register(create);
        okHttpIdlingResources.add(create);
    }

    public final void unregister() {
        IdlingRegistry instance = IdlingRegistry.getInstance();
        for (OkHttpIdling okHttpIdling : okHttpIdlingResources) {
            instance.unregister(okHttpIdling);
        }
    }
}
