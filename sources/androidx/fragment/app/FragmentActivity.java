package androidx.fragment.app;

import a2.a;
import a2.b;
import a2.c;
import a2.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry = new LifecycleRegistry(this);
    final FragmentController mFragments = FragmentController.createController(new HostCallbacks());
    boolean mResumed;
    boolean mStopped = true;

    public class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener, MenuHost {
        public HostCallbacks() {
            super(FragmentActivity.this);
        }

        public void addMenuProvider(@NonNull MenuProvider menuProvider) {
            FragmentActivity.this.addMenuProvider(menuProvider);
        }

        public void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
            FragmentActivity.this.addOnConfigurationChangedListener(consumer);
        }

        public void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
            FragmentActivity.this.addOnMultiWindowModeChangedListener(consumer);
        }

        public void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
            FragmentActivity.this.addOnPictureInPictureModeChangedListener(consumer);
        }

        public void addOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
            FragmentActivity.this.addOnTrimMemoryListener(consumer);
        }

        @NonNull
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @NonNull
        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @NonNull
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @NonNull
        public SavedStateRegistry getSavedStateRegistry() {
            return FragmentActivity.this.getSavedStateRegistry();
        }

        @NonNull
        public ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public void invalidateMenu() {
            FragmentActivity.this.invalidateOptionsMenu();
        }

        public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public void onDump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Nullable
        public View onFindViewById(int i11) {
            return FragmentActivity.this.findViewById(i11);
        }

        @NonNull
        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null || window.peekDecorView() == null) {
                return false;
            }
            return true;
        }

        public boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }

        public void onSupportInvalidateOptionsMenu() {
            invalidateMenu();
        }

        public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
            FragmentActivity.this.removeMenuProvider(menuProvider);
        }

        public void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
            FragmentActivity.this.removeOnConfigurationChangedListener(consumer);
        }

        public void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
            FragmentActivity.this.removeOnMultiWindowModeChangedListener(consumer);
        }

        public void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
            FragmentActivity.this.removeOnPictureInPictureModeChangedListener(consumer);
        }

        public void removeOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
            FragmentActivity.this.removeOnTrimMemoryListener(consumer);
        }

        public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
            FragmentActivity.this.addMenuProvider(menuProvider, lifecycleOwner);
        }

        public FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }

        public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
            FragmentActivity.this.addMenuProvider(menuProvider, lifecycleOwner, state);
        }
    }

    public FragmentActivity() {
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(LIFECYCLE_TAG, new a(this));
        addOnConfigurationChangedListener(new b(this));
        addOnNewIntentListener(new c(this));
        addOnContextAvailableListener(new d(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Configuration configuration) {
        this.mFragments.noteStateNotSaved();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(Intent intent) {
        this.mFragments.noteStateNotSaved();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(Context context) {
        this.mFragments.attachHost((Fragment) null);
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z11 = false;
        for (Fragment next : fragmentManager.getFragments()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z11 |= markState(next.getChildFragmentManager(), state);
                }
                FragmentViewLifecycleOwner fragmentViewLifecycleOwner = next.mViewLifecycleOwner;
                if (fragmentViewLifecycleOwner != null && fragmentViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    next.mViewLifecycleOwner.setCurrentState(state);
                    z11 = true;
                }
                if (next.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    next.mLifecycleRegistry.setCurrentState(state);
                    z11 = true;
                }
            }
        }
        return z11;
    }

    @Nullable
    public final View dispatchFragmentsOnCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, str, context, attributeSet);
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                LoaderManager.getInstance(this).dump(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @NonNull
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    @CallSuper
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(i11, i12, intent);
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public boolean onMenuItemSelected(int i11, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i11, menuItem)) {
            return true;
        }
        if (i11 == 6) {
            return this.mFragments.dispatchContextItemSelected(menuItem);
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @CallSuper
    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    public void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i11) {
        startActivityFromFragment(fragment, intent, i11, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i11 == -1) {
            ActivityCompat.startIntentSenderForResult(this, intentSender, i11, intent, i12, i13, i14, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i11) {
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i11, @Nullable Bundle bundle) {
        if (i11 == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i11, bundle);
        }
    }

    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @ContentView
    public FragmentActivity(@LayoutRes int i11) {
        super(i11);
        init();
    }
}
