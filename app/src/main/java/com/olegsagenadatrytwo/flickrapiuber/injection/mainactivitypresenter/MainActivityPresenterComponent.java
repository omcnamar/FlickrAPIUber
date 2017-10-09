package com.olegsagenadatrytwo.flickrapiuber.injection.mainactivitypresenter;

import com.olegsagenadatrytwo.flickrapiuber.view.mainactivity.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainActivityPresenterModule.class} )
public interface MainActivityPresenterComponent {

    void insert(MainActivityPresenter mainActivityPresenter);
}