package com.training.leave.app.dao;

import com.training.leave.app.entity.LeavesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavesRepo extends CrudRepository<LeavesEntity, Long> {
//    LeavesEntity save(LeavesEntity shoe);
}
