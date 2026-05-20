import java.util.Scanner;

public class lesson5 {

    public static void hienThiMang(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sapXepTang(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void sapXepGiam(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int linearSearch(double[] arr, double x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(double[] arr, double x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void thongKe(double[] arr) {
        double tong = 0;
        double max = arr[0];
        double min = arr[0];
        int dem = 0;

        for (int i = 0; i < arr.length; i++) {
            tong += arr[i];

            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        double tb = tong / arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= tb) {
                dem++;
            }
        }

        System.out.println("Điểm trung bình: " + tb);
        System.out.println("Điểm cao nhất: " + max);
        System.out.println("Điểm thấp nhất: " + min);
        System.out.println("Số sinh viên trên trung bình: " + dem);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();

        double[] diem = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
            diem[i] = sc.nextDouble();
        }

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê điểm");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hienThiMang(diem);
                    break;

                case 2:

                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");
                    System.out.print("Chọn kiểu sắp xếp: ");

                    int kieu = sc.nextInt();

                    if (kieu == 1) {
                        sapXepTang(diem);
                    } else if (kieu == 2) {
                        sapXepGiam(diem);
                    }

                    System.out.println("Mảng sau khi sắp xếp:");
                    hienThiMang(diem);

                    break;

                case 3:

                    System.out.print("Nhập điểm cần tìm: ");
                    double x = sc.nextDouble();

                    int vt1 = linearSearch(diem, x);

                    if (vt1 != -1) {
                        System.out.println("Linear Search tìm thấy tại vị trí: " + vt1);
                    } else {
                        System.out.println("Linear Search không tìm thấy");
                    }

                    int vt2 = binarySearch(diem, x);

                    if (vt2 != -1) {
                        System.out.println("Binary Search tìm thấy tại vị trí: " + vt2);
                    } else {
                        System.out.println("Binary Search không tìm thấy");
                    }

                    break;

                case 4:
                    thongKe(diem);
                    break;

                case 0:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (choice != 0);

        sc.close();
    }
}

