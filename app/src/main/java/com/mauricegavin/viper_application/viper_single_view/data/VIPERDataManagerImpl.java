package com.mauricegavin.viper_application.viper_single_view.data;

import com.mauricegavin.viper_application.common.data.local.ResourceProxy;
import com.mauricegavin.viper_application.viper_single_view.domain.VIPERItem;

import rx.Observable;

/**
 * Created by maurice on 24/08/2016.
 */
public class VIPERDataManagerImpl implements VIPERDataManager {

    private final ResourceProxy resourceProxy;
    private final ENTITYManager entityManager;

    public VIPERDataManagerImpl(ResourceProxy resourceProxy, ENTITYManager ENTITYManager) {
        this.resourceProxy = resourceProxy;
        entityManager = ENTITYManager;
    }

    // VIPERDataManager Implementation

    @Override
    public Observable<VIPERItem> getVIPERItem(String paymentId) {
        return null;
        /*paymentManager.getPayment(paymentId)
                .map(transformPaymentToVIPERItem());*/
    }

    /*@NonNull
    private Func1<Payment, VIPERItem> transformPaymentToVIPERItem() {
        return payment -> new VIPERItem(payment.getId(), payment.getPrice());
    }

    @Override
    public Observable<VIPERItem> VIPERCustomer(VIPERItem VIPERItem) {
        return VIPERManager.createVIPER(VIPERItem.getPaymentId())
                .map(transformVIPERToVIPERItem());
    }

    @NonNull
    private Func1<VIPER, VIPERItem> transformVIPERToVIPERItem() {
        return VIPER -> new VIPERItem(
                VIPER.getPaymentId(),
                VIPERStatus.valueFor(VIPER.getStatus()));
    }

    @Override
    public Observable<Source> updateDefaultSource(String sourceId) {
        return sourceManager.setPrimarySource(sourceId)
                .doOnError(e -> Timber.e(e, "Failed to set default source to be %s.", sourceId));
    }*/
}
