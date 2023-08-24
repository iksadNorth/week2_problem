package question_second;

public class Main {
    /**
     * 단순히 적절히 공백과 별표를 조합해서
     * print하면 되는 문제로 파악했습니다.
     *
     * 고려해야 했던 유의점은
     * 1. 층 하나를 출력하는 함수를 만들어야 하는 것.
     * 2. 별 갯수가 감소할 때, 종료조건이 무엇인지
     * 3. 별 갯수가 다시 증가할 때, 종료조건이 무엇인지
     * 였습니다.
     */
    public void solution(int star) {
        // StringBuilder로 answer 변수 선언
        StringBuilder sb = new StringBuilder();

        // 1층에 공백:0개, 별표:i개
        // 2층에 공백:1개, 별표:i-2개
        // ...
        // n층에 공백:n개, 별표:i-2n개
        // ...
        // x층에 공백:y개, 별표:1개
        // ...
        // 마지막층에 공백:0개, 별표:i개

        int n=0;
        while(star-2*n>=1) {
            addFloor(sb, star, n++);
        }

        n -= 2;
        while(n>=0) {
            addFloor(sb, star, n--);
        }

        // 정답 출력
        System.out.println(sb);
    }

    // n층에 공백:n개, 별표:i-2n개
    static void addFloor(StringBuilder sb, int i, int n) {
        String blanks = " ".repeat(n);
        String stars = "*".repeat(i - 2*n);

        sb.append(blanks);
        sb.append(stars);
        sb.append("\n");
    }

    public static void main(String[] args) {
        Main method = new Main();
        int star = 7;
        method.solution(star);
    }
}