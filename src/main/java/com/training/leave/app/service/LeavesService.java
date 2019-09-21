package com.training.leave.app.service;

import com.training.leave.app.dao.EmployeeRepo;
import com.training.leave.app.dao.LeavesRepo;
import com.training.leave.app.entity.EmployeeEntity;
import com.training.leave.app.entity.LeavesEntity;
import com.training.leave.app.model.Leaves;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LeavesService {

    @Autowired
    private LeavesRepo repo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public boolean saveLeave(long empId, Leaves leaves) throws Exception {
        try {
            Optional<EmployeeEntity> optionalEmployeeEntity =  employeeRepo.findById(empId);
            EmployeeEntity employeeEntity =  optionalEmployeeEntity.get();
            LeavesEntity leavesEntity = new LeavesEntity();
            BeanUtils.copyProperties(leaves, leavesEntity);
            leavesEntity.setEmployee(employeeEntity);
            repo.save(leavesEntity);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean updateLeave(long  leaveId,String leaveStatus) throws  Exception{
        try{
            Optional<LeavesEntity> optionalLeavesEntity =  repo.findById(leaveId);
            LeavesEntity leavesEntity =  optionalLeavesEntity.get();
            leavesEntity.setLeaveStatus(leaveStatus);
            repo.save(leavesEntity);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();;
            throw ex;
        }
    }

    public boolean saveLeave(Leaves leaves) throws Exception {
        try {
            LeavesEntity leavesEntity = new LeavesEntity();
            BeanUtils.copyProperties(leaves, leavesEntity);
            repo.save(leavesEntity);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
