package com.instabug.fatalhangs.sync;

import android.annotation.SuppressLint;
import com.instabug.fatalhangs.model.c;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.FileToUpload;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f46493a = new a();

    private a() {
    }

    private final void a(Request.Builder builder, c cVar) {
        Object obj;
        Request.Builder builder2;
        State h11 = cVar.h();
        if (h11 == null || h11.isMinimalState() || h11.getReportedAt() == 0) {
            try {
                Result.Companion companion = Result.Companion;
                String c11 = cVar.c();
                if (c11 == null) {
                    builder2 = null;
                } else {
                    builder2 = builder.addParameter(new RequestParameter(State.KEY_REPORTED_AT, Long.valueOf(Long.parseLong(c11) / 1000)));
                }
                obj = Result.m6329constructorimpl(builder2);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
            if (r52 != null) {
                IBGDiagnostics.reportNonFatal(r52, "Failed to update reported_at in fatal hang reporting request.");
            }
        }
    }

    @NotNull
    @SuppressLint({"WrongConstant"})
    public final Request b(@NotNull c cVar) {
        ArrayList<State.StateItem> stateItems;
        Intrinsics.checkNotNullParameter(cVar, "fatalHang");
        String appToken = Instabug.getAppToken();
        Request.Builder method = new Request.Builder().endpoint(Endpoints.REPORT_FATAL_HANG).method("POST");
        if (appToken == null) {
            appToken = "";
        }
        Request.Builder addHeader = method.addHeader(new RequestParameter(Header.APP_TOKEN, appToken));
        String uuid = cVar.getMetadata().getUuid();
        if (uuid != null) {
            addHeader.addHeader(new RequestParameter("id", uuid));
        }
        State h11 = cVar.h();
        if (!(h11 == null || (stateItems = h11.getStateItems()) == null || stateItems.size() <= 0)) {
            int size = stateItems.size();
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                String key = stateItems.get(i11).getKey();
                Object value = stateItems.get(i11).getValue();
                if (!(key == null || value == null)) {
                    addHeader.addParameter(new RequestParameter(key, value));
                }
                i11 = i12;
            }
        }
        Intrinsics.checkNotNullExpressionValue(addHeader, "requestBuilder");
        a(addHeader, cVar);
        addHeader.addParameter(new RequestParameter("title", cVar.e()));
        addHeader.addParameter(new RequestParameter(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS, cVar.g()));
        addHeader.addParameter(new RequestParameter("activity_name", cVar.d()));
        String uuid2 = cVar.getMetadata().getUuid();
        if (uuid2 != null) {
            addHeader.addParameter(new RequestParameter("id", uuid2));
        }
        if (cVar.a().size() > 0) {
            addHeader.addParameter(new RequestParameter("attachments_count", Integer.valueOf(cVar.a().size())));
        }
        Request build = addHeader.build();
        Intrinsics.checkNotNullExpressionValue(build, "requestBuilder.build()");
        return build;
    }

    @NotNull
    public final Request a(@NotNull c cVar) {
        String str;
        ArrayList<State.StateItem> logsItems;
        Intrinsics.checkNotNullParameter(cVar, "fatalHang");
        Request.Builder builder = new Request.Builder();
        String j11 = cVar.j();
        if (j11 == null) {
            str = null;
        } else {
            str = new Regex(":crash_token").replace((CharSequence) Endpoints.CRASH_LOGS, j11);
        }
        Request.Builder method = builder.endpoint(str).method("POST");
        State h11 = cVar.h();
        if (!(h11 == null || (logsItems = h11.getLogsItems()) == null || logsItems.size() <= 0)) {
            Iterator<State.StateItem> it = logsItems.iterator();
            while (it.hasNext()) {
                State.StateItem next = it.next();
                if (next.getKey() != null) {
                    method.addParameter(new RequestParameter(next.getKey(), next.getValue() != null ? next.getValue() : ""));
                }
            }
        }
        Request build = method.build();
        Intrinsics.checkNotNullExpressionValue(build, "requestBuilder.build()");
        return build;
    }

    @Nullable
    public final Request a(@NotNull c cVar, @NotNull Attachment attachment) {
        Intrinsics.checkNotNullParameter(cVar, "fatalHang");
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        String j11 = cVar.j();
        if (j11 == null) {
            return null;
        }
        Request.Builder type = new Request.Builder().endpoint(new Regex(":crash_token").replace((CharSequence) Endpoints.ADD_CRASH_ATTACHMENT, j11)).method("POST").type(2);
        if (attachment.getType() != null) {
            type.addParameter(new RequestParameter("metadata[file_type]", attachment.getType()));
        }
        if (attachment.getType() == Attachment.Type.AUDIO && attachment.getDuration() != null) {
            type.addParameter(new RequestParameter("metadata[duration]", attachment.getDuration()));
        }
        String name2 = attachment.getName();
        String localPath = attachment.getLocalPath();
        if (!(name2 == null || localPath == null)) {
            type.fileToUpload(new FileToUpload("file", name2, localPath, attachment.getFileType()));
        }
        return type.build();
    }
}
