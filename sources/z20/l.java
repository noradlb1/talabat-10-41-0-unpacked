package z20;

import j$.lang.Iterable;
import j$.util.Optional;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class l {
    @API(since = "5.7.1", status = API.Status.EXPERIMENTAL)
    public static void a(ExtensionContext extensionContext, Consumer<Object> consumer) {
        ArrayList arrayList = new ArrayList(extensionContext.getRequiredTestInstances().getAllInstances());
        while (true) {
            Optional<ExtensionContext> parent = extensionContext.getParent();
            if (parent.isPresent()) {
                parent.get().getTestInstances().map(new j()).ifPresent(new k(arrayList));
                extensionContext = parent.get();
            } else {
                Collections.reverse(arrayList);
                Iterable.EL.forEach(arrayList, consumer);
                return;
            }
        }
    }
}
