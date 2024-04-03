package com.huawei.hms.dtm.provider.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDtmFilter extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.dtm.provider.api.IDtmFilter";

    public static class Default implements IDtmFilter {
        public IBinder asBinder() {
            return null;
        }

        public String getUserProfile(String str) throws RemoteException {
            return null;
        }

        public void onFiltered(String str, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDtmFilter {

        public static class Proxy implements IDtmFilter {
            public static IDtmFilter sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f48671a;

            public Proxy(IBinder iBinder) {
                this.f48671a = iBinder;
            }

            public IBinder asBinder() {
                return this.f48671a;
            }

            public String getInterfaceDescriptor() {
                return IDtmFilter.DESCRIPTOR;
            }

            public String getUserProfile(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmFilter.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.f48671a.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getUserProfile(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onFiltered(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmFilter.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f48671a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFiltered(str, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDtmFilter.DESCRIPTOR);
        }

        public static IDtmFilter asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDtmFilter.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDtmFilter)) ? new Proxy(iBinder) : (IDtmFilter) queryLocalInterface;
        }

        public static IDtmFilter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDtmFilter iDtmFilter) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDtmFilter == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDtmFilter;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1598968902) {
                parcel2.writeString(IDtmFilter.DESCRIPTOR);
                return true;
            } else if (i11 == 1) {
                parcel.enforceInterface(IDtmFilter.DESCRIPTOR);
                onFiltered(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i11 != 2) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface(IDtmFilter.DESCRIPTOR);
                String userProfile = getUserProfile(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(userProfile);
                return true;
            }
        }
    }

    String getUserProfile(String str) throws RemoteException;

    void onFiltered(String str, Bundle bundle) throws RemoteException;
}
