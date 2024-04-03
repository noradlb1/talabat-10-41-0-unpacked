package com.deliveryhero.chatui.view.chatroom;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.chatui.data.event.Event;
import com.deliveryhero.chatui.data.event.EventHandler;
import com.deliveryhero.chatui.domain.UploadImageUseCase;
import com.deliveryhero.chatui.domain.imageselection.ImageSelectionUseCases;
import com.deliveryhero.chatui.domain.imageselection.UploadImageConfirmationDialog;
import com.deliveryhero.chatui.domain.imageselection.usecase.GetCameraImageUriStatus;
import com.deliveryhero.chatui.domain.imageselection.usecase.GetImagePathUseCase;
import com.deliveryhero.chatui.domain.imageselection.usecase.ImageSizeUseCase;
import com.deliveryhero.chatui.view.chatroom.ImageMessage;
import com.deliveryhero.chatui.view.chatroom.LocationMessage;
import com.deliveryhero.chatui.view.chatroom.UIEvent;
import com.deliveryhero.chatui.view.chatroom.connectivity.ConnectivityMonitor;
import com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapper;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionType;
import com.deliveryhero.chatui.view.util.MapperUtilKt;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.AdminMessage;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.ChannelFrozenMessage;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.ConfigUpdateMessage;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.GroupChannel;
import com.deliveryhero.contract.model.LocationData;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.contract.model.Source;
import com.deliveryhero.contract.model.TextMessageData;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.commons.ChatUtils;
import com.deliveryhero.customerchat.commons.ExtensionsUtilsKt;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.ImageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.ImageSource;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageType;
import com.deliveryhero.customerchat.eventTracking.data.TranslationMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.AnalyticsWrapper;
import com.deliveryhero.customerchat.eventTracking.tracker.ChatEventsTracker;
import com.deliveryhero.customerchat.eventTracking.tracker.ImageEventsTracker;
import com.deliveryhero.customerchat.eventTracking.tracker.LocationEventsTracker;
import com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTracker;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.fwf.UserFeatureFlags;
import com.deliveryhero.customerchat.service.ChannelService;
import com.deliveryhero.customerchat.telephony.util.dispatcher.Dispatcher;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000É\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001k\b\u0000\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\b\u0010n\u001a\u00020-H\u0002J\u0010\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020pH\u0002J\b\u0010t\u001a\u00020pH\u0002J\u0006\u0010u\u001a\u00020pJ\b\u0010v\u001a\u00020pH\u0002J\u0010\u0010w\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010x\u001a\u00020pH\u0002J!\u0010y\u001a\u00020z2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010{\u001a\u00020|H@ø\u0001\u0000¢\u0006\u0002\u0010}J\b\u0010~\u001a\u00020-H\u0002J\u0011\u0010\u001a\u00020p2\t\b\u0002\u0010\u0001\u001a\u00020-J$\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020-H\u0002J\u0007\u0010\u0001\u001a\u00020-J\u0014\u0010\u0001\u001a\u00020-2\t\u0010\u0001\u001a\u0004\u0018\u00010+H\u0002J\u0011\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u0001J\t\u0010\u0001\u001a\u00020pH\u0002J\u0007\u0010\u0001\u001a\u00020pJ\t\u0010\u0001\u001a\u00020pH\u0002J\u0007\u0010\u0001\u001a\u00020-J\t\u0010\u0001\u001a\u00020pH\u0014J\u0012\u0010\u0001\u001a\u00020p2\t\u0010\u0001\u001a\u0004\u0018\u00010dJ\u0007\u0010\u0001\u001a\u00020pJ\u0007\u0010\u0001\u001a\u00020pJ\u0013\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0011\u0010\u0001\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u00020pH\u0002J\u0007\u0010\u0001\u001a\u00020pJ\u0007\u0010\u0001\u001a\u00020pJ\u0007\u0010\u0001\u001a\u00020pJ\u0019\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020-J\u0010\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020+J\u0007\u0010 \u0001\u001a\u00020-J0\u0010¡\u0001\u001a\u00020p2\b\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010¤\u0001\u001a\u00020'2\b\u0010¥\u0001\u001a\u00030¦\u00012\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001J\u0013\u0010©\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010ª\u0001\u001a\u00020pJ\t\u0010«\u0001\u001a\u00020pH\u0002J\t\u0010¬\u0001\u001a\u00020pH\u0002J\u001e\u0010­\u0001\u001a\u00020p2\t\u0010®\u0001\u001a\u0004\u0018\u00010+2\b\u0010¯\u0001\u001a\u00030°\u0001H\u0002J\u0007\u0010±\u0001\u001a\u00020pJ\t\u0010²\u0001\u001a\u00020pH\u0002J-\u0010³\u0001\u001a\u00020p2\u000b\b\u0002\u0010´\u0001\u001a\u0004\u0018\u00010r2\u0007\u0010µ\u0001\u001a\u00020%2\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0002J-\u0010¸\u0001\u001a\u00020p2\u0007\u0010´\u0001\u001a\u00020r2\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010%2\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0002J\u001c\u0010¹\u0001\u001a\u00020%2\b\u0010º\u0001\u001a\u00030»\u00012\u0007\u0010¼\u0001\u001a\u00020%H\u0002J\u0012\u0010½\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020rH\u0002J\t\u0010¾\u0001\u001a\u00020pH\u0002J\t\u0010¿\u0001\u001a\u00020pH\u0002J\"\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020r0$*\b\u0012\u0004\u0012\u00020r0$2\u0007\u0010Á\u0001\u001a\u00020-H\u0002J\u0019\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020r0$*\b\u0012\u0004\u0012\u00020r0$H\u0002R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0$0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\"07¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010<\u001a\u0004\u0018\u00010;2\b\u0010:\u001a\u0004\u0018\u00010;@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\u0004\u0018\u00010A8@X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\u00020EX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u00020NX\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020'8BX\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020%8BX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020XX\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u001a\u0010[\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0\\X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0/¢\u0006\b\n\u0000\u001a\u0004\b^\u00101R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020'0/¢\u0006\b\n\u0000\u001a\u0004\b`\u00101R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020)07¢\u0006\b\n\u0000\u001a\u0004\bb\u00109R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0$0/¢\u0006\b\n\u0000\u001a\u0004\bf\u00101R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020-0/¢\u0006\b\n\u0000\u001a\u0004\bh\u00101R\u000e\u0010i\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u00020kX\u0004¢\u0006\u0004\n\u0002\u0010lR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006Ã\u0001"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "service", "Lcom/deliveryhero/customerchat/service/ChannelService;", "mapper", "Lcom/deliveryhero/chatui/view/chatroom/mapper/ChatMessageViewModelMapper;", "eventHandler", "Lcom/deliveryhero/chatui/data/event/EventHandler;", "connectivityMonitor", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/ConnectivityMonitor;", "imageSelectionUseCases", "Lcom/deliveryhero/chatui/domain/imageselection/ImageSelectionUseCases;", "uploadImageUseCase", "Lcom/deliveryhero/chatui/domain/UploadImageUseCase;", "getImagePathUseCase", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetImagePathUseCase;", "imageSizeUseCase", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/ImageSizeUseCase;", "dispatcher", "Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "chatUtils", "Lcom/deliveryhero/customerchat/commons/ChatUtils;", "analyticsWrapper", "Lcom/deliveryhero/customerchat/eventTracking/tracker/AnalyticsWrapper;", "(Lcom/deliveryhero/customerchat/service/ChannelService;Lcom/deliveryhero/chatui/view/chatroom/mapper/ChatMessageViewModelMapper;Lcom/deliveryhero/chatui/data/event/EventHandler;Lcom/deliveryhero/chatui/view/chatroom/connectivity/ConnectivityMonitor;Lcom/deliveryhero/chatui/domain/imageselection/ImageSelectionUseCases;Lcom/deliveryhero/chatui/domain/UploadImageUseCase;Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetImagePathUseCase;Lcom/deliveryhero/chatui/domain/imageselection/usecase/ImageSizeUseCase;Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;Lcom/deliveryhero/customerchat/commons/ChatUtils;Lcom/deliveryhero/customerchat/eventTracking/tracker/AnalyticsWrapper;)V", "_attachmentView", "Landroidx/lifecycle/MutableLiveData;", "Lcom/deliveryhero/chatui/view/chatroom/AttachmentViewOptions;", "_chatUIEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deliveryhero/chatui/view/chatroom/UIEvent;", "_messagesLiveData", "", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "_noInternetLiveData", "", "_openImageNavigator", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "_quickReplies", "", "_refreshing", "", "attachmentView", "Landroidx/lifecycle/LiveData;", "getAttachmentView", "()Landroidx/lifecycle/LiveData;", "chatEvents", "Lcom/deliveryhero/customerchat/eventTracking/tracker/ChatEventsTracker;", "getChatEvents$customerchat_basicRelease", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/ChatEventsTracker;", "chatUIEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "getChatUIEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "<set-?>", "Lcom/deliveryhero/chatui/view/chatroom/DeliveryViewModel;", "deliveryViewModel", "getDeliveryViewModel", "()Lcom/deliveryhero/chatui/view/chatroom/DeliveryViewModel;", "enableTranslation", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "getEventMetadata$customerchat_basicRelease", "()Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "imageEvents", "Lcom/deliveryhero/customerchat/eventTracking/tracker/ImageEventsTracker;", "getImageEvents$customerchat_basicRelease", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/ImageEventsTracker;", "imageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ImageMetadata;", "isInternetDisconnected", "isLocationEnabled", "lastMessageInList", "locationEvents", "Lcom/deliveryhero/customerchat/eventTracking/tracker/LocationEventsTracker;", "getLocationEvents$customerchat_basicRelease", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/LocationEventsTracker;", "mIndex", "getMIndex", "()I", "mTempMessage", "getMTempMessage", "()Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "messageEvents", "Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTracker;", "getMessageEvents$customerchat_basicRelease", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTracker;", "messages", "", "messagesLiveData", "getMessagesLiveData", "noInternetLiveData", "getNoInternetLiveData", "openImageNavigator", "getOpenImageNavigator", "pendingLocationData", "Lcom/deliveryhero/contract/model/LocationData;", "quickReplies", "getQuickReplies", "refreshing", "getRefreshing", "scrollToBottom", "sendListener", "com/deliveryhero/chatui/view/chatroom/ChatViewModel$sendListener$1", "Lcom/deliveryhero/chatui/view/chatroom/ChatViewModel$sendListener$1;", "userCount", "canExit", "checkIfChannelFrozen", "", "it", "Lcom/deliveryhero/contract/model/BaseMessage;", "connect", "connectChannel", "disconnect", "fetchConfigIfPhoneCalling", "fetchConfigIfUpdated", "getAndSyncLastMessageInChat", "getFeatureFlagProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties;", "chatConfiguration", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "(Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;Lcom/deliveryhero/contract/configuration/ChatConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "haveIReplied", "init", "hasSavedInstance", "invokeImageUploadUseCase", "message", "index", "saveToGallery", "isTranslationEnabled", "isValidMessage", "listenAllConnection", "handler", "Landroid/os/Handler;", "loadChat", "locationSharingError", "markAllMessagesAsRead", "onBackPressed", "onCleared", "onLocationReceived", "data", "openCamera", "openGallery", "populateAttachmentSelector", "userFeatureFlags", "Lcom/deliveryhero/customerchat/fwf/UserFeatureFlags;", "preferredLanguage", "preferredLanguage$customerchat_basicRelease", "registerChatConnection", "resetConnection", "sendCameraPhoto", "sendGalleryPhoto", "sendNewMessage", "messageText", "isQuickReply", "sendQuickReply", "shouldScrollToBottom", "showImageShareConfirmation", "context", "Landroid/content/Context;", "requestCode", "uri", "Landroid/net/Uri;", "chatLogger", "Lcom/deliveryhero/contract/ChatLogger;", "startListeningNetworkConnection", "stopListeningAllConnection", "stopListeningNetworkConnection", "subscribeForMessages", "trackImageSelectedEvent", "imagePath", "imageFrom", "Lcom/deliveryhero/customerchat/eventTracking/data/ImageSource;", "translate", "unregisterChatConnection", "updateMessageFailure", "chatMessage", "tempMessage", "error", "", "updateMessageSuccess", "updateReceiptIfNeeds", "groupChannel", "Lcom/deliveryhero/contract/model/GroupChannel;", "chatMessageViewModel", "updateUserCount", "uploadCameraImage", "uploadGalleryImage", "filterAdmin", "hideAdminMessages", "removeConfigAndChatFrozenMessages", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<AttachmentViewOptions> _attachmentView;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableSharedFlow<UIEvent> _chatUIEvents;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<List<ChatMessageViewModel>> _messagesLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Integer> _noInternetLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableSharedFlow<ImageSelectionType> _openImageNavigator;
    @NotNull
    private final MutableLiveData<List<String>> _quickReplies;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _refreshing;
    @NotNull
    private final LiveData<AttachmentViewOptions> attachmentView;
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    @NotNull
    private final ChatEventsTracker chatEvents;
    @NotNull
    private final SharedFlow<UIEvent> chatUIEvents;
    /* access modifiers changed from: private */
    @NotNull
    public final ChatUtils chatUtils;
    @NotNull
    private final ConnectivityMonitor connectivityMonitor;
    @Nullable
    private DeliveryViewModel deliveryViewModel;
    /* access modifiers changed from: private */
    @NotNull
    public final Dispatcher dispatcher;
    private boolean enableTranslation;
    /* access modifiers changed from: private */
    @NotNull
    public final EventHandler eventHandler;
    /* access modifiers changed from: private */
    @NotNull
    public final FeatureFlagProvider featureFlagProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final GetImagePathUseCase getImagePathUseCase;
    @NotNull
    private final ImageEventsTracker imageEvents;
    /* access modifiers changed from: private */
    @Nullable
    public ImageMetadata imageMetadata;
    @NotNull
    private final ImageSelectionUseCases imageSelectionUseCases;
    @NotNull
    private final ImageSizeUseCase imageSizeUseCase;
    /* access modifiers changed from: private */
    public boolean isInternetDisconnected;
    private boolean isLocationEnabled;
    /* access modifiers changed from: private */
    @Nullable
    public ChatMessageViewModel lastMessageInList;
    @NotNull
    private final LocationEventsTracker locationEvents;
    /* access modifiers changed from: private */
    @NotNull
    public final ChatMessageViewModelMapper mapper;
    @NotNull
    private final MessageEventsTracker messageEvents;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<Integer, ChatMessageViewModel> messages = new TreeMap();
    @NotNull
    private final LiveData<List<ChatMessageViewModel>> messagesLiveData;
    @NotNull
    private final LiveData<Integer> noInternetLiveData;
    @NotNull
    private final SharedFlow<ImageSelectionType> openImageNavigator;
    /* access modifiers changed from: private */
    @Nullable
    public LocationData pendingLocationData;
    @NotNull
    private final LiveData<List<String>> quickReplies;
    @NotNull
    private final LiveData<Boolean> refreshing;
    /* access modifiers changed from: private */
    public boolean scrollToBottom = true;
    @NotNull
    private final ChatViewModel$sendListener$1 sendListener;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    public final ChannelService f29493service;
    @NotNull
    private final UploadImageUseCase uploadImageUseCase;
    private int userCount;

    public ChatViewModel(@NotNull ChannelService channelService, @NotNull ChatMessageViewModelMapper chatMessageViewModelMapper, @NotNull EventHandler eventHandler2, @NotNull ConnectivityMonitor connectivityMonitor2, @NotNull ImageSelectionUseCases imageSelectionUseCases2, @NotNull UploadImageUseCase uploadImageUseCase2, @NotNull GetImagePathUseCase getImagePathUseCase2, @NotNull ImageSizeUseCase imageSizeUseCase2, @NotNull Dispatcher dispatcher2, @NotNull ChatConfigProvider chatConfigProvider2, @NotNull FeatureFlagProvider featureFlagProvider2, @NotNull ChatUtils chatUtils2, @NotNull AnalyticsWrapper analyticsWrapper) {
        Intrinsics.checkNotNullParameter(channelService, "service");
        Intrinsics.checkNotNullParameter(chatMessageViewModelMapper, "mapper");
        Intrinsics.checkNotNullParameter(eventHandler2, "eventHandler");
        Intrinsics.checkNotNullParameter(connectivityMonitor2, "connectivityMonitor");
        Intrinsics.checkNotNullParameter(imageSelectionUseCases2, "imageSelectionUseCases");
        Intrinsics.checkNotNullParameter(uploadImageUseCase2, "uploadImageUseCase");
        Intrinsics.checkNotNullParameter(getImagePathUseCase2, "getImagePathUseCase");
        Intrinsics.checkNotNullParameter(imageSizeUseCase2, "imageSizeUseCase");
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        Intrinsics.checkNotNullParameter(chatUtils2, "chatUtils");
        Intrinsics.checkNotNullParameter(analyticsWrapper, "analyticsWrapper");
        this.f29493service = channelService;
        this.mapper = chatMessageViewModelMapper;
        this.eventHandler = eventHandler2;
        this.connectivityMonitor = connectivityMonitor2;
        this.imageSelectionUseCases = imageSelectionUseCases2;
        this.uploadImageUseCase = uploadImageUseCase2;
        this.getImagePathUseCase = getImagePathUseCase2;
        this.imageSizeUseCase = imageSizeUseCase2;
        this.dispatcher = dispatcher2;
        this.chatConfigProvider = chatConfigProvider2;
        this.featureFlagProvider = featureFlagProvider2;
        this.chatUtils = chatUtils2;
        MutableLiveData<List<ChatMessageViewModel>> mutableLiveData = new MutableLiveData<>();
        this._messagesLiveData = mutableLiveData;
        this.messagesLiveData = mutableLiveData;
        MutableSharedFlow<UIEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, (BufferOverflow) null, 6, (Object) null);
        this._chatUIEvents = MutableSharedFlow$default;
        this.chatUIEvents = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._refreshing = mutableLiveData2;
        this.refreshing = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this._noInternetLiveData = mutableLiveData3;
        this.noInternetLiveData = mutableLiveData3;
        MutableLiveData<List<String>> mutableLiveData4 = new MutableLiveData<>();
        this._quickReplies = mutableLiveData4;
        this.quickReplies = mutableLiveData4;
        MutableLiveData<AttachmentViewOptions> mutableLiveData5 = new MutableLiveData<>();
        this._attachmentView = mutableLiveData5;
        this.attachmentView = mutableLiveData5;
        MutableSharedFlow<ImageSelectionType> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._openImageNavigator = MutableSharedFlow$default2;
        this.openImageNavigator = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        this.chatEvents = analyticsWrapper.getChatEventsTracker();
        this.imageEvents = analyticsWrapper.getImageEventsTracker();
        this.locationEvents = analyticsWrapper.getLocationEventsTracker();
        this.messageEvents = analyticsWrapper.getMessageEventsTracker();
        this.sendListener = new ChatViewModel$sendListener$1(this);
    }

    public static /* synthetic */ void a(ChatViewModel chatViewModel, BaseMessage baseMessage, ChatMessageViewModel chatMessageViewModel, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            chatMessageViewModel = null;
        }
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        chatViewModel.updateMessageSuccess(baseMessage, chatMessageViewModel, th2);
    }

    private final boolean canExit() {
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration == null || !chatConfiguration.isReplyingMandatory()) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) this._refreshing.getValue(), (Object) Boolean.TRUE) && (this.userCount > 2 || this.lastMessageInList == null || haveIReplied())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void checkIfChannelFrozen(BaseMessage baseMessage) {
        if (baseMessage instanceof ChannelFrozenMessage) {
            this._chatUIEvents.tryEmit(UIEvent.ChannelStatusUpdate.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void connect() {
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null) {
            this.f29493service.connect(chatConfiguration.getUserInfo(), new ChatViewModel$connect$1(this), new ChatViewModel$connect$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void connectChannel() {
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null) {
            this._refreshing.setValue(Boolean.TRUE);
            this.f29493service.connectChannel(chatConfiguration.getChannelId(), new ChatViewModel$connectChannel$1(this), new ChatViewModel$connectChannel$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void fetchConfigIfPhoneCalling() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$fetchConfigIfPhoneCalling$1(this, (Continuation<? super ChatViewModel$fetchConfigIfPhoneCalling$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void fetchConfigIfUpdated(BaseMessage baseMessage) {
        if (baseMessage instanceof ConfigUpdateMessage) {
            fetchConfigIfPhoneCalling();
        }
    }

    /* access modifiers changed from: private */
    public final List<BaseMessage> filterAdmin(List<? extends BaseMessage> list, boolean z11) {
        List<? extends BaseMessage> list2;
        if (z11) {
            list2 = list;
        } else {
            list2 = null;
        }
        if (list2 != null) {
            list = new ArrayList<>();
            for (Object next : list2) {
                if (!(((BaseMessage) next) instanceof AdminMessage)) {
                    list.add(next);
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public final void getAndSyncLastMessageInChat() {
        ArrayList arrayList = new ArrayList();
        for (Object next : this.messages.values()) {
            if (!(((ChatMessageViewModel) next).getChatMessage() instanceof AdminMessage)) {
                arrayList.add(next);
            }
        }
        this.lastMessageInList = (ChatMessageViewModel) CollectionsKt___CollectionsKt.lastOrNull(arrayList);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getFeatureFlagProperties(com.deliveryhero.customerchat.fwf.FeatureFlagProvider r24, com.deliveryhero.contract.configuration.ChatConfiguration r25, kotlin.coroutines.Continuation<? super com.deliveryhero.customerchat.eventTracking.data.FeatureFlagProperties> r26) {
        /*
            r23 = this;
            r0 = r24
            r1 = r26
            boolean r2 = r1 instanceof com.deliveryhero.chatui.view.chatroom.ChatViewModel$getFeatureFlagProperties$1
            if (r2 == 0) goto L_0x0019
            r2 = r1
            com.deliveryhero.chatui.view.chatroom.ChatViewModel$getFeatureFlagProperties$1 r2 = (com.deliveryhero.chatui.view.chatroom.ChatViewModel$getFeatureFlagProperties$1) r2
            int r3 = r2.f29511s
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0019
            int r3 = r3 - r4
            r2.f29511s = r3
            r3 = r23
            goto L_0x0020
        L_0x0019:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel$getFeatureFlagProperties$1 r2 = new com.deliveryhero.chatui.view.chatroom.ChatViewModel$getFeatureFlagProperties$1
            r3 = r23
            r2.<init>(r3, r1)
        L_0x0020:
            java.lang.Object r1 = r2.f29509q
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.f29511s
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L_0x0082
            if (r5 == r8) goto L_0x0070
            if (r5 == r7) goto L_0x0057
            if (r5 != r6) goto L_0x004f
            int r0 = r2.f29508p
            boolean r4 = r2.f29507o
            boolean r5 = r2.f29506n
            boolean r6 = r2.f29505m
            boolean r7 = r2.f29504l
            boolean r9 = r2.f29503k
            boolean r10 = r2.f29502j
            java.lang.Object r2 = r2.f29500h
            com.deliveryhero.contract.configuration.ChatConfiguration r2 = (com.deliveryhero.contract.configuration.ChatConfiguration) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r4
            r14 = r5
            r13 = r6
            r12 = r7
            r11 = r9
            goto L_0x0119
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            boolean r0 = r2.f29507o
            boolean r5 = r2.f29506n
            boolean r7 = r2.f29505m
            boolean r9 = r2.f29504l
            boolean r10 = r2.f29503k
            boolean r11 = r2.f29502j
            java.lang.Object r12 = r2.f29501i
            com.deliveryhero.contract.configuration.ChatConfiguration r12 = (com.deliveryhero.contract.configuration.ChatConfiguration) r12
            java.lang.Object r13 = r2.f29500h
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r13 = (com.deliveryhero.customerchat.fwf.FeatureFlagProvider) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00ee
        L_0x0070:
            java.lang.Object r0 = r2.f29501i
            com.deliveryhero.contract.configuration.ChatConfiguration r0 = (com.deliveryhero.contract.configuration.ChatConfiguration) r0
            java.lang.Object r5 = r2.f29500h
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r5 = (com.deliveryhero.customerchat.fwf.FeatureFlagProvider) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r20 = r1
            r1 = r0
            r0 = r5
            r5 = r20
            goto L_0x0094
        L_0x0082:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.f29500h = r0
            r1 = r25
            r2.f29501i = r1
            r2.f29511s = r8
            java.lang.Object r5 = r0.getUserFeatureFlags(r2)
            if (r5 != r4) goto L_0x0094
            return r4
        L_0x0094:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r5 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r5
            if (r5 != 0) goto L_0x00ac
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r5 = new com.deliveryhero.customerchat.fwf.UserFeatureFlags
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 255(0xff, float:3.57E-43)
            r19 = 0
            r9 = r5
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
        L_0x00ac:
            boolean r9 = r1.getStackFromEnd()
            boolean r10 = r1.isReplyingMandatory()
            boolean r11 = r5.isPhotoSharingEnabled()
            boolean r12 = r5.isHideAdminMessagesEnabled()
            boolean r13 = r5.isShowSenderNameEnabled()
            boolean r5 = r5.isLocationSharingEnabled()
            r2.f29500h = r0
            r2.f29501i = r1
            r2.f29502j = r9
            r2.f29503k = r10
            r2.f29504l = r11
            r2.f29505m = r12
            r2.f29506n = r13
            r2.f29507o = r5
            r2.f29511s = r7
            java.lang.Object r7 = r0.getPhoneCallingType(r2)
            if (r7 != r4) goto L_0x00dd
            return r4
        L_0x00dd:
            r20 = r13
            r13 = r0
            r0 = r5
            r5 = r20
            r21 = r12
            r12 = r1
            r1 = r7
            r7 = r21
            r22 = r11
            r11 = r9
            r9 = r22
        L_0x00ee:
            boolean r1 = r1 instanceof com.deliveryhero.contract.model.PhoneCallType.None
            r1 = r1 ^ r8
            r2.f29500h = r12
            r14 = 0
            r2.f29501i = r14
            r2.f29502j = r11
            r2.f29503k = r10
            r2.f29504l = r9
            r2.f29505m = r7
            r2.f29506n = r5
            r2.f29507o = r0
            r2.f29508p = r1
            r2.f29511s = r6
            java.lang.Object r2 = r13.getPhoneCallingType(r2)
            if (r2 != r4) goto L_0x010d
            return r4
        L_0x010d:
            r15 = r0
            r0 = r1
            r1 = r2
            r14 = r5
            r13 = r7
            r2 = r12
            r12 = r9
            r20 = r11
            r11 = r10
            r10 = r20
        L_0x0119:
            boolean r1 = r1 instanceof com.deliveryhero.contract.model.PhoneCallType.Toku
            com.deliveryhero.contract.model.Translations r4 = r2.getTranslations()
            boolean r18 = r4.isEnabled()
            boolean r19 = r2.isFWFEnabled()
            com.deliveryhero.customerchat.eventTracking.data.FeatureFlagProperties r2 = new com.deliveryhero.customerchat.eventTracking.data.FeatureFlagProperties
            if (r0 == 0) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            r8 = 0
        L_0x012d:
            r16 = r8
            r9 = r2
            r17 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatViewModel.getFeatureFlagProperties(com.deliveryhero.customerchat.fwf.FeatureFlagProvider, com.deliveryhero.contract.configuration.ChatConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int getMIndex() {
        return this.messages.size();
    }

    private final ChatMessageViewModel getMTempMessage() {
        return new ChatMessageViewModel(getMIndex(), new TextMessage(8, (String) null, 2, (DefaultConstructorMarker) null), (TextMessage) null, new ImageMessage.Uploading(0, 1, (DefaultConstructorMarker) null), (LocationMessage) null, "", true, Receipt.SENDING, (BaseMessage) null, (String) null, 788, (DefaultConstructorMarker) null);
    }

    private final boolean haveIReplied() {
        ChatMessageViewModel chatMessageViewModel = this.lastMessageInList;
        return chatMessageViewModel != null && chatMessageViewModel.getSendByMe();
    }

    public static /* synthetic */ void init$default(ChatViewModel chatViewModel, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        chatViewModel.init(z11);
    }

    private final void invokeImageUploadUseCase(ChatMessageViewModel chatMessageViewModel, int i11, boolean z11) {
        long nanoTime = System.nanoTime();
        String generateUUIDString = this.chatUtils.generateUUIDString();
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$invokeImageUploadUseCase$1(this, new MessageMetadata(generateUUIDString, MessageType.IMAGE, 0, 0, (String) null, (Boolean) null, (String) null, 124, (DefaultConstructorMarker) null), (Continuation<? super ChatViewModel$invokeImageUploadUseCase$1>) null), 3, (Object) null);
        this.uploadImageUseCase.execute(z11, generateUUIDString, new ChatViewModel$invokeImageUploadUseCase$2(nanoTime, this, chatMessageViewModel, i11, z11));
    }

    private final boolean isValidMessage(String str) {
        return !(str == null || StringsKt__StringsJVMKt.isBlank(str));
    }

    /* access modifiers changed from: private */
    public final void loadChat() {
        this.f29493service.getChatList(this.chatUtils.generateUUIDString(), new ChatViewModel$loadChat$1(this), new ChatViewModel$loadChat$2(this));
    }

    /* access modifiers changed from: private */
    public final void markAllMessagesAsRead() {
        this.f29493service.markAllMessagesAsRead(this.chatUtils.generateUUIDString());
    }

    /* access modifiers changed from: private */
    public final void populateAttachmentSelector(UserFeatureFlags userFeatureFlags) {
        boolean z11;
        this.isLocationEnabled = userFeatureFlags.isLocationSharingEnabled();
        boolean isPhotoSharingEnabled = userFeatureFlags.isPhotoSharingEnabled();
        boolean isLocationSharingEnabled = userFeatureFlags.isLocationSharingEnabled();
        int i11 = 8;
        int i12 = 0;
        if ((isLocationSharingEnabled && isPhotoSharingEnabled) || isPhotoSharingEnabled) {
            z11 = true;
        } else if (isLocationSharingEnabled) {
            z11 = true;
            i12 = 8;
            i11 = 0;
        } else {
            z11 = false;
            i12 = 8;
        }
        this._attachmentView.setValue(new AttachmentViewOptions(8, 8, i11, i12, z11));
    }

    private final void registerChatConnection() {
        this.f29493service.registerConnectionHandler(new ChatViewModel$registerChatConnection$1(this), new ChatViewModel$registerChatConnection$2(this));
    }

    /* access modifiers changed from: private */
    public final List<BaseMessage> removeConfigAndChatFrozenMessages(List<? extends BaseMessage> list) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            BaseMessage baseMessage = (BaseMessage) next;
            if ((baseMessage instanceof ConfigUpdateMessage) || (baseMessage instanceof ChannelFrozenMessage)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final void startListeningNetworkConnection(Handler handler) {
        this.connectivityMonitor.startListening(new ChatViewModel$startListeningNetworkConnection$1(handler, this));
    }

    private final void stopListeningNetworkConnection() {
        this.connectivityMonitor.stopListening();
    }

    /* access modifiers changed from: private */
    public final void subscribeForMessages() {
        this.f29493service.subscribeForMessages(new ChatViewModel$subscribeForMessages$1(this), new ChatViewModel$subscribeForMessages$2(this));
    }

    /* access modifiers changed from: private */
    public final void trackImageSelectedEvent(String str, ImageSource imageSource) {
        String str2;
        String str3 = str;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFile(str3, options);
        if (str3 == null || (str2 = String.valueOf(this.imageSizeUseCase.getImageSizeInKiloBytes(str3))) == null) {
            str2 = "";
        }
        ImageSource imageSource2 = imageSource;
        this.imageMetadata = new ImageMetadata(imageSource2, String.valueOf(options.outWidth), String.valueOf(options.outWidth), str2, (String) null, 16, (DefaultConstructorMarker) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$trackImageSelectedEvent$1(this, (Continuation<? super ChatViewModel$trackImageSelectedEvent$1>) null), 3, (Object) null);
    }

    private final void unregisterChatConnection() {
        this.f29493service.removeConnectionHandler();
        if (this.f29493service.isConnected() && this.f29493service.getAutoBackgroundDetection()) {
            this.f29493service.disconnect(ChatViewModel$unregisterChatConnection$1.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void updateMessageFailure(BaseMessage baseMessage, ChatMessageViewModel chatMessageViewModel, Throwable th2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$updateMessageFailure$1(this, baseMessage, chatMessageViewModel, th2, (Continuation<? super ChatViewModel$updateMessageFailure$1>) null), 3, (Object) null);
    }

    private final void updateMessageSuccess(BaseMessage baseMessage, ChatMessageViewModel chatMessageViewModel, Throwable th2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$updateMessageSuccess$1(baseMessage, this, chatMessageViewModel, th2, (Continuation<? super ChatViewModel$updateMessageSuccess$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ChatMessageViewModel updateReceiptIfNeeds(GroupChannel groupChannel, ChatMessageViewModel chatMessageViewModel) {
        Receipt receipt;
        BaseMessage chatMessage = chatMessageViewModel.getChatMessage();
        if (chatMessage != null) {
            GroupChannel groupChannel2 = groupChannel;
            if (groupChannel.getReadReceipt(chatMessage) == 0) {
                receipt = Receipt.SEEN;
            } else {
                receipt = chatMessageViewModel.getReceiptState();
            }
            ChatMessageViewModel copy$default = ChatMessageViewModel.copy$default(chatMessageViewModel, 0, (TextMessage) null, (TextMessage) null, (ImageMessage) null, (LocationMessage) null, (String) null, false, receipt, (BaseMessage) null, (String) null, 895, (Object) null);
            if (copy$default != null) {
                return copy$default;
            }
        }
        return chatMessageViewModel;
    }

    /* access modifiers changed from: private */
    public final void updateUserCount(BaseMessage baseMessage) {
        BaseMessage.MetaData metadata = baseMessage.getMetadata();
        if (metadata != null) {
            this.userCount = metadata.getUserCount();
        }
    }

    /* access modifiers changed from: private */
    public final void uploadCameraImage() {
        invokeImageUploadUseCase(getMTempMessage(), getMIndex(), true);
    }

    /* access modifiers changed from: private */
    public final void uploadGalleryImage() {
        int mIndex = getMIndex();
        ChatMessageViewModel mTempMessage = getMTempMessage();
        boolean z11 = true;
        this.scrollToBottom = true;
        this.messages.put(Integer.valueOf(mIndex), mTempMessage);
        this._messagesLiveData.postValue(CollectionsKt___CollectionsKt.toList(this.messages.values()));
        String selectedGalleryImagePath = this.getImagePathUseCase.getSelectedGalleryImagePath();
        if (selectedGalleryImagePath.length() <= 0) {
            z11 = false;
        }
        if (z11) {
            this.imageSelectionUseCases.cacheGalleryImage(selectedGalleryImagePath);
            invokeImageUploadUseCase(mTempMessage, mIndex, false);
        }
    }

    public final void disconnect() {
        this.f29493service.unsubscribeForMessages();
        this.f29493service.disconnect(ChatViewModel$disconnect$1.INSTANCE);
    }

    @NotNull
    public final LiveData<AttachmentViewOptions> getAttachmentView() {
        return this.attachmentView;
    }

    @NotNull
    public final ChatEventsTracker getChatEvents$customerchat_basicRelease() {
        return this.chatEvents;
    }

    @NotNull
    public final SharedFlow<UIEvent> getChatUIEvents() {
        return this.chatUIEvents;
    }

    @Nullable
    public final DeliveryViewModel getDeliveryViewModel() {
        return this.deliveryViewModel;
    }

    @Nullable
    public final EventMetadata getEventMetadata$customerchat_basicRelease() {
        String str;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        String str2 = null;
        if (chatConfiguration == null) {
            return null;
        }
        ClientConfig clientConfigOrNull = chatConfiguration.getClientConfigOrNull();
        if (clientConfigOrNull != null) {
            str = clientConfigOrNull.getGlobalEntityID();
        } else {
            str = null;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(ExtensionsUtilsKt.getOrderIDFromChannelID(chatConfiguration.getChannelIDOrNull()));
        String valueOf3 = String.valueOf(chatConfiguration.getChannelIDOrNull());
        UserInfo userInfoOrNull = chatConfiguration.getUserInfoOrNull();
        if (userInfoOrNull != null) {
            str2 = userInfoOrNull.getId();
        }
        return new EventMetadata(valueOf, valueOf2, valueOf3, String.valueOf(str2));
    }

    @NotNull
    public final ImageEventsTracker getImageEvents$customerchat_basicRelease() {
        return this.imageEvents;
    }

    @NotNull
    public final LocationEventsTracker getLocationEvents$customerchat_basicRelease() {
        return this.locationEvents;
    }

    @NotNull
    public final MessageEventsTracker getMessageEvents$customerchat_basicRelease() {
        return this.messageEvents;
    }

    @NotNull
    public final LiveData<List<ChatMessageViewModel>> getMessagesLiveData() {
        return this.messagesLiveData;
    }

    @NotNull
    public final LiveData<Integer> getNoInternetLiveData() {
        return this.noInternetLiveData;
    }

    @NotNull
    public final SharedFlow<ImageSelectionType> getOpenImageNavigator() {
        return this.openImageNavigator;
    }

    @NotNull
    public final LiveData<List<String>> getQuickReplies() {
        return this.quickReplies;
    }

    @NotNull
    public final LiveData<Boolean> getRefreshing() {
        return this.refreshing;
    }

    public final void init(boolean z11) {
        DeliveryViewModel deliveryViewModel2;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null) {
            DeliveryInfo deliveryInfo = chatConfiguration.getDeliveryInfo();
            if (deliveryInfo != null) {
                deliveryViewModel2 = new DeliveryViewModel(deliveryInfo.getCode(), deliveryInfo.getAmount(), deliveryInfo.getAddress(), deliveryInfo.getComments());
            } else {
                deliveryViewModel2 = new DeliveryViewModel((String) null, (String) null, (String) null, (String) null);
            }
            this.deliveryViewModel = deliveryViewModel2;
            this._quickReplies.postValue(chatConfiguration.getQuickReplies());
            Translations translations = chatConfiguration.getTranslations();
            if (translations instanceof Translations.DISABLED) {
                this.enableTranslation = false;
            } else if (translations instanceof Translations.ENABLED) {
                this.enableTranslation = true;
                this.f29493service.setPreferredLanguage(((Translations.ENABLED) translations).getPreferredLanguage());
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$init$2(z11, this, (Continuation<? super ChatViewModel$init$2>) null), 3, (Object) null);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$init$3(this, chatConfiguration, (Continuation<? super ChatViewModel$init$3>) null), 3, (Object) null);
        }
    }

    public final boolean isTranslationEnabled() {
        return this.enableTranslation;
    }

    public final void listenAllConnection(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        startListeningNetworkConnection(handler);
        registerChatConnection();
    }

    public final void locationSharingError() {
        this.eventHandler.onEvent(new Event.LocationProviderError(this.isLocationEnabled));
    }

    public final boolean onBackPressed() {
        if (canExit()) {
            return false;
        }
        this._chatUIEvents.tryEmit(new UIEvent.LocalizedErrorMessage(Integer.valueOf(R.string.customer_chat_chat_exit_error_message)));
        return true;
    }

    public void onCleared() {
        super.onCleared();
        this.f29493service.clear();
    }

    public final void onLocationReceived(@Nullable LocationData locationData) {
        LocationData locationData2 = locationData;
        if (locationData2 != null) {
            if (!this.f29493service.isConnected()) {
                this.pendingLocationData = locationData2;
                return;
            }
            LocationData copy$default = LocationData.copy$default(locationData, 0.0d, 0.0d, (String) null, (Source) null, this.chatUtils.generateUUIDString(), 15, (Object) null);
            int size = this.messages.size();
            LocationData locationData3 = copy$default;
            ChatMessageViewModel chatMessageViewModel = r3;
            ChatMessageViewModel chatMessageViewModel2 = new ChatMessageViewModel(size, new TextMessage(8, (String) null, 2, (DefaultConstructorMarker) null), (TextMessage) null, (ImageMessage) null, new LocationMessage.Location(copy$default.getLat(), copy$default.getLon()), "", true, Receipt.SENDING, (BaseMessage) null, (String) null, 780, (DefaultConstructorMarker) null);
            this.scrollToBottom = true;
            this.messages.put(Integer.valueOf(size), chatMessageViewModel);
            this._messagesLiveData.setValue(CollectionsKt___CollectionsKt.toList(this.messages.values()));
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$onLocationReceived$1(this, new MessageMetadata(locationData3.getCorrelationID(), MessageType.LOCATION, 0, 0, (String) null, (Boolean) null, (String) null, 124, (DefaultConstructorMarker) null), (Continuation<? super ChatViewModel$onLocationReceived$1>) null), 3, (Object) null);
            this.f29493service.sendLocationMessage(locationData3, new ChatViewModel$onLocationReceived$2(this, chatMessageViewModel), new ChatViewModel$onLocationReceived$3(this, chatMessageViewModel));
        }
    }

    public final void openCamera() {
        String str;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$openCamera$1(this, (Continuation<? super ChatViewModel$openCamera$1>) null), 3, (Object) null);
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration == null || (str = chatConfiguration.getChannelIDOrNull()) == null) {
            str = "";
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        GetCameraImageUriStatus cameraImageUri = this.imageSelectionUseCases.getCameraImageUri(str + '_' + format);
        if (cameraImageUri instanceof GetCameraImageUriStatus.Data) {
            this.f29493service.setAutoBackgroundDetection(false);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$openCamera$2(this, cameraImageUri, (Continuation<? super ChatViewModel$openCamera$2>) null), 3, (Object) null);
        } else if (cameraImageUri instanceof GetCameraImageUriStatus.Error) {
            this._chatUIEvents.tryEmit(new UIEvent.LocalizedErrorMessage(Integer.valueOf(R.string.customer_chat_all_error)));
        }
    }

    public final void openGallery() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$openGallery$1(this, (Continuation<? super ChatViewModel$openGallery$1>) null), 3, (Object) null);
        this.f29493service.setAutoBackgroundDetection(false);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$openGallery$2(this, (Continuation<? super ChatViewModel$openGallery$2>) null), 3, (Object) null);
    }

    @Nullable
    public final String preferredLanguage$customerchat_basicRelease() {
        ChatConfiguration chatConfiguration;
        Translations translations;
        if (!this.enableTranslation || (chatConfiguration = this.chatConfigProvider.getChatConfiguration()) == null || (translations = chatConfiguration.getTranslations()) == null) {
            return null;
        }
        return translations.preferredLanguage();
    }

    public final void resetConnection() {
        this.f29493service.setAutoBackgroundDetection(true);
    }

    public final void sendCameraPhoto() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$sendCameraPhoto$1(this, (Continuation<? super ChatViewModel$sendCameraPhoto$1>) null), 3, (Object) null);
    }

    public final void sendGalleryPhoto() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$sendGalleryPhoto$1(this, (Continuation<? super ChatViewModel$sendGalleryPhoto$1>) null), 3, (Object) null);
    }

    public final boolean sendNewMessage(@NotNull String str, boolean z11) {
        List<String> list;
        Translations translations;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "messageText");
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (!isValidMessage(str)) {
            return false;
        }
        TextMessageData textMessageData = new TextMessageData(str2, this.chatUtils.generateUUIDString());
        int size = this.messages.size();
        ChatMessageViewModel chatMessageViewModel = r6;
        ChatMessageViewModel chatMessageViewModel2 = new ChatMessageViewModel(size, new TextMessage(0, str2, 1, (DefaultConstructorMarker) null), (TextMessage) null, (ImageMessage) null, (LocationMessage) null, "", true, Receipt.SENDING, (BaseMessage) null, (String) null, 796, (DefaultConstructorMarker) null);
        ChatViewModelEventsHelperKt.trackMessageEvent(this, str2, z11, textMessageData.getCorrelationID());
        this.messages.put(Integer.valueOf(size), chatMessageViewModel);
        this._messagesLiveData.setValue(CollectionsKt___CollectionsKt.toList(this.messages.values()));
        ChannelService channelService = this.f29493service;
        if (chatConfiguration == null || (translations = chatConfiguration.getTranslations()) == null) {
            list = null;
        } else {
            list = translations.getSupportedTranslationsList();
        }
        channelService.sendMessage(textMessageData, list, new ChatViewModel$sendNewMessage$1(this, chatMessageViewModel), new ChatViewModel$sendNewMessage$2(this, chatMessageViewModel));
        return true;
    }

    public final void sendQuickReply(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "messageText");
        this.eventHandler.onEvent(new Event.QuickReplyMessageSent(str));
        if (Intrinsics.areEqual((Object) this._refreshing.getValue(), (Object) Boolean.FALSE)) {
            sendNewMessage(str, true);
        }
    }

    public final boolean shouldScrollToBottom() {
        return this.scrollToBottom;
    }

    public final void showImageShareConfirmation(@NotNull Context context, int i11, @NotNull Uri uri, @Nullable ChatLogger chatLogger) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri2 = uri;
        Intrinsics.checkNotNullParameter(uri2, "uri");
        UploadImageConfirmationDialog uploadImageConfirmationDialog = new UploadImageConfirmationDialog(context, chatLogger);
        uploadImageConfirmationDialog.bind(i11, this.sendListener);
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        Job unused = BuildersKt__Builders_commonKt.launch$default(viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$showImageShareConfirmation$1(this, i11, uri2, uploadImageConfirmationDialog, (Continuation<? super ChatViewModel$showImageShareConfirmation$1>) null), 3, (Object) null);
    }

    public final void stopListeningAllConnection() {
        unregisterChatConnection();
        stopListeningNetworkConnection();
    }

    public final void translate() {
        String str;
        List<String> list;
        Translations translations;
        Translations translations2;
        this.enableTranslation = !this.enableTranslation;
        MapperUtilKt.replaceAll(this.messages, new ChatViewModel$translate$1(this));
        this._messagesLiveData.setValue(CollectionsKt___CollectionsKt.toList(this.messages.values()));
        this.eventHandler.onEvent(new Event.Translation(this.enableTranslation));
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration == null || (translations2 = chatConfiguration.getTranslations()) == null) {
            str = null;
        } else {
            str = translations2.preferredLanguage();
        }
        if (chatConfiguration == null || (translations = chatConfiguration.getTranslations()) == null) {
            list = null;
        } else {
            list = translations.getSupportedTranslationsList();
        }
        TranslationMetadata translationMetadata = new TranslationMetadata(str, list);
        EventMetadata eventMetadata$customerchat_basicRelease = getEventMetadata$customerchat_basicRelease();
        if (eventMetadata$customerchat_basicRelease != null) {
            if (this.enableTranslation) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$translate$2(this, eventMetadata$customerchat_basicRelease, translationMetadata, (Continuation<? super ChatViewModel$translate$2>) null), 3, (Object) null);
            } else {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$translate$3(this, eventMetadata$customerchat_basicRelease, translationMetadata, (Continuation<? super ChatViewModel$translate$3>) null), 3, (Object) null);
            }
        }
    }
}
