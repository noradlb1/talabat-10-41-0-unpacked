package com.talabat.feature.cancellationpolicy.remote;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyResponse;", "", "isEnabled", "", "content", "Lcom/talabat/feature/cancellationpolicy/remote/Content;", "(ZLcom/talabat/feature/cancellationpolicy/remote/Content;)V", "getContent", "()Lcom/talabat/feature/cancellationpolicy/remote/Content;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyResponse {
    @SerializedName("content")
    @NotNull
    private final Content content;
    @SerializedName("isEnabled")
    private final boolean isEnabled;

    public CancellationPolicyResponse(@Json(name = "isEnabled") boolean z11, @NotNull @Json(name = "content") Content content2) {
        Intrinsics.checkNotNullParameter(content2, "content");
        this.isEnabled = z11;
        this.content = content2;
    }

    public static /* synthetic */ CancellationPolicyResponse copy$default(CancellationPolicyResponse cancellationPolicyResponse, boolean z11, Content content2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = cancellationPolicyResponse.isEnabled;
        }
        if ((i11 & 2) != 0) {
            content2 = cancellationPolicyResponse.content;
        }
        return cancellationPolicyResponse.copy(z11, content2);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    @NotNull
    public final Content component2() {
        return this.content;
    }

    @NotNull
    public final CancellationPolicyResponse copy(@Json(name = "isEnabled") boolean z11, @NotNull @Json(name = "content") Content content2) {
        Intrinsics.checkNotNullParameter(content2, "content");
        return new CancellationPolicyResponse(z11, content2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancellationPolicyResponse)) {
            return false;
        }
        CancellationPolicyResponse cancellationPolicyResponse = (CancellationPolicyResponse) obj;
        return this.isEnabled == cancellationPolicyResponse.isEnabled && Intrinsics.areEqual((Object) this.content, (Object) cancellationPolicyResponse.content);
    }

    @NotNull
    public final Content getContent() {
        return this.content;
    }

    public int hashCode() {
        boolean z11 = this.isEnabled;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.content.hashCode();
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isEnabled;
        Content content2 = this.content;
        return "CancellationPolicyResponse(isEnabled=" + z11 + ", content=" + content2 + ")";
    }
}
