package com.talabat.feature.tmart.growth.data.files;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager", f = "TMartGrowthFileManager.kt", i = {}, l = {18}, m = "getFilePath-r0oKcjY", n = {}, s = {})
public final class TMartGrowthFileManager$getFilePath$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59072h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthFileManager f59073i;

    /* renamed from: j  reason: collision with root package name */
    public int f59074j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthFileManager$getFilePath$1(TMartGrowthFileManager tMartGrowthFileManager, Continuation<? super TMartGrowthFileManager$getFilePath$1> continuation) {
        super(continuation);
        this.f59073i = tMartGrowthFileManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59072h = obj;
        this.f59074j |= Integer.MIN_VALUE;
        Object r22 = this.f59073i.m10298getFilePathr0oKcjY((String) null, this);
        return r22 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r22 : TMartGrowthFilePath.m10323boximpl((String) r22);
    }
}
