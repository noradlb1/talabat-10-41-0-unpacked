package com.talabat.splash.data.remote.worker;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.talabat.splash.data.local.LocalCache;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import vu.a;

@Instrumented
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/splash/data/remote/worker/DownloadWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "localCache", "Lcom/talabat/splash/data/local/LocalCache;", "deleteFilesAndRemoveEntry", "", "file", "Ljava/io/File;", "preferenceName", "", "doWork", "Landroidx/work/ListenableWorker$Result;", "downloadFile", "urlData", "filePath", "getSharedPreference", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "prepareCacheAndGetPath", "type", "Lcom/talabat/splash/data/remote/worker/DownloadWorker$Type;", "savePathInPreference", "Companion", "Type", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadWorker extends Worker {
    private static final int BUFFER = 8192;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DATA_PREFERENCE_KEY = "preference_name";
    @NotNull
    public static final String DATA_TYPE_KEY = "type";
    @NotNull
    public static final String DATA_URL_KEY = "url";
    private static final long MAX_FILE_RETAIN_AGE_IN_DAYS = 1;
    @NotNull
    private final Context context;
    @NotNull
    private final LocalCache localCache;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/splash/data/remote/worker/DownloadWorker$Companion;", "", "()V", "BUFFER", "", "DATA_PREFERENCE_KEY", "", "DATA_TYPE_KEY", "DATA_URL_KEY", "MAX_FILE_RETAIN_AGE_IN_DAYS", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/splash/data/remote/worker/DownloadWorker$Type;", "", "extension", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "IMAGE", "VIDEO", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        IMAGE(".png"),
        VIDEO(".mp4");
        
        @NotNull
        private final String extension;

        private Type(String str) {
            this.extension = str;
        }

        @NotNull
        public final String getExtension() {
            return this.extension;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadWorker(@NotNull Context context2, @NotNull WorkerParameters workerParameters) {
        super(context2, workerParameters);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        this.context = context2;
        this.localCache = new LocalCache(context2, (Function1) null, 2, (DefaultConstructorMarker) null);
    }

    private final void deleteFilesAndRemoveEntry(File file, String str) {
        SharedPreferences sharedPreference = getSharedPreference(str);
        File[] listFiles = file.listFiles(new a());
        if (listFiles != null) {
            for (File file2 : listFiles) {
                Map<String, ?> all = sharedPreference.getAll();
                Intrinsics.checkNotNullExpressionValue(all, "sharedPreference.all");
                for (Map.Entry next : all.entrySet()) {
                    if (Intrinsics.areEqual(next.getValue(), (Object) file2.getPath())) {
                        sharedPreference.edit().remove((String) next.getKey()).apply();
                    }
                }
                file2.delete();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteFilesAndRemoveEntry$lambda-1  reason: not valid java name */
    public static final boolean m10909deleteFilesAndRemoveEntry$lambda1(File file) {
        return file.lastModified() + TimeUnit.DAYS.toMillis(1) < System.currentTimeMillis();
    }

    private final void downloadFile(String str, String str2) {
        URL url = new URL(str);
        ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection()))).connect();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(FirebasePerfUrlConnection.openStream(url), 8192);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[1024];
        Ref.IntRef intRef = new Ref.IntRef();
        DownloadWorker$downloadFile$readData$1 downloadWorker$downloadFile$readData$1 = new DownloadWorker$downloadFile$readData$1(intRef, bufferedInputStream, bArr);
        while (((Number) downloadWorker$downloadFile$readData$1.invoke()).intValue() != -1) {
            fileOutputStream.write(bArr, 0, intRef.element);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        bufferedInputStream.close();
    }

    private final SharedPreferences getSharedPreference(String str) {
        return this.context.getSharedPreferences(str, 0);
    }

    private final String prepareCacheAndGetPath(String str, Type type) {
        File downloadFolder = this.localCache.getDownloadFolder();
        if (!downloadFolder.exists()) {
            downloadFolder.mkdir();
        } else {
            deleteFilesAndRemoveEntry(downloadFolder, str);
        }
        String str2 = type.name() + JavaConstant.Dynamic.DEFAULT_NAME + System.currentTimeMillis() + type.getExtension();
        return downloadFolder.getPath() + "/" + str2;
    }

    private final void savePathInPreference(String str, String str2, String str3) {
        getSharedPreference(str).edit().putString(str2, str3).commit();
    }

    @NotNull
    public ListenableWorker.Result doWork() {
        Type type;
        boolean z11;
        try {
            String string = getInputData().getString("url");
            if (string != null) {
                String string2 = getInputData().getString(DATA_PREFERENCE_KEY);
                if (string2 != null) {
                    Type[] values = Type.values();
                    int length = values.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            type = null;
                            break;
                        }
                        type = values[i11];
                        if (type.ordinal() == getInputData().getInt("type", -1)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            break;
                        }
                        i11++;
                    }
                    if (type != null) {
                        String prepareCacheAndGetPath = prepareCacheAndGetPath(string2, type);
                        downloadFile(string, prepareCacheAndGetPath);
                        savePathInPreference(string2, string, prepareCacheAndGetPath);
                        ListenableWorker.Result success = ListenableWorker.Result.success();
                        Intrinsics.checkNotNullExpressionValue(success, "success()");
                        return success;
                    }
                    throw new IllegalArgumentException("type inputData must be set");
                }
                throw new IllegalArgumentException("preference_name inputData must be set");
            }
            throw new IllegalArgumentException("url inputData must be set");
        } catch (Exception unused) {
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure()");
            return failure;
        }
    }
}
