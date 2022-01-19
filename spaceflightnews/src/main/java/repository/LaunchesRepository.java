package repository;

import com.ebff.challenge.spaceflightnews.model.Launches;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaunchesRepository extends MongoRepository<Launches, Long> {
}
