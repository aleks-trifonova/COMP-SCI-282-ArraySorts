/* Aleksandra Trifonova
 *Computer Science 282
 * Monday Wednesday 2:00 pm - 3:15 pm
 * Professor Lorentz
 * Turned in December 5th
 * In this file different algorithms for insertion sort, quicksort, and heapsort are contained and tested on random
 * arrays as well as sets.
 */

import java.util.Random;
// use this class to contain everything related to your sorts

class ArraySorts {
    private static int[] a;
    private static int length;
    private static int lf;
    private static int rt;
    private static int pivot;
    private static int pivotRight;
    private static int pivotLeft;
    private static int begin;
    private static int index;
    private static int n;
    private static int cutoff;
    private static int start;
    private static int end;
// Some sample driver method headers

    public static void QuickSort1(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort1(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }
        public static void QuickSort1(){ // overloaded methods with default parameters
        QuickSort1(a,n,cutoff);
        }
    private static void QuickSort1(int[] a, int lf, int rt, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.cutoff = cutoff;
        while (rt - lf + 1 >= cutoff) {
            Random rand = new Random();
            int pivot;

            //this is to check for when the biggest value of nonspecific is 0
            if (lf == rt) {
                pivot = rt;
            } else {
                pivot = lf + rand.nextInt(rt - lf);
            }

            pivot = bookPartition(a, lf, rt, pivot);

            int leftPartitionSize = pivot - 1 - lf;
            int rightPartitionSize = rt - pivot + 1;

            if (leftPartitionSize < rightPartitionSize) {
                QuickSort1(a, lf, pivot - 1, cutoff);
                lf = pivot + 1;
            } else {
                QuickSort1(a, pivot + 1, rt, cutoff);
                rt = pivot - 1;
            }
        }
    }
    public static void QuickSort2(){ //overloaded methods with default parameters
        QuickSort2(a,n,cutoff);
    }

    public static void QuickSort2(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort2(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }

    private static void QuickSort2(int[] a, int lf, int rt, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.cutoff = cutoff;
        while (rt - lf + 1 >= cutoff) {
            int pivot;
            Random rand = new Random();

            //Required if-statement to avoid crash when ceiling for rand is 0
            if (lf == rt) {
                pivot = rt;
            } else {
                pivot = lf + rand.nextInt(rt - lf);
            }

            pair twoPivots = twoPivotPartition(a, lf, rt, pivot);

            int leftPartitionSize = twoPivots.left + 1 - lf;
            int rightPartSize = rt + 1 - twoPivots.right;

            if (leftPartitionSize < rightPartSize) {
                QuickSort2(a, lf, twoPivots.left, cutoff);
                lf = twoPivots.right;
            } else {
                QuickSort2(a, twoPivots.right, rt, cutoff);
                rt = twoPivots.left;
            }
        }
    }

    public static void QuickSort3(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort3(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }

    private static void QuickSort3(int[] a, int lf, int rt, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.cutoff = cutoff;
        while (rt - lf + 1 >= cutoff) {
            int pivot = lf;
            pivot = bookPartition(a, lf, rt, pivot);

            int leftPartSize = pivot - 1 - lf;
            int rightPartSize = rt - pivot + 1;

            if (leftPartSize < rightPartSize) {
                QuickSort3(a, lf, pivot - 1, cutoff);
                lf = pivot + 1;
            } else {
                QuickSort3(a, pivot + 1, rt, cutoff);
                rt = pivot - 1;
            }
        }
    }

    public static void QuickSort4(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort4(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }

    private static void QuickSort4(int[] a, int lf, int rt, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.cutoff = cutoff;
        while (rt - lf + 1 >= cutoff) {
            int pivot = lf;
            pivot = bookPartition(a, lf, rt, pivot);

            pair twoPivots = twoPivotPartition(a, lf, rt, pivot);

            int leftPartSize = twoPivots.left + 1 - lf;
            int rightPartSize = rt + 1 - twoPivots.right;

            if (leftPartSize < rightPartSize) {
                QuickSort4(a, lf, twoPivots.left, cutoff);
                lf = twoPivots.right;
            } else {
                QuickSort4(a, twoPivots.right, rt, cutoff);
                rt = twoPivots.left;
            }
        }
    }

    public static void QuickSort5(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort5(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }

    private static void QuickSort5() {//overloaded method with default parameters
        QuickSort5(a,lf ,rt ,cutoff );
    }

    private static void QuickSort5(int[] a, int lf, int rt, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.cutoff = cutoff;
        while (rt - lf + 1 >= cutoff) {
            int pivot1;
            int pivot2;
            Random rand = new Random();

            //Required if-statement to avoid crash when ceiling for rand is 0
            do {
                pivot1 = lf + rand.nextInt(rt - lf + 1);
                pivot2 = lf + rand.nextInt(rt - lf + 1);
            } while (pivot1 == pivot2);

            pair pivotPair = new pair(pivot1, pivot2);
            pivotPair = threePartition(a, lf, rt, pivot1, pivot2);

            int leftPartSize = pivotPair.left - lf;
            int midPartSize = pivotPair.right + 1 - pivotPair.left;
            int rightPartSize = rt - pivotPair.right;

            if (leftPartSize > rightPartSize && leftPartSize > midPartSize) {
                QuickSort5(a, pivotPair.left + 1, pivotPair.right - 1, cutoff);//Middle
                QuickSort5(a, pivotPair.right + 1, rt, cutoff);//Rightmost side
                rt = pivotPair.left - 1;
            } else if (midPartSize > rightPartSize && midPartSize > leftPartSize) {
                QuickSort5(a, lf, pivotPair.left - 1, cutoff);//Leftmost side
                QuickSort5(a, pivotPair.right + 1, rt, cutoff);//Rightmost side
                lf = pivotPair.left + 1;
                rt = pivotPair.right - 1;
            } else {
                QuickSort5(a, lf, pivotPair.left - 1, cutoff);//Leftmost side
                QuickSort5(a, pivotPair.left + 1, pivotPair.right - 1, cutoff);//Middle
                lf = pivotPair.right + 1;
            }
        }
    }

    public static void AlmostQS1() {//overloaded method with default parameters
        AlmostQS1(a, n, cutoff);
    }

    public static void AlmostQS1(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort1(a, 0, n - 1, cutoff);
    }

    public static void AlmostQS2() {//overloaded method with default parameters
        AlmostQS2(a,n ,cutoff );
    }

    public static void AlmostQS2(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort2(a, 0, n - 1, cutoff);
    }

    public static void AlmostQS5() { //overloaded method with default parameters
        AlmostQS5(a, n, cutoff);
    }

    public static void AlmostQS5(int[] a, int n, int cutoff) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        ArraySorts.cutoff = cutoff;
        QuickSort5(a, 0, n - 1, cutoff);
    }

    public static void insertionSort() {
        insertionSort(a,length);
    }

    public static void insertionSort(int[] a, int length) {
        ArraySorts.a = a; // Insertion Sort
        ArraySorts.length = length;
        for (int i = 1; i < length; i++) {
            int save = a[i];
            int j = i - 1;
            while (j > -1 && a[j] > save) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = save;
        }
    }

    private static pair twoPivotPartition() {
        return twoPivotPartition(a,lf,rt,pivot);
    }

    private static pair twoPivotPartition(int[] a, int lf, int rt, int pivot) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.pivot = pivot;
        int rightPT = rt;
        int leftPT = lf;
        int pivotVal = a[pivot];
        int temp;

        while (leftPT <= rightPT) {
            while (a[leftPT] < pivotVal) {
                leftPT++;
            }
            while (a[rightPT] > pivotVal) {
                rightPT--;
            }

            if (leftPT <= rightPT) {
                temp = a[leftPT];
                a[leftPT] = a[rightPT];
                a[rightPT] = temp;
                rightPT--;
                leftPT++;
            }
        }
        pair output = new pair(rightPT, leftPT);
        return output;
    }

    private static int bookPartition() {
        return bookPartition(a,lf,rt,pivot);
    }

    private static int bookPartition(int[] a, int lf, int rt, int pivot) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.pivot = pivot;
        int pivotVal = a[pivot];
        int temp = a[pivot];
        a[pivot] = a[lf];
        a[lf] = temp;

        int lastSmall = lf;
        int firstUnknown = lf + 1;

        boolean lever = true;

        while (firstUnknown <= rt) {
            if (a[firstUnknown] < pivotVal) {
                temp = a[firstUnknown];
                a[firstUnknown] = a[lastSmall + 1];
                a[lastSmall + 1] = temp;
                firstUnknown++;
                lastSmall++;

                //put firstUnknown into s1
            } else if (a[firstUnknown] > pivotVal) {
                firstUnknown++;
                //put firstUnknown into s2

            } else {
                //if a[fu]==pivot
                if (lever) {
                    temp = a[firstUnknown];
                    a[firstUnknown] = a[lastSmall + 1];
                    a[lastSmall + 1] = temp;
                    lastSmall++;
                    firstUnknown++;
                } else {
                    firstUnknown++;
                }
                if(lever){
                    lever = false;
                }else
                    lever = true;
            }
        }

        temp = a[lf];
        a[lf] = a[lastSmall];
        a[lastSmall] = temp;
        return lastSmall;
    }
    public static void threePartition(){ //overloaded methods with default parameters
        threePartition(a,lf, rt,pivotRight,pivotLeft);
    }
    private static pair threePartition(int[] a, int lf, int rt, int pivotRight, int pivotLeft) {
        ArraySorts.a = a;
        ArraySorts.lf = lf;
        ArraySorts.rt = rt;
        ArraySorts.pivotRight = pivotRight;
        ArraySorts.pivotLeft = pivotLeft;
        int firstUnknown = lf + 1;
        int lastSmall = lf;
        int firstBig = rt;
        int temp = a[lf];
        a[lf] = a[pivotLeft];
        a[pivotLeft] = temp;

        temp = a[rt];
        a[rt] = a[pivotRight];
        a[pivotRight] = temp;

        if (a[lf] > a[rt]) {
            temp = a[rt];
            a[rt] = a[lf];
            a[lf] = temp;
        }

        boolean button = true;

        while (firstUnknown < firstBig) {

            if (a[firstUnknown] > a[rt]) {
                temp = a[firstUnknown];
                a[firstUnknown] = a[firstBig - 1];
                a[firstBig - 1] = temp;
                firstBig--;

            } else if (a[firstUnknown] < a[lf]) {
                temp = a[firstUnknown];
                a[firstUnknown] = a[lastSmall + 1];
                a[lastSmall + 1] = temp;

                lastSmall++;
                firstUnknown++;

            } else if (a[lf] < a[firstUnknown] && a[firstUnknown] < a[rt]) {
                firstUnknown++;

            } else {
                if (button) {
                    if (a[firstUnknown] == a[lf]) {
                        temp = a[firstUnknown];
                        a[firstUnknown] = a[lastSmall + 1];
                        a[lastSmall + 1] = temp;
                        lastSmall++;
                        firstUnknown++;

                    } else if (a[firstUnknown] == a[rt]) {
                        temp = a[firstUnknown];
                        a[firstUnknown] = a[firstBig - 1];
                        a[firstBig - 1] = temp;
                        firstBig--;
                    }

                } else {
                    firstUnknown++;
                }
                if(button){
                    button = false;
                }else
                    button = true;
            }
        }

        temp = a[lf];
        a[lf] = a[lastSmall];
        a[lastSmall] = temp;

        temp = a[rt];
        a[rt] = a[firstBig];
        a[firstBig] = temp;

        pair output = new pair(lastSmall, firstBig);
        return output;
    }

    public static void HeapSortTD(){ //overloaded methods with default parameters
        HeapSortTD(a,n);
    }

    public static void HeapSortTD(int[] a, int n) {
        ArraySorts.a = a;
        ArraySorts.n = n;
        int temp;
        for (int b = 0; b < n; b++) {
            trickleUp(a, 0, b);
        }

        for (int end = n - 1; end > 0; end--) {
            //put max to the end and rebuild heap with -1 size;
            temp = a[end];
            a[end] = a[0];
            a[0] = temp;
            trickleDown(a, 0, end - 1);
        }
    }

    public static void trickleUp(){ //overloaded methods with default parameters
        trickleUp(a,begin, index);
    }
    private static void trickleUp(int[] a, int begin, int index) {
        ArraySorts.a = a;
        ArraySorts.begin = begin;
        ArraySorts.index = index;
        int parent = (index - 1) / 2;
        int temp = a[index];

        if (a[parent] > a[index]) {
            while (index > begin && temp > a[(index - 1) / 2]) {
                a[index] = a[(index - 1) / 2];
                index = (index - 1) / 2;
            }
            a[index] = temp;
        }
    }

    public static void HeapSortBU() { // overloaded method with default parameters
        HeapSortBU(a,n);
    }

    public static void HeapSortBU(int[] a, int n) {
        ArraySorts.a = a; // heapsort with linear buildheap
        ArraySorts.n = n;
        int temp;
        for (int start = (n - 2) / 2; start > -1; start--) {
            //Trickle down the node until every element in the heap is in sorted order.
            trickleDown(a, start, n - 1);
        }

        for (int end = n - 1; end > 0; end--) {
            //put max at the end and rebuild heap with -1 size;
            temp = a[end];
            a[end] = a[0];
            a[0] = temp;
            trickleDown(a, 0, end - 1);
        }
    }

    private static void trickleDown() {//overloaded method with default parameter values
        trickleDown(a,start ,end );
    }
    private static void trickleDown(int[] a, int start, int end) {
        ArraySorts.a = a;
        ArraySorts.start = start;
        ArraySorts.end = end;
        int temporary  = a[start];
        int first = start * 2 + 1;//Left first
        //If right is bigger then point to right first
        if (first + 1 <= end && a[first] < a[first + 1]) {
            first++;
        }
        while ((start * 2 + 1) <= end && a[first] > temporary ) {
            //does while heap is not sorted
            a[start] = a[first];
            start = first;//resetting the children & parents
            first = start * 2 + 1;
            if (first + 1 <= end && a[first] < a[first + 1]) {
                first++;
            }
        }
        a[start] = temporary ;
    }

    public static String myName() {
        return "Aleksandra Trifonova";
    }
}

// use this class so that you can return two pivots in your quicksort5
// partition method

class pair {

    public int left, right;

    public pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}




