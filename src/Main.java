public class Main {

    public static void main(String[] args) {
        final int INF = 10000000;

        int[][] a = {
                {0, 5, INF, 8},
                {7, 0, 9, INF},
                {2, INF, 0, 4},
                {INF, INF, 3, 0}
        };

        new FloydWarshall(4).start(a);
    }
}

class FloydWarshall {
    private int num;

    FloydWarshall(int num) {
        this.num = num;
    }

    void start(int[][] a) {
        // 결과 그래프를 초기화 합니다.
        int[][] d = new int[num][num];

        // 결과 그래프를 초기화 합니다.
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                d[i][j] = a[i][j];
            }
        }

        // k = 거쳐가는 노드
        for (int k = 0; k < num; k++) {
            // i = 출발 노드
            for (int i = 0; i < num; i++) {
                // j = 도착 노드
                for (int j = 0; j < num; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        // 결과를 출력 합니다.
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%3d", d[i][j]);
            }
            System.out.println();
        }
    }
}
