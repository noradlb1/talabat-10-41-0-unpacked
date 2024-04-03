package com.talabat.core.featureflag.domain;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ8\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u000bH&\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "", "getFeatureFlag", "", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITalabatFeatureFlag {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getFeatureFlag$default(ITalabatFeatureFlag iTalabatFeatureFlag, FWFKey fWFKey, boolean z11, boolean z12, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    z11 = false;
                }
                if ((i11 & 4) != 0) {
                    z12 = false;
                }
                return iTalabatFeatureFlag.getFeatureFlag(fWFKey, z11, z12, (Continuation<? super Boolean>) continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFeatureFlag");
        }

        public static /* synthetic */ void getFeatureFlag$default(ITalabatFeatureFlag iTalabatFeatureFlag, FWFKey fWFKey, boolean z11, boolean z12, Function1 function1, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    z11 = false;
                }
                if ((i11 & 4) != 0) {
                    z12 = false;
                }
                iTalabatFeatureFlag.getFeatureFlag(fWFKey, z11, z12, (Function1<? super Boolean, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFeatureFlag");
        }

        public static /* synthetic */ boolean getFeatureFlag$default(ITalabatFeatureFlag iTalabatFeatureFlag, FWFKey fWFKey, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    z11 = false;
                }
                return iTalabatFeatureFlag.getFeatureFlag(fWFKey, z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFeatureFlag");
        }
    }

    @Nullable
    Object getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation);

    void getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1);

    boolean getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11);
}
