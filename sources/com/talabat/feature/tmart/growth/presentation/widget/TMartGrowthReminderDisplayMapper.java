package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthReminderDisplayMapper;", "", "imageFileManager", "Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;", "(Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;)V", "downloadImageSafely", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "url", "", "downloadImageSafely-r0oKcjY", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDisplayModel", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "reminderData", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "(Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthReminderDisplayMapper {
    @NotNull
    private final ITMartGrowthFileManager imageFileManager;

    @Inject
    public TMartGrowthReminderDisplayMapper(@NotNull ITMartGrowthFileManager iTMartGrowthFileManager) {
        Intrinsics.checkNotNullParameter(iTMartGrowthFileManager, "imageFileManager");
        this.imageFileManager = iTMartGrowthFileManager;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: downloadImageSafely-r0oKcjY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m10347downloadImageSafelyr0oKcjY(java.lang.String r5, kotlin.coroutines.Continuation<? super com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$downloadImageSafely$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$downloadImageSafely$1 r0 = (com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$downloadImageSafely$1) r0
            int r1 = r0.f59189j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59189j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$downloadImageSafely$1 r0 = new com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$downloadImageSafely$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f59187h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59189j
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0052 }
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r6     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = r6.m10329unboximpl()     // Catch:{ all -> 0x0052 }
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager r6 = r4.imageFileManager
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0052 }
            r0.f59189j = r3     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = r6.m10337getFilePathr0oKcjY(r5, r0)     // Catch:{ all -> 0x0052 }
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0052 }
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r5 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath.m10323boximpl(r5)     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0052 }
            goto L_0x005d
        L_0x0052:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x005d:
            java.lang.String r6 = ""
            java.lang.String r6 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath.m10324constructorimpl(r6)
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r6 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath.m10323boximpl(r6)
            boolean r0 = kotlin.Result.m6335isFailureimpl(r5)
            if (r0 == 0) goto L_0x006e
            r5 = r6
        L_0x006e:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r5 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r5
            java.lang.String r5 = r5.m10329unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper.m10347downloadImageSafelyr0oKcjY(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0128 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object toDisplayModel(@org.jetbrains.annotations.NotNull com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData r23, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            boolean r3 = r2 instanceof com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$toDisplayModel$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$toDisplayModel$1 r3 = (com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$toDisplayModel$1) r3
            int r4 = r3.f59198p
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f59198p = r4
            goto L_0x001e
        L_0x0019:
            com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$toDisplayModel$1 r3 = new com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper$toDisplayModel$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f59196n
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.f59198p
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L_0x00a0
            if (r5 == r8) goto L_0x0085
            if (r5 == r7) goto L_0x0065
            if (r5 != r6) goto L_0x005d
            java.lang.Object r1 = r3.f59195m
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r3.f59194l
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r3.f59193k
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.f59192j
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r3.f59191i
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r3 = r3.f59190h
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r2)
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r2 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r2
            java.lang.String r2 = r2.m10329unboximpl()
            r16 = r1
            r14 = r3
            r17 = r4
            r18 = r5
            r15 = r6
            r13 = r7
            goto L_0x0133
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            java.lang.Object r1 = r3.f59193k
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.f59192j
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r3.f59191i
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData r7 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData) r7
            java.lang.Object r8 = r3.f59190h
            com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper r8 = (com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper) r8
            kotlin.ResultKt.throwOnFailure(r2)
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r2 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r2
            java.lang.String r2 = r2.m10329unboximpl()
            r21 = r7
            r7 = r1
            r1 = r21
            goto L_0x0100
        L_0x0085:
            java.lang.Object r1 = r3.f59192j
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r3.f59191i
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.f59190h
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData r3 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData) r3
            kotlin.ResultKt.throwOnFailure(r2)
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r2 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r2
            java.lang.String r2 = r2.m10329unboximpl()
            r21 = r3
            r3 = r1
            r1 = r21
            goto L_0x00c7
        L_0x00a0:
            kotlin.ResultKt.throwOnFailure(r2)
            boolean r2 = r1 instanceof com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Basic
            if (r2 == 0) goto L_0x00d9
            r2 = r1
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData$Basic r2 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Basic) r2
            java.lang.String r5 = r2.getTitle()
            java.lang.String r6 = r2.getSubtitle()
            java.lang.String r2 = r2.getIconUrl()
            r3.f59190h = r1
            r3.f59191i = r6
            r3.f59192j = r5
            r3.f59198p = r8
            java.lang.Object r2 = r0.m10347downloadImageSafelyr0oKcjY(r2, r3)
            if (r2 != r4) goto L_0x00c5
            return r4
        L_0x00c5:
            r3 = r5
            r4 = r6
        L_0x00c7:
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData$Basic r1 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Basic) r1
            java.lang.String r6 = r1.getDeeplink()
            r7 = 0
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel$Claimed r1 = new com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel$Claimed
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x014f
        L_0x00d9:
            boolean r2 = r1 instanceof com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Rich
            if (r2 == 0) goto L_0x0140
            r2 = r1
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData$Rich r2 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Rich) r2
            java.lang.String r5 = r2.getTitle()
            java.lang.String r8 = r2.getSubtitle()
            java.lang.String r2 = r2.getImageUrl()
            r3.f59190h = r0
            r3.f59191i = r1
            r3.f59192j = r8
            r3.f59193k = r5
            r3.f59198p = r7
            java.lang.Object r2 = r0.m10347downloadImageSafelyr0oKcjY(r2, r3)
            if (r2 != r4) goto L_0x00fd
            return r4
        L_0x00fd:
            r7 = r5
            r5 = r8
            r8 = r0
        L_0x0100:
            java.lang.String r2 = (java.lang.String) r2
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData$Rich r1 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Rich) r1
            java.lang.String r9 = r1.getButtonText()
            java.lang.String r10 = r1.getDeeplink()
            java.lang.String r11 = r1.getLogoUrl()
            java.lang.String r1 = r1.getBackgroundUrl()
            r3.f59190h = r5
            r3.f59191i = r7
            r3.f59192j = r2
            r3.f59193k = r11
            r3.f59194l = r10
            r3.f59195m = r9
            r3.f59198p = r6
            java.lang.Object r1 = r8.m10347downloadImageSafelyr0oKcjY(r1, r3)
            if (r1 != r4) goto L_0x0129
            return r4
        L_0x0129:
            r15 = r2
            r14 = r5
            r13 = r7
            r16 = r9
            r17 = r10
            r18 = r11
            r2 = r1
        L_0x0133:
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
            r20 = 0
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel$Reminder r1 = new com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel$Reminder
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x014f
        L_0x0140:
            boolean r2 = r1 instanceof com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Plain
            if (r2 == 0) goto L_0x0145
            goto L_0x014b
        L_0x0145:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData$Unknown r2 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData.Unknown.INSTANCE
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x014b:
            if (r8 == 0) goto L_0x0150
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel$None r1 = com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel.None.INSTANCE
        L_0x014f:
            return r1
        L_0x0150:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper.toDisplayModel(com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
