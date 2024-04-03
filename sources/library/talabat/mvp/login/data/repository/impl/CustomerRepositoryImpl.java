package library.talabat.mvp.login.data.repository.impl;

import android.content.Context;
import buisnessmodels.Customer;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.domain.address.Address;
import datamodels.CustomerInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Llibrary/talabat/mvp/login/data/repository/impl/CustomerRepositoryImpl;", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "context", "Landroid/content/Context;", "customer", "Lbuisnessmodels/Customer;", "setPilotUser", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Lbuisnessmodels/Customer;Lkotlin/jvm/functions/Function1;)V", "getCustomerAddress", "Ljava/util/ArrayList;", "Lcom/talabat/domain/address/Address;", "Lkotlin/collections/ArrayList;", "getMobileNumber", "withCountryCode", "", "getMobileNumberForGuestUser", "hasAddresses", "isLoggedIn", "saveCustomerInfo", "customerInfo", "Ldatamodels/CustomerInfo;", "setCustomerAddresses", "addresses", "", "setSelectedCustomerAddress", "addressId", "areaId", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerRepositoryImpl implements CustomerRepository {
    @NotNull
    private final Context context;
    @NotNull
    private final Customer customer;
    @NotNull
    private final Function1<String, Unit> setPilotUser;

    public CustomerRepositoryImpl(@NotNull Context context2, @NotNull Customer customer2, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(customer2, "customer");
        Intrinsics.checkNotNullParameter(function1, "setPilotUser");
        this.context = context2;
        this.customer = customer2;
        this.setPilotUser = function1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getMobileNumberForGuestUser(boolean r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.context
            java.lang.String r1 = com.talabat.helpers.GlobalConstants.PrefsConstants.getNAME()
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "context.getSharedPrefere…xt.MODE_PRIVATE\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            JsonModels.parser.UniversalGson r1 = JsonModels.parser.UniversalGson.INSTANCE
            com.google.gson.Gson r1 = r1.gson
            int r2 = com.talabat.helpers.GlobalDataModel.SelectedAreaId
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            boolean r2 = r0.contains(r2)
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0072
            int r2 = com.talabat.helpers.GlobalDataModel.SelectedAreaId
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r0 = r0.getString(r2, r3)
            boolean r2 = r1 instanceof com.google.gson.Gson
            java.lang.Class<datamodels.QuickOrderInfo> r4 = datamodels.QuickOrderInfo.class
            if (r2 != 0) goto L_0x0047
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r4)
            goto L_0x004b
        L_0x0047:
            java.lang.Object r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r1, (java.lang.String) r0, r4)
        L_0x004b:
            datamodels.QuickOrderInfo r0 = (datamodels.QuickOrderInfo) r0
            if (r0 == 0) goto L_0x0072
            if (r6 == 0) goto L_0x005b
            com.talabat.domain.address.Address r6 = r0.address
            java.lang.String r6 = r6.mobilNumberCountryCode
            if (r6 == 0) goto L_0x005b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto L_0x005c
        L_0x005b:
            r6 = r3
        L_0x005c:
            com.talabat.domain.address.Address r0 = r0.address
            java.lang.String r0 = r0.mobileNumber
            if (r0 == 0) goto L_0x0073
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r0)
            java.lang.String r6 = r1.toString()
            goto L_0x0073
        L_0x0072:
            r6 = r3
        L_0x0073:
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)
            if (r0 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r3 = r6
        L_0x007b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl.getMobileNumberForGuestUser(boolean):java.lang.String");
    }

    @NotNull
    public ArrayList<Address> getCustomerAddress() {
        ArrayList<Address> customerAddress = this.customer.getCustomerAddress();
        Intrinsics.checkNotNullExpressionValue(customerAddress, "customer.customerAddress");
        return customerAddress;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMobileNumber(boolean r4) {
        /*
            r3 = this;
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            boolean r0 = r0.isLoggedIn()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0067
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r0 = r0.getSelectedCustomerAddress()
            if (r0 == 0) goto L_0x0062
            if (r4 == 0) goto L_0x0035
            buisnessmodels.Customer r4 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r4 = r4.getSelectedCustomerAddress()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r4 = r4.mobilNumberCountryCode
            if (r4 == 0) goto L_0x0035
            buisnessmodels.Customer r4 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r4 = r4.getSelectedCustomerAddress()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r4 = r4.mobilNumberCountryCode
            goto L_0x0036
        L_0x0035:
            r4 = r1
        L_0x0036:
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r0 = r0.getSelectedCustomerAddress()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.mobileNumber
            if (r0 == 0) goto L_0x006b
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r0 = r0.getSelectedCustomerAddress()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.mobileNumber
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r0)
            java.lang.String r4 = r2.toString()
            goto L_0x006b
        L_0x0062:
            java.lang.String r4 = r3.getMobileNumberForGuestUser(r4)
            goto L_0x006b
        L_0x0067:
            java.lang.String r4 = r3.getMobileNumberForGuestUser(r4)
        L_0x006b:
            if (r4 != 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r1 = r4
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl.getMobileNumber(boolean):java.lang.String");
    }

    public boolean hasAddresses() {
        return this.customer.hasAddresses();
    }

    public boolean isLoggedIn() {
        return this.customer.isLoggedIn();
    }

    public void saveCustomerInfo(@Nullable CustomerInfo customerInfo) {
        String str;
        this.customer.setCustomerInfo(customerInfo);
        if (customerInfo != null) {
            str = customerInfo.email;
        } else {
            str = null;
        }
        if (str != null) {
            Function1<String, Unit> function1 = this.setPilotUser;
            String str2 = customerInfo.email;
            Intrinsics.checkNotNullExpressionValue(str2, "customerInfo.email");
            function1.invoke(str2);
        }
    }

    public void setCustomerAddresses(@NotNull List<Address> list) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        this.customer.setCustomerAddress(this.context, new ArrayList(list));
    }

    public void setSelectedCustomerAddress(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "addressId");
        this.customer.setSelectedCustomerAddress(this.context, str, i11);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomerRepositoryImpl(android.content.Context r1, buisnessmodels.Customer r2, kotlin.jvm.functions.Function1 r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000d
            buisnessmodels.Customer r2 = buisnessmodels.Customer.getInstance()
            java.lang.String r5 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x000d:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0013
            library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl$1 r3 = library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl.AnonymousClass1.INSTANCE
        L_0x0013:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl.<init>(android.content.Context, buisnessmodels.Customer, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
