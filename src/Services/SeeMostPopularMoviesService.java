package Services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import API.ThemoviedbApiAccess;

/**
 * The class <code>SeeMostPopularMoviesService</code> is a service called by the
 * servlet to display all the most popular Movies
 * 
 * TODO: some extensions
 * 
 * 
 * <p>
 * Created on : October 19, 2017
 * </p>
 * 
 * @version $Name$ -- $Revision$ -- $Date$
 */

public class SeeMostPopularMoviesService {

	public JSONObject GetMostPopularMovies() throws Exception {
		StringBuffer response = ThemoviedbApiAccess.GetResponseFromAPI(ThemoviedbApiAccess.MOST_POPULAR_FILMS);

		JSONObject json_most_popular_movies = null;
		try {
			JSONObject j = new JSONObject(response.toString());
			if (j.getJSONArray("results").length() > 0) {
				JSONArray popular_movies = j.getJSONArray("results");

				json_most_popular_movies = new JSONObject();
				json_most_popular_movies.put("popular_movies", popular_movies);
				json_most_popular_movies.put("message", 1);
				return json_most_popular_movies;
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json_most_popular_movies;

	}

}
