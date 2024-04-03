package com.talabat.authentication.token.data.flutter;

import com.talabat.authentication.token.domain.model.Token;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H&J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;", "", "fromMap", "Lcom/talabat/authentication/token/domain/model/Token;", "arguments", "", "", "toMap", "token", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokenFlutterMapper {
    @NotNull
    Token fromMap(@NotNull Map<String, ? extends Object> map);

    @NotNull
    Map<String, Object> toMap(@NotNull Token token);
}
