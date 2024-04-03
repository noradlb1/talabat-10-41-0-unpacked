package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.R;
import androidx.navigation.fragment.FragmentNavigator;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b3\u00104J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0015J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0015J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0015J&\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0017J\b\u0010#\u001a\u00020\u0005H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020)8BX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0011\u0010\u000e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavHost;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroidx/navigation/NavHostController;", "navHostController", "k0", "Landroidx/navigation/NavController;", "navController", "j0", "", "isPrimaryNavigationFragment", "onPrimaryNavigationFragmentChanged", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "i0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "Landroid/util/AttributeSet;", "attrs", "onInflate", "outState", "onSaveInstanceState", "onDestroyView", "Landroidx/navigation/NavHostController;", "isPrimaryBeforeOnCreate", "Ljava/lang/Boolean;", "viewParent", "Landroid/view/View;", "", "graphId", "I", "defaultNavHost", "Z", "getContainerId", "()I", "containerId", "getNavController", "()Landroidx/navigation/NavController;", "<init>", "()V", "Companion", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
public class NavHostFragment extends Fragment implements NavHost {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
    @NotNull
    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
    private boolean defaultNavHost;
    private int graphId;
    @Nullable
    private Boolean isPrimaryBeforeOnCreate;
    /* access modifiers changed from: private */
    @Nullable
    public NavHostController navHostController;
    @Nullable
    private View viewParent;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment$Companion;", "", "()V", "KEY_DEFAULT_NAV_HOST", "", "KEY_GRAPH_ID", "KEY_NAV_CONTROLLER_STATE", "KEY_START_DESTINATION_ARGS", "create", "Landroidx/navigation/fragment/NavHostFragment;", "graphResId", "", "startDestinationArgs", "Landroid/os/Bundle;", "findNavController", "Landroidx/navigation/NavController;", "fragment", "Landroidx/fragment/app/Fragment;", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavHostFragment create$default(Companion companion, int i11, Bundle bundle, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                bundle = null;
            }
            return companion.create(i11, bundle);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final NavHostFragment create(@NavigationRes int i11) {
            return create$default(this, i11, (Bundle) null, 2, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final NavHostFragment create(@NavigationRes int i11, @Nullable Bundle bundle) {
            Bundle bundle2;
            if (i11 != 0) {
                bundle2 = new Bundle();
                bundle2.putInt(NavHostFragment.KEY_GRAPH_ID, i11);
            } else {
                bundle2 = null;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBundle(NavHostFragment.KEY_START_DESTINATION_ARGS, bundle);
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle2 != null) {
                navHostFragment.setArguments(bundle2);
            }
            return navHostFragment;
        }

        @JvmStatic
        @NotNull
        public final NavController findNavController(@NotNull Fragment fragment) {
            DialogFragment dialogFragment;
            Dialog dialog;
            Window window;
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
                if (fragment2 instanceof NavHostFragment) {
                    NavHostController access$getNavHostController$p = ((NavHostFragment) fragment2).navHostController;
                    if (access$getNavHostController$p != null) {
                        return access$getNavHostController$p;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
                Fragment primaryNavigationFragment = fragment2.getParentFragmentManager().getPrimaryNavigationFragment();
                if (primaryNavigationFragment instanceof NavHostFragment) {
                    NavHostController access$getNavHostController$p2 = ((NavHostFragment) primaryNavigationFragment).navHostController;
                    if (access$getNavHostController$p2 != null) {
                        return access$getNavHostController$p2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
            }
            View view = fragment.getView();
            if (view != null) {
                return Navigation.findNavController(view);
            }
            View view2 = null;
            if (fragment instanceof DialogFragment) {
                dialogFragment = (DialogFragment) fragment;
            } else {
                dialogFragment = null;
            }
            if (!(dialogFragment == null || (dialog = dialogFragment.getDialog()) == null || (window = dialog.getWindow()) == null)) {
                view2 = window.getDecorView();
            }
            if (view2 != null) {
                return Navigation.findNavController(view2);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
        }
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final NavHostFragment create(@NavigationRes int i11) {
        return Companion.create(i11);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final NavHostFragment create(@NavigationRes int i11, @Nullable Bundle bundle) {
        return Companion.create(i11, bundle);
    }

    @JvmStatic
    @NotNull
    public static final NavController findNavController(@NotNull Fragment fragment) {
        return Companion.findNavController(fragment);
    }

    private final int getContainerId() {
        int id2 = getId();
        if (id2 == 0 || id2 == -1) {
            return R.id.nav_host_fragment_container;
        }
        return id2;
    }

    @NotNull
    public final NavController getNavController() {
        NavHostController navHostController2 = this.navHostController;
        if (navHostController2 == null) {
            throw new IllegalStateException("NavController is not available before onCreate()".toString());
        } else if (navHostController2 != null) {
            return navHostController2;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavHostController");
        }
    }

    @NotNull
    @Deprecated(message = "Use {@link #onCreateNavController(NavController)}")
    public Navigator<? extends FragmentNavigator.Destination> i0() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return new FragmentNavigator(requireContext, childFragmentManager, getContainerId());
    }

    @CallSuper
    @Deprecated(message = "Override {@link #onCreateNavHostController(NavHostController)} to gain\n      access to the full {@link NavHostController} that is created by this NavHostFragment.")
    public void j0(@NotNull NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavigatorProvider navigatorProvider = navController.getNavigatorProvider();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        navigatorProvider.addNavigator(new DialogFragmentNavigator(requireContext, childFragmentManager));
        navController.getNavigatorProvider().addNavigator(i0());
    }

    @CallSuper
    public void k0(@NotNull NavHostController navHostController2) {
        Intrinsics.checkNotNullParameter(navHostController2, "navHostController");
        j0(navHostController2);
    }

    @CallSuper
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (this.defaultNavHost) {
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c0  */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.requireContext()
            java.lang.String r1 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.navigation.NavHostController r1 = new androidx.navigation.NavHostController
            r1.<init>(r0)
            r6.navHostController = r1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.setLifecycleOwner(r6)
        L_0x0016:
            boolean r1 = r0 instanceof android.content.ContextWrapper
            if (r1 == 0) goto L_0x003e
            boolean r1 = r0 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r1 == 0) goto L_0x0032
            androidx.navigation.NavHostController r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.activity.OnBackPressedDispatcherOwner r0 = (androidx.activity.OnBackPressedDispatcherOwner) r0
            androidx.activity.OnBackPressedDispatcher r0 = r0.getOnBackPressedDispatcher()
            java.lang.String r2 = "context as OnBackPressed…).onBackPressedDispatcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r1.setOnBackPressedDispatcher(r0)
            goto L_0x003e
        L_0x0032:
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            java.lang.String r1 = "context.baseContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x0016
        L_0x003e:
            androidx.navigation.NavHostController r0 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Boolean r1 = r6.isPrimaryBeforeOnCreate
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x005b
            if (r1 == 0) goto L_0x0053
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x005b
            r1 = r2
            goto L_0x005c
        L_0x0053:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Boolean"
            r7.<init>(r0)
            throw r7
        L_0x005b:
            r1 = r3
        L_0x005c:
            r0.enableOnBackPressed(r1)
            r0 = 0
            r6.isPrimaryBeforeOnCreate = r0
            androidx.navigation.NavHostController r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.lifecycle.ViewModelStore r4 = r6.getViewModelStore()
            java.lang.String r5 = "viewModelStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r1.setViewModelStore(r4)
            androidx.navigation.NavHostController r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r6.k0(r1)
            java.lang.String r1 = "android-support-nav:fragment:graphId"
            if (r7 == 0) goto L_0x00a6
            java.lang.String r4 = "android-support-nav:fragment:navControllerState"
            android.os.Bundle r4 = r7.getBundle(r4)
            java.lang.String r5 = "android-support-nav:fragment:defaultHost"
            boolean r5 = r7.getBoolean(r5, r3)
            if (r5 == 0) goto L_0x009f
            r6.defaultNavHost = r2
            androidx.fragment.app.FragmentManager r2 = r6.getParentFragmentManager()
            androidx.fragment.app.FragmentTransaction r2 = r2.beginTransaction()
            androidx.fragment.app.FragmentTransaction r2 = r2.setPrimaryNavigationFragment(r6)
            r2.commit()
        L_0x009f:
            int r2 = r7.getInt(r1)
            r6.graphId = r2
            goto L_0x00a7
        L_0x00a6:
            r4 = r0
        L_0x00a7:
            if (r4 == 0) goto L_0x00b1
            androidx.navigation.NavHostController r2 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2.restoreState(r4)
        L_0x00b1:
            int r2 = r6.graphId
            if (r2 == 0) goto L_0x00c0
            androidx.navigation.NavHostController r0 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r1 = r6.graphId
            r0.setGraph((int) r1)
            goto L_0x00dc
        L_0x00c0:
            android.os.Bundle r2 = r6.getArguments()
            if (r2 == 0) goto L_0x00ca
            int r3 = r2.getInt(r1)
        L_0x00ca:
            if (r2 == 0) goto L_0x00d2
            java.lang.String r0 = "android-support-nav:fragment:startDestinationArgs"
            android.os.Bundle r0 = r2.getBundle(r0)
        L_0x00d2:
            if (r3 == 0) goto L_0x00dc
            androidx.navigation.NavHostController r1 = r6.navHostController
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.setGraph((int) r3, (android.os.Bundle) r0)
        L_0x00dc:
            super.onCreate(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.NavHostFragment.onCreate(android.os.Bundle):void");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = layoutInflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(getContainerId());
        return fragmentContainerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        View view = this.viewParent;
        if (view != null && Navigation.findNavController(view) == this.navHostController) {
            Navigation.setViewNavController(view, (NavController) null);
        }
        this.viewParent = null;
    }

    @CallSuper
    public void onInflate(@NotNull Context context, @NotNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavHost);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.graphId = resourceId;
        }
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.NavHostFragment);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "context.obtainStyledAttr…tyleable.NavHostFragment)");
        if (obtainStyledAttributes2.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
            this.defaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @CallSuper
    public void onPrimaryNavigationFragmentChanged(boolean z11) {
        NavHostController navHostController2 = this.navHostController;
        if (navHostController2 == null) {
            this.isPrimaryBeforeOnCreate = Boolean.valueOf(z11);
        } else if (navHostController2 != null) {
            navHostController2.enableOnBackPressed(z11);
        }
    }

    @CallSuper
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NavHostController navHostController2 = this.navHostController;
        Intrinsics.checkNotNull(navHostController2);
        Bundle saveState = navHostController2.saveState();
        if (saveState != null) {
            bundle.putBundle(KEY_NAV_CONTROLLER_STATE, saveState);
        }
        if (this.defaultNavHost) {
            bundle.putBoolean(KEY_DEFAULT_NAV_HOST, true);
        }
        int i11 = this.graphId;
        if (i11 != 0) {
            bundle.putInt(KEY_GRAPH_ID, i11);
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            Navigation.setViewNavController(view, this.navHostController);
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    View view2 = (View) parent;
                    this.viewParent = view2;
                    Intrinsics.checkNotNull(view2);
                    if (view2.getId() == getId()) {
                        View view3 = this.viewParent;
                        Intrinsics.checkNotNull(view3);
                        Navigation.setViewNavController(view3, this.navHostController);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            return;
        }
        throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
    }
}
