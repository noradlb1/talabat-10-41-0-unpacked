package com.instabug.library.sessionV3.sync;

import com.instabug.library.model.v3Session.c0;
import java.util.List;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

public interface SessionBatchingFilter {
    @NotNull
    List<Pair<String, c0>> invoke(@NotNull List<? extends Pair<String, ? extends c0>> list);
}
