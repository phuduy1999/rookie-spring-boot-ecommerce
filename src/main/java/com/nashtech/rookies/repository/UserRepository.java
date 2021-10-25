package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Rate;
import com.nashtech.rookies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
