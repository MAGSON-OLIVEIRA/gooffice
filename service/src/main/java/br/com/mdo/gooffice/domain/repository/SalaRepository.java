package br.com.mdo.gooffice.domain.repository;

import br.com.mdo.gooffice.domain.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    Optional<Sala> findByIdAndAtivo(Long id, Boolean ativo);

    Optional<Sala> findByNomeAndAtivo(String nome, Boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Sala r SET r.ativo = false WHERE r.id = :salaId")
    void desativar(@Param("roomId") Long salaId);

/*    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Room r SET r.name = :name, r.seats = :seats WHERE r.id = :roomId")
    void atualizarSala(@Param("name") String name, @Param("seats") Integer seats, @Param("roomId") Long roomId);*/
}
