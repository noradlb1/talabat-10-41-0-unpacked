package com.instabug.survey;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.Feature;
import com.instabug.library.OnUsageExceededReady;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.callbacks.OnDismissCallback;
import com.instabug.survey.callbacks.OnFinishCallback;
import com.instabug.survey.callbacks.OnShowCallback;
import java.util.List;

public class Surveys {

    public class a implements VoidRunnable {
        public void run() {
            com.instabug.survey.settings.c.a();
        }
    }

    public class b implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f52210a;

        public b(boolean z11) {
            this.f52210a = z11;
        }

        public void run() {
            com.instabug.survey.settings.c.b(this.f52210a);
        }
    }

    public class c implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnFinishCallback f52211a;

        public c(OnFinishCallback onFinishCallback) {
            this.f52211a = onFinishCallback;
        }

        public void run() {
            com.instabug.survey.settings.c.a(this.f52211a);
        }
    }

    public class d implements ReturnableRunnable {
        @Nullable
        /* renamed from: a */
        public Boolean run() {
            InstabugSDKLogger.d("IBG-Surveys", "showSurveyIfAvailable");
            return Boolean.valueOf(h.e() != null && h.e().u());
        }
    }

    public class e implements ReturnableRunnable {
        @Nullable
        /* renamed from: a */
        public List run() {
            InstabugSDKLogger.d("IBG-Surveys", "getAvailableSurveys");
            if (h.e() == null || !com.instabug.survey.utils.j.d() || !com.instabug.survey.di.a.b().a()) {
                return null;
            }
            return h.e().k();
        }
    }

    public class f implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f52212a;

        public f(boolean z11) {
            this.f52212a = z11;
        }

        public void run() {
            InstabugSDKLogger.d("IBG-Surveys", "setAutoShowingEnabled:" + this.f52212a);
            com.instabug.survey.settings.c.d(this.f52212a);
        }
    }

    public class g implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnShowCallback f52213a;

        public g(OnShowCallback onShowCallback) {
            this.f52213a = onShowCallback;
        }

        public void run() {
            com.instabug.survey.settings.c.a(this.f52213a);
        }
    }

    public class h implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnDismissCallback f52214a;

        public h(OnDismissCallback onDismissCallback) {
            this.f52214a = onDismissCallback;
        }

        public void run() {
            com.instabug.survey.settings.c.a(this.f52214a);
        }
    }

    public class i implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52215a;

        public i(String str) {
            this.f52215a = str;
        }

        /* renamed from: a */
        public Boolean run() {
            String str = this.f52215a;
            if (str == null || str.equals("null")) {
                InstabugSDKLogger.e("IBG-Surveys", "Survey token was null");
                return Boolean.FALSE;
            }
            return Boolean.valueOf(h.e() != null && h.e().q(this.f52215a));
        }
    }

    public class j implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52216a;

        public j(String str) {
            this.f52216a = str;
        }

        /* renamed from: a */
        public Boolean run() {
            String str = this.f52216a;
            if (str == null || str.equals("null")) {
                InstabugSDKLogger.e("IBG-Surveys", "Survey token was null");
                return Boolean.FALSE;
            }
            return Boolean.valueOf(h.e() != null && h.e().o(this.f52216a));
        }
    }

    public class k implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f52217a;

        public k(boolean z11) {
            this.f52217a = z11;
        }

        public void run() {
            com.instabug.survey.settings.c.c(this.f52217a);
        }
    }

    public class l implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f52218a;

        public l(Feature.State state) {
            this.f52218a = state;
        }

        public void run() {
            InstabugCore.setFeatureState(Feature.SURVEYS, this.f52218a);
            InstabugCore.setFeatureState(Feature.ANNOUNCEMENTS, this.f52218a);
        }
    }

    private static void enableCustomization() {
        APIChecker.checkAndRunInExecutor("Surveys.enableCustomization", new a());
    }

    @WorkerThread
    @Nullable
    public static List<Survey> getAvailableSurveys() {
        return (List) APIChecker.checkAndGet("Surveys.getAvailableSurveys", new e(), null);
    }

    public static void getUsageExceeded(@NonNull OnUsageExceededReady onUsageExceededReady) {
        try {
            APIChecker.checkAndRunOrThrow("Surveys.getUsageExceeded", new sd.h(onUsageExceededReady));
        } catch (Exception unused) {
            if (onUsageExceededReady != null) {
                onUsageExceededReady.onReady(false);
            }
        }
    }

    @WorkerThread
    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public static boolean hasRespondToSurvey(@NonNull String str) {
        return ((Boolean) APIChecker.checkAndGet("Surveys.hasRespondToSurvey", new j(str), Boolean.FALSE)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getUsageExceeded$0(OnUsageExceededReady onUsageExceededReady, boolean z11) {
        if (onUsageExceededReady != null) {
            onUsageExceededReady.onReady(z11);
        }
    }

    public static void setAutoShowingEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("Surveys.setAutoShowingEnabled", new f(z11));
    }

    public static void setIsAppStoreRatingEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("Surveys.setIsAppStoreRatingEnabled", new b(z11));
    }

    public static void setOnDismissCallback(OnDismissCallback onDismissCallback) {
        APIChecker.checkAndRunInExecutorThenPostOnMain("Surveys.setOnDismissCallback", new h(onDismissCallback));
    }

    public static void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        APIChecker.checkAndRun("Surveys.setOnFinishCallback", new c(onFinishCallback));
    }

    public static void setOnShowCallback(OnShowCallback onShowCallback) {
        APIChecker.checkAndRunInExecutorThenPostOnMain("Surveys.setOnShowCallback", new g(onShowCallback));
    }

    public static void setShouldShowWelcomeScreen(boolean z11) {
        APIChecker.checkAndRunInExecutor("Surveys.setShouldShowWelcomeScreen", new k(z11));
    }

    public static void setState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("Surveys.setState", new l(state));
    }

    @WorkerThread
    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public static boolean showSurvey(@NonNull String str) {
        return ((Boolean) APIChecker.checkAndGet("Surveys.showSurvey", new i(str), Boolean.FALSE)).booleanValue();
    }

    @WorkerThread
    public static boolean showSurveyIfAvailable() {
        Boolean bool = (Boolean) APIChecker.checkAndGet("Surveys.showSurveyIfAvailable", new d(), Boolean.FALSE);
        return bool != null && bool.booleanValue();
    }
}
