package androidx.compose.foundation.layout;

import a0.a;
import a0.b;
import androidx.compose.foundation.layout.AlignmentLineProvider;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\r\u000eB \b\u0004\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\nH&\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/layout/SiblingsAlignedModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "WithAlignmentLine", "WithAlignmentLineBlock", "Landroidx/compose/foundation/layout/SiblingsAlignedModifier$WithAlignmentLine;", "Landroidx/compose/foundation/layout/SiblingsAlignedModifier$WithAlignmentLineBlock;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class SiblingsAlignedModifier extends InspectorValueInfo implements ParentDataModifier {

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u000f*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/SiblingsAlignedModifier$WithAlignmentLine;", "Landroidx/compose/foundation/layout/SiblingsAlignedModifier;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/layout/AlignmentLine;Lkotlin/jvm/functions/Function1;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "equals", "", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WithAlignmentLine extends SiblingsAlignedModifier {
        @NotNull
        private final AlignmentLine alignmentLine;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithAlignmentLine(@NotNull AlignmentLine alignmentLine2, @NotNull Function1<? super InspectorInfo, Unit> function1) {
            super(function1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(alignmentLine2, "alignmentLine");
            Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
            this.alignmentLine = alignmentLine2;
        }

        public boolean equals(@Nullable Object obj) {
            WithAlignmentLine withAlignmentLine;
            if (this == obj) {
                return true;
            }
            if (obj instanceof WithAlignmentLine) {
                withAlignmentLine = (WithAlignmentLine) obj;
            } else {
                withAlignmentLine = null;
            }
            if (withAlignmentLine == null) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.alignmentLine, (Object) withAlignmentLine.alignmentLine);
        }

        @NotNull
        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            RowColumnParentData rowColumnParentData;
            Intrinsics.checkNotNullParameter(density, "<this>");
            if (obj instanceof RowColumnParentData) {
                rowColumnParentData = (RowColumnParentData) obj;
            } else {
                rowColumnParentData = null;
            }
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, (CrossAxisAlignment) null, 7, (DefaultConstructorMarker) null);
            }
            rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release(new AlignmentLineProvider.Value(this.alignmentLine)));
            return rowColumnParentData;
        }

        @NotNull
        public String toString() {
            return "WithAlignmentLine(line=" + this.alignmentLine + ')';
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B2\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u0010*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/SiblingsAlignedModifier$WithAlignmentLineBlock;", "Landroidx/compose/foundation/layout/SiblingsAlignedModifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "toString", "", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WithAlignmentLineBlock extends SiblingsAlignedModifier {
        @NotNull
        private final Function1<Measured, Integer> block;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithAlignmentLineBlock(@NotNull Function1<? super Measured, Integer> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
            super(function12, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function1, "block");
            Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
            this.block = function1;
        }

        public boolean equals(@Nullable Object obj) {
            WithAlignmentLineBlock withAlignmentLineBlock;
            if (this == obj) {
                return true;
            }
            if (obj instanceof WithAlignmentLineBlock) {
                withAlignmentLineBlock = (WithAlignmentLineBlock) obj;
            } else {
                withAlignmentLineBlock = null;
            }
            if (withAlignmentLineBlock == null) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.block, (Object) withAlignmentLineBlock.block);
        }

        @NotNull
        public final Function1<Measured, Integer> getBlock() {
            return this.block;
        }

        public int hashCode() {
            return this.block.hashCode();
        }

        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            RowColumnParentData rowColumnParentData;
            Intrinsics.checkNotNullParameter(density, "<this>");
            if (obj instanceof RowColumnParentData) {
                rowColumnParentData = (RowColumnParentData) obj;
            } else {
                rowColumnParentData = null;
            }
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, (CrossAxisAlignment) null, 7, (DefaultConstructorMarker) null);
            }
            rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release(new AlignmentLineProvider.Block(this.block)));
            return rowColumnParentData;
        }

        @NotNull
        public String toString() {
            return "WithAlignmentLineBlock(block=" + this.block + ')';
        }
    }

    private SiblingsAlignedModifier(Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
    }

    public /* synthetic */ SiblingsAlignedModifier(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @Nullable
    public abstract Object modifyParentData(@NotNull Density density, @Nullable Object obj);

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
