package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SendCancellationFeedbackRootResponse;", "", "hasError", "", "errors", "", "", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getHasError", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/talabat/feature/subscriptions/data/remote/model/SendCancellationFeedbackRootResponse;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendCancellationFeedbackRootResponse {
    @Nullable
    private final List<String> errors;
    @Nullable
    private final Boolean hasError;

    public SendCancellationFeedbackRootResponse() {
        this((Boolean) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public SendCancellationFeedbackRootResponse(@Nullable @Json(name = "hasError") Boolean bool, @Nullable @Json(name = "errors") List<String> list) {
        this.hasError = bool;
        this.errors = list;
    }

    public static /* synthetic */ SendCancellationFeedbackRootResponse copy$default(SendCancellationFeedbackRootResponse sendCancellationFeedbackRootResponse, Boolean bool, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = sendCancellationFeedbackRootResponse.hasError;
        }
        if ((i11 & 2) != 0) {
            list = sendCancellationFeedbackRootResponse.errors;
        }
        return sendCancellationFeedbackRootResponse.copy(bool, list);
    }

    @Nullable
    public final Boolean component1() {
        return this.hasError;
    }

    @Nullable
    public final List<String> component2() {
        return this.errors;
    }

    @NotNull
    public final SendCancellationFeedbackRootResponse copy(@Nullable @Json(name = "hasError") Boolean bool, @Nullable @Json(name = "errors") List<String> list) {
        return new SendCancellationFeedbackRootResponse(bool, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendCancellationFeedbackRootResponse)) {
            return false;
        }
        SendCancellationFeedbackRootResponse sendCancellationFeedbackRootResponse = (SendCancellationFeedbackRootResponse) obj;
        return Intrinsics.areEqual((Object) this.hasError, (Object) sendCancellationFeedbackRootResponse.hasError) && Intrinsics.areEqual((Object) this.errors, (Object) sendCancellationFeedbackRootResponse.errors);
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    @Nullable
    public final Boolean getHasError() {
        return this.hasError;
    }

    public int hashCode() {
        Boolean bool = this.hasError;
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
        Boolean bool = this.hasError;
        List<String> list = this.errors;
        return "SendCancellationFeedbackRootResponse(hasError=" + bool + ", errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SendCancellationFeedbackRootResponse(Boolean bool, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : list);
    }
}
