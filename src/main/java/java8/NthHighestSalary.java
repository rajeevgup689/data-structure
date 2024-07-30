package java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary {
    public static void main(String[] args) {
        Map<String, Integer> empMap = new HashMap<>();
        empMap.put("Rajeev1", 1000);
        empMap.put("Rajeev2", 500);
        empMap.put("Rajeev3", 10000);
        empMap.put("Rajeev4", 2000);
        empMap.put("Rajeev5", 100);
        empMap.put("Rajeev6", 2000);

        Map<Integer, List<String>> groupByValueKeyList = empMap.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(groupByValueKeyList);

        List<Map.Entry<Integer, List<String>>> collect = groupByValueKeyList.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(collect.get(1)); // 2nd highest salary
        System.out.println(collect.get(groupByValueKeyList.size() - 1)); // 1st highest salary
    }
}