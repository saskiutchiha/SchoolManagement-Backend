package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.dto.EvaluationStatisticsDTO;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SModuleRepository extends JpaRepository<SModule, Long> {
    List<SModule> findByProf_Code(Long profCode);

    List<SModule> getAllByModule_Code(Long moduleCode);
    List<SModule> findByModuleCode(Long moduleId);
    List<SModule> getByCode(Long code);
    @Query("SELECT sm FROM SModule sm WHERE sm.prof IS NULL")
    List<SModule> smoduleDispo();

    @Query("SELECT sm FROM SModule sm WHERE sm.prof IS NOT NULL")
    List<SModule> smoduleAffected();

    @Modifying
    @Transactional
    @Query("UPDATE SModule sm SET sm.prof = NULL WHERE sm = :smodule")
    void deleteProfAffectation(SModule smodule);
    @Query(value = """

            SELECT
            me.nom AS type,
            ROUND(AVG(n.note), 2) AS average,
            ROUND(STDDEV(n.note), 2) AS standardDeviation,
            MIN(n.note) AS minGrade,
            MAX(n.note) AS maxGrade,
            ROUND(100.0 * em.coef / SUM(em.coef) OVER (PARTITION BY sm.code), 2) AS weight,
            ROUND(100.0 * SUM(CASE WHEN n.note > 12 THEN 1 ELSE 0 END) / COUNT(n.note), 2) AS percentageAbove12
        FROM s_modules sm
        JOIN elem_mevaluations em ON em.s_module_id = sm.code
        JOIN m_evaluations me ON me.id = em.m_evaluation_id
        JOIN notes n ON n.s_module_id = sm.code AND n.m_eval_id = me.id
        WHERE sm.code = :codeModule
        GROUP BY sm.code, me.nom, em.coef
        """, nativeQuery = true)
    List<Object[]> getEvaluationStatisticsByModuleCode(@Param("codeModule") Long codeModule);
    @Query(value = """
          SELECT 
            me.nom AS type,
         SUM(CASE WHEN n.note BETWEEN 10 AND 11 THEN 1 ELSE 0 END) AS "10-11",
         SUM(CASE WHEN n.note BETWEEN 11 AND 12 THEN 1 ELSE 0 END) AS "11-12",
         SUM(CASE WHEN n.note BETWEEN 12 AND 13 THEN 1 ELSE 0 END) AS "12-13",
         SUM(CASE WHEN n.note BETWEEN 13 AND 14 THEN 1 ELSE 0 END) AS "13-14",
          SUM(CASE WHEN n.note BETWEEN 14 AND 15 THEN 1 ELSE 0 END) AS "14-15",
          SUM(CASE WHEN n.note BETWEEN 15 AND 16 THEN 1 ELSE 0 END) AS "15-16",
          SUM(CASE WHEN n.note BETWEEN 16 AND 17 THEN 1 ELSE 0 END) AS "16-17",
          SUM(CASE WHEN n.note BETWEEN 17 AND 18 THEN 1 ELSE 0 END) AS "17-18",
          SUM(CASE WHEN n.note BETWEEN 18 AND 19 THEN 1 ELSE 0 END) AS "18-19",
          SUM(CASE WHEN n.note BETWEEN 19 AND 20 THEN 1 ELSE 0 END) AS "19-20"
        FROM s_modules sm
        JOIN elem_mevaluations em ON em.s_module_id = sm.code
        JOIN m_evaluations me ON me.id = em.m_evaluation_id
        JOIN notes n ON n.s_module_id = sm.code AND n.m_eval_id = me.id
        WHERE sm.code = :codeModule
        GROUP BY sm.code, me.nom
        """, nativeQuery = true)
    List<EvaluationStatisticsDTO> getEvaluationStatisticsByintervales(@Param("codeModule") Long codeModule);
}
