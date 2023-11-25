// NewsRepository.java
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class NewsRepository {
    private ApiService apiService;

    public NewsRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public LiveData<List<NewsArticle>> getNews() {
        MutableLiveData<List<NewsArticle>> data = new MutableLiveData<>();

        apiService.getNews().enqueue(new Callback<List<NewsArticle>>() {
            @Override
            public void onResponse(Call<List<NewsArticle>> call, Response<List<NewsArticle>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<NewsArticle>> call, Throwable t) {
                // Handle failure
            }
        });

        return data;
    }
}
