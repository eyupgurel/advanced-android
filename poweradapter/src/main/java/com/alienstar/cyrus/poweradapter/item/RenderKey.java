package com.alienstar.cyrus.poweradapter.item;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * Created by cyrus on 3/18/18.
 */
@MapKey
@Target(ElementType.METHOD)
public @interface RenderKey {
    String value();
}
