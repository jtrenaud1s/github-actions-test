package me.jtrenaud1s.githubactionstest.domain.repository;

import me.jtrenaud1s.githubactionstest.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
