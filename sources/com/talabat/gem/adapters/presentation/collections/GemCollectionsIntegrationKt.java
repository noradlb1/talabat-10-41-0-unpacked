package com.talabat.gem.adapters.presentation.collections;

import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\"\"\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"GemCollectionsConfigurations", "Lio/reactivex/subjects/ReplaySubject;", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "kotlin.jvm.PlatformType", "getGemCollectionsConfigurations", "()Lio/reactivex/subjects/ReplaySubject;", "MAXIMUM_CACHE_TIME_SECONDS", "", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionsIntegrationKt {
    @NotNull
    private static final ReplaySubject<GemEntryViewConfigurations> GemCollectionsConfigurations;
    private static final long MAXIMUM_CACHE_TIME_SECONDS = 3;

    static {
        ReplaySubject<GemEntryViewConfigurations> createWithTime = ReplaySubject.createWithTime(3, TimeUnit.SECONDS, Schedulers.computation());
        Intrinsics.checkNotNullExpressionValue(createWithTime, "createWithTime<GemEntryV…ONDS,\n    computation()\n)");
        GemCollectionsConfigurations = createWithTime;
    }

    @NotNull
    public static final ReplaySubject<GemEntryViewConfigurations> getGemCollectionsConfigurations() {
        return GemCollectionsConfigurations;
    }
}
