package com.instabug.crash.network;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.crash.cache.b;
import com.instabug.crash.models.a;
import com.instabug.crash.utils.e;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.video.InstabugVideoUtils;
import com.instabug.library.model.Attachment;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

public class h extends InstabugNetworkJob {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static h f46438a;

    private h() {
    }

    private static void a(@NonNull Context context) throws IOException {
        if (SettingsManager.getInstance().autoScreenRecordingEnabled()) {
            int autoScreenRecordingMaxDuration = SettingsManager.getInstance().autoScreenRecordingMaxDuration();
            for (a aVar : b.a(context)) {
                if (aVar.c() == a.C0057a.WAITING_FOR_SCREEN_RECORDING_TO_BE_TRIMMED) {
                    Iterator it = aVar.a().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Attachment attachment = (Attachment) it.next();
                        if (attachment.isEncrypted()) {
                            attachment.setEncrypted(AttachmentsUtility.decryptAttachmentAndUpdateDb(attachment));
                        }
                        if (attachment.getType() != null && attachment.getType().toString().equalsIgnoreCase(Attachment.Type.AUTO_SCREEN_RECORDING_VIDEO.toString()) && attachment.getLocalPath() != null) {
                            File startTrim = InstabugVideoUtils.startTrim(new File(attachment.getLocalPath()), AttachmentManager.getAutoScreenRecordingFile(context), autoScreenRecordingMaxDuration);
                            Uri fromFile = Uri.fromFile(startTrim);
                            if (fromFile.getLastPathSegment() != null) {
                                attachment.setName(fromFile.getLastPathSegment());
                            }
                            if (fromFile.getPath() != null) {
                                attachment.setLocalPath(fromFile.getPath());
                            }
                            a.C0057a aVar2 = a.C0057a.READY_TO_BE_SENT;
                            aVar.a(aVar2);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("crash_state", aVar2.name());
                            String e11 = aVar.e();
                            if (e11 != null) {
                                b.a(e11, contentValues);
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH, startTrim.getPath());
                            AttachmentsDbHelper.update(attachment.getId(), contentValues2);
                        }
                    }
                }
            }
        }
    }

    public static synchronized h b() {
        h hVar;
        synchronized (h.class) {
            if (f46438a == null) {
                f46438a = new h();
            }
            hVar = f46438a;
        }
        return hVar;
    }

    /* access modifiers changed from: private */
    public static void c(a aVar, @NonNull Context context) throws JSONException {
        InstabugSDKLogger.d("IBG-CR", "Found " + aVar.a().size() + " attachments related to crash");
        d.a().b(aVar, new g(aVar));
    }

    private static void d() {
        InstabugSDKLogger.d("IBG-CR", String.format(RateLimitedException.RATE_LIMIT_REACHED, new Object[]{"Crashes"}));
    }

    /* access modifiers changed from: private */
    public static void e() {
        Calendar instance = Calendar.getInstance(Locale.ENGLISH);
        InstabugSDKLogger.v("IBG-CR", "Updating last_crash_time to " + instance.getTime());
        com.instabug.crash.settings.b.a().a(instance.getTime().getTime());
    }

    public void start() {
        b(IBGNetworkWorker.CRASH, new gc.a());
    }

    /* access modifiers changed from: private */
    public static void d(a aVar, @NonNull Context context) {
        d.a().c(aVar, new f(aVar, context));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c() {
        if (Instabug.getApplicationContext() != null) {
            try {
                a(Instabug.getApplicationContext());
                b(Instabug.getApplicationContext());
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-CR", "Error " + e11.getMessage() + "occurred while uploading crashes", e11);
            }
        } else {
            InstabugSDKLogger.d("IBG-CR", "Context was null while uploading Crashes");
        }
    }

    private static void b(@NonNull Context context) throws JSONException {
        List<a> a11 = b.a(context);
        InstabugSDKLogger.d("IBG-CR", "Found " + a11.size() + " crashes in cache");
        for (a aVar : a11) {
            if (aVar.c().equals(a.C0057a.READY_TO_BE_SENT)) {
                if (com.instabug.crash.settings.b.a().isRateLimited()) {
                    a(context, aVar);
                    d();
                } else {
                    com.instabug.crash.settings.b.a().setLastRequestStartedAt(System.currentTimeMillis());
                    InstabugSDKLogger.d("IBG-CR", "Uploading crash: " + aVar.e() + " is handled: " + aVar.k());
                    d.a().a(aVar, (Request.Callbacks) new e(aVar, context));
                }
            } else if (aVar.c().equals(a.C0057a.LOGS_READY_TO_BE_UPLOADED)) {
                InstabugSDKLogger.v("IBG-CR", "crash: " + aVar.e() + " already uploaded but has unsent logs, uploading now");
                d(aVar, context);
            } else if (aVar.c().equals(a.C0057a.ATTACHMENTS_READY_TO_BE_UPLOADED)) {
                InstabugSDKLogger.d("IBG-CR", "crash: " + aVar.e() + " already uploaded but has unsent attachments, uploading now");
                c(aVar, context);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(RateLimitedException rateLimitedException, @NonNull a aVar, Context context) {
        com.instabug.crash.settings.b.a().setLimitedUntil(rateLimitedException.getPeriod());
        d();
        a(context, aVar);
    }

    private static void a(Context context, @NonNull a aVar) {
        e.a(context, aVar);
    }
}
