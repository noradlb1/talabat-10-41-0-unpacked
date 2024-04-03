package com.talabat.feature.mission.control.data;

import com.talabat.feature.mission.control.domain.model.MissionControlRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.mission.control.data.RealMissionControlRepository", f = "RealMissionControlRepository.kt", i = {0, 0, 0}, l = {53}, m = "getLifeStyleMissionControls", n = {"this", "request", "emptyResponse"}, s = {"L$0", "L$1", "L$2"})
public final class RealMissionControlRepository$getLifeStyleMissionControls$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58569h;

    /* renamed from: i  reason: collision with root package name */
    public Object f58570i;

    /* renamed from: j  reason: collision with root package name */
    public Object f58571j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f58572k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ RealMissionControlRepository f58573l;

    /* renamed from: m  reason: collision with root package name */
    public int f58574m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealMissionControlRepository$getLifeStyleMissionControls$1(RealMissionControlRepository realMissionControlRepository, Continuation<? super RealMissionControlRepository$getLifeStyleMissionControls$1> continuation) {
        super(continuation);
        this.f58573l = realMissionControlRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58572k = obj;
        this.f58574m |= Integer.MIN_VALUE;
        return this.f58573l.getLifeStyleMissionControls((MissionControlRequest) null, this);
    }
}
