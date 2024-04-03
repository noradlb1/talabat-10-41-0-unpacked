package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/navigation/NavViewModelStoreProvider;", "()V", "viewModelStores", "", "", "Landroidx/lifecycle/ViewModelStore;", "clear", "", "backStackEntryId", "getViewModelStore", "onCleared", "toString", "Companion", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavControllerViewModel extends ViewModel implements NavViewModelStoreProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ViewModelProvider.Factory FACTORY = new NavControllerViewModel$Companion$FACTORY$1();
    @NotNull
    private final Map<String, ViewModelStore> viewModelStores = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/navigation/NavControllerViewModel$Companion;", "", "()V", "FACTORY", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getInstance", "Landroidx/navigation/NavControllerViewModel;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final NavControllerViewModel getInstance(@NotNull ViewModelStore viewModelStore) {
            Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
            return (NavControllerViewModel) new ViewModelProvider(viewModelStore, NavControllerViewModel.FACTORY, (CreationExtras) null, 4, (DefaultConstructorMarker) null).get(NavControllerViewModel.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final NavControllerViewModel getInstance(@NotNull ViewModelStore viewModelStore) {
        return Companion.getInstance(viewModelStore);
    }

    public final void clear(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "backStackEntryId");
        ViewModelStore remove = this.viewModelStores.remove(str);
        if (remove != null) {
            remove.clear();
        }
    }

    @NotNull
    public ViewModelStore getViewModelStore(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "backStackEntryId");
        ViewModelStore viewModelStore = this.viewModelStores.get(str);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.viewModelStores.put(str, viewModelStore2);
        return viewModelStore2;
    }

    public void onCleared() {
        for (ViewModelStore clear : this.viewModelStores.values()) {
            clear.clear();
        }
        this.viewModelStores.clear();
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("NavControllerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} ViewModelStores (");
        Iterator<String> it = this.viewModelStores.keySet().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }
}
