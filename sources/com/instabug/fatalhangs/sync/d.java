package com.instabug.fatalhangs.sync;

import android.content.Context;
import com.instabug.fatalhangs.model.c;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f46495a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f46496b;

    public d(i iVar, c cVar) {
        this.f46495a = iVar;
        this.f46496b = cVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.d("IBG-CR", "Fatal hang attachments uploaded successfully");
        Context a11 = com.instabug.fatalhangs.di.c.f46466a.a();
        if (a11 != null) {
            this.f46495a.a(a11, this.f46496b);
        }
    }

    /* renamed from: a */
    public void onFailed(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        AttachmentsUtility.encryptAttachmentsAndUpdateDb(this.f46496b.a());
        InstabugSDKLogger.e("IBG-CR", "Something went wrong while uploading fatal hang attachments", th2);
    }
}
