package repository;

import com.ebff.challenge.spaceflightnews.model.Events;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventsRepository extends MongoRepository<Events, Long> {
}
