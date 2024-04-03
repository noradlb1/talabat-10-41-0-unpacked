package com.checkout.base.model;

import androidx.annotation.DrawableRes;
import com.checkout.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\b\u0001\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 BI\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006!"}, d2 = {"Lcom/checkout/base/model/CardScheme;", "", "cvvLength", "", "", "regex", "Lkotlin/text/Regex;", "eagerRegex", "maxNumberLength", "numberSeparatorPattern", "", "imageId", "(Ljava/lang/String;ILjava/util/Set;Lkotlin/text/Regex;Lkotlin/text/Regex;ILjava/util/List;I)V", "getCvvLength", "()Ljava/util/Set;", "getEagerRegex$checkout_release", "()Lkotlin/text/Regex;", "getImageId", "()I", "getMaxNumberLength", "getNumberSeparatorPattern", "()Ljava/util/List;", "getRegex$checkout_release", "AMERICAN_EXPRESS", "DINERS_CLUB", "DISCOVER", "JCB", "MADA", "MAESTRO", "MASTERCARD", "VISA", "UNKNOWN", "Companion", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum CardScheme {
    AMERICAN_EXPRESS(SetsKt__SetsJVMKt.setOf(4), new Regex("^3[47]\\d{13}$"), new Regex("^3[47]\\d*$"), 15, CollectionsKt__CollectionsKt.listOf(4, 11), R.drawable.cko_ic_scheme_amex),
    DINERS_CLUB(r19, r20, r21, 19, CollectionsKt__CollectionsKt.listOf(4, 9, 14, 19), R.drawable.cko_ic_scheme_diners),
    DISCOVER(r28, r29, r30, 16, CollectionsKt__CollectionsKt.listOf(4, 9, 14), R.drawable.cko_ic_scheme_discover),
    JCB(r19, r20, r21, 19, CollectionsKt__CollectionsKt.listOf(4, 9, 14, 19), R.drawable.cko_ic_scheme_jcb),
    MADA(r28, r3, new Regex("^(4(0(0861|1757|6996|7(197|395)|9201)|1(2565|0685|7633|9593)|2(281(7|8|9)|8(331|67(1|2|3)))|3(1361|2328|4107|9954)|4(0(533|647|795)|5564|6(393|404|672))|5(5(036|708)|7865|7997|8456)|6(2220|854(0|1|2|3))|8(301(0|1|2)|4783|609(4|5|6)|931(7|8|9))|93428)|5(0(4300|6968|8160)|13213|2(0058|1076|4(130|514)|9(415|741))|3(0(060|906)|1(095|196)|2013|5(825|989)|6023|7767|9931)|4(3(085|357)|9760)|5(4180|7606|8848)|8(5265|8(8(4(5|6|7|8|9)|5(0|1))|98(2|3))|9(005|206)))|6(0(4906|5141)|36120)|9682(0(1|2|3|4|5|6|7|8|9)|1(0|1)))\\d*$"), 0, (Regex) null, R.drawable.cko_ic_scheme_mada, 24, (int) null),
    MAESTRO(r19, r20, r21, 19, CollectionsKt__CollectionsKt.listOf(4, 9, 14, 19), R.drawable.cko_ic_scheme_maestro),
    MASTERCARD(r28, r3, new Regex("^(2[3-7]|22[2-9]|5[1-5])\\d*$"), 0, (Regex) null, R.drawable.cko_ic_scheme_mastercard, 24, (int) null),
    VISA(r19, r20, r21, 19, CollectionsKt__CollectionsKt.listOf(4, 9, 14, 19), R.drawable.cko_ic_scheme_visa),
    UNKNOWN(r28, r29, r30, 19, CollectionsKt__CollectionsKt.listOf(4, 9, 14, 19), 0, 32, (int) null);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final Set<Integer> cvvLength;
    @NotNull
    private final Regex eagerRegex;
    private final int imageId;
    private final int maxNumberLength;
    @NotNull
    private final List<Integer> numberSeparatorPattern;
    @NotNull
    private final Regex regex;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/checkout/base/model/CardScheme$Companion;", "", "()V", "fetchAllSupportedCardSchemes", "", "Lcom/checkout/base/model/CardScheme;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final List<CardScheme> fetchAllSupportedCardSchemes() {
            ArrayList arrayList = new ArrayList();
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (T[]) CardScheme.values());
            arrayList.remove(CardScheme.UNKNOWN);
            return arrayList;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private CardScheme(Set<Integer> set, Regex regex2, Regex regex3, int i11, List<Integer> list, @DrawableRes int i12) {
        this.cvvLength = set;
        this.regex = regex2;
        this.eagerRegex = regex3;
        this.maxNumberLength = i11;
        this.numberSeparatorPattern = list;
        this.imageId = i12;
    }

    @JvmStatic
    @NotNull
    public static final List<CardScheme> fetchAllSupportedCardSchemes() {
        return Companion.fetchAllSupportedCardSchemes();
    }

    @NotNull
    public final Set<Integer> getCvvLength() {
        return this.cvvLength;
    }

    @NotNull
    public final Regex getEagerRegex$checkout_release() {
        return this.eagerRegex;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final int getMaxNumberLength() {
        return this.maxNumberLength;
    }

    @NotNull
    public final List<Integer> getNumberSeparatorPattern() {
        return this.numberSeparatorPattern;
    }

    @NotNull
    public final Regex getRegex$checkout_release() {
        return this.regex;
    }
}
