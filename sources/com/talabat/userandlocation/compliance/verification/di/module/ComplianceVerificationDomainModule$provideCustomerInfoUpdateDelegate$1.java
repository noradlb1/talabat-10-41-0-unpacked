package com.talabat.userandlocation.compliance.verification.di.module;

import buisnessmodels.Customer;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ldatamodels/CustomerInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ComplianceVerificationDomainModule$provideCustomerInfoUpdateDelegate$1 extends Lambda implements Function0<CustomerInfo> {
    public static final ComplianceVerificationDomainModule$provideCustomerInfoUpdateDelegate$1 INSTANCE = new ComplianceVerificationDomainModule$provideCustomerInfoUpdateDelegate$1();

    public ComplianceVerificationDomainModule$provideCustomerInfoUpdateDelegate$1() {
        super(0);
    }

    @Nullable
    public final CustomerInfo invoke() {
        return Customer.getInstance().getCustomerInfo();
    }
}
