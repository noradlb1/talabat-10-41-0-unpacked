package com.talabat.feature.darkstores.vendorlanding.domain.model;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/MetadataError;", "", "message", "", "code", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetadataError {
    @NotNull
    private final String code;
    @NotNull
    private final String message;

    public MetadataError(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
        this.message = str;
        this.code = str2;
    }

    public static /* synthetic */ MetadataError copy$default(MetadataError metadataError, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = metadataError.message;
        }
        if ((i11 & 2) != 0) {
            str2 = metadataError.code;
        }
        return metadataError.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final String component2() {
        return this.code;
    }

    @NotNull
    public final MetadataError copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
        return new MetadataError(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataError)) {
            return false;
        }
        MetadataError metadataError = (MetadataError) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) metadataError.message) && Intrinsics.areEqual((Object) this.code, (Object) metadataError.code);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.code.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.message;
        String str2 = this.code;
        return "MetadataError(message=" + str + ", code=" + str2 + ")";
    }
}
