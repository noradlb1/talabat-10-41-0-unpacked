package com.talabat.core.network.domain.endpoint;

import com.talabat.core.fwf.data.FunWithFlags;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "", "label", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "PRODUCTION", "QA", "MOCK", "Companion", "com_talabat_core_network_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum EndpointEnvironment {
    PRODUCTION("prod"),
    QA(FunWithFlags.ENV_QA),
    MOCK("mock");
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final EndpointEnvironment[] values = null;
    @NotNull
    private final String label;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment$Companion;", "", "()V", "values", "", "Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "getValues", "()[Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "[Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "com_talabat_core_network_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EndpointEnvironment[] getValues() {
            return EndpointEnvironment.values;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        values = values();
    }

    private EndpointEnvironment(String str) {
        this.label = str;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }
}
