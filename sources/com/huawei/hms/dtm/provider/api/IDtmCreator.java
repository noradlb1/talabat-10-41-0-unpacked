package com.huawei.hms.dtm.provider.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.dtm.provider.api.IDtmDelegate;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public interface IDtmCreator extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.dtm.provider.api.IDtmCreator";

    public static class Default implements IDtmCreator {
        public IBinder asBinder() {
            return null;
        }

        public IDtmDelegate newDtmDelegate(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDtmCreator {

        public static class Proxy implements IDtmCreator {
            public static IDtmCreator sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f48669a;

            public Proxy(IBinder iBinder) {
                this.f48669a = iBinder;
            }

            public IBinder asBinder() {
                return this.f48669a;
            }

            public String getInterfaceDescriptor() {
                return IDtmCreator.DESCRIPTOR;
            }

            public IDtmDelegate newDtmDelegate(IObjectWrapper iObjectWrapper) throws RemoteException {
                IDtmDelegate asInterface;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmCreator.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.f48669a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        asInterface = IDtmDelegate.Stub.asInterface(obtain2.readStrongBinder());
                    } else {
                        asInterface = Stub.getDefaultImpl().newDtmDelegate(iObjectWrapper);
                    }
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDtmCreator.DESCRIPTOR);
        }

        public static IDtmCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDtmCreator.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDtmCreator)) ? new Proxy(iBinder) : (IDtmCreator) queryLocalInterface;
        }

        public static IDtmCreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDtmCreator iDtmCreator) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDtmCreator == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDtmCreator;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1598968902) {
                parcel2.writeString(IDtmCreator.DESCRIPTOR);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface(IDtmCreator.DESCRIPTOR);
                IDtmDelegate newDtmDelegate = newDtmDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(newDtmDelegate != null ? newDtmDelegate.asBinder() : null);
                return true;
            }
        }
    }

    IDtmDelegate newDtmDelegate(IObjectWrapper iObjectWrapper) throws RemoteException;
}
