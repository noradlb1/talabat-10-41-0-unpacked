package com.talabat.feature.cancellationpolicy.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "", "build", "", "orderId", "caseId", "com_talabat_feature_helpcenter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IHelpCenterDeeplinkBuilder {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ String build$default(IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder, String str, String str2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = null;
                }
                if ((i11 & 2) != 0) {
                    str2 = null;
                }
                return iHelpCenterDeeplinkBuilder.build(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
        }
    }

    @NotNull
    String build(@Nullable String str, @Nullable String str2);
}
