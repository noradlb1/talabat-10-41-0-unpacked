package com.instabug.commons.session;

import com.instabug.commons.di.CommonsLocator;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a implements FeatureSessionDataController {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f46333a = new a();

    private a() {
    }

    private final f a() {
        return CommonsLocator.INSTANCE.getSessionIncidentCachingHandler();
    }

    @NotNull
    public Map collectSessionsData(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "sessionsIds");
        return i.d(a().b(list));
    }

    public void dropSessionData(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "sessionsIds");
        a().a(list);
    }
}
