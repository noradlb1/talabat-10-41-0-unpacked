package com.talabat.talabatlife.features.subscription.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse;", "", "result", "", "errors", "", "", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse;", "equals", "other", "hashCode", "", "toString", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoRenewSubscriptionResponse {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("errors")
    @Nullable
    private final List<String> errors;
    @SerializedName("result")
    @Nullable
    private final Boolean result;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse$Companion;", "", "()V", "empty", "Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AutoRenewSubscriptionResponse empty() {
            return new AutoRenewSubscriptionResponse(Boolean.FALSE, CollectionsKt__CollectionsKt.emptyList());
        }
    }

    public AutoRenewSubscriptionResponse() {
        this((Boolean) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public AutoRenewSubscriptionResponse(@Nullable Boolean bool, @Nullable List<String> list) {
        this.result = bool;
        this.errors = list;
    }

    public static /* synthetic */ AutoRenewSubscriptionResponse copy$default(AutoRenewSubscriptionResponse autoRenewSubscriptionResponse, Boolean bool, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = autoRenewSubscriptionResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = autoRenewSubscriptionResponse.errors;
        }
        return autoRenewSubscriptionResponse.copy(bool, list);
    }

    @Nullable
    public final Boolean component1() {
        return this.result;
    }

    @Nullable
    public final List<String> component2() {
        return this.errors;
    }

    @NotNull
    public final AutoRenewSubscriptionResponse copy(@Nullable Boolean bool, @Nullable List<String> list) {
        return new AutoRenewSubscriptionResponse(bool, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoRenewSubscriptionResponse)) {
            return false;
        }
        AutoRenewSubscriptionResponse autoRenewSubscriptionResponse = (AutoRenewSubscriptionResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) autoRenewSubscriptionResponse.result) && Intrinsics.areEqual((Object) this.errors, (Object) autoRenewSubscriptionResponse.errors);
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    @Nullable
    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Boolean bool = this.result;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<String> list = this.errors;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.result;
        List<String> list = this.errors;
        return "AutoRenewSubscriptionResponse(result=" + bool + ", errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoRenewSubscriptionResponse(Boolean bool, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : list);
    }
}
