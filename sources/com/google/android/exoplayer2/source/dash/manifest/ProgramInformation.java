package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;

public final class ProgramInformation {
    @Nullable
    public final String copyright;
    @Nullable
    public final String lang;
    @Nullable
    public final String moreInformationURL;
    @Nullable
    public final String source;
    @Nullable
    public final String title;

    public ProgramInformation(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.title = str;
        this.source = str2;
        this.copyright = str3;
        this.moreInformationURL = str4;
        this.lang = str5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramInformation)) {
            return false;
        }
        ProgramInformation programInformation = (ProgramInformation) obj;
        if (!Util.areEqual(this.title, programInformation.title) || !Util.areEqual(this.source, programInformation.source) || !Util.areEqual(this.copyright, programInformation.copyright) || !Util.areEqual(this.moreInformationURL, programInformation.moreInformationURL) || !Util.areEqual(this.lang, programInformation.lang)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        String str = this.title;
        int i15 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i16 = (527 + i11) * 31;
        String str2 = this.source;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i17 = (i16 + i12) * 31;
        String str3 = this.copyright;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i18 = (i17 + i13) * 31;
        String str4 = this.moreInformationURL;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i19 = (i18 + i14) * 31;
        String str5 = this.lang;
        if (str5 != null) {
            i15 = str5.hashCode();
        }
        return i19 + i15;
    }
}
