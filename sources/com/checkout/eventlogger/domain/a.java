package com.checkout.eventlogger.domain;

import com.checkout.eventlogger.domain.model.Event;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface a {
    void a(@NotNull Map<String, String> map, @NotNull Event... eventArr);
}
