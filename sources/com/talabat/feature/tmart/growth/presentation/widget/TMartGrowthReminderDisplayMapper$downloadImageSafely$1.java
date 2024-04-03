package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper", f = "TMartGrowthReminderDisplayMapper.kt", i = {}, l = {38}, m = "downloadImageSafely-r0oKcjY", n = {}, s = {})
public final class TMartGrowthReminderDisplayMapper$downloadImageSafely$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59187h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthReminderDisplayMapper f59188i;

    /* renamed from: j  reason: collision with root package name */
    public int f59189j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthReminderDisplayMapper$downloadImageSafely$1(TMartGrowthReminderDisplayMapper tMartGrowthReminderDisplayMapper, Continuation<? super TMartGrowthReminderDisplayMapper$downloadImageSafely$1> continuation) {
        super(continuation);
        this.f59188i = tMartGrowthReminderDisplayMapper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59187h = obj;
        this.f59189j |= Integer.MIN_VALUE;
        Object r22 = this.f59188i.m10347downloadImageSafelyr0oKcjY((String) null, this);
        return r22 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r22 : TMartGrowthFilePath.m10323boximpl((String) r22);
    }
}
