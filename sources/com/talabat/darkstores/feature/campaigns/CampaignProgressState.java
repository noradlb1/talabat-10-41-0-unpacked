package com.talabat.darkstores.feature.campaigns;

import com.talabat.darkstores.data.grocery.model.CampaignProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\u00020\u0001:\u0006\u0016\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0001\u0005\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "", "()V", "animationPauseMillis", "", "getAnimationPauseMillis", "()Ljava/lang/Long;", "isTPro", "", "()Z", "message", "", "getMessage", "()Ljava/lang/String;", "progress", "", "getProgress", "()Ljava/lang/Integer;", "source", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "getSource", "()Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "BelowThreshold", "Companion", "Hidden", "InProgress", "Success", "Transient", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Hidden;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$BelowThreshold;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$InProgress;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Success;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Transient;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CampaignProgressState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MILLIS_MULTIPLIER = 1000;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Companion;", "", "()V", "MILLIS_MULTIPLIER", "", "fromResponse", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "response", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CampaignProgress.State.values().length];
                iArr[CampaignProgress.State.HIDDEN.ordinal()] = 1;
                iArr[CampaignProgress.State.SUCCESS.ordinal()] = 2;
                iArr[CampaignProgress.State.IN_PROGRESS.ordinal()] = 3;
                iArr[CampaignProgress.State.BELOW_THRESHOLD.ordinal()] = 4;
                iArr[CampaignProgress.State.TRANSIENT.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.Integer} */
        /* JADX WARNING: type inference failed for: r5v7, types: [java.lang.Long] */
        /* JADX WARNING: type inference failed for: r5v9, types: [java.lang.Long] */
        /* JADX WARNING: type inference failed for: r5v12, types: [java.lang.Long] */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.talabat.darkstores.feature.campaigns.CampaignProgressState fromResponse(@org.jetbrains.annotations.NotNull com.talabat.darkstores.data.grocery.model.CampaignProgress r19) {
            /*
                r18 = this;
                java.lang.String r0 = "response"
                r1 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                com.talabat.darkstores.data.grocery.model.CampaignProgress$State r0 = r19.getState()
                if (r0 != 0) goto L_0x000f
                r0 = -1
                goto L_0x0017
            L_0x000f:
                int[] r2 = com.talabat.darkstores.feature.campaigns.CampaignProgressState.Companion.WhenMappings.$EnumSwitchMapping$0
                int r0 = r0.ordinal()
                r0 = r2[r0]
            L_0x0017:
                r2 = 1
                if (r0 == r2) goto L_0x011e
                r2 = 2
                r3 = 1000(0x3e8, float:1.401E-42)
                java.lang.String r4 = ""
                r5 = 0
                if (r0 == r2) goto L_0x00db
                r2 = 3
                if (r0 == r2) goto L_0x0097
                r2 = 4
                if (r0 == r2) goto L_0x0054
                r2 = 5
                if (r0 == r2) goto L_0x002f
                com.talabat.darkstores.feature.campaigns.CampaignProgressState$Hidden r0 = com.talabat.darkstores.feature.campaigns.CampaignProgressState.Hidden.INSTANCE
                goto L_0x0120
            L_0x002f:
                com.talabat.darkstores.feature.campaigns.CampaignProgressState$Transient r0 = new com.talabat.darkstores.feature.campaigns.CampaignProgressState$Transient
                java.lang.String r2 = r19.getMessage()
                if (r2 != 0) goto L_0x0038
                r2 = r4
            L_0x0038:
                java.lang.Long r1 = r19.getShowForSeconds()
                if (r1 == 0) goto L_0x0048
                long r4 = r1.longValue()
                long r6 = (long) r3
                long r4 = r4 * r6
                java.lang.Long r5 = java.lang.Long.valueOf(r4)
            L_0x0048:
                r3 = r5
                r4 = 0
                r5 = 0
                r6 = 12
                r7 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)
                goto L_0x0120
            L_0x0054:
                com.talabat.darkstores.feature.campaigns.CampaignProgressState$BelowThreshold r0 = new com.talabat.darkstores.feature.campaigns.CampaignProgressState$BelowThreshold
                java.lang.String r2 = r19.getMessage()
                if (r2 != 0) goto L_0x005e
                r9 = r4
                goto L_0x005f
            L_0x005e:
                r9 = r2
            L_0x005f:
                java.lang.Float r2 = r19.getProgressValue()
                if (r2 == 0) goto L_0x0073
                float r2 = r2.floatValue()
                int r2 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r10 = r2
                goto L_0x0074
            L_0x0073:
                r10 = r5
            L_0x0074:
                java.lang.Long r2 = r19.getShowForSeconds()
                if (r2 == 0) goto L_0x0084
                long r4 = r2.longValue()
                long r2 = (long) r3
                long r4 = r4 * r2
                java.lang.Long r5 = java.lang.Long.valueOf(r4)
            L_0x0084:
                r11 = r5
                java.lang.Boolean r1 = r19.isTPro()
                boolean r12 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r1)
                r13 = 0
                r14 = 16
                r15 = 0
                r8 = r0
                r8.<init>(r9, r10, r11, r12, r13, r14, r15)
                goto L_0x0120
            L_0x0097:
                com.talabat.darkstores.feature.campaigns.CampaignProgressState$InProgress r0 = new com.talabat.darkstores.feature.campaigns.CampaignProgressState$InProgress
                java.lang.String r2 = r19.getMessage()
                if (r2 != 0) goto L_0x00a0
                r2 = r4
            L_0x00a0:
                java.lang.Float r4 = r19.getProgressValue()
                if (r4 == 0) goto L_0x00b3
                float r4 = r4.floatValue()
                int r4 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r4)
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                goto L_0x00b4
            L_0x00b3:
                r4 = r5
            L_0x00b4:
                java.lang.Long r6 = r19.getShowForSeconds()
                if (r6 == 0) goto L_0x00c4
                long r5 = r6.longValue()
                long r7 = (long) r3
                long r5 = r5 * r7
                java.lang.Long r5 = java.lang.Long.valueOf(r5)
            L_0x00c4:
                java.lang.Boolean r1 = r19.isTPro()
                boolean r6 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r1)
                r7 = 0
                r8 = 16
                r9 = 0
                r1 = r0
                r3 = r4
                r4 = r5
                r5 = r6
                r6 = r7
                r7 = r8
                r8 = r9
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                goto L_0x0120
            L_0x00db:
                com.talabat.darkstores.feature.campaigns.CampaignProgressState$Success r0 = new com.talabat.darkstores.feature.campaigns.CampaignProgressState$Success
                java.lang.String r2 = r19.getMessage()
                if (r2 != 0) goto L_0x00e5
                r11 = r4
                goto L_0x00e6
            L_0x00e5:
                r11 = r2
            L_0x00e6:
                java.lang.Long r2 = r19.getShowForSeconds()
                if (r2 == 0) goto L_0x00f8
                long r6 = r2.longValue()
                long r2 = (long) r3
                long r6 = r6 * r2
                java.lang.Long r2 = java.lang.Long.valueOf(r6)
                r12 = r2
                goto L_0x00f9
            L_0x00f8:
                r12 = r5
            L_0x00f9:
                java.lang.Boolean r2 = r19.isTPro()
                boolean r13 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r2)
                java.lang.Float r1 = r19.getProgressValue()
                if (r1 == 0) goto L_0x0113
                float r1 = r1.floatValue()
                int r1 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r1)
                java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            L_0x0113:
                r14 = r5
                r15 = 0
                r16 = 16
                r17 = 0
                r10 = r0
                r10.<init>(r11, r12, r13, r14, r15, r16, r17)
                goto L_0x0120
            L_0x011e:
                com.talabat.darkstores.feature.campaigns.CampaignProgressState$Hidden r0 = com.talabat.darkstores.feature.campaigns.CampaignProgressState.Hidden.INSTANCE
            L_0x0120:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.campaigns.CampaignProgressState.Companion.fromResponse(com.talabat.darkstores.data.grocery.model.CampaignProgress):com.talabat.darkstores.feature.campaigns.CampaignProgressState");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Hidden;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "()V", "animationPauseMillis", "", "getAnimationPauseMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isTPro", "", "()Z", "message", "", "getMessage", "()Ljava/lang/String;", "progress", "", "getProgress", "()Ljava/lang/Integer;", "source", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "getSource", "()Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends CampaignProgressState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();
        @Nullable
        private static final Long animationPauseMillis = null;
        private static final boolean isTPro = false;
        @NotNull
        private static final String message = "";
        private static final int progress = 0;
        @NotNull
        private static final CampaignProgressStateSource source = CampaignProgressStateSource.UNKNOWN;

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }

        @Nullable
        public Long getAnimationPauseMillis() {
            return animationPauseMillis;
        }

        @NotNull
        public String getMessage() {
            return message;
        }

        @NotNull
        public Integer getProgress() {
            return Integer.valueOf(progress);
        }

        @NotNull
        public CampaignProgressStateSource getSource() {
            return source;
        }

        public boolean isTPro() {
            return isTPro;
        }
    }

    private CampaignProgressState() {
    }

    public /* synthetic */ CampaignProgressState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public abstract Long getAnimationPauseMillis();

    @NotNull
    public abstract String getMessage();

    @Nullable
    public abstract Integer getProgress();

    @NotNull
    public abstract CampaignProgressStateSource getSource();

    public abstract boolean isTPro();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JD\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$BelowThreshold;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "message", "", "progress", "", "animationPauseMillis", "", "isTPro", "", "source", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;ZLcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)V", "getAnimationPauseMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getMessage", "()Ljava/lang/String;", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSource", "()Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;ZLcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$BelowThreshold;", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BelowThreshold extends CampaignProgressState {
        @Nullable
        private final Long animationPauseMillis;
        private final boolean isTPro;
        @NotNull
        private final String message;
        @Nullable
        private final Integer progress;
        @NotNull
        private final CampaignProgressStateSource source;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BelowThreshold(String str, Integer num, Long l11, boolean z11, CampaignProgressStateSource campaignProgressStateSource, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, num, l11, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? CampaignProgressStateSource.UNKNOWN : campaignProgressStateSource);
        }

        public static /* synthetic */ BelowThreshold copy$default(BelowThreshold belowThreshold, String str, Integer num, Long l11, boolean z11, CampaignProgressStateSource campaignProgressStateSource, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = belowThreshold.getMessage();
            }
            if ((i11 & 2) != 0) {
                num = belowThreshold.getProgress();
            }
            Integer num2 = num;
            if ((i11 & 4) != 0) {
                l11 = belowThreshold.getAnimationPauseMillis();
            }
            Long l12 = l11;
            if ((i11 & 8) != 0) {
                z11 = belowThreshold.isTPro();
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                campaignProgressStateSource = belowThreshold.getSource();
            }
            return belowThreshold.copy(str, num2, l12, z12, campaignProgressStateSource);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @Nullable
        public final Integer component2() {
            return getProgress();
        }

        @Nullable
        public final Long component3() {
            return getAnimationPauseMillis();
        }

        public final boolean component4() {
            return isTPro();
        }

        @NotNull
        public final CampaignProgressStateSource component5() {
            return getSource();
        }

        @NotNull
        public final BelowThreshold copy(@NotNull String str, @Nullable Integer num, @Nullable Long l11, boolean z11, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            return new BelowThreshold(str, num, l11, z11, campaignProgressStateSource);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BelowThreshold)) {
                return false;
            }
            BelowThreshold belowThreshold = (BelowThreshold) obj;
            return Intrinsics.areEqual((Object) getMessage(), (Object) belowThreshold.getMessage()) && Intrinsics.areEqual((Object) getProgress(), (Object) belowThreshold.getProgress()) && Intrinsics.areEqual((Object) getAnimationPauseMillis(), (Object) belowThreshold.getAnimationPauseMillis()) && isTPro() == belowThreshold.isTPro() && getSource() == belowThreshold.getSource();
        }

        @Nullable
        public Long getAnimationPauseMillis() {
            return this.animationPauseMillis;
        }

        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Nullable
        public Integer getProgress() {
            return this.progress;
        }

        @NotNull
        public CampaignProgressStateSource getSource() {
            return this.source;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((getMessage().hashCode() * 31) + (getProgress() == null ? 0 : getProgress().hashCode())) * 31;
            if (getAnimationPauseMillis() != null) {
                i11 = getAnimationPauseMillis().hashCode();
            }
            int i12 = (hashCode + i11) * 31;
            boolean isTPro2 = isTPro();
            if (isTPro2) {
                isTPro2 = true;
            }
            return ((i12 + (isTPro2 ? 1 : 0)) * 31) + getSource().hashCode();
        }

        public boolean isTPro() {
            return this.isTPro;
        }

        @NotNull
        public String toString() {
            String message2 = getMessage();
            Integer progress2 = getProgress();
            Long animationPauseMillis2 = getAnimationPauseMillis();
            boolean isTPro2 = isTPro();
            CampaignProgressStateSource source2 = getSource();
            return "BelowThreshold(message=" + message2 + ", progress=" + progress2 + ", animationPauseMillis=" + animationPauseMillis2 + ", isTPro=" + isTPro2 + ", source=" + source2 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BelowThreshold(@NotNull String str, @Nullable Integer num, @Nullable Long l11, boolean z11, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            this.message = str;
            this.progress = num;
            this.animationPauseMillis = l11;
            this.isTPro = z11;
            this.source = campaignProgressStateSource;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JD\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$InProgress;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "message", "", "progress", "", "animationPauseMillis", "", "isTPro", "", "source", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;ZLcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)V", "getAnimationPauseMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getMessage", "()Ljava/lang/String;", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSource", "()Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;ZLcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$InProgress;", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InProgress extends CampaignProgressState {
        @Nullable
        private final Long animationPauseMillis;
        private final boolean isTPro;
        @NotNull
        private final String message;
        @Nullable
        private final Integer progress;
        @NotNull
        private final CampaignProgressStateSource source;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ InProgress(String str, Integer num, Long l11, boolean z11, CampaignProgressStateSource campaignProgressStateSource, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, num, l11, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? CampaignProgressStateSource.UNKNOWN : campaignProgressStateSource);
        }

        public static /* synthetic */ InProgress copy$default(InProgress inProgress, String str, Integer num, Long l11, boolean z11, CampaignProgressStateSource campaignProgressStateSource, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = inProgress.getMessage();
            }
            if ((i11 & 2) != 0) {
                num = inProgress.getProgress();
            }
            Integer num2 = num;
            if ((i11 & 4) != 0) {
                l11 = inProgress.getAnimationPauseMillis();
            }
            Long l12 = l11;
            if ((i11 & 8) != 0) {
                z11 = inProgress.isTPro();
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                campaignProgressStateSource = inProgress.getSource();
            }
            return inProgress.copy(str, num2, l12, z12, campaignProgressStateSource);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @Nullable
        public final Integer component2() {
            return getProgress();
        }

        @Nullable
        public final Long component3() {
            return getAnimationPauseMillis();
        }

        public final boolean component4() {
            return isTPro();
        }

        @NotNull
        public final CampaignProgressStateSource component5() {
            return getSource();
        }

        @NotNull
        public final InProgress copy(@NotNull String str, @Nullable Integer num, @Nullable Long l11, boolean z11, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            return new InProgress(str, num, l11, z11, campaignProgressStateSource);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InProgress)) {
                return false;
            }
            InProgress inProgress = (InProgress) obj;
            return Intrinsics.areEqual((Object) getMessage(), (Object) inProgress.getMessage()) && Intrinsics.areEqual((Object) getProgress(), (Object) inProgress.getProgress()) && Intrinsics.areEqual((Object) getAnimationPauseMillis(), (Object) inProgress.getAnimationPauseMillis()) && isTPro() == inProgress.isTPro() && getSource() == inProgress.getSource();
        }

        @Nullable
        public Long getAnimationPauseMillis() {
            return this.animationPauseMillis;
        }

        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Nullable
        public Integer getProgress() {
            return this.progress;
        }

        @NotNull
        public CampaignProgressStateSource getSource() {
            return this.source;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((getMessage().hashCode() * 31) + (getProgress() == null ? 0 : getProgress().hashCode())) * 31;
            if (getAnimationPauseMillis() != null) {
                i11 = getAnimationPauseMillis().hashCode();
            }
            int i12 = (hashCode + i11) * 31;
            boolean isTPro2 = isTPro();
            if (isTPro2) {
                isTPro2 = true;
            }
            return ((i12 + (isTPro2 ? 1 : 0)) * 31) + getSource().hashCode();
        }

        public boolean isTPro() {
            return this.isTPro;
        }

        @NotNull
        public String toString() {
            String message2 = getMessage();
            Integer progress2 = getProgress();
            Long animationPauseMillis2 = getAnimationPauseMillis();
            boolean isTPro2 = isTPro();
            CampaignProgressStateSource source2 = getSource();
            return "InProgress(message=" + message2 + ", progress=" + progress2 + ", animationPauseMillis=" + animationPauseMillis2 + ", isTPro=" + isTPro2 + ", source=" + source2 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InProgress(@NotNull String str, @Nullable Integer num, @Nullable Long l11, boolean z11, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            this.message = str;
            this.progress = num;
            this.animationPauseMillis = l11;
            this.isTPro = z11;
            this.source = campaignProgressStateSource;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JD\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\tHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Success;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "message", "", "animationPauseMillis", "", "isTPro", "", "progress", "", "source", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "(Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Integer;Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)V", "getAnimationPauseMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getMessage", "()Ljava/lang/String;", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSource", "()Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Integer;Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Success;", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success extends CampaignProgressState {
        @Nullable
        private final Long animationPauseMillis;
        private final boolean isTPro;
        @NotNull
        private final String message;
        @Nullable
        private final Integer progress;
        @NotNull
        private final CampaignProgressStateSource source;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Success(String str, Long l11, boolean z11, Integer num, CampaignProgressStateSource campaignProgressStateSource, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, l11, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? CampaignProgressStateSource.UNKNOWN : campaignProgressStateSource);
        }

        public static /* synthetic */ Success copy$default(Success success, String str, Long l11, boolean z11, Integer num, CampaignProgressStateSource campaignProgressStateSource, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = success.getMessage();
            }
            if ((i11 & 2) != 0) {
                l11 = success.getAnimationPauseMillis();
            }
            Long l12 = l11;
            if ((i11 & 4) != 0) {
                z11 = success.isTPro();
            }
            boolean z12 = z11;
            if ((i11 & 8) != 0) {
                num = success.getProgress();
            }
            Integer num2 = num;
            if ((i11 & 16) != 0) {
                campaignProgressStateSource = success.getSource();
            }
            return success.copy(str, l12, z12, num2, campaignProgressStateSource);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @Nullable
        public final Long component2() {
            return getAnimationPauseMillis();
        }

        public final boolean component3() {
            return isTPro();
        }

        @Nullable
        public final Integer component4() {
            return getProgress();
        }

        @NotNull
        public final CampaignProgressStateSource component5() {
            return getSource();
        }

        @NotNull
        public final Success copy(@NotNull String str, @Nullable Long l11, boolean z11, @Nullable Integer num, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            return new Success(str, l11, z11, num, campaignProgressStateSource);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return Intrinsics.areEqual((Object) getMessage(), (Object) success.getMessage()) && Intrinsics.areEqual((Object) getAnimationPauseMillis(), (Object) success.getAnimationPauseMillis()) && isTPro() == success.isTPro() && Intrinsics.areEqual((Object) getProgress(), (Object) success.getProgress()) && getSource() == success.getSource();
        }

        @Nullable
        public Long getAnimationPauseMillis() {
            return this.animationPauseMillis;
        }

        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Nullable
        public Integer getProgress() {
            return this.progress;
        }

        @NotNull
        public CampaignProgressStateSource getSource() {
            return this.source;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((getMessage().hashCode() * 31) + (getAnimationPauseMillis() == null ? 0 : getAnimationPauseMillis().hashCode())) * 31;
            boolean isTPro2 = isTPro();
            if (isTPro2) {
                isTPro2 = true;
            }
            int i12 = (hashCode + (isTPro2 ? 1 : 0)) * 31;
            if (getProgress() != null) {
                i11 = getProgress().hashCode();
            }
            return ((i12 + i11) * 31) + getSource().hashCode();
        }

        public boolean isTPro() {
            return this.isTPro;
        }

        @NotNull
        public String toString() {
            String message2 = getMessage();
            Long animationPauseMillis2 = getAnimationPauseMillis();
            boolean isTPro2 = isTPro();
            Integer progress2 = getProgress();
            CampaignProgressStateSource source2 = getSource();
            return "Success(message=" + message2 + ", animationPauseMillis=" + animationPauseMillis2 + ", isTPro=" + isTPro2 + ", progress=" + progress2 + ", source=" + source2 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull String str, @Nullable Long l11, boolean z11, @Nullable Integer num, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            this.message = str;
            this.animationPauseMillis = l11;
            this.isTPro = z11;
            this.progress = num;
            this.source = campaignProgressStateSource;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J8\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0012HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Transient;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "message", "", "animationPauseMillis", "", "isTPro", "", "source", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "(Ljava/lang/String;Ljava/lang/Long;ZLcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)V", "getAnimationPauseMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getMessage", "()Ljava/lang/String;", "progress", "", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSource", "()Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;ZLcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;)Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState$Transient;", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Transient extends CampaignProgressState {
        @Nullable
        private final Long animationPauseMillis;
        private final boolean isTPro;
        @NotNull
        private final String message;
        @Nullable
        private final Integer progress;
        @NotNull
        private final CampaignProgressStateSource source;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Transient(String str, Long l11, boolean z11, CampaignProgressStateSource campaignProgressStateSource, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, l11, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? CampaignProgressStateSource.UNKNOWN : campaignProgressStateSource);
        }

        public static /* synthetic */ Transient copy$default(Transient transientR, String str, Long l11, boolean z11, CampaignProgressStateSource campaignProgressStateSource, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = transientR.getMessage();
            }
            if ((i11 & 2) != 0) {
                l11 = transientR.getAnimationPauseMillis();
            }
            if ((i11 & 4) != 0) {
                z11 = transientR.isTPro();
            }
            if ((i11 & 8) != 0) {
                campaignProgressStateSource = transientR.getSource();
            }
            return transientR.copy(str, l11, z11, campaignProgressStateSource);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @Nullable
        public final Long component2() {
            return getAnimationPauseMillis();
        }

        public final boolean component3() {
            return isTPro();
        }

        @NotNull
        public final CampaignProgressStateSource component4() {
            return getSource();
        }

        @NotNull
        public final Transient copy(@NotNull String str, @Nullable Long l11, boolean z11, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            return new Transient(str, l11, z11, campaignProgressStateSource);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Transient)) {
                return false;
            }
            Transient transientR = (Transient) obj;
            return Intrinsics.areEqual((Object) getMessage(), (Object) transientR.getMessage()) && Intrinsics.areEqual((Object) getAnimationPauseMillis(), (Object) transientR.getAnimationPauseMillis()) && isTPro() == transientR.isTPro() && getSource() == transientR.getSource();
        }

        @Nullable
        public Long getAnimationPauseMillis() {
            return this.animationPauseMillis;
        }

        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Nullable
        public Integer getProgress() {
            return this.progress;
        }

        @NotNull
        public CampaignProgressStateSource getSource() {
            return this.source;
        }

        public int hashCode() {
            int hashCode = ((getMessage().hashCode() * 31) + (getAnimationPauseMillis() == null ? 0 : getAnimationPauseMillis().hashCode())) * 31;
            boolean isTPro2 = isTPro();
            if (isTPro2) {
                isTPro2 = true;
            }
            return ((hashCode + (isTPro2 ? 1 : 0)) * 31) + getSource().hashCode();
        }

        public boolean isTPro() {
            return this.isTPro;
        }

        @NotNull
        public String toString() {
            String message2 = getMessage();
            Long animationPauseMillis2 = getAnimationPauseMillis();
            boolean isTPro2 = isTPro();
            CampaignProgressStateSource source2 = getSource();
            return "Transient(message=" + message2 + ", animationPauseMillis=" + animationPauseMillis2 + ", isTPro=" + isTPro2 + ", source=" + source2 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Transient(@NotNull String str, @Nullable Long l11, boolean z11, @NotNull CampaignProgressStateSource campaignProgressStateSource) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(campaignProgressStateSource, "source");
            this.message = str;
            this.animationPauseMillis = l11;
            this.isTPro = z11;
            this.source = campaignProgressStateSource;
        }
    }
}
