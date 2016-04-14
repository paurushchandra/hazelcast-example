# hazelcast map benchmarking


Output
[2016-04-14 11:11:20][INFO ][main][App] - inserting into non-indexedDataMap
[2016-04-14 11:11:21][INFO ][main][TestUtil] - map populated with: 1000 recs in: 208 ms
[2016-04-14 11:11:21][INFO ][main][App] - inserting into indexedDataMap
[2016-04-14 11:11:21][INFO ][main][TestUtil] - map populated with: 1000 recs in: 249 ms
[2016-04-14 11:11:21][INFO ][main][App] - benchmarking predicate search on non-indexed collection
[2016-04-14 11:11:23][INFO ][main][App] - performed: 128 searches in: 2 secs
[2016-04-14 11:11:23][INFO ][main][App] - benchmarking predicate search on indexed collection
[2016-04-14 11:11:25][INFO ][main][App] - performed: 115415 searches in: 2 secs
[2016-04-14 11:11:25][INFO ][main][App] - benchmarking sql search on non-indexed collection
[2016-04-14 11:11:27][INFO ][main][App] - performed: 210 searches in: 2 secs
[2016-04-14 11:11:27][INFO ][main][App] - benchmarking sql search on indexed collection
[2016-04-14 11:11:29][INFO ][main][App] - performed: 109876 searches in: 2 secs
[2016-04-14 11:11:29][INFO ][main][App] - benchmarking sql search on indexed collection with where clause having both, indexed and non-indexed column
[2016-04-14 11:11:31][INFO ][main][App] - performed: 76901 searches in: 2 secs

