package com.talabat.feature.tmart.growth.data.files;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.signature.ObjectKey;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager$getFilePath$2", f = "TMartGrowthFileManager.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthFileManager$getFilePath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TMartGrowthFilePath>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59075h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthFileManager f59076i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59077j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthFileManager$getFilePath$2(TMartGrowthFileManager tMartGrowthFileManager, String str, Continuation<? super TMartGrowthFileManager$getFilePath$2> continuation) {
        super(2, continuation);
        this.f59076i = tMartGrowthFileManager;
        this.f59077j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TMartGrowthFileManager$getFilePath$2(this.f59076i, this.f59077j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super TMartGrowthFilePath> continuation) {
        return ((TMartGrowthFileManager$getFilePath$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        File file;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59075h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DiskCache access$getDiscCache$p = this.f59076i.discCache;
            if (access$getDiscCache$p != null) {
                String str = this.f59077j;
                TMartGrowthFileManager tMartGrowthFileManager = this.f59076i;
                ObjectKey objectKey = new ObjectKey((String) CollectionsKt___CollectionsKt.last(StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null)));
                file = access$getDiscCache$p.get(objectKey);
                if (file == null) {
                    this.f59075h = 1;
                    obj = tMartGrowthFileManager.downloadAndSaveFile(str, access$getDiscCache$p, objectKey, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Intrinsics.checkNotNullExpressionValue(file, "cache.get(fileKey) ?: do…File(url, cache, fileKey)");
                String path = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "resultFile.path");
                return TMartGrowthFilePath.m10323boximpl(TMartGrowthFilePath.m10324constructorimpl(path));
            }
            throw new IllegalStateException("Cannot save file on disk");
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        file = (File) obj;
        Intrinsics.checkNotNullExpressionValue(file, "cache.get(fileKey) ?: do…File(url, cache, fileKey)");
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "resultFile.path");
        return TMartGrowthFilePath.m10323boximpl(TMartGrowthFilePath.m10324constructorimpl(path2));
    }
}
