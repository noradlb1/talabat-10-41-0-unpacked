package com.talabat.feature.rewards.presentation.mission.details;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/text/Regex;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MissionDetailsDialogFragment$Companion$DEEPLINK_REGEX$1 extends Lambda implements Function1<String, Regex> {
    public static final MissionDetailsDialogFragment$Companion$DEEPLINK_REGEX$1 INSTANCE = new MissionDetailsDialogFragment$Companion$DEEPLINK_REGEX$1();

    public MissionDetailsDialogFragment$Companion$DEEPLINK_REGEX$1() {
        super(1);
    }

    @NotNull
    public final Regex invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return new Regex("talabat://?.*" + str + "(&|$).*");
    }
}
