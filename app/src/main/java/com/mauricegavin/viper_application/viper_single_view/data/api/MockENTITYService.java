package com.mauricegavin.viper_application.viper_single_view.data.api;

import android.support.annotation.NonNull;

import com.mauricegavin.viper_application.viper_single_view.data.entities.ENTITY;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.Path;
import rx.Observable;
import timber.log.Timber;

/**
 * Mocked API Endpoint for submitting VIPER.
 * API Documentation:
 */
public class MockENTITYService implements ENTITYService {

    private static final int DELAY = 1000;

    public MockENTITYService() {
    }

    @Override
    public Observable<List<ENTITY>> getENTITYs() {
        return null;
    }

    @Override
    public Observable<ENTITY> updateDefaultENTITY(@Path("id") String id, @Field("param1") String param1) {
        return null;
    }

    @Override
    @SuppressWarnings("FeatureEnvy")
    public Observable<ENTITY> createENTITY(String paymentId) {
        simulateNetworkDelay(DELAY);

        return createENTITYSucceeded(paymentId);
        //return createENTITYPending(paymentId);
        //return createENTITYFailed(paymentId);
    }

    // Use these methods for testing different states
    @SuppressWarnings("FeatureEnvy")
    public Observable<ENTITY> createENTITYSucceeded(String paymentId) {
        ENTITY ENTITY = createMockedENTITY(paymentId);
        return Observable.just(ENTITY);
    }

    @SuppressWarnings("FeatureEnvy")
    public Observable<ENTITY> createENTITYPending(String paymentId) {
        ENTITY ENTITY = createMockedENTITY(paymentId);
        return Observable.just(ENTITY);
    }

    @SuppressWarnings("FeatureEnvy")
    public Observable<ENTITY> createENTITYFailed(String paymentId) {
        ENTITY ENTITY = createMockedENTITY(paymentId);
        return Observable.just(ENTITY);
    }

    @NonNull
    private ENTITY createMockedENTITY(String paymentId) {
        ENTITY ENTITY = new ENTITY();
        return ENTITY;
    }

    private void simulateNetworkDelay(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Timber.e(e, "Sleep interrupted");
        }
    }
}
