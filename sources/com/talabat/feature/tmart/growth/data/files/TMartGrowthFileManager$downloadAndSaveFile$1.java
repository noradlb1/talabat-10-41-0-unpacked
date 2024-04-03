package com.talabat.feature.tmart.growth.data.files;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager", f = "TMartGrowthFileManager.kt", i = {0, 0, 0}, l = {28}, m = "downloadAndSaveFile", n = {"this", "discCache", "fileKey"}, s = {"L$0", "L$1", "L$2"})
public final class TMartGrowthFileManager$downloadAndSaveFile$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59066h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59067i;

    /* renamed from: j  reason: collision with root package name */
    public Object f59068j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f59069k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthFileManager f59070l;

    /* renamed from: m  reason: collision with root package name */
    public int f59071m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthFileManager$downloadAndSaveFile$1(TMartGrowthFileManager tMartGrowthFileManager, Continuation<? super TMartGrowthFileManager$downloadAndSaveFile$1> continuation) {
        super(continuation);
        this.f59070l = tMartGrowthFileManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59069k = obj;
        this.f59071m |= Integer.MIN_VALUE;
        return this.f59070l.downloadAndSaveFile((String) null, (DiskCache) null, (Key) null, this);
    }
}
