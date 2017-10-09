package com.olegsagenadatrytwo.flickrapiuber.injection.mainactivity;

import com.olegsagenadatrytwo.flickrapiuber.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by omcna on 10/9/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void insert(MainActivity mainActivity);
}
