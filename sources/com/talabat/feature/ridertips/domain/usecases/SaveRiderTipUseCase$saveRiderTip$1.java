package com.talabat.feature.ridertips.domain.usecases;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase", f = "SaveRiderTipUseCase.kt", i = {0}, l = {15}, m = "saveRiderTip", n = {"this"}, s = {"L$0"})
public final class SaveRiderTipUseCase$saveRiderTip$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58799h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58800i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SaveRiderTipUseCase f58801j;

    /* renamed from: k  reason: collision with root package name */
    public int f58802k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaveRiderTipUseCase$saveRiderTip$1(SaveRiderTipUseCase saveRiderTipUseCase, Continuation<? super SaveRiderTipUseCase$saveRiderTip$1> continuation) {
        super(continuation);
        this.f58801j = saveRiderTipUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58800i = obj;
        this.f58802k |= Integer.MIN_VALUE;
        return this.f58801j.saveRiderTip((Double) null, false, this);
    }
}
