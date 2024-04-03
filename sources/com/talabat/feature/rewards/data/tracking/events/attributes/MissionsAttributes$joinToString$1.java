package com.talabat.feature.rewards.data.tracking.events.attributes;

import com.talabat.feature.rewards.domain.model.Mission;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/rewards/domain/model/Mission;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MissionsAttributes$joinToString$1 extends Lambda implements Function1<Mission, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MissionsAttributes f58750g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Mission, Integer> f58751h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissionsAttributes$joinToString$1(MissionsAttributes missionsAttributes, Function1<? super Mission, Integer> function1) {
        super(1);
        this.f58750g = missionsAttributes;
        this.f58751h = function1;
    }

    @NotNull
    public final CharSequence invoke(@NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "it");
        return this.f58750g.or0(this.f58751h.invoke(mission)).toString();
    }
}
