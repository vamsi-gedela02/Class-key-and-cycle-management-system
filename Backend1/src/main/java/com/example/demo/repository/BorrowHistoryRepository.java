package com.example.demo.repository;

import com.example.demo.model.BorrowHistory;
import com.example.demo.model.ClassroomKey;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory, Long> {

    // Fetch all key borrow history (where bicycle is null)
    List<BorrowHistory> findByBicycleIsNull();

    // Fetch currently borrowed keys (not returned)
    List<BorrowHistory> findByBicycleIsNullAndReturnTimeIsNull();

    // Fetch all bicycle borrow history (where bicycle is not null)
    List<BorrowHistory> findByBicycleIsNotNull();

    // Fetch currently borrowed bicycles (not returned)
    List<BorrowHistory> findByBicycleIsNotNullAndReturnTimeIsNull();
    
    List<BorrowHistory> findByStudentId(Long studentId);
    
 // Find if a student already has this key and has not returned it
    Optional<BorrowHistory> findByStudentAndClassroomKeyAndIsReturned(User student, ClassroomKey classroomKey, boolean isReturned);

    // Find if the key is currently borrowed by anyone
    Optional<BorrowHistory> findByClassroomKeyAndIsReturned(ClassroomKey classroomKey, boolean isReturned);
    
    List<BorrowHistory> findByStudentIdAndIsReturnedFalse(Long studentId);
}

