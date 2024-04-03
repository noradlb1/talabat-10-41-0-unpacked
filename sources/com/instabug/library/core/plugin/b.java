package com.instabug.library.core.plugin;

import com.instabug.library.sessionV3.providers.FeatureSessionDataControllerHost;
import com.instabug.library.sessionV3.providers.FeatureSessionLazyDataProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f34196a = new b();

    private b() {
    }

    @NotNull
    public List a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "plugins");
        List<FeatureSessionDataControllerHost> filterIsInstance = CollectionsKt___CollectionsJvmKt.filterIsInstance(list, FeatureSessionDataControllerHost.class);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(filterIsInstance, 10));
        for (FeatureSessionDataControllerHost sessionDataController : filterIsInstance) {
            arrayList.add(sessionDataController.getSessionDataController());
        }
        return arrayList;
    }

    @NotNull
    public List b(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "plugins");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof FeatureSessionLazyDataProvider) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
