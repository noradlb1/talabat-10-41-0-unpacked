package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.DoNotInline;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import d.d;
import d.e;
import d.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    @LayoutRes
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        public static void cancelPendingInputEvents(View view) {
            view.cancelPendingInputEvents();
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new d(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController create = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = create;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            public void run() {
                try {
                    ComponentActivity.super.onBackPressed();
                } catch (IllegalStateException e11) {
                    if (!TextUtils.equals(e11.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e11;
                    }
                }
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ActivityResultRegistry() {
            public <I, O> void onLaunch(final int i11, @NonNull ActivityResultContract<I, O> activityResultContract, I i12, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                Bundle bundle;
                Bundle bundle2;
                ComponentActivity componentActivity = ComponentActivity.this;
                final ActivityResultContract.SynchronousResult<O> synchronousResult = activityResultContract.getSynchronousResult(componentActivity, i12);
                if (synchronousResult != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            AnonymousClass2.this.dispatchResult(i11, synchronousResult.getValue());
                        }
                    });
                    return;
                }
                Intent createIntent = activityResultContract.createIntent(componentActivity, i12);
                if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                    createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (createIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
                    Bundle bundleExtra = createIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                    createIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                    bundle = bundleExtra;
                } else {
                    if (activityOptionsCompat != null) {
                        bundle2 = activityOptionsCompat.toBundle();
                    } else {
                        bundle2 = null;
                    }
                    bundle = bundle2;
                }
                if (ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS.equals(createIntent.getAction())) {
                    String[] stringArrayExtra = createIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, i11);
                } else if (ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST.equals(createIntent.getAction())) {
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
                    try {
                        ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), i11, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
                    } catch (IntentSender.SendIntentException e11) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                AnonymousClass2.this.dispatchResult(i11, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, e11));
                            }
                        });
                    }
                } else {
                    ActivityCompat.startActivityForResult(componentActivity, createIntent, i11, bundle);
                }
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            int i11 = Build.VERSION.SDK_INT;
            getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            Api19Impl.cancelPendingInputEvents(view);
                        }
                    }
                }
            });
            getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.clearAvailableContext();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().clear();
                        }
                    }
                }
            });
            getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().removeObserver(this);
                }
            });
            create.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(this);
            if (i11 <= 23) {
                getLifecycle().addObserver(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new e(this));
            addOnContextAvailableListener(new f(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$0() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Context context) {
        Bundle consumeRestoredStateForKey = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (consumeRestoredStateForKey != null) {
            this.mActivityResultRegistry.onRestoreInstanceState(consumeRestoredStateForKey);
        }
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuHostHelper.addMenuProvider(menuProvider);
    }

    public final void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.addOnContextAvailableListener(onContextAvailableListener);
    }

    public final void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(@NonNull Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.add(consumer);
    }

    public final void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer);
    }

    public final void addOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.add(consumer);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @CallSuper
    @NonNull
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (getApplication() != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    @Nullable
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @CallSuper
    @Deprecated
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        if (!this.mActivityResultRegistry.dispatchResult(i11, i12, intent)) {
            super.onActivityResult(i11, i12, intent);
        }
    }

    @MainThread
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public void onCreate(@Nullable Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
        if (BuildCompat.isAtLeastT()) {
            this.mOnBackPressedDispatcher.setOnBackInvokedDispatcher(Api33Impl.getOnBackInvokedDispatcher(this));
        }
        int i11 = this.mContentLayoutId;
        if (i11 != 0) {
            setContentView(i11);
        }
    }

    public boolean onCreatePanelMenu(int i11, @NonNull Menu menu) {
        if (i11 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i11, menu);
        this.mMenuHostHelper.onCreateMenu(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i11, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i11, menuItem)) {
            return true;
        }
        if (i11 == 0) {
            return this.mMenuHostHelper.onMenuItemSelected(menuItem);
        }
        return false;
    }

    @CallSuper
    public void onMultiWindowModeChanged(boolean z11) {
        if (!this.mDispatchingOnMultiWindowModeChanged) {
            Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z11));
            }
        }
    }

    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public void onPanelClosed(int i11, @NonNull Menu menu) {
        this.mMenuHostHelper.onMenuClosed(menu);
        super.onPanelClosed(i11, menu);
    }

    @CallSuper
    public void onPictureInPictureModeChanged(boolean z11) {
        if (!this.mDispatchingOnPictureInPictureModeChanged) {
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z11));
            }
        }
    }

    public boolean onPreparePanel(int i11, @Nullable View view, @NonNull Menu menu) {
        if (i11 != 0) {
            return true;
        }
        super.onPreparePanel(i11, view, menu);
        this.mMenuHostHelper.onPrepareMenu(menu);
        return true;
    }

    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.mActivityResultRegistry.dispatchResult(i11, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, iArr))) {
            super.onRequestPermissionsResult(i11, strArr, iArr);
        }
    }

    @Deprecated
    @Nullable
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.custom = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances2.viewModelStore = viewModelStore;
        return nonConfigurationInstances2;
    }

    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
    }

    @CallSuper
    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        Iterator<Consumer<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i11));
        }
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    public final void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener);
    }

    public final void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(@NonNull Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.remove(consumer);
    }

    public final void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer);
    }

    public final void removeOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.remove(consumer);
    }

    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        } finally {
            Trace.endSection();
        }
    }

    public void setContentView(@LayoutRes int i11) {
        initViewTreeOwners();
        super.setContentView(i11);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i11) {
        super.startActivityForResult(intent, i11);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14);
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i11, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i11, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean z11, @NonNull Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z11, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z11, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z11, @NonNull Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z11, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z11, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th2;
        }
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int i11) {
        this();
        this.mContentLayoutId = i11;
    }
}
