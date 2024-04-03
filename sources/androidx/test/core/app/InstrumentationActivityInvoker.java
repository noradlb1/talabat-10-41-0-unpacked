package androidx.test.core.app;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.test.internal.platform.app.ActivityInvoker;
import androidx.test.internal.platform.app.ActivityInvoker$$CC;
import androidx.test.internal.platform.app.ActivityLifecycleTimeout;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class InstrumentationActivityInvoker implements ActivityInvoker {
    private static final String BOOTSTRAP_ACTIVITY_RESULT_CODE_KEY = "androidx.test.core.app.InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_CODE_KEY";
    private static final String BOOTSTRAP_ACTIVITY_RESULT_DATA_KEY = "androidx.test.core.app.InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_DATA_KEY";
    private static final String BOOTSTRAP_ACTIVITY_RESULT_RECEIVED = "androidx.test.core.app.InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_RECEIVED";
    private static final String CANCEL_ACTIVITY_RESULT_WAITER = "androidx.test.core.app.InstrumentationActivityInvoker.CANCEL_ACTIVITY_RESULT_WAITER";
    private static final String EMPTY_ACTIVITY_RESUMED = "androidx.test.core.app.InstrumentationActivityInvoker.EMPTY_ACTIVITY_RESUMED";
    private static final String EMPTY_FLOATING_ACTIVITY_RESUMED = "androidx.test.core.app.InstrumentationActivityInvoker.EMPTY_FLOATING_ACTIVITY_RESUMED";
    private static final String FINISH_BOOTSTRAP_ACTIVITY = "androidx.test.core.app.InstrumentationActivityInvoker.FINISH_BOOTSTRAP_ACTIVITY";
    private static final String FINISH_EMPTY_ACTIVITIES = "androidx.test.core.app.InstrumentationActivityInvoker.FINISH_EMPTY_ACTIVITIES";
    private static final int FLAG_MUTABLE = 33554432;
    private static final String TARGET_ACTIVITY_INTENT_KEY = "androidx.test.core.app.InstrumentationActivityInvoker.START_TARGET_ACTIVITY_INTENT_KEY";
    private static final String TARGET_ACTIVITY_OPTIONS_BUNDLE_KEY = "androidx.test.core.app.InstrumentationActivityInvoker.TARGET_ACTIVITY_OPTIONS_BUNDLE_KEY";
    @Nullable
    private ActivityResultWaiter activityResultWaiter;

    public static class ActivityResultWaiter {
        private static final String TAG = "androidx.test.core.app.InstrumentationActivityInvoker$ActivityResultWaiter";
        /* access modifiers changed from: private */
        @Nullable
        public Instrumentation.ActivityResult activityResult;
        /* access modifiers changed from: private */
        public final CountDownLatch latch = new CountDownLatch(1);

        public ActivityResultWaiter(Context context) {
            AnonymousClass1 r02 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    context.unregisterReceiver(this);
                    if (InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_RECEIVED.equals(intent.getAction())) {
                        int intExtra = intent.getIntExtra(InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_CODE_KEY, 0);
                        Intent intent2 = (Intent) intent.getParcelableExtra(InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_DATA_KEY);
                        if (intent2 != null) {
                            intent2 = new Intent(intent2);
                        }
                        Instrumentation.ActivityResult unused = ActivityResultWaiter.this.activityResult = new Instrumentation.ActivityResult(intExtra, intent2);
                        ActivityResultWaiter.this.latch.countDown();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter(InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_RECEIVED);
            intentFilter.addAction(InstrumentationActivityInvoker.CANCEL_ACTIVITY_RESULT_WAITER);
            context.registerReceiver(r02, intentFilter);
        }

        public Instrumentation.ActivityResult getActivityResult() {
            try {
                this.latch.await(ActivityLifecycleTimeout.getMillis(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e11) {
                Log.i(TAG, "Waiting activity result was interrupted", e11);
            }
            Checks.checkNotNull(this.activityResult, "onActivityResult never be called after %d milliseconds", Long.valueOf(ActivityLifecycleTimeout.getMillis()));
            return this.activityResult;
        }
    }

    public static class BootstrapActivity extends Activity {
        private static final String IS_TARGET_ACTIVITY_STARTED_KEY = "IS_TARGET_ACTIVITY_STARTED_KEY";
        private static final String TAG = "androidx.test.core.app.InstrumentationActivityInvoker$BootstrapActivity";
        private boolean isTargetActivityStarted;
        private final BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                BootstrapActivity.this.finishActivity(0);
                BootstrapActivity.this.finish();
            }
        };

        public void finish() {
            super.finish();
            overridePendingTransition(0, 0);
        }

        public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
            if (i11 == 0) {
                Intent intent2 = new Intent(InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_RECEIVED);
                intent2.putExtra(InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_CODE_KEY, i12);
                if (intent != null) {
                    intent2.putExtra(InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_DATA_KEY, intent);
                }
                sendBroadcast(intent2);
                finish();
            }
        }

        public void onCreate(@Nullable Bundle bundle) {
            boolean z11;
            super.onCreate(bundle);
            registerReceiver(this.receiver, new IntentFilter(InstrumentationActivityInvoker.FINISH_BOOTSTRAP_ACTIVITY));
            if (bundle == null || !bundle.getBoolean(IS_TARGET_ACTIVITY_STARTED_KEY, false)) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.isTargetActivityStarted = z11;
            overridePendingTransition(0, 0);
        }

        public void onDestroy() {
            super.onDestroy();
            unregisterReceiver(this.receiver);
        }

        public void onResume() {
            super.onResume();
            if (!this.isTargetActivityStarted) {
                this.isTargetActivityStarted = true;
                PendingIntent pendingIntent = (PendingIntent) Checks.checkNotNull((PendingIntent) getIntent().getParcelableExtra(InstrumentationActivityInvoker.TARGET_ACTIVITY_INTENT_KEY));
                Bundle bundleExtra = getIntent().getBundleExtra(InstrumentationActivityInvoker.TARGET_ACTIVITY_OPTIONS_BUNDLE_KEY);
                if (bundleExtra != null) {
                    try {
                        startIntentSenderForResult(pendingIntent.getIntentSender(), 0, (Intent) null, 268435456, 0, 0, bundleExtra);
                    } catch (IntentSender.SendIntentException e11) {
                        Log.e(TAG, "Failed to start target activity.", e11);
                        throw new RuntimeException(e11);
                    }
                } else {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 0, (Intent) null, 268435456, 0, 0);
                }
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(IS_TARGET_ACTIVITY_STARTED_KEY, this.isTargetActivityStarted);
        }
    }

    public static class EmptyActivity extends Activity {
        private final BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                EmptyActivity.this.finish();
            }
        };

        public void finish() {
            super.finish();
            overridePendingTransition(0, 0);
        }

        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            registerReceiver(this.receiver, new IntentFilter(InstrumentationActivityInvoker.FINISH_EMPTY_ACTIVITIES));
            overridePendingTransition(0, 0);
        }

        public void onDestroy() {
            super.onDestroy();
            unregisterReceiver(this.receiver);
        }

        public void onResume() {
            super.onResume();
            sendBroadcast(new Intent(InstrumentationActivityInvoker.EMPTY_ACTIVITY_RESUMED));
        }
    }

    public static class EmptyFloatingActivity extends Activity {
        private final BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                EmptyFloatingActivity.this.finish();
            }
        };

        public void finish() {
            super.finish();
            overridePendingTransition(0, 0);
        }

        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            registerReceiver(this.receiver, new IntentFilter(InstrumentationActivityInvoker.FINISH_EMPTY_ACTIVITIES));
            overridePendingTransition(0, 0);
        }

        public void onDestroy() {
            super.onDestroy();
            unregisterReceiver(this.receiver);
        }

        public void onResume() {
            super.onResume();
            sendBroadcast(new Intent(InstrumentationActivityInvoker.EMPTY_FLOATING_ACTIVITY_RESUMED));
        }
    }

    public static final /* synthetic */ void a(Activity activity, Set set) {
        Stage lifecycleStageOf = ActivityLifecycleMonitorRegistry.getInstance().getLifecycleStageOf(activity);
        Checks.checkState(set.contains(lifecycleStageOf), "Activity's stage must be %s but was %s", set, lifecycleStageOf);
    }

    private static void checkActivityStageIsIn(Activity activity, Stage... stageArr) {
        checkActivityStageIsIn(activity, (Set<Stage>) new HashSet(Arrays.asList(stageArr)));
    }

    private void startEmptyActivitySync() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AnonymousClass2 r12 = new BroadcastReceiver(this) {
            public void onReceive(Context context, Intent intent) {
                countDownLatch.countDown();
            }
        };
        ApplicationProvider.getApplicationContext().registerReceiver(r12, new IntentFilter(EMPTY_ACTIVITY_RESUMED));
        ApplicationProvider.getApplicationContext().startActivity(getIntentForActivity(EmptyActivity.class).setFlags(268435456));
        try {
            countDownLatch.await(ActivityLifecycleTimeout.getMillis(), TimeUnit.MILLISECONDS);
            ApplicationProvider.getApplicationContext().unregisterReceiver(r12);
        } catch (InterruptedException e11) {
            throw new AssertionError("Failed to stop activity", e11);
        } catch (Throwable th2) {
            ApplicationProvider.getApplicationContext().unregisterReceiver(r12);
            throw th2;
        }
    }

    private void startFloatingEmptyActivitySync() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AnonymousClass1 r12 = new BroadcastReceiver(this) {
            public void onReceive(Context context, Intent intent) {
                countDownLatch.countDown();
            }
        };
        ApplicationProvider.getApplicationContext().registerReceiver(r12, new IntentFilter(EMPTY_FLOATING_ACTIVITY_RESUMED));
        ApplicationProvider.getApplicationContext().startActivity(getIntentForActivity(EmptyFloatingActivity.class).setFlags(268435456));
        try {
            countDownLatch.await(ActivityLifecycleTimeout.getMillis(), TimeUnit.MILLISECONDS);
            ApplicationProvider.getApplicationContext().unregisterReceiver(r12);
        } catch (InterruptedException e11) {
            throw new AssertionError("Failed to pause activity", e11);
        } catch (Throwable th2) {
            ApplicationProvider.getApplicationContext().unregisterReceiver(r12);
            throw th2;
        }
    }

    public void finishActivity(Activity activity) {
        startEmptyActivitySync();
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        activity.getClass();
        instrumentation.runOnMainSync(InstrumentationActivityInvoker$$Lambda$1.a(activity));
        ApplicationProvider.getApplicationContext().sendBroadcast(new Intent(FINISH_BOOTSTRAP_ACTIVITY));
        startEmptyActivitySync();
        InstrumentationRegistry.getInstrumentation().runOnMainSync(InstrumentationActivityInvoker$$Lambda$2.a(activity));
        ApplicationProvider.getApplicationContext().sendBroadcast(new Intent(FINISH_EMPTY_ACTIVITIES));
        ApplicationProvider.getApplicationContext().sendBroadcast(new Intent(CANCEL_ACTIVITY_RESULT_WAITER));
    }

    public Instrumentation.ActivityResult getActivityResult() {
        return ((ActivityResultWaiter) Checks.checkNotNull(this.activityResultWaiter, "You must start Activity first")).getActivityResult();
    }

    public Intent getIntentForActivity(Class cls) {
        return ActivityInvoker$$CC.getIntentForActivity$$dflt$$(this, cls);
    }

    public void pauseActivity(Activity activity) {
        checkActivityStageIsIn(activity, Stage.RESUMED, Stage.PAUSED);
        startFloatingEmptyActivitySync();
    }

    public void recreateActivity(Activity activity) {
        checkActivityStageIsIn(activity, Stage.RESUMED, Stage.PAUSED, Stage.STOPPED);
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        activity.getClass();
        instrumentation.runOnMainSync(InstrumentationActivityInvoker$$Lambda$0.a(activity));
    }

    public void resumeActivity(Activity activity) {
        checkActivityStageIsIn(activity, Stage.RESUMED, Stage.PAUSED, Stage.STOPPED);
        ApplicationProvider.getApplicationContext().sendBroadcast(new Intent(FINISH_EMPTY_ACTIVITIES));
    }

    public void startActivity(Intent intent, @Nullable Bundle bundle) {
        if (intent.resolveActivityInfo(ApplicationProvider.getApplicationContext().getPackageManager(), 0) != null) {
            ApplicationProvider.getApplicationContext().sendBroadcast(new Intent(FINISH_BOOTSTRAP_ACTIVITY));
            ApplicationProvider.getApplicationContext().sendBroadcast(new Intent(FINISH_EMPTY_ACTIVITIES));
            this.activityResultWaiter = new ActivityResultWaiter(ApplicationProvider.getApplicationContext());
            ApplicationProvider.getApplicationContext().startActivity(getIntentForActivity(BootstrapActivity.class).setFlags(268468224).putExtra(TARGET_ACTIVITY_INTENT_KEY, PendingIntent.getActivity(ApplicationProvider.getApplicationContext(), 0, intent, 167772160)).putExtra(TARGET_ACTIVITY_OPTIONS_BUNDLE_KEY, bundle), bundle);
            return;
        }
        String valueOf = String.valueOf(intent);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
        sb2.append("Unable to resolve activity for: ");
        sb2.append(valueOf);
        throw new RuntimeException(sb2.toString());
    }

    public void stopActivity(Activity activity) {
        checkActivityStageIsIn(activity, Stage.RESUMED, Stage.PAUSED, Stage.STOPPED);
        startEmptyActivitySync();
    }

    private static void checkActivityStageIsIn(Activity activity, Set<Stage> set) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new InstrumentationActivityInvoker$$Lambda$3(activity, set));
    }

    public void startActivity(Intent intent) {
        startActivity(intent, (Bundle) null);
    }
}
