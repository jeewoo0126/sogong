package practice_lab1;

public class Book {

	public class Calculator {
		// 더하기 함수
		public int add(int a, int b) {
			return a + b;
		}
		// 빼기 함수
		public int subtract(int a, int b) {
			return a - b;
		}
		// 곱하기 함수
		public int multiply(int a, int b) {
			return a * b;
		}
		// 나누기 함수
		public int divide(int a, int b) {
			if (b == 0) {
				throw new IllegalArgumentException("Divisor cannot be zero");
			}
			return a / b;
		}
	}
}
