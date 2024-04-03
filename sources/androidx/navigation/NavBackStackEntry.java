package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003LMNB\u001b\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bBQ\b\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\u0013\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0007J\b\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\u0007H\u0007J\b\u0010K\u001a\u00020DH\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\f@\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R&\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8FX\u0002¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b-\u0010.R\u0014\u00100\u001a\u0002018VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "entry", "arguments", "Landroid/os/Bundle;", "(Landroidx/navigation/NavBackStackEntry;Landroid/os/Bundle;)V", "context", "Landroid/content/Context;", "destination", "Landroidx/navigation/NavDestination;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "savedState", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/NavViewModelStoreProvider;Ljava/lang/String;Landroid/os/Bundle;)V", "getArguments", "()Landroid/os/Bundle;", "defaultFactory", "Landroidx/lifecycle/SavedStateViewModelFactory;", "getDefaultFactory", "()Landroidx/lifecycle/SavedStateViewModelFactory;", "defaultFactory$delegate", "Lkotlin/Lazy;", "getDestination", "()Landroidx/navigation/NavDestination;", "setDestination", "(Landroidx/navigation/NavDestination;)V", "getId", "()Ljava/lang/String;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "maxState", "maxLifecycle", "getMaxLifecycle", "()Landroidx/lifecycle/Lifecycle$State;", "setMaxLifecycle", "(Landroidx/lifecycle/Lifecycle$State;)V", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "getSavedStateHandle", "()Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle$delegate", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryAttached", "", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "equals", "other", "", "getDefaultViewModelCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "handleLifecycleEvent", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "hashCode", "", "saveState", "outBundle", "updateState", "Companion", "NavResultSavedStateFactory", "SavedStateViewModel", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Bundle arguments;
    /* access modifiers changed from: private */
    @Nullable
    public final Context context;
    @NotNull
    private final Lazy defaultFactory$delegate;
    @NotNull
    private NavDestination destination;
    @NotNull
    private Lifecycle.State hostLifecycleState;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f36300id;
    /* access modifiers changed from: private */
    @NotNull
    public LifecycleRegistry lifecycle;
    @NotNull
    private Lifecycle.State maxLifecycle;
    @Nullable
    private final Bundle savedState;
    @NotNull
    private final Lazy savedStateHandle$delegate;
    /* access modifiers changed from: private */
    public boolean savedStateRegistryAttached;
    @NotNull
    private final SavedStateRegistryController savedStateRegistryController;
    @Nullable
    private final NavViewModelStoreProvider viewModelStoreProvider;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavBackStackEntry$Companion;", "", "()V", "create", "Landroidx/navigation/NavBackStackEntry;", "context", "Landroid/content/Context;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "savedState", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry create$default(Companion companion, Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, int i11, Object obj) {
            Bundle bundle3;
            Lifecycle.State state2;
            NavViewModelStoreProvider navViewModelStoreProvider2;
            String str2;
            Bundle bundle4;
            if ((i11 & 4) != 0) {
                bundle3 = null;
            } else {
                bundle3 = bundle;
            }
            if ((i11 & 8) != 0) {
                state2 = Lifecycle.State.CREATED;
            } else {
                state2 = state;
            }
            if ((i11 & 16) != 0) {
                navViewModelStoreProvider2 = null;
            } else {
                navViewModelStoreProvider2 = navViewModelStoreProvider;
            }
            if ((i11 & 32) != 0) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                str2 = uuid;
            } else {
                str2 = str;
            }
            if ((i11 & 64) != 0) {
                bundle4 = null;
            } else {
                bundle4 = bundle2;
            }
            return companion.create(context, navDestination, bundle3, state2, navViewModelStoreProvider2, str2, bundle4);
        }

        @NotNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final NavBackStackEntry create(@Nullable Context context, @NotNull NavDestination navDestination, @Nullable Bundle bundle, @NotNull Lifecycle.State state, @Nullable NavViewModelStoreProvider navViewModelStoreProvider, @NotNull String str, @Nullable Bundle bundle2) {
            Intrinsics.checkNotNullParameter(navDestination, "destination");
            Intrinsics.checkNotNullParameter(state, "hostLifecycleState");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "id");
            return new NavBackStackEntry(context, navDestination, bundle, state, navViewModelStoreProvider, str2, bundle2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/navigation/NavBackStackEntry$NavResultSavedStateFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "", "key", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/SavedStateHandle;", "handle", "a", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NavResultSavedStateFactory(@NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
            super(savedStateRegistryOwner, (Bundle) null);
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        }

        @NotNull
        public <T extends ViewModel> T a(@NotNull String str, @NotNull Class<T> cls, @NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
            return new SavedStateViewModel(savedStateHandle);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavBackStackEntry$SavedStateViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "getHandle", "()Landroidx/lifecycle/SavedStateHandle;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SavedStateViewModel extends ViewModel {
        @NotNull
        private final SavedStateHandle handle;

        public SavedStateViewModel(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
            this.handle = savedStateHandle;
        }

        @NotNull
        public final SavedStateHandle getHandle() {
            return this.handle;
        }
    }

    private NavBackStackEntry(Context context2, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2) {
        this.context = context2;
        this.destination = navDestination;
        this.arguments = bundle;
        this.hostLifecycleState = state;
        this.viewModelStoreProvider = navViewModelStoreProvider;
        this.f36300id = str;
        this.savedState = bundle2;
        this.lifecycle = new LifecycleRegistry(this);
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(this);
        this.defaultFactory$delegate = LazyKt__LazyJVMKt.lazy(new NavBackStackEntry$defaultFactory$2(this));
        this.savedStateHandle$delegate = LazyKt__LazyJVMKt.lazy(new NavBackStackEntry$savedStateHandle$2(this));
        this.maxLifecycle = Lifecycle.State.INITIALIZED;
    }

    public /* synthetic */ NavBackStackEntry(Context context2, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, navDestination, bundle, state, navViewModelStoreProvider, str, bundle2);
    }

    private final SavedStateViewModelFactory getDefaultFactory() {
        return (SavedStateViewModelFactory) this.defaultFactory$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0083
            boolean r1 = r7 instanceof androidx.navigation.NavBackStackEntry
            if (r1 != 0) goto L_0x0009
            goto L_0x0083
        L_0x0009:
            java.lang.String r1 = r6.f36300id
            androidx.navigation.NavBackStackEntry r7 = (androidx.navigation.NavBackStackEntry) r7
            java.lang.String r2 = r7.f36300id
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0083
            androidx.navigation.NavDestination r1 = r6.destination
            androidx.navigation.NavDestination r2 = r7.destination
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0083
            androidx.lifecycle.LifecycleRegistry r1 = r6.lifecycle
            androidx.lifecycle.LifecycleRegistry r2 = r7.lifecycle
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0083
            androidx.savedstate.SavedStateRegistry r1 = r6.getSavedStateRegistry()
            androidx.savedstate.SavedStateRegistry r2 = r7.getSavedStateRegistry()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0083
            android.os.Bundle r1 = r6.arguments
            android.os.Bundle r2 = r7.arguments
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r2 = 1
            if (r1 != 0) goto L_0x0082
            android.os.Bundle r1 = r6.arguments
            if (r1 == 0) goto L_0x007f
            java.util.Set r1 = r1.keySet()
            if (r1 == 0) goto L_0x007f
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x0054
        L_0x0052:
            r7 = r2
            goto L_0x007b
        L_0x0054:
            java.util.Iterator r1 = r1.iterator()
        L_0x0058:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0052
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = r6.arguments
            java.lang.Object r4 = r4.get(r3)
            android.os.Bundle r5 = r7.arguments
            if (r5 == 0) goto L_0x0073
            java.lang.Object r3 = r5.get(r3)
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x0058
            r7 = r0
        L_0x007b:
            if (r7 != r2) goto L_0x007f
            r7 = r2
            goto L_0x0080
        L_0x007f:
            r7 = r0
        L_0x0080:
            if (r7 == 0) goto L_0x0083
        L_0x0082:
            r0 = r2
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavBackStackEntry.equals(java.lang.Object):boolean");
    }

    @Nullable
    public final Bundle getArguments() {
        return this.arguments;
    }

    @NotNull
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context context2;
        Application application = null;
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) null, 1, (DefaultConstructorMarker) null);
        Context context3 = this.context;
        if (context3 != null) {
            context2 = context3.getApplicationContext();
        } else {
            context2 = null;
        }
        if (context2 instanceof Application) {
            application = (Application) context2;
        }
        if (application != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        Bundle bundle = this.arguments;
        if (bundle != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, bundle);
        }
        return mutableCreationExtras;
    }

    @NotNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return getDefaultFactory();
    }

    @NotNull
    public final NavDestination getDestination() {
        return this.destination;
    }

    @NotNull
    public final String getId() {
        return this.f36300id;
    }

    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Lifecycle.State getMaxLifecycle() {
        return this.maxLifecycle;
    }

    @NotNull
    public final SavedStateHandle getSavedStateHandle() {
        return (SavedStateHandle) this.savedStateHandle$delegate.getValue();
    }

    @NotNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @NotNull
    public ViewModelStore getViewModelStore() {
        boolean z11;
        if (this.savedStateRegistryAttached) {
            if (this.lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                NavViewModelStoreProvider navViewModelStoreProvider = this.viewModelStoreProvider;
                if (navViewModelStoreProvider != null) {
                    return navViewModelStoreProvider.getViewModelStore(this.f36300id);
                }
                throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
            }
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void handleLifecycleEvent(@NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.checkNotNullExpressionValue(targetState, "event.targetState");
        this.hostLifecycleState = targetState;
        updateState();
    }

    public int hashCode() {
        Set<String> keySet;
        int i11;
        int hashCode = (this.f36300id.hashCode() * 31) + this.destination.hashCode();
        Bundle bundle = this.arguments;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i12 = hashCode * 31;
                Object obj = this.arguments.get(str);
                if (obj != null) {
                    i11 = obj.hashCode();
                } else {
                    i11 = 0;
                }
                hashCode = i12 + i11;
            }
        }
        return (((hashCode * 31) + this.lifecycle.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void saveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outBundle");
        this.savedStateRegistryController.performSave(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setDestination(@NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "<set-?>");
        this.destination = navDestination;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setMaxLifecycle(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "maxState");
        this.maxLifecycle = state;
        updateState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void updateState() {
        if (!this.savedStateRegistryAttached) {
            this.savedStateRegistryController.performAttach();
            this.savedStateRegistryAttached = true;
            if (this.viewModelStoreProvider != null) {
                SavedStateHandleSupport.enableSavedStateHandles(this);
            }
            this.savedStateRegistryController.performRestore(this.savedState);
        }
        if (this.hostLifecycleState.ordinal() < this.maxLifecycle.ordinal()) {
            this.lifecycle.setCurrentState(this.hostLifecycleState);
        } else {
            this.lifecycle.setCurrentState(this.maxLifecycle);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavBackStackEntry(NavBackStackEntry navBackStackEntry, Bundle bundle, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(navBackStackEntry, (i11 & 2) != 0 ? navBackStackEntry.arguments : bundle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavBackStackEntry(@NotNull NavBackStackEntry navBackStackEntry, @Nullable Bundle bundle) {
        this(navBackStackEntry.context, navBackStackEntry.destination, bundle, navBackStackEntry.hostLifecycleState, navBackStackEntry.viewModelStoreProvider, navBackStackEntry.f36300id, navBackStackEntry.savedState);
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        this.hostLifecycleState = navBackStackEntry.hostLifecycleState;
        setMaxLifecycle(navBackStackEntry.maxLifecycle);
    }
}
