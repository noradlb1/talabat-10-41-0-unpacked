package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ViewModelStore {
    private final HashMap<String, ViewModel> mMap = new HashMap<>();

    public final ViewModel a(String str) {
        return this.mMap.get(str);
    }

    public Set<String> b() {
        return new HashSet(this.mMap.keySet());
    }

    public final void c(String str, ViewModel viewModel) {
        ViewModel put = this.mMap.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }

    public final void clear() {
        for (ViewModel clear : this.mMap.values()) {
            clear.clear();
        }
        this.mMap.clear();
    }
}
