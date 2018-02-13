package foo.projetglpoo.api.mashape;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONObject;

import foo.projetglpoo.api.EuroMillionsAPI;
import foo.projetglpoo.api.EuroMillionsResult;
import foo.projetglpoo.api.SimpleEuroMillionsResult;

public class MashableAPI implements EuroMillionsAPI {
	private final String apiKey;

	public MashableAPI(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public EuroMillionsResult getLastResult() {
		String jsonString;

		try {
			HttpResponse<String> response = Unirest.get("https://euromillions.p.mashape.com/ResultsService/FindLast")
					.header("X-Mashape-Key", apiKey).header("Accept", "text/plain").asString();
			if (response.getStatus() != 200)
				return null;
			jsonString = response.getBody().toString();
		} catch (UnirestException e) {
			return null;
		}

		JSONObject result = new JSONObject(jsonString);

		final int jackpot = result.getInt("Jackpot");
		final int nextJackpot = result.getInt("NextJackpot");

		final int[] numbers = new int[5];
		numbers[0] = result.getInt("Num1");
		numbers[1] = result.getInt("Num2");
		numbers[2] = result.getInt("Num3");
		numbers[3] = result.getInt("Num4");
		numbers[4] = result.getInt("Num5");

		final int[] stars = new int[2];
		stars[0] = result.getInt("Star1");
		stars[1] = result.getInt("Star2");

		return new SimpleEuroMillionsResult(jackpot, nextJackpot, numbers, stars);
	}
}