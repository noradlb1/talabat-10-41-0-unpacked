package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/tooling/data/SourceLocationInfo;", "", "lineNumber", "", "offset", "length", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLineNumber", "getOffset", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class SourceLocationInfo {
    @Nullable
    private final Integer length;
    @Nullable
    private final Integer lineNumber;
    @Nullable
    private final Integer offset;

    public SourceLocationInfo(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.lineNumber = num;
        this.offset = num2;
        this.length = num3;
    }

    @Nullable
    public final Integer getLength() {
        return this.length;
    }

    @Nullable
    public final Integer getLineNumber() {
        return this.lineNumber;
    }

    @Nullable
    public final Integer getOffset() {
        return this.offset;
    }
}
