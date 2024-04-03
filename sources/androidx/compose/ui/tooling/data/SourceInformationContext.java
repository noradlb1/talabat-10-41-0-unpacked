package androidx.compose.ui.tooling.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/tooling/data/SourceInformationContext;", "", "name", "", "sourceFile", "packageHash", "", "locations", "", "Landroidx/compose/ui/tooling/data/SourceLocationInfo;", "repeatOffset", "parameters", "Landroidx/compose/ui/tooling/data/Parameter;", "isCall", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;Z)V", "()Z", "getLocations", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "nextLocation", "getPackageHash", "()I", "getParameters", "getRepeatOffset", "getSourceFile", "nextSourceLocation", "Landroidx/compose/ui/tooling/data/SourceLocation;", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@UiToolingDataApi
final class SourceInformationContext {
    private final boolean isCall;
    @NotNull
    private final List<SourceLocationInfo> locations;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f10282name;
    private int nextLocation;
    private final int packageHash;
    @Nullable
    private final List<Parameter> parameters;
    private final int repeatOffset;
    @Nullable
    private final String sourceFile;

    public SourceInformationContext(@Nullable String str, @Nullable String str2, int i11, @NotNull List<SourceLocationInfo> list, int i12, @Nullable List<Parameter> list2, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "locations");
        this.f10282name = str;
        this.sourceFile = str2;
        this.packageHash = i11;
        this.locations = list;
        this.repeatOffset = i12;
        this.parameters = list2;
        this.isCall = z11;
    }

    @NotNull
    public final List<SourceLocationInfo> getLocations() {
        return this.locations;
    }

    @Nullable
    public final String getName() {
        return this.f10282name;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    @Nullable
    public final List<Parameter> getParameters() {
        return this.parameters;
    }

    public final int getRepeatOffset() {
        return this.repeatOffset;
    }

    @Nullable
    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final boolean isCall() {
        return this.isCall;
    }

    @Nullable
    public final SourceLocation nextSourceLocation() {
        int i11;
        int i12;
        int i13;
        int i14;
        if (this.nextLocation >= this.locations.size() && (i14 = this.repeatOffset) >= 0) {
            this.nextLocation = i14;
        }
        if (this.nextLocation >= this.locations.size()) {
            return null;
        }
        List<SourceLocationInfo> list = this.locations;
        int i15 = this.nextLocation;
        this.nextLocation = i15 + 1;
        SourceLocationInfo sourceLocationInfo = list.get(i15);
        Integer lineNumber = sourceLocationInfo.getLineNumber();
        if (lineNumber == null) {
            i11 = -1;
        } else {
            i11 = lineNumber.intValue();
        }
        Integer offset = sourceLocationInfo.getOffset();
        if (offset == null) {
            i12 = -1;
        } else {
            i12 = offset.intValue();
        }
        Integer length = sourceLocationInfo.getLength();
        if (length == null) {
            i13 = -1;
        } else {
            i13 = length.intValue();
        }
        return new SourceLocation(i11, i12, i13, this.sourceFile, this.packageHash);
    }
}
