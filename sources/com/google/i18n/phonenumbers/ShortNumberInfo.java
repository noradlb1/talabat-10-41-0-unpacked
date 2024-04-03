package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.google.i18n.phonenumbers.metadata.source.RegionMetadataSource;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShortNumberInfo {
    private static final ShortNumberInfo INSTANCE = new ShortNumberInfo(RegexBasedMatcher.create(), DefaultMetadataDependenciesProvider.getInstance().getShortNumberMetadataSource());
    private static final Set<String> REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT;
    private static final Logger logger = Logger.getLogger(ShortNumberInfo.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap();
    private final MatcherApi matcherApi;
    private final RegionMetadataSource shortNumberMetadataSource;

    /* renamed from: com.google.i18n.phonenumbers.ShortNumberInfo$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost[] r0 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost = r0
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.PREMIUM_RATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.UNKNOWN_COST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.STANDARD_RATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.TOLL_FREE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.ShortNumberInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ShortNumberCost {
        TOLL_FREE,
        STANDARD_RATE,
        PREMIUM_RATE,
        UNKNOWN_COST
    }

    static {
        HashSet hashSet = new HashSet();
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = hashSet;
        hashSet.add(Profile.Country.BR);
        hashSet.add(Profile.Country.CL);
        hashSet.add("NI");
    }

    public ShortNumberInfo(MatcherApi matcherApi2, RegionMetadataSource regionMetadataSource) {
        this.matcherApi = matcherApi2;
        this.shortNumberMetadataSource = regionMetadataSource;
    }

    public static ShortNumberInfo getInstance() {
        return INSTANCE;
    }

    private static String getNationalSignificantNumber(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder sb2 = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb2.append(new String(cArr));
        }
        sb2.append(phoneNumber.getNationalNumber());
        return sb2.toString();
    }

    private String getRegionCodeForShortNumberFromRegionList(Phonenumber.PhoneNumber phoneNumber, List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String next : list) {
            Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = getShortNumberMetadataForRegion(next);
            if (shortNumberMetadataForRegion != null && matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getShortCode())) {
                return next;
            }
        }
        return null;
    }

    private List<String> getRegionCodesForCountryCode(int i11) {
        List list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i11));
        if (list == null) {
            list = new ArrayList(0);
        }
        return Collections.unmodifiableList(list);
    }

    private Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.shortNumberMetadataSource.getMetadataForRegion(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private boolean matchesEmergencyNumberHelper(CharSequence charSequence, String str, boolean z11) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        CharSequence extractPossibleNumber = PhoneNumberUtil.extractPossibleNumber(charSequence);
        boolean z12 = false;
        if (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(extractPossibleNumber).lookingAt() || (shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str)) == null || !shortNumberMetadataForRegion.hasEmergency()) {
            return false;
        }
        String normalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(extractPossibleNumber);
        if (z11 && !REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.contains(str)) {
            z12 = true;
        }
        return this.matcherApi.matchNationalNumber(normalizeDigitsOnly, shortNumberMetadataForRegion.getEmergency(), z12);
    }

    private boolean matchesPossibleNumberAndNationalNumber(String str, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        if (phoneNumberDesc.getPossibleLengthCount() <= 0 || phoneNumberDesc.getPossibleLengthList().contains(Integer.valueOf(str.length()))) {
            return this.matcherApi.matchNationalNumber(str, phoneNumberDesc, false);
        }
        return false;
    }

    private boolean regionDialingFromMatchesNumber(Phonenumber.PhoneNumber phoneNumber, String str) {
        return getRegionCodesForCountryCode(phoneNumber.getCountryCode()).contains(str);
    }

    public boolean connectsToEmergencyNumber(String str, String str2) {
        return matchesEmergencyNumberHelper(str, str2, true);
    }

    public String getExampleShortNumber(String str) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return "";
        }
        Phonemetadata.PhoneNumberDesc shortCode = shortNumberMetadataForRegion.getShortCode();
        if (shortCode.hasExampleNumber()) {
            return shortCode.getExampleNumber();
        }
        return "";
    }

    public String getExampleShortNumberForCost(String str, ShortNumberCost shortNumberCost) {
        Phonemetadata.PhoneNumberDesc phoneNumberDesc;
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return "";
        }
        int i11 = AnonymousClass1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[shortNumberCost.ordinal()];
        if (i11 == 1) {
            phoneNumberDesc = shortNumberMetadataForRegion.getPremiumRate();
        } else if (i11 == 3) {
            phoneNumberDesc = shortNumberMetadataForRegion.getStandardRate();
        } else if (i11 != 4) {
            phoneNumberDesc = null;
        } else {
            phoneNumberDesc = shortNumberMetadataForRegion.getTollFree();
        }
        if (phoneNumberDesc == null || !phoneNumberDesc.hasExampleNumber()) {
            return "";
        }
        return phoneNumberDesc.getExampleNumber();
    }

    public ShortNumberCost getExpectedCost(Phonenumber.PhoneNumber phoneNumber) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        if (regionCodesForCountryCode.size() == 0) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (regionCodesForCountryCode.size() == 1) {
            return getExpectedCostForRegion(phoneNumber, regionCodesForCountryCode.get(0));
        }
        ShortNumberCost shortNumberCost = ShortNumberCost.TOLL_FREE;
        for (String expectedCostForRegion : regionCodesForCountryCode) {
            ShortNumberCost expectedCostForRegion2 = getExpectedCostForRegion(phoneNumber, expectedCostForRegion);
            int i11 = AnonymousClass1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[expectedCostForRegion2.ordinal()];
            if (i11 == 1) {
                return ShortNumberCost.PREMIUM_RATE;
            }
            if (i11 == 2) {
                shortNumberCost = ShortNumberCost.UNKNOWN_COST;
            } else if (i11 != 3) {
                if (i11 != 4) {
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    logger2.log(level, "Unrecognised cost for region: " + expectedCostForRegion2);
                }
            } else if (shortNumberCost != ShortNumberCost.UNKNOWN_COST) {
                shortNumberCost = ShortNumberCost.STANDARD_RATE;
            }
        }
        return shortNumberCost;
    }

    public ShortNumberCost getExpectedCostForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (!regionDialingFromMatchesNumber(phoneNumber, str)) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!shortNumberMetadataForRegion.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(nationalSignificantNumber.length()))) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getPremiumRate())) {
            return ShortNumberCost.PREMIUM_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getStandardRate())) {
            return ShortNumberCost.STANDARD_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getTollFree())) {
            return ShortNumberCost.TOLL_FREE;
        }
        if (isEmergencyNumber(nationalSignificantNumber, str)) {
            return ShortNumberCost.TOLL_FREE;
        }
        return ShortNumberCost.UNKNOWN_COST;
    }

    public boolean isCarrierSpecific(Phonenumber.PhoneNumber phoneNumber) {
        String regionCodeForShortNumberFromRegionList = getRegionCodeForShortNumberFromRegionList(phoneNumber, getRegionCodesForCountryCode(phoneNumber.getCountryCode()));
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = getShortNumberMetadataForRegion(regionCodeForShortNumberFromRegionList);
        if (shortNumberMetadataForRegion == null || !matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getCarrierSpecific())) {
            return false;
        }
        return true;
    }

    public boolean isCarrierSpecificForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (!regionDialingFromMatchesNumber(phoneNumber, str)) {
            return false;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null || !matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getCarrierSpecific())) {
            return false;
        }
        return true;
    }

    public boolean isEmergencyNumber(CharSequence charSequence, String str) {
        return matchesEmergencyNumberHelper(charSequence, str, false);
    }

    public boolean isPossibleShortNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        int length = getNationalSignificantNumber(phoneNumber).length();
        for (String shortNumberMetadataForRegion : regionCodesForCountryCode) {
            Phonemetadata.PhoneMetadata shortNumberMetadataForRegion2 = getShortNumberMetadataForRegion(shortNumberMetadataForRegion);
            if (shortNumberMetadataForRegion2 != null && shortNumberMetadataForRegion2.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(length))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleShortNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        if (!regionDialingFromMatchesNumber(phoneNumber, str) || (shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str)) == null) {
            return false;
        }
        return shortNumberMetadataForRegion.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(getNationalSignificantNumber(phoneNumber).length()));
    }

    public boolean isSmsServiceForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        if (regionDialingFromMatchesNumber(phoneNumber, str) && (shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str)) != null && matchesPossibleNumberAndNationalNumber(getNationalSignificantNumber(phoneNumber), shortNumberMetadataForRegion.getSmsServices())) {
            return true;
        }
        return false;
    }

    public boolean isValidShortNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        String regionCodeForShortNumberFromRegionList = getRegionCodeForShortNumberFromRegionList(phoneNumber, regionCodesForCountryCode);
        if (regionCodesForCountryCode.size() <= 1 || regionCodeForShortNumberFromRegionList == null) {
            return isValidShortNumberForRegion(phoneNumber, regionCodeForShortNumberFromRegionList);
        }
        return true;
    }

    public boolean isValidShortNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        if (!regionDialingFromMatchesNumber(phoneNumber, str) || (shortNumberMetadataForRegion = getShortNumberMetadataForRegion(str)) == null) {
            return false;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getGeneralDesc())) {
            return false;
        }
        return matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getShortCode());
    }
}
