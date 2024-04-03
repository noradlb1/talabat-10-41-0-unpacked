package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "msg", "", "ex", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleProcessDataStore$actor$2 extends Lambda implements Function2<SingleProcessDataStore.Message<T>, Throwable, Unit> {
    public static final SingleProcessDataStore$actor$2 INSTANCE = new SingleProcessDataStore$actor$2();

    public SingleProcessDataStore$actor$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SingleProcessDataStore.Message) obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SingleProcessDataStore.Message<T> message, @Nullable Throwable th2) {
        Intrinsics.checkNotNullParameter(message, "msg");
        if (message instanceof SingleProcessDataStore.Message.Update) {
            CompletableDeferred ack = ((SingleProcessDataStore.Message.Update) message).getAck();
            if (th2 == null) {
                th2 = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            ack.completeExceptionally(th2);
        }
    }
}
