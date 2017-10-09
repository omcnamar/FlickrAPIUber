package com.olegsagenadatrytwo.flickrapiuber.injection.mainactivity;

import com.olegsagenadatrytwo.flickrapiuber.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omcna on 10/9/2017.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
