package com.talabat.helpers;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/helpers/RiderTipFunWithFragHelper;", "", "()V", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipFunWithFragHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/helpers/RiderTipFunWithFragHelper$Companion;", "", "()V", "getFwfKeyForThisCountry", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FWFKey getFwfKeyForThisCountry() {
            String str = "ridertip-andy-enabled-kwt";
            switch (GlobalDataModel.SelectedCountryId) {
                case 2:
                    str = "ridertip-andy-enabled-ksa";
                    break;
                case 3:
                    str = "ridertip-andy-enabled-bhr";
                    break;
                case 4:
                    str = "ridertip-andy-enabled-uae";
                    break;
                case 5:
                    str = "ridertip-andy-enabled-omn";
                    break;
                case 6:
                    str = "ridertip-andy-enabled-qat";
                    break;
                case 7:
                    str = "ridertip-andy-enabled-lbn";
                    break;
                case 8:
                    str = "ridertip-andy-enabled-jor";
                    break;
                case 9:
                    str = "ridertip-andy-enabled-egy";
                    break;
                case 10:
                    str = "ridertip-andy-enabled-irq";
                    break;
            }
            return new FWFKeyObject(str, (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
        }
    }
}
