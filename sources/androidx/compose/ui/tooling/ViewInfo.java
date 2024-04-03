package androidx.compose.ui.tooling;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\u0002\u0010\fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010!\u001a\u00020\u001fJ\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Landroidx/compose/ui/tooling/ViewInfo;", "", "fileName", "", "lineNumber", "", "bounds", "Landroidx/compose/ui/unit/IntRect;", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "children", "", "(Ljava/lang/String;ILandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/util/List;)V", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "getChildren", "()Ljava/util/List;", "getFileName", "()Ljava/lang/String;", "getLineNumber", "()I", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "allChildren", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hasBounds", "hashCode", "toString", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewInfo {
    public static final int $stable = 8;
    @NotNull
    private final IntRect bounds;
    @NotNull
    private final List<ViewInfo> children;
    @NotNull
    private final String fileName;
    private final int lineNumber;
    @Nullable
    private final SourceLocation location;

    public ViewInfo(@NotNull String str, int i11, @NotNull IntRect intRect, @Nullable SourceLocation sourceLocation, @NotNull List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(intRect, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(list, "children");
        this.fileName = str;
        this.lineNumber = i11;
        this.bounds = intRect;
        this.location = sourceLocation;
        this.children = list;
    }

    public static /* synthetic */ ViewInfo copy$default(ViewInfo viewInfo, String str, int i11, IntRect intRect, SourceLocation sourceLocation, List<ViewInfo> list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = viewInfo.fileName;
        }
        if ((i12 & 2) != 0) {
            i11 = viewInfo.lineNumber;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            intRect = viewInfo.bounds;
        }
        IntRect intRect2 = intRect;
        if ((i12 & 8) != 0) {
            sourceLocation = viewInfo.location;
        }
        SourceLocation sourceLocation2 = sourceLocation;
        if ((i12 & 16) != 0) {
            list = viewInfo.children;
        }
        return viewInfo.copy(str, i13, intRect2, sourceLocation2, list);
    }

    @NotNull
    public final List<ViewInfo> allChildren() {
        List<ViewInfo> list = this.children;
        Collection collection = list;
        ArrayList arrayList = new ArrayList();
        for (ViewInfo allChildren : list) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, allChildren.allChildren());
        }
        return CollectionsKt___CollectionsKt.plus(collection, arrayList);
    }

    @NotNull
    public final String component1() {
        return this.fileName;
    }

    public final int component2() {
        return this.lineNumber;
    }

    @NotNull
    public final IntRect component3() {
        return this.bounds;
    }

    @Nullable
    public final SourceLocation component4() {
        return this.location;
    }

    @NotNull
    public final List<ViewInfo> component5() {
        return this.children;
    }

    @NotNull
    public final ViewInfo copy(@NotNull String str, int i11, @NotNull IntRect intRect, @Nullable SourceLocation sourceLocation, @NotNull List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(intRect, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(list, "children");
        return new ViewInfo(str, i11, intRect, sourceLocation, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        return Intrinsics.areEqual((Object) this.fileName, (Object) viewInfo.fileName) && this.lineNumber == viewInfo.lineNumber && Intrinsics.areEqual((Object) this.bounds, (Object) viewInfo.bounds) && Intrinsics.areEqual((Object) this.location, (Object) viewInfo.location) && Intrinsics.areEqual((Object) this.children, (Object) viewInfo.children);
    }

    @NotNull
    public final IntRect getBounds() {
        return this.bounds;
    }

    @NotNull
    public final List<ViewInfo> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    @Nullable
    public final SourceLocation getLocation() {
        return this.location;
    }

    public final boolean hasBounds() {
        return (this.bounds.getBottom() == 0 || this.bounds.getRight() == 0) ? false : true;
    }

    public int hashCode() {
        int hashCode = ((((this.fileName.hashCode() * 31) + this.lineNumber) * 31) + this.bounds.hashCode()) * 31;
        SourceLocation sourceLocation = this.location;
        return ((hashCode + (sourceLocation == null ? 0 : sourceLocation.hashCode())) * 31) + this.children.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(this.fileName);
        sb2.append(AbstractJsonLexerKt.COLON);
        sb2.append(this.lineNumber);
        sb2.append(",\n            |bounds=(top=");
        sb2.append(this.bounds.getTop());
        sb2.append(", left=");
        sb2.append(this.bounds.getLeft());
        sb2.append(",\n            |location=");
        SourceLocation sourceLocation = this.location;
        String str = "<none>";
        if (sourceLocation != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('(');
            sb3.append(sourceLocation.getOffset());
            sb3.append('L');
            sb3.append(sourceLocation.getLength());
            String sb4 = sb3.toString();
            if (sb4 != null) {
                str = sb4;
            }
        }
        sb2.append(str);
        sb2.append("\n            |bottom=");
        sb2.append(this.bounds.getBottom());
        sb2.append(", right=");
        sb2.append(this.bounds.getRight());
        sb2.append("),\n            |childrenCount=");
        sb2.append(this.children.size());
        sb2.append(')');
        return StringsKt__IndentKt.trimMargin$default(sb2.toString(), (String) null, 1, (Object) null);
    }
}
