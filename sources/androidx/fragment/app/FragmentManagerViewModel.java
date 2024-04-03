package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class FragmentManagerViewModel extends ViewModel {
    private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory() {
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }
    };
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentManagerViewModel> mChildNonConfigs = new HashMap<>();
    private boolean mHasBeenCleared = false;
    private boolean mHasSavedSnapshot = false;
    private boolean mIsStateSaved = false;
    private final HashMap<String, Fragment> mRetainedFragments = new HashMap<>();
    private final boolean mStateAutomaticallySaved;
    private final HashMap<String, ViewModelStore> mViewModelStores = new HashMap<>();

    public FragmentManagerViewModel(boolean z11) {
        this.mStateAutomaticallySaved = z11;
    }

    private void clearNonConfigStateInternal(@NonNull String str) {
        FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(str);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.onCleared();
            this.mChildNonConfigs.remove(str);
        }
        ViewModelStore viewModelStore = this.mViewModelStores.get(str);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.mViewModelStores.remove(str);
        }
    }

    @NonNull
    public static FragmentManagerViewModel getInstance(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(FragmentManagerViewModel.class);
    }

    public void addRetainedFragment(@NonNull Fragment fragment) {
        if (this.mIsStateSaved) {
            FragmentManager.isLoggingEnabled(2);
        } else if (!this.mRetainedFragments.containsKey(fragment.mWho)) {
            this.mRetainedFragments.put(fragment.mWho, fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Updating retained Fragments: Added ");
                sb2.append(fragment);
            }
        }
    }

    public void clearNonConfigState(@NonNull Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for ");
            sb2.append(fragment);
        }
        clearNonConfigStateInternal(fragment.mWho);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        if (!this.mRetainedFragments.equals(fragmentManagerViewModel.mRetainedFragments) || !this.mChildNonConfigs.equals(fragmentManagerViewModel.mChildNonConfigs) || !this.mViewModelStores.equals(fragmentManagerViewModel.mViewModelStores)) {
            return false;
        }
        return true;
    }

    @Nullable
    public Fragment findRetainedFragmentByWho(String str) {
        return this.mRetainedFragments.get(str);
    }

    @NonNull
    public FragmentManagerViewModel getChildNonConfig(@NonNull Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            return fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(fragment.mWho, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    @NonNull
    public Collection<Fragment> getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    @Deprecated
    @Nullable
    public FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() && this.mChildNonConfigs.isEmpty() && this.mViewModelStores.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.mChildNonConfigs.entrySet()) {
            FragmentManagerNonConfig snapshot = ((FragmentManagerViewModel) next.getValue()).getSnapshot();
            if (snapshot != null) {
                hashMap.put((String) next.getKey(), snapshot);
            }
        }
        this.mHasSavedSnapshot = true;
        if (!this.mRetainedFragments.isEmpty() || !hashMap.isEmpty() || !this.mViewModelStores.isEmpty()) {
            return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), hashMap, new HashMap(this.mViewModelStores));
        }
        return null;
    }

    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment fragment) {
        ViewModelStore viewModelStore = this.mViewModelStores.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.mViewModelStores.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public int hashCode() {
        return (((this.mRetainedFragments.hashCode() * 31) + this.mChildNonConfigs.hashCode()) * 31) + this.mViewModelStores.hashCode();
    }

    public boolean isCleared() {
        return this.mHasBeenCleared;
    }

    public void onCleared() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCleared called for ");
            sb2.append(this);
        }
        this.mHasBeenCleared = true;
    }

    public void removeRetainedFragment(@NonNull Fragment fragment) {
        boolean z11;
        if (this.mIsStateSaved) {
            FragmentManager.isLoggingEnabled(2);
            return;
        }
        if (this.mRetainedFragments.remove(fragment.mWho) != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating retained Fragments: Removed ");
            sb2.append(fragment);
        }
    }

    @Deprecated
    public void restoreFromSnapshot(@Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> fragments = fragmentManagerNonConfig.getFragments();
            if (fragments != null) {
                for (Fragment next : fragments) {
                    if (next != null) {
                        this.mRetainedFragments.put(next.mWho, next);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
            if (childNonConfigs != null) {
                for (Map.Entry next2 : childNonConfigs.entrySet()) {
                    FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
                    fragmentManagerViewModel.restoreFromSnapshot((FragmentManagerNonConfig) next2.getValue());
                    this.mChildNonConfigs.put((String) next2.getKey(), fragmentManagerViewModel);
                }
            }
            Map<String, ViewModelStore> viewModelStores = fragmentManagerNonConfig.getViewModelStores();
            if (viewModelStores != null) {
                this.mViewModelStores.putAll(viewModelStores);
            }
        }
        this.mHasSavedSnapshot = false;
    }

    public void setIsStateSaved(boolean z11) {
        this.mIsStateSaved = z11;
    }

    public boolean shouldDestroy(@NonNull Fragment fragment) {
        if (!this.mRetainedFragments.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.mStateAutomaticallySaved) {
            return this.mHasBeenCleared;
        }
        return !this.mHasSavedSnapshot;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.mRetainedFragments.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.mChildNonConfigs.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.mViewModelStores.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public void clearNonConfigState(@NonNull String str) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for saved state of Fragment ");
            sb2.append(str);
        }
        clearNonConfigStateInternal(str);
    }
}
