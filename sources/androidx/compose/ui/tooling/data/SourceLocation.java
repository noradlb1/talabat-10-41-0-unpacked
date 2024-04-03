package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/tooling/data/SourceLocation;", "", "lineNumber", "", "offset", "length", "sourceFile", "", "packageHash", "(IIILjava/lang/String;I)V", "getLength", "()I", "getLineNumber", "getOffset", "getPackageHash", "getSourceFile", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@UiToolingDataApi
public final class SourceLocation {
    public static final int $stable = 0;
    private final int length;
    private final int lineNumber;
    private final int offset;
    private final int packageHash;
    @Nullable
    private final String sourceFile;

    public SourceLocation(int i11, int i12, int i13, @Nullable String str, int i14) {
        this.lineNumber = i11;
        this.offset = i12;
        this.length = i13;
        this.sourceFile = str;
        this.packageHash = i14;
    }

    public static /* synthetic */ SourceLocation copy$default(SourceLocation sourceLocation, int i11, int i12, int i13, String str, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = sourceLocation.lineNumber;
        }
        if ((i15 & 2) != 0) {
            i12 = sourceLocation.offset;
        }
        int i16 = i12;
        if ((i15 & 4) != 0) {
            i13 = sourceLocation.length;
        }
        int i17 = i13;
        if ((i15 & 8) != 0) {
            str = sourceLocation.sourceFile;
        }
        String str2 = str;
        if ((i15 & 16) != 0) {
            i14 = sourceLocation.packageHash;
        }
        return sourceLocation.copy(i11, i16, i17, str2, i14);
    }

    public final int component1() {
        return this.lineNumber;
    }

    public final int component2() {
        return this.offset;
    }

    public final int component3() {
        return this.length;
    }

    @Nullable
    public final String component4() {
        return this.sourceFile;
    }

    public final int component5() {
        return this.packageHash;
    }

    @NotNull
    public final SourceLocation copy(int i11, int i12, int i13, @Nullable String str, int i14) {
        return new SourceLocation(i11, i12, i13, str, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceLocation)) {
            return false;
        }
        SourceLocation sourceLocation = (SourceLocation) obj;
        return this.lineNumber == sourceLocation.lineNumber && this.offset == sourceLocation.offset && this.length == sourceLocation.length && Intrinsics.areEqual((Object) this.sourceFile, (Object) sourceLocation.sourceFile) && this.packageHash == sourceLocation.packageHash;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    @Nullable
    public final String getSourceFile() {
        return this.sourceFile;
    }

    public int hashCode() {
        int i11 = ((((this.lineNumber * 31) + this.offset) * 31) + this.length) * 31;
        String str = this.sourceFile;
        return ((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.packageHash;
    }

    @NotNull
    public String toString() {
        return "SourceLocation(lineNumber=" + this.lineNumber + ", offset=" + this.offset + ", length=" + this.length + ", sourceFile=" + this.sourceFile + ", packageHash=" + this.packageHash + ')';
    }
}
