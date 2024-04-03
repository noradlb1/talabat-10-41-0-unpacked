package com.talabat.core.fwfprojectskeys.domain;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Will be removed after all Keys migrated to the right projects Enums")
public final class FWFKeyObject implements FWFKey {
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    public FWFKeyObject(@NotNull String str, @NotNull FWFProjectName fWFProjectName) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(fWFProjectName, "projectName");
        this.value = str;
        this.projectName = fWFProjectName;
    }

    public static /* synthetic */ FWFKeyObject copy$default(FWFKeyObject fWFKeyObject, String str, FWFProjectName fWFProjectName, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fWFKeyObject.getValue();
        }
        if ((i11 & 2) != 0) {
            fWFProjectName = fWFKeyObject.getProjectName();
        }
        return fWFKeyObject.copy(str, fWFProjectName);
    }

    @NotNull
    public final String component1() {
        return getValue();
    }

    @NotNull
    public final FWFProjectName component2() {
        return getProjectName();
    }

    @NotNull
    public final FWFKeyObject copy(@NotNull String str, @NotNull FWFProjectName fWFProjectName) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(fWFProjectName, "projectName");
        return new FWFKeyObject(str, fWFProjectName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FWFKeyObject)) {
            return false;
        }
        FWFKeyObject fWFKeyObject = (FWFKeyObject) obj;
        return Intrinsics.areEqual((Object) getValue(), (Object) fWFKeyObject.getValue()) && getProjectName() == fWFKeyObject.getProjectName();
    }

    @NotNull
    public FWFProjectName getProjectName() {
        return this.projectName;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (getValue().hashCode() * 31) + getProjectName().hashCode();
    }

    @NotNull
    public String toString() {
        String value2 = getValue();
        FWFProjectName projectName2 = getProjectName();
        return "FWFKeyObject(value=" + value2 + ", projectName=" + projectName2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FWFKeyObject(String str, FWFProjectName fWFProjectName, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? FWFProjectName.DEFAULT : fWFProjectName);
    }
}
