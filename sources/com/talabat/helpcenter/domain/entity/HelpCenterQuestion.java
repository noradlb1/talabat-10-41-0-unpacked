package com.talabat.helpcenter.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006 "}, d2 = {"Lcom/talabat/helpcenter/domain/entity/HelpCenterQuestion;", "", "id", "", "question", "", "answer", "deepLinkId", "config", "Lcom/talabat/helpcenter/domain/entity/HelpCenterConfig;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/helpcenter/domain/entity/HelpCenterConfig;)V", "getAnswer", "()Ljava/lang/String;", "getConfig", "()Lcom/talabat/helpcenter/domain/entity/HelpCenterConfig;", "getDeepLinkId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getQuestion", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/helpcenter/domain/entity/HelpCenterConfig;)Lcom/talabat/helpcenter/domain/entity/HelpCenterQuestion;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterQuestion {
    @Nullable
    private final String answer;
    @Nullable
    private final HelpCenterConfig config;
    @Nullable
    private final Integer deepLinkId;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f60748id;
    @Nullable
    private final String question;

    public HelpCenterQuestion() {
        this((Integer) null, (String) null, (String) null, (Integer) null, (HelpCenterConfig) null, 31, (DefaultConstructorMarker) null);
    }

    public HelpCenterQuestion(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable HelpCenterConfig helpCenterConfig) {
        this.f60748id = num;
        this.question = str;
        this.answer = str2;
        this.deepLinkId = num2;
        this.config = helpCenterConfig;
    }

    public static /* synthetic */ HelpCenterQuestion copy$default(HelpCenterQuestion helpCenterQuestion, Integer num, String str, String str2, Integer num2, HelpCenterConfig helpCenterConfig, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = helpCenterQuestion.f60748id;
        }
        if ((i11 & 2) != 0) {
            str = helpCenterQuestion.question;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            str2 = helpCenterQuestion.answer;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            num2 = helpCenterQuestion.deepLinkId;
        }
        Integer num3 = num2;
        if ((i11 & 16) != 0) {
            helpCenterConfig = helpCenterQuestion.config;
        }
        return helpCenterQuestion.copy(num, str3, str4, num3, helpCenterConfig);
    }

    @Nullable
    public final Integer component1() {
        return this.f60748id;
    }

    @Nullable
    public final String component2() {
        return this.question;
    }

    @Nullable
    public final String component3() {
        return this.answer;
    }

    @Nullable
    public final Integer component4() {
        return this.deepLinkId;
    }

    @Nullable
    public final HelpCenterConfig component5() {
        return this.config;
    }

    @NotNull
    public final HelpCenterQuestion copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable HelpCenterConfig helpCenterConfig) {
        return new HelpCenterQuestion(num, str, str2, num2, helpCenterConfig);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterQuestion)) {
            return false;
        }
        HelpCenterQuestion helpCenterQuestion = (HelpCenterQuestion) obj;
        return Intrinsics.areEqual((Object) this.f60748id, (Object) helpCenterQuestion.f60748id) && Intrinsics.areEqual((Object) this.question, (Object) helpCenterQuestion.question) && Intrinsics.areEqual((Object) this.answer, (Object) helpCenterQuestion.answer) && Intrinsics.areEqual((Object) this.deepLinkId, (Object) helpCenterQuestion.deepLinkId) && Intrinsics.areEqual((Object) this.config, (Object) helpCenterQuestion.config);
    }

    @Nullable
    public final String getAnswer() {
        return this.answer;
    }

    @Nullable
    public final HelpCenterConfig getConfig() {
        return this.config;
    }

    @Nullable
    public final Integer getDeepLinkId() {
        return this.deepLinkId;
    }

    @Nullable
    public final Integer getId() {
        return this.f60748id;
    }

    @Nullable
    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        Integer num = this.f60748id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.question;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.answer;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.deepLinkId;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        HelpCenterConfig helpCenterConfig = this.config;
        if (helpCenterConfig != null) {
            i11 = helpCenterConfig.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.f60748id;
        String str = this.question;
        String str2 = this.answer;
        Integer num2 = this.deepLinkId;
        HelpCenterConfig helpCenterConfig = this.config;
        return "HelpCenterQuestion(id=" + num + ", question=" + str + ", answer=" + str2 + ", deepLinkId=" + num2 + ", config=" + helpCenterConfig + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HelpCenterQuestion(java.lang.Integer r5, java.lang.String r6, java.lang.String r7, java.lang.Integer r8, com.talabat.helpcenter.domain.entity.HelpCenterConfig r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpcenter.domain.entity.HelpCenterQuestion.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, com.talabat.helpcenter.domain.entity.HelpCenterConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
