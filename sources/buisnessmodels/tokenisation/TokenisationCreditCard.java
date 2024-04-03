package buisnessmodels.tokenisation;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Deprecated
public class TokenisationCreditCard {
    public String binNumber;
    public String cardnumber;
    public String cardtype;
    public String expiredate;
    public int expiremonth;
    public int expireyear;
    public String holdername;
    public boolean isBinDiscountValid = false;
    public boolean isForceCvv = false;
    public boolean isValidCard;
    public String message = "";
    public String token;
    public String tokenId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TokenisationCreditCard tokenisationCreditCard = (TokenisationCreditCard) obj;
        if (this.expireyear != tokenisationCreditCard.expireyear || this.expiremonth != tokenisationCreditCard.expiremonth || this.isValidCard != tokenisationCreditCard.isValidCard || this.isBinDiscountValid != tokenisationCreditCard.isBinDiscountValid || this.isForceCvv != tokenisationCreditCard.isForceCvv) {
            return false;
        }
        String str = this.token;
        if (str == null ? tokenisationCreditCard.token != null : !str.equals(tokenisationCreditCard.token)) {
            return false;
        }
        String str2 = this.holdername;
        if (str2 == null ? tokenisationCreditCard.holdername != null : !str2.equals(tokenisationCreditCard.holdername)) {
            return false;
        }
        String str3 = this.cardnumber;
        if (str3 == null ? tokenisationCreditCard.cardnumber != null : !str3.equals(tokenisationCreditCard.cardnumber)) {
            return false;
        }
        String str4 = this.cardtype;
        if (str4 == null ? tokenisationCreditCard.cardtype != null : !str4.equals(tokenisationCreditCard.cardtype)) {
            return false;
        }
        String str5 = this.expiredate;
        if (str5 == null ? tokenisationCreditCard.expiredate != null : !str5.equals(tokenisationCreditCard.expiredate)) {
            return false;
        }
        String str6 = this.message;
        if (str6 == null ? tokenisationCreditCard.message != null : !str6.equals(tokenisationCreditCard.message)) {
            return false;
        }
        String str7 = this.tokenId;
        if (str7 == null ? tokenisationCreditCard.tokenId != null : !str7.equals(tokenisationCreditCard.tokenId)) {
            return false;
        }
        String str8 = this.binNumber;
        String str9 = tokenisationCreditCard.binNumber;
        if (str8 != null) {
            return str8.equals(str9);
        }
        if (str9 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        String str = this.token;
        int i18 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i19 = i11 * 31;
        String str2 = this.holdername;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i21 = (i19 + i12) * 31;
        String str3 = this.cardnumber;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i22 = (i21 + i13) * 31;
        String str4 = this.cardtype;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i23 = (i22 + i14) * 31;
        String str5 = this.expiredate;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i24 = (((((((((i23 + i15) * 31) + this.expireyear) * 31) + this.expiremonth) * 31) + (this.isValidCard ? 1 : 0)) * 31) + (this.isBinDiscountValid ? 1 : 0)) * 31;
        String str6 = this.message;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i25 = (i24 + i16) * 31;
        String str7 = this.binNumber;
        if (str7 != null) {
            i17 = str7.hashCode();
        } else {
            i17 = 0;
        }
        int i26 = (i25 + i17) * 31;
        String str8 = this.tokenId;
        if (str8 != null) {
            i18 = str8.hashCode();
        }
        return ((i26 + i18) * 31) + (this.isForceCvv ? 1 : 0);
    }

    public String toString() {
        return "TokenisationCreditCard{token='" + this.token + '\'' + ", holdername='" + this.holdername + '\'' + ", cardnumber='" + this.cardnumber + '\'' + ", cardtype='" + this.cardtype + '\'' + ", expiredate='" + this.expiredate + '\'' + ", expireyear=" + this.expireyear + ", expiremonth=" + this.expiremonth + ", isValidCard=" + this.isValidCard + ", isBinDiscountValid=" + this.isBinDiscountValid + ", message='" + this.message + '\'' + ", binNumber='" + this.binNumber + '\'' + ", isForceCvv=" + this.isForceCvv + '\'' + ", tokenId=" + this.tokenId + AbstractJsonLexerKt.END_OBJ;
    }
}
