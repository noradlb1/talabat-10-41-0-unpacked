package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

public final /* synthetic */ class a implements TransportScheduleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f47389a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f47390b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f47391c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsReportWithSessionId f47392d;

    public /* synthetic */ a(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z11, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f47389a = reportQueue;
        this.f47390b = taskCompletionSource;
        this.f47391c = z11;
        this.f47392d = crashlyticsReportWithSessionId;
    }

    public final void onSchedule(Exception exc) {
        this.f47389a.lambda$sendReport$1(this.f47390b, this.f47391c, this.f47392d, exc);
    }
}
