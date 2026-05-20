import java.util.Scanner;

public class lesson3 {

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {

                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        System.out.println("Mảng sau khi sắp xếp giảm dần:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\nNhập số cần tìm: ");
        int x = sc.nextInt();

        int linearResult = linearSearch(arr, x);

        int binaryResult = binarySearch(arr, x);

        if (linearResult != -1) {
            System.out.println("Tìm kiếm tuyến tính: Tìm thấy tại vị trí " + linearResult);
        } else {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy");
        }

        if (binaryResult != -1) {
            System.out.println("Tìm kiếm nhị phân: Tìm thấy tại vị trí " + binaryResult);
        } else {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy");
        }

        sc.close();
    }
}

