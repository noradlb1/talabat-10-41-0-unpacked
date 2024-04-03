package androidx.compose.runtime.saveable;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaveableStateHolderKt$rememberSaveableStateHolder$1 extends Lambda implements Function0<SaveableStateHolderImpl> {
    public static final SaveableStateHolderKt$rememberSaveableStateHolder$1 INSTANCE = new SaveableStateHolderKt$rememberSaveableStateHolder$1();

    public SaveableStateHolderKt$rememberSaveableStateHolder$1() {
        super(0);
    }

    @NotNull
    public final SaveableStateHolderImpl invoke() {
        return new SaveableStateHolderImpl((Map) null, 1, (DefaultConstructorMarker) null);
    }
}
