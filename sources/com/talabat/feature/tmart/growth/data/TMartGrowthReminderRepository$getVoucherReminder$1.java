package com.talabat.feature.tmart.growth.data;

import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository", f = "TMartGrowthReminderRepository.kt", i = {0}, l = {23}, m = "getVoucherReminder", n = {"this"}, s = {"L$0"})
public final class TMartGrowthReminderRepository$getVoucherReminder$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59019h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59020i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthReminderRepository f59021j;

    /* renamed from: k  reason: collision with root package name */
    public int f59022k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthReminderRepository$getVoucherReminder$1(TMartGrowthReminderRepository tMartGrowthReminderRepository, Continuation<? super TMartGrowthReminderRepository$getVoucherReminder$1> continuation) {
        super(continuation);
        this.f59021j = tMartGrowthReminderRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59020i = obj;
        this.f59022k |= Integer.MIN_VALUE;
        return this.f59021j.getVoucherReminder((TMartGrowthScreenType) null, this);
    }
}
