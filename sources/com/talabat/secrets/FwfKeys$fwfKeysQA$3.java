package com.talabat.secrets;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class FwfKeys$fwfKeysQA$3 extends FunctionReferenceImpl implements Function0<String> {
    public FwfKeys$fwfKeysQA$3(FwfKeys fwfKeys) {
        super(0, fwfKeys, FwfKeys.class, "getFwfVendorListQaToken", "getFwfVendorListQaToken()Ljava/lang/String;", 0);
    }

    @NotNull
    public final String invoke() {
        return ((FwfKeys) this.receiver).getFwfVendorListQaToken();
    }
}
