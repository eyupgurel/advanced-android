package com.alienstar.cyrus.advancedandroid.details;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.data.TestRepoService;
import com.alienstar.cyrus.advancedandroid.test.ControllerTest;
import com.bluelinelabs.conductor.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

/**
 * Created by cyrus on 3/15/18.
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class RepoDetailsControllerTest extends ControllerTest {

    @Before
    public void setUp() {
        testRule.clearState();

    }

    @Test
    public void repoDetailsSuccess(){
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyName("RxJava")
                .verifyDescription("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.")
                .verifyCreatedDate("Jan 08, 2013")
                .verifyUpdatedDate("Mar 09, 2018");
    }

    @Test
    public void repoDetailsError() {
        repoService.setErrorFlags(TestRepoService.FLAG_GET_REPO);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContentVisibility(ViewMatchers.Visibility.GONE)
                .verifyErrorText(R.string.api_error_single_repo);

    }

    @Test
    public void contributorsSuccess() {
        launch();
        RepoDetailsRobot.init()
                .verifyContributorsLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorShown("benjchristensen");

    }

    @Test
    public void contributorsError() {
        repoService.setErrorFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init()
                .verifyContributorsLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorVisibility(ViewMatchers.Visibility.VISIBLE)
                .verifyContributorsErrorText(R.string.api_error_contributors);
    }

    @Test
    public void repoSuccessContributorsError() {
        repoService.setErrorFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyErrorVisibility(ViewMatchers.Visibility.GONE)
                .verifyName("RxJava")
                .verifyDescription("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.")
                .verifyCreatedDate("Jan 08, 2013")
                .verifyUpdatedDate("Mar 09, 2018")
                .verifyContributorsLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorVisibility(ViewMatchers.Visibility.VISIBLE)
                .verifyContributorsErrorText(R.string.api_error_contributors);
    }

    @Test
    public void loadingRepo(){
        repoService.setHoldFlags(TestRepoService.FLAG_GET_REPO);
        launch();
        RepoDetailsRobot.init().verifyLoadingVisibility(ViewMatchers.Visibility.VISIBLE)
                .verifyErrorVisibility(ViewMatchers.Visibility.GONE);
    }

    @Test
    public void loadingContributors(){
        repoService.setHoldFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init().verifyContributorsLoadingVisibility(ViewMatchers.Visibility.VISIBLE)
                               .verifyContributorsErrorVisibility(ViewMatchers.Visibility.GONE);
    }

    @Override
    protected Controller controllerToLaunch() {
        return RepoDetailsController.newInstance("ReactiveX", "RxJava");
    }
}
