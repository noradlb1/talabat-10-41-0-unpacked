package datamodels;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b9\b\b\u0018\u00002\u00020\u0001B½\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u00109\u001a\u00020\nHÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#JÆ\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b(\u0010#R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u001a\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b*\u0010#R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001c¨\u0006C"}, d2 = {"Ldatamodels/FaqQuestionsAns;", "", "deeplinkId", "", "questionId", "question", "", "answer", "soertIndex", "showChatCTA", "", "showChatQuestion", "showVendorPhone", "showRiderChat", "showOrder", "showRateOrder", "ccr1", "ccr2", "ccr3", "shouldSoftDeflect", "dhCode", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "getCcr1", "getCcr2", "getCcr3", "getDeeplinkId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDhCode", "getQuestion", "getQuestionId", "()I", "getShouldSoftDeflect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowChatCTA", "()Z", "getShowChatQuestion", "getShowOrder", "getShowRateOrder", "getShowRiderChat", "getShowVendorPhone", "getSoertIndex", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Ldatamodels/FaqQuestionsAns;", "equals", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaqQuestionsAns {
    @SerializedName("answer")
    @Nullable
    private final String answer;
    @SerializedName("ccr1")
    @Nullable
    private final String ccr1;
    @SerializedName("ccr2")
    @Nullable
    private final String ccr2;
    @SerializedName("ccr3")
    @Nullable
    private final String ccr3;
    @SerializedName("deeplinkId")
    @Nullable
    private final Integer deeplinkId;
    @SerializedName("dhCode")
    @Nullable
    private final String dhCode;
    @SerializedName("question")
    @Nullable
    private final String question;
    @SerializedName("id")
    private final int questionId;
    @SerializedName("shouldSoftDeflect")
    @Nullable
    private final Boolean shouldSoftDeflect;
    @SerializedName("showChatCTA")
    private final boolean showChatCTA;
    @SerializedName("showChatQuestion")
    private final boolean showChatQuestion;
    @SerializedName("showOrder")
    @Nullable
    private final Boolean showOrder;
    @SerializedName("rateOrder")
    @Nullable
    private final Boolean showRateOrder;
    @SerializedName("showRiderChat")
    @Nullable
    private final Boolean showRiderChat;
    @SerializedName("showVendorPhone")
    private final boolean showVendorPhone;
    @SerializedName("sortIndex")
    @Nullable
    private final Integer soertIndex;

    public FaqQuestionsAns() {
        this((Integer) null, 0, (String) null, (String) null, (Integer) null, false, false, false, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, 65535, (DefaultConstructorMarker) null);
    }

    public FaqQuestionsAns(@Nullable Integer num, int i11, @Nullable String str, @Nullable String str2, @Nullable Integer num2, boolean z11, boolean z12, boolean z13, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool4, @Nullable String str6) {
        this.deeplinkId = num;
        this.questionId = i11;
        this.question = str;
        this.answer = str2;
        this.soertIndex = num2;
        this.showChatCTA = z11;
        this.showChatQuestion = z12;
        this.showVendorPhone = z13;
        this.showRiderChat = bool;
        this.showOrder = bool2;
        this.showRateOrder = bool3;
        this.ccr1 = str3;
        this.ccr2 = str4;
        this.ccr3 = str5;
        this.shouldSoftDeflect = bool4;
        this.dhCode = str6;
    }

    public static /* synthetic */ FaqQuestionsAns copy$default(FaqQuestionsAns faqQuestionsAns, Integer num, int i11, String str, String str2, Integer num2, boolean z11, boolean z12, boolean z13, Boolean bool, Boolean bool2, Boolean bool3, String str3, String str4, String str5, Boolean bool4, String str6, int i12, Object obj) {
        FaqQuestionsAns faqQuestionsAns2 = faqQuestionsAns;
        int i13 = i12;
        return faqQuestionsAns.copy((i13 & 1) != 0 ? faqQuestionsAns2.deeplinkId : num, (i13 & 2) != 0 ? faqQuestionsAns2.questionId : i11, (i13 & 4) != 0 ? faqQuestionsAns2.question : str, (i13 & 8) != 0 ? faqQuestionsAns2.answer : str2, (i13 & 16) != 0 ? faqQuestionsAns2.soertIndex : num2, (i13 & 32) != 0 ? faqQuestionsAns2.showChatCTA : z11, (i13 & 64) != 0 ? faqQuestionsAns2.showChatQuestion : z12, (i13 & 128) != 0 ? faqQuestionsAns2.showVendorPhone : z13, (i13 & 256) != 0 ? faqQuestionsAns2.showRiderChat : bool, (i13 & 512) != 0 ? faqQuestionsAns2.showOrder : bool2, (i13 & 1024) != 0 ? faqQuestionsAns2.showRateOrder : bool3, (i13 & 2048) != 0 ? faqQuestionsAns2.ccr1 : str3, (i13 & 4096) != 0 ? faqQuestionsAns2.ccr2 : str4, (i13 & 8192) != 0 ? faqQuestionsAns2.ccr3 : str5, (i13 & 16384) != 0 ? faqQuestionsAns2.shouldSoftDeflect : bool4, (i13 & 32768) != 0 ? faqQuestionsAns2.dhCode : str6);
    }

    @Nullable
    public final Integer component1() {
        return this.deeplinkId;
    }

    @Nullable
    public final Boolean component10() {
        return this.showOrder;
    }

    @Nullable
    public final Boolean component11() {
        return this.showRateOrder;
    }

    @Nullable
    public final String component12() {
        return this.ccr1;
    }

    @Nullable
    public final String component13() {
        return this.ccr2;
    }

    @Nullable
    public final String component14() {
        return this.ccr3;
    }

    @Nullable
    public final Boolean component15() {
        return this.shouldSoftDeflect;
    }

    @Nullable
    public final String component16() {
        return this.dhCode;
    }

    public final int component2() {
        return this.questionId;
    }

    @Nullable
    public final String component3() {
        return this.question;
    }

    @Nullable
    public final String component4() {
        return this.answer;
    }

    @Nullable
    public final Integer component5() {
        return this.soertIndex;
    }

    public final boolean component6() {
        return this.showChatCTA;
    }

    public final boolean component7() {
        return this.showChatQuestion;
    }

    public final boolean component8() {
        return this.showVendorPhone;
    }

    @Nullable
    public final Boolean component9() {
        return this.showRiderChat;
    }

    @NotNull
    public final FaqQuestionsAns copy(@Nullable Integer num, int i11, @Nullable String str, @Nullable String str2, @Nullable Integer num2, boolean z11, boolean z12, boolean z13, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool4, @Nullable String str6) {
        return new FaqQuestionsAns(num, i11, str, str2, num2, z11, z12, z13, bool, bool2, bool3, str3, str4, str5, bool4, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FaqQuestionsAns)) {
            return false;
        }
        FaqQuestionsAns faqQuestionsAns = (FaqQuestionsAns) obj;
        return Intrinsics.areEqual((Object) this.deeplinkId, (Object) faqQuestionsAns.deeplinkId) && this.questionId == faqQuestionsAns.questionId && Intrinsics.areEqual((Object) this.question, (Object) faqQuestionsAns.question) && Intrinsics.areEqual((Object) this.answer, (Object) faqQuestionsAns.answer) && Intrinsics.areEqual((Object) this.soertIndex, (Object) faqQuestionsAns.soertIndex) && this.showChatCTA == faqQuestionsAns.showChatCTA && this.showChatQuestion == faqQuestionsAns.showChatQuestion && this.showVendorPhone == faqQuestionsAns.showVendorPhone && Intrinsics.areEqual((Object) this.showRiderChat, (Object) faqQuestionsAns.showRiderChat) && Intrinsics.areEqual((Object) this.showOrder, (Object) faqQuestionsAns.showOrder) && Intrinsics.areEqual((Object) this.showRateOrder, (Object) faqQuestionsAns.showRateOrder) && Intrinsics.areEqual((Object) this.ccr1, (Object) faqQuestionsAns.ccr1) && Intrinsics.areEqual((Object) this.ccr2, (Object) faqQuestionsAns.ccr2) && Intrinsics.areEqual((Object) this.ccr3, (Object) faqQuestionsAns.ccr3) && Intrinsics.areEqual((Object) this.shouldSoftDeflect, (Object) faqQuestionsAns.shouldSoftDeflect) && Intrinsics.areEqual((Object) this.dhCode, (Object) faqQuestionsAns.dhCode);
    }

    @Nullable
    public final String getAnswer() {
        return this.answer;
    }

    @Nullable
    public final String getCcr1() {
        return this.ccr1;
    }

    @Nullable
    public final String getCcr2() {
        return this.ccr2;
    }

    @Nullable
    public final String getCcr3() {
        return this.ccr3;
    }

    @Nullable
    public final Integer getDeeplinkId() {
        return this.deeplinkId;
    }

    @Nullable
    public final String getDhCode() {
        return this.dhCode;
    }

    @Nullable
    public final String getQuestion() {
        return this.question;
    }

    public final int getQuestionId() {
        return this.questionId;
    }

    @Nullable
    public final Boolean getShouldSoftDeflect() {
        return this.shouldSoftDeflect;
    }

    public final boolean getShowChatCTA() {
        return this.showChatCTA;
    }

    public final boolean getShowChatQuestion() {
        return this.showChatQuestion;
    }

    @Nullable
    public final Boolean getShowOrder() {
        return this.showOrder;
    }

    @Nullable
    public final Boolean getShowRateOrder() {
        return this.showRateOrder;
    }

    @Nullable
    public final Boolean getShowRiderChat() {
        return this.showRiderChat;
    }

    public final boolean getShowVendorPhone() {
        return this.showVendorPhone;
    }

    @Nullable
    public final Integer getSoertIndex() {
        return this.soertIndex;
    }

    public int hashCode() {
        Integer num = this.deeplinkId;
        int i11 = 0;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.questionId) * 31;
        String str = this.question;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.answer;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.soertIndex;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        boolean z11 = this.showChatCTA;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode4 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.showChatQuestion;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.showVendorPhone;
        if (!z14) {
            z12 = z14;
        }
        int i14 = (i13 + (z12 ? 1 : 0)) * 31;
        Boolean bool = this.showRiderChat;
        int hashCode5 = (i14 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.showOrder;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.showRateOrder;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str3 = this.ccr1;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ccr2;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ccr3;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool4 = this.shouldSoftDeflect;
        int hashCode11 = (hashCode10 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str6 = this.dhCode;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode11 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.deeplinkId;
        int i11 = this.questionId;
        String str = this.question;
        String str2 = this.answer;
        Integer num2 = this.soertIndex;
        boolean z11 = this.showChatCTA;
        boolean z12 = this.showChatQuestion;
        boolean z13 = this.showVendorPhone;
        Boolean bool = this.showRiderChat;
        Boolean bool2 = this.showOrder;
        Boolean bool3 = this.showRateOrder;
        String str3 = this.ccr1;
        String str4 = this.ccr2;
        String str5 = this.ccr3;
        Boolean bool4 = this.shouldSoftDeflect;
        String str6 = this.dhCode;
        return "FaqQuestionsAns(deeplinkId=" + num + ", questionId=" + i11 + ", question=" + str + ", answer=" + str2 + ", soertIndex=" + num2 + ", showChatCTA=" + z11 + ", showChatQuestion=" + z12 + ", showVendorPhone=" + z13 + ", showRiderChat=" + bool + ", showOrder=" + bool2 + ", showRateOrder=" + bool3 + ", ccr1=" + str3 + ", ccr2=" + str4 + ", ccr3=" + str5 + ", shouldSoftDeflect=" + bool4 + ", dhCode=" + str6 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FaqQuestionsAns(java.lang.Integer r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.Integer r22, boolean r23, boolean r24, boolean r25, java.lang.Boolean r26, java.lang.Boolean r27, java.lang.Boolean r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.Boolean r32, java.lang.String r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0013
        L_0x0011:
            r3 = r19
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = 0
            goto L_0x001b
        L_0x0019:
            r5 = r20
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r21
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002c
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            goto L_0x002e
        L_0x002c:
            r7 = r22
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r4 = r23
        L_0x0035:
            r8 = r0 & 64
            r9 = 1
            if (r8 == 0) goto L_0x003c
            r8 = r9
            goto L_0x003e
        L_0x003c:
            r8 = r24
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r9 = r25
        L_0x0045:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004c
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            goto L_0x004e
        L_0x004c:
            r10 = r26
        L_0x004e:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0055
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            goto L_0x0057
        L_0x0055:
            r11 = r27
        L_0x0057:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005e
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            goto L_0x0060
        L_0x005e:
            r12 = r28
        L_0x0060:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0066
            r13 = 0
            goto L_0x0068
        L_0x0066:
            r13 = r29
        L_0x0068:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006e
            r14 = 0
            goto L_0x0070
        L_0x006e:
            r14 = r30
        L_0x0070:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0076
            r15 = 0
            goto L_0x0078
        L_0x0076:
            r15 = r31
        L_0x0078:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007f
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L_0x0081
        L_0x007f:
            r2 = r32
        L_0x0081:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x008a
            r0 = 0
            goto L_0x008c
        L_0x008a:
            r0 = r33
        L_0x008c:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r4
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.FaqQuestionsAns.<init>(java.lang.Integer, int, java.lang.String, java.lang.String, java.lang.Integer, boolean, boolean, boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
