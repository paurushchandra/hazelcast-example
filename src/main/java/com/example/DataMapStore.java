package com.example;

import com.example.model.Data;
import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/4/16.
 */
public class DataMapStore implements MapStore<String, Data> {

    public static final Logger LOGGER = Logger.getLogger(DataMapStore.class);
    private static char[] ALPHA = new char[]{'A','B','C','D','E','F','G','H','I','J'};
    private static final int I = 100000;
    private Map<String, Data> map = new HashMap<String, Data>(I);


    public Data load(String key) {
//        LOGGER.info("loading for key " + key);
        return map.get(key);
    }

    public Map<String, Data> loadAll(Collection<String> keys) {
        LOGGER.info("loading all");
        map.clear();
        for(int i = 0; i<I; i++) {
            String assetId = new String(new char[]{ALPHA[(int) Math.random() * 10], ALPHA[(int) Math.random() * 10]});
            LOGGER.info("loaded assetId:" + assetId);
            map.put(assetId, new Data(assetId, Math.random()));
        }
        return map;
    }

    public Iterable<String> loadAllKeys() {
        return map.keySet();
    }

    public void store(String key, Data value) {

    }

    public void storeAll(Map<String, Data> map) {

    }

    public void delete(String key) {

    }

    public void deleteAll(Collection<String> keys) {

    }
}
