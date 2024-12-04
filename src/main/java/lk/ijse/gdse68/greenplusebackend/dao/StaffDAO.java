package lk.ijse.gdse68.greenplusebackend.dao;

import lk.ijse.gdse68.greenplusebackend.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDAO extends JpaRepository<StaffEntity, String> {
}
