package com.naver.hackday.trendapi.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;

        import com.naver.hackday.trendapi.model.Test;

/**
 * @author SaeHan Kim
 * @since 2018-11-14
 */
@RepositoryRestResource(path = "test", collectionResourceRel = "test")
public interface TestRepository extends JpaRepository<Test, String> {
}
