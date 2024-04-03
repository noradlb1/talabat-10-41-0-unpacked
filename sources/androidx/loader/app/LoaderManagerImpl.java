package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import d2.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36147a = false;
    @NonNull
    private final LifecycleOwner mLifecycleOwner;
    @NonNull
    private final LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        @Nullable
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        @NonNull
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        public LoaderInfo(int i11, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.mId = i11;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            loader.registerListener(i11, this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            Loader<D> loader = this.mLoader;
            loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.mObserver != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                LoaderObserver<D> loaderObserver = this.mObserver;
                loaderObserver.dump(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(h().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        public void e() {
            if (LoaderManagerImpl.f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Starting: ");
                sb2.append(this);
            }
            this.mLoader.startLoading();
        }

        public void f() {
            if (LoaderManagerImpl.f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Stopping: ");
                sb2.append(this);
            }
            this.mLoader.stopLoading();
        }

        @MainThread
        public Loader<D> g(boolean z11) {
            if (LoaderManagerImpl.f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Destroying: ");
                sb2.append(this);
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z11) {
                    loaderObserver.b();
                }
            }
            this.mLoader.unregisterListener(this);
            if ((loaderObserver == null || loaderObserver.a()) && !z11) {
                return this.mLoader;
            }
            this.mLoader.reset();
            return this.mPriorLoader;
        }

        @NonNull
        public Loader<D> h() {
            return this.mLoader;
        }

        public boolean i() {
            LoaderObserver<D> loaderObserver;
            if (hasActiveObservers() && (loaderObserver = this.mObserver) != null && !loaderObserver.a()) {
                return true;
            }
            return false;
        }

        public void j() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.removeObserver(loaderObserver);
                observe(lifecycleOwner, loaderObserver);
            }
        }

        @MainThread
        @NonNull
        public Loader<D> k(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.mLoader, loaderCallbacks);
            observe(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.mObserver;
            if (loaderObserver2 != null) {
                removeObserver(loaderObserver2);
            }
            this.mLifecycleOwner = lifecycleOwner;
            this.mObserver = loaderObserver;
            return this.mLoader;
        }

        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d11) {
            if (LoaderManagerImpl.f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onLoadComplete: ");
                sb2.append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d11);
                return;
            }
            if (LoaderManagerImpl.f36147a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d11);
        }

        public void removeObserver(@NonNull Observer<? super D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        public void setValue(D d11) {
            super.setValue(d11);
            Loader<D> loader = this.mPriorLoader;
            if (loader != null) {
                loader.reset();
                this.mPriorLoader = null;
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.mId);
            sb2.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    public static class LoaderObserver<D> implements Observer<D> {
        @NonNull
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData = false;
        @NonNull
        private final Loader<D> mLoader;

        public LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        public boolean a() {
            return this.mDeliveredData;
        }

        @MainThread
        public void b() {
            if (this.mDeliveredData) {
                if (LoaderManagerImpl.f36147a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Resetting: ");
                    sb2.append(this.mLoader);
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.mDeliveredData);
        }

        public void onChanged(@Nullable D d11) {
            if (LoaderManagerImpl.f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  onLoadFinished in ");
                sb2.append(this.mLoader);
                sb2.append(": ");
                sb2.append(this.mLoader.dataToString(d11));
            }
            this.mCallback.onLoadFinished(this.mLoader, d11);
            this.mDeliveredData = true;
        }

        public String toString() {
            return this.mCallback.toString();
        }
    }

    public static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory() {
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }

            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return h.b(this, cls, creationExtras);
            }
        };
        private boolean mCreatingLoader = false;
        private SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<>();

        @NonNull
        public static LoaderViewModel b(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(LoaderViewModel.class);
        }

        public void a() {
            this.mCreatingLoader = false;
        }

        public <D> LoaderInfo<D> c(int i11) {
            return this.mLoaders.get(i11);
        }

        public boolean d() {
            int size = this.mLoaders.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (this.mLoaders.valueAt(i11).i()) {
                    return true;
                }
            }
            return false;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i11 = 0; i11 < this.mLoaders.size(); i11++) {
                    LoaderInfo valueAt = this.mLoaders.valueAt(i11);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i11));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public boolean e() {
            return this.mCreatingLoader;
        }

        public void f() {
            int size = this.mLoaders.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mLoaders.valueAt(i11).j();
            }
        }

        public void g(int i11, @NonNull LoaderInfo loaderInfo) {
            this.mLoaders.put(i11, loaderInfo);
        }

        public void h(int i11) {
            this.mLoaders.remove(i11);
        }

        public void i() {
            this.mCreatingLoader = true;
        }

        public void onCleared() {
            super.onCleared();
            int size = this.mLoaders.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mLoaders.valueAt(i11).g(true);
            }
            this.mLoaders.clear();
        }
    }

    public LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = LoaderViewModel.b(viewModelStore);
    }

    /* JADX INFO: finally extract failed */
    @MainThread
    @NonNull
    private <D> Loader<D> createAndInstallLoader(int i11, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        try {
            this.mLoaderViewModel.i();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i11, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                LoaderInfo loaderInfo = new LoaderInfo(i11, bundle, onCreateLoader, loader);
                if (f36147a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Created new loader ");
                    sb2.append(loaderInfo);
                }
                this.mLoaderViewModel.g(i11, loaderInfo);
                this.mLoaderViewModel.a();
                return loaderInfo.k(this.mLifecycleOwner, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th2) {
            this.mLoaderViewModel.a();
            throw th2;
        }
    }

    @MainThread
    public void destroyLoader(int i11) {
        if (this.mLoaderViewModel.e()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("destroyLoader in ");
                sb2.append(this);
                sb2.append(" of ");
                sb2.append(i11);
            }
            LoaderInfo c11 = this.mLoaderViewModel.c(i11);
            if (c11 != null) {
                c11.g(true);
                this.mLoaderViewModel.h(i11);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mLoaderViewModel.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public <D> Loader<D> getLoader(int i11) {
        if (!this.mLoaderViewModel.e()) {
            LoaderInfo c11 = this.mLoaderViewModel.c(i11);
            if (c11 != null) {
                return c11.h();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.d();
    }

    @MainThread
    @NonNull
    public <D> Loader<D> initLoader(int i11, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.e()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo c11 = this.mLoaderViewModel.c(i11);
            if (f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initLoader in ");
                sb2.append(this);
                sb2.append(": args=");
                sb2.append(bundle);
            }
            if (c11 == null) {
                return createAndInstallLoader(i11, bundle, loaderCallbacks, (Loader) null);
            }
            if (f36147a) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  Re-using existing loader ");
                sb3.append(c11);
            }
            return c11.k(this.mLifecycleOwner, loaderCallbacks);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void markForRedelivery() {
        this.mLoaderViewModel.f();
    }

    @MainThread
    @NonNull
    public <D> Loader<D> restartLoader(int i11, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        Loader loader;
        if (this.mLoaderViewModel.e()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f36147a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("restartLoader in ");
                sb2.append(this);
                sb2.append(": args=");
                sb2.append(bundle);
            }
            LoaderInfo c11 = this.mLoaderViewModel.c(i11);
            if (c11 != null) {
                loader = c11.g(false);
            } else {
                loader = null;
            }
            return createAndInstallLoader(i11, bundle, loaderCallbacks, loader);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
