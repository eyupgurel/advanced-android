package com.alienstar.cyrus.advancedandroid.details;

import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

/**
 * Created by cyrus on 3/11/18.
 */
@AutoValue
abstract class ContributorState {

    abstract  boolean loading();

    @Nullable
    abstract Integer errorRes();

    boolean isSuccess() {
        return errorRes() == null;
    }

    static Builder builder(){
        return new AutoValue_ContributorState.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder loading(boolean loading);

        abstract Builder errorRes(Integer errorRes);

        abstract ContributorState build();
    }
}
