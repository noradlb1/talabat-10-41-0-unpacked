package com.talabat.core.fwf.domain;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H&J4\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\nH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/fwf/domain/IFunWithFlags;", "", "getVariation", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "", "forceRequest", "", "callback", "Lkotlin/Function1;", "com_talabat_core_fwf_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFunWithFlags {
    @NotNull
    Object getVariation(@NotNull FWFKey fWFKey, @NotNull Object obj);

    void getVariation(@NotNull FWFKey fWFKey, @NotNull Object obj, boolean z11, @NotNull Function1<Object, Unit> function1);
}
