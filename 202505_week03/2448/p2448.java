import java.io.*;

public class p2448 {
    static char[][] arr;
    public static void recursive() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n*2-1];


        //                       *
        //                      * *
        //                     *****
        //                    *     *
        //                   * *   * *
        //                  ***** *****
        //                 *           *
        //                * *         * *
        //               *****       *****
        //              *     *     *     *
        //             * *   * *   * *   * *
        //            ***** ***** ***** *****
        //           *                       *
        //          * *                     * *
        //         *****                   *****
        //        *     *                 *     *
        //       * *   * *               * *   * *
        //      ***** *****             ***** *****
        //     *           *           *           *
        //    * *         * *         * *         * *
        //   *****       *****       *****       *****
        //  *     *     *     *     *     *     *     *
        // * *   * *   * *   * *   * *   * *   * *   * *
        //***** ***** ***** ***** ***** ***** ***** *****
    }
}
