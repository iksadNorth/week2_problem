package question_third;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    /**
     * 우선 중복된 단어를 모두 찾고 중복된 단어를 다시 찾아 제거해야 했던 문제.
     * 때문에 각 단어의 갯수를 셈하기 위해 HashMap을 이용했습니다.
     * key값에는 영단어가, value값에는 출현 횟수를 기입했습니다.
     *
     * 풀이 순서는 다음과 같습니다.
     * 1. HashMap에 단어 출현 횟수를 기입합니다.
     * 2. arr를 stream으로 형변환하고 HashMap의 value값이 1인 요소로 필터링합니다.
     * 3. arr stream을 다시 인덱스 n을 기준으로 정렬합니다.
     * 4. arr stream을 배열로 형변환해줍니다.
     */
    public String[] solution(String[] arr, int n) {
        // 첫번째 arr 순회 시, HashMap에 해당 단어의 빈도를 계산.
        HashMap<String, Integer> table = new HashMap<>();
        for (String item : arr) {
            Integer frequency = table.getOrDefault(item, 0);
            table.put(item, frequency+1);
        }

        // Comparator를 이용해서 정렬함.
        // n번째 글자로 오름차순 정렬.
        // 만약 동일하다면 사전순으로 앞선 문자열이 앞쪽.
        Comparator<String> comparator = Comparator.comparing(o -> o.charAt(n));
        comparator = comparator.thenComparing(String::toString);

        // 두번째 arr 순회 시, stream으로 만들고 value값이 1인 요소만 필터링.
        // stream sort를 이용해서 인덱스 1의 문자를 기준으로 정렬.
        return Arrays.stream(arr)
                .filter(i -> table.get(i) == 1)
                .sorted(comparator)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        Main method = new Main();
        String[] arr = {"coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"};
        int n = 2;
        System.out.println(Arrays.toString(method.solution(arr, n)));
    }
}