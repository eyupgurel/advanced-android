package com.alienstar.cyrus.poweradapter.adapter;



import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alienstar.cyrus.poweradapter.item.ItemRenderer;
import com.alienstar.cyrus.poweradapter.item.RecyclerItem;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by cyrus on 3/18/18.
 */
public class RecyclerDataSourceTest {
    private final ItemRenderer<? extends RecyclerItem> rendererOne = new TestRenderer(1);
    private final ItemRenderer<? extends RecyclerItem> rendererTwo = new TestRenderer(2);
    private final TestItem itemOne = new TestItem(1, "r1");
    private final TestItem itemTwo = new TestItem(2, "r1");
    private final TestItem itemThree = new TestItem(3, "r2");

    private RecyclerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        List<RecyclerItem> items = Arrays.<RecyclerItem>asList(itemOne, itemTwo, itemThree);
        Map<String, ItemRenderer<? extends RecyclerItem>> renderers = new HashMap<>();
        renderers.put("r1", rendererOne);
        renderers.put("r2", rendererTwo);
        dataSource = new RecyclerDataSource(renderers);
        dataSource.seedData(items);
    }

    @Test
    public void rendererForType() throws Exception {
        assertEquals(rendererOne, dataSource.rendererForType(rendererOne.layoutRes()));
        assertEquals(rendererTwo, dataSource.rendererForType(rendererTwo.layoutRes()));
    }

    @Test
    public void viewResourceForPosition() throws Exception {
        assertEquals(rendererOne.layoutRes(), 1);
        assertEquals(rendererTwo.layoutRes(), 2);
    }

    @Test
    public void getCount() throws Exception {
        assertEquals(3, dataSource.getCount());
    }

    @Test
    public void getItem() throws Exception {
        assertEquals(itemOne, dataSource.getItem(0));
        assertEquals(itemThree, dataSource.getItem(2));

    }

    static class TestItem implements RecyclerItem {

        private final long id;
        private final String key;

        TestItem(long id, String key) {
            this.id = id;
            this.key = key;
        }

        @Override
        public long getId() {
            return id;
        }

        @Override
        public String renderKey() {
            return key;
        }
    }

    static class TestRenderer implements ItemRenderer<RecyclerItem> {
        private final int layoutRes;

        TestRenderer(int layoutRes) {
            this.layoutRes = layoutRes;
        }

        @Override
        public int layoutRes() {
            return layoutRes;
        }

        @Override
        public View createView(@NonNull ViewGroup parent) {
            return null;
        }

        @Override
        public void render(@NonNull View itemView, @NonNull RecyclerItem item) {

        }
    }

}