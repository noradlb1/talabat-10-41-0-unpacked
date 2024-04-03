package com.talabat.core.hms.base.domain;

import com.talabat.core.di.Api;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "Lcom/talabat/core/di/Api;", "isHmsAvailable", "", "com_talabat_core_hms_base_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HmsBaseCoreLibApi extends Api {
    @IsHmsAvailable
    boolean isHmsAvailable();
}
