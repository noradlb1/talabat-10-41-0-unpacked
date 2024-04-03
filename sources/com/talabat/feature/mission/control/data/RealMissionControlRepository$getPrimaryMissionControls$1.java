package com.talabat.feature.mission.control.data;

import com.talabat.feature.mission.control.domain.model.MissionControlRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.mission.control.data.RealMissionControlRepository", f = "RealMissionControlRepository.kt", i = {0, 0, 0}, l = {91}, m = "getPrimaryMissionControls", n = {"this", "request", "emptyResponse"}, s = {"L$0", "L$1", "L$2"})
public final class RealMissionControlRepository$getPrimaryMissionControls$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58575h;

    /* renamed from: i  reason: collision with root package name */
    public Object f58576i;

    /* renamed from: j  reason: collision with root package name */
    public Object f58577j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f58578k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ RealMissionControlRepository f58579l;

    /* renamed from: m  reason: collision with root package name */
    public int f58580m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealMissionControlRepository$getPrimaryMissionControls$1(RealMissionControlRepository realMissionControlRepository, Continuation<? super RealMissionControlRepository$getPrimaryMissionControls$1> continuation) {
        super(continuation);
        this.f58579l = realMissionControlRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58578k = obj;
        this.f58580m |= Integer.MIN_VALUE;
        return this.f58579l.getPrimaryMissionControls((MissionControlRequest) null, this);
    }
}
