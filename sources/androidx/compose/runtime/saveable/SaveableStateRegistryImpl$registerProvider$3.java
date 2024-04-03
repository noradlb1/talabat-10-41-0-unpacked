package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/runtime/saveable/SaveableStateRegistryImpl$registerProvider$3", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "unregister", "", "runtime-saveable_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SaveableStateRegistryImpl$registerProvider$3 implements SaveableStateRegistry.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistryImpl f9512a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9513b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0<Object> f9514c;

    public SaveableStateRegistryImpl$registerProvider$3(SaveableStateRegistryImpl saveableStateRegistryImpl, String str, Function0<? extends Object> function0) {
        this.f9512a = saveableStateRegistryImpl;
        this.f9513b = str;
        this.f9514c = function0;
    }

    public void unregister() {
        List list = (List) this.f9512a.valueProviders.remove(this.f9513b);
        if (list != null) {
            list.remove(this.f9514c);
        }
        if (list != null && (!list.isEmpty())) {
            this.f9512a.valueProviders.put(this.f9513b, list);
        }
    }
}
