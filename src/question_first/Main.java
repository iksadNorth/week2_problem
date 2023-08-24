package question_first;

import java.util.Arrays;

public class Main {
    /**
     * 해당 문제는 단순히 행렬 덧셈이라고 파악했습니다.
     * 물론 signs라는 배열로 부호를 결정하는 것을 고려해야 하지만
     * 전체적으로는 행렬 덧셈이라고 여겼습니다.
     *
     * 때문에 먼저 정답을 담아낼 2차원 배열 answer를 만들고
     * 2중 for문으로 각 (i행 j열)의 요소를 더하고
     * 부호를 적절히 부여할 계획을 잡았습니다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2, boolean[][] signs) {
        // arr1의 Row, Col 수를 각각 numR, numC라고 지정.
        int numR = arr1.length, numC = arr1[0].length;

        // answer를 (numR X numC)인 2차원 배열로 생성.
        int[][] answer = new int[numR][numC];

        // answer를 2중 for문을 이용해서 순회하면서 덧셈을 수행.
        for (int i=0; i<numR; i++) {
            for (int j=0; j<numC; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
                answer[i][j] *= signs[i][j] ? 1 : -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        int[][] arr1 = {{5,7,1},{2,3,5}};
        int[][] arr2 = {{5,1,6},{7,5,6}};
        boolean[][] signs={{true,true,false},{false,true,false}};
        System.out.println(Arrays.deepToString(method.solution(arr1, arr2, signs)));
    }
}