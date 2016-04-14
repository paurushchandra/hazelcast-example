package com.example;

import com.example.model.Data;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by user on 14/4/16.
 */
public class TestUtil {

    public static final char[] ALPHA = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};
    private static final Logger LOGGER = Logger.getLogger(TestUtil.class);

    public static List<Data> generateTestData(int size) {
        Random r = new Random();
        List<Data> testData = new ArrayList<Data>(size);
        for (int i = 0; i < size; i++) {
            String assetId = new String(new char[]{ALPHA[r.nextInt(25)], ALPHA[r.nextInt(25)]});
            testData.add(new Data(assetId, Math.random()));
        }
        return testData;
    }

    public static void populateTestData(Map<String, Data> map, List<Data> testDataList) {
        long startTime = System.currentTimeMillis();
        int i = 0;
        for (Data data: testDataList) {
            map.put("" + i, data);
            i++;
        }
        long totalTime = System.currentTimeMillis() - startTime;
        LOGGER.info(String.format("map populated with: %d recs in: %d ms", map.size(), totalTime));
    }

}
