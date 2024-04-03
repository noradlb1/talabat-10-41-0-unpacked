package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.internal.RegexCache;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.Character;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch>, j$.util.Iterator {
    private static final Pattern[] INNER_MATCHES = {Pattern.compile("/+(.*)"), Pattern.compile("(\\([^(]*)"), Pattern.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile("[‒-―－]\\p{Z}*(.+)"), Pattern.compile("\\.+\\p{Z}*([^.]+)"), Pattern.compile("\\p{Z}+(\\P{Z}+)")};
    private static final Pattern LEAD_CLASS;
    private static final Pattern MATCHING_BRACKETS;
    private static final Pattern PATTERN;
    private static final Pattern PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
    private static final Pattern SLASH_SEPARATED_DATES = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
    private static final Pattern TIME_STAMPS = Pattern.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");
    private static final Pattern TIME_STAMPS_SUFFIX = Pattern.compile(":[0-5]\\d");
    private PhoneNumberMatch lastMatch = null;
    private final PhoneNumberUtil.Leniency leniency;
    private long maxTries;
    private final PhoneNumberUtil phoneUtil;
    private final String preferredRegion;
    private final RegexCache regexCache = new RegexCache(32);
    private int searchIndex = 0;
    private State state = State.NOT_READY;
    private final CharSequence text;

    public interface NumberGroupingChecker {
        boolean checkGroups(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb2, String[] strArr);
    }

    public enum State {
        NOT_READY,
        READY,
        DONE
    }

    static {
        String str = "[^" + "(\\[（［" + ")\\]）］" + "]";
        MATCHING_BRACKETS = Pattern.compile("(?:[" + "(\\[（［" + "])?(?:" + str + "+[" + ")\\]）］" + "])?" + str + "+(?:[" + "(\\[（［" + "]" + str + "+[" + ")\\]）］" + "])" + limit(0, 3) + str + "*");
        String limit = limit(0, 2);
        String limit2 = limit(0, 4);
        String limit3 = limit(0, 20);
        String str2 = "[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]" + limit2;
        String str3 = "\\p{Nd}" + limit(1, 20);
        String str4 = "[" + ("(\\[（［" + "+＋") + "]";
        LEAD_CLASS = Pattern.compile(str4);
        PATTERN = Pattern.compile("(?:" + str4 + str2 + ")" + limit + str3 + "(?:" + str2 + str3 + ")" + limit3 + "(?:" + PhoneNumberUtil.EXTN_PATTERNS_FOR_MATCHING + ")?", 66);
    }

    public PhoneNumberMatcher(PhoneNumberUtil phoneNumberUtil, String str, String str2, PhoneNumberUtil.Leniency leniency2, long j11) {
        if (phoneNumberUtil == null || leniency2 == null) {
            throw null;
        } else if (j11 >= 0) {
            this.phoneUtil = phoneNumberUtil;
            this.text = str == null ? "" : str;
            this.preferredRegion = str2;
            this.leniency = leniency2;
            this.maxTries = j11;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean allNumberGroupsAreExactlyPresent(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb2, String[] strArr) {
        int i11;
        String[] split = PhoneNumberUtil.NON_DIGITS_PATTERN.split(sb2.toString());
        if (phoneNumber.hasExtension()) {
            i11 = split.length - 2;
        } else {
            i11 = split.length - 1;
        }
        if (split.length == 1 || split[i11].contains(phoneNumberUtil.getNationalSignificantNumber(phoneNumber))) {
            return true;
        }
        int length = strArr.length - 1;
        while (length > 0 && i11 >= 0) {
            if (!split[i11].equals(strArr[length])) {
                return false;
            }
            length--;
            i11--;
        }
        if (i11 < 0 || !split[i11].endsWith(strArr[0])) {
            return false;
        }
        return true;
    }

    public static boolean allNumberGroupsRemainGrouped(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb2, String[] strArr) {
        int i11;
        if (phoneNumber.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            String num = Integer.toString(phoneNumber.getCountryCode());
            i11 = sb2.indexOf(num) + num.length();
        } else {
            i11 = 0;
        }
        int i12 = 0;
        while (i12 < strArr.length) {
            int indexOf = sb2.indexOf(strArr[i12], i11);
            if (indexOf < 0) {
                return false;
            }
            i11 = indexOf + strArr[i12].length();
            if (i12 != 0 || i11 >= sb2.length() || phoneNumberUtil.getNddPrefixForRegion(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()), true) == null || !Character.isDigit(sb2.charAt(i11))) {
                i12++;
            } else {
                return sb2.substring(i11 - strArr[i12].length()).startsWith(phoneNumberUtil.getNationalSignificantNumber(phoneNumber));
            }
        }
        return sb2.substring(i11).contains(phoneNumber.getExtension());
    }

    public static boolean containsMoreThanOneSlashInNationalNumber(Phonenumber.PhoneNumber phoneNumber, String str) {
        int indexOf;
        boolean z11;
        int indexOf2 = str.indexOf(47);
        if (indexOf2 < 0 || (indexOf = str.indexOf(47, indexOf2 + 1)) < 0) {
            return false;
        }
        if (phoneNumber.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN || phoneNumber.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !PhoneNumberUtil.normalizeDigitsOnly(str.substring(0, indexOf2)).equals(Integer.toString(phoneNumber.getCountryCode()))) {
            return true;
        }
        return str.substring(indexOf + 1).contains("/");
    }

    public static boolean containsOnlyValidXChars(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
        int i11 = 0;
        while (i11 < str.length() - 1) {
            char charAt = str.charAt(i11);
            if (charAt == 'x' || charAt == 'X') {
                int i12 = i11 + 1;
                char charAt2 = str.charAt(i12);
                if (charAt2 == 'x' || charAt2 == 'X') {
                    if (phoneNumberUtil.isNumberMatch(phoneNumber, (CharSequence) str.substring(i12)) != PhoneNumberUtil.MatchType.NSN_MATCH) {
                        return false;
                    }
                    i11 = i12;
                } else if (!PhoneNumberUtil.normalizeDigitsOnly(str.substring(i11)).equals(phoneNumber.getExtension())) {
                    return false;
                }
            }
            i11++;
        }
        return true;
    }

    private PhoneNumberMatch extractInnerMatch(CharSequence charSequence, int i11) {
        for (Pattern matcher : INNER_MATCHES) {
            Matcher matcher2 = matcher.matcher(charSequence);
            boolean z11 = true;
            while (matcher2.find() && this.maxTries > 0) {
                if (z11) {
                    PhoneNumberMatch parseAndVerify = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, charSequence.subSequence(0, matcher2.start())), i11);
                    if (parseAndVerify != null) {
                        return parseAndVerify;
                    }
                    this.maxTries--;
                    z11 = false;
                }
                PhoneNumberMatch parseAndVerify2 = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, matcher2.group(1)), matcher2.start(1) + i11);
                if (parseAndVerify2 != null) {
                    return parseAndVerify2;
                }
                this.maxTries--;
            }
        }
        return null;
    }

    private PhoneNumberMatch extractMatch(CharSequence charSequence, int i11) {
        if (SLASH_SEPARATED_DATES.matcher(charSequence).find()) {
            return null;
        }
        if (TIME_STAMPS.matcher(charSequence).find()) {
            if (TIME_STAMPS_SUFFIX.matcher(this.text.toString().substring(charSequence.length() + i11)).lookingAt()) {
                return null;
            }
        }
        PhoneNumberMatch parseAndVerify = parseAndVerify(charSequence, i11);
        if (parseAndVerify != null) {
            return parseAndVerify;
        }
        return extractInnerMatch(charSequence, i11);
    }

    private PhoneNumberMatch find(int i11) {
        Matcher matcher = PATTERN.matcher(this.text);
        while (this.maxTries > 0 && matcher.find(i11)) {
            int start = matcher.start();
            CharSequence trimAfterFirstMatch = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, this.text.subSequence(start, matcher.end()));
            PhoneNumberMatch extractMatch = extractMatch(trimAfterFirstMatch, start);
            if (extractMatch != null) {
                return extractMatch;
            }
            i11 = start + trimAfterFirstMatch.length();
            this.maxTries--;
        }
        return null;
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber) {
        String format = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.RFC3966);
        int indexOf = format.indexOf(59);
        if (indexOf < 0) {
            indexOf = format.length();
        }
        return format.substring(format.indexOf(45) + 1, indexOf).split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
    }

    private static boolean isInvalidPunctuationSymbol(char c11) {
        return c11 == '%' || Character.getType(c11) == 26;
    }

    public static boolean isLatinLetter(char c11) {
        if (!Character.isLetter(c11) && Character.getType(c11) != 6) {
            return false;
        }
        Character.UnicodeBlock of2 = Character.UnicodeBlock.of(c11);
        if (of2.equals(Character.UnicodeBlock.BASIC_LATIN) || of2.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) || of2.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) || of2.equals(Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) || of2.equals(Character.UnicodeBlock.LATIN_EXTENDED_B) || of2.equals(Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS)) {
            return true;
        }
        return false;
    }

    public static boolean isNationalPrefixPresentIfRequired(Phonenumber.PhoneNumber phoneNumber, PhoneNumberUtil phoneNumberUtil) {
        Phonemetadata.PhoneMetadata metadataForRegion;
        Phonemetadata.NumberFormat chooseFormattingPatternForNumber;
        if (phoneNumber.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY && (metadataForRegion = phoneNumberUtil.getMetadataForRegion(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()))) != null && (chooseFormattingPatternForNumber = phoneNumberUtil.chooseFormattingPatternForNumber(metadataForRegion.getNumberFormatList(), phoneNumberUtil.getNationalSignificantNumber(phoneNumber))) != null && chooseFormattingPatternForNumber.getNationalPrefixFormattingRule().length() > 0 && !chooseFormattingPatternForNumber.getNationalPrefixOptionalWhenFormatting() && !PhoneNumberUtil.formattingRuleHasFirstGroupOnly(chooseFormattingPatternForNumber.getNationalPrefixFormattingRule())) {
            return phoneNumberUtil.maybeStripNationalPrefixAndCarrierCode(new StringBuilder(PhoneNumberUtil.normalizeDigitsOnly(phoneNumber.getRawInput())), metadataForRegion, (StringBuilder) null);
        }
        return true;
    }

    private static String limit(int i11, int i12) {
        if (i11 < 0 || i12 <= 0 || i12 < i11) {
            throw new IllegalArgumentException();
        }
        return "{" + i11 + "," + i12 + "}";
    }

    private PhoneNumberMatch parseAndVerify(CharSequence charSequence, int i11) {
        try {
            if (MATCHING_BRACKETS.matcher(charSequence).matches()) {
                if (!PUB_PAGES.matcher(charSequence).find()) {
                    if (this.leniency.compareTo(PhoneNumberUtil.Leniency.VALID) >= 0) {
                        if (i11 > 0 && !LEAD_CLASS.matcher(charSequence).lookingAt()) {
                            char charAt = this.text.charAt(i11 - 1);
                            if (isInvalidPunctuationSymbol(charAt) || isLatinLetter(charAt)) {
                                return null;
                            }
                        }
                        int length = charSequence.length() + i11;
                        if (length < this.text.length()) {
                            char charAt2 = this.text.charAt(length);
                            if (isInvalidPunctuationSymbol(charAt2) || isLatinLetter(charAt2)) {
                                return null;
                            }
                        }
                    }
                    Phonenumber.PhoneNumber parseAndKeepRawInput = this.phoneUtil.parseAndKeepRawInput(charSequence, this.preferredRegion);
                    if (this.leniency.verify(parseAndKeepRawInput, charSequence, this.phoneUtil, this)) {
                        parseAndKeepRawInput.clearCountryCodeSource();
                        parseAndKeepRawInput.clearRawInput();
                        parseAndKeepRawInput.clearPreferredDomesticCarrierCode();
                        return new PhoneNumberMatch(i11, charSequence.toString(), parseAndKeepRawInput);
                    }
                }
            }
        } catch (NumberParseException unused) {
        }
        return null;
    }

    private static CharSequence trimAfterFirstMatch(Pattern pattern, CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        if (matcher.find()) {
            return charSequence.subSequence(0, matcher.start());
        }
        return charSequence;
    }

    public boolean checkNumberGroupingIsValid(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, NumberGroupingChecker numberGroupingChecker) {
        StringBuilder normalizeDigits = PhoneNumberUtil.normalizeDigits(charSequence, true);
        if (numberGroupingChecker.checkGroups(phoneNumberUtil, phoneNumber, normalizeDigits, getNationalNumberGroups(phoneNumberUtil, phoneNumber))) {
            return true;
        }
        Phonemetadata.PhoneMetadata formattingMetadataForCountryCallingCode = DefaultMetadataDependenciesProvider.getInstance().getAlternateFormatsMetadataSource().getFormattingMetadataForCountryCallingCode(phoneNumber.getCountryCode());
        String nationalSignificantNumber = phoneNumberUtil.getNationalSignificantNumber(phoneNumber);
        if (formattingMetadataForCountryCallingCode != null) {
            for (Phonemetadata.NumberFormat next : formattingMetadataForCountryCallingCode.getNumberFormatList()) {
                if ((next.getLeadingDigitsPatternCount() <= 0 || this.regexCache.getPatternForRegex(next.getLeadingDigitsPattern(0)).matcher(nationalSignificantNumber).lookingAt()) && numberGroupingChecker.checkGroups(phoneNumberUtil, phoneNumber, normalizeDigits, getNationalNumberGroups(phoneNumberUtil, phoneNumber, next))) {
                    return true;
                }
            }
        }
        return false;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        if (this.state == State.NOT_READY) {
            PhoneNumberMatch find = find(this.searchIndex);
            this.lastMatch = find;
            if (find == null) {
                this.state = State.DONE;
            } else {
                this.searchIndex = find.end();
                this.state = State.READY;
            }
        }
        if (this.state == State.READY) {
            return true;
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public PhoneNumberMatch next() {
        if (hasNext()) {
            PhoneNumberMatch phoneNumberMatch = this.lastMatch;
            this.lastMatch = null;
            this.state = State.NOT_READY;
            return phoneNumberMatch;
        }
        throw new NoSuchElementException();
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, Phonemetadata.NumberFormat numberFormat) {
        return phoneNumberUtil.formatNsnUsingPattern(phoneNumberUtil.getNationalSignificantNumber(phoneNumber), numberFormat, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
    }
}
