package com.itsmerishab08.salonuserservice.repository;

import com.itsmerishab08.salonuserservice.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByIdAndDeletedAtNull(String id);
    List<UserEntity> findAllByDeletedAtNull(Pageable pageable);

}
