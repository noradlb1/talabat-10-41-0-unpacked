package com.talabat.feature.tmart.growth.data.files;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import java.io.File;
import javax.inject.Inject;
import ko.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/files/TMartGrowthFileManager;", "Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;", "discCache", "Lcom/bumptech/glide/load/engine/cache/DiskCache;", "downloadManager", "Lcom/talabat/feature/tmart/growth/data/files/FileDownloadManager;", "dispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/bumptech/glide/load/engine/cache/DiskCache;Lcom/talabat/feature/tmart/growth/data/files/FileDownloadManager;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "downloadAndSaveFile", "Ljava/io/File;", "url", "", "fileKey", "Lcom/bumptech/glide/load/Key;", "(Ljava/lang/String;Lcom/bumptech/glide/load/engine/cache/DiskCache;Lcom/bumptech/glide/load/Key;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "getFilePath-r0oKcjY", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFile", "", "bytes", "", "Companion", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthFileManager implements ITMartGrowthFileManager {
    @NotNull
    private static final String CACHE_ERROR_MESSAGE = "Cannot save file on disk";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public final DiskCache discCache;
    @NotNull
    private final CoroutineDispatchersFactory dispatchersFactory;
    @NotNull
    private final FileDownloadManager downloadManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/files/TMartGrowthFileManager$Companion;", "", "()V", "CACHE_ERROR_MESSAGE", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TMartGrowthFileManager(@Nullable DiskCache diskCache, @NotNull FileDownloadManager fileDownloadManager, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(fileDownloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "dispatchersFactory");
        this.discCache = diskCache;
        this.downloadManager = fileDownloadManager;
        this.dispatchersFactory = coroutineDispatchersFactory;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.bumptech.glide.load.Key} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.bumptech.glide.load.engine.cache.DiskCache} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[SYNTHETIC, Splitter:B:25:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadAndSaveFile(java.lang.String r5, com.bumptech.glide.load.engine.cache.DiskCache r6, com.bumptech.glide.load.Key r7, kotlin.coroutines.Continuation<? super java.io.File> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$downloadAndSaveFile$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$downloadAndSaveFile$1 r0 = (com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$downloadAndSaveFile$1) r0
            int r1 = r0.f59071m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59071m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$downloadAndSaveFile$1 r0 = new com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$downloadAndSaveFile$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f59069k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59071m
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r5 = r0.f59068j
            r7 = r5
            com.bumptech.glide.load.Key r7 = (com.bumptech.glide.load.Key) r7
            java.lang.Object r5 = r0.f59067i
            r6 = r5
            com.bumptech.glide.load.engine.cache.DiskCache r6 = (com.bumptech.glide.load.engine.cache.DiskCache) r6
            java.lang.Object r5 = r0.f59066h
            com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager r5 = (com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0054
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.feature.tmart.growth.data.files.FileDownloadManager r8 = r4.downloadManager
            r0.f59066h = r4
            r0.f59067i = r6
            r0.f59068j = r7
            r0.f59071m = r3
            java.lang.Object r8 = r8.download(r5, r0)
            if (r8 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r5 = r4
        L_0x0054:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0061 }
            okhttp3.ResponseBody r8 = (okhttp3.ResponseBody) r8     // Catch:{ all -> 0x0061 }
            byte[] r8 = r8.bytes()     // Catch:{ all -> 0x0061 }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x0061 }
            goto L_0x006c
        L_0x0061:
            r8 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x006c:
            boolean r0 = kotlin.Result.m6336isSuccessimpl(r8)
            if (r0 == 0) goto L_0x0078
            r0 = r8
            byte[] r0 = (byte[]) r0
            r5.saveFile(r6, r7, r0)
        L_0x0078:
            boolean r5 = kotlin.Result.m6336isSuccessimpl(r8)
            if (r5 == 0) goto L_0x0098
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x008c }
            java.io.File r5 = r6.get(r7)     // Catch:{ all -> 0x008c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x008c }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x008c }
            goto L_0x009c
        L_0x008c:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
            goto L_0x009c
        L_0x0098:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r8)
        L_0x009c:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r6 = "downloadManager.download…            .getOrThrow()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager.downloadAndSaveFile(java.lang.String, com.bumptech.glide.load.engine.cache.DiskCache, com.bumptech.glide.load.Key, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void saveFile(DiskCache diskCache, Key key, byte[] bArr) {
        diskCache.put(key, new a(bArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: saveFile$lambda-4  reason: not valid java name */
    public static final boolean m10297saveFile$lambda4(byte[] bArr, File file) {
        Object obj;
        Intrinsics.checkNotNullParameter(bArr, "$bytes");
        Intrinsics.checkNotNullParameter(file, "outputFile");
        try {
            Result.Companion companion = Result.Companion;
            FilesKt__FileReadWriteKt.writeBytes(file, bArr);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return Result.m6336isSuccessimpl(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getFilePath-r0oKcjY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m10298getFilePathr0oKcjY(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$1 r0 = (com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$1) r0
            int r1 = r0.f59074j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59074j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$1 r0 = new com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f59072h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59074j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0049
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r7 = r5.dispatchersFactory
            kotlinx.coroutines.CoroutineDispatcher r7 = r7.io()
            com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$2 r2 = new com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f59074j = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r7 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r7
            java.lang.String r6 = r7.m10329unboximpl()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager.m10298getFilePathr0oKcjY(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
