package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonenumber;
import java.util.Arrays;

public final class PhoneNumberMatch {
    private final Phonenumber.PhoneNumber number;
    private final String rawString;
    private final int start;

    public PhoneNumberMatch(int i11, String str, Phonenumber.PhoneNumber phoneNumber) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Start index must be >= 0.");
        } else if (str == null || phoneNumber == null) {
            throw null;
        } else {
            this.start = i11;
            this.rawString = str;
            this.number = phoneNumber;
        }
    }

    public int end() {
        return this.start + this.rawString.length();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneNumberMatch)) {
            return false;
        }
        PhoneNumberMatch phoneNumberMatch = (PhoneNumberMatch) obj;
        if (!this.rawString.equals(phoneNumberMatch.rawString) || this.start != phoneNumberMatch.start || !this.number.equals(phoneNumberMatch.number)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.start), this.rawString, this.number});
    }

    public Phonenumber.PhoneNumber number() {
        return this.number;
    }

    public String rawString() {
        return this.rawString;
    }

    public int start() {
        return this.start;
    }

    public String toString() {
        return "PhoneNumberMatch [" + start() + "," + end() + ") " + this.rawString;
    }
}
