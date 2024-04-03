package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.ViewModelStoreOwner;
import tracking.gtm.TalabatGTM;

class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;
    @NonNull
    private final Fragment mFragment;
    private int mFragmentManagerState = -1;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState = false;

    /* renamed from: androidx.fragment.app.FragmentStateManager$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$lifecycle$Lifecycle$State = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.AnonymousClass2.<clinit>():void");
        }
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    private boolean isFragmentViewChild(@NonNull View view) {
        if (view == this.mFragment.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.mFragment.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.mFragment.mView != null) {
            saveViewState();
        }
        if (this.mFragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
        }
        if (this.mFragment.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle(VIEW_REGISTRY_STATE_TAG, this.mFragment.mSavedViewRegistryState);
        }
        if (!this.mFragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    public void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ACTIVITY_CREATED: ");
            sb2.append(this.mFragment);
        }
        Fragment fragment = this.mFragment;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment2 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void addViewToContainer() {
        int findFragmentIndexInContainer = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        Fragment fragment = this.mFragment;
        fragment.mContainer.addView(fragment.mView, findFragmentIndexInContainer);
    }

    public void attach() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ATTACHED: ");
            sb2.append(this.mFragment);
        }
        Fragment fragment = this.mFragment;
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = this.mFragmentStore.getFragmentStateManager(fragment2.mWho);
            if (fragmentStateManager2 != null) {
                Fragment fragment3 = this.mFragment;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                fragmentStateManager = fragmentStateManager2;
            } else {
                throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = this.mFragmentStore.getFragmentStateManager(str)) == null) {
                throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.moveToExpectedState();
        }
        Fragment fragment4 = this.mFragment;
        fragment4.mHost = fragment4.mFragmentManager.getHost();
        Fragment fragment5 = this.mFragment;
        fragment5.mParentFragment = fragment5.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
    }

    public int computeExpectedState() {
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact;
        Fragment fragment = this.mFragment;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i11 = this.mFragmentManagerState;
        int i12 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[fragment.mMaxState.ordinal()];
        if (i12 != 1) {
            if (i12 == 2) {
                i11 = Math.min(i11, 5);
            } else if (i12 == 3) {
                i11 = Math.min(i11, 1);
            } else if (i12 != 4) {
                i11 = Math.min(i11, -1);
            } else {
                i11 = Math.min(i11, 0);
            }
        }
        Fragment fragment2 = this.mFragment;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i11 = Math.max(this.mFragmentManagerState, 2);
                View view = this.mFragment.mView;
                if (view != null && view.getParent() == null) {
                    i11 = Math.min(i11, 2);
                }
            } else {
                i11 = this.mFragmentManagerState < 4 ? Math.min(i11, fragment2.mState) : Math.min(i11, 1);
            }
        }
        if (!this.mFragment.mAdded) {
            i11 = Math.min(i11, 1);
        }
        Fragment fragment3 = this.mFragment;
        ViewGroup viewGroup = fragment3.mContainer;
        if (viewGroup != null) {
            lifecycleImpact = SpecialEffectsController.getOrCreateController(viewGroup, fragment3.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        } else {
            lifecycleImpact = null;
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i11 = Math.min(i11, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i11 = Math.max(i11, 3);
        } else {
            Fragment fragment4 = this.mFragment;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i11 = Math.min(i11, 1);
                } else {
                    i11 = Math.min(i11, -1);
                }
            }
        }
        Fragment fragment5 = this.mFragment;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i11 = Math.min(i11, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("computeExpectedState() of ");
            sb2.append(i11);
            sb2.append(" for ");
            sb2.append(this.mFragment);
        }
        return i11;
    }

    public void create() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATED: ");
            sb2.append(this.mFragment);
        }
        Fragment fragment = this.mFragment;
        if (!fragment.mIsCreated) {
            this.mDispatcher.dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.mFragment;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment3 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createView() {
        /*
            r6 = this;
            androidx.fragment.app.Fragment r0 = r6.mFragment
            boolean r0 = r0.mFromLayout
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r0)
            if (r0 == 0) goto L_0x001d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto CREATE_VIEW: "
            r0.append(r1)
            androidx.fragment.app.Fragment r1 = r6.mFragment
            r0.append(r1)
        L_0x001d:
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.os.Bundle r1 = r0.mSavedFragmentState
            android.view.LayoutInflater r0 = r0.performGetLayoutInflater(r1)
            androidx.fragment.app.Fragment r1 = r6.mFragment
            android.view.ViewGroup r2 = r1.mContainer
            if (r2 == 0) goto L_0x002d
            goto L_0x00b7
        L_0x002d:
            int r2 = r1.mContainerId
            if (r2 == 0) goto L_0x00b6
            r3 = -1
            if (r2 == r3) goto L_0x0098
            androidx.fragment.app.FragmentManager r1 = r1.mFragmentManager
            androidx.fragment.app.FragmentContainer r1 = r1.getContainer()
            androidx.fragment.app.Fragment r2 = r6.mFragment
            int r2 = r2.mContainerId
            android.view.View r1 = r1.onFindViewById(r2)
            r2 = r1
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 != 0) goto L_0x008e
            androidx.fragment.app.Fragment r1 = r6.mFragment
            boolean r3 = r1.mRestored
            if (r3 == 0) goto L_0x004e
            goto L_0x00b7
        L_0x004e:
            android.content.res.Resources r0 = r1.getResources()     // Catch:{ NotFoundException -> 0x005b }
            androidx.fragment.app.Fragment r1 = r6.mFragment     // Catch:{ NotFoundException -> 0x005b }
            int r1 = r1.mContainerId     // Catch:{ NotFoundException -> 0x005b }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x005b }
            goto L_0x005d
        L_0x005b:
            java.lang.String r0 = "unknown"
        L_0x005d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            androidx.fragment.app.Fragment r3 = r6.mFragment
            int r3 = r3.mContainerId
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            androidx.fragment.app.Fragment r0 = r6.mFragment
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x008e:
            boolean r1 = r2 instanceof androidx.fragment.app.FragmentContainerView
            if (r1 != 0) goto L_0x00b7
            androidx.fragment.app.Fragment r1 = r6.mFragment
            androidx.fragment.app.strictmode.FragmentStrictMode.onWrongFragmentContainer(r1, r2)
            goto L_0x00b7
        L_0x0098:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r6.mFragment
            r1.append(r2)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00b6:
            r2 = 0
        L_0x00b7:
            androidx.fragment.app.Fragment r1 = r6.mFragment
            r1.mContainer = r2
            android.os.Bundle r3 = r1.mSavedFragmentState
            r1.performCreateView(r0, r2, r3)
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.view.View r0 = r0.mView
            r1 = 2
            if (r0 == 0) goto L_0x0163
            r3 = 0
            r0.setSaveFromParentEnabled(r3)
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.view.View r4 = r0.mView
            int r5 = androidx.fragment.R.id.fragment_container_view_tag
            r4.setTag(r5, r0)
            if (r2 == 0) goto L_0x00d9
            r6.addViewToContainer()
        L_0x00d9:
            androidx.fragment.app.Fragment r0 = r6.mFragment
            boolean r2 = r0.mHidden
            if (r2 == 0) goto L_0x00e6
            android.view.View r0 = r0.mView
            r2 = 8
            r0.setVisibility(r2)
        L_0x00e6:
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.view.View r0 = r0.mView
            boolean r0 = androidx.core.view.ViewCompat.isAttachedToWindow(r0)
            if (r0 == 0) goto L_0x00f8
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.view.View r0 = r0.mView
            androidx.core.view.ViewCompat.requestApplyInsets(r0)
            goto L_0x0104
        L_0x00f8:
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.view.View r0 = r0.mView
            androidx.fragment.app.FragmentStateManager$1 r2 = new androidx.fragment.app.FragmentStateManager$1
            r2.<init>(r0)
            r0.addOnAttachStateChangeListener(r2)
        L_0x0104:
            androidx.fragment.app.Fragment r0 = r6.mFragment
            r0.performViewCreated()
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r0 = r6.mDispatcher
            androidx.fragment.app.Fragment r2 = r6.mFragment
            android.view.View r4 = r2.mView
            android.os.Bundle r5 = r2.mSavedFragmentState
            r0.dispatchOnFragmentViewCreated(r2, r4, r5, r3)
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.view.View r0 = r0.mView
            int r0 = r0.getVisibility()
            androidx.fragment.app.Fragment r2 = r6.mFragment
            android.view.View r2 = r2.mView
            float r2 = r2.getAlpha()
            androidx.fragment.app.Fragment r3 = r6.mFragment
            r3.setPostOnViewCreatedAlpha(r2)
            androidx.fragment.app.Fragment r2 = r6.mFragment
            android.view.ViewGroup r3 = r2.mContainer
            if (r3 == 0) goto L_0x0163
            if (r0 != 0) goto L_0x0163
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            if (r0 == 0) goto L_0x015b
            androidx.fragment.app.Fragment r2 = r6.mFragment
            r2.setFocusedView(r0)
            boolean r2 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r1)
            if (r2 == 0) goto L_0x015b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "requestFocus: Saved focused view "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " for Fragment "
            r2.append(r0)
            androidx.fragment.app.Fragment r0 = r6.mFragment
            r2.append(r0)
        L_0x015b:
            androidx.fragment.app.Fragment r0 = r6.mFragment
            android.view.View r0 = r0.mView
            r2 = 0
            r0.setAlpha(r2)
        L_0x0163:
            androidx.fragment.app.Fragment r0 = r6.mFragment
            r0.mState = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.createView():void");
    }

    public void destroy() {
        boolean z11;
        boolean z12;
        Fragment findActiveFragment;
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATED: ");
            sb2.append(this.mFragment);
        }
        Fragment fragment = this.mFragment;
        boolean z13 = true;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            Fragment fragment2 = this.mFragment;
            if (!fragment2.mBeingSaved) {
                this.mFragmentStore.setSavedState(fragment2.mWho, (FragmentState) null);
            }
        }
        if (z11 || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            FragmentHostCallback<?> fragmentHostCallback = this.mFragment.mHost;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z13 = this.mFragmentStore.getNonConfig().isCleared();
            } else if (fragmentHostCallback.getContext() instanceof Activity) {
                z13 = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
            }
            if ((z11 && !this.mFragment.mBeingSaved) || z13) {
                this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
            }
            this.mFragment.performDestroy();
            this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
            for (FragmentStateManager next : this.mFragmentStore.getActiveFragmentStateManagers()) {
                if (next != null) {
                    Fragment fragment3 = next.getFragment();
                    if (this.mFragment.mWho.equals(fragment3.mTargetWho)) {
                        fragment3.mTarget = this.mFragment;
                        fragment3.mTargetWho = null;
                    }
                }
            }
            Fragment fragment4 = this.mFragment;
            String str = fragment4.mTargetWho;
            if (str != null) {
                fragment4.mTarget = this.mFragmentStore.findActiveFragment(str);
            }
            this.mFragmentStore.makeInactive(this);
            return;
        }
        String str2 = this.mFragment.mTargetWho;
        if (!(str2 == null || (findActiveFragment = this.mFragmentStore.findActiveFragment(str2)) == null || !findActiveFragment.mRetainInstance)) {
            this.mFragment.mTarget = findActiveFragment;
        }
        this.mFragment.mState = 0;
    }

    public void destroyFragmentView() {
        View view;
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATE_VIEW: ");
            sb2.append(this.mFragment);
        }
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        Fragment fragment2 = this.mFragment;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    public void detach() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom ATTACHED: ");
            sb2.append(this.mFragment);
        }
        this.mFragment.performDetach();
        boolean z11 = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z11 = true;
        }
        if (z11 || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("initState called for fragment: ");
                sb3.append(this.mFragment);
            }
            this.mFragment.initState();
        }
    }

    public void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveto CREATE_VIEW: ");
                sb2.append(this.mFragment);
            }
            Fragment fragment2 = this.mFragment;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.mFragment.mSavedFragmentState);
            View view = this.mFragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.mFragment;
                fragment3.mView.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.mFragment;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.mFragment.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                Fragment fragment5 = this.mFragment;
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.mFragment.mState = 2;
            }
        }
    }

    @NonNull
    public Fragment getFragment() {
        return this.mFragment;
    }

    /* JADX INFO: finally extract failed */
    public void moveToExpectedState() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.mMovingToState) {
            try {
                this.mMovingToState = true;
                boolean z11 = false;
                while (true) {
                    int computeExpectedState = computeExpectedState();
                    Fragment fragment = this.mFragment;
                    int i11 = fragment.mState;
                    if (computeExpectedState != i11) {
                        if (computeExpectedState <= i11) {
                            switch (i11 - 1) {
                                case -1:
                                    detach();
                                    break;
                                case 0:
                                    if (fragment.mBeingSaved && this.mFragmentStore.getSavedState(fragment.mWho) == null) {
                                        saveState();
                                    }
                                    destroy();
                                    break;
                                case 1:
                                    destroyFragmentView();
                                    this.mFragment.mState = 1;
                                    break;
                                case 2:
                                    fragment.mInLayout = false;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.isLoggingEnabled(3)) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("movefrom ACTIVITY_CREATED: ");
                                        sb2.append(this.mFragment);
                                    }
                                    Fragment fragment2 = this.mFragment;
                                    if (fragment2.mBeingSaved) {
                                        saveState();
                                    } else if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        saveViewState();
                                    }
                                    Fragment fragment3 = this.mFragment;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        SpecialEffectsController.getOrCreateController(viewGroup2, fragment3.getParentFragmentManager()).enqueueRemove(this);
                                    }
                                    this.mFragment.mState = 3;
                                    break;
                                case 4:
                                    stop();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    pause();
                                    break;
                            }
                        } else {
                            switch (i11 + 1) {
                                case 0:
                                    attach();
                                    break;
                                case 1:
                                    create();
                                    break;
                                case 2:
                                    ensureInflatedView();
                                    createView();
                                    break;
                                case 3:
                                    activityCreated();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        SpecialEffectsController.getOrCreateController(viewGroup3, fragment.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);
                                    }
                                    this.mFragment.mState = 4;
                                    break;
                                case 5:
                                    start();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    resume();
                                    break;
                            }
                        }
                        z11 = true;
                    } else {
                        if (!z11 && i11 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.mFragment.mBeingSaved) {
                            if (FragmentManager.isLoggingEnabled(3)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Cleaning up state of never attached fragment: ");
                                sb3.append(this.mFragment);
                            }
                            this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
                            this.mFragmentStore.makeInactive(this);
                            if (FragmentManager.isLoggingEnabled(3)) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("initState called for fragment: ");
                                sb4.append(this.mFragment);
                            }
                            this.mFragment.initState();
                        }
                        Fragment fragment4 = this.mFragment;
                        if (fragment4.mHiddenChanged) {
                            if (!(fragment4.mView == null || (viewGroup = fragment4.mContainer) == null)) {
                                SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup, fragment4.getParentFragmentManager());
                                if (this.mFragment.mHidden) {
                                    orCreateController.enqueueHide(this);
                                } else {
                                    orCreateController.enqueueShow(this);
                                }
                            }
                            Fragment fragment5 = this.mFragment;
                            FragmentManager fragmentManager = fragment5.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.invalidateMenuForFragment(fragment5);
                            }
                            Fragment fragment6 = this.mFragment;
                            fragment6.mHiddenChanged = false;
                            fragment6.onHiddenChanged(fragment6.mHidden);
                            this.mFragment.mChildFragmentManager.dispatchOnHiddenChanged();
                        }
                        this.mMovingToState = false;
                        return;
                    }
                }
            } catch (Throwable th2) {
                this.mMovingToState = false;
                throw th2;
            }
        } else if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Ignoring re-entrant call to moveToExpectedState() for ");
            sb5.append(getFragment());
        }
    }

    public void pause() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom RESUMED: ");
            sb2.append(this.mFragment);
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    public void restoreState(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.mFragment.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.mFragment;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
            Fragment fragment2 = this.mFragment;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
            Fragment fragment3 = this.mFragment;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString(TARGET_STATE_TAG);
            Fragment fragment4 = this.mFragment;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
            }
            Fragment fragment5 = this.mFragment;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.mFragment.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
            }
            Fragment fragment6 = this.mFragment;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    public void resume() {
        String str;
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESUMED: ");
            sb2.append(this.mFragment);
        }
        View focusedView = this.mFragment.getFocusedView();
        if (focusedView != null && isFragmentViewChild(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("requestFocus: Restoring focused view ");
                sb3.append(focusedView);
                sb3.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = TalabatGTM.FAILED;
                }
                sb3.append(str);
                sb3.append(" on Fragment ");
                sb3.append(this.mFragment);
                sb3.append(" resulting in focused view ");
                sb3.append(this.mFragment.mView.findFocus());
            }
        }
        this.mFragment.setFocusedView((View) null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    @Nullable
    public Fragment.SavedState saveInstanceState() {
        Bundle saveBasicState;
        if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
            return null;
        }
        return new Fragment.SavedState(saveBasicState);
    }

    public void saveState() {
        FragmentState fragmentState = new FragmentState(this.mFragment);
        Fragment fragment = this.mFragment;
        if (fragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
        } else {
            Bundle saveBasicState = saveBasicState();
            fragmentState.mSavedFragmentState = saveBasicState;
            if (this.mFragment.mTargetWho != null) {
                if (saveBasicState == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                int i11 = this.mFragment.mTargetRequestCode;
                if (i11 != 0) {
                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, i11);
                }
            }
        }
        this.mFragmentStore.setSavedState(this.mFragment.mWho, fragmentState);
    }

    public void saveViewState() {
        if (this.mFragment.mView != null) {
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Saving view state for fragment ");
                sb2.append(this.mFragment);
                sb2.append(" with view ");
                sb2.append(this.mFragment.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.mFragment.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.mFragment.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.mFragment.mViewLifecycleOwner.performSave(bundle);
            if (!bundle.isEmpty()) {
                this.mFragment.mSavedViewRegistryState = bundle;
            }
        }
    }

    public void setFragmentManagerState(int i11) {
        this.mFragmentManagerState = i11;
    }

    public void start() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto STARTED: ");
            sb2.append(this.mFragment);
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    public void stop() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom STARTED: ");
            sb2.append(this.mFragment);
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        Fragment instantiate = fragmentState.instantiate(fragmentFactory, classLoader);
        this.mFragment = instantiate;
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Instantiated fragment ");
            sb2.append(instantiate);
        }
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
