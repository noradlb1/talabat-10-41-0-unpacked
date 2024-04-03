package androidx.compose.ui.tooling;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/compose/ui/tooling/CompositionDataRecord;", "", "store", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getStore", "()Ljava/util/Set;", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CompositionDataRecord {
    @NotNull
    public static final Companion Companion = Companion.f10255a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/tooling/CompositionDataRecord$Companion;", "", "()V", "create", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f10255a = new Companion();

        private Companion() {
        }

        @NotNull
        public final CompositionDataRecord create() {
            return new CompositionDataRecordImpl();
        }
    }

    @NotNull
    Set<CompositionData> getStore();
}
