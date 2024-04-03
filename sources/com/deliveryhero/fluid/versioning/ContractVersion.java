package com.deliveryhero.fluid.versioning;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/fluid/versioning/ContractVersion;", "", "coreVersionNumber", "", "integrationVersionNumber", "(II)V", "getCoreVersionNumber", "()I", "getIntegrationVersionNumber", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContractVersion {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char VERSION_SEPARATOR = '.';
    private final int coreVersionNumber;
    private final int integrationVersionNumber;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/fluid/versioning/ContractVersion$Companion;", "", "()V", "VERSION_SEPARATOR", "", "fromString", "Lcom/deliveryhero/fluid/versioning/ContractVersion;", "versionString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ContractVersion fromString(@NotNull String str) throws Exception {
            Intrinsics.checkNotNullParameter(str, "versionString");
            List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
            return new ContractVersion(Integer.parseInt((String) split$default.get(0)), Integer.parseInt((String) split$default.get(1)));
        }
    }

    public ContractVersion(int i11, int i12) {
        this.coreVersionNumber = i11;
        this.integrationVersionNumber = i12;
    }

    public static /* synthetic */ ContractVersion copy$default(ContractVersion contractVersion, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = contractVersion.coreVersionNumber;
        }
        if ((i13 & 2) != 0) {
            i12 = contractVersion.integrationVersionNumber;
        }
        return contractVersion.copy(i11, i12);
    }

    public final int component1() {
        return this.coreVersionNumber;
    }

    public final int component2() {
        return this.integrationVersionNumber;
    }

    @NotNull
    public final ContractVersion copy(int i11, int i12) {
        return new ContractVersion(i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContractVersion)) {
            return false;
        }
        ContractVersion contractVersion = (ContractVersion) obj;
        return this.coreVersionNumber == contractVersion.coreVersionNumber && this.integrationVersionNumber == contractVersion.integrationVersionNumber;
    }

    public final int getCoreVersionNumber() {
        return this.coreVersionNumber;
    }

    public final int getIntegrationVersionNumber() {
        return this.integrationVersionNumber;
    }

    public int hashCode() {
        return (this.coreVersionNumber * 31) + this.integrationVersionNumber;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.coreVersionNumber);
        sb2.append('.');
        sb2.append(this.integrationVersionNumber);
        return sb2.toString();
    }
}
