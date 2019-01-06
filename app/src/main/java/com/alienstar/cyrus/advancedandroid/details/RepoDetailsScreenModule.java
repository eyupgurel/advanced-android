package com.alienstar.cyrus.advancedandroid.details;

import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.lifecycle.ScreenLifecycleTask;
import com.alienstar.cyrus.poweradapter.adapter.RecyclerDataSource;
import com.alienstar.cyrus.poweradapter.item.ItemRenderer;
import com.alienstar.cyrus.poweradapter.item.RecyclerItem;
import com.alienstar.cyrus.poweradapter.item.RenderKey;

import java.util.Map;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;

/**
 * Created by cyrus on 3/17/18.
 */
@Module
public abstract class RepoDetailsScreenModule {
    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindUIManagerTask(RepoDetailsUIManager UIManager);

    @Binds
    @IntoMap
    @RenderKey("Contributor")
    abstract ItemRenderer<? extends RecyclerItem> bindContributorRenderer(ContributorRenderer contributorRenderer);

    @Provides
    @ScreenScope
    static RecyclerDataSource provideDataSource(Map<String, ItemRenderer<? extends RecyclerItem>> renderers) {
        return new RecyclerDataSource(renderers);
    }

}
