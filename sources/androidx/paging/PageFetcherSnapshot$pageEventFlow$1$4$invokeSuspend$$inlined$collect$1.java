package androidx.paging;

import androidx.paging.PageFetcherSnapshot$pageEventFlow$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 implements FlowCollector<Unit> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4 f36752b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f36753c;

    public PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1(PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4 r12, CoroutineScope coroutineScope) {
        this.f36752b = r12;
        this.f36753c = coroutineScope;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x033c, code lost:
        r5 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x033d, code lost:
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x033f, code lost:
        r2.unlock((java.lang.Object) null);
        r2 = r5;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0349, code lost:
        r2 = r13;
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x034b, code lost:
        r5 = r12;
        r12 = r9.f36752b.f36815i.f36807l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x035a, code lost:
        if (androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0[r2.ordinal()] == 1) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x035c, code lost:
        r7 = r9.f36752b.f36815i.f36807l.stateHolder;
        r6 = r7.lock;
        r0.f36757k = r9;
        r0.f36758l = r2;
        r0.f36759m = r7;
        r0.f36760n = r6;
        r0.f36761o = r5;
        r0.f36762p = r2;
        r0.f36763q = r12;
        r0.f36755i = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0380, code lost:
        if (r6.lock((java.lang.Object) null, r0) != r1) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0382, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0383, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r13 = r7.state.getFailedHintsByLoadType$paging_common().get(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0392, code lost:
        r6.unlock((java.lang.Object) null);
        r6 = r5;
        r5 = r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0399, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x039a, code lost:
        r6.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x039d, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x039e, code lost:
        r13 = null;
        r6 = r5;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03a1, code lost:
        r0.f36757k = r9;
        r0.f36758l = r2;
        r0.f36759m = r6;
        r0.f36760n = null;
        r0.f36761o = null;
        r0.f36762p = null;
        r0.f36763q = null;
        r0.f36755i = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03b7, code lost:
        if (r12.d(r5, r13, r0) != r1) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03b9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03ba, code lost:
        r12 = r6;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03be, code lost:
        if (r2 != androidx.paging.LoadType.REFRESH) goto L_0x0407;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03c0, code lost:
        r5 = r6.f36752b.f36815i.f36807l.stateHolder;
        r2 = r5.lock;
        r0.f36757k = r6;
        r0.f36758l = r5;
        r0.f36759m = r2;
        r0.f36760n = r12;
        r0.f36755i = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x03de, code lost:
        if (r2.lock((java.lang.Object) null, r0) != r1) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03e0, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r13 = r5.state.getSourceLoadStates$paging_common().get$paging_common(androidx.paging.LoadType.REFRESH);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x03ef, code lost:
        r2.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x03f4, code lost:
        if ((r13 instanceof androidx.paging.LoadState.Error) != false) goto L_0x0407;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x03f6, code lost:
        r6.f36752b.f36815i.f36807l.startConsumingHints(r6.f36753c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0402, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0403, code lost:
        r2.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0406, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0407, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0408, code lost:
        r13 = androidx.paging.LoadType.APPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0410, code lost:
        if ((r12.getAppend() instanceof androidx.paging.LoadState.Error) != false) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0416, code lost:
        if (r13 == androidx.paging.LoadType.REFRESH) goto L_0x0461;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0418, code lost:
        r2 = r5.f36752b.f36815i.f36807l.stateHolder;
        r12 = r2.lock;
        r0.f36757k = r5;
        r0.f36758l = r13;
        r0.f36759m = r2;
        r0.f36760n = r12;
        r0.f36755i = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0436, code lost:
        if (r12.lock((java.lang.Object) null, r0) != r1) goto L_0x0439;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0438, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        r2 = r2.state;
        r6 = r5.f36752b.f36815i.f36807l;
        r0.f36757k = r5;
        r0.f36758l = r13;
        r0.f36759m = r12;
        r0.f36760n = null;
        r0.f36755i = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0453, code lost:
        if (r6.e(r2, r13, r0) != r1) goto L_0x0456;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0455, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0456, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0457, code lost:
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0459, code lost:
        r12.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0461, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0462, code lost:
        r7 = r5;
        r12 = r7.f36752b.f36815i.f36807l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0471, code lost:
        if (androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0[r2.ordinal()] == 1) goto L_0x04b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0473, code lost:
        r5 = r7.f36752b.f36815i.f36807l.stateHolder;
        r3 = r5.lock;
        r0.f36757k = r7;
        r0.f36758l = r2;
        r0.f36759m = r5;
        r0.f36760n = r3;
        r0.f36761o = r2;
        r0.f36762p = r12;
        r0.f36755i = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0495, code lost:
        if (r3.lock((java.lang.Object) null, r0) != r1) goto L_0x0498;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0497, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0498, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r13 = r5.state.getFailedHintsByLoadType$paging_common().get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04a7, code lost:
        r3.unlock((java.lang.Object) null);
        r3 = r2;
        r2 = r13;
        r13 = r12;
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x04af, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x04b0, code lost:
        r3.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x04b3, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04b4, code lost:
        r13 = r12;
        r12 = r2;
        r3 = r12;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04b8, code lost:
        r0.f36757k = r7;
        r0.f36758l = r12;
        r0.f36759m = null;
        r0.f36760n = null;
        r0.f36761o = null;
        r0.f36762p = null;
        r0.f36755i = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04cc, code lost:
        if (r13.d(r3, r2, r0) != r1) goto L_0x04cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x04ce, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04cf, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x04d2, code lost:
        if (r12 != androidx.paging.LoadType.REFRESH) goto L_0x051c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x04d4, code lost:
        r12 = r2.f36752b.f36815i.f36807l.stateHolder;
        r13 = r12.lock;
        r0.f36757k = r2;
        r0.f36758l = r12;
        r0.f36759m = r13;
        r0.f36755i = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x04f0, code lost:
        if (r13.lock((java.lang.Object) null, r0) != r1) goto L_0x04f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x04f2, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x04f3, code lost:
        r1 = r12;
        r12 = r13;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:?, code lost:
        r13 = r1.state.getSourceLoadStates$paging_common().get$paging_common(androidx.paging.LoadType.REFRESH);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0504, code lost:
        r12.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0509, code lost:
        if ((r13 instanceof androidx.paging.LoadState.Error) != false) goto L_0x051c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x050b, code lost:
        r0.f36752b.f36815i.f36807l.startConsumingHints(r0.f36753c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0517, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0518, code lost:
        r12.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x051b, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x051e, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x051f, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0520, code lost:
        r12.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0523, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01a3, code lost:
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01a5, code lost:
        r2.unlock((java.lang.Object) null);
        r2 = r5;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01aa, code lost:
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r13 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r2);
        r13 = kotlin.TuplesKt.to(r13.getSourceLoadStates$paging_common(), r13.currentPagingState$paging_common(r5.f36752b.f36815i.f36807l.lastHint));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01fe, code lost:
        r12.unlock((java.lang.Object) null);
        r12 = (androidx.paging.LoadStates) r13.component1();
        r13 = (androidx.paging.PagingState) r13.component2();
        r2 = r5.f36752b.f36815i.f36807l.getRemoteMediatorConnection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0217, code lost:
        if (r2 == null) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0219, code lost:
        r2.retryFailed(r13);
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x021e, code lost:
        r13 = androidx.paging.LoadType.REFRESH;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0226, code lost:
        if ((r12.getRefresh() instanceof androidx.paging.LoadState.Error) != false) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x022a, code lost:
        r2 = r13;
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x022e, code lost:
        r12 = r9.f36752b.f36815i.f36807l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x023c, code lost:
        if (androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0[r2.ordinal()] == 1) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x023e, code lost:
        r7 = r9.f36752b.f36815i.f36807l.stateHolder;
        r6 = r7.lock;
        r0.f36757k = r9;
        r0.f36758l = r2;
        r0.f36759m = r7;
        r0.f36760n = r6;
        r0.f36761o = r5;
        r0.f36762p = r2;
        r0.f36763q = r12;
        r0.f36755i = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0261, code lost:
        if (r6.lock((java.lang.Object) null, r0) != r1) goto L_0x0264;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0263, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0264, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r13 = r7.state.getFailedHintsByLoadType$paging_common().get(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0273, code lost:
        r6.unlock((java.lang.Object) null);
        r6 = r5;
        r5 = r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x027a, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x027b, code lost:
        r6.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x027e, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x027f, code lost:
        r13 = null;
        r6 = r5;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0282, code lost:
        r0.f36757k = r9;
        r0.f36758l = r2;
        r0.f36759m = r6;
        r0.f36760n = null;
        r0.f36761o = null;
        r0.f36762p = null;
        r0.f36763q = null;
        r0.f36755i = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0297, code lost:
        if (r12.d(r5, r13, r0) != r1) goto L_0x029a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0299, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x029a, code lost:
        r12 = r6;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x029e, code lost:
        if (r2 != androidx.paging.LoadType.REFRESH) goto L_0x02e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02a0, code lost:
        r5 = r6.f36752b.f36815i.f36807l.stateHolder;
        r2 = r5.lock;
        r0.f36757k = r6;
        r0.f36758l = r5;
        r0.f36759m = r2;
        r0.f36760n = r12;
        r0.f36755i = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02bd, code lost:
        if (r2.lock((java.lang.Object) null, r0) != r1) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02bf, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        r13 = r5.state.getSourceLoadStates$paging_common().get$paging_common(androidx.paging.LoadType.REFRESH);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02ce, code lost:
        r2.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02d3, code lost:
        if ((r13 instanceof androidx.paging.LoadState.Error) != false) goto L_0x02e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02d5, code lost:
        r6.f36752b.f36815i.f36807l.startConsumingHints(r6.f36753c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02e1, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02e2, code lost:
        r2.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02e5, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02e6, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02e7, code lost:
        r13 = androidx.paging.LoadType.PREPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02ef, code lost:
        if ((r12.getPrepend() instanceof androidx.paging.LoadState.Error) != false) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02f5, code lost:
        if (r13 == androidx.paging.LoadType.REFRESH) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02f7, code lost:
        r2 = r5.f36752b.f36815i.f36807l.stateHolder;
        r6 = r2.lock;
        r0.f36757k = r5;
        r0.f36758l = r13;
        r0.f36759m = r2;
        r0.f36760n = r6;
        r0.f36761o = r12;
        r0.f36755i = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0316, code lost:
        if (r6.lock((java.lang.Object) null, r0) != r1) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0318, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0319, code lost:
        r10 = r5;
        r5 = r2;
        r2 = r6;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r5 = r5.state;
        r7 = r6.f36752b.f36815i.f36807l;
        r0.f36757k = r6;
        r0.f36758l = r13;
        r0.f36759m = r2;
        r0.f36760n = r12;
        r0.f36761o = null;
        r0.f36755i = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0339, code lost:
        if (r7.e(r5, r13, r0) != r1) goto L_0x033c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x033b, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.f36755i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36755i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f36754h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36755i
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x01c1;
                case 1: goto L_0x01b1;
                case 2: goto L_0x016c;
                case 3: goto L_0x0156;
                case 4: goto L_0x0135;
                case 5: goto L_0x0123;
                case 6: goto L_0x010e;
                case 7: goto L_0x00f3;
                case 8: goto L_0x00db;
                case 9: goto L_0x00ba;
                case 10: goto L_0x00a8;
                case 11: goto L_0x0093;
                case 12: goto L_0x007c;
                case 13: goto L_0x0068;
                case 14: goto L_0x004b;
                case 15: goto L_0x003e;
                case 16: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x002d:
            java.lang.Object r12 = r0.f36759m
            kotlinx.coroutines.sync.Mutex r12 = (kotlinx.coroutines.sync.Mutex) r12
            java.lang.Object r1 = r0.f36758l
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r0 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r0 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x04f6
        L_0x003e:
            java.lang.Object r12 = r0.f36758l
            androidx.paging.LoadType r12 = (androidx.paging.LoadType) r12
            java.lang.Object r2 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r2 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x04d0
        L_0x004b:
            java.lang.Object r12 = r0.f36762p
            androidx.paging.PageFetcherSnapshot r12 = (androidx.paging.PageFetcherSnapshot) r12
            java.lang.Object r2 = r0.f36761o
            androidx.paging.LoadType r2 = (androidx.paging.LoadType) r2
            java.lang.Object r3 = r0.f36760n
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r5 = r0.f36759m
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36758l
            androidx.paging.LoadType r6 = (androidx.paging.LoadType) r6
            java.lang.Object r7 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r7 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0499
        L_0x0068:
            java.lang.Object r12 = r0.f36759m
            kotlinx.coroutines.sync.Mutex r12 = (kotlinx.coroutines.sync.Mutex) r12
            java.lang.Object r2 = r0.f36758l
            androidx.paging.LoadType r2 = (androidx.paging.LoadType) r2
            java.lang.Object r5 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r5 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r5
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0079 }
            goto L_0x0457
        L_0x0079:
            r13 = move-exception
            goto L_0x045d
        L_0x007c:
            java.lang.Object r12 = r0.f36760n
            kotlinx.coroutines.sync.Mutex r12 = (kotlinx.coroutines.sync.Mutex) r12
            java.lang.Object r2 = r0.f36759m
            androidx.paging.PageFetcherSnapshotState$Holder r2 = (androidx.paging.PageFetcherSnapshotState.Holder) r2
            java.lang.Object r5 = r0.f36758l
            androidx.paging.LoadType r5 = (androidx.paging.LoadType) r5
            java.lang.Object r6 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r6 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r6
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r5
            r5 = r6
            goto L_0x0439
        L_0x0093:
            java.lang.Object r12 = r0.f36760n
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36759m
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36758l
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r6 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r6
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x03e1
        L_0x00a8:
            java.lang.Object r12 = r0.f36759m
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36758l
            androidx.paging.LoadType r2 = (androidx.paging.LoadType) r2
            java.lang.Object r5 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r5 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r5
            goto L_0x03bc
        L_0x00ba:
            java.lang.Object r12 = r0.f36763q
            androidx.paging.PageFetcherSnapshot r12 = (androidx.paging.PageFetcherSnapshot) r12
            java.lang.Object r2 = r0.f36762p
            androidx.paging.LoadType r2 = (androidx.paging.LoadType) r2
            java.lang.Object r5 = r0.f36761o
            androidx.paging.LoadStates r5 = (androidx.paging.LoadStates) r5
            java.lang.Object r6 = r0.f36760n
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.f36759m
            androidx.paging.PageFetcherSnapshotState$Holder r7 = (androidx.paging.PageFetcherSnapshotState.Holder) r7
            java.lang.Object r8 = r0.f36758l
            androidx.paging.LoadType r8 = (androidx.paging.LoadType) r8
            java.lang.Object r9 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r9 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r9
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0384
        L_0x00db:
            java.lang.Object r12 = r0.f36760n
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36759m
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36758l
            androidx.paging.LoadType r5 = (androidx.paging.LoadType) r5
            java.lang.Object r6 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r6 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r6
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x00f0 }
            goto L_0x033d
        L_0x00f0:
            r12 = move-exception
            goto L_0x0345
        L_0x00f3:
            java.lang.Object r12 = r0.f36761o
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36760n
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36759m
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36758l
            androidx.paging.LoadType r6 = (androidx.paging.LoadType) r6
            java.lang.Object r7 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r7 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r7
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r6
            r6 = r7
            goto L_0x031d
        L_0x010e:
            java.lang.Object r12 = r0.f36760n
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36759m
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36758l
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r6 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r6
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x02c0
        L_0x0123:
            java.lang.Object r12 = r0.f36759m
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36758l
            androidx.paging.LoadType r2 = (androidx.paging.LoadType) r2
            java.lang.Object r5 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r5 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r5
            goto L_0x029c
        L_0x0135:
            java.lang.Object r12 = r0.f36763q
            androidx.paging.PageFetcherSnapshot r12 = (androidx.paging.PageFetcherSnapshot) r12
            java.lang.Object r2 = r0.f36762p
            androidx.paging.LoadType r2 = (androidx.paging.LoadType) r2
            java.lang.Object r5 = r0.f36761o
            androidx.paging.LoadStates r5 = (androidx.paging.LoadStates) r5
            java.lang.Object r6 = r0.f36760n
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.f36759m
            androidx.paging.PageFetcherSnapshotState$Holder r7 = (androidx.paging.PageFetcherSnapshotState.Holder) r7
            java.lang.Object r8 = r0.f36758l
            androidx.paging.LoadType r8 = (androidx.paging.LoadType) r8
            java.lang.Object r9 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r9 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r9
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0265
        L_0x0156:
            java.lang.Object r12 = r0.f36760n
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36759m
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36758l
            androidx.paging.LoadType r5 = (androidx.paging.LoadType) r5
            java.lang.Object r6 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r6 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r6
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x016a }
            goto L_0x01a3
        L_0x016a:
            r12 = move-exception
            goto L_0x01ad
        L_0x016c:
            java.lang.Object r12 = r0.f36761o
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r2 = r0.f36760n
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36759m
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36758l
            androidx.paging.LoadType r6 = (androidx.paging.LoadType) r6
            java.lang.Object r7 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r7 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r7
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.paging.PageFetcherSnapshotState r13 = r5.state     // Catch:{ all -> 0x016a }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r5 = r7.f36752b     // Catch:{ all -> 0x016a }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r5 = r5.f36815i     // Catch:{ all -> 0x016a }
            androidx.paging.PageFetcherSnapshot r5 = r5.f36807l     // Catch:{ all -> 0x016a }
            r0.f36757k = r7     // Catch:{ all -> 0x016a }
            r0.f36758l = r6     // Catch:{ all -> 0x016a }
            r0.f36759m = r2     // Catch:{ all -> 0x016a }
            r0.f36760n = r12     // Catch:{ all -> 0x016a }
            r0.f36761o = r4     // Catch:{ all -> 0x016a }
            r8 = 3
            r0.f36755i = r8     // Catch:{ all -> 0x016a }
            java.lang.Object r13 = r5.e(r13, r6, r0)     // Catch:{ all -> 0x016a }
            if (r13 != r1) goto L_0x01a1
            return r1
        L_0x01a1:
            r5 = r6
            r6 = r7
        L_0x01a3:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x016a }
            r2.unlock(r4)
            r2 = r5
            r9 = r6
        L_0x01aa:
            r5 = r12
            goto L_0x022e
        L_0x01ad:
            r2.unlock(r4)
            throw r12
        L_0x01b1:
            java.lang.Object r12 = r0.f36759m
            kotlinx.coroutines.sync.Mutex r12 = (kotlinx.coroutines.sync.Mutex) r12
            java.lang.Object r2 = r0.f36758l
            androidx.paging.PageFetcherSnapshotState$Holder r2 = (androidx.paging.PageFetcherSnapshotState.Holder) r2
            java.lang.Object r5 = r0.f36757k
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 r5 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1) r5
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x01e4
        L_0x01c1:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Unit r12 = (kotlin.Unit) r12
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r12 = r11.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r12 = r12.f36815i
            androidx.paging.PageFetcherSnapshot r12 = r12.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r2 = r12.stateHolder
            kotlinx.coroutines.sync.Mutex r12 = r2.lock
            r0.f36757k = r11
            r0.f36758l = r2
            r0.f36759m = r12
            r0.f36755i = r3
            java.lang.Object r13 = r12.lock(r4, r0)
            if (r13 != r1) goto L_0x01e3
            return r1
        L_0x01e3:
            r5 = r11
        L_0x01e4:
            androidx.paging.PageFetcherSnapshotState r13 = r2.state     // Catch:{ all -> 0x051f }
            androidx.paging.LoadStates r2 = r13.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x051f }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r6 = r5.f36752b     // Catch:{ all -> 0x051f }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r6 = r6.f36815i     // Catch:{ all -> 0x051f }
            androidx.paging.PageFetcherSnapshot r6 = r6.f36807l     // Catch:{ all -> 0x051f }
            androidx.paging.ViewportHint$Access r6 = r6.lastHint     // Catch:{ all -> 0x051f }
            androidx.paging.PagingState r13 = r13.currentPagingState$paging_common(r6)     // Catch:{ all -> 0x051f }
            kotlin.Pair r13 = kotlin.TuplesKt.to(r2, r13)     // Catch:{ all -> 0x051f }
            r12.unlock(r4)
            java.lang.Object r12 = r13.component1()
            androidx.paging.LoadStates r12 = (androidx.paging.LoadStates) r12
            java.lang.Object r13 = r13.component2()
            androidx.paging.PagingState r13 = (androidx.paging.PagingState) r13
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r2 = r5.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r2 = r2.f36815i
            androidx.paging.PageFetcherSnapshot r2 = r2.f36807l
            androidx.paging.RemoteMediatorConnection r2 = r2.getRemoteMediatorConnection()
            if (r2 == 0) goto L_0x021e
            r2.retryFailed(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
        L_0x021e:
            androidx.paging.LoadType r13 = androidx.paging.LoadType.REFRESH
            androidx.paging.LoadState r2 = r12.getRefresh()
            boolean r2 = r2 instanceof androidx.paging.LoadState.Error
            if (r2 != 0) goto L_0x022a
            goto L_0x02e7
        L_0x022a:
            r2 = r13
            r9 = r5
            goto L_0x01aa
        L_0x022e:
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r12 = r9.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r12 = r12.f36815i
            androidx.paging.PageFetcherSnapshot r12 = r12.f36807l
            int[] r13 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0
            int r6 = r2.ordinal()
            r13 = r13[r6]
            if (r13 == r3) goto L_0x027f
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r13 = r9.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r13 = r13.f36815i
            androidx.paging.PageFetcherSnapshot r13 = r13.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r7 = r13.stateHolder
            kotlinx.coroutines.sync.Mutex r6 = r7.lock
            r0.f36757k = r9
            r0.f36758l = r2
            r0.f36759m = r7
            r0.f36760n = r6
            r0.f36761o = r5
            r0.f36762p = r2
            r0.f36763q = r12
            r13 = 4
            r0.f36755i = r13
            java.lang.Object r13 = r6.lock(r4, r0)
            if (r13 != r1) goto L_0x0264
            return r1
        L_0x0264:
            r8 = r2
        L_0x0265:
            androidx.paging.PageFetcherSnapshotState r13 = r7.state     // Catch:{ all -> 0x027a }
            java.util.Map r13 = r13.getFailedHintsByLoadType$paging_common()     // Catch:{ all -> 0x027a }
            java.lang.Object r13 = r13.get(r8)     // Catch:{ all -> 0x027a }
            androidx.paging.ViewportHint r13 = (androidx.paging.ViewportHint) r13     // Catch:{ all -> 0x027a }
            r6.unlock(r4)
            r6 = r5
            r5 = r2
            r2 = r8
            goto L_0x0282
        L_0x027a:
            r12 = move-exception
            r6.unlock(r4)
            throw r12
        L_0x027f:
            r13 = r4
            r6 = r5
            r5 = r2
        L_0x0282:
            r0.f36757k = r9
            r0.f36758l = r2
            r0.f36759m = r6
            r0.f36760n = r4
            r0.f36761o = r4
            r0.f36762p = r4
            r0.f36763q = r4
            r7 = 5
            r0.f36755i = r7
            java.lang.Object r12 = r12.d(r5, r13, r0)
            if (r12 != r1) goto L_0x029a
            return r1
        L_0x029a:
            r12 = r6
            r6 = r9
        L_0x029c:
            androidx.paging.LoadType r13 = androidx.paging.LoadType.REFRESH
            if (r2 != r13) goto L_0x02e6
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r13 = r6.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r13 = r13.f36815i
            androidx.paging.PageFetcherSnapshot r13 = r13.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r5 = r13.stateHolder
            kotlinx.coroutines.sync.Mutex r2 = r5.lock
            r0.f36757k = r6
            r0.f36758l = r5
            r0.f36759m = r2
            r0.f36760n = r12
            r13 = 6
            r0.f36755i = r13
            java.lang.Object r13 = r2.lock(r4, r0)
            if (r13 != r1) goto L_0x02c0
            return r1
        L_0x02c0:
            androidx.paging.PageFetcherSnapshotState r13 = r5.state     // Catch:{ all -> 0x02e1 }
            androidx.paging.LoadStates r13 = r13.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x02e1 }
            androidx.paging.LoadType r5 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x02e1 }
            androidx.paging.LoadState r13 = r13.get$paging_common(r5)     // Catch:{ all -> 0x02e1 }
            r2.unlock(r4)
            boolean r13 = r13 instanceof androidx.paging.LoadState.Error
            if (r13 != 0) goto L_0x02e6
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r13 = r6.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r13 = r13.f36815i
            androidx.paging.PageFetcherSnapshot r13 = r13.f36807l
            kotlinx.coroutines.CoroutineScope r2 = r6.f36753c
            r13.startConsumingHints(r2)
            goto L_0x02e6
        L_0x02e1:
            r12 = move-exception
            r2.unlock(r4)
            throw r12
        L_0x02e6:
            r5 = r6
        L_0x02e7:
            androidx.paging.LoadType r13 = androidx.paging.LoadType.PREPEND
            androidx.paging.LoadState r2 = r12.getPrepend()
            boolean r2 = r2 instanceof androidx.paging.LoadState.Error
            if (r2 != 0) goto L_0x02f3
            goto L_0x0408
        L_0x02f3:
            androidx.paging.LoadType r2 = androidx.paging.LoadType.REFRESH
            if (r13 == r2) goto L_0x0349
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r2 = r5.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r2 = r2.f36815i
            androidx.paging.PageFetcherSnapshot r2 = r2.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r2 = r2.stateHolder
            kotlinx.coroutines.sync.Mutex r6 = r2.lock
            r0.f36757k = r5
            r0.f36758l = r13
            r0.f36759m = r2
            r0.f36760n = r6
            r0.f36761o = r12
            r7 = 7
            r0.f36755i = r7
            java.lang.Object r7 = r6.lock(r4, r0)
            if (r7 != r1) goto L_0x0319
            return r1
        L_0x0319:
            r10 = r5
            r5 = r2
            r2 = r6
            r6 = r10
        L_0x031d:
            androidx.paging.PageFetcherSnapshotState r5 = r5.state     // Catch:{ all -> 0x00f0 }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r7 = r6.f36752b     // Catch:{ all -> 0x00f0 }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r7 = r7.f36815i     // Catch:{ all -> 0x00f0 }
            androidx.paging.PageFetcherSnapshot r7 = r7.f36807l     // Catch:{ all -> 0x00f0 }
            r0.f36757k = r6     // Catch:{ all -> 0x00f0 }
            r0.f36758l = r13     // Catch:{ all -> 0x00f0 }
            r0.f36759m = r2     // Catch:{ all -> 0x00f0 }
            r0.f36760n = r12     // Catch:{ all -> 0x00f0 }
            r0.f36761o = r4     // Catch:{ all -> 0x00f0 }
            r8 = 8
            r0.f36755i = r8     // Catch:{ all -> 0x00f0 }
            java.lang.Object r5 = r7.e(r5, r13, r0)     // Catch:{ all -> 0x00f0 }
            if (r5 != r1) goto L_0x033c
            return r1
        L_0x033c:
            r5 = r13
        L_0x033d:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f0 }
            r2.unlock(r4)
            r2 = r5
            r9 = r6
            goto L_0x034b
        L_0x0345:
            r2.unlock(r4)
            throw r12
        L_0x0349:
            r2 = r13
            r9 = r5
        L_0x034b:
            r5 = r12
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r12 = r9.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r12 = r12.f36815i
            androidx.paging.PageFetcherSnapshot r12 = r12.f36807l
            int[] r13 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0
            int r6 = r2.ordinal()
            r13 = r13[r6]
            if (r13 == r3) goto L_0x039e
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r13 = r9.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r13 = r13.f36815i
            androidx.paging.PageFetcherSnapshot r13 = r13.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r7 = r13.stateHolder
            kotlinx.coroutines.sync.Mutex r6 = r7.lock
            r0.f36757k = r9
            r0.f36758l = r2
            r0.f36759m = r7
            r0.f36760n = r6
            r0.f36761o = r5
            r0.f36762p = r2
            r0.f36763q = r12
            r13 = 9
            r0.f36755i = r13
            java.lang.Object r13 = r6.lock(r4, r0)
            if (r13 != r1) goto L_0x0383
            return r1
        L_0x0383:
            r8 = r2
        L_0x0384:
            androidx.paging.PageFetcherSnapshotState r13 = r7.state     // Catch:{ all -> 0x0399 }
            java.util.Map r13 = r13.getFailedHintsByLoadType$paging_common()     // Catch:{ all -> 0x0399 }
            java.lang.Object r13 = r13.get(r8)     // Catch:{ all -> 0x0399 }
            androidx.paging.ViewportHint r13 = (androidx.paging.ViewportHint) r13     // Catch:{ all -> 0x0399 }
            r6.unlock(r4)
            r6 = r5
            r5 = r2
            r2 = r8
            goto L_0x03a1
        L_0x0399:
            r12 = move-exception
            r6.unlock(r4)
            throw r12
        L_0x039e:
            r13 = r4
            r6 = r5
            r5 = r2
        L_0x03a1:
            r0.f36757k = r9
            r0.f36758l = r2
            r0.f36759m = r6
            r0.f36760n = r4
            r0.f36761o = r4
            r0.f36762p = r4
            r0.f36763q = r4
            r7 = 10
            r0.f36755i = r7
            java.lang.Object r12 = r12.d(r5, r13, r0)
            if (r12 != r1) goto L_0x03ba
            return r1
        L_0x03ba:
            r12 = r6
            r6 = r9
        L_0x03bc:
            androidx.paging.LoadType r13 = androidx.paging.LoadType.REFRESH
            if (r2 != r13) goto L_0x0407
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r13 = r6.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r13 = r13.f36815i
            androidx.paging.PageFetcherSnapshot r13 = r13.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r5 = r13.stateHolder
            kotlinx.coroutines.sync.Mutex r2 = r5.lock
            r0.f36757k = r6
            r0.f36758l = r5
            r0.f36759m = r2
            r0.f36760n = r12
            r13 = 11
            r0.f36755i = r13
            java.lang.Object r13 = r2.lock(r4, r0)
            if (r13 != r1) goto L_0x03e1
            return r1
        L_0x03e1:
            androidx.paging.PageFetcherSnapshotState r13 = r5.state     // Catch:{ all -> 0x0402 }
            androidx.paging.LoadStates r13 = r13.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x0402 }
            androidx.paging.LoadType r5 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0402 }
            androidx.paging.LoadState r13 = r13.get$paging_common(r5)     // Catch:{ all -> 0x0402 }
            r2.unlock(r4)
            boolean r13 = r13 instanceof androidx.paging.LoadState.Error
            if (r13 != 0) goto L_0x0407
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r13 = r6.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r13 = r13.f36815i
            androidx.paging.PageFetcherSnapshot r13 = r13.f36807l
            kotlinx.coroutines.CoroutineScope r2 = r6.f36753c
            r13.startConsumingHints(r2)
            goto L_0x0407
        L_0x0402:
            r12 = move-exception
            r2.unlock(r4)
            throw r12
        L_0x0407:
            r5 = r6
        L_0x0408:
            androidx.paging.LoadType r13 = androidx.paging.LoadType.APPEND
            androidx.paging.LoadState r12 = r12.getAppend()
            boolean r12 = r12 instanceof androidx.paging.LoadState.Error
            if (r12 != 0) goto L_0x0414
            goto L_0x051c
        L_0x0414:
            androidx.paging.LoadType r12 = androidx.paging.LoadType.REFRESH
            if (r13 == r12) goto L_0x0461
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r12 = r5.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r12 = r12.f36815i
            androidx.paging.PageFetcherSnapshot r12 = r12.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r2 = r12.stateHolder
            kotlinx.coroutines.sync.Mutex r12 = r2.lock
            r0.f36757k = r5
            r0.f36758l = r13
            r0.f36759m = r2
            r0.f36760n = r12
            r6 = 12
            r0.f36755i = r6
            java.lang.Object r6 = r12.lock(r4, r0)
            if (r6 != r1) goto L_0x0439
            return r1
        L_0x0439:
            androidx.paging.PageFetcherSnapshotState r2 = r2.state     // Catch:{ all -> 0x0079 }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r6 = r5.f36752b     // Catch:{ all -> 0x0079 }
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r6 = r6.f36815i     // Catch:{ all -> 0x0079 }
            androidx.paging.PageFetcherSnapshot r6 = r6.f36807l     // Catch:{ all -> 0x0079 }
            r0.f36757k = r5     // Catch:{ all -> 0x0079 }
            r0.f36758l = r13     // Catch:{ all -> 0x0079 }
            r0.f36759m = r12     // Catch:{ all -> 0x0079 }
            r0.f36760n = r4     // Catch:{ all -> 0x0079 }
            r7 = 13
            r0.f36755i = r7     // Catch:{ all -> 0x0079 }
            java.lang.Object r2 = r6.e(r2, r13, r0)     // Catch:{ all -> 0x0079 }
            if (r2 != r1) goto L_0x0456
            return r1
        L_0x0456:
            r2 = r13
        L_0x0457:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r12.unlock(r4)
            goto L_0x0462
        L_0x045d:
            r12.unlock(r4)
            throw r13
        L_0x0461:
            r2 = r13
        L_0x0462:
            r7 = r5
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r12 = r7.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r12 = r12.f36815i
            androidx.paging.PageFetcherSnapshot r12 = r12.f36807l
            int[] r13 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0
            int r5 = r2.ordinal()
            r13 = r13[r5]
            if (r13 == r3) goto L_0x04b4
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r13 = r7.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r13 = r13.f36815i
            androidx.paging.PageFetcherSnapshot r13 = r13.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r5 = r13.stateHolder
            kotlinx.coroutines.sync.Mutex r3 = r5.lock
            r0.f36757k = r7
            r0.f36758l = r2
            r0.f36759m = r5
            r0.f36760n = r3
            r0.f36761o = r2
            r0.f36762p = r12
            r13 = 14
            r0.f36755i = r13
            java.lang.Object r13 = r3.lock(r4, r0)
            if (r13 != r1) goto L_0x0498
            return r1
        L_0x0498:
            r6 = r2
        L_0x0499:
            androidx.paging.PageFetcherSnapshotState r13 = r5.state     // Catch:{ all -> 0x04af }
            java.util.Map r13 = r13.getFailedHintsByLoadType$paging_common()     // Catch:{ all -> 0x04af }
            java.lang.Object r13 = r13.get(r6)     // Catch:{ all -> 0x04af }
            androidx.paging.ViewportHint r13 = (androidx.paging.ViewportHint) r13     // Catch:{ all -> 0x04af }
            r3.unlock(r4)
            r3 = r2
            r2 = r13
            r13 = r12
            r12 = r6
            goto L_0x04b8
        L_0x04af:
            r12 = move-exception
            r3.unlock(r4)
            throw r12
        L_0x04b4:
            r13 = r12
            r12 = r2
            r3 = r12
            r2 = r4
        L_0x04b8:
            r0.f36757k = r7
            r0.f36758l = r12
            r0.f36759m = r4
            r0.f36760n = r4
            r0.f36761o = r4
            r0.f36762p = r4
            r5 = 15
            r0.f36755i = r5
            java.lang.Object r13 = r13.d(r3, r2, r0)
            if (r13 != r1) goto L_0x04cf
            return r1
        L_0x04cf:
            r2 = r7
        L_0x04d0:
            androidx.paging.LoadType r13 = androidx.paging.LoadType.REFRESH
            if (r12 != r13) goto L_0x051c
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r12 = r2.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r12 = r12.f36815i
            androidx.paging.PageFetcherSnapshot r12 = r12.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r12 = r12.stateHolder
            kotlinx.coroutines.sync.Mutex r13 = r12.lock
            r0.f36757k = r2
            r0.f36758l = r12
            r0.f36759m = r13
            r3 = 16
            r0.f36755i = r3
            java.lang.Object r0 = r13.lock(r4, r0)
            if (r0 != r1) goto L_0x04f3
            return r1
        L_0x04f3:
            r1 = r12
            r12 = r13
            r0 = r2
        L_0x04f6:
            androidx.paging.PageFetcherSnapshotState r13 = r1.state     // Catch:{ all -> 0x0517 }
            androidx.paging.LoadStates r13 = r13.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x0517 }
            androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0517 }
            androidx.paging.LoadState r13 = r13.get$paging_common(r1)     // Catch:{ all -> 0x0517 }
            r12.unlock(r4)
            boolean r12 = r13 instanceof androidx.paging.LoadState.Error
            if (r12 != 0) goto L_0x051c
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r12 = r0.f36752b
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1 r12 = r12.f36815i
            androidx.paging.PageFetcherSnapshot r12 = r12.f36807l
            kotlinx.coroutines.CoroutineScope r13 = r0.f36753c
            r12.startConsumingHints(r13)
            goto L_0x051c
        L_0x0517:
            r13 = move-exception
            r12.unlock(r4)
            throw r13
        L_0x051c:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x051f:
            r13 = move-exception
            r12.unlock(r4)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
