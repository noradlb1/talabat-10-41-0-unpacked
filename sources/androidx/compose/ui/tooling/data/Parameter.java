package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/data/Parameter;", "", "sortedIndex", "", "inlineClass", "", "(ILjava/lang/String;)V", "getInlineClass", "()Ljava/lang/String;", "getSortedIndex", "()I", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class Parameter {
    @Nullable
    private final String inlineClass;
    private final int sortedIndex;

    public Parameter(int i11, @Nullable String str) {
        this.sortedIndex = i11;
        this.inlineClass = str;
    }

    @Nullable
    public final String getInlineClass() {
        return this.inlineClass;
    }

    public final int getSortedIndex() {
        return this.sortedIndex;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Parameter(int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : str);
    }
}
