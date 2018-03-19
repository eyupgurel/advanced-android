package com.alienstar.cyrus.advancedandroid.trending;

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
public abstract class TrendingReposScreenModule {
    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindUIManager(TrendingReposUIManager UIManager);

    @Binds
    @IntoMap
    @RenderKey("Repo")
    abstract ItemRenderer<? extends RecyclerItem> bindRepoRenderer(RepoRenderer repoRenderer);

    @Provides
    @ScreenScope
    static RecyclerDataSource provideRecyclerDataSource(Map<String, ItemRenderer<? extends RecyclerItem>> renderers) {
        return new RecyclerDataSource(renderers);
    }
}
