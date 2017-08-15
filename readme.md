# JMH benchmark for String match

This project benchmark String match performance with separate common implementations

* String - JDK String replacement
* KMP - [a KMP implementation](https://gist.github.com/shoenig/1430733/250b4184dc4a2dd31aa136e2fbdded5f90489a64)
* KMP precompiled - use precompiled KMP instance for searching 
* Aho-Corasick - [A Aho-Corasick implementation](https://github.com/robert-bor/aho-corasick)

The project measures String matching in several use cases:

* Short text - find `algorithm` in `BMH algorithm is the fast and easy to implement`
* Long text - find `encountered` in [this file content](https://github.com/greenlaw110/Benchmark4StringReplace/blob/master/src/main/resources/long_str.txt) to `appearance`

Benchmark result

| test scenario | short text | long text |
| :---         |  ---: | ---: |
| String | `*78,763.767/ms` | `*4,093.381/ms` | 
| KMP | `19,118.220/ms` | `329.124/ms` | 
| KMP - precompiled | `29,489.667/ms` | `426.696/ms` |
| Aho-Corasick | `7824.821/ms` | `197.690/ms` |
| Horspool | `20,589.804/ms` | `2,281.852/ms` |
| ShiftOr | `18718.990/ms` | `765.880/ms` |
| BOM | `10772.581/ms` | `1270.413/ms`

## Run the project

```
mvn clean package
```

```
java -jar target/benchmarks.jar  StringSearchBenchmark -wi 3 -i 6 -f 1 -tu ms
```

```
Benchmark                                  Mode  Cnt      Score      Error   Units
StringSearchBenchmark.ahoCorasick         thrpt    6   7824.821 ±  180.215  ops/ms
StringSearchBenchmark.ahoCorasickLong     thrpt    6    197.690 ±   11.022  ops/ms
StringSearchBenchmark.kmp                 thrpt    6  19118.220 ± 1425.688  ops/ms
StringSearchBenchmark.kmpLong             thrpt    6    329.124 ±   12.258  ops/ms
StringSearchBenchmark.kmpPrecompiled      thrpt    6  29489.667 ± 9573.152  ops/ms
StringSearchBenchmark.kmpPrecompiledLong  thrpt    6    426.696 ±   12.585  ops/ms
StringSearchBenchmark.string              thrpt    6  78763.767 ± 1797.206  ops/ms
StringSearchBenchmark.stringLong          thrpt    6   4093.381 ±  194.671  ops/ms
```

```
java -jar target/benchmarks.jar  HorspoolBenchmark -wi 3 -i 6 -f 1 -tu ms
```

```
Benchmark                        Mode  Cnt      Score     Error   Units
HorspoolBenchmark.horspool      thrpt    6  20589.804 ± 187.774  ops/ms
HorspoolBenchmark.horspoolLong  thrpt    6   2281.852 ±  35.489  ops/ms
```

```
java -jar target/benchmarks.jar  ShiftOrBenchmark -wi 3 -i 6 -f 1 -tu ms
```

```
Benchmark                      Mode  Cnt      Score     Error   Units
ShiftOrBenchmark.shiftOr      thrpt    6  18718.990 ± 397.213  ops/ms
ShiftOrBenchmark.shiftOrLong  thrpt    6    765.880 ±  10.747  ops/ms
```

```shell
java -jar target/benchmarks.jar  BOMBenchmark -wi 3 -i 6 -f 1 -tu ms
```

```
Benchmark              Mode  Cnt      Score    Error   Units
BOMBenchmark.bom      thrpt    6  10772.581 ± 92.371  ops/ms
BOMBenchmark.bomLong  thrpt    6   1270.413 ± 27.856  ops/ms
```

## References

* http://openjdk.java.net/projects/code-tools/jmh
* http://java-performance.info/jmh/
* http://java-performance.info/introduction-jmh-profilers/
* http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/
* https://github.com/greenlaw110/Benchmark4StringReplace/blob/master/src/main/java/sample/StringReplaceBenchmark.java