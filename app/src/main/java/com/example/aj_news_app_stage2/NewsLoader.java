package com.example.aj_news_app_stage2;
/**created and written by AJ Warner for Udacity Nano Degree on 2/28/19*/
import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


public class NewsLoader extends AsyncTaskLoader<List<News>> {

    // private static String REQUEST_URL ="http://content.guardianapis.com/search?q=debates&api-key=test";
    String mURL ;

    public NewsLoader(Context context, String url) {
        super(context);
        this.mURL = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mURL == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchNewsData(mURL);
        return newsList;
    }
}