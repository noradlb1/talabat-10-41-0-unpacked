package com.instabug.fatalhangs.sync;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.instabug.crash.settings.b;
import com.instabug.crash.utils.e;
import com.instabug.fatalhangs.cache.a;
import com.instabug.fatalhangs.di.c;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.executor.DeleteOperationExecutor;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.model.Attachment;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

public final class i implements b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f46507a = LazyKt__LazyJVMKt.lazy(c.f46494a);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final a f46508b = c.f46466a.b();

    /* access modifiers changed from: private */
    public final void c(com.instabug.fatalhangs.model.c cVar) {
        b().doRequestOnSameThread(1, a.f46493a.a(cVar), (Request.Callbacks<RequestResponse, Throwable>) new e(cVar, this));
    }

    private final void d() {
        Context a11 = c.f46466a.a();
        if (a11 != null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T a12 = this.f46508b.a(a11);
            objectRef.element = a12;
            if (a12 != null) {
                int b11 = a12.b();
                if (b11 == 1) {
                    a((com.instabug.fatalhangs.model.c) a12, (Request.Callbacks) new g(a12, this, objectRef));
                } else if (b11 == 2) {
                    c((com.instabug.fatalhangs.model.c) a12);
                } else if (b11 == 3) {
                    b((com.instabug.fatalhangs.model.c) a12);
                }
            }
        }
    }

    private final NetworkManager b() {
        return (NetworkManager) this.f46507a.getValue();
    }

    /* access modifiers changed from: private */
    public static final void b(i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "this$0");
        InstabugSDKLogger.v("IBG-CR", "Starting Fatal hangs sync");
        iVar.d();
    }

    /* access modifiers changed from: private */
    public final void b(com.instabug.fatalhangs.model.c cVar) {
        b(cVar, (Request.Callbacks) new d(this, cVar));
    }

    private final void c() {
        String format = String.format(RateLimitedException.RATE_LIMIT_REACHED, Arrays.copyOf(new Object[]{"Crashes"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        InstabugSDKLogger.d("IBG-CR", format);
    }

    public void a() {
        PoolProvider.getNetworkingSingleThreadExecutor("fatal-hang").execute(new jc.a(this));
    }

    private final void b(com.instabug.fatalhangs.model.c cVar, Request.Callbacks callbacks) {
        String localPath;
        InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("Uploading Fatal hang attachments, size: ", Integer.valueOf(cVar.a().size())));
        if (cVar.a().size() == 0) {
            callbacks.onSucceeded(Boolean.TRUE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = cVar.a().size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            Attachment attachment = (Attachment) cVar.a().get(i11);
            if (AttachmentsUtility.decryptAttachmentAndUpdateDb(attachment)) {
                Request a11 = a.f46493a.a(cVar, attachment);
                if (!(a11 == null || (localPath = attachment.getLocalPath()) == null)) {
                    File a12 = c.f46466a.a(localPath);
                    if (!a12.exists() || a12.length() <= 0) {
                        InstabugSDKLogger.w("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it's either not found or empty file");
                    } else {
                        attachment.setAttachmentState(Attachment.AttachmentState.SYNCED);
                        b().doRequestOnSameThread(2, a11, (Request.Callbacks<RequestResponse, Throwable>) new h(attachment, arrayList, cVar, callbacks));
                    }
                }
            } else {
                InstabugSDKLogger.w("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it was not decrypted successfully");
            }
            i11 = i12;
        }
    }

    @VisibleForTesting
    public final void a(@NotNull com.instabug.fatalhangs.model.c cVar, @NotNull Request.Callbacks callbacks) {
        Intrinsics.checkNotNullParameter(cVar, "fatalHang");
        Intrinsics.checkNotNullParameter(callbacks, "callback");
        if (b.a().isRateLimited()) {
            a(cVar);
            return;
        }
        b.a().setLastRequestStartedAt(System.currentTimeMillis());
        b().doRequestOnSameThread(1, a.f46493a.b(cVar), (Request.Callbacks<RequestResponse, Throwable>) new f(callbacks));
    }

    private final void a(com.instabug.fatalhangs.model.c cVar) {
        c();
        Context a11 = c.f46466a.a();
        if (a11 != null) {
            b(a11, cVar);
        }
    }

    /* access modifiers changed from: private */
    public final void a(Context context, com.instabug.fatalhangs.model.c cVar) {
        Object obj;
        if (cVar.i() != null) {
            InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("attempting to delete state file for Fatal hang with id: ", cVar.c()));
            DeleteOperationExecutor deleteOperation = DiskUtils.with(context).deleteOperation(new DeleteUriDiskOperation(cVar.i()));
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6329constructorimpl(Boolean.valueOf(deleteOperation.execute()));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
            if (r02 != null) {
                InstabugSDKLogger.e("IBG-CR", "Unable to delete state file", r02);
                obj = null;
            }
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("result:", Boolean.valueOf(bool.booleanValue())));
                InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("deleting FatalHang:", cVar.c()));
                a aVar = this.f46508b;
                String c11 = cVar.c();
                Intrinsics.checkNotNull(c11);
                aVar.a(c11);
                d();
                return;
            }
            return;
        }
        InstabugSDKLogger.i("IBG-CR", "No state file found. deleting Fatal hang");
        a aVar2 = this.f46508b;
        String c12 = cVar.c();
        Intrinsics.checkNotNull(c12);
        aVar2.a(c12);
        d();
    }

    private final void b(Context context, com.instabug.fatalhangs.model.c cVar) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            for (Attachment a11 : cVar.a()) {
                e.a(a11, cVar.c());
            }
            Unit unit = Unit.INSTANCE;
            a(context, cVar);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (r42 != null) {
            InstabugSDKLogger.e("IBG-CR", Intrinsics.stringPlus("couldn't delete fatal hang ", cVar.c()), r42);
        }
    }

    /* access modifiers changed from: private */
    public final void a(com.instabug.fatalhangs.model.c cVar, RateLimitedException rateLimitedException) {
        b.a().setLimitedUntil(rateLimitedException.getPeriod());
        a(cVar);
    }
}
