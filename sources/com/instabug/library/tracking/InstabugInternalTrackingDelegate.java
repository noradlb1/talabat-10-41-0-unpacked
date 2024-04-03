package com.instabug.library.tracking;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.instabug.library.Feature;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.CurrentFragmentLifeCycleEventBus;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.a;
import com.instabug.library.e0;
import com.instabug.library.model.StepType;
import com.instabug.library.sessionV3.manager.l;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.y;
import java.lang.ref.WeakReference;

public class InstabugInternalTrackingDelegate {
    private static final String FRAGMENT_NAV_HOST_NAME = "androidx.navigation.fragment.NavHostFragment";
    private static volatile InstabugInternalTrackingDelegate INSTANCE;
    private final g activityLifecycleListener;
    @Nullable
    private WeakReference<Activity> currentActivity;
    private final a currentActivityMonitor;
    @Nullable
    private WeakReference<Activity> currentRealActivity;
    private boolean isRegistered = false;
    @Nullable
    private WeakReference<Fragment> lastResumedFragment;
    private final p navigableViewsTrackingDelegate;
    private int startedActivitiesNumber = 0;

    private InstabugInternalTrackingDelegate(@NonNull Application application) {
        a aVar = new a();
        this.currentActivityMonitor = aVar;
        this.activityLifecycleListener = new g();
        aVar.a(application);
        registerLifecycleListeners(application);
        this.navigableViewsTrackingDelegate = new p();
    }

    public static InstabugInternalTrackingDelegate getInstance() {
        return INSTANCE;
    }

    public static void init(@NonNull Application application) {
        if (INSTANCE == null) {
            INSTANCE = new InstabugInternalTrackingDelegate(application);
        }
    }

    private boolean isNavHostFragment(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return FRAGMENT_NAV_HOST_NAME.equals(fragment.getClass().getName());
    }

    private boolean isNotInstabugActivity(Activity activity) {
        return !(activity instanceof _InstabugActivity);
    }

    private boolean isReproStepsEnable() {
        if (e0.c().b((Object) Feature.REPRO_STEPS) != Feature.State.ENABLED || !InstabugStateProvider.getInstance().getState().equals(InstabugState.ENABLED)) {
            return false;
        }
        return true;
    }

    private boolean isUserTrackingStepsEnable() {
        if (e0.c().b((Object) Feature.TRACK_USER_STEPS) != Feature.State.ENABLED || !InstabugStateProvider.getInstance().getState().equals(InstabugState.ENABLED)) {
            return false;
        }
        return true;
    }

    private void registerWindowCallbacksIfNeeded(Activity activity) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof o)) {
                InstabugSDKLogger.d("IBG-Core", "restore original window callback");
                activity.getWindow().setCallback(new o(callback));
            }
        }
    }

    public void a(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                InstabugSDKLogger.v("IBG-Core", activity.getClass().getSimpleName() + " created");
                n.a().a(activity.getClass().getName(), StepType.ACTIVITY_CREATED);
            }
            if (isReproStepsEnable() && SettingsManager.getInstance().getCurrentPlatform() == 2) {
                y.d().b(StepType.ACTIVITY_CREATED, activity.getClass().getSimpleName(), activity.getClass().getName(), (String) null);
            }
            CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.CREATED);
        }
    }

    public void b(Activity activity) {
        WeakReference<Activity> weakReference;
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                InstabugSDKLogger.v("IBG-Core", activity.getClass().getSimpleName() + " destroyed");
                n.a().a(activity.getClass().getName(), StepType.ACTIVITY_DESTROYED);
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.ACTIVITY_DESTROYED, activity.getClass().getSimpleName(), activity.getClass().getName(), (String) null);
            }
            if (!(activity == null || (weakReference = this.currentActivity) == null || weakReference.get() == null || activity != this.currentActivity.get())) {
                this.currentActivity.clear();
            }
            CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.DESTROYED);
        }
    }

    public void c(Activity activity) {
        Activity activity2;
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (isNotInstabugActivity(activity)) {
            if (activity2 == null) {
                InstabugSDKLogger.w("IBG-Core", "No activity was set earlier than this call. Doing nothing");
                return;
            } else if (!activity.equals(activity2)) {
                InstabugSDKLogger.w("IBG-Core", "You're trying to pause an activity that is not the current activity! Please make sure you're calling onCurrentActivityPaused and onCurrentActivityResumed on every activity");
                return;
            } else {
                if (isUserTrackingStepsEnable()) {
                    InstabugSDKLogger.v("IBG-Core", activity.getClass().getSimpleName() + " paused");
                    n.a().a(activity.getClass().getName(), StepType.ACTIVITY_PAUSED);
                }
                if (isReproStepsEnable()) {
                    y.d().b(StepType.ACTIVITY_PAUSED, activity.getClass().getSimpleName(), activity.getClass().getName(), (String) null);
                }
                CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.PAUSED);
            }
        }
        this.navigableViewsTrackingDelegate.b(activity);
    }

    public void d(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                InstabugSDKLogger.v("IBG-Core", activity.getClass().getSimpleName() + " resumed");
                n.a().a(activity.getClass().getName(), StepType.ACTIVITY_RESUMED);
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.ACTIVITY_RESUMED, activity.getClass().getSimpleName(), activity.getClass().getName(), (String) null);
                this.navigableViewsTrackingDelegate.d(activity);
            }
            CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.RESUMED);
            registerWindowCallbacksIfNeeded(activity);
            b.c().b(activity.getClass().getName());
        }
    }

    public void e(Activity activity) {
        this.startedActivitiesNumber++;
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                InstabugSDKLogger.v("IBG-Core", activity.getClass().getSimpleName() + " started");
                n.a().a(activity.getClass().getName(), StepType.ACTIVITY_STARTED);
            }
            if (isReproStepsEnable() && SettingsManager.getInstance().getCurrentPlatform() == 2) {
                y.d().b(StepType.ACTIVITY_STARTED, activity.getClass().getSimpleName(), activity.getClass().getName(), (String) null);
            }
        }
        CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.STARTED);
    }

    public void f(Activity activity) {
        this.startedActivitiesNumber--;
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                InstabugSDKLogger.v("IBG-Core", activity.getClass().getSimpleName() + " stopped");
                n.a().a(activity.getClass().getName(), StepType.ACTIVITY_STOPPED);
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.ACTIVITY_STOPPED, activity.getClass().getSimpleName(), activity.getClass().getName(), (String) null);
            }
        }
        CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.STOPPED);
    }

    public void g(Configuration configuration) {
        if (getTargetActivity() != null) {
            a a11 = a.a();
            a11.a(configuration);
            a.a().post(a11);
        }
    }

    @Nullable
    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Nullable
    public Activity getCurrentRealActivity() {
        WeakReference<Activity> weakReference = this.currentRealActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Nullable
    public Object getLastSeenView() {
        WeakReference<Fragment> weakReference = this.lastResumedFragment;
        if (weakReference == null || weakReference.get() == null) {
            return getTargetActivity();
        }
        return this.lastResumedFragment.get();
    }

    public int getStartedActivitiesNumber() {
        return this.startedActivitiesNumber;
    }

    @Nullable
    public Activity getTargetActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null && activity.getParent() != null) {
            Activity parent = activity.getParent();
            while (parent.getParent() != null) {
                parent = parent.getParent();
            }
            return parent;
        } else if (activity != null) {
            return activity;
        } else {
            return null;
        }
    }

    public void h(Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            WeakReference<Activity> weakReference = this.currentActivity;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n.a().a(fragment.getClass().getName(), activity.getClass().getName(), StepType.FRAGMENT_ATTACHED);
                }
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.FRAGMENT_ATTACHED, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
            }
            CurrentFragmentLifeCycleEventBus.getInstance().post(FragmentLifeCycleEvent.ATTACHED);
        }
    }

    public void i(Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            WeakReference<Activity> weakReference = this.currentActivity;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n.a().a(fragment.getClass().getName(), activity.getClass().getName(), StepType.FRAGMENT_DETACHED);
                }
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.FRAGMENT_DETACHED, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
            }
            this.navigableViewsTrackingDelegate.c(fragment);
            CurrentFragmentLifeCycleEventBus.getInstance().post(FragmentLifeCycleEvent.DETACHED);
        }
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void j(Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            this.lastResumedFragment = null;
            WeakReference<Activity> weakReference = this.currentActivity;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n.a().a(fragment.getClass().getName(), activity.getClass().getName(), StepType.FRAGMENT_PAUSED);
                }
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.FRAGMENT_PAUSED, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
            }
            CurrentFragmentLifeCycleEventBus.getInstance().post(FragmentLifeCycleEvent.PAUSED);
        }
    }

    public void k(Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            this.lastResumedFragment = new WeakReference<>(fragment);
            WeakReference<Activity> weakReference = this.currentActivity;
            String str = StepType.FRAGMENT_RESUMED;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n.a().a(fragment.getClass().getName(), activity.getClass().getName(), str);
                }
            }
            if (isReproStepsEnable() && fragment.getUserVisibleHint()) {
                y d11 = y.d();
                if (fragment instanceof DialogFragment) {
                    str = StepType.DIALOG_FRAGMENT_RESUMED;
                }
                d11.b(str, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
            }
            if (fragment.getActivity() != null) {
                registerWindowCallbacksIfNeeded(fragment.getActivity());
            }
            CurrentFragmentLifeCycleEventBus.getInstance().post(FragmentLifeCycleEvent.RESUMED);
            b.c().c(fragment.getClass().getName());
        }
    }

    public void l(Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            WeakReference<Activity> weakReference = this.currentActivity;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n.a().a(fragment.getClass().getName(), activity.getClass().getName(), StepType.FRAGMENT_STARTED);
                }
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.FRAGMENT_STARTED, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
            }
            CurrentFragmentLifeCycleEventBus.getInstance().post(FragmentLifeCycleEvent.STARTED);
        }
    }

    public void m(Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            WeakReference<Activity> weakReference = this.currentActivity;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n.a().a(fragment.getClass().getName(), activity.getClass().getName(), StepType.FRAGMENT_STOPPED);
                }
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.FRAGMENT_STOPPED, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
            }
            CurrentFragmentLifeCycleEventBus.getInstance().post(FragmentLifeCycleEvent.STOPPED);
        }
    }

    public void n(Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            WeakReference<Activity> weakReference = this.currentActivity;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n.a().a(fragment.getClass().getName(), activity.getClass().getName(), StepType.FRAGMENT_VIEW_CREATED);
                }
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.FRAGMENT_VIEW_CREATED, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
                this.navigableViewsTrackingDelegate.e(fragment);
            }
            CurrentFragmentLifeCycleEventBus.getInstance().post(FragmentLifeCycleEvent.VIEW_CREATED);
        }
    }

    public void o(MotionEvent motionEvent) {
        k.a().b(motionEvent);
    }

    public void onApplicationCreated(Application application) {
        if (isUserTrackingStepsEnable()) {
            InstabugSDKLogger.v("IBG-Core", application.getClass().getSimpleName() + " created");
            n.a().a(application.getClass().getName(), StepType.APPLICATION_CREATED);
        }
    }

    public void onFragmentVisibilityChanged(boolean z11, Fragment fragment) {
        if (fragment != null && !isNavHostFragment(fragment)) {
            WeakReference<Activity> weakReference = this.currentActivity;
            if (!(weakReference == null || weakReference.get() == null)) {
                Activity activity = this.currentActivity.get();
                if (isUserTrackingStepsEnable()) {
                    n a11 = n.a();
                    String name2 = fragment.getClass().getName();
                    String name3 = activity.getClass().getName();
                    a11.a(name2, name3, "Fragment visibility: " + z11, StepType.FRAGMENT_VISIBILITY_CHANGED);
                }
            }
            if (isReproStepsEnable()) {
                y.d().b(StepType.FRAGMENT_VISIBILITY_CHANGED, fragment.getClass().getSimpleName(), fragment.getClass().getName(), (String) null);
            }
        }
    }

    public void registerLifecycleListeners(Application application) {
        InstabugSDKLogger.d("IBG-Core", "Registering activity lifecycle listener");
        application.registerActivityLifecycleCallbacks(this.activityLifecycleListener);
        application.registerComponentCallbacks(this.activityLifecycleListener);
        l.f51814a.a(application);
        this.isRegistered = true;
    }

    public void setCurrentActivity(Activity activity) {
        this.currentRealActivity = new WeakReference<>(activity);
        if (isNotInstabugActivity(activity)) {
            this.currentActivity = new WeakReference<>(activity);
        }
    }

    public void unregisterLifecycleListeners(Application application) {
        InstabugSDKLogger.d("IBG-Core", "Unregistering activity lifecycle listener");
        application.unregisterActivityLifecycleCallbacks(this.activityLifecycleListener);
        application.unregisterComponentCallbacks(this.activityLifecycleListener);
        l.f51814a.b(application);
        this.isRegistered = false;
    }
}
