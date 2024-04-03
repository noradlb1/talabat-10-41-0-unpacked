package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.platform.InspectionModeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a(\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"InInspectionModeOnly", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Inspectable", "compositionDataRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "(Landroidx/compose/ui/tooling/CompositionDataRecord;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ui-tooling_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class InspectableKt {
    @Composable
    public static final void InInspectionModeOnly(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1847774503);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((2 ^ (i12 & 11)) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue()) {
            startRestartGroup.startReplaceableGroup(-1847774406);
            function2.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-1847774381);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InspectableKt$InInspectionModeOnly$1(function2, i11));
        }
    }

    @Composable
    public static final void Inspectable(@NotNull CompositionDataRecord compositionDataRecord, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(compositionDataRecord, "compositionDataRecord");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(569790625);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) compositionDataRecord)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.collectParameterInformation();
            Set<CompositionData> store = ((CompositionDataRecordImpl) compositionDataRecord).getStore();
            store.add(startRestartGroup.getCompositionData());
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InspectionModeKt.getLocalInspectionMode().provides(Boolean.TRUE), InspectionTablesKt.getLocalInspectionTables().provides(store)}, function2, startRestartGroup, (i12 & 112) | 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InspectableKt$Inspectable$1(compositionDataRecord, function2, i11));
        }
    }
}
