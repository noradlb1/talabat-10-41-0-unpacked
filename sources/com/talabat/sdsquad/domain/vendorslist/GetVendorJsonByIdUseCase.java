package com.talabat.sdsquad.domain.vendorslist;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.vendorslist.VendorRepository;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase$RequestValues;", "", "requestValues", "a", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "mVendorRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "<init>", "(Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetVendorJsonByIdUseCase extends UseCase<RequestValues, String> {
    @NotNull
    private final VendorRepository mVendorRepository;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorId", "", "(I)V", "getVendorId", "()I", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        private final int vendorId;

        public RequestValues(int i11) {
            this.vendorId = i11;
        }

        public final int getVendorId() {
            return this.vendorId;
        }
    }

    public GetVendorJsonByIdUseCase(@NotNull VendorRepository vendorRepository) {
        Intrinsics.checkNotNullParameter(vendorRepository, "mVendorRepository");
        this.mVendorRepository = vendorRepository;
    }

    @NotNull
    /* renamed from: a */
    public String executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            Vendor vendorById = this.mVendorRepository.getVendorById(requestValues.getVendorId());
            if (vendorById == null) {
                return "";
            }
            String json = GsonInstrumentation.toJson(new Gson(), (Object) vendorById);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(vendor)");
            return json;
        }
        throw new RuntimeException("request value can not be null");
    }
}
