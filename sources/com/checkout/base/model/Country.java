package com.checkout.base.model;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.huawei.wearengine.sensor.Sensor;
import com.newrelic.agent.android.Agent;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0003\b\u0002\b\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bxj\u0002\byj\u0002\bzj\u0002\b{j\u0002\b|j\u0002\b}j\u0002\b~j\u0002\bj\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b \u0001j\u0003\b¡\u0001j\u0003\b¢\u0001j\u0003\b£\u0001j\u0003\b¤\u0001j\u0003\b¥\u0001j\u0003\b¦\u0001j\u0003\b§\u0001j\u0003\b¨\u0001j\u0003\b©\u0001j\u0003\bª\u0001j\u0003\b«\u0001j\u0003\b¬\u0001j\u0003\b­\u0001j\u0003\b®\u0001j\u0003\b¯\u0001j\u0003\b°\u0001j\u0003\b±\u0001j\u0003\b²\u0001j\u0003\b³\u0001j\u0003\b´\u0001j\u0003\bµ\u0001j\u0003\b¶\u0001j\u0003\b·\u0001j\u0003\b¸\u0001j\u0003\b¹\u0001j\u0003\bº\u0001j\u0003\b»\u0001j\u0003\b¼\u0001j\u0003\b½\u0001j\u0003\b¾\u0001j\u0003\b¿\u0001j\u0003\bÀ\u0001j\u0003\bÁ\u0001j\u0003\bÂ\u0001j\u0003\bÃ\u0001j\u0003\bÄ\u0001j\u0003\bÅ\u0001j\u0003\bÆ\u0001j\u0003\bÇ\u0001j\u0003\bÈ\u0001j\u0003\bÉ\u0001j\u0003\bÊ\u0001j\u0003\bË\u0001j\u0003\bÌ\u0001j\u0003\bÍ\u0001j\u0003\bÎ\u0001j\u0003\bÏ\u0001j\u0003\bÐ\u0001j\u0003\bÑ\u0001j\u0003\bÒ\u0001j\u0003\bÓ\u0001j\u0003\bÔ\u0001j\u0003\bÕ\u0001j\u0003\bÖ\u0001j\u0003\b×\u0001j\u0003\bØ\u0001j\u0003\bÙ\u0001j\u0003\bÚ\u0001j\u0003\bÛ\u0001j\u0003\bÜ\u0001j\u0003\bÝ\u0001j\u0003\bÞ\u0001j\u0003\bß\u0001j\u0003\bà\u0001j\u0003\bá\u0001j\u0003\bâ\u0001j\u0003\bã\u0001j\u0003\bä\u0001j\u0003\bå\u0001j\u0003\bæ\u0001j\u0003\bç\u0001j\u0003\bè\u0001j\u0003\bé\u0001j\u0003\bê\u0001j\u0003\bë\u0001j\u0003\bì\u0001j\u0003\bí\u0001j\u0003\bî\u0001j\u0003\bï\u0001j\u0003\bð\u0001j\u0003\bñ\u0001j\u0003\bò\u0001j\u0003\bó\u0001j\u0003\bô\u0001j\u0003\bõ\u0001j\u0003\bö\u0001j\u0003\b÷\u0001j\u0003\bø\u0001j\u0003\bù\u0001j\u0003\bú\u0001j\u0003\bû\u0001j\u0003\bü\u0001j\u0003\bý\u0001j\u0003\bþ\u0001j\u0003\bÿ\u0001j\u0003\b\u0002j\u0003\b\u0002j\u0003\b\u0002j\u0003\b\u0002j\u0003\b\u0002¨\u0006\u0002"}, d2 = {"Lcom/checkout/base/model/Country;", "", "iso3166Alpha2", "", "dialingCode", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDialingCode", "()Ljava/lang/String;", "getIso3166Alpha2", "AFGHANISTAN", "ALAND_ISLANDS", "ALBANIA", "ALGERIA", "AMERICAN_SAMOA", "ANDORRA", "ANGOLA", "ANGUILLA", "ANTARCTICA", "ANTIGUA_AND_BARBUDA", "ARGENTINA", "ARMENIA", "ARUBA", "ASCENSION_ISLAND", "AUSTRALIA", "AUSTRIA", "AZERBAIJAN", "BAHAMAS", "BAHRAIN", "BANGLADESH", "BARBADOS", "BELARUS", "BELGIUM", "BELIZE", "BENIN", "BERMUDA", "BHUTAN", "BOLIVIA", "BONAIRE", "BOSNIA_AND_HERZEGOVINA", "BOTSWANA", "BOUVET_ISLAND", "BRAZIL", "BRITISH_INDIAN_OCEAN_TERRITORY", "BRUNEI_DARUSSALAM", "BULGARIA", "BURKINA_FASO", "BURUNDI", "CAMBODIA", "CAMEROON", "CANADA", "CAPE_VERDE", "CAYMAN_ISLANDS", "CENTRAL_AFRICAN_REPUBLIC", "CHAD", "CHILE", "CHINA", "CHRISTMAS_ISLAND", "COCOS_ISLANDS", "COLOMBIA", "COMOROS", "CONGO_BRAZZAVILLE", "COOK_ISLANDS", "COSTA_RICA", "CROATIA", "CUBA", "CURACAO", "CYPRUS", "CZECH_REPUBLIC", "CONGO_KINSHASA", "DENMARK", "DJIBOUTI", "DOMINICA", "DOMINICAN_REPUBLIC", "ECUADOR", "EGYPT", "EL_SALVADOR", "EQUATORIAL_GUINEA", "ERITREA", "ESTONIA", "SWAZILAND", "ETHIOPIA", "FALKLAND_ISLANDS", "FAROE_ISLANDS", "FIJI", "FINLAND", "FRANCE", "FRENCH_GUIANA", "FRENCH_POLYNESIA", "FRENCH_SOUTHERN_ANTARCTIC_LANDS", "GABON", "GAMBIA", "GEORGIA", "GERMANY", "GHANA", "GIBRALTAR", "GREECE", "GREENLAND", "GRENADA", "GUADELOUPE", "GUAM", "GUATEMALA", "GUERNSEY", "GUINEA", "GUINEA_BISSAU", "GUYANA", "HAITI", "HEARD_ISLANDS_MCDONALD_ISLANDS", "HONDURAS", "HONG_KONG", "HUNGARY", "ICELAND", "INDIA", "INDONESIA", "IRAN", "IRAQ", "IRELAND", "ISLE_OF_MAN", "ISRAEL", "ITALY", "COTE_D_IVOIRE", "JAMAICA", "JAPAN", "JERSEY", "JORDAN", "KAZAKHSTAN", "KENYA", "KIRIBATI", "KOREA_NORTH", "KOREA_SOUTH", "KUWAIT", "KYRGYZSTAN", "LAO_PDR", "LATVIA", "LEBANON", "LESOTHO", "LIBERIA", "LIBYA", "LIECHTENSTEIN", "LITHUANIA", "LUXEMBOURG", "MACAO", "MADAGASCAR", "MALAWI", "MALAYSIA", "MALDIVES", "MALI", "MALTA", "MARSHALL_ISLANDS", "MARTINIQUE", "MAURITANIA", "MAURITIUS", "MAYOTTE", "MEXICO", "MICRONESIA", "MOLDOVA", "MONACO", "MONGOLIA", "MONTENEGRO", "MONTSERRAT", "MOROCCO", "MOZAMBIQUE", "MYANMAR", "NAMIBIA", "NAURU", "NEPAL", "NETHERLANDS", "NETHERLANDS_ANTILLES", "NEW_CALEDONIA", "NEW_ZEALAND", "NICARAGUA", "NIGER", "NIGERIA", "NIUE", "NORFOLK_ISLAND", "MACEDONIA", "NORTHERN_MARIANA_ISLANDS", "NORWAY", "OMAN", "PAKISTAN", "PALAU", "PANAMA", "PAPUA_NEW_GUINEA", "PARAGUAY", "PERU", "PHILIPPINES", "PITCAIRN", "POLAND", "PORTUGAL", "PUERTO_RICO", "QATAR", "REUNION", "RO", "ROMANIA", "RWANDA", "SAINT_BARTHELEMY", "SAINT_HELENA", "SAINT_KITTS_AND_NEVIS", "SAINT_LUCIA", "SAINT_MARTIN", "SAINT_PIERRE_AND_MIQUELON", "SAINT_VINCENT_AND_GRENADINES", "SAMOA", "SAN_MARINO", "SAO_TOME_AND_PRINCIPE", "SAUDI_ARABIA", "SENEGAL", "SERBIA", "SEYCHELLES", "SIERRA_LEONE", "SINGAPORE", "SINT_MAARTEN", "SLOVAKIA", "SLOVENIA", "SOLOMON_ISLANDS", "SOMALIA", "SOUTH_AFRICA", "SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS", "SOUTH_SUDAN", "SPAIN", "SRI_LANKA", "SUDAN", "SURINAME", "SVALBARD_AND_JAN_MAYEN_ISLANDS", "SWEDEN", "SWITZERLAND", "SYRIA", "TAIWAN", "TAJIKISTAN", "TANZANIA", "THAILAND", "TIMOR_LESTE", "TOGO", "TOKELAU", "TONGA", "TRINIDAD_AND_TOBAGO", "TRISTAN_DA_CUNHA", "TUNISIA", "TURKEY", "TURKMENISTAN", "TURKS_AND_CAICOS_ISLANDS", "TUVALU", "UGANDA", "UKRAINE", "UNITED_ARAB_EMIRATES", "UNITED_KINGDOM", "UNITED_STATES_OF_AMERICA", "US_MINOR_OUTLYING_ISLANDS", "URUGUAY", "UZBEKISTAN", "VANUATU", "VATICAN_CITY", "VENEZUELA", "VIETNAM", "BRITISH_VIRGIN_ISLANDS", "VIRGIN_ISLANDS", "WALLIS_AND_FUTUNA_ISLANDS", "WESTERN_SAHARA", "YEMEN", "ZAMBIA", "ZIMBABWE", "INVALID_COUNTRY", "Companion", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum Country {
    AFGHANISTAN("AF", "93"),
    ALAND_ISLANDS("AX", "358"),
    ALBANIA("AL", "355"),
    ALGERIA("DZ", "213"),
    AMERICAN_SAMOA("AS", "1684"),
    ANDORRA("AD", "376"),
    ANGOLA("AO", "244"),
    ANGUILLA("AI", "1264"),
    ANTARCTICA("AQ", "672"),
    ANTIGUA_AND_BARBUDA("AG", "1268"),
    ARGENTINA(Profile.Country.AR, "54"),
    ARMENIA("AM", "374"),
    ARUBA("AW", "297"),
    ASCENSION_ISLAND("AC", "247"),
    AUSTRALIA(Profile.Country.AU, "61"),
    AUSTRIA("AT", "43"),
    AZERBAIJAN("AZ", "994"),
    BAHAMAS("BS", "1242"),
    BAHRAIN("BH", "973"),
    BANGLADESH("BD", "880"),
    BARBADOS("BB", "1246"),
    BELARUS("BY", "375"),
    BELGIUM("BE", "32"),
    BELIZE("BZ", "501"),
    BENIN("BJ", "229"),
    BERMUDA("BM", "1441"),
    BHUTAN("BT", "975"),
    BOLIVIA("BO", "591"),
    BONAIRE("BQ", "5997"),
    BOSNIA_AND_HERZEGOVINA("BA", "387"),
    BOTSWANA("BW", "267"),
    BOUVET_ISLAND("BV", ""),
    BRAZIL(Profile.Country.BR, "55"),
    BRITISH_INDIAN_OCEAN_TERRITORY("IO", "246"),
    BRUNEI_DARUSSALAM("BN", "673"),
    BULGARIA("BG", "359"),
    BURKINA_FASO("BF", "226"),
    BURUNDI("BI", "257"),
    CAMBODIA("KH", "855"),
    CAMEROON("CM", "237"),
    CANADA(Profile.Country.CA, "1"),
    CAPE_VERDE("CV", "238"),
    CAYMAN_ISLANDS("KY", "1345"),
    CENTRAL_AFRICAN_REPUBLIC("CF", "236"),
    CHAD("TD", "235"),
    CHILE(Profile.Country.CL, "56"),
    CHINA(Profile.Country.CN, "86"),
    CHRISTMAS_ISLAND("CX", "61"),
    COCOS_ISLANDS("CC", "61"),
    COLOMBIA(Profile.Country.CO, "57"),
    COMOROS("KM", "269"),
    CONGO_BRAZZAVILLE("CG", "242"),
    COOK_ISLANDS("CK", "682"),
    COSTA_RICA("CR", "506"),
    CROATIA(Sensor.NAME_HR, "385"),
    CUBA("CU", "53"),
    CURACAO("CW", "5999"),
    CYPRUS("CY", "357"),
    CZECH_REPUBLIC("CZ", "420"),
    CONGO_KINSHASA("CD", "243"),
    DENMARK("DK", "45"),
    DJIBOUTI("DJ", "253"),
    DOMINICA("DM", "1767"),
    DOMINICAN_REPUBLIC("DO", "1849"),
    ECUADOR("EC", "593"),
    EGYPT("EG", "20"),
    EL_SALVADOR("SV", "503"),
    EQUATORIAL_GUINEA("GQ", "240"),
    ERITREA("ER", "291"),
    ESTONIA("EE", "372"),
    SWAZILAND("SZ", "268"),
    ETHIOPIA("ET", "251"),
    FALKLAND_ISLANDS("FK", "500"),
    FAROE_ISLANDS("FO", "298"),
    FIJI("FJ", "679"),
    FINLAND("FI", "358"),
    FRANCE(Profile.Country.FR, "33"),
    FRENCH_GUIANA("GF", "594"),
    FRENCH_POLYNESIA("PF", "689"),
    FRENCH_SOUTHERN_ANTARCTIC_LANDS("TF", "590"),
    GABON("GA", "241"),
    GAMBIA("GM", "220"),
    GEORGIA("GE", "995"),
    GERMANY("DE", "49"),
    GHANA("GH", "233"),
    GIBRALTAR("GI", "350"),
    GREECE("GR", "30"),
    GREENLAND("GL", "299"),
    GRENADA("GD", "1473"),
    GUADELOUPE("GP", "590"),
    GUAM("GU", "1671"),
    GUATEMALA("GT", "502"),
    GUERNSEY("GG", "44"),
    GUINEA("GN", "224"),
    GUINEA_BISSAU("GW", "245"),
    GUYANA("GY", "592"),
    HAITI("HT", "509"),
    HEARD_ISLANDS_MCDONALD_ISLANDS("HM", ""),
    HONDURAS("HN", "504"),
    HONG_KONG(Profile.Country.HK, "852"),
    HUNGARY("HU", "36"),
    ICELAND("IS", "354"),
    INDIA(Profile.Country.IN, "91"),
    INDONESIA("ID", "62"),
    IRAN("IR", "98"),
    IRAQ("IQ", "964"),
    IRELAND(Profile.Country.IE, "353"),
    ISLE_OF_MAN("IM", "44"),
    ISRAEL("IL", "972"),
    ITALY("IT", "39"),
    COTE_D_IVOIRE("CI", "225"),
    JAMAICA("JM", "1876"),
    JAPAN("JP", "81"),
    JERSEY("JE", "44"),
    JORDAN("JO", "962"),
    KAZAKHSTAN("KZ", "77"),
    KENYA("KE", "254"),
    KIRIBATI("KI", "686"),
    KOREA_NORTH("KP", "850"),
    KOREA_SOUTH("KR", "82"),
    KUWAIT(Profile.Country.KW, "965"),
    KYRGYZSTAN(ExpandedProductParsedResult.KILOGRAM, "996"),
    LAO_PDR("LA", "856"),
    LATVIA("LV", "371"),
    LEBANON(ExpandedProductParsedResult.POUND, "961"),
    LESOTHO("LS", "266"),
    LIBERIA("LR", "231"),
    LIBYA("LY", "218"),
    LIECHTENSTEIN("LI", "423"),
    LITHUANIA("LT", "370"),
    LUXEMBOURG("LU", "352"),
    MACAO("MO", "853"),
    MADAGASCAR("MG", "261"),
    MALAWI("MW", "265"),
    MALAYSIA(Profile.Country.MY, "60"),
    MALDIVES("MV", "960"),
    MALI("ML", "223"),
    MALTA("MT", "356"),
    MARSHALL_ISLANDS("MH", "692"),
    MARTINIQUE("MQ", "596"),
    MAURITANIA("MR", "222"),
    MAURITIUS("MU", "230"),
    MAYOTTE("YT", "262"),
    MEXICO(Profile.Country.MX, "52"),
    MICRONESIA("FM", "691"),
    MOLDOVA("MD", "373"),
    MONACO("MC", "377"),
    MONGOLIA("MN", "976"),
    MONTENEGRO("ME", "382"),
    MONTSERRAT("MS", "1664"),
    MOROCCO(RequestConfiguration.MAX_AD_CONTENT_RATING_MA, "212"),
    MOZAMBIQUE("MZ", "258"),
    MYANMAR("MM", "95"),
    NAMIBIA("NA", "264"),
    NAURU("NR", "674"),
    NEPAL("NP", "977"),
    NETHERLANDS("NL", "31"),
    NETHERLANDS_ANTILLES("AN", "599"),
    NEW_CALEDONIA("NC", "687"),
    NEW_ZEALAND(Profile.Country.NZ, "64"),
    NICARAGUA("NI", "505"),
    NIGER("NE", "227"),
    NIGERIA("NG", "234"),
    NIUE("NU", "683"),
    NORFOLK_ISLAND("NF", "672"),
    MACEDONIA("MK", "389"),
    NORTHERN_MARIANA_ISLANDS("MP", "1670"),
    NORWAY(Agent.MONO_INSTRUMENTATION_FLAG, "47"),
    OMAN("OM", "968"),
    PAKISTAN("PK", "92"),
    PALAU("PW", "680"),
    PANAMA("PA", "507"),
    PAPUA_NEW_GUINEA(RequestConfiguration.MAX_AD_CONTENT_RATING_PG, "675"),
    PARAGUAY("PY", "595"),
    PERU(Profile.Country.PE, "51"),
    PHILIPPINES("PH", "63"),
    PITCAIRN("PN", "872"),
    POLAND(Profile.Country.PL, "48"),
    PORTUGAL("PT", "351"),
    PUERTO_RICO("PR", "1939"),
    QATAR(Profile.Country.QA, "974"),
    REUNION("RE", "262"),
    RO("RO", "40"),
    ROMANIA("RU", "7"),
    RWANDA("RW", "250"),
    SAINT_BARTHELEMY("BL", "590"),
    SAINT_HELENA("SH", "290"),
    SAINT_KITTS_AND_NEVIS("KN", "1869"),
    SAINT_LUCIA("LC", "1758"),
    SAINT_MARTIN("MF", "590"),
    SAINT_PIERRE_AND_MIQUELON("PM", "508"),
    SAINT_VINCENT_AND_GRENADINES("VC", "1784"),
    SAMOA("WS", "685"),
    SAN_MARINO("SM", "378"),
    SAO_TOME_AND_PRINCIPE("ST", "239"),
    SAUDI_ARABIA(Profile.Country.SA, "966"),
    SENEGAL("SN", "221"),
    SERBIA("RS", "381"),
    SEYCHELLES("SC", "248"),
    SIERRA_LEONE("SL", "232"),
    SINGAPORE(Profile.Country.SG, "65"),
    SINT_MAARTEN("SX", "1721"),
    SLOVAKIA("SK", "421"),
    SLOVENIA("SI", "386"),
    SOLOMON_ISLANDS("SB", "677"),
    SOMALIA("SO", "252"),
    SOUTH_AFRICA(Profile.Country.ZA, "27"),
    SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("GS", "500"),
    SOUTH_SUDAN("SS", "211"),
    SPAIN(Profile.Country.ES, "34"),
    SRI_LANKA("LK", "94"),
    SUDAN("SD", "249"),
    SURINAME("SR", "597"),
    SVALBARD_AND_JAN_MAYEN_ISLANDS("SJ", "47"),
    SWEDEN("SE", "46"),
    SWITZERLAND("CH", "41"),
    SYRIA("SY", "963"),
    TAIWAN("TW", "886"),
    TAJIKISTAN("TJ", "992"),
    TANZANIA("TZ", "255"),
    THAILAND("TH", "66"),
    TIMOR_LESTE("TL", "670"),
    TOGO("TG", "228"),
    TOKELAU("TK", "690"),
    TONGA("TO", "676"),
    TRINIDAD_AND_TOBAGO("TT", "1868"),
    TRISTAN_DA_CUNHA("TA", "2908"),
    TUNISIA("TN", "216"),
    TURKEY("TR", "90"),
    TURKMENISTAN("TM", "993"),
    TURKS_AND_CAICOS_ISLANDS("TC", "1649"),
    TUVALU("TV", "688"),
    UGANDA("UG", "256"),
    UKRAINE(Profile.Country.UA, "380"),
    UNITED_ARAB_EMIRATES(Profile.Country.AE, "971"),
    UNITED_KINGDOM(Profile.Country.GB, "44"),
    UNITED_STATES_OF_AMERICA(Profile.Country.US, "1"),
    US_MINOR_OUTLYING_ISLANDS("UM", "246"),
    URUGUAY("UY", "598"),
    UZBEKISTAN("UZ", "998"),
    VANUATU("VU", "678"),
    VATICAN_CITY("VA", "379"),
    VENEZUELA("VE", "58"),
    VIETNAM("VN", "84"),
    BRITISH_VIRGIN_ISLANDS("VG", "1284"),
    VIRGIN_ISLANDS("VI", "1340"),
    WALLIS_AND_FUTUNA_ISLANDS("WF", "681"),
    WESTERN_SAHARA("EH", "2125288"),
    YEMEN("YE", "967"),
    ZAMBIA("ZM", "260"),
    ZIMBABWE("ZW", "263"),
    INVALID_COUNTRY("", "");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String dialingCode;
    @NotNull
    private final String iso3166Alpha2;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/checkout/base/model/Country$Companion;", "", "()V", "from", "Lcom/checkout/base/model/Country;", "iso3166Alpha2", "", "getCountryFromDialingCode", "dialingCode", "getCountryFromDialingCode$checkout_release", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Country from(@NotNull String str) {
            Country country;
            Intrinsics.checkNotNullParameter(str, "iso3166Alpha2");
            Country[] values = Country.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    country = null;
                    break;
                }
                country = values[i11];
                if (StringsKt__StringsJVMKt.equals(country.getIso3166Alpha2(), str, true)) {
                    break;
                }
                i11++;
            }
            if (country == null) {
                return Country.INVALID_COUNTRY;
            }
            return country;
        }

        @NotNull
        public final Country getCountryFromDialingCode$checkout_release(@NotNull String str) {
            Country country;
            Intrinsics.checkNotNullParameter(str, "dialingCode");
            Country[] values = Country.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    country = null;
                    break;
                }
                country = values[i11];
                if (StringsKt__StringsJVMKt.equals(country.getDialingCode(), str, true)) {
                    break;
                }
                i11++;
            }
            if (country == null) {
                return Country.INVALID_COUNTRY;
            }
            return country;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Country(String str, String str2) {
        this.iso3166Alpha2 = str;
        this.dialingCode = str2;
    }

    @JvmStatic
    @NotNull
    public static final Country from(@NotNull String str) {
        return Companion.from(str);
    }

    @NotNull
    public final String getDialingCode() {
        return this.dialingCode;
    }

    @NotNull
    public final String getIso3166Alpha2() {
        return this.iso3166Alpha2;
    }
}
