package com.andikasoft.rwandacattle.rwandacattle;

import android.app.Application;
import android.content.Context;

public class ChangeLanguage extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
