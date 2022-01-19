package repository;

import com.ebff.challenge.spaceflightnews.model.Articles;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticlesRepository extends MongoRepository<Articles, Long> {
}
