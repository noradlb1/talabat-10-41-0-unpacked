package com.talabat.performance_analytics;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/talabat/performance_analytics/InitializeParams;", "", "perseusClientId", "", "perseusSessionId", "firebaseInstanceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirebaseInstanceId", "()Ljava/lang/String;", "getPerseusClientId", "getPerseusSessionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toList", "", "toString", "Companion", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InitializeParams {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final String firebaseInstanceId;
    @NotNull
    private final String perseusClientId;
    @NotNull
    private final String perseusSessionId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/performance_analytics/InitializeParams$Companion;", "", "()V", "fromList", "Lcom/talabat/performance_analytics/InitializeParams;", "list", "", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InitializeParams fromList(@NotNull List<? extends Object> list) {
            Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            return new InitializeParams((String) obj, (String) obj2, (String) list.get(2));
        }
    }

    public InitializeParams(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "perseusClientId");
        Intrinsics.checkNotNullParameter(str2, "perseusSessionId");
        this.perseusClientId = str;
        this.perseusSessionId = str2;
        this.firebaseInstanceId = str3;
    }

    public static /* synthetic */ InitializeParams copy$default(InitializeParams initializeParams, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = initializeParams.perseusClientId;
        }
        if ((i11 & 2) != 0) {
            str2 = initializeParams.perseusSessionId;
        }
        if ((i11 & 4) != 0) {
            str3 = initializeParams.firebaseInstanceId;
        }
        return initializeParams.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.perseusClientId;
    }

    @NotNull
    public final String component2() {
        return this.perseusSessionId;
    }

    @Nullable
    public final String component3() {
        return this.firebaseInstanceId;
    }

    @NotNull
    public final InitializeParams copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "perseusClientId");
        Intrinsics.checkNotNullParameter(str2, "perseusSessionId");
        return new InitializeParams(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitializeParams)) {
            return false;
        }
        InitializeParams initializeParams = (InitializeParams) obj;
        return Intrinsics.areEqual((Object) this.perseusClientId, (Object) initializeParams.perseusClientId) && Intrinsics.areEqual((Object) this.perseusSessionId, (Object) initializeParams.perseusSessionId) && Intrinsics.areEqual((Object) this.firebaseInstanceId, (Object) initializeParams.firebaseInstanceId);
    }

    @Nullable
    public final String getFirebaseInstanceId() {
        return this.firebaseInstanceId;
    }

    @NotNull
    public final String getPerseusClientId() {
        return this.perseusClientId;
    }

    @NotNull
    public final String getPerseusSessionId() {
        return this.perseusSessionId;
    }

    public int hashCode() {
        int hashCode = ((this.perseusClientId.hashCode() * 31) + this.perseusSessionId.hashCode()) * 31;
        String str = this.firebaseInstanceId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public final List<Object> toList() {
        return CollectionsKt__CollectionsKt.listOf(this.perseusClientId, this.perseusSessionId, this.firebaseInstanceId);
    }

    @NotNull
    public String toString() {
        return "InitializeParams(perseusClientId=" + this.perseusClientId + ", perseusSessionId=" + this.perseusSessionId + ", firebaseInstanceId=" + this.firebaseInstanceId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InitializeParams(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? null : str3);
    }
}
