package com.olegsagenadatrytwo.flickrapiuber.view.mainactivity;

import com.olegsagenadatrytwo.flickrapiuber.entities.Flicker;
import com.olegsagenadatrytwo.flickrapiuber.injection.mainactivitypresenter.DaggerMainActivityPresenterComponent;
import com.olegsagenadatrytwo.flickrapiuber.injection.mainactivitypresenter.MainActivityPresenterModule;
import com.olegsagenadatrytwo.flickrapiuber.model.remote.IRemote;
import com.olegsagenadatrytwo.flickrapiuber.model.remote.Remote;

import javax.inject.Inject;

/**
 * Created by omcna on 10/9/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter, IRemote {

    private MainActivityContract.View view;
    @Inject
    Remote remote;

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getImages(String query) {
        remote.makeRestCallForImages(query);
    }

    @Override
    public void attachRemote(){
        DaggerMainActivityPresenterComponent
                .builder()
                .mainActivityPresenterModule(new MainActivityPresenterModule(this))
                .build()
                .insert(this);
    }

    @Override
    public void sendData(final Flicker data) {
        ((MainActivity)view).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.updateUI(data);
            }
        });
    }
}
