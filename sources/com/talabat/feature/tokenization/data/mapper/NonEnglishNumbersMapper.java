package com.talabat.feature.tokenization.data.mapper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/tokenization/data/mapper/NonEnglishNumbersMapper;", "", "()V", "map", "", "input", "Companion", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NonEnglishNumbersMapper {
    @Deprecated
    private static final int ARABIC_NUMBERS_END = 1641;
    @Deprecated
    private static final int ARABIC_NUMBERS_START = 1632;
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int PERSIAN_NUMBERS_END = 1785;
    @Deprecated
    private static final int PERSIAN_NUMBERS_START = 1776;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tokenization/data/mapper/NonEnglishNumbersMapper$Companion;", "", "()V", "ARABIC_NUMBERS_END", "", "ARABIC_NUMBERS_START", "PERSIAN_NUMBERS_END", "PERSIAN_NUMBERS_START", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public final String map(@NotNull String str) {
        boolean z11;
        int i11;
        Intrinsics.checkNotNullParameter(str, "input");
        char[] cArr = new char[str.length()];
        int length = str.length();
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            boolean z12 = true;
            if (ARABIC_NUMBERS_START > charAt || charAt >= 1642) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                i11 = charAt - 1584;
            } else {
                if (PERSIAN_NUMBERS_START > charAt || charAt >= 1786) {
                    z12 = false;
                }
                if (z12) {
                    i11 = charAt - 1728;
                } else {
                    cArr[i12] = charAt;
                }
            }
            charAt = (char) i11;
            cArr[i12] = charAt;
        }
        return new String(cArr);
    }
}
