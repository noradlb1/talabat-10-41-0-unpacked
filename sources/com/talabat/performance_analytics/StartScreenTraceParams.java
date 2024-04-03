package com.talabat.performance_analytics;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/talabat/performance_analytics/StartScreenTraceParams;", "", "traceName", "", "screenName", "screenType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "getScreenType", "getTraceName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toList", "", "toString", "Companion", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StartScreenTraceParams {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String traceName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/performance_analytics/StartScreenTraceParams$Companion;", "", "()V", "fromList", "Lcom/talabat/performance_analytics/StartScreenTraceParams;", "list", "", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StartScreenTraceParams fromList(@NotNull List<? extends Object> list) {
            Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(2);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            return new StartScreenTraceParams((String) obj, (String) obj2, (String) obj3);
        }
    }

    public StartScreenTraceParams(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        this.traceName = str;
        this.screenName = str2;
        this.screenType = str3;
    }

    public static /* synthetic */ StartScreenTraceParams copy$default(StartScreenTraceParams startScreenTraceParams, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = startScreenTraceParams.traceName;
        }
        if ((i11 & 2) != 0) {
            str2 = startScreenTraceParams.screenName;
        }
        if ((i11 & 4) != 0) {
            str3 = startScreenTraceParams.screenType;
        }
        return startScreenTraceParams.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.traceName;
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
    public final StartScreenTraceParams copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        return new StartScreenTraceParams(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartScreenTraceParams)) {
            return false;
        }
        StartScreenTraceParams startScreenTraceParams = (StartScreenTraceParams) obj;
        return Intrinsics.areEqual((Object) this.traceName, (Object) startScreenTraceParams.traceName) && Intrinsics.areEqual((Object) this.screenName, (Object) startScreenTraceParams.screenName) && Intrinsics.areEqual((Object) this.screenType, (Object) startScreenTraceParams.screenType);
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
    public final String getTraceName() {
        return this.traceName;
    }

    public int hashCode() {
        return (((this.traceName.hashCode() * 31) + this.screenName.hashCode()) * 31) + this.screenType.hashCode();
    }

    @NotNull
    public final List<Object> toList() {
        return CollectionsKt__CollectionsKt.listOf(this.traceName, this.screenName, this.screenType);
    }

    @NotNull
    public String toString() {
        return "StartScreenTraceParams(traceName=" + this.traceName + ", screenName=" + this.screenName + ", screenType=" + this.screenType + ')';
    }
}
