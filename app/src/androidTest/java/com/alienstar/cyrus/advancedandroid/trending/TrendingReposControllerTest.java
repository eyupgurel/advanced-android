package com.alienstar.cyrus.advancedandroid.trending;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.data.TestRepoService;
import com.alienstar.cyrus.advancedandroid.test.ControllerTest;
import com.bluelinelabs.conductor.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by cyrus on 3/10/18.
 */
@RunWith(AndroidJUnit4.class)
public class TrendingReposControllerTest extends ControllerTest {

    @Test
    public void loadRepos() {
        repoService.clearErrorFlags();
        launch();

        onView(withId(R.id.loading_indicator)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.tv_error)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.repo_list)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(allOf(withId(R.id.tv_repo_name), withText("RxJava"))).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

    }
    @Test
    public void loadReposError(){
        repoService.setErrorFlags(TestRepoService.FLAG_TRENDING_REPOS);
        launch();
        onView(withId(R.id.loading_indicator)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.repo_list)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

        onView(withId(R.id.tv_error)).check(matches(allOf(withText(R.string.api_error_repos), withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))));

    }

    @Override
    protected Controller controllerToLaunch() {
        return new TrendingReposController();
    }
}
