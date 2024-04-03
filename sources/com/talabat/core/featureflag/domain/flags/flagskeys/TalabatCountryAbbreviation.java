package com.talabat.core.featureflag.domain.flags.flagskeys;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/flagskeys/TalabatCountryAbbreviation;", "", "countryAbbreviation", "", "countryId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getCountryAbbreviation", "()Ljava/lang/String;", "getCountryId", "()I", "KUWAIT", "KSA", "BAHRAIN", "UAE", "OMAN", "QATAR", "LEBANON", "JORDAN", "EGYPT", "IRAQ", "Companion", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum TalabatCountryAbbreviation {
    KUWAIT("kwt", 1),
    KSA("ksa", 2),
    BAHRAIN("bhr", 3),
    UAE("uae", 4),
    OMAN("omn", 5),
    QATAR("qat", 6),
    LEBANON("lbn", 7),
    JORDAN("jor", 8),
    EGYPT("egy", 9),
    IRAQ("irq", 10);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String countryAbbreviation;
    private final int countryId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/flagskeys/TalabatCountryAbbreviation$Companion;", "", "()V", "getCountryAbbreviation", "", "countryId", "", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getCountryAbbreviation(int i11) {
            TalabatCountryAbbreviation talabatCountryAbbreviation;
            String countryAbbreviation;
            boolean z11;
            TalabatCountryAbbreviation[] values = TalabatCountryAbbreviation.values();
            int length = values.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    talabatCountryAbbreviation = null;
                    break;
                }
                talabatCountryAbbreviation = values[i12];
                if (talabatCountryAbbreviation.getCountryId() == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i12++;
            }
            if (talabatCountryAbbreviation == null || (countryAbbreviation = talabatCountryAbbreviation.getCountryAbbreviation()) == null) {
                return "kwt";
            }
            return countryAbbreviation;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private TalabatCountryAbbreviation(String str, int i11) {
        this.countryAbbreviation = str;
        this.countryId = i11;
    }

    @NotNull
    public final String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public final int getCountryId() {
        return this.countryId;
    }
}
