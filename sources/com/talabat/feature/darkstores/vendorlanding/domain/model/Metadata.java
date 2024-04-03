package com.talabat.feature.darkstores.vendorlanding.domain.model;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Metadata;", "", "primaryMissionSwimlanesRequestId", "", "(Ljava/lang/String;)V", "getPrimaryMissionSwimlanesRequestId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Metadata {
    @Nullable
    private final String primaryMissionSwimlanesRequestId;

    public Metadata(@Nullable String str) {
        this.primaryMissionSwimlanesRequestId = str;
    }

    public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = metadata.primaryMissionSwimlanesRequestId;
        }
        return metadata.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.primaryMissionSwimlanesRequestId;
    }

    @NotNull
    public final Metadata copy(@Nullable String str) {
        return new Metadata(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Metadata) && Intrinsics.areEqual((Object) this.primaryMissionSwimlanesRequestId, (Object) ((Metadata) obj).primaryMissionSwimlanesRequestId);
    }

    @Nullable
    public final String getPrimaryMissionSwimlanesRequestId() {
        return this.primaryMissionSwimlanesRequestId;
    }

    public int hashCode() {
        String str = this.primaryMissionSwimlanesRequestId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.primaryMissionSwimlanesRequestId;
        return "Metadata(primaryMissionSwimlanesRequestId=" + str + ")";
    }
}
