package com.mauricegavin.viper_application.common.domain;

import rx.Observable;

/**
 * Created by maurice on 22/10/2016.
 */
public interface Config {
    Observable<Config> prepare();
    String getApiKey();
    String getGitSha();
}