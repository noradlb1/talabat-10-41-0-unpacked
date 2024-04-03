package com.facebook.internal.instrument.crashreport;

import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y6.a;
import y6.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "previousHandler", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "uncaughtException", "", "t", "Ljava/lang/Thread;", "e", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_CRASH_REPORT_NUM = 5;
    /* access modifiers changed from: private */
    public static final String TAG = CrashHandler.class.getCanonicalName();
    /* access modifiers changed from: private */
    @Nullable
    public static CrashHandler instance;
    @Nullable
    private final Thread.UncaughtExceptionHandler previousHandler;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler$Companion;", "", "()V", "MAX_CRASH_REPORT_NUM", "", "TAG", "", "kotlin.jvm.PlatformType", "instance", "Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "enable", "", "sendExceptionReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void sendExceptionReports() {
            if (!Utility.isDataProcessingRestricted()) {
                File[] listExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
                ArrayList arrayList = new ArrayList(listExceptionReportFiles.length);
                for (File load : listExceptionReportFiles) {
                    arrayList.add(InstrumentData.Builder.load(load));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object next : arrayList) {
                    if (((InstrumentData) next).isValid()) {
                        arrayList2.add(next);
                    }
                }
                List sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new a());
                JSONArray jSONArray = new JSONArray();
                Iterator it = RangesKt___RangesKt.until(0, Math.min(sortedWith.size(), 5)).iterator();
                while (it.hasNext()) {
                    jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
                }
                InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                InstrumentUtility.sendReports("crash_reports", jSONArray, new b(sortedWith));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: sendExceptionReports$lambda-2  reason: not valid java name */
        public static final int m8980sendExceptionReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
            Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        }

        /* access modifiers changed from: private */
        /* renamed from: sendExceptionReports$lambda-5  reason: not valid java name */
        public static final void m8981sendExceptionReports$lambda5(List list, GraphResponse graphResponse) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(list, "$validReports");
            Intrinsics.checkNotNullParameter(graphResponse, "response");
            try {
                if (graphResponse.getError() == null) {
                    JSONObject jsonObject = graphResponse.getJsonObject();
                    if (jsonObject == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(jsonObject.getBoolean("success"));
                    }
                    if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((InstrumentData) it.next()).clear();
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        @JvmStatic
        public final synchronized void enable() {
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                sendExceptionReports();
            }
            if (CrashHandler.instance != null) {
                Log.w(CrashHandler.TAG, "Already enabled!");
                return;
            }
            CrashHandler.instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), (DefaultConstructorMarker) null);
            Thread.setDefaultUncaughtExceptionHandler(CrashHandler.instance);
        }
    }

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.previousHandler = uncaughtExceptionHandler;
    }

    public /* synthetic */ CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(uncaughtExceptionHandler);
    }

    @JvmStatic
    public static final synchronized void enable() {
        synchronized (CrashHandler.class) {
            Companion.enable();
        }
    }

    public void uncaughtException(@NotNull Thread thread, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(thread, "t");
        Intrinsics.checkNotNullParameter(th2, "e");
        if (InstrumentUtility.isSDKRelatedException(th2)) {
            ExceptionAnalyzer.execute(th2);
            InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
            InstrumentData.Builder.build(th2, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }
}
