// ApiService.java
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("your_news_endpoint")
    Call<List<NewsArticle>> getNews();
}
