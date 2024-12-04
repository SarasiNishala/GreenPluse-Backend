package lk.ijse.gdse68.greenplusebackend.dao;

import lk.ijse.gdse68.greenplusebackend.entity.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDAO extends JpaRepository<FieldEntity, String> {
}
