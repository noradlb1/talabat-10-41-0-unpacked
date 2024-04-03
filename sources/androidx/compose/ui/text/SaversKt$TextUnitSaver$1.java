package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/unit/TextUnit;", "invoke-mpE4wyQ", "(Landroidx/compose/runtime/saveable/SaverScope;J)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaversKt$TextUnitSaver$1 extends Lambda implements Function2<SaverScope, TextUnit, Object> {
    public static final SaversKt$TextUnitSaver$1 INSTANCE = new SaversKt$TextUnitSaver$1();

    public SaversKt$TextUnitSaver$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m4991invokempE4wyQ((SaverScope) obj, ((TextUnit) obj2).m5668unboximpl());
    }

    @Nullable
    /* renamed from: invoke-mpE4wyQ  reason: not valid java name */
    public final Object m4991invokempE4wyQ(@NotNull SaverScope saverScope, long j11) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        return CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(TextUnit.m5659getValueimpl(j11))), SaversKt.save(TextUnitType.m5684boximpl(TextUnit.m5658getTypeUIouoOA(j11))));
    }
}
