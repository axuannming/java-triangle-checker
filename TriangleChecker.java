import java.util.Scanner;

public class TriangleChecker {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Ask again only when the input is not exactly three positive integers.
		while (true) {
			System.out.println("Enter exactly three positive integers on one line:");
			if (!input.hasNextLine()) {
				System.out.println("No more input is available.");
				return;
			}

			// Read one completed line, so two values can be rejected after Enter.
			Scanner values = new Scanner(input.nextLine());

			// hasNextInt() checks a value; nextInt() then reads that value.
			if (!values.hasNextInt()) {
				if (!values.hasNext()) {
					System.out.println("Please enter exactly three integers on one line.");
				} else if (values.hasNextDouble()) {
					System.out.println("Decimals or out-of-range numbers are not allowed.");
				} else {
					System.out.println("Only integers are allowed. Please try again.");
				}
				continue;
			}
			int a = values.nextInt();

			if (!values.hasNextInt()) {
				if (!values.hasNext()) {
					System.out.println("Please enter exactly three integers on one line.");
				} else if (values.hasNextDouble()) {
					System.out.println("Decimals or out-of-range numbers are not allowed.");
				} else {
					System.out.println("Only integers are allowed. Please try again.");
				}
				continue;
			}
			int b = values.nextInt();

			if (!values.hasNextInt()) {
				if (!values.hasNext()) {
					System.out.println("Please enter exactly three integers on one line.");
				} else if (values.hasNextDouble()) {
					System.out.println("Decimals or out-of-range numbers are not allowed.");
				} else {
					System.out.println("Only integers are allowed. Please try again.");
				}
				continue;
			}
			int c = values.nextInt();

			// Any remaining value means that the user entered more than three.
			if (values.hasNext()) {
				System.out.println("Please enter exactly three integers on one line.");
				continue;
			}

			if (a < 0 || b < 0 || c < 0) {
				System.out.println("Negative numbers are not allowed. Enter positive integers.");
				continue;
			}
			if (a == 0 || b == 0 || c == 0) {
				System.out.println("Zero is not a positive integer. Enter numbers greater than zero.");
				continue;
			}

			// These are three valid integers, but they may not make a triangle.
			if (a + b <= c || a + c <= b || b + c <= a) {
				System.out.println("Cannot form a triangle");
				return;
			}

			// Check right triangles before isosceles and scalene triangles.
			if (a == b && b == c) {
				System.out.println("Equilateral triangle");
			} else if (a * a + b * b == c * c ||
					a * a + c * c == b * b ||
					b * b + c * c == a * a) {
				System.out.println("Right angled triangle");
			} else if (a == b || b == c || a == c) {
				System.out.println("Isosceles triangle");
			} else {
				System.out.println("Scalene triangle");
			}
			return; // A result has been printed.
		}
	}
}
