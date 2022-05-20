package br.com.mdo.gooffice.domain.repository;

import br.com.mdo.gooffice.domain.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Locacao, Long> {

/*    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Allocation a SET a.subject = :subject, a.startAt = :startAt, a.endAt = :endAt WHERE a.id = :allocationId")
    void updateAllocation(
            @Param("allocationId") Long allocationId,
            @Param("subject") String subject,
            @Param("startAt") OffsetDateTime startAt,
            @Param("endAt") OffsetDateTime endAt);

    @Query(
            "SELECT a FROM Allocation a WHERE " +
            "(:employeeEmail IS NULL OR a.employee.email = :employeeEmail) AND " +
            "(:roomId IS NULL OR a.room.id = :roomId) AND " +
            "(:starAt IS NULL OR a.startAt >= :starAt) AND " +
            "(:endAt IS NULL OR a.endAt <= :endAt)"
    )
    Page<Allocation> findAllWithFilters(
            @Param("employeeEmail")String employeeEmail,
            @Param("roomId") Long roomId,
            @Param("starAt") OffsetDateTime startAt,
            @Param("endAt") OffsetDateTime endAt,
            Pageable pageable);

    @Query(
            "SELECT a FROM Allocation a WHERE " +
                    "(:employeeEmail IS NULL OR a.employee.email = :employeeEmail) AND " +
                    "(:roomId IS NULL OR a.room.id = :roomId) AND " +
                    "(:starAt IS NULL OR a.startAt >= :starAt) AND " +
                    "(:endAt IS NULL OR a.endAt <= :endAt)"
    )
    List<Allocation> findAllWithFilters(
            @Param("employeeEmail")String employeeEmail,
            @Param("roomId") Long roomId,
            @Param("starAt") OffsetDateTime startAt,
            @Param("endAt") OffsetDateTime endAt);*/

}
