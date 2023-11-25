// NewsViewModel.java
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class NewsViewModel extends ViewModel {
    private NewsRepository newsRepository;
    private LiveData<List<NewsArticle>> news;

    public NewsViewModel() {
        newsRepository = new NewsRepository(/* Inject your ApiService here */);
        news = newsRepository.getNews();
    }

    public LiveData<List<NewsArticle>> getNews() {
        return news;
    }
}
