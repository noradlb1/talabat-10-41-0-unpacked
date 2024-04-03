package coil.fetch;

import coil.decode.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcoil/fetch/SourceResult;", "Lcoil/fetch/FetchResult;", "source", "Lokio/BufferedSource;", "mimeType", "", "dataSource", "Lcoil/decode/DataSource;", "(Lokio/BufferedSource;Ljava/lang/String;Lcoil/decode/DataSource;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getMimeType", "()Ljava/lang/String;", "getSource", "()Lokio/BufferedSource;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SourceResult extends FetchResult {
    @NotNull
    private final DataSource dataSource;
    @Nullable
    private final String mimeType;
    @NotNull
    private final BufferedSource source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SourceResult(@NotNull BufferedSource bufferedSource, @Nullable String str, @NotNull DataSource dataSource2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
        this.source = bufferedSource;
        this.mimeType = str;
        this.dataSource = dataSource2;
    }

    public static /* synthetic */ SourceResult copy$default(SourceResult sourceResult, BufferedSource bufferedSource, String str, DataSource dataSource2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bufferedSource = sourceResult.source;
        }
        if ((i11 & 2) != 0) {
            str = sourceResult.mimeType;
        }
        if ((i11 & 4) != 0) {
            dataSource2 = sourceResult.dataSource;
        }
        return sourceResult.copy(bufferedSource, str, dataSource2);
    }

    @NotNull
    public final BufferedSource component1() {
        return this.source;
    }

    @Nullable
    public final String component2() {
        return this.mimeType;
    }

    @NotNull
    public final DataSource component3() {
        return this.dataSource;
    }

    @NotNull
    public final SourceResult copy(@NotNull BufferedSource bufferedSource, @Nullable String str, @NotNull DataSource dataSource2) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
        return new SourceResult(bufferedSource, str, dataSource2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceResult)) {
            return false;
        }
        SourceResult sourceResult = (SourceResult) obj;
        return Intrinsics.areEqual((Object) this.source, (Object) sourceResult.source) && Intrinsics.areEqual((Object) this.mimeType, (Object) sourceResult.mimeType) && this.dataSource == sourceResult.dataSource;
    }

    @NotNull
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.dataSource.hashCode();
    }

    @NotNull
    public String toString() {
        return "SourceResult(source=" + this.source + ", mimeType=" + this.mimeType + ", dataSource=" + this.dataSource + ')';
    }
}
