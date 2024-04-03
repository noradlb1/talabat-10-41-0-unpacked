package com.google.i18n.phonenumbers;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberMatcher;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.internal.RegexCache;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.google.i18n.phonenumbers.metadata.source.MetadataSource;
import com.google.i18n.phonenumbers.metadata.source.MetadataSourceImpl;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
    private static final String CC_STRING = "$CC";
    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final String DIGITS = "\\p{Nd}";
    private static final Pattern EXTN_PATTERN;
    static final String EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(false);
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final String FG_STRING = "$FG";
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    private static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    private static final Set<Integer> GEO_MOBILE_COUNTRIES;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES;
    private static final int MAX_INPUT_STRING_LENGTH = 250;
    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    static final int MAX_LENGTH_FOR_NSN = 17;
    private static final int MIN_LENGTH_FOR_NSN = 2;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    private static final int NANPA_COUNTRY_CODE = 1;
    static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    private static final String NP_STRING = "$NP";
    static final String PLUS_CHARS = "+＋";
    static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
    static final char PLUS_SIGN = '+';
    static final int REGEX_FLAGS = 66;
    public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
    private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
    private static final String RFC3966_PREFIX = "tel:";
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    private static final Pattern SINGLE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    private static final char STAR_SIGN = '*';
    private static final String UNKNOWN_REGION = "ZZ";
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    static final String VALID_PUNCTUATION = "-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～";
    private static final String VALID_START_CHAR = "[+＋\\p{Nd}]";
    private static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
    private static PhoneNumberUtil instance = null;
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();
    private final MatcherApi matcherApi = RegexBasedMatcher.create();
    private final MetadataSource metadataSource;
    private final Set<String> nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Set<String> supportedRegions = new HashSet(320);

    /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat;
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType;
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource;

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(2:27|28)|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|(3:47|48|50)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(2:27|28)|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|(3:47|48|50)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00c4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00d8 */
        static {
            /*
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType[] r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType = r0
                r1 = 1
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PREMIUM_RATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r3 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.TOLL_FREE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.SHARED_COST     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOIP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PERSONAL_NUMBER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PAGER     // Catch:{ NoSuchFieldError -> 0x006c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r6 = 9
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.UAN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r6 = 10
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOICEMAIL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r6 = 11
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat[] r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat = r4
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat     // Catch:{ NoSuchFieldError -> 0x009f }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL     // Catch:{ NoSuchFieldError -> 0x009f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat     // Catch:{ NoSuchFieldError -> 0x00a9 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.RFC3966     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r4 = $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat     // Catch:{ NoSuchFieldError -> 0x00b3 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource[] r4 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource = r4
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r5 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN     // Catch:{ NoSuchFieldError -> 0x00c4 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c4 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00c4 }
            L_0x00c4:
                int[] r1 = $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r4 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r0 = $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r1 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource     // Catch:{ NoSuchFieldError -> 0x00e2 }
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r1 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY     // Catch:{ NoSuchFieldError -> 0x00e2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e2 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00e2 }
            L_0x00e2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.AnonymousClass2.<clinit>():void");
        }
    }

    public enum Leniency {
        POSSIBLE {
            public boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                return phoneNumberUtil.isPossibleNumber(phoneNumber);
            }
        },
        VALID {
            public boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                if (!phoneNumberUtil.isValidNumber(phoneNumber) || !PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, charSequence.toString(), phoneNumberUtil)) {
                    return false;
                }
                return PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil);
            }
        },
        STRICT_GROUPING {
            public boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                String charSequence2 = charSequence.toString();
                if (!phoneNumberUtil.isValidNumber(phoneNumber) || !PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, charSequence2, phoneNumberUtil) || PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(phoneNumber, charSequence2) || !PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil)) {
                    return false;
                }
                return phoneNumberMatcher.checkNumberGroupingIsValid(phoneNumber, charSequence, phoneNumberUtil, new PhoneNumberMatcher.NumberGroupingChecker() {
                    public boolean checkGroups(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb2, String[] strArr) {
                        return PhoneNumberMatcher.allNumberGroupsRemainGrouped(phoneNumberUtil, phoneNumber, sb2, strArr);
                    }
                });
            }
        },
        EXACT_GROUPING {
            public boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                String charSequence2 = charSequence.toString();
                if (!phoneNumberUtil.isValidNumber(phoneNumber) || !PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, charSequence2, phoneNumberUtil) || PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(phoneNumber, charSequence2) || !PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil)) {
                    return false;
                }
                return phoneNumberMatcher.checkNumberGroupingIsValid(phoneNumber, charSequence, phoneNumberUtil, new PhoneNumberMatcher.NumberGroupingChecker() {
                    public boolean checkGroups(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb2, String[] strArr) {
                        return PhoneNumberMatcher.allNumberGroupsAreExactlyPresent(phoneNumberUtil, phoneNumber, sb2, strArr);
                    }
                });
            }
        };

        public abstract boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher);
    }

    public enum MatchType {
        NOT_A_NUMBER,
        NO_MATCH,
        SHORT_NSN_MATCH,
        NSN_MATCH,
        EXACT_MATCH
    }

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum ValidationResult {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(54, "9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        GEO_MOBILE_COUNTRIES = Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        Character valueOf = Character.valueOf(ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK);
        hashMap2.put(valueOf, valueOf);
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        Map<Character, Character> unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        ALPHA_MAPPINGS = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        hashMap5.put('*', '*');
        hashMap5.put('#', '#');
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character charValue : unmodifiableMap.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap6.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put(Character.valueOf(SignatureVisitor.SUPER), Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(65293, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(8208, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(8209, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(8210, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(Character.valueOf(Typography.ndash), Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(Character.valueOf(Typography.mdash), Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(8213, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(8722, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put('/', '/');
        hashMap6.put(65295, '/');
        hashMap6.put(' ', ' ');
        hashMap6.put(12288, ' ');
        hashMap6.put(8288, ' ');
        hashMap6.put('.', '.');
        hashMap6.put(65294, '.');
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(hashMap6);
        StringBuilder sb2 = new StringBuilder();
        Map<Character, Character> map = ALPHA_MAPPINGS;
        sb2.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb2.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String sb3 = sb2.toString();
        VALID_ALPHA = sb3;
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*" + sb3 + DIGITS + "]*";
        VALID_PHONE_NUMBER = str;
        String createExtnPattern = createExtnPattern(true);
        EXTN_PATTERNS_FOR_PARSING = createExtnPattern;
        EXTN_PATTERN = Pattern.compile("(?:" + createExtnPattern + ")$", 66);
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(str + "(?:" + createExtnPattern + ")?", 66);
    }

    public PhoneNumberUtil(MetadataSource metadataSource2, Map<Integer, List<String>> map) {
        this.metadataSource = metadataSource2;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Map.Entry next : map.entrySet()) {
            List list = (List) next.getValue();
            if (list.size() != 1 || !"001".equals(list.get(0))) {
                this.supportedRegions.addAll(list);
            } else {
                this.countryCodesForNonGeographicalRegion.add(next.getKey());
            }
        }
        if (this.supportedRegions.remove("001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll(map.get(1));
    }

    private void buildNationalNumberForParsing(String str, StringBuilder sb2) {
        int i11;
        int indexOf = str.indexOf(RFC3966_PHONE_CONTEXT);
        if (indexOf >= 0) {
            int i12 = indexOf + 15;
            if (i12 < str.length() - 1 && str.charAt(i12) == '+') {
                int indexOf2 = str.indexOf(59, i12);
                if (indexOf2 > 0) {
                    sb2.append(str.substring(i12, indexOf2));
                } else {
                    sb2.append(str.substring(i12));
                }
            }
            int indexOf3 = str.indexOf(RFC3966_PREFIX);
            if (indexOf3 >= 0) {
                i11 = indexOf3 + 4;
            } else {
                i11 = 0;
            }
            sb2.append(str.substring(i11, indexOf));
        } else {
            sb2.append(extractPossibleNumber(str));
        }
        int indexOf4 = sb2.indexOf(RFC3966_ISDN_SUBADDRESS);
        if (indexOf4 > 0) {
            sb2.delete(indexOf4, sb2.length());
        }
    }

    private boolean checkRegionForParsing(CharSequence charSequence, String str) {
        if (isValidRegionCode(str)) {
            return true;
        }
        if (charSequence == null || charSequence.length() == 0 || !PLUS_CHARS_PATTERN.matcher(charSequence).lookingAt()) {
            return false;
        }
        return true;
    }

    public static String convertAlphaCharactersInNumber(CharSequence charSequence) {
        return normalizeHelper(charSequence, ALPHA_PHONE_MAPPINGS, false);
    }

    private static Phonenumber.PhoneNumber copyCoreFieldsOnly(Phonenumber.PhoneNumber phoneNumber) {
        Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
        phoneNumber2.setCountryCode(phoneNumber.getCountryCode());
        phoneNumber2.setNationalNumber(phoneNumber.getNationalNumber());
        if (phoneNumber.getExtension().length() > 0) {
            phoneNumber2.setExtension(phoneNumber.getExtension());
        }
        if (phoneNumber.isItalianLeadingZero()) {
            phoneNumber2.setItalianLeadingZero(true);
            phoneNumber2.setNumberOfLeadingZeros(phoneNumber.getNumberOfLeadingZeros());
        }
        return phoneNumber2;
    }

    private static String createExtnPattern(boolean z11) {
        String str = (RFC3966_EXTN_PREFIX + extnDigits(20)) + "|" + ("[  \\t,]*" + "(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|anexo)" + "[:\\.．]?[  \\t,-]*" + extnDigits(20) + "#?") + "|" + ("[  \\t,]*" + "(?:[xｘ#＃~～]|int|ｉｎｔ)" + "[:\\.．]?[  \\t,-]*" + extnDigits(9) + "#?") + "|" + ("[- ]+" + extnDigits(6) + "#");
        if (!z11) {
            return str;
        }
        return str + "|" + ("[  \\t]*" + "(?:,{2}|;)" + "[:\\.．]?[  \\t,-]*" + extnDigits(15) + "#?") + "|" + ("[  \\t]*" + "(?:,)+" + "[:\\.．]?[  \\t,-]*" + extnDigits(9) + "#?");
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader != null) {
            return createInstance((MetadataSource) new MetadataSourceImpl(DefaultMetadataDependenciesProvider.getInstance().getPhoneNumberMetadataFileNameProvider(), metadataLoader, DefaultMetadataDependenciesProvider.getInstance().getMetadataParser()));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static boolean descHasData(Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        if (phoneNumberDesc.hasExampleNumber() || descHasPossibleNumberData(phoneNumberDesc) || phoneNumberDesc.hasNationalNumberPattern()) {
            return true;
        }
        return false;
    }

    private static boolean descHasPossibleNumberData(Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        return (phoneNumberDesc.getPossibleLengthCount() == 1 && phoneNumberDesc.getPossibleLength(0) == -1) ? false : true;
    }

    private static void ensureMetadataIsNonNull(Phonemetadata.PhoneMetadata phoneMetadata, String str) {
        if (phoneMetadata == null) {
            throw new MissingMetadataException(str);
        }
    }

    private static String extnDigits(int i11) {
        return "(\\p{Nd}{1," + i11 + "})";
    }

    public static CharSequence extractPossibleNumber(CharSequence charSequence) {
        Matcher matcher = VALID_START_CHAR_PATTERN.matcher(charSequence);
        if (!matcher.find()) {
            return "";
        }
        CharSequence subSequence = charSequence.subSequence(matcher.start(), charSequence.length());
        Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(subSequence);
        if (matcher2.find()) {
            subSequence = subSequence.subSequence(0, matcher2.start());
        }
        Matcher matcher3 = SECOND_NUMBER_START_PATTERN.matcher(subSequence);
        if (matcher3.find()) {
            return subSequence.subSequence(0, matcher3.start());
        }
        return subSequence;
    }

    private String formatNsn(String str, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return formatNsn(str, phoneMetadata, phoneNumberFormat, (CharSequence) null);
    }

    public static boolean formattingRuleHasFirstGroupOnly(String str) {
        if (str.length() == 0 || FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    private int getCountryCodeForValidRegion(String str) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion != null) {
            return metadataForRegion.getCountryCode();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    public static String getCountryMobileToken(int i11) {
        Map<Integer, String> map = MOBILE_TOKEN_MAPPINGS;
        if (map.containsKey(Integer.valueOf(i11))) {
            return map.get(Integer.valueOf(i11));
        }
        return "";
    }

    public static synchronized PhoneNumberUtil getInstance() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            if (instance == null) {
                setInstance(createInstance(DefaultMetadataDependenciesProvider.getInstance().getMetadataLoader()));
            }
            phoneNumberUtil = instance;
        }
        return phoneNumberUtil;
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegionOrCallingCode(int i11, String str) {
        if ("001".equals(str)) {
            return getMetadataForNonGeographicalRegion(i11);
        }
        return getMetadataForRegion(str);
    }

    private PhoneNumberType getNumberTypeHelper(String str, Phonemetadata.PhoneMetadata phoneMetadata) {
        if (!isNumberMatchingDesc(str, phoneMetadata.getGeneralDesc())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPremiumRate())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getTollFree())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getSharedCost())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getVoip())) {
            return PhoneNumberType.VOIP;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPersonalNumber())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPager())) {
            return PhoneNumberType.PAGER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getUan())) {
            return PhoneNumberType.UAN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getVoicemail())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getFixedLine())) {
            if (phoneMetadata.getSameMobileAndFixedLinePattern()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (isNumberMatchingDesc(str, phoneMetadata.getMobile())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        } else if (phoneMetadata.getSameMobileAndFixedLinePattern() || !isNumberMatchingDesc(str, phoneMetadata.getMobile())) {
            return PhoneNumberType.UNKNOWN;
        } else {
            return PhoneNumberType.MOBILE;
        }
    }

    private String getRegionCodeForNumberFromRegionList(Phonenumber.PhoneNumber phoneNumber, List<String> list) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String next : list) {
            Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(next);
            if (metadataForRegion.hasLeadingDigits()) {
                if (this.regexCache.getPatternForRegex(metadataForRegion.getLeadingDigits()).matcher(nationalSignificantNumber).lookingAt()) {
                    return next;
                }
            } else if (getNumberTypeHelper(nationalSignificantNumber, metadataForRegion) != PhoneNumberType.UNKNOWN) {
                return next;
            }
        }
        return null;
    }

    private Set<PhoneNumberType> getSupportedTypesForMetadata(Phonemetadata.PhoneMetadata phoneMetadata) {
        TreeSet treeSet = new TreeSet();
        for (PhoneNumberType phoneNumberType : PhoneNumberType.values()) {
            if (!(phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE || phoneNumberType == PhoneNumberType.UNKNOWN || !descHasData(getNumberDescByType(phoneMetadata, phoneNumberType)))) {
                treeSet.add(phoneNumberType);
            }
        }
        return Collections.unmodifiableSet(treeSet);
    }

    private boolean hasFormattingPatternForNumber(Phonenumber.PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        if (metadataForRegionOrCallingCode == null) {
            return false;
        }
        if (chooseFormattingPatternForNumber(metadataForRegionOrCallingCode.getNumberFormatList(), getNationalSignificantNumber(phoneNumber)) != null) {
            return true;
        }
        return false;
    }

    private boolean hasValidCountryCallingCode(int i11) {
        return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i11));
    }

    private boolean isNationalNumberSuffixOfTheOther(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        String valueOf = String.valueOf(phoneNumber.getNationalNumber());
        String valueOf2 = String.valueOf(phoneNumber2.getNationalNumber());
        if (valueOf.endsWith(valueOf2) || valueOf2.endsWith(valueOf)) {
            return true;
        }
        return false;
    }

    private boolean isValidRegionCode(String str) {
        return str != null && this.supportedRegions.contains(str);
    }

    public static boolean isViablePhoneNumber(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(charSequence).matches();
    }

    private void maybeAppendFormattedExtension(Phonenumber.PhoneNumber phoneNumber, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder sb2) {
        if (phoneNumber.hasExtension() && phoneNumber.getExtension().length() > 0) {
            if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                sb2.append(RFC3966_EXTN_PREFIX);
                sb2.append(phoneNumber.getExtension());
            } else if (phoneMetadata.hasPreferredExtnPrefix()) {
                sb2.append(phoneMetadata.getPreferredExtnPrefix());
                sb2.append(phoneNumber.getExtension());
            } else {
                sb2.append(DEFAULT_EXTN_PREFIX);
                sb2.append(phoneNumber.getExtension());
            }
        }
    }

    public static StringBuilder normalize(StringBuilder sb2) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(sb2).matches()) {
            sb2.replace(0, sb2.length(), normalizeHelper(sb2, ALPHA_PHONE_MAPPINGS, true));
        } else {
            sb2.replace(0, sb2.length(), normalizeDigitsOnly(sb2));
        }
        return sb2;
    }

    public static String normalizeDiallableCharsOnly(CharSequence charSequence) {
        return normalizeHelper(charSequence, DIALLABLE_CHAR_MAPPINGS, true);
    }

    public static StringBuilder normalizeDigits(CharSequence charSequence, boolean z11) {
        StringBuilder sb2 = new StringBuilder(charSequence.length());
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            char charAt = charSequence.charAt(i11);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb2.append(digit);
            } else if (z11) {
                sb2.append(charAt);
            }
        }
        return sb2;
    }

    public static String normalizeDigitsOnly(CharSequence charSequence) {
        return normalizeDigits(charSequence, false).toString();
    }

    private static String normalizeHelper(CharSequence charSequence, Map<Character, Character> map, boolean z11) {
        StringBuilder sb2 = new StringBuilder(charSequence.length());
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            char charAt = charSequence.charAt(i11);
            Character ch2 = map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch2 != null) {
                sb2.append(ch2);
            } else if (!z11) {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    private void parseHelper(CharSequence charSequence, String str, boolean z11, boolean z12, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        int i11;
        if (charSequence == null) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (charSequence.length() <= 250) {
            StringBuilder sb2 = new StringBuilder();
            String charSequence2 = charSequence.toString();
            buildNationalNumberForParsing(charSequence2, sb2);
            if (!isViablePhoneNumber(sb2)) {
                throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!z12 || checkRegionForParsing(sb2, str)) {
                if (z11) {
                    phoneNumber.setRawInput(charSequence2);
                }
                String maybeStripExtension = maybeStripExtension(sb2);
                if (maybeStripExtension.length() > 0) {
                    phoneNumber.setExtension(maybeStripExtension);
                }
                Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
                StringBuilder sb3 = new StringBuilder();
                try {
                    i11 = maybeExtractCountryCode(sb2, metadataForRegion, sb3, z11, phoneNumber);
                } catch (NumberParseException e11) {
                    Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb2);
                    if (e11.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE || !matcher.lookingAt()) {
                        throw new NumberParseException(e11.getErrorType(), e11.getMessage());
                    }
                    i11 = maybeExtractCountryCode(sb2.substring(matcher.end()), metadataForRegion, sb3, z11, phoneNumber);
                    if (i11 == 0) {
                        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                    }
                }
                if (i11 != 0) {
                    String regionCodeForCountryCode = getRegionCodeForCountryCode(i11);
                    if (!regionCodeForCountryCode.equals(str)) {
                        metadataForRegion = getMetadataForRegionOrCallingCode(i11, regionCodeForCountryCode);
                    }
                } else {
                    sb3.append(normalize(sb2));
                    if (str != null) {
                        phoneNumber.setCountryCode(metadataForRegion.getCountryCode());
                    } else if (z11) {
                        phoneNumber.clearCountryCodeSource();
                    }
                }
                if (sb3.length() >= 2) {
                    if (metadataForRegion != null) {
                        StringBuilder sb4 = new StringBuilder();
                        StringBuilder sb5 = new StringBuilder(sb3);
                        maybeStripNationalPrefixAndCarrierCode(sb5, metadataForRegion, sb4);
                        ValidationResult testNumberLength = testNumberLength(sb5, metadataForRegion);
                        if (!(testNumberLength == ValidationResult.TOO_SHORT || testNumberLength == ValidationResult.IS_POSSIBLE_LOCAL_ONLY || testNumberLength == ValidationResult.INVALID_LENGTH)) {
                            if (z11 && sb4.length() > 0) {
                                phoneNumber.setPreferredDomesticCarrierCode(sb4.toString());
                            }
                            sb3 = sb5;
                        }
                    }
                    int length = sb3.length();
                    if (length < 2) {
                        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                    } else if (length <= 17) {
                        setItalianLeadingZerosForPhoneNumber(sb3, phoneNumber);
                        phoneNumber.setNationalNumber(Long.parseLong(sb3.toString()));
                    } else {
                        throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                    }
                } else {
                    throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
            } else {
                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        } else {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
    }

    private boolean parsePrefixAsIdd(Pattern pattern, StringBuilder sb2) {
        Matcher matcher = pattern.matcher(sb2);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = CAPTURING_DIGIT_PATTERN.matcher(sb2.substring(end));
        if (matcher2.find() && normalizeDigitsOnly(matcher2.group(1)).equals("0")) {
            return false;
        }
        sb2.delete(0, end);
        return true;
    }

    private void prefixNumberWithCountryCallingCode(int i11, PhoneNumberFormat phoneNumberFormat, StringBuilder sb2) {
        int i12 = AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[phoneNumberFormat.ordinal()];
        if (i12 == 1) {
            sb2.insert(0, i11).insert(0, '+');
        } else if (i12 == 2) {
            sb2.insert(0, " ").insert(0, i11).insert(0, '+');
        } else if (i12 == 3) {
            sb2.insert(0, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE).insert(0, i11).insert(0, '+').insert(0, RFC3966_PREFIX);
        }
    }

    private boolean rawInputContainsNationalPrefix(String str, String str2, String str3) {
        String normalizeDigitsOnly = normalizeDigitsOnly(str);
        if (normalizeDigitsOnly.startsWith(str2)) {
            try {
                return isValidNumber(parse(normalizeDigitsOnly.substring(str2.length()), str3));
            } catch (NumberParseException unused) {
            }
        }
        return false;
    }

    public static synchronized void setInstance(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            instance = phoneNumberUtil;
        }
    }

    public static void setItalianLeadingZerosForPhoneNumber(CharSequence charSequence, Phonenumber.PhoneNumber phoneNumber) {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '0') {
            phoneNumber.setItalianLeadingZero(true);
            int i11 = 1;
            while (i11 < charSequence.length() - 1 && charSequence.charAt(i11) == '0') {
                i11++;
            }
            if (i11 != 1) {
                phoneNumber.setNumberOfLeadingZeros(i11);
            }
        }
    }

    private ValidationResult testNumberLength(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata) {
        return testNumberLength(charSequence, phoneMetadata, PhoneNumberType.UNKNOWN);
    }

    public boolean canBeInternationallyDialled(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(getRegionCodeForNumber(phoneNumber));
        if (metadataForRegion == null) {
            return true;
        }
        return !isNumberMatchingDesc(getNationalSignificantNumber(phoneNumber), metadataForRegion.getNoInternationalDialling());
    }

    public Phonemetadata.NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata.NumberFormat> list, String str) {
        for (Phonemetadata.NumberFormat next : list) {
            int leadingDigitsPatternCount = next.getLeadingDigitsPatternCount();
            if ((leadingDigitsPatternCount == 0 || this.regexCache.getPatternForRegex(next.getLeadingDigitsPattern(leadingDigitsPatternCount - 1)).matcher(str).lookingAt()) && this.regexCache.getPatternForRegex(next.getPattern()).matcher(str).matches()) {
                return next;
            }
        }
        return null;
    }

    public int extractCountryCode(StringBuilder sb2, StringBuilder sb3) {
        if (!(sb2.length() == 0 || sb2.charAt(0) == '0')) {
            int length = sb2.length();
            int i11 = 1;
            while (i11 <= 3 && i11 <= length) {
                int parseInt = Integer.parseInt(sb2.substring(0, i11));
                if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(parseInt))) {
                    sb3.append(sb2.substring(i11));
                    return parseInt;
                }
                i11++;
            }
        }
        return 0;
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence charSequence, String str) {
        return findNumbers(charSequence, str, Leniency.VALID, Long.MAX_VALUE);
    }

    public String format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phoneNumber.getNationalNumber() == 0 && phoneNumber.hasRawInput()) {
            String rawInput = phoneNumber.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder sb2 = new StringBuilder(20);
        format(phoneNumber, phoneNumberFormat, sb2);
        return sb2.toString();
    }

    public String formatByPattern(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, List<Phonemetadata.NumberFormat> list) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb2 = new StringBuilder(20);
        Phonemetadata.NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(list, nationalSignificantNumber);
        if (chooseFormattingPatternForNumber == null) {
            sb2.append(nationalSignificantNumber);
        } else {
            Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
            newBuilder.mergeFrom(chooseFormattingPatternForNumber);
            String nationalPrefixFormattingRule = chooseFormattingPatternForNumber.getNationalPrefixFormattingRule();
            if (nationalPrefixFormattingRule.length() > 0) {
                String nationalPrefix = metadataForRegionOrCallingCode.getNationalPrefix();
                if (nationalPrefix.length() > 0) {
                    newBuilder.setNationalPrefixFormattingRule(nationalPrefixFormattingRule.replace(NP_STRING, nationalPrefix).replace(FG_STRING, "$1"));
                } else {
                    newBuilder.clearNationalPrefixFormattingRule();
                }
            }
            sb2.append(formatNsnUsingPattern(nationalSignificantNumber, newBuilder.build(), phoneNumberFormat));
        }
        maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb2);
        prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb2);
        return sb2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        r0 = r8.getNationalPrefixFormattingRule();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String formatInOriginalFormat(com.google.i18n.phonenumbers.Phonenumber.PhoneNumber r7, java.lang.String r8) {
        /*
            r6 = this;
            boolean r0 = r7.hasRawInput()
            if (r0 == 0) goto L_0x0011
            boolean r0 = r6.hasFormattingPatternForNumber(r7)
            if (r0 != 0) goto L_0x0011
            java.lang.String r7 = r7.getRawInput()
            return r7
        L_0x0011:
            boolean r0 = r7.hasCountryCodeSource()
            if (r0 != 0) goto L_0x001e
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r8 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL
            java.lang.String r7 = r6.format(r7, r8)
            return r7
        L_0x001e:
            int[] r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r1 = r7.getCountryCodeSource()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x00b5
            r2 = 2
            if (r0 == r2) goto L_0x00b0
            r8 = 3
            if (r0 == r8) goto L_0x00a5
            int r8 = r7.getCountryCode()
            java.lang.String r8 = r6.getRegionCodeForCountryCode(r8)
            java.lang.String r0 = r6.getNddPrefixForRegion(r8, r1)
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL
            java.lang.String r3 = r6.format(r7, r2)
            if (r0 == 0) goto L_0x00bb
            int r4 = r0.length()
            if (r4 != 0) goto L_0x004f
            goto L_0x00bb
        L_0x004f:
            java.lang.String r4 = r7.getRawInput()
            boolean r0 = r6.rawInputContainsNationalPrefix(r4, r0, r8)
            if (r0 == 0) goto L_0x005a
            goto L_0x00bb
        L_0x005a:
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r8 = r6.getMetadataForRegion(r8)
            java.lang.String r0 = r6.getNationalSignificantNumber(r7)
            java.util.List r8 = r8.getNumberFormatList()
            com.google.i18n.phonenumbers.Phonemetadata$NumberFormat r8 = r6.chooseFormattingPatternForNumber(r8, r0)
            if (r8 != 0) goto L_0x006d
            goto L_0x00bb
        L_0x006d:
            java.lang.String r0 = r8.getNationalPrefixFormattingRule()
            java.lang.String r4 = "$1"
            int r4 = r0.indexOf(r4)
            if (r4 > 0) goto L_0x007a
            goto L_0x00bb
        L_0x007a:
            r5 = 0
            java.lang.String r0 = r0.substring(r5, r4)
            java.lang.String r0 = normalizeDigitsOnly(r0)
            int r0 = r0.length()
            if (r0 != 0) goto L_0x008a
            goto L_0x00bb
        L_0x008a:
            com.google.i18n.phonenumbers.Phonemetadata$NumberFormat$Builder r0 = com.google.i18n.phonenumbers.Phonemetadata.NumberFormat.newBuilder()
            r0.mergeFrom(r8)
            r0.clearNationalPrefixFormattingRule()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>(r1)
            com.google.i18n.phonenumbers.Phonemetadata$NumberFormat r0 = r0.build()
            r8.add(r0)
            java.lang.String r3 = r6.formatByPattern(r7, r2, r8)
            goto L_0x00bb
        L_0x00a5:
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r8 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL
            java.lang.String r8 = r6.format(r7, r8)
            java.lang.String r3 = r8.substring(r1)
            goto L_0x00bb
        L_0x00b0:
            java.lang.String r3 = r6.formatOutOfCountryCallingNumber(r7, r8)
            goto L_0x00bb
        L_0x00b5:
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r8 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL
            java.lang.String r3 = r6.format(r7, r8)
        L_0x00bb:
            java.lang.String r7 = r7.getRawInput()
            if (r3 == 0) goto L_0x00d6
            int r8 = r7.length()
            if (r8 <= 0) goto L_0x00d6
            java.lang.String r8 = normalizeDiallableCharsOnly(r3)
            java.lang.String r0 = normalizeDiallableCharsOnly(r7)
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00d6
            r3 = r7
        L_0x00d6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.formatInOriginalFormat(com.google.i18n.phonenumbers.Phonenumber$PhoneNumber, java.lang.String):java.lang.String");
    }

    public String formatNationalNumberWithCarrierCode(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb2 = new StringBuilder(20);
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.NATIONAL;
        sb2.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, phoneNumberFormat, charSequence));
        maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb2);
        prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb2);
        return sb2.toString();
    }

    public String formatNationalNumberWithPreferredCarrierCode(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence) {
        if (phoneNumber.getPreferredDomesticCarrierCode().length() > 0) {
            charSequence = phoneNumber.getPreferredDomesticCarrierCode();
        }
        return formatNationalNumberWithCarrierCode(phoneNumber, charSequence);
    }

    public String formatNsnUsingPattern(String str, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat) {
        return formatNsnUsingPattern(str, numberFormat, phoneNumberFormat, (CharSequence) null);
    }

    public String formatNumberForMobileDialing(Phonenumber.PhoneNumber phoneNumber, String str, boolean z11) {
        boolean z12;
        String str2;
        int countryCode = phoneNumber.getCountryCode();
        String str3 = "";
        if (hasValidCountryCallingCode(countryCode)) {
            Phonenumber.PhoneNumber clearExtension = new Phonenumber.PhoneNumber().mergeFrom(phoneNumber).clearExtension();
            String regionCodeForCountryCode = getRegionCodeForCountryCode(countryCode);
            PhoneNumberType numberType = getNumberType(clearExtension);
            boolean z13 = false;
            if (numberType != PhoneNumberType.UNKNOWN) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (str.equals(regionCodeForCountryCode)) {
                if (numberType == PhoneNumberType.FIXED_LINE || numberType == PhoneNumberType.MOBILE || numberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
                    z13 = true;
                }
                if (!regionCodeForCountryCode.equals(Profile.Country.BR) || !z13) {
                    if (countryCode == 1) {
                        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
                        if (!canBeInternationallyDialled(clearExtension) || testNumberLength(getNationalSignificantNumber(clearExtension), metadataForRegion) == ValidationResult.TOO_SHORT) {
                            str2 = format(clearExtension, PhoneNumberFormat.NATIONAL);
                        } else {
                            str2 = format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
                        }
                    } else if ((regionCodeForCountryCode.equals("001") || ((regionCodeForCountryCode.equals(Profile.Country.MX) || regionCodeForCountryCode.equals(Profile.Country.CL) || regionCodeForCountryCode.equals("UZ")) && z13)) && canBeInternationallyDialled(clearExtension)) {
                        str2 = format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
                    } else {
                        str2 = format(clearExtension, PhoneNumberFormat.NATIONAL);
                    }
                    str3 = str2;
                } else if (clearExtension.getPreferredDomesticCarrierCode().length() > 0) {
                    str3 = formatNationalNumberWithPreferredCarrierCode(clearExtension, str3);
                }
            } else if (z12 && canBeInternationallyDialled(clearExtension)) {
                if (z11) {
                    return format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
                }
                return format(clearExtension, PhoneNumberFormat.E164);
            }
            if (z11) {
                return str3;
            }
            return normalizeDiallableCharsOnly(str3);
        } else if (phoneNumber.hasRawInput()) {
            return phoneNumber.getRawInput();
        } else {
            return str3;
        }
    }

    public String formatOutOfCountryCallingNumber(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (!isValidRegionCode(str)) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            logger2.log(level, "Trying to format number from invalid region " + str + ". International formatting applied.");
            return format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        }
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        if (countryCode == 1) {
            if (isNANPACountry(str)) {
                return countryCode + " " + format(phoneNumber, PhoneNumberFormat.NATIONAL);
            }
        } else if (countryCode == getCountryCodeForValidRegion(str)) {
            return format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        String internationalPrefix = metadataForRegion.getInternationalPrefix();
        if (metadataForRegion.hasPreferredInternationalPrefix()) {
            internationalPrefix = metadataForRegion.getPreferredInternationalPrefix();
        } else if (!SINGLE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()) {
            internationalPrefix = "";
        }
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.INTERNATIONAL;
        StringBuilder sb2 = new StringBuilder(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, phoneNumberFormat));
        maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb2);
        if (internationalPrefix.length() > 0) {
            sb2.insert(0, " ").insert(0, countryCode).insert(0, " ").insert(0, internationalPrefix);
        } else {
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb2);
        }
        return sb2.toString();
    }

    public String formatOutOfCountryKeepingAlphaChars(Phonenumber.PhoneNumber phoneNumber, String str) {
        String str2;
        int indexOf;
        String rawInput = phoneNumber.getRawInput();
        if (rawInput.length() == 0) {
            return formatOutOfCountryCallingNumber(phoneNumber, str);
        }
        int countryCode = phoneNumber.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return rawInput;
        }
        String normalizeHelper = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (nationalSignificantNumber.length() > 3 && (indexOf = normalizeHelper.indexOf(nationalSignificantNumber.substring(0, 3))) != -1) {
            normalizeHelper = normalizeHelper.substring(indexOf);
        }
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (countryCode == 1) {
            if (isNANPACountry(str)) {
                return countryCode + " " + normalizeHelper;
            }
        } else if (metadataForRegion != null && countryCode == getCountryCodeForValidRegion(str)) {
            Phonemetadata.NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(metadataForRegion.getNumberFormatList(), nationalSignificantNumber);
            if (chooseFormattingPatternForNumber == null) {
                return normalizeHelper;
            }
            Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
            newBuilder.mergeFrom(chooseFormattingPatternForNumber);
            newBuilder.setPattern("(\\d+)(.*)");
            newBuilder.setFormat("$1$2");
            return formatNsnUsingPattern(normalizeHelper, newBuilder.build(), PhoneNumberFormat.NATIONAL);
        }
        if (metadataForRegion != null) {
            str2 = metadataForRegion.getInternationalPrefix();
            if (!SINGLE_INTERNATIONAL_PREFIX.matcher(str2).matches()) {
                str2 = metadataForRegion.getPreferredInternationalPrefix();
            }
        } else {
            str2 = "";
        }
        StringBuilder sb2 = new StringBuilder(normalizeHelper);
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.INTERNATIONAL;
        maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb2);
        if (str2.length() > 0) {
            sb2.insert(0, " ").insert(0, countryCode).insert(0, " ").insert(0, str2);
        } else {
            if (!isValidRegionCode(str)) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                logger2.log(level, "Trying to format number from invalid region " + str + ". International formatting applied.");
            }
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb2);
        }
        return sb2.toString();
    }

    public AsYouTypeFormatter getAsYouTypeFormatter(String str) {
        return new AsYouTypeFormatter(str);
    }

    public int getCountryCodeForRegion(String str) {
        if (isValidRegionCode(str)) {
            return getCountryCodeForValidRegion(str);
        }
        Logger logger2 = logger;
        Level level = Level.WARNING;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid or missing region code (");
        if (str == null) {
            str = "null";
        }
        sb2.append(str);
        sb2.append(") provided.");
        logger2.log(level, sb2.toString());
        return 0;
    }

    public Phonenumber.PhoneNumber getExampleNumber(String str) {
        return getExampleNumberForType(str, PhoneNumberType.FIXED_LINE);
    }

    public Phonenumber.PhoneNumber getExampleNumberForNonGeoEntity(int i11) {
        Phonemetadata.PhoneMetadata metadataForNonGeographicalRegion = getMetadataForNonGeographicalRegion(i11);
        if (metadataForNonGeographicalRegion != null) {
            for (Phonemetadata.PhoneNumberDesc phoneNumberDesc : Arrays.asList(new Phonemetadata.PhoneNumberDesc[]{metadataForNonGeographicalRegion.getMobile(), metadataForNonGeographicalRegion.getTollFree(), metadataForNonGeographicalRegion.getSharedCost(), metadataForNonGeographicalRegion.getVoip(), metadataForNonGeographicalRegion.getVoicemail(), metadataForNonGeographicalRegion.getUan(), metadataForNonGeographicalRegion.getPremiumRate()})) {
                if (phoneNumberDesc != null) {
                    try {
                        if (phoneNumberDesc.hasExampleNumber()) {
                            return parse("+" + i11 + phoneNumberDesc.getExampleNumber(), UNKNOWN_REGION);
                        }
                    } catch (NumberParseException e11) {
                        logger.log(Level.SEVERE, e11.toString());
                    }
                }
            }
            return null;
        }
        Logger logger2 = logger;
        Level level = Level.WARNING;
        logger2.log(level, "Invalid or unknown country calling code provided: " + i11);
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(String str, PhoneNumberType phoneNumberType) {
        if (!isValidRegionCode(str)) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            logger2.log(level, "Invalid or unknown region code provided: " + str);
            return null;
        }
        Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForRegion(str), phoneNumberType);
        try {
            if (numberDescByType.hasExampleNumber()) {
                return parse(numberDescByType.getExampleNumber(), str);
            }
        } catch (NumberParseException e11) {
            logger.log(Level.SEVERE, e11.toString());
        }
        return null;
    }

    public Phonenumber.PhoneNumber getInvalidExampleNumber(String str) {
        if (!isValidRegionCode(str)) {
            logger.log(Level.WARNING, "Invalid or unknown region code provided: " + str);
            return null;
        }
        Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForRegion(str), PhoneNumberType.FIXED_LINE);
        if (!numberDescByType.hasExampleNumber()) {
            return null;
        }
        String exampleNumber = numberDescByType.getExampleNumber();
        int length = exampleNumber.length();
        while (true) {
            length--;
            if (length < 2) {
                return null;
            }
            try {
                Phonenumber.PhoneNumber parse = parse(exampleNumber.substring(0, length), str);
                if (!isValidNumber(parse)) {
                    return parse;
                }
            } catch (NumberParseException unused) {
            }
        }
    }

    public int getLengthOfGeographicalAreaCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(getRegionCodeForNumber(phoneNumber));
        if (metadataForRegion == null) {
            return 0;
        }
        if (!metadataForRegion.hasNationalPrefix() && !phoneNumber.isItalianLeadingZero()) {
            return 0;
        }
        PhoneNumberType numberType = getNumberType(phoneNumber);
        int countryCode = phoneNumber.getCountryCode();
        if ((numberType != PhoneNumberType.MOBILE || !GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES.contains(Integer.valueOf(countryCode))) && isNumberGeographical(numberType, countryCode)) {
            return getLengthOfNationalDestinationCode(phoneNumber);
        }
        return 0;
    }

    public int getLengthOfNationalDestinationCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonenumber.PhoneNumber phoneNumber2;
        if (phoneNumber.hasExtension()) {
            phoneNumber2 = new Phonenumber.PhoneNumber();
            phoneNumber2.mergeFrom(phoneNumber);
            phoneNumber2.clearExtension();
        } else {
            phoneNumber2 = phoneNumber;
        }
        String[] split = NON_DIGITS_PATTERN.split(format(phoneNumber2, PhoneNumberFormat.INTERNATIONAL));
        if (split.length <= 3) {
            return 0;
        }
        if (getNumberType(phoneNumber) != PhoneNumberType.MOBILE || getCountryMobileToken(phoneNumber.getCountryCode()).equals("")) {
            return split[2].length();
        }
        return split[2].length() + split[3].length();
    }

    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i11) {
        if (!this.countryCodesForNonGeographicalRegion.contains(Integer.valueOf(i11))) {
            return null;
        }
        Phonemetadata.PhoneMetadata metadataForNonGeographicalRegion = this.metadataSource.getMetadataForNonGeographicalRegion(i11);
        ensureMetadataIsNonNull(metadataForNonGeographicalRegion, "Missing metadata for country code " + i11);
        return metadataForNonGeographicalRegion;
    }

    public Phonemetadata.PhoneMetadata getMetadataForRegion(String str) {
        if (!isValidRegionCode(str)) {
            return null;
        }
        Phonemetadata.PhoneMetadata metadataForRegion = this.metadataSource.getMetadataForRegion(str);
        ensureMetadataIsNonNull(metadataForRegion, "Missing metadata for region code " + str);
        return metadataForRegion;
    }

    public String getNationalSignificantNumber(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder sb2 = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero() && phoneNumber.getNumberOfLeadingZeros() > 0) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb2.append(new String(cArr));
        }
        sb2.append(phoneNumber.getNationalNumber());
        return sb2.toString();
    }

    public String getNddPrefixForRegion(String str, boolean z11) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion == null) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb2.append(str);
            sb2.append(") provided.");
            logger2.log(level, sb2.toString());
            return null;
        }
        String nationalPrefix = metadataForRegion.getNationalPrefix();
        if (nationalPrefix.length() == 0) {
            return null;
        }
        if (z11) {
            return nationalPrefix.replace("~", "");
        }
        return nationalPrefix;
    }

    public Phonemetadata.PhoneNumberDesc getNumberDescByType(Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        switch (AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[phoneNumberType.ordinal()]) {
            case 1:
                return phoneMetadata.getPremiumRate();
            case 2:
                return phoneMetadata.getTollFree();
            case 3:
                return phoneMetadata.getMobile();
            case 4:
            case 5:
                return phoneMetadata.getFixedLine();
            case 6:
                return phoneMetadata.getSharedCost();
            case 7:
                return phoneMetadata.getVoip();
            case 8:
                return phoneMetadata.getPersonalNumber();
            case 9:
                return phoneMetadata.getPager();
            case 10:
                return phoneMetadata.getUan();
            case 11:
                return phoneMetadata.getVoicemail();
            default:
                return phoneMetadata.getGeneralDesc();
        }
    }

    public PhoneNumberType getNumberType(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(phoneNumber.getCountryCode(), getRegionCodeForNumber(phoneNumber));
        if (metadataForRegionOrCallingCode == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode);
    }

    public String getRegionCodeForCountryCode(int i11) {
        List list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i11));
        if (list == null) {
            return UNKNOWN_REGION;
        }
        return (String) list.get(0);
    }

    public String getRegionCodeForNumber(Phonenumber.PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        List list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCode));
        if (list == null) {
            Logger logger2 = logger;
            Level level = Level.INFO;
            logger2.log(level, "Missing/invalid country_code (" + countryCode + ")");
            return null;
        } else if (list.size() == 1) {
            return (String) list.get(0);
        } else {
            return getRegionCodeForNumberFromRegionList(phoneNumber, list);
        }
    }

    public List<String> getRegionCodesForCountryCode(int i11) {
        List list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i11));
        if (list == null) {
            list = new ArrayList(0);
        }
        return Collections.unmodifiableList(list);
    }

    public Set<Integer> getSupportedCallingCodes() {
        return Collections.unmodifiableSet(this.countryCallingCodeToRegionCodeMap.keySet());
    }

    public Set<Integer> getSupportedGlobalNetworkCallingCodes() {
        return Collections.unmodifiableSet(this.countryCodesForNonGeographicalRegion);
    }

    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(this.supportedRegions);
    }

    public Set<PhoneNumberType> getSupportedTypesForNonGeoEntity(int i11) {
        Phonemetadata.PhoneMetadata metadataForNonGeographicalRegion = getMetadataForNonGeographicalRegion(i11);
        if (metadataForNonGeographicalRegion != null) {
            return getSupportedTypesForMetadata(metadataForNonGeographicalRegion);
        }
        Logger logger2 = logger;
        Level level = Level.WARNING;
        logger2.log(level, "Unknown country calling code for a non-geographical entity provided: " + i11);
        return Collections.unmodifiableSet(new TreeSet());
    }

    public Set<PhoneNumberType> getSupportedTypesForRegion(String str) {
        if (isValidRegionCode(str)) {
            return getSupportedTypesForMetadata(getMetadataForRegion(str));
        }
        Logger logger2 = logger;
        Level level = Level.WARNING;
        logger2.log(level, "Invalid or unknown region code provided: " + str);
        return Collections.unmodifiableSet(new TreeSet());
    }

    public boolean isAlphaNumber(CharSequence charSequence) {
        if (!isViablePhoneNumber(charSequence)) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        maybeStripExtension(sb2);
        return VALID_ALPHA_PHONE_PATTERN.matcher(sb2).matches();
    }

    public boolean isMobileNumberPortableRegion(String str) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion != null) {
            return metadataForRegion.getMobileNumberPortableRegion();
        }
        Logger logger2 = logger;
        Level level = Level.WARNING;
        logger2.log(level, "Invalid or unknown region code provided: " + str);
        return false;
    }

    public boolean isNANPACountry(String str) {
        return this.nanpaRegions.contains(str);
    }

    public boolean isNumberGeographical(Phonenumber.PhoneNumber phoneNumber) {
        return isNumberGeographical(getNumberType(phoneNumber), phoneNumber.getCountryCode());
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        Phonenumber.PhoneNumber copyCoreFieldsOnly = copyCoreFieldsOnly(phoneNumber);
        Phonenumber.PhoneNumber copyCoreFieldsOnly2 = copyCoreFieldsOnly(phoneNumber2);
        if (copyCoreFieldsOnly.hasExtension() && copyCoreFieldsOnly2.hasExtension() && !copyCoreFieldsOnly.getExtension().equals(copyCoreFieldsOnly2.getExtension())) {
            return MatchType.NO_MATCH;
        }
        int countryCode = copyCoreFieldsOnly.getCountryCode();
        int countryCode2 = copyCoreFieldsOnly2.getCountryCode();
        if (countryCode == 0 || countryCode2 == 0) {
            copyCoreFieldsOnly.setCountryCode(countryCode2);
            if (copyCoreFieldsOnly.exactlySameAs(copyCoreFieldsOnly2)) {
                return MatchType.NSN_MATCH;
            }
            if (isNationalNumberSuffixOfTheOther(copyCoreFieldsOnly, copyCoreFieldsOnly2)) {
                return MatchType.SHORT_NSN_MATCH;
            }
            return MatchType.NO_MATCH;
        } else if (copyCoreFieldsOnly.exactlySameAs(copyCoreFieldsOnly2)) {
            return MatchType.EXACT_MATCH;
        } else {
            if (countryCode != countryCode2 || !isNationalNumberSuffixOfTheOther(copyCoreFieldsOnly, copyCoreFieldsOnly2)) {
                return MatchType.NO_MATCH;
            }
            return MatchType.SHORT_NSN_MATCH;
        }
    }

    public boolean isNumberMatchingDesc(String str, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        int length = str.length();
        List<Integer> possibleLengthList = phoneNumberDesc.getPossibleLengthList();
        if (possibleLengthList.size() <= 0 || possibleLengthList.contains(Integer.valueOf(length))) {
            return this.matcherApi.matchNationalNumber(str, phoneNumberDesc, false);
        }
        return false;
    }

    public boolean isPossibleNumber(Phonenumber.PhoneNumber phoneNumber) {
        ValidationResult isPossibleNumberWithReason = isPossibleNumberWithReason(phoneNumber);
        return isPossibleNumberWithReason == ValidationResult.IS_POSSIBLE || isPossibleNumberWithReason == ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
    }

    public boolean isPossibleNumberForType(Phonenumber.PhoneNumber phoneNumber, PhoneNumberType phoneNumberType) {
        ValidationResult isPossibleNumberForTypeWithReason = isPossibleNumberForTypeWithReason(phoneNumber, phoneNumberType);
        if (isPossibleNumberForTypeWithReason == ValidationResult.IS_POSSIBLE || isPossibleNumberForTypeWithReason == ValidationResult.IS_POSSIBLE_LOCAL_ONLY) {
            return true;
        }
        return false;
    }

    public ValidationResult isPossibleNumberForTypeWithReason(Phonenumber.PhoneNumber phoneNumber, PhoneNumberType phoneNumberType) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        int countryCode = phoneNumber.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return testNumberLength(nationalSignificantNumber, getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)), phoneNumberType);
    }

    public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber phoneNumber) {
        return isPossibleNumberForTypeWithReason(phoneNumber, PhoneNumberType.UNKNOWN);
    }

    public boolean isValidNumber(Phonenumber.PhoneNumber phoneNumber) {
        return isValidNumberForRegion(phoneNumber, getRegionCodeForNumber(phoneNumber));
    }

    public boolean isValidNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        int countryCode = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, str);
        if (metadataForRegionOrCallingCode == null) {
            return false;
        }
        if (("001".equals(str) || countryCode == getCountryCodeForValidRegion(str)) && getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode) != PhoneNumberType.UNKNOWN) {
            return true;
        }
        return false;
    }

    public int maybeExtractCountryCode(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb2, boolean z11, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        String str;
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb3 = new StringBuilder(charSequence);
        if (phoneMetadata != null) {
            str = phoneMetadata.getInternationalPrefix();
        } else {
            str = "NonMatch";
        }
        Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize = maybeStripInternationalPrefixAndNormalize(sb3, str);
        if (z11) {
            phoneNumber.setCountryCodeSource(maybeStripInternationalPrefixAndNormalize);
        }
        if (maybeStripInternationalPrefixAndNormalize == Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (phoneMetadata != null) {
                int countryCode = phoneMetadata.getCountryCode();
                String valueOf = String.valueOf(countryCode);
                String sb4 = sb3.toString();
                if (sb4.startsWith(valueOf)) {
                    StringBuilder sb5 = new StringBuilder(sb4.substring(valueOf.length()));
                    Phonemetadata.PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                    maybeStripNationalPrefixAndCarrierCode(sb5, phoneMetadata, (StringBuilder) null);
                    if ((!this.matcherApi.matchNationalNumber(sb3, generalDesc, false) && this.matcherApi.matchNationalNumber(sb5, generalDesc, false)) || testNumberLength(sb3, phoneMetadata) == ValidationResult.TOO_LONG) {
                        sb2.append(sb5);
                        if (z11) {
                            phoneNumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        phoneNumber.setCountryCode(countryCode);
                        return countryCode;
                    }
                }
            }
            phoneNumber.setCountryCode(0);
            return 0;
        } else if (sb3.length() > 2) {
            int extractCountryCode = extractCountryCode(sb3, sb2);
            if (extractCountryCode != 0) {
                phoneNumber.setCountryCode(extractCountryCode);
                return extractCountryCode;
            }
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        } else {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
    }

    public String maybeStripExtension(StringBuilder sb2) {
        Matcher matcher = EXTN_PATTERN.matcher(sb2);
        if (!matcher.find() || !isViablePhoneNumber(sb2.substring(0, matcher.start()))) {
            return "";
        }
        int groupCount = matcher.groupCount();
        for (int i11 = 1; i11 <= groupCount; i11++) {
            if (matcher.group(i11) != null) {
                String group = matcher.group(i11);
                sb2.delete(matcher.start(), sb2.length());
                return group;
            }
        }
        return "";
    }

    public Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder sb2, String str) {
        if (sb2.length() == 0) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb2);
        if (matcher.lookingAt()) {
            sb2.delete(0, matcher.end());
            normalize(sb2);
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(str);
        normalize(sb2);
        if (parsePrefixAsIdd(patternForRegex, sb2)) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        }
        return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    public boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder sb2, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb3) {
        int length = sb2.length();
        String nationalPrefixForParsing = phoneMetadata.getNationalPrefixForParsing();
        if (!(length == 0 || nationalPrefixForParsing.length() == 0)) {
            Matcher matcher = this.regexCache.getPatternForRegex(nationalPrefixForParsing).matcher(sb2);
            if (matcher.lookingAt()) {
                Phonemetadata.PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                boolean matchNationalNumber = this.matcherApi.matchNationalNumber(sb2, generalDesc, false);
                int groupCount = matcher.groupCount();
                String nationalPrefixTransformRule = phoneMetadata.getNationalPrefixTransformRule();
                if (nationalPrefixTransformRule != null && nationalPrefixTransformRule.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb4 = new StringBuilder(sb2);
                    sb4.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
                    if (matchNationalNumber && !this.matcherApi.matchNationalNumber(sb4.toString(), generalDesc, false)) {
                        return false;
                    }
                    if (sb3 != null && groupCount > 1) {
                        sb3.append(matcher.group(1));
                    }
                    sb2.replace(0, sb2.length(), sb4.toString());
                    return true;
                } else if (matchNationalNumber && !this.matcherApi.matchNationalNumber(sb2.substring(matcher.end()), generalDesc, false)) {
                    return false;
                } else {
                    if (!(sb3 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                        sb3.append(matcher.group(1));
                    }
                    sb2.delete(0, matcher.end());
                    return true;
                }
            }
        }
        return false;
    }

    public Phonenumber.PhoneNumber parse(CharSequence charSequence, String str) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parse(charSequence, str, phoneNumber);
        return phoneNumber;
    }

    public Phonenumber.PhoneNumber parseAndKeepRawInput(CharSequence charSequence, String str) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parseAndKeepRawInput(charSequence, str, phoneNumber);
        return phoneNumber;
    }

    public boolean truncateTooLongNumber(Phonenumber.PhoneNumber phoneNumber) {
        if (isValidNumber(phoneNumber)) {
            return true;
        }
        Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
        phoneNumber2.mergeFrom(phoneNumber);
        long nationalNumber = phoneNumber.getNationalNumber();
        do {
            nationalNumber /= 10;
            phoneNumber2.setNationalNumber(nationalNumber);
            if (isPossibleNumberWithReason(phoneNumber2) == ValidationResult.TOO_SHORT || nationalNumber == 0) {
                return false;
            }
        } while (!isValidNumber(phoneNumber2));
        phoneNumber.setNationalNumber(nationalNumber);
        return true;
    }

    private String formatNsn(String str, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        List<Phonemetadata.NumberFormat> list;
        if (phoneMetadata.getIntlNumberFormatList().size() == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) {
            list = phoneMetadata.getNumberFormatList();
        } else {
            list = phoneMetadata.getIntlNumberFormatList();
        }
        Phonemetadata.NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(list, str);
        return chooseFormattingPatternForNumber == null ? str : formatNsnUsingPattern(str, chooseFormattingPatternForNumber, phoneNumberFormat, charSequence);
    }

    private String formatNsnUsingPattern(String str, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        String str2;
        String format = numberFormat.getFormat();
        Matcher matcher = this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher(str);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.NATIONAL;
        if (phoneNumberFormat != phoneNumberFormat2 || charSequence == null || charSequence.length() <= 0 || numberFormat.getDomesticCarrierCodeFormattingRule().length() <= 0) {
            String nationalPrefixFormattingRule = numberFormat.getNationalPrefixFormattingRule();
            if (phoneNumberFormat != phoneNumberFormat2 || nationalPrefixFormattingRule == null || nationalPrefixFormattingRule.length() <= 0) {
                str2 = matcher.replaceAll(format);
            } else {
                str2 = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(nationalPrefixFormattingRule));
            }
        } else {
            str2 = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(numberFormat.getDomesticCarrierCodeFormattingRule().replace(CC_STRING, charSequence)));
        }
        if (phoneNumberFormat != PhoneNumberFormat.RFC3966) {
            return str2;
        }
        Matcher matcher2 = SEPARATOR_PATTERN.matcher(str2);
        if (matcher2.lookingAt()) {
            str2 = matcher2.replaceFirst("");
        }
        return matcher2.reset(str2).replaceAll(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
    }

    private ValidationResult testNumberLength(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        List<Integer> list;
        Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(phoneMetadata, phoneNumberType);
        ArrayList possibleLengthList = numberDescByType.getPossibleLengthList().isEmpty() ? phoneMetadata.getGeneralDesc().getPossibleLengthList() : numberDescByType.getPossibleLengthList();
        List<Integer> possibleLengthLocalOnlyList = numberDescByType.getPossibleLengthLocalOnlyList();
        if (phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            if (!descHasPossibleNumberData(getNumberDescByType(phoneMetadata, PhoneNumberType.FIXED_LINE))) {
                return testNumberLength(charSequence, phoneMetadata, PhoneNumberType.MOBILE);
            }
            Phonemetadata.PhoneNumberDesc numberDescByType2 = getNumberDescByType(phoneMetadata, PhoneNumberType.MOBILE);
            if (descHasPossibleNumberData(numberDescByType2)) {
                ArrayList arrayList = new ArrayList(possibleLengthList);
                if (numberDescByType2.getPossibleLengthCount() == 0) {
                    list = phoneMetadata.getGeneralDesc().getPossibleLengthList();
                } else {
                    list = numberDescByType2.getPossibleLengthList();
                }
                arrayList.addAll(list);
                Collections.sort(arrayList);
                if (possibleLengthLocalOnlyList.isEmpty()) {
                    possibleLengthLocalOnlyList = numberDescByType2.getPossibleLengthLocalOnlyList();
                } else {
                    ArrayList arrayList2 = new ArrayList(possibleLengthLocalOnlyList);
                    arrayList2.addAll(numberDescByType2.getPossibleLengthLocalOnlyList());
                    Collections.sort(arrayList2);
                    possibleLengthLocalOnlyList = arrayList2;
                }
                possibleLengthList = arrayList;
            }
        }
        if (((Integer) possibleLengthList.get(0)).intValue() == -1) {
            return ValidationResult.INVALID_LENGTH;
        }
        int length = charSequence.length();
        if (possibleLengthLocalOnlyList.contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        }
        int intValue = ((Integer) possibleLengthList.get(0)).intValue();
        if (intValue == length) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (intValue > length) {
            return ValidationResult.TOO_SHORT;
        }
        if (((Integer) possibleLengthList.get(possibleLengthList.size() - 1)).intValue() < length) {
            return ValidationResult.TOO_LONG;
        }
        return possibleLengthList.subList(1, possibleLengthList.size()).contains(Integer.valueOf(length)) ? ValidationResult.IS_POSSIBLE : ValidationResult.INVALID_LENGTH;
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence charSequence, String str, Leniency leniency, long j11) {
        final CharSequence charSequence2 = charSequence;
        final String str2 = str;
        final Leniency leniency2 = leniency;
        final long j12 = j11;
        return new Iterable<PhoneNumberMatch>() {
            public Iterator<PhoneNumberMatch> iterator() {
                return new PhoneNumberMatcher(PhoneNumberUtil.this, charSequence2, str2, leniency2, j12);
            }
        };
    }

    public boolean isNumberGeographical(PhoneNumberType phoneNumberType, int i11) {
        return phoneNumberType == PhoneNumberType.FIXED_LINE || phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE || (GEO_MOBILE_COUNTRIES.contains(Integer.valueOf(i11)) && phoneNumberType == PhoneNumberType.MOBILE);
    }

    public boolean isPossibleNumber(CharSequence charSequence, String str) {
        try {
            return isPossibleNumber(parse(charSequence, str));
        } catch (NumberParseException unused) {
            return false;
        }
    }

    public void parse(CharSequence charSequence, String str, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(charSequence, str, false, true, phoneNumber);
    }

    public void parseAndKeepRawInput(CharSequence charSequence, String str, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(charSequence, str, true, true, phoneNumber);
    }

    private static PhoneNumberUtil createInstance(MetadataSource metadataSource2) {
        if (metadataSource2 != null) {
            return new PhoneNumberUtil(metadataSource2, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public void format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder sb2) {
        sb2.setLength(0);
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.E164;
        if (phoneNumberFormat == phoneNumberFormat2) {
            sb2.append(nationalSignificantNumber);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat2, sb2);
        } else if (!hasValidCountryCallingCode(countryCode)) {
            sb2.append(nationalSignificantNumber);
        } else {
            Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            sb2.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, phoneNumberFormat));
            maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb2);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb2);
        }
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(PhoneNumberType phoneNumberType) {
        for (String exampleNumberForType : getSupportedRegions()) {
            Phonenumber.PhoneNumber exampleNumberForType2 = getExampleNumberForType(exampleNumberForType, phoneNumberType);
            if (exampleNumberForType2 != null) {
                return exampleNumberForType2;
            }
        }
        for (Integer intValue : getSupportedGlobalNetworkCallingCodes()) {
            int intValue2 = intValue.intValue();
            Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForNonGeographicalRegion(intValue2), phoneNumberType);
            try {
                if (numberDescByType.hasExampleNumber()) {
                    return parse("+" + intValue2 + numberDescByType.getExampleNumber(), UNKNOWN_REGION);
                }
            } catch (NumberParseException e11) {
                logger.log(Level.SEVERE, e11.toString());
            }
        }
        return null;
    }

    public MatchType isNumberMatch(CharSequence charSequence, CharSequence charSequence2) {
        try {
            return isNumberMatch(parse(charSequence, UNKNOWN_REGION), charSequence2);
        } catch (NumberParseException e11) {
            if (e11.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                try {
                    return isNumberMatch(parse(charSequence2, UNKNOWN_REGION), charSequence);
                } catch (NumberParseException e12) {
                    if (e12.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                        try {
                            Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
                            Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
                            parseHelper(charSequence, (String) null, false, false, phoneNumber);
                            parseHelper(charSequence2, (String) null, false, false, phoneNumber2);
                            return isNumberMatch(phoneNumber, phoneNumber2);
                        } catch (NumberParseException unused) {
                            return MatchType.NOT_A_NUMBER;
                        }
                    }
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence) {
        try {
            return isNumberMatch(phoneNumber, parse(charSequence, UNKNOWN_REGION));
        } catch (NumberParseException e11) {
            if (e11.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                String regionCodeForCountryCode = getRegionCodeForCountryCode(phoneNumber.getCountryCode());
                try {
                    if (!regionCodeForCountryCode.equals(UNKNOWN_REGION)) {
                        MatchType isNumberMatch = isNumberMatch(phoneNumber, parse(charSequence, regionCodeForCountryCode));
                        return isNumberMatch == MatchType.EXACT_MATCH ? MatchType.NSN_MATCH : isNumberMatch;
                    }
                    Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
                    parseHelper(charSequence, (String) null, false, false, phoneNumber2);
                    return isNumberMatch(phoneNumber, phoneNumber2);
                } catch (NumberParseException unused) {
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }
}
