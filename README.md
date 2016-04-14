# hazelcast map benchmarking

this code creates two maps (one indexed and another non-indexed) and populated them with 1M records, and then benchmark them for 30 secs


Output
[2016-04-14 12:03:43][INFO ][main][App] - inserting into non-indexedDataMap
[2016-04-14 12:04:02][INFO ][main][TestUtil] - map populated with: 1000000 recs in: 18600 ms
[2016-04-14 12:04:02][INFO ][main][App] - inserting into indexedDataMap
[2016-04-14 12:04:38][INFO ][main][TestUtil] - map populated with: 1000000 recs in: 35460 ms
[2016-04-14 12:04:38][INFO ][main][App] - benchmarking predicate search on non-indexed collection
[2016-04-14 12:05:10][INFO ][main][App] - performed: 4 searches in: 30 secs
[2016-04-14 12:05:10][INFO ][main][App] - benchmarking predicate search on indexed collection
[2016-04-14 12:05:40][INFO ][main][App] - performed: 148715 searches in: 30 secs
[2016-04-14 12:05:40][INFO ][main][App] - benchmarking sql search on non-indexed collection
[2016-04-14 12:06:12][INFO ][main][App] - performed: 4 searches in: 30 secs
[2016-04-14 12:06:12][INFO ][main][App] - benchmarking sql search on indexed collection
[2016-04-14 12:06:42][INFO ][main][App] - performed: 186199 searches in: 30 secs
[2016-04-14 12:06:42][INFO ][main][App] - benchmarking sql search on indexed collection with where clause having both, indexed and non-indexed column
[2016-04-14 12:07:12][INFO ][main][App] - performed: 33325 searches in: 30 secs
