package com.talabat.darkstores.feature.home;

import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012>\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003JA\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bHÆ\u0003JU\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032@\b\u0002\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001RI\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/feature/home/LifestyleMissionV2Data;", "", "lifestyleMission", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "lifeStyleMissionClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "", "Lcom/talabat/feature/mission/control/presentation/listener/LifeStyleMissionClickListener;", "(Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;Lkotlin/jvm/functions/Function2;)V", "getLifeStyleMissionClickListener", "()Lkotlin/jvm/functions/Function2;", "getLifestyleMission", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionV2Data {
    @Nullable
    private final Function2<String, String, Unit> lifeStyleMissionClickListener;
    @NotNull
    private final LifestyleMission lifestyleMission;

    public LifestyleMissionV2Data(@NotNull LifestyleMission lifestyleMission2, @Nullable Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(lifestyleMission2, "lifestyleMission");
        this.lifestyleMission = lifestyleMission2;
        this.lifeStyleMissionClickListener = function2;
    }

    public static /* synthetic */ LifestyleMissionV2Data copy$default(LifestyleMissionV2Data lifestyleMissionV2Data, LifestyleMission lifestyleMission2, Function2<String, String, Unit> function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            lifestyleMission2 = lifestyleMissionV2Data.lifestyleMission;
        }
        if ((i11 & 2) != 0) {
            function2 = lifestyleMissionV2Data.lifeStyleMissionClickListener;
        }
        return lifestyleMissionV2Data.copy(lifestyleMission2, function2);
    }

    @NotNull
    public final LifestyleMission component1() {
        return this.lifestyleMission;
    }

    @Nullable
    public final Function2<String, String, Unit> component2() {
        return this.lifeStyleMissionClickListener;
    }

    @NotNull
    public final LifestyleMissionV2Data copy(@NotNull LifestyleMission lifestyleMission2, @Nullable Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(lifestyleMission2, "lifestyleMission");
        return new LifestyleMissionV2Data(lifestyleMission2, function2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LifestyleMissionV2Data)) {
            return false;
        }
        LifestyleMissionV2Data lifestyleMissionV2Data = (LifestyleMissionV2Data) obj;
        return Intrinsics.areEqual((Object) this.lifestyleMission, (Object) lifestyleMissionV2Data.lifestyleMission) && Intrinsics.areEqual((Object) this.lifeStyleMissionClickListener, (Object) lifestyleMissionV2Data.lifeStyleMissionClickListener);
    }

    @Nullable
    public final Function2<String, String, Unit> getLifeStyleMissionClickListener() {
        return this.lifeStyleMissionClickListener;
    }

    @NotNull
    public final LifestyleMission getLifestyleMission() {
        return this.lifestyleMission;
    }

    public int hashCode() {
        int hashCode = this.lifestyleMission.hashCode() * 31;
        Function2<String, String, Unit> function2 = this.lifeStyleMissionClickListener;
        return hashCode + (function2 == null ? 0 : function2.hashCode());
    }

    @NotNull
    public String toString() {
        LifestyleMission lifestyleMission2 = this.lifestyleMission;
        Function2<String, String, Unit> function2 = this.lifeStyleMissionClickListener;
        return "LifestyleMissionV2Data(lifestyleMission=" + lifestyleMission2 + ", lifeStyleMissionClickListener=" + function2 + ")";
    }
}
