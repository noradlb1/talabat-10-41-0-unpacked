package com.talabat.talabatremoteconfiguration.datasource;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\bH&¢\u0006\u0002\u0010\tJ=\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJM\u0010\u0002\u001a\u00020\r\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\r0\u000fH&¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "", "getRemoteConfiguration", "T", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "classType", "Ljava/lang/Class;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "forceRequest", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IRemoteConfigurationDataSource {
    <T> T getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, @NotNull Class<T> cls);

    @Nullable
    <T> Object getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Continuation<? super T> continuation);

    <T> void getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Function1<? super T, Unit> function1);
}
