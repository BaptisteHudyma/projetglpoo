package foo.projetglpoo.api;

public class SimpleEuroMillionsResult implements EuroMillionsResult {
	private final int jackpot;
	private final int nextJackpot;
	private final int[] numbers;
	private final int[] stars;

	public SimpleEuroMillionsResult(int jackpot, int nextJackpot, int[] numbers, int[] stars) {
		if (numbers.length != 5) {
			throw new IllegalArgumentException("numbers must have 5 fields");
		}

		if (stars.length != 2) {
			throw new IllegalArgumentException("stars must have 2 fields");
		}

		this.jackpot = jackpot;
		this.nextJackpot = nextJackpot;
		this.numbers = numbers;
		this.stars = stars;
	}

	@Override
	public int getJackpot() {
		return jackpot;
	}

	@Override
	public int getNextJackpot() {
		return nextJackpot;
	}

	@Override
	public int[] getNumbers() {
		return numbers;
	}

	@Override
	public int[] getStars() {
		return stars;
	}
}
