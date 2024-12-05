package lk.ijse.gdse68.greenplusebackend.dao;

import lk.ijse.gdse68.greenplusebackend.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StaffDAO extends JpaRepository<StaffEntity, String> {
    // Custom query to fetch the last staff ID by role
    @Query("SELECT s.staffId FROM StaffEntity s WHERE s.role = :role ORDER BY s.staffId DESC LIMIT 1")
    String getLastStaffIdByRole(@Param("role") String role);
}
