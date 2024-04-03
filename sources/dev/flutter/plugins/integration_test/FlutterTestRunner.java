package dev.flutter.plugins.integration_test;

import android.content.Intent;
import androidx.test.rule.ActivityTestRule;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class FlutterTestRunner extends Runner {
    private static final String TAG = "FlutterTestRunner";

    /* renamed from: a  reason: collision with root package name */
    public final Class f13885a;

    /* renamed from: b  reason: collision with root package name */
    public TestRule f13886b = null;

    public FlutterTestRunner(Class<?> cls) {
        this.f13885a = cls;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Rule.class)) {
                try {
                    Object newInstance = cls.newInstance();
                    if (field.get(newInstance) instanceof ActivityTestRule) {
                        this.f13886b = (TestRule) field.get(newInstance);
                        return;
                    }
                } catch (IllegalAccessException | InstantiationException e11) {
                    throw new RuntimeException("Unable to access activity rule", e11);
                }
            }
        }
    }

    public Description getDescription() {
        return Description.createTestDescription(this.f13885a, "Flutter Tests");
    }

    public void run(RunNotifier runNotifier) {
        ActivityTestRule activityTestRule = this.f13886b;
        if (activityTestRule != null) {
            try {
                if (activityTestRule instanceof ActivityTestRule) {
                    activityTestRule.launchActivity((Intent) null);
                }
            } catch (RuntimeException e11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("launchActivity failed, possibly because the activity was already running. ");
                sb2.append(e11);
            }
            try {
                Map map = IntegrationTestPlugin.testResults.get();
                for (String str : map.keySet()) {
                    Description createTestDescription = Description.createTestDescription(this.f13885a, str);
                    runNotifier.fireTestStarted(createTestDescription);
                    String str2 = (String) map.get(str);
                    if (!str2.equals("success")) {
                        runNotifier.fireTestFailure(new Failure(createTestDescription, new Exception(str2)));
                    }
                    runNotifier.fireTestFinished(createTestDescription);
                }
            } catch (InterruptedException | ExecutionException unused) {
                throw new IllegalThreadStateException("Unable to get test results");
            }
        } else {
            throw new RuntimeException("Unable to run tests due to missing activity rule");
        }
    }
}
