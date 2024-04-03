package com.instabug.crash.utils;

import android.content.Context;
import com.instabug.crash.cache.b;
import com.instabug.crash.models.a;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class e {
    public static final void b(@NotNull Context context, @NotNull a aVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aVar, "crash");
        State h11 = aVar.h();
        if (h11 == null || h11.getUri() == null) {
            unit = null;
        } else {
            a(aVar, context);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            InstabugSDKLogger.v("IBG-CR", "No state file found. deleting the crash");
            b(aVar);
        }
    }

    public static final void a(@NotNull Context context, @NotNull a aVar) {
        Object obj;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aVar, "crash");
        try {
            Result.Companion companion = Result.Companion;
            List<Attachment> a11 = aVar.a();
            if (a11 == null) {
                unit = null;
            } else {
                for (Attachment attachment : a11) {
                    Intrinsics.checkNotNullExpressionValue(attachment, "it");
                    a(attachment, aVar.e());
                }
                unit = Unit.INSTANCE;
            }
            b(context, aVar);
            obj = Result.m6329constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r32 = Result.m6332exceptionOrNullimpl(obj);
        if (r32 != null) {
            InstabugSDKLogger.e("IBG-CR", Intrinsics.stringPlus("couldn't delete crash ", aVar.e()), r32);
        }
    }

    /* access modifiers changed from: private */
    public static final void b(a aVar) {
        if (aVar.e() != null) {
            b.a(aVar.e());
        }
    }

    public static final void b(@NotNull Context context, @NotNull com.instabug.anr.model.b bVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bVar, "anr");
        State g11 = bVar.g();
        if (g11 == null || g11.getUri() == null) {
            unit = null;
        } else {
            a(bVar, context);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            InstabugSDKLogger.e("IBG-CR", "No state file found. deleting ANR");
            a(bVar);
        }
    }

    private static final void b(Attachment attachment, String str) {
        if (attachment.getId() != -1) {
            AttachmentsDbHelper.delete(attachment.getId());
        } else if (attachment.getName() != null && str != null) {
            AttachmentsDbHelper.delete(attachment.getName(), str);
        }
    }

    private static final void a(a aVar, Context context) {
        InstabugSDKLogger.v("IBG-CR", Intrinsics.stringPlus("attempting to delete state file for crash with id: ", aVar.e()));
        DiskUtils with = DiskUtils.with(context);
        State h11 = aVar.h();
        Intrinsics.checkNotNull(h11);
        with.deleteOperation(new DeleteUriDiskOperation(h11.getUri())).executeAsync(new c(aVar));
    }

    public static final void a(@NotNull Context context, @NotNull com.instabug.anr.model.b bVar) {
        Object obj;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bVar, "anr");
        try {
            Result.Companion companion = Result.Companion;
            List<Attachment> b11 = bVar.b();
            if (b11 == null) {
                unit = null;
            } else {
                for (Attachment attachment : b11) {
                    Intrinsics.checkNotNullExpressionValue(attachment, "it");
                    a(attachment, bVar.c());
                }
                unit = Unit.INSTANCE;
            }
            b(context, bVar);
            obj = Result.m6329constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r32 = Result.m6332exceptionOrNullimpl(obj);
        if (r32 != null) {
            InstabugSDKLogger.e("IBG-CR", Intrinsics.stringPlus("couldn't delete anr ", bVar.c()), r32);
        }
    }

    public static final void a(@NotNull com.instabug.anr.model.b bVar, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        InstabugSDKLogger.v("IBG-CR", Intrinsics.stringPlus("attempting to delete state file for ANR with id: ", bVar.c()));
        DiskUtils.with(context).deleteOperation(new DeleteUriDiskOperation(bVar.g().getUri())).executeAsync(new d(bVar));
    }

    public static final void a(@NotNull com.instabug.anr.model.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        if (bVar.c() != null) {
            com.instabug.anr.cache.a.a(bVar.c());
        }
    }

    public static final void a(@NotNull Attachment attachment, @Nullable String str) {
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        String localPath = attachment.getLocalPath();
        if (localPath != null) {
            Boolean valueOf = Boolean.valueOf(new File(localPath).delete());
            a(attachment, valueOf.booleanValue());
            valueOf.booleanValue();
            b(attachment, str);
        }
    }

    private static final void a(Attachment attachment, boolean z11) {
        if (!z11) {
            InstabugSDKLogger.w("IBG-CR", "Attachment: " + attachment + " is not removed");
            return;
        }
        InstabugSDKLogger.d("IBG-CR", "Attachment: " + attachment + " is removed");
    }
}
