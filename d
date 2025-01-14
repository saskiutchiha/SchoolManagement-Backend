[1mdiff --git a/src/main/java/org/ensa/schoolmanagementbackend/dao/repository/SModuleRepository.java b/src/main/java/org/ensa/schoolmanagementbackend/dao/repository/SModuleRepository.java[m
[1mdeleted file mode 100644[m
[1mindex 6c67f7e..0000000[m
[1m--- a/src/main/java/org/ensa/schoolmanagementbackend/dao/repository/SModuleRepository.java[m
[1m+++ /dev/null[m
[36m@@ -1,68 +0,0 @@[m
[31m-package org.ensa.schoolmanagementbackend.dao.repository;[m
[31m-[m
[31m-import org.ensa.schoolmanagementbackend.dao.dto.EvaluationStatisticsDTO;[m
[31m-import org.ensa.schoolmanagementbackend.dao.entity.SModule;[m
[31m-import org.springframework.data.jpa.repository.JpaRepository;[m
[31m-import org.springframework.data.jpa.repository.Modifying;[m
[31m-import org.springframework.data.jpa.repository.Query;[m
[31m-import org.springframework.data.repository.query.Param;[m
[31m-import org.springframework.transaction.annotation.Transactional;[m
[31m-[m
[31m-import java.util.List;[m
[31m-[m
[31m-public interface SModuleRepository extends JpaRepository<SModule, Long> {[m
[31m-    List<SModule> findByProf_Code(Long profCode);[m
[31m-[m
[31m-    List<SModule> getAllByModule_Code(Long moduleCode);[m
[31m-    List<SModule> findByModuleCode(Long moduleId);[m
[31m-    List<SModule> getByCode(Long code);[m
[31m-    @Query("SELECT sm FROM SModule sm WHERE sm.prof IS NULL")[m
[31m-    List<SModule> smoduleDispo();[m
[31m-[m
[31m-    @Query("SELECT sm FROM SModule sm WHERE sm.prof IS NOT NULL")[m
[31m-    List<SModule> smoduleAffected();[m
[31m-[m
[31m-    @Modifying[m
[31m-    @Transactional[m
[31m-    @Query("UPDATE SModule sm SET sm.prof = NULL WHERE sm = :smodule")[m
[31m-    void deleteProfAffectation(SModule smodule);[m
[31m-    @Query(value = """[m
[31m-[m
[31m-            SELECT[m
[31m-            me.nom AS type,[m
[31m-            ROUND(AVG(n.note), 2) AS average,[m
[31m-            ROUND(STDDEV(n.note), 2) AS standardDeviation,[m
[31m-            MIN(n.note) AS minGrade,[m
[31m-            MAX(n.note) AS maxGrade,[m
[31m-            ROUND(100.0 * em.coef / SUM(em.coef) OVER (PARTITION BY sm.code), 2) AS weight,[m
[31m-            ROUND(100.0 * SUM(CASE WHEN n.note > 12 THEN 1 ELSE 0 END) / COUNT(n.note), 2) AS percentageAbove12[m
[31m-        FROM s_modules sm[m
[31m-        JOIN elem_mevaluations em ON em.s_module_id = sm.code[m
[31m-        JOIN m_evaluations me ON me.id = em.m_evaluation_id[m
[31m-        JOIN notes n ON n.s_module_id = sm.code AND n.m_eval_id = me.id[m
[31m-        WHERE sm.code = :codeModule[m
[31m-        GROUP BY sm.code, me.nom, em.coef[m
[31m-        """, nativeQuery = true)[m
[31m-    List<Object[]> getEvaluationStatisticsByModuleCode(@Param("codeModule") Long codeModule);[m
[31m-    @Query(value = """[m
[31m-          SELECT [m
[31m-            me.nom AS type,[m
[31m-         SUM(CASE WHEN n.note BETWEEN 10 AND 11 THEN 1 ELSE 0 END) AS "10-11",[m
[31m-         SUM(CASE WHEN n.note BETWEEN 11 AND 12 THEN 1 ELSE 0 END) AS "11-12",[m
[31m-         SUM(CASE WHEN n.note BETWEEN 12 AND 13 THEN 1 ELSE 0 END) AS "12-13",[m
[31m-         SUM(CASE WHEN n.note BETWEEN 13 AND 14 THEN 1 ELSE 0 END) AS "13-14",[m
[31m-          SUM(CASE WHEN n.note BETWEEN 14 AND 15 THEN 1 ELSE 0 END) AS "14-15",[m
[31m-          SUM(CASE WHEN n.note BETWEEN 15 AND 16 THEN 1 ELSE 0 END) AS "15-16",[m
[31m-          SUM(CASE WHEN n.note BETWEEN 16 AND 17 THEN 1 ELSE 0 END) AS "16-17",[m
[31m-          SUM(CASE WHEN n.note BETWEEN 17 AND 18 THEN 1 ELSE 0 END) AS "17-18",[m
[31m-          SUM(CASE WHEN n.note BETWEEN 18 AND 19 THEN 1 ELSE 0 END) AS "18-19",[m
[31m-          SUM(CASE WHEN n.note BETWEEN 19 AND 20 THEN 1 ELSE 0 END) AS "19-20"[m
[31m-        FROM s_modules sm[m
[31m-        JOIN elem_mevaluations em ON em.s_module_id = sm.code[m
[31m-        JOIN m_evaluations me ON me.id = em.m_evaluation_id[m
[31m-        JOIN notes n ON n.s_module_id = sm.code AND n.m_eval_id = me.id[m
[31m-        WHERE sm.code = :codeModule[m
[31m-        GROUP BY sm.code, me.nom[m
[31m-        """, nativeQuery = true)[m
[31m-    List<EvaluationStatisticsDTO> getEvaluationStatisticsByintervales(@Param("codeModule") Long codeModule);[m
[31m-}[m
