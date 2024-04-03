package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$debugInspectorInfo$1;
import androidx.compose.ui.platform.InspectorInfo;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\bø\u0001\u0000\u001ac\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0014\b\u0004\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\u00072\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"modifierElementOf", "Landroidx/compose/ui/Modifier;", "T", "Landroidx/compose/ui/Modifier$Node;", "create", "Lkotlin/Function0;", "definitions", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "params", "", "update", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ModifierNodeElementKt {
    @ExperimentalComposeUiApi
    public static final /* synthetic */ <T extends Modifier.Node> Modifier modifierElementOf(Object obj, Function0<? extends T> function0, Function1<? super T, Unit> function1, Function1<? super InspectorInfo, Unit> function12) {
        Intrinsics.checkNotNullParameter(function0, "create");
        Intrinsics.checkNotNullParameter(function1, Constant.METHOD_UPDATE);
        Intrinsics.checkNotNullParameter(function12, "definitions");
        Function1 inspectableValueKt$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new InspectableValueKt$debugInspectorInfo$1(function12) : InspectableValueKt.getNoInspectorInfo();
        Intrinsics.needClassReification();
        return new ModifierNodeElementKt$modifierElementOf$1(obj, function0, function1, inspectableValueKt$debugInspectorInfo$1);
    }

    @ExperimentalComposeUiApi
    public static final /* synthetic */ <T extends Modifier.Node> Modifier modifierElementOf(Function0<? extends T> function0, Function1<? super InspectorInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "create");
        Intrinsics.checkNotNullParameter(function1, "definitions");
        Function1 inspectableValueKt$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new InspectableValueKt$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo();
        Intrinsics.needClassReification();
        return new ModifierNodeElementKt$modifierElementOf$2(function0, inspectableValueKt$debugInspectorInfo$1);
    }
}
