package proj;

public class Algorithms {
    public static void main(String[] args) {
        int[] mas = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        printMas(mas);
        bubbleSort(mas);
        printMas(mas);
        resetMas(mas);
        System.out.println();

        printMas(mas);
        insertionSort(mas);
        printMas(mas);
        resetMas(mas);
        System.out.println();

        bubbleSort(mas);
        int el = 3;
        int ind = binarySearch(mas, el);
        System.out.println("index of " + el + " = " + ind);

        int n = 3;
        System.out.println("fact " + n + " = " + fact(n));
        System.out.println();

        int t = 15;
        for (int i = 1; i <= t; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();

        char[] str = { 'a', 'b', 'c', 'd', 'e' };
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }

        System.out.print("\n");
        rev(str);
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }

        System.out.print("\n");

        resetMas(mas);
        printMas(mas);
        mergeSort(mas, 0, mas.length - 1);
        printMas(mas);

        System.out.print("\n");
        resetMas(mas);
        printMas(mas);
        quickSort(mas, 0, mas.length - 1);
        printMas(mas);
    }

    public static void printMas(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }

        System.out.print("\n");
    }

    public static void resetMas(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = mas.length - i;
        }
    }

    /******************************************************************************************************************/

    public static void bubbleSort(int[] mas) {
        // for (int i = 0; i < mas.length; i++) {
        // for (int j = mas.length - 1; j > i; j--) {
        // if (mas[j - 1] > mas[j]) {
        // int temp = mas[j - 1];
        // mas[j - 1] = mas[j];
        // mas[j] = temp;
        // }
        // }
        // }

        for (int i = mas.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mas[j] > mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }
    }

    /******************************************************************************************************************/

    public static void quickSort(int[] mas, int low, int high) {
        int i = low;
        int j = high;
        int x = mas[(low + high) / 2];

        do {
            while (mas[i] < x) {
                i++;
            }

            while (mas[j] > x) {
                j--;
            }

            if (i <= j) {
                int temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (low < j) {
            quickSort(mas, low, j);
        }

        if (i < high) {
            quickSort(mas, i, high);
        }
    }

    /******************************************************************************************************************/

    public static void mergeSort(int[] mas, int lb, int ub) {
        int split;

        if (lb < ub) {
            split = (lb + ub) / 2;

            mergeSort(mas, lb, split);
            mergeSort(mas, split + 1, ub);
            merge(mas, lb, split, ub);
        }
    }

    public static void merge(int[] mas, int lb, int split, int ub) {
        int pos1 = lb;
        int pos2 = split + 1;
        int pos3 = 0;

        int[] temp = new int[ub - lb + 1];

        while (pos1 <= split && pos2 <= ub) {
            if (mas[pos1] < mas[pos2]) {
                temp[pos3] = mas[pos1];
                pos1++;
                pos3++;
            } else {
                temp[pos3] = mas[pos2];
                pos2++;
                pos3++;
            }
        }

        while (pos1 <= split) {
            temp[pos3] = mas[pos1];
            pos1++;
            pos3++;
        }

        while (pos2 <= ub) {
            temp[pos3] = mas[pos2];
            pos2++;
            pos3++;
        }

        for (int i = 0; i < ub - lb + 1; i++) {
            mas[lb + i] = temp[i];
        }
    }

    /******************************************************************************************************************/

    public static void insertionSort(int[] mas) {
        // for (int i = 1; i < mas.length; i++) {
        //     int temp = mas[i];

        //     for (int j = i - 1; j >= 0; j--) {
        //         if (mas[j] < temp) {
        //             break;
        //         }

        //         mas[j + 1] = mas[j];
        //         mas[j] = temp;
        //     }
        // }

        for (int i = 1; i < mas.length; i++) {
            int j = i;

            while (j > 0 && mas[j] < mas[j - 1]) {
                int temp = mas[j];
                mas[j] = mas[j - 1];
                mas[j - 1] = temp;
                j--;
            }
        }
    }

    /******************************************************************************************************************/

    public static int binarySearch(int[] mas, int el) {
        int lo = 0;
        int hi = mas.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (el < mas[mid]) {
                hi = mid - 1;
            } else if (el > mas[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /******************************************************************************************************************/

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    /******************************************************************************************************************/

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /******************************************************************************************************************/

    public static void rev(char[] mas) {
        for (int i = 0; i < mas.length / 2; i++) {
            char temp;
            temp = mas[i];
            mas[i] = mas[mas.length - 1 - i];
            mas[mas.length - 1 - i] = temp;
        }
    }
}
