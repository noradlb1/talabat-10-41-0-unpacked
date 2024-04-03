package com.instabug.library.internal.module;

import buisnessmodels.FilterEngine;
import com.visa.checkout.Profile;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

public enum InstabugLocale {
    ENGLISH("en"),
    ARABIC(ArchiveStreamFactory.AR),
    GERMAN("de"),
    SPANISH("es"),
    FRENCH("fr"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KOREAN("ko"),
    POLISH("pl"),
    PORTUGUESE_BRAZIL("pt", Profile.Country.BR),
    PORTUGUESE_PORTUGAL("pt", "PT"),
    RUSSIAN("ru"),
    SWEDISH("sv"),
    TURKISH("tr"),
    SIMPLIFIED_CHINESE("zh", Profile.Country.CN),
    TRADITIONAL_CHINESE("zh", "TW"),
    CZECH("cs"),
    PERSIAN("fa"),
    INDONESIAN("in"),
    DANISH("da"),
    SLOVAK("sk"),
    NETHERLANDS("nl"),
    NORWEGIAN("no"),
    FINNISH("fi"),
    AZERBAIJANI(FilterEngine.DEEPLINKSORT.ALPHABETIC),
    HUNGARIAN("hu"),
    CATALAN("ca"),
    CATALAN_SPAIN("ca", Profile.Country.ES),
    ROMANIAN("ro");
    
    private final String code;
    private final String country;

    private InstabugLocale(String str) {
        this.code = str;
        this.country = "";
    }

    public String getCode() {
        return this.code;
    }

    public String getCountry() {
        return this.country;
    }

    private InstabugLocale(String str, String str2) {
        this.code = str;
        this.country = str2;
    }
}
