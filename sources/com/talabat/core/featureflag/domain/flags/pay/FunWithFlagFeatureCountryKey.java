package com.talabat.core.featureflag.domain.flags.pay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/pay/FunWithFlagFeatureCountryKey;", "", "id", "", "fwfKey", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getFwfKey", "()Ljava/lang/String;", "getId", "()I", "KWT", "KSA", "BHR", "UAE", "OMN", "QAT", "LBN", "JOR", "EGY", "IRAQ", "Companion", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum FunWithFlagFeatureCountryKey {
    KWT(1, "kwt"),
    KSA(2, "ksa"),
    BHR(3, "bhr"),
    UAE(4, "uae"),
    OMN(5, "omn"),
    QAT(6, "qat"),
    LBN(7, "lbn"),
    JOR(8, "jor"),
    EGY(9, "egy"),
    IRAQ(10, "irq");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String fwfKey;

    /* renamed from: id  reason: collision with root package name */
    private final int f55867id;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/pay/FunWithFlagFeatureCountryKey$Companion;", "", "()V", "getCountryKey", "", "countryId", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getCountryKey(@Nullable Integer num) {
            FunWithFlagFeatureCountryKey funWithFlagFeatureCountryKey;
            boolean z11;
            FunWithFlagFeatureCountryKey[] values = FunWithFlagFeatureCountryKey.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    funWithFlagFeatureCountryKey = null;
                    break;
                }
                funWithFlagFeatureCountryKey = values[i11];
                int id2 = funWithFlagFeatureCountryKey.getId();
                if (num != null && id2 == num.intValue()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i11++;
            }
            if (funWithFlagFeatureCountryKey == null) {
                funWithFlagFeatureCountryKey = FunWithFlagFeatureCountryKey.KWT;
            }
            return funWithFlagFeatureCountryKey.getFwfKey();
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private FunWithFlagFeatureCountryKey(int i11, String str) {
        this.f55867id = i11;
        this.fwfKey = str;
    }

    @NotNull
    public final String getFwfKey() {
        return this.fwfKey;
    }

    public final int getId() {
        return this.f55867id;
    }
}
