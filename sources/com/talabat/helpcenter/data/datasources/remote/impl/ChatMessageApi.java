package com.talabat.helpcenter.data.datasources.remote.impl;

import com.talabat.helpcenter.data.datasources.remote.dto.UnreadChatMessagesCountResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/helpcenter/data/datasources/remote/impl/ChatMessageApi;", "", "getUnreadChatMessages", "Lcom/talabat/helpcenter/data/datasources/remote/dto/UnreadChatMessagesCountResponse;", "authorization", "", "gei", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatMessageApi {
    @Nullable
    @GET("chat-api/v1/unread-message-count")
    @Headers({"x-service-type: customer"})
    Object getUnreadChatMessages(@NotNull @Header("Authorization") String str, @NotNull @Header("x-helpcenter-gei") String str2, @NotNull Continuation<? super UnreadChatMessagesCountResponse> continuation);
}
