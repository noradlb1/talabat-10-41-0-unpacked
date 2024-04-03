package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\u0010\u0010R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/tooling/data/CallGroup;", "Landroidx/compose/ui/tooling/data/Group;", "key", "", "name", "", "box", "Landroidx/compose/ui/unit/IntRect;", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "parameters", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "data", "", "children", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/util/List;Ljava/util/Collection;Ljava/util/Collection;)V", "getParameters", "()Ljava/util/List;", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@UiToolingDataApi
public final class CallGroup extends Group {
    public static final int $stable = 8;
    @NotNull
    private final List<ParameterInformation> parameters;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CallGroup(@org.jetbrains.annotations.Nullable java.lang.Object r11, @org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.IntRect r13, @org.jetbrains.annotations.Nullable androidx.compose.ui.tooling.data.SourceLocation r14, @org.jetbrains.annotations.NotNull java.util.List<androidx.compose.ui.tooling.data.ParameterInformation> r15, @org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> r16, @org.jetbrains.annotations.NotNull java.util.Collection<? extends androidx.compose.ui.tooling.data.Group> r17) {
        /*
            r10 = this;
            r0 = r15
            java.lang.String r1 = "box"
            r6 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "data"
            r7 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "children"
            r8 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            r9 = 0
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r1 = r10
            r1.parameters = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.CallGroup.<init>(java.lang.Object, java.lang.String, androidx.compose.ui.unit.IntRect, androidx.compose.ui.tooling.data.SourceLocation, java.util.List, java.util.Collection, java.util.Collection):void");
    }

    @NotNull
    public List<ParameterInformation> getParameters() {
        return this.parameters;
    }
}
