package com.facebook.internal.instrument.anrreport;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x6.b;
import x6.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "()V", "MAX_ANR_REPORT_NUM", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enable", "", "sendANRReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class ANRHandler {
    @NotNull
    public static final ANRHandler INSTANCE = new ANRHandler();
    private static final int MAX_ANR_REPORT_NUM = 5;
    @NotNull
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private ANRHandler() {
    }

    @JvmStatic
    public static final synchronized void enable() {
        synchronized (ANRHandler.class) {
            if (!enabled.getAndSet(true)) {
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    sendANRReports();
                }
                ANRDetector.start();
            }
        }
    }

    @JvmStatic
    @VisibleForTesting
    public static final void sendANRReports() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listAnrReportFiles = InstrumentUtility.listAnrReportFiles();
            ArrayList arrayList = new ArrayList(listAnrReportFiles.length);
            for (File load : listAnrReportFiles) {
                arrayList.add(InstrumentData.Builder.load(load));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if (((InstrumentData) next).isValid()) {
                    arrayList2.add(next);
                }
            }
            List sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new b());
            JSONArray jSONArray = new JSONArray();
            Iterator it = RangesKt___RangesKt.until(0, Math.min(sortedWith.size(), 5)).iterator();
            while (it.hasNext()) {
                jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
            }
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.sendReports("anr_reports", jSONArray, new c(sortedWith));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-2  reason: not valid java name */
    public static final int m8978sendANRReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
        Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
        return instrumentData.compareTo(instrumentData2);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-5  reason: not valid java name */
    public static final void m8979sendANRReports$lambda5(List list, GraphResponse graphResponse) {
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
}
