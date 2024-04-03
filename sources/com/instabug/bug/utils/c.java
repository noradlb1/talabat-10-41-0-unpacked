package com.instabug.bug.utils;

import android.content.Context;
import com.instabug.bug.di.a;
import com.instabug.bug.model.d;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class c {
    public static final void a(@NotNull d dVar, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(dVar, "bug");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            b(c(dVar), context);
        } catch (Exception e11) {
            InstabugCore.reportError(e11, Intrinsics.stringPlus("couldn't delete Bug ", dVar.getId()));
        }
    }

    public static final void a(@NotNull Attachment attachment, @Nullable String str) {
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        String localPath = attachment.getLocalPath();
        if (localPath != null) {
            a(new File(localPath).delete());
            Unit unit = Unit.INSTANCE;
        }
        b(attachment, str);
    }

    private static final void a(boolean z11) {
        if (z11) {
            InstabugSDKLogger.v("IBG-BR", "uploadingBugAttachmentRequest succeeded, attachment file deleted successfully");
        }
    }

    /* access modifiers changed from: private */
    public static final void b(d dVar) {
        if (dVar.getId() != null) {
            a.a().a(dVar.getId());
        }
    }

    public static final void b(@NotNull d dVar, @NotNull Context context) {
        Unit unit;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        State state = dVar.getState();
        if (state == null || state.getUri() == null) {
            unit = null;
        } else {
            c(dVar, context);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            InstabugSDKLogger.i("IBG-BR", "No state file found. deleting the bug");
            b(dVar);
            com.instabug.bug.testingreport.a.f45789a.post(1);
        }
    }

    private static final void b(Attachment attachment, String str) {
        if (attachment.getId() != -1) {
            AttachmentsDbHelper.delete(attachment.getId());
        } else if (attachment.getName() != null && str != null) {
            AttachmentsDbHelper.delete(attachment.getName(), str);
        }
    }

    private static final d c(d dVar) {
        List a11 = dVar.a();
        if (a11 != null) {
            ArrayList<Attachment> arrayList = new ArrayList<>();
            for (Object next : a11) {
                if (((Attachment) next).getLocalPath() != null) {
                    arrayList.add(next);
                }
            }
            for (Attachment attachment : arrayList) {
                Intrinsics.checkNotNullExpressionValue(attachment, "it");
                a(attachment, dVar.getId());
            }
        }
        return dVar;
    }

    public static final void c(@NotNull d dVar, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        InstabugSDKLogger.v("IBG-BR", Intrinsics.stringPlus("attempting to delete state file for bug with id: ", dVar.getId()));
        DiskUtils with = DiskUtils.with(context);
        State state = dVar.getState();
        Intrinsics.checkNotNull(state);
        with.deleteOperation(new DeleteUriDiskOperation(state.getUri())).executeAsync(new b(dVar));
    }
}
