package com.talabat.core.observabilityNew.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/entity/ScreenTrackerParams;", "", "trace", "", "screenName", "screenType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "getScreenType", "getTrace", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenTrackerParams {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String trace;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/entity/ScreenTrackerParams$Companion;", "", "()V", "create", "Lcom/talabat/core/observabilityNew/domain/entity/ScreenTrackerParams;", "name", "", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ScreenTrackerParams create(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new ScreenTrackerParams(str, str, str);
        }
    }

    public ScreenTrackerParams(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "trace");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        this.trace = str;
        this.screenName = str2;
        this.screenType = str3;
    }

    public static /* synthetic */ ScreenTrackerParams copy$default(ScreenTrackerParams screenTrackerParams, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = screenTrackerParams.trace;
        }
        if ((i11 & 2) != 0) {
            str2 = screenTrackerParams.screenName;
        }
        if ((i11 & 4) != 0) {
            str3 = screenTrackerParams.screenType;
        }
        return screenTrackerParams.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.trace;
    }

    @NotNull
    public final String component2() {
        return this.screenName;
    }

    @NotNull
    public final String component3() {
        return this.screenType;
    }

    @NotNull
    public final ScreenTrackerParams copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "trace");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        return new ScreenTrackerParams(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenTrackerParams)) {
            return false;
        }
        ScreenTrackerParams screenTrackerParams = (ScreenTrackerParams) obj;
        return Intrinsics.areEqual((Object) this.trace, (Object) screenTrackerParams.trace) && Intrinsics.areEqual((Object) this.screenName, (Object) screenTrackerParams.screenName) && Intrinsics.areEqual((Object) this.screenType, (Object) screenTrackerParams.screenType);
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getScreenType() {
        return this.screenType;
    }

    @NotNull
    public final String getTrace() {
        return this.trace;
    }

    public int hashCode() {
        return (((this.trace.hashCode() * 31) + this.screenName.hashCode()) * 31) + this.screenType.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.trace;
        String str2 = this.screenName;
        String str3 = this.screenType;
        return "ScreenTrackerParams(trace=" + str + ", screenName=" + str2 + ", screenType=" + str3 + ")";
    }
}
