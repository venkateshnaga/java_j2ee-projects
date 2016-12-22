import java.util.Scanner;

public class Test {

	int m1, m2, m3, currency;

	public void blockconversion(double grams) {
		if (grams > 2 && grams <= 1000000000) {
			m1 = (int) (grams / 2);
			m2 = (int) (grams / 3);
			m3 = (int) (grams / 4);
			currencyconversion();
		} else if (grams == 2) {
			lessconversion(grams);
		} else {
			System.out.println("Exchange Limit is Between 2 to 1000000000 Grams Only:Please Enter Proper Input");
		}
	}

	public void currencyconversion() {
		currency = m1 + m2 + m3;
		System.out.println("You Get " + currency + " Units Of Currency");
	}

	public void lessconversion(double grams) {
		int z = (int) grams;
		System.out.println("You Get " + z + " Units Of Currency");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Test t = new Test();
		System.out.println("Enter How Much Grams Of Block To Exchange");
		double grams = scanner.nextDouble();
		t.blockconversion(grams);
		scanner.close();

	}
}