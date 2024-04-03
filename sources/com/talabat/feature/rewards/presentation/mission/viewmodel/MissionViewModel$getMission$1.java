package com.talabat.feature.rewards.presentation.mission.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel", f = "MissionViewModel.kt", i = {0}, l = {55}, m = "getMission", n = {"this"}, s = {"L$0"})
public final class MissionViewModel$getMission$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58783h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58784i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MissionViewModel f58785j;

    /* renamed from: k  reason: collision with root package name */
    public int f58786k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissionViewModel$getMission$1(MissionViewModel missionViewModel, Continuation<? super MissionViewModel$getMission$1> continuation) {
        super(continuation);
        this.f58785j = missionViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58784i = obj;
        this.f58786k |= Integer.MIN_VALUE;
        return this.f58785j.getMission(this);
    }
}
