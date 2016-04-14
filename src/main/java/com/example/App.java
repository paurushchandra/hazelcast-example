package com.example;

import com.example.model.Data;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicates;
import com.hazelcast.query.SqlPredicate;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.example.TestUtil.generateTestData;
import static com.example.TestUtil.populateTestData;
import static com.example.TestUtil.ALPHA;

/**
 * Hello world!
 */
public class App {

    public static final Logger LOGGER = Logger.getLogger(App.class);
    private static final int BENCHMARK_INTERVAL = 30;
    private static final int TEST_DATA_SIZE = 1000000;


    public static void main(String[] args) {

        LOGGER.info("starting application");
        ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
        List<Data> testData = generateTestData(TEST_DATA_SIZE);

        IMap<String, Data> dataMap = context.getBean("dataMap", IMap.class);
        LOGGER.info("inserting into non-indexedDataMap");
        populateTestData(dataMap, testData);

        IMap<String, Data> indexedDataMap = context.getBean("indexedDataMap", IMap.class);
        LOGGER.info("inserting into indexedDataMap");
        populateTestData(indexedDataMap, testData);

        LOGGER.info("benchmarking predicate search on non-indexed collection");
        benchMarkPredicateSearch(dataMap);

        LOGGER.info("benchmarking predicate search on indexed collection");
        benchMarkPredicateSearch(indexedDataMap);

        LOGGER.info("benchmarking sql search on non-indexed collection");
        benchMarkSqlPredicateSearch(dataMap);

        LOGGER.info("benchmarking sql search on indexed collection");
        benchMarkSqlPredicateSearch(indexedDataMap);

        LOGGER.info("benchmarking sql search on indexed collection with where clause having both, indexed and non-indexed column");
        benchMarkSqlPrdWithNonIndexedCol(indexedDataMap);

//        CacheManager cacheManager = context.getBean(HazelcastCacheManager.class);
//        Cache cache = cacheManager.getCache("dataMap");
//        cache.get("AA");

        ((AbstractApplicationContext) context).close();
        LOGGER.info("end");

    }

    private static void benchMarkSqlPrdWithNonIndexedCol(IMap<String, Data> map) {
        int count = 0;
        Random r = new Random();
        long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(BENCHMARK_INTERVAL);
        while (System.currentTimeMillis() < endTime) {
            String assetId = new String(new char[]{ALPHA[r.nextInt(25)], ALPHA[r.nextInt(25)]});
            Collection<?> result = map.values(new SqlPredicate("assetId = '" + assetId + "' AND nav > 0.5"));
//            LOGGER.info(String.format("for assetId: %s matches found: %d", assetId, result.size()));
            count++;
        }
        LOGGER.info(String.format("performed: %d searches in: %d secs ", count, BENCHMARK_INTERVAL));
    }


    private static void benchMarkPredicateSearch(IMap<String, Data> map) {
        int count = 0;
        Random r = new Random();
        long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(BENCHMARK_INTERVAL);
        while (System.currentTimeMillis() < endTime) {
            String assetId = new String(new char[]{ALPHA[r.nextInt(25)], ALPHA[r.nextInt(25)]});
            Collection<?> result = map.values(Predicates.equal("assetId", assetId));
//            LOGGER.info(String.format("for assetId: %s matches found: %d", assetId, result.size()));
            count++;
        }
        LOGGER.info(String.format("performed: %d searches in: %d secs ", count, BENCHMARK_INTERVAL));
    }

    private static void benchMarkSqlPredicateSearch(IMap<String, Data> map) {
        int count = 0;
        Random r = new Random();
        long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(BENCHMARK_INTERVAL);
        while (System.currentTimeMillis() < endTime) {
            String assetId = new String(new char[]{ALPHA[r.nextInt(25)], ALPHA[r.nextInt(25)]});
            Collection<?> result = map.values(new SqlPredicate("assetId = '" + assetId + "'"));
//            LOGGER.info(String.format("for assetId: %s matches found: %d", assetId, result.size()));
            count++;
        }
        LOGGER.info(String.format("performed: %d searches in: %d secs ", count, BENCHMARK_INTERVAL));
    }

}
