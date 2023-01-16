package by.itstep.organizaer.repository;

import by.itstep.organizaer.model.entity.Friend;
import by.itstep.organizaer.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

    Optional<Friend> findByUuidAndUser(final UUID uuid, final User user);

    @Query("select f from Friend f where f.uuid is null")
    List<Friend> findFriendUuidIsNull();

}
