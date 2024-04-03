package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ClientToken extends IInterface {

    public static class Default implements ClientToken {
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ClientToken {
        private static final String DESCRIPTOR = "com.huawei.wearengine.ClientToken";

        public static class Proxy implements ClientToken {
            public static ClientToken sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ClientToken asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ClientToken)) ? new Proxy(iBinder) : (ClientToken) queryLocalInterface;
        }

        public static ClientToken getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ClientToken clientToken) {
            if (Proxy.sDefaultImpl != null || clientToken == null) {
                return false;
            }
            Proxy.sDefaultImpl = clientToken;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }
}
